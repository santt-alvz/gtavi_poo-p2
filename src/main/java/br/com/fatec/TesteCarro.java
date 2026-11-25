package br.com.fatec;

public class TesteCarro {
    public static void main(String[] args) {
        Carro c1 = new Carro("Grotti Cheetah", 500);
        Carro c2 = new Carro("Bravado Banshee", 400);
        Carro c3 = new Carro("Dinka Blista", 200);

        System.out.println(c1 + " faz a volta em " + c1.getTempoDeVolta() + "s");
        System.out.println(c2 + " faz a volta em " + c2.getTempoDeVolta() + "s");
        System.out.println(c3 + " faz a volta em " + c3.getTempoDeVolta() + "s");
    }
}