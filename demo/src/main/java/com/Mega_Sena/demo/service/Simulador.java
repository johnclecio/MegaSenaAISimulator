package com.Mega_Sena.demo.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Simulador {

    private Map<Integer, Integer> cache;
    private long lastUpdate = 0;

    public Map<Integer, Integer> executar(int threads, int simulacoesPorThread) {

        List<Worker> workers = new ArrayList<>();

        int i = 0;
        while (i < threads) {
            Worker w = new Worker(simulacoesPorThread);
            workers.add(w);
            w.start();
            i++;
        }

        for (Worker w : workers) {
            try {
                w.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Erro ao aguardar thread: " + e.getMessage());
            }
        }

        Map<Integer, Integer> rankingGlobal = new HashMap<>();

        int n = 1;
        while (n <= 60) {
            rankingGlobal.put(n, 0);
            n++;
        }

        for (Worker w : workers) {
            Map<Integer, Integer> local = w.getRanking();

            for (Map.Entry<Integer, Integer> entry : local.entrySet()) {
                rankingGlobal.merge(entry.getKey(), entry.getValue(), Integer::sum);
            }
        }

        return rankingGlobal;
    }

  
        public Map<Integer, Integer> executarComCache(int threads, int simulacoesPorThread) {

            long agora = System.currentTimeMillis();

            // atualiza a cada 10 segundos
            if (cache == null || (agora - lastUpdate) > 10000) {

                cache = executar(threads, simulacoesPorThread);
                lastUpdate = agora;

                System.out.println("🔥 Simulação atualizada");
            } else {
                System.out.println("⚡ Usando cache");
            }

            return cache;
        }
    }


