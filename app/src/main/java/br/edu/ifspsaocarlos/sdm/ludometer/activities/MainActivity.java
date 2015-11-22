package br.edu.ifspsaocarlos.sdm.ludometer.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.edu.ifspsaocarlos.sdm.ludometer.R;
import br.edu.ifspsaocarlos.sdm.ludometer.activities.raffles.DiceSetActivity;
import br.edu.ifspsaocarlos.sdm.ludometer.activities.raffles.RouletteActivity;
import br.edu.ifspsaocarlos.sdm.ludometer.activities.timers.ChessClockActivity;
import br.edu.ifspsaocarlos.sdm.ludometer.activities.timers.TimerActivity;

/**
 * Tela inicial do aplicativo que apresenta as funções
 * disponíveis através de ícones.
 * Ao tocar sobre um ícone abre-se a respectiva função.
 */
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
            case R.id.dice: // Tela de sorteio de dados
                i = new Intent(this, DiceSetActivity.class);
                startActivity(i);
                break;
            case R.id.roulette: // Tela de sorteio de dados
                i = new Intent(this, RouletteActivity.class);
                startActivity(i);
                break;
            case R.id.chessclock: // Tela do relógio de xadrez
                i = new Intent(this, ChessClockActivity.class);
                startActivity(i);
                break;
            case R.id.countdown: // Tela de contagem regressiva
                i = new Intent(this, TimerActivity.class);
                startActivity(i);
                break;
        }
    }
}
