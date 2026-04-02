package com.Mega_Sena.demo.service;

// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class AnaliseService {
    public AnaliseService() {
    }

    public Map<Integer, Integer> gerarRankingHistorico() {

        Map<Integer, Integer> ranking = new HashMap<>();

        int i = 1;
        while (i <= 60) {
            ranking.put(i, 0);
            i++;
        }

        try {

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            getClass().getClassLoader().getResourceAsStream("historico.csv")
                    )
            );

            String linha;

            while ((linha = reader.readLine()) != null) {

                String[] partes = linha.split(",");

                if (partes.length >= 2) {

                    String[] numeros = partes[1].split("-");

                    int j = 0;
                    while (j < numeros.length) {

                        int num = Integer.parseInt(numeros[j]);

                        ranking.put(num, ranking.get(num) + 1);

                        j++;
                    }
                }
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ranking;
    }
}

