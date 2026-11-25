package br.com.fatec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TesteCarro {
    public static void main(String[] args) {
        Carro c1 = new Carro("Grotti Cheetah", 500);
        Carro c2 = new Carro("Bravado Banshee", 400);
        Carro c3 = new Carro("Dinka Blista", 200);

        System.out.println(c1 + " faz a volta em " + c1.getTempoDeVolta() + "s");
        System.out.println(c2 + " faz a volta em " + c2.getTempoDeVolta() + "s");
        System.out.println(c3 + " faz a volta em " + c3.getTempoDeVolta() + "s");

        Carro outroCheetah = new Carro("Grotti Cheetah", 500);
        Carro infernus = new Carro("Pegassi Infernus", 500);
        System.out.println("Iguais? " + c1.equals(outroCheetah));
        System.out.println("Iguais? " + c1.equals(infernus));

        List<Carro> lista = new ArrayList<>();
        lista.add(new Carro("Dinka Blista", 200));
        lista.add(new Carro("Ocelot Pariah", 500));
        lista.add(new Carro("Bravado Banshee", 400));
        lista.add(new Carro("Grotti Cheetah", 500));
        Collections.sort(lista);
        System.out.println(lista);
    }
}