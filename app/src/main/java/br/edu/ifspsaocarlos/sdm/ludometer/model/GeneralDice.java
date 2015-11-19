package br.edu.ifspsaocarlos.sdm.ludometer.model;

public class GeneralDice extends Raffle {
    /**
     * Construtor
     *
     * @param sides number of sides
     */
    public GeneralDice(int sides) {
        super(sides);
        this.result = this.roll(); // default initial value
    }
}
