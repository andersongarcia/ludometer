package br.edu.ifspsaocarlos.sdm.ludometer.model;

public class GeneralDice extends Raffle {
    /**
     * Construtor
     *
     * @param sides number of sides
     */
    public GeneralDice(int sides) {
        super(sides);

        this.result = 6; // default initial value
    }
}
