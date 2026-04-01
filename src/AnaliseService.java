import java.io.*;
import java.util.*;

public class AnaliseService {

    public Map<Integer, Integer> gerarRankingHistorico() {

        Map<Integer, Integer> ranking = new HashMap<>();

        int i = 1;
        while (i <= 60) {
            ranking.put(i, 0);
            i++;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader("historico.csv"));

            String linha;

            while ((linha = reader.readLine()) != null) {

                String[] partes = linha.split(",");

                if (partes.length < 2) continue;

                String[] numeros = partes[1].split("-");

                int j = 0;

                while (j < numeros.length) {
                    int num = Integer.parseInt(numeros[j]);
                    ranking.put(num, ranking.get(num) + 1);
                    j++;
                }
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ranking;
    }
}   