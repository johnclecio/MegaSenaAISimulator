package com.Mega_Sena.demo.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Simulador {

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
            } catch (Exception e) {
                e.printStackTrace();
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
}
