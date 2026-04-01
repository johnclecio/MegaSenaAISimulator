package com.Mega_Sena.demo.service;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Worker extends Thread {

    private int simulacoes;
    private Map<Integer, Integer> ranking;

    public Worker(int simulacoes) {
        this.simulacoes = simulacoes;
        this.ranking = new HashMap<>();

        // inicializa ranking
        int i = 1;
        while (i <= 60) {
            ranking.put(i, 0);
            i++;
        }
    }

    @Override
    public void run() {

        int i = 0;

        while (i < simulacoes) {

            List<Integer> jogo = gerarJogo();

            int j = 0;
            while (j < jogo.size()) {
                int num = jogo.get(j);

                ranking.put(num, ranking.get(num) + 1);

                j++;
            }

            i++;
        }
    }

    // 🎲 geração do jogo
    private List<Integer> gerarJogo() {

        Set<Integer> jogo = new HashSet<>();

        while (jogo.size() < 6) {

            int num = ThreadLocalRandom.current().nextInt(1, 61);

            // regra do seu sistema
            if (num % 2 == 0 || num > 30) {
                jogo.add(num);
            }
        }

        List<Integer> lista = new ArrayList<>(jogo);
        Collections.sort(lista);

        return lista;
    }

    public Map<Integer, Integer> getRanking() {
        return ranking;
    }
}