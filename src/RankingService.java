import java.util.*;

public class RankingService {

    public List<Integer> gerarTopN(Map<Integer, Integer> ranking, int n) {
        List<Map.Entry<Integer, Integer>> lista = new ArrayList<>(ranking.entrySet());

        lista.sort((a, b) -> b.getValue() - a.getValue());

        List<Integer> top = new ArrayList<>();

        int i = 0;
       int limite = Math.min(n, lista.size());

       
        while (i < limite) {
            top.add(lista.get(i).getKey());
            i++;
        }

        return top;
    }

    // 🔥 gera vários jogos
    public List<List<Integer>> gerarJogos(Map<Integer, Integer> ranking, int quantidadeJogos) {

        List<Integer> top15 = gerarTopN(ranking, 15);

        List<List<Integer>> jogos = new ArrayList<>();

        Random rand = new Random();

        int i = 0;

        while (i < quantidadeJogos) {

            Set<Integer> jogo = new HashSet<>();

            while (jogo.size() < 6) {
                int num = top15.get(rand.nextInt(top15.size()));
                jogo.add(num);
            }

            List<Integer> lista = new ArrayList<>(jogo);
            Collections.sort(lista);

            jogos.add(lista);

            i++;
        }

        return jogos;
    }

        public Map<Integer, Integer> combinar(Map<Integer, Integer> sim, Map<Integer, Integer> hist) {

        Map<Integer, Integer> combinado = new HashMap<>();

        int i = 1;

        while (i <= 60) {
            int valor = sim.get(i) + (hist.get(i) * 3);
            combinado.put(i, valor);
            i++;
        }

        return combinado;
    }
}