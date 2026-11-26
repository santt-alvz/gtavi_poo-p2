package br.com.fatec;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Partida {
    private int codigo;
    private String jogador;
    private int pontuacao;
}