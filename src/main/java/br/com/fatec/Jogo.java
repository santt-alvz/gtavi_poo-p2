package br.com.fatec;

import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

public class Jogo {
    private static final int CORRIDAS = 3;
    private static final int NITROS = 2;

    public static void main(String[] args) {
        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(
                "1-Jogar\n2-Ranking\n0-Sair"
            ));

            switch (opcao) {
                case 1:
                    jogar();
                    break;
                case 2:
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Ate a proxima!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcao invalida");
                    break;
            }
        } while (opcao != 0);
    }

    private static void jogar() {
        String nomeJogador = JOptionPane.showInputDialog("Digite seu nome:");
        int escolhaPiloto = Integer.parseInt(JOptionPane.showInputDialog(
            "Escolha seu piloto:\n1-Jason\n2-Lucia"
        ));

        String nomePiloto;
        switch (escolhaPiloto) {
            case 1:
                nomePiloto = "Jason";
                break;
            case 2:
                nomePiloto = "Lucia";
                break;
            default:
                nomePiloto = "Lucia";
                break;
        }

        Concessionaria concessionaria = new Concessionaria();
        Campeonato campeonato = new Campeonato();
        Random gerador = new Random();

        Piloto jogador = new Piloto(nomePiloto, concessionaria.sortear());
        campeonato.inscrever(jogador);
        campeonato.inscrever(new Piloto("Raul", concessionaria.sortear()));
        campeonato.inscrever(new Piloto("Boobie", concessionaria.sortear()));
        campeonato.inscrever(new Piloto("Cal", concessionaria.sortear()));

        JOptionPane.showMessageDialog(null, "Seu carro: " + jogador.getCarro());

        int nitrosRestantes = NITROS;

        for (int corrida = 1; corrida <= CORRIDAS; corrida++) {
            List<Piloto> classificacaoAtual = campeonato.getClassificacao();
            String textoClassificacao = formatarListaPilotos(classificacaoAtual, false);

            int escolhaNitro = Integer.parseInt(JOptionPane.showInputDialog(
                "Corrida " + corrida + "/" + CORRIDAS + "\n" +
                textoClassificacao + "\n" +
                "Usar nitro? 1-Sim 2-Nao (restam " + nitrosRestantes + ")"
            ));

            boolean usarNitro = false;
            if (escolhaNitro == 1) {
                if (nitrosRestantes > 0) {
                    usarNitro = true;
                    nitrosRestantes--;
                } else {
                    JOptionPane.showMessageDialog(null, "Sem nitro restante");
                }
            }

            List<Piloto> chegada = campeonato.disputarCorrida(gerador, jogador, usarNitro);
            String textoChegada = formatarListaPilotos(chegada, true);

            JOptionPane.showMessageDialog(null, "Chegada\n" + textoChegada);
        }

        List<Piloto> classificacaoFinal = campeonato.getClassificacao();
        int posicaoFinal = classificacaoFinal.indexOf(jogador) + 1;
        String resultadoFinal = (posicaoFinal == 1)
            ? "Campeao de Vice City!"
            : "Posicao final: " + posicaoFinal;

        JOptionPane.showMessageDialog(
            null,
            formatarListaPilotos(classificacaoFinal, false) + "\n" + resultadoFinal
        );

        Partida partida = Partida.builder()
            .jogador(nomeJogador)
            .pontuacao(jogador.getPontos())
            .build();

        if (PartidaDAO.cadastrar(partida)) {
            JOptionPane.showMessageDialog(null, "Partida salva");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao salvar a partida");
        }
    }

    private static String formatarListaPilotos(List<Piloto> pilotos, boolean exibirTempo) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pilotos.size(); i++) {
            Piloto p = pilotos.get(i);
            sb.append(i + 1).append(". ");
            if (exibirTempo) {
                sb.append(p.getNome()).append(" - ").append(p.getTempo()).append("s");
            } else {
                sb.append(p.toString());
            }
            if (i < pilotos.size() - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}