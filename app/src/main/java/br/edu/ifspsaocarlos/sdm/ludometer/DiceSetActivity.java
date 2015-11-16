package br.edu.ifspsaocarlos.sdm.ludometer;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;

import java.util.List;

import br.edu.ifspsaocarlos.sdm.ludometer.adapters.DiceSetAdapter;
import br.edu.ifspsaocarlos.sdm.ludometer.model.DiceSet;
import br.edu.ifspsaocarlos.sdm.ludometer.model.GeneralDice;

public class DiceSetActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DiceSet diceSet = new DiceSet(2, 6);
        ListAdapter adaptador = new DiceSetAdapter(this, diceSet.getSet());
        setListAdapter(adaptador);
    }
}
