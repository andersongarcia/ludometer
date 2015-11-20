package br.edu.ifspsaocarlos.sdm.ludometer.activities.timers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;

import br.edu.ifspsaocarlos.sdm.ludometer.R;
import br.edu.ifspsaocarlos.sdm.ludometer.activities.BaseActivity;
import br.edu.ifspsaocarlos.sdm.ludometer.model.timers.Stopwatch;

/**
 * Tela de relógio de xadrez.
 * Ao tocar a tela alterna a contagem de tempo dos jogadores.
 */
public class ChessClockActivity extends BaseActivity {

    private Stopwatch chronP1; // relógio do jogador 1
    private Stopwatch chronP2; // relógio do jogador 2
    private boolean turn; // vez de P1 = true; vez de P2 = false.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chessclock);

        chronP1 = new Stopwatch ((Chronometer) findViewById(R.id.chronometerP1));
        chronP2 = new Stopwatch ((Chronometer) findViewById(R.id.chronometerP2));
        turn = true; // começa com P1
    }

    /**
     * Ao tocar a tela é verificado de quem é a vez de jogar para
     * iniciar a contagem de tempo, enquanto o relógio do oponente
     * é parado.
     *
     * @param view
     */
    public void onClickChron(View view) {
        if (turn) {
            // ativa cronometro do P1 e desativa de P2.
            chronP1.resume();
            chronP2.stop();
            turn = false;
        } else {
            // desativa cronometro do P1 e ativa de P2.
            chronP2.resume();
            chronP1.stop();
            turn = true;
        }
    }

    @Override
    protected Intent getConfig() {
        return null;
    }
}
