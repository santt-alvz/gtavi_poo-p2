package br.com.fatec;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Carro implements Comparable<Carro> {
    private String modelo;
    private int potencia;

    // Calcula o tempo de volta em segundos (divisão inteira)
    public int getTempoDeVolta() {
        return 30 + 6000 / potencia;
    }

    @Override
    public String toString() {
        return modelo + " (" + potencia + " cv)";
    }

    @Override
    public boolean equals(Object obj) {
        Carro outro = (Carro) obj;
        return this.modelo.equals(outro.modelo);
    }

    @Override
    public int compareTo(Carro outro) {
        if (this.potencia > outro.potencia)
            return -1;
        if (this.potencia < outro.potencia)
            return 1;
        return this.modelo.compareTo(outro.modelo);
    }
}