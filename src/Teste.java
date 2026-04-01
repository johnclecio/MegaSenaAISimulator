package src;
import java.util.*;

public class Teste {

    static Random rand = new Random();

    public static List<Integer> gerarJogo() {
        Set<Integer> jogo = new HashSet<>();

        while (jogo.size() < 6) {
            int num = rand.nextInt(60) + 1;

            if (num % 2 == 0 || num > 30) {
                jogo.add(num);
            }
        }

        List<Integer> lista = new ArrayList<>(jogo);
        Collections.sort(lista);
        return lista;
    }

    public static void main(String[] args) {

        int mundos = 10;
        int simulacoesPorMundo = 1_000_000;

        List<Integer> alvo = Arrays.asList(18, 24, 31, 43, 44, 47);

        List<Double> probabilidades = new ArrayList<>();

        Map<Integer, Integer> rankingGlobal = new HashMap<>();

        // inicializa ranking
        int n = 1;
        while (n <= 60) {
            rankingGlobal.put(n, 0);
            n++;
        }

        int m = 0;

        while (m < mundos) {

            int contador = 0;

            Map<Integer, Integer> rankingLocal = new HashMap<>();

            int k = 1;
            while (k <= 60) {
                rankingLocal.put(k, 0);
                k++;
            }

            int i = 0;

            while (i < simulacoesPorMundo) {
                List<Integer> jogo = gerarJogo();

                // conta alvo
                if (jogo.equals(alvo)) {
                    contador++;
                }

                // ranking local
                int j = 0;
                while (j < jogo.size()) {
                    int num = jogo.get(j);
                    rankingLocal.put(num, rankingLocal.get(num) + 1);
                    j++;
                }

                i++;
            }

            // probabilidade desse mundo
            double p = (double) contador / simulacoesPorMundo;
            probabilidades.add(p);

            // soma no ranking global
            for (Map.Entry<Integer, Integer> entry : rankingLocal.entrySet()) {
                int numero = entry.getKey();
                int valor = entry.getValue();
                rankingGlobal.put(numero, rankingGlobal.get(numero) + valor);
            }

            System.out.println("🌍 Mundo " + (m + 1) + " | p = " + p);

            m++;
        }

        // 🔹 média
        double soma = 0;
        int i = 0;
        while (i < probabilidades.size()) {
            soma += probabilidades.get(i);
            i++;
        }

        double media = soma / probabilidades.size();

        // 🔹 variância
        double variancia = 0;
        int j = 0;
        while (j < probabilidades.size()) {
            variancia += Math.pow(probabilidades.get(j) - media, 2);
            j++;
        }

        variancia = variancia / probabilidades.size();

        // 🔥 ranking final
        List<Map.Entry<Integer, Integer>> ranking = new ArrayList<>(rankingGlobal.entrySet());
        ranking.sort((a, b) -> b.getValue() - a.getValue());

        List<Integer> top6 = new ArrayList<>();

        int x = 0;

        while (x < 6) {
            top6.add(ranking.get(x).getKey());
            x++;
        }

        // ordena a aposta final
        Collections.sort(top6);

        System.out.println("\n🎯 APOSTA GERADA (TOP 6): " + top6);

        System.out.println("\n📊 RESULTADO FINAL");

        System.out.println("Média das probabilidades: " + media);
        System.out.println("Variância: " + variancia);

        System.out.println("\n🔥 RANKING CONSOLIDADO:");

        int r = 0;
        while (r < ranking.size()) {
            System.out.println(
                "Número: " + ranking.get(r).getKey() +
                " | Frequência: " + ranking.get(r).getValue()
            );
            r++;
        }

        
    }
}