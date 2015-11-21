package br.edu.ifspsaocarlos.sdm.ludometer.activities.timers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

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
    private TextView tvP1Chron;
    private TextView tvP2Chron;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chessclock);

        tvP1Chron = (TextView) findViewById(R.id.chronometerP1);
        tvP2Chron = (TextView) findViewById(R.id.chronometerP2);

        startNewGame();
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
            tvP1Chron.setTextSize(80);
            tvP1Chron.setEnabled(true);
            chronP2.stop();
            tvP2Chron.setTextSize(60);
            tvP2Chron.setEnabled(false);
            turn = false;
        } else {
            // desativa cronometro do P1 e ativa de P2.
            chronP2.resume();
            tvP2Chron.setTextSize(80);
            tvP2Chron.setEnabled(true);
            chronP1.stop();
            tvP1Chron.setTextSize(60);
            tvP1Chron.setEnabled(false);
            turn = true;
        }
    }

    /**
     * Botão para reiniciar as contagens de tempo.
     *
     * @param view
     */
    public void onClickResetClock (View view) {
        chronP1.stop();
        chronP2.stop();
        startNewGame();
    }

    /**
     * Método que carrega os parẫmetros iniciais para uma nova partida.
     *
     */
    void startNewGame () {
        chronP1 = new Stopwatch ((Chronometer) findViewById(R.id.chronometerP1));
        chronP2 = new Stopwatch ((Chronometer) findViewById(R.id.chronometerP2));
        turn = true; // começa com P1
    }

    @Override
    protected Intent getConfig() {
        return null;
    }
}
