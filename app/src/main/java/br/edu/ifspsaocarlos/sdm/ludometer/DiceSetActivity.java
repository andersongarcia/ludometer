package br.edu.ifspsaocarlos.sdm.ludometer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import br.edu.ifspsaocarlos.sdm.ludometer.adapters.DiceSetAdapter;
import br.edu.ifspsaocarlos.sdm.ludometer.model.DiceSet;

public class DiceSetActivity extends BaseActivity {
    private DiceSet diceSet;
    private ListView listView;
    private TextView totalDices;
    private ListAdapter diceAdapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diceset);

        listView = (ListView)findViewById(R.id.listDices);
        totalDices = (TextView)findViewById(R.id.total_dices);

        diceSet = new DiceSet(3, 6);
        diceAdapt = new DiceSetAdapter(this, diceSet.getSet());
        listView.setAdapter(diceAdapt);
    }

    public void onClickSort (View view) {
        // Ao clicar na tela sorteia um novo número do dado.
        int numberDrawn = diceSet.roll();

        diceAdapt = new DiceSetAdapter(this, diceSet.getSet());
        listView.setAdapter(diceAdapt);

        totalDices.setText(String.valueOf(numberDrawn));
    }

    @Override
    protected Intent getConfig() {
        return new Intent(this, DiceSetConfigActivity.class);
    }
}
