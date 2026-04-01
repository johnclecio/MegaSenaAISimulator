package com.Mega_Sena.demo.service;

import java.util.*;

public class EstatisticaService {

    public Map<Integer, Double> calcularProbabilidade(Map<Integer, Integer> ranking) {

        Map<Integer, Double> prob = new HashMap<>();

        double total = 0;

        for (int valor : ranking.values()) {
            total += valor;
        }

        for (Map.Entry<Integer, Integer> entry : ranking.entrySet()) {
            double p = (entry.getValue() / total) * 100.0;
            prob.put(entry.getKey(), p);
        }

        return prob;
    }

    public List<Integer> topQuentes(Map<Integer, Integer> ranking, int n) {
        List<Map.Entry<Integer, Integer>> lista = new ArrayList<>(ranking.entrySet());

        lista.sort((a, b) -> b.getValue() - a.getValue());

        List<Integer> quentes = new ArrayList<>();

        int i = 0;
        while (i < n) {
            quentes.add(lista.get(i).getKey());
            i++;

        }

        return quentes;
    }

    public List<Integer> topFrios(Map<Integer, Integer> ranking, int n) {
        List<Map.Entry<Integer, Integer>> lista = new ArrayList<>(ranking.entrySet());

        lista.sort((a, b) -> a.getValue() - b.getValue());

        List<Integer> frios = new ArrayList<>();

        int i = 0;
        while (i < n) {
            frios.add(lista.get(i).getKey());
            i++;
        }

        return frios;
    }

    public int calcularScore(List<Integer> jogo, Map<Integer, Integer> ranking) {

        int score = 0;

        int i = 0;
        while (i < jogo.size()) {
            score += ranking.get(jogo.get(i));
            i++;
        }

        return score;
    }
}
