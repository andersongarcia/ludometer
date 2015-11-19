package br.edu.ifspsaocarlos.sdm.ludometer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import br.edu.ifspsaocarlos.sdm.ludometer.util.LudometerPreferences;

public class DiceSetConfigActivity extends AppCompatActivity {
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_set_config);

        spinner = (Spinner)findViewById(R.id.spinnerNumeroDeDados);
        Integer[] items = new Integer[]{1,2,3,4,5,6};
        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        spinner.setAdapter(adapter);
    }


    public void saveConfig(View view) {
        LudometerPreferences.setNumberOfDices(this, (Integer) spinner.getSelectedItem());
    }
}
