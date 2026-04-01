import java.io.*;
import java.util.*;

public class HistoricoService {

    private static int rodada = 1;

    public void salvar(List<List<Integer>> jogos) {

        try {
            FileWriter writer = new FileWriter("historico.csv", true);

            for (List<Integer> jogo : jogos) {

                StringBuilder sb = new StringBuilder();

                int i = 0;
                while (i < jogo.size()) {
                    sb.append(jogo.get(i));
                    if (i < jogo.size() - 1) sb.append("-");
                    i++;
                }

                writer.write(rodada + "," + sb.toString() + "\n");
            }

            rodada++;

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}