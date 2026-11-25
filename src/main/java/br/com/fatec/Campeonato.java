

package br.com.fatec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Campeonato {
    private static final int[] PONTOS = {10, 6, 3, 1};
    private List<Piloto> pilotos = new ArrayList<>();

    public void inscrever(Piloto piloto) {
        if (pilotos.size() >= 4) {
            System.out.println("Grid cheio.");
            return;
        }
        if (pilotos.contains(piloto)) {
            System.out.println("Piloto repetido.");
            return;
        }
        pilotos.add(piloto);
    }

    public void registrarCorrida(List<Piloto> chegada) {
        for (int i = 0; i < chegada.size(); i++) {
            Piloto p = chegada.get(i);
            if (i < PONTOS.length) {
                p.somarPontos(PONTOS[i]);
            }
            if (i == 0) {
                p.registrarVitoria();
            }
        }
    }

    public List<Piloto> disputarCorrida(Random gerador, Piloto jogador, boolean nitro) {
        for (Piloto p : pilotos) {
            boolean usaNitro = p.equals(jogador) && nitro;
            p.correr(gerador, usaNitro);
        }

        List<Piloto> chegada = new ArrayList<>(pilotos);
        chegada.sort(new Comparator<Piloto>() {
            @Override
            public int compare(Piloto a, Piloto b) {
                if (a.getTempo() < b.getTempo()) return -1;
                if (a.getTempo() > b.getTempo()) return 1;
                return 0;
            }
        });

        registrarCorrida(chegada);
        return chegada;
    }

    public List<Piloto> getClassificacao() {
        List<Piloto> classificacao = new ArrayList<>(pilotos);
        Collections.sort(classificacao, new Comparator<Piloto>() {
            @Override
            public int compare(Piloto a, Piloto b) {
                if (a.getPontos() > b.getPontos()) return -1;
                if (a.getPontos() < b.getPontos()) return 1;

                if (a.getVitorias() > b.getVitorias()) return -1;
                if (a.getVitorias() < b.getVitorias()) return 1;

                return a.getNome().compareTo(b.getNome());
            }
        });
        return classificacao;
    }
}


