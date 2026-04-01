import java.util.*;

public class Simulador {

    public Map<Integer, Integer> executar(int threads, int simulacoesPorThread) {

        List<Worker> workers = new ArrayList<>();

        int i = 0;
        while (i < threads) {
            Worker w = new Worker(simulacoesPorThread);
            workers.add(w);
            w.start();
            i++;
        }

        for (Worker w : workers) {
            try {
                w.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 🔥 juntar resultados
        Map<Integer, Integer> rankingGlobal = new HashMap<>();

        int n = 1;
        while (n <= 60) {
            rankingGlobal.put(n, 0);
            n++;
        }

        for (Worker w : workers) {
            Map<Integer, Integer> local = w.getRanking();

            for (Map.Entry<Integer, Integer> entry : local.entrySet()) {
                int numero = entry.getKey();
                int valor = entry.getValue();

                rankingGlobal.put(numero, rankingGlobal.get(numero) + valor);
            }
        }

        return rankingGlobal;
    }
}