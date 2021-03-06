package br.edu.ifspsaocarlos.sdm.ludometer.model.raffles;

import java.util.Random;

/**
 * Abstração de sorteio genérico
 */
public abstract class Raffle implements ISortable {
    private int length;
    protected int result;

    /** Construtor
     * @param length número de variáveis para sorteio */
    public Raffle(int length){
        this.length = length;
    }

    public int getResult() {
        return result;
    }

    @Override
    public int roll() {
        this.result = new Random().nextInt(this.length);
        return this.result;
    }
}
