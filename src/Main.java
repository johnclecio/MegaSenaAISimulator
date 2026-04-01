import java.util.*;

public class Main {

    public static void main(String[] args) {

        int threads = 4;
        int simulacoesPorThread = 1_000_000;
        int rodadas = 10;

        Simulador simulador = new Simulador();
        RankingService service = new RankingService();
        HistoricoService historico = new HistoricoService();
        AnaliseService analise = new AnaliseService();
        EstatisticaService estat = new EstatisticaService();

        int r = 0;

        while (r < rodadas) {

            System.out.println("\n🚀 RODADA " + (r + 1));

            // 1. simulação
            Map<Integer, Integer> rankingAtual =
                    simulador.executar(threads, simulacoesPorThread);

            // 2. histórico
            Map<Integer, Integer> rankingHistorico =
                    analise.gerarRankingHistorico();

            // 3. combinação
            Map<Integer, Integer> rankingFinal =
                    combinar(rankingAtual, rankingHistorico);


            // 🔥 TENDÊNCIA (AQUI É O LUGAR CERTO)
            TendenciaService tendenciaService = new TendenciaService();

            Map<Integer, Integer> tendencia =
                    tendenciaService.calcularTendencia(rankingAtual, rankingHistorico);

            System.out.println("📈 SUBINDO: " +
                    tendenciaService.topSubindo(tendencia, 10));

            System.out.println("📉 CAINDO: " +
                    tendenciaService.topCaindo(tendencia, 10));        

            // 4. TOP 10
            List<Integer> top10 = service.gerarTopN(rankingFinal, 10);
            System.out.println("🔥 TOP 10 REAL: " + top10);

            // 5. aposta principal
            List<Integer> aposta = service.gerarTopN(rankingFinal, 6);
            System.out.println("🎯 APOSTA PRINCIPAL: " + aposta);

            // 6. jogos
            List<List<Integer>> jogos = service.gerarJogos(rankingFinal, 5);

            IAService ia = new IAService();

            List<List<Integer>> melhores =
                    ia.evoluir(rankingFinal, 5, 20);

            System.out.println("\n🤖 MELHORES JOGOS (IA):");

            for (List<Integer> jogo : melhores) {
                System.out.println(jogo);
}

            System.out.println("🎯 JOGOS GERADOS:");
            for (List<Integer> jogo : jogos) {
                System.out.println(jogo);
            }

            // 7. probabilidade
            Map<Integer, Double> prob =
                    estat.calcularProbabilidade(rankingFinal);

            System.out.println("\n📊 PROBABILIDADE (%):");
            for (Map.Entry<Integer, Double> e : prob.entrySet()) {
                System.out.println(
                        "Número " + e.getKey() +
                        " → " + String.format("%.2f", e.getValue()) + "%"
                );
            }

            // 🔥 QUENTES / FRIOS
            System.out.println("\n🔥 QUENTES: " +
                    estat.topQuentes(rankingFinal, 10));

            System.out.println("❄️ FRIOS: " +
                    estat.topFrios(rankingFinal, 10));

            // 🏆 SCORE DOS JOGOS
            System.out.println("\n🏆 SCORE DOS JOGOS:");
            for (List<Integer> jogo : jogos) {
                int score = estat.calcularScore(jogo, rankingFinal);
                System.out.println(jogo + " → Score: " + score);
            }

            // 🔥 EXPORTAÇÃO (AQUI 👇)
            ExportService export = new ExportService();
            export.exportarJSON(rankingFinal);

            // 🔹 salva histórico
            historico.salvar(jogos);

            // 8. salvar histórico
            historico.salvar(jogos);

            r++;

            try {
                System.out.println("⏳ Aguardando próxima rodada...");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n✅ Finalizado.");
    }

    // 🔥 combinar simulação + histórico
    public static Map<Integer, Integer> combinar(
            Map<Integer, Integer> sim,
            Map<Integer, Integer> hist) {

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