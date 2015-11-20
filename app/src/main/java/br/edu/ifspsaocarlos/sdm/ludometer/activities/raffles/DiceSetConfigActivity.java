package br.edu.ifspsaocarlos.sdm.ludometer.activities.raffles;

import android.content.Intent;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.Spinner;

import br.edu.ifspsaocarlos.sdm.ludometer.R;
import br.edu.ifspsaocarlos.sdm.ludometer.activities.ConfigActivity;
import br.edu.ifspsaocarlos.sdm.ludometer.util.LudometerPreferences;

public class DiceSetConfigActivity extends ConfigActivity {
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
    public void saveconfig() {
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
