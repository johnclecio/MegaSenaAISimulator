package com.testemegasena.demo.service;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EstatisticaService {

    public Map<Integer, Double> calcularProbabilidade(Map<Integer, Integer> ranking) {
        Map<Integer, Double> prob = new HashMap<>();
        double total = 0;
        for (int valor : ranking.values()) total += valor;
        for (Map.Entry<Integer, Integer> entry : ranking.entrySet()) {
            double p = (entry.getValue() / total) * 100.0;
            prob.put(entry.getKey(), p);
        }
        return prob;
    }

    public List<Integer> topQuentes(Map<Integer, Integer> ranking, int n) {
        List<Map.Entry<Integer, Integer>> lista = new ArrayList<>(ranking.entrySet());
        lista.sort(Comparator.comparing(Map.Entry<Integer, Integer>::getValue).reversed());
        List<Integer> quentes = new ArrayList<>();
        for (int i = 0; i < n; i++) quentes.add(lista.get(i).getKey());
        return quentes;
    }

    public List<Integer> topFrios(Map<Integer, Integer> ranking, int n) {
        List<Map.Entry<Integer, Integer>> lista = new ArrayList<>(ranking.entrySet());
        lista.sort(Comparator.comparing(Map.Entry<Integer, Integer>::getValue));
        List<Integer> frios = new ArrayList<>();
        for (int i = 0; i < n; i++) frios.add(lista.get(i).getKey());
        return frios;
    }

    public int calcularScore(List<Integer> jogo, Map<Integer, Integer> ranking) {
        int score = 0;
        for (int num : jogo) score += ranking.get(num);
        return score;
    }
}