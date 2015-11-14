package br.edu.ifspsaocarlos.sdm.ludometer;

import android.app.Activity;
import android.os.SystemClock;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;

import br.edu.ifspsaocarlos.sdm.ludometer.model.Stopwatch;

public class ChessClockActivity extends BaseActivity {

    private Stopwatch chronP1;
    private Stopwatch chronP2;
    private boolean turn; // vez de P1 = true; vez de P2 = false.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chessclock);

        chronP1 = new Stopwatch ((Chronometer) findViewById(R.id.chronometerP1));
        chronP2 = new Stopwatch ((Chronometer) findViewById(R.id.chronometerP2));
        turn = true; // começa com P1
    }

    public void onClickChron(View view) {
        if (turn) {
            // desativa cronometro do P1 e ativa de P2.
            chronP1.resume();
            chronP2.stop();
            turn = false;
        } else {
            // ativa cronometro do P1 e desativa de P2.
            chronP1.stop();
            chronP2.resume();
            turn = true;
        }
    }
}
