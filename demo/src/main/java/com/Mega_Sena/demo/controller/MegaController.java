import com.Mega_Sena.demo.service.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/mega")
public class MegaController {

    private final Simulador simulador;
    private final RankingService rankingService;
    private final EstatisticaService estat;
    private final TendenciaService tendenciaService;
    private final IAService ia;
    private final AnaliseService analise;

    // 🔥 INJEÇÃO CORRETA
    public MegaController(
            Simulador simulador,
            RankingService rankingService,
            EstatisticaService estat,
            TendenciaService tendenciaService,
            IAService ia,
            AnaliseService analise) {

        this.simulador = simulador;
        this.rankingService = rankingService;
        this.estat = estat;
        this.tendenciaService = tendenciaService;
        this.ia = ia;
        this.analise = analise;
    }

    public Map<Integer, Integer> combinar(
            Map<Integer, Integer> sim,
            Map<Integer, Integer> hist) {

        Map<Integer, Integer> combinado = new HashMap<>();

        int i = 1;
        while (i <= 60) {
            int valor = sim.getOrDefault(i, 0)
                    + (hist.getOrDefault(i, 0) * 3);
            combinado.put(i, valor);
            i++;
        }

        return combinado;
    }

    // 🎯 aposta principal
    @GetMapping("/aposta")
    public List<Integer> getAposta() {
        Map<Integer, Integer> ranking = simulador.executar(4, 1_000_000);
        return rankingService.gerarTopN(ranking, 6);
    }

    // 🔥 top 10
    @GetMapping("/top10")
    public List<Integer> getTop10() {
        Map<Integer, Integer> ranking = simulador.executar(4, 1_000_000);
        return rankingService.gerarTopN(ranking, 10);
    }

    // 📈 tendência
    @GetMapping("/tendencias")
    public Map<String, List<Integer>> getTendencias() {

        Map<Integer, Integer> atual =
                simulador.executarComCache(4, 1_000_000);

        Map<Integer, Integer> historico =
                analise.gerarRankingHistorico();

        Map<Integer, Integer> tendencia =
                tendenciaService.calcularTendencia(atual, historico);

        Map<String, List<Integer>> resp = new HashMap<>();
        resp.put("subindo", tendenciaService.topHI(tendencia, 10));
        resp.put("caindo", tendenciaService.topLOW(tendencia, 10));

        return resp;
    }

    // 🤖 IA
    @GetMapping("/ia")
    public List<List<Integer>> getIA() {
        Map<Integer, Integer> ranking = simulador.executar(4, 1_000_000);
        return ia.evoluir(ranking, 5, 20);
    }

    // 📊 probabilidade
    @GetMapping("/probabilidade")
    public Map<Integer, Double> getProbabilidade() {
        Map<Integer, Integer> ranking = simulador.executar(4, 1_000_000);
        return estat.calcularProbabilidade(ranking);
    }

    // 🔥 análise completa
    @GetMapping("/analiseService")
    public List<List<Integer>> getAnaliseService() {

        Map<Integer, Integer> rankingAtual =
                simulador.executar(4, 1_000_000);

        Map<Integer, Integer> rankingHistorico =
                analise.gerarRankingHistorico();

        Map<Integer, Integer> rankingFinal =
                combinar(rankingAtual, rankingHistorico);

        return rankingService.gerarJogos(rankingFinal, 5);
    }
}