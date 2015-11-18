package br.edu.ifspsaocarlos.sdm.ludometer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickMenu (View view) {
        int menu = view.getId();
        Intent i;

        switch (menu) {
            case R.id.dice:
                i = new Intent(this, DiceActivity.class);
                startActivity(i);
                break;
            case R.id.chessclock:
                i = new Intent(this, ChessClockActivity.class);
                startActivity(i);
                break;
            case R.id.countdown:
                i = new Intent(this, TimerActivity.class);
                startActivity(i);
                break;
        }
    }
}
