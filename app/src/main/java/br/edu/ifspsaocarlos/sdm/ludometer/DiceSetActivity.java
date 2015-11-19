package br.edu.ifspsaocarlos.sdm.ludometer;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import br.edu.ifspsaocarlos.sdm.ludometer.adapters.DiceSetAdapter;
import br.edu.ifspsaocarlos.sdm.ludometer.model.DiceSet;
import br.edu.ifspsaocarlos.sdm.ludometer.model.GeneralDice;
import br.edu.ifspsaocarlos.sdm.ludometer.model.SimpleDice;

public class DiceSetActivity extends BaseActivity {
    private DiceSet diceSet; // dado simples (6 lados)
    private ListView listView;
    private TextView totalDices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diceset);
        listView = (ListView)findViewById(R.id.listDices);
        totalDices = (TextView)findViewById(R.id.totalDices);

        this.diceSet = new DiceSet(2, 6);
        ListAdapter adaptador = new DiceSetAdapter(this, diceSet.getSet());
        listView.setAdapter(adaptador);
    }

    public void onClickSort (View view) {
        // Ao clicar na tela sorteia um novo número do dado.
        int numberDrawn = diceSet.roll();

        ListAdapter adaptador = new DiceSetAdapter(this, diceSet.getSet());
        listView.setAdapter(adaptador);

        //totalDices.setText(numberDrawn);
    }
}
