package br.edu.ifspsaocarlos.sdm.ludometer.activities.raffles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import br.edu.ifspsaocarlos.sdm.ludometer.R;
import br.edu.ifspsaocarlos.sdm.ludometer.adapters.DiceSetAdapter;
import br.edu.ifspsaocarlos.sdm.ludometer.model.raffles.DiceSet;
import br.edu.ifspsaocarlos.sdm.ludometer.util.LudometerPreferences;

/**
 * Tela de sorteio de 1 ou mais dados.
 * Ao tocar a tela novos números são sorteados.
 */
public class DiceSetActivity extends AppCompatActivity {
    private static final int INTENT_CONFIG = 10;
    private DiceSet diceSet;   // conjunto de dados
    private ListView listView; // lista que exibe os dados na Activity
    private TextView totalDices;  // soma dos valores sorteados nos dados
    private ListAdapter diceAdapt;// adaptador que representa um dado
    private int numberOfDices; // número de dados a serem jogados/sorteados

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diceset);

        listView = (ListView)findViewById(R.id.listDices);
        totalDices = (TextView)findViewById(R.id.total_dices);

        // Obtém número de dados das preferências
        numberOfDices = LudometerPreferences.getNumberOfDices(this);

        diceSet = new DiceSet(numberOfDices, 1);
        update();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_diceset, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.menu_config:
                startActivityForResult(new Intent(this, DiceSetConfigActivity.class), INTENT_CONFIG);
                break;
        }
        return false;
    }

    /* Ao tocar a tela sorteia os dados e atualiza a tela */
    public void onClickSort (View view) {
        update();
    }

    /* Abre tela de configuração */
    protected Intent getConfig() {
        return new Intent(this, DiceSetConfigActivity.class);
    }

    /* Chamado com o retorno da tela de configuração */
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == INTENT_CONFIG) {
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
        // Ao clicar na tela realiza um novo sorteio de dados.
        int numberDrawn = diceSet.roll();
        totalDices.setText(String.valueOf(numberDrawn));

        // Preenche lista de dados
        diceAdapt = new DiceSetAdapter(this, diceSet.getSet());
        listView.setAdapter(diceAdapt);
    }

}
