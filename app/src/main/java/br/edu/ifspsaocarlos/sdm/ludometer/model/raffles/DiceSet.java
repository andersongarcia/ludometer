package br.edu.ifspsaocarlos.sdm.ludometer.model.raffles;

import java.util.ArrayList;
import java.util.List;

public class DiceSet extends Raffle {

    private List<Raffle> set;

    /**
     * Constructor
     * @param dices number of dices
     * @param sides number of sides of each dice
     */
    public DiceSet(int dices, int sides) {
        super(sides);

        this.set = new ArrayList<>();

        for (int i = 0; i < dices; i++) {
            this.set.add(new GeneralDice(sides));
        }
    }

    public List<Raffle> getSet() {
        return set;
    }

    /**
     * Roll all dices in the set
     * @return the sum of drawn numbers
     */
    @Override
    public int roll() {
        this.result = 0;
        for (Raffle dice : this.set) {
            this.result += (dice.roll() + 1);
        }

        return this.result;
    }
}