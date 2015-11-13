package br.edu.ifspsaocarlos.sdm.ludometer.model;

import android.os.SystemClock;

import java.util.Random;

/**
 * Abstração de sorteio genérico
 */
public abstract class Raffle implements ISortable {
    private int length;

    /** Construtor
     * @param length número de variáveis para sorteio */
    public Raffle(int length){
        this.length = length;
    }

    @Override
    public int roll() {
        return new Random(SystemClock.currentThreadTimeMillis()).nextInt(this.length);
    }
}
