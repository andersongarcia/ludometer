package br.edu.ifspsaocarlos.sdm.ludometer;

import android.content.Intent;
import android.content.SyncStatusObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public abstract class BaseActivity extends AppCompatActivity {
    static final int REQUEST_CODE = 10;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.open_dice:
                startActivity(new Intent(this, DiceActivity.class));
                break;
            case R.id.open_diceset:
                startActivity(new Intent(this, DiceSetActivity.class));
                break;
            case R.id.open_chessclock:
                startActivity(new Intent(this, ChessClockActivity.class));
                break;
            case R.id.open_timer:
                startActivity(new Intent(this, TimerActivity.class));
                break;
            case R.id.menu_config:
                startActivityForResult(this.getConfig(), REQUEST_CODE);
        }
        return false;
    }

    protected abstract Intent getConfig();
}
