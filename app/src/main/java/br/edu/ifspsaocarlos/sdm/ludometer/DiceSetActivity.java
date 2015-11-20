package br.edu.ifspsaocarlos.sdm.ludometer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import br.edu.ifspsaocarlos.sdm.ludometer.adapters.DiceSetAdapter;
import br.edu.ifspsaocarlos.sdm.ludometer.model.DiceSet;
import br.edu.ifspsaocarlos.sdm.ludometer.util.LudometerPreferences;

public class DiceSetActivity extends BaseActivity {
    private DiceSet diceSet;
    private ListView listView;
    private TextView totalDices;
    private ListAdapter diceAdapt;
    private int numberOfDices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diceset);

        listView = (ListView)findViewById(R.id.listDices);
        totalDices = (TextView)findViewById(R.id.total_dices);

        // Obtém número de dados das preferências
        numberOfDices = LudometerPreferences.getNumberOfDices(this);

        diceSet = new DiceSet(numberOfDices, 6);
        update();
    }

    public void onClickSort (View view) {
        update();
    }

    @Override
    protected Intent getConfig() {
        return new Intent(this, DiceSetConfigActivity.class);
    }

    /* Called when the second activity's finished */
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                //numberOfDices = data.getIntExtra(LudometerPreferences.NUMBER_OF_DICES, 1);
                numberOfDices = data.getIntExtra(LudometerPreferences.NUMBER_OF_DICES, 1);
                diceSet = new DiceSet(numberOfDices, 6);
                //diceSet = new DiceSet(LudometerPreferences.getNumberOfDices(this), 6);
                update();
            }
        }
    }

    private void update() {
        // Ao clicar na tela sorteia um novo número do dado.
        int numberDrawn = diceSet.roll();
        totalDices.setText(String.valueOf(numberDrawn));

        // Preenche lista de dados
        diceAdapt = new DiceSetAdapter(this, diceSet.getSet());
        listView.setAdapter(diceAdapt);
    }

}
