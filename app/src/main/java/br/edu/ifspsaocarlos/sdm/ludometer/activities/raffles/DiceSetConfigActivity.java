package br.edu.ifspsaocarlos.sdm.ludometer.activities.raffles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.NumberPicker;
import android.widget.Spinner;

import br.edu.ifspsaocarlos.sdm.ludometer.R;
import br.edu.ifspsaocarlos.sdm.ludometer.util.LudometerPreferences;

/**
 * Tela de configuração dos parâmetros do conjunto de dados.
 */
public class DiceSetConfigActivity extends AppCompatActivity {

    private Spinner spinner;
    private NumberPicker picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_set_config);

        picker = (NumberPicker)findViewById(R.id.pickerNumeroDeDados);
        picker.setMinValue(1);
        picker.setMaxValue(5);
        picker.setValue(LudometerPreferences.getNumberOfDices(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_config, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.menu_saveconfig:
                saveConfig();
                break;
        }
        return false;
    }

    public void saveConfig() {
        Integer numOfDices = picker.getValue();

        // salva configurações nas shared preferences
        LudometerPreferences.setNumberOfDices(this, numOfDices);

        // seta intent com resultado
        Intent intent = getIntent();
        intent.putExtra(LudometerPreferences.NUMBER_OF_DICES, numOfDices);
        setResult(RESULT_OK, intent);
        finish();
    }
}
