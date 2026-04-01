import java.util.*;

public class Worker extends Thread {

    private int simulacoes;
    private Map<Integer, Integer> ranking;

    public Worker(int simulacoes) {
        this.simulacoes = simulacoes;
        this.ranking = new HashMap<>();

        // inicializa ranking de 1 a 60
        int i = 1;
        while (i <= 60) {
            ranking.put(i, 0);
            i++;
        }
    }

    public Map<Integer, Integer> getRanking() {
        return ranking;
    }

    @Override
    public void run() {

        Random rand = new Random();

        int i = 0;

        while (i < simulacoes) {

            Set<Integer> jogo = new HashSet<>();

            // gera jogo
            while (jogo.size() < 6) {
                int num = rand.nextInt(60) + 1;

                if (num % 2 == 0 || num > 30) {
                    jogo.add(num);
                }
            }

            // atualiza ranking
            for (int num : jogo) {
                ranking.put(num, ranking.get(num) + 1);
            }

            i++;
        }
    }
}