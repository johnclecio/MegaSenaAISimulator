package com.Mega_Sena.demo.controller;



import com.Mega_Sena.demo.service.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/mega")
public class MegaController {

    private final Simulador simulador = new Simulador();
    private final RankingService rankingService = new RankingService();
    private final EstatisticaService estat = new EstatisticaService();
    private final TendenciaService tendenciaService = new TendenciaService();
    private final IAService ia = new IAService();
    private final AnaliseService analise = new AnaliseService();

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

    @GetMapping("/tendencias")
    public Map<String, List<Integer>> getTendencias() {

        Map<Integer, Integer> atual =
                simulador.executar(4, 1_000_000);

        Map<Integer, Integer> historico =
                analise.gerarRankingHistorico();

        TendenciaService tendenciaService = new TendenciaService();

        Map<Integer, Integer> tendencia =
                tendenciaService.calcularTendencia(atual, historico);

        Map<String, List<Integer>> resp = new HashMap<>();

        // 🔥 HI (subindo)
        resp.put("subindo", tendenciaService.topHI(tendencia, 10));

        // ❄️ LOW (caindo)
        resp.put("caindo", tendenciaService.topLOW(tendencia, 10));

        return resp;
    }

    // 🤖 jogos IA
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
}