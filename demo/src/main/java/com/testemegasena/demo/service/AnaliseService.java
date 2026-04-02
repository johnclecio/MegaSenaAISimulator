package com.testemegasena.demo.service;

import org.springframework.stereotype.Service;
import java.io.*;
import java.util.*;

@Service
public class AnaliseService {

    public Map<Integer, Integer> gerarRankingHistorico() {

        Map<Integer, Integer> ranking = new HashMap<>();

        int i = 1;
        while (i <= 60) {
            ranking.put(i, 0);
            i++;
        }

        try {

            InputStream input = getClass()
                    .getClassLoader()
                    .getResourceAsStream("historico.csv");

            if (input == null) {
                throw new RuntimeException("Arquivo historico.csv não encontrado");
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

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
            throw new RuntimeException("Erro ao processar histórico", e);
        }

        return ranking;
    }
}