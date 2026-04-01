import java.io.FileWriter;
import java.util.Map;

public class ExportService {

    public void exportarJSON(Map<Integer, Integer> ranking) {
        try {
            FileWriter writer = new FileWriter("dados.json");

            writer.write("{\n");

            int i = 1;
            while (i <= 60) {
                writer.write("\"" + i + "\": " + ranking.get(i));
                if (i < 60) writer.write(",");
                writer.write("\n");
                i++;
            }

            writer.write("}");
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}