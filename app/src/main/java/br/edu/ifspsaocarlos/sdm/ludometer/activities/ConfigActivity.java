package br.edu.ifspsaocarlos.sdm.ludometer.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import br.edu.ifspsaocarlos.sdm.ludometer.R;

/**
 * Classe de referência para criação de telas de configurações
 * contendo opções padrỗes.
 */
public abstract class ConfigActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

    public abstract void saveConfig();
}
