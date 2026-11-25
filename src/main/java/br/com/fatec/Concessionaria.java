package br.com.fatec;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Concessionaria {
    private List<Carro> estoque;
    private Random gerador;

    public Concessionaria() {
        estoque = new ArrayList<>();
        gerador = new Random();

        String[] modelos = {
            "Truffade Adder", "Grotti Cheetah", "Pegassi Infernus", "Vapid Dominator",
            "Bravado Banshee", "Declasse Vigero", "Karin Sultan", "Dinka Blista"
        };

        int[] potencias = {
            520, 500, 480, 420, 400, 350, 300, 200
        };

        for (int i = 0; i < modelos.length; i++) {
            estoque.add(new Carro(modelos[i], potencias[i]));
        }
    }

    public Carro sortear() {
        if (estoque.isEmpty()) {
            return null;
        }
        int indice = gerador.nextInt(estoque.size());
        return estoque.remove(indice);
    }

    public int restantes() {
        return estoque.size();
    }
}