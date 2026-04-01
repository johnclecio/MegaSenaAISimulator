import java.util.*;

public class TendenciaService {

    public Map<Integer, Integer> calcularTendencia(
            Map<Integer, Integer> atual,
            Map<Integer, Integer> historico) {

        Map<Integer, Integer> tendencia = new HashMap<>();

        int i = 1;

        while (i <= 60) {
            int valor = atual.get(i) - historico.get(i);
            tendencia.put(i, valor);
            i++;
        }

        return tendencia;
    }

    public List<Integer> topSubindo(Map<Integer, Integer> tendencia, int n) {

        List<Map.Entry<Integer, Integer>> lista =
                new ArrayList<>(tendencia.entrySet());

        lista.sort((a, b) -> b.getValue() - a.getValue());

        List<Integer> res = new ArrayList<>();

        int i = 0;
        while (i < n) {
            res.add(lista.get(i).getKey());
            i++;
        }

        return res;
    }

    public List<Integer> topCaindo(Map<Integer, Integer> tendencia, int n) {

        List<Map.Entry<Integer, Integer>> lista =
                new ArrayList<>(tendencia.entrySet());

        lista.sort((a, b) -> a.getValue() - b.getValue());

        List<Integer> res = new ArrayList<>();

        int i = 0;
        while (i < n) {
            res.add(lista.get(i).getKey());
            i++;
        }

        return res;
    }
}