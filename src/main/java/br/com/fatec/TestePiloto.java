package br.com.fatec;

import java.util.Random;

public class TestePiloto {
        public static void main(String [] args) {
            Random gerador = new Random();
            Piloto lucia = new Piloto("Lucia", new Carro("Grotti Cheetah", 500));
            System.out.println(lucia);

            lucia.correr(gerador, false);
            System.out.println("Tempo sem nitro: "+ lucia.getTempo() + "s");
            lucia.correr(gerador, true);
            System.out.println("Tempo com nitro: " + lucia.getTempo() + "s");

            lucia.somarPontos(10);
            lucia.registrarVitoria();
            System.out.println(lucia);

            Piloto outraLucia = new Piloto("Lucia", new Carro("Dinka Blista", 200));
            System.out.println("Iguais? " + lucia.equals(outraLucia));
        }
}
