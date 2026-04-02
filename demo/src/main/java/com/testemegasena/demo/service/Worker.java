package com.testemegasena.demo.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class Worker extends Thread {

    private final int simulacoes;
    private final Map<Integer, Integer> ranking;

    public Worker(@Value("${worker.simulacoes}") int simulacoes) {
        this.simulacoes = simulacoes;
        this.ranking = new HashMap<>();

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

    private List<Integer> gerarJogo() {
        Set<Integer> jogo = new HashSet<>();
        while (jogo.size() < 6) {
            int num = ThreadLocalRandom.current().nextInt(1, 61);
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