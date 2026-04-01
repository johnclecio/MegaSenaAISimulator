package com.Mega_Sena.demo.service;

import java.util.*;

public class IAService {

    Random rand = new Random();

    public List<List<Integer>> evoluir(
            Map<Integer, Integer> ranking,
            int geracoes,
            int populacaoSize) {

        List<List<Integer>> populacao = gerarPopulacaoInicial(ranking, populacaoSize);

        EstatisticaService estat = new EstatisticaService();

        int g = 0;

        while (g < geracoes) {
    
            // ordena por score
            populacao.sort((a, b) ->
                    estat.calcularScore(b, ranking) -
                            estat.calcularScore(a, ranking));

            // mantém top 50%
            List<List<Integer>> nova = new ArrayList<>();

            int i = 0;
            while (i < populacaoSize / 2) {
                nova.add(populacao.get(i));
                i++;
            }

            // cruzamento
            while (nova.size() < populacaoSize) {

                List<Integer> pai1 = nova.get(rand.nextInt(nova.size()));
                List<Integer> pai2 = nova.get(rand.nextInt(nova.size()));

                Set<Integer> filho = new HashSet<>();

                filho.addAll(pai1);
                filho.addAll(pai2);

                while (filho.size() > 6) {
                    List<Integer> temp = new ArrayList<>(filho);
                    filho.remove(temp.get(rand.nextInt(temp.size())));
                }

                nova.add(new ArrayList<>(filho));
            }

            populacao = nova;
            g++;
        }

        return populacao;
    }

    private List<List<Integer>> gerarPopulacaoInicial(
            Map<Integer, Integer> ranking, int size) {

        RankingService service = new RankingService();
        return service.gerarJogos(ranking, size);
    }
}
