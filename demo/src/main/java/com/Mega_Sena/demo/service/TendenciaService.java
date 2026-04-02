package com.Mega_Sena.demo.service;

import java.util.*;

public class TendenciaService {

    // 🔹 calcula diferença entre atual e histórico
    public Map<Integer, Integer> calcularTendencia(
            Map<Integer, Integer> atual,
            Map<Integer, Integer> historico) {

        Map<Integer, Integer> tendencia = new HashMap<>();

        int i = 1;

        while (i <= 60) {
            int valorAtual = atual.get(i);
            int valorHistorico = historico.get(i);

            int diff = valorAtual - valorHistorico;

            tendencia.put(i, diff);

            i++;
        }

        return tendencia;
    }

    // 🔥 HI → números que estão SUBINDO
    public List<Integer> topHI(Map<Integer, Integer> tendencia, int n) {

        List<Map.Entry<Integer, Integer>> lista =
                new ArrayList<>(tendencia.entrySet());

        // ordena do maior pro menor (mais positivo primeiro)
        lista.sort((a, b) -> b.getValue() - a.getValue());

        List<Integer> hi = new ArrayList<>();

        int i = 0;

        while (i < n) {
            hi.add(lista.get(i).getKey());
            i++;
        }

        return hi;
    }

    // ❄️ LOW → números que estão CAINDO
    public List<Integer> topLOW(Map<Integer, Integer> tendencia, int n) {

        List<Map.Entry<Integer, Integer>> lista =
                new ArrayList<>(tendencia.entrySet());

        // ordena do menor pro maior (mais negativo primeiro)
        lista.sort((a, b) ->
                Integer.compare(a.getValue(), b.getValue()));

        List<Integer> low = new ArrayList<>();

        int limite = Math.min(n, lista.size());

        int i = 0;
        while (i < limite) {
            low.add(lista.get(i).getKey());
            i++;
        }

        return low;
    }
}