package br.com.fatec;

import java.util.List;

public class TestePartidaDAO {
    public static void main(String[] args) {
        Partida ana = Partida.builder().jogador("Ana").pontuacao(26).build();
        Partida bia = Partida.builder().jogador("Bia").pontuacao(13).build();

        System.out.println("Cadastrou Ana? " + PartidaDAO.cadastrar(ana));
        System.out.println("Cadastrou Bia? " + PartidaDAO.cadastrar(bia));

        List<Partida> partidas = PartidaDAO.listar();
        for (int i = 0; i < partidas.size(); i++) {
            Partida p = partidas.get(i);
            System.out.println((i + 1) + "- " + p.getJogador() + " - " + p.getPontuacao());
        }
    }
}