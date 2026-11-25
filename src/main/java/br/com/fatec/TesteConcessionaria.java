package br.com.fatec;

public class TesteConcessionaria {
    public static void main(String[] args) {
        Concessionaria concessionaria = new Concessionaria();
        System.out.println("Carros no estoque: " + concessionaria.restantes());

        for (int i = 0; i < 3; i++) {
            Carro carro = concessionaria.sortear();
            System.out.println("Sorteou: " + carro);
        }

        System.out.println("Carros no estoque: " + concessionaria.restantes());
    }
}
