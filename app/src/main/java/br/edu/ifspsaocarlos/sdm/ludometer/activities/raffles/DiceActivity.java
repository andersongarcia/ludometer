package br.edu.ifspsaocarlos.sdm.ludometer.activities.raffles;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import br.edu.ifspsaocarlos.sdm.ludometer.R;
import br.edu.ifspsaocarlos.sdm.ludometer.activities.BaseActivity;
import br.edu.ifspsaocarlos.sdm.ludometer.model.raffles.SimpleDice;

/**
 * Tela de sorteio de dado de 6 lados.
 * Ao tocar a tela um novo número é sorteado.
 */
public class DiceActivity extends BaseActivity {

    private SimpleDice dice; // dado simples (6 lados)
    private ImageView ivDice; // Visualização do dado.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

        ivDice = (ImageView) findViewById(R.id.img_dice);
        dice = new SimpleDice();
        show(dice.roll());
    }

    public void onClickSort (View view) {
        // Ao clicar na tela sorteia um novo número do dado.
        int numberDrawn = dice.roll();
        show(numberDrawn);
    }

    private void show(int numberDrawn) {
        // De acordo com o número sorteado muda a imagem do dado.
        switch (numberDrawn) {
            case 0: // Lado 1;
                ivDice.setImageResource(R.drawable.dado_1);
                break;
            case 1: // Lado 2;
                ivDice.setImageResource(R.drawable.dado_2);
                break;
            case 2: // Lado 3;
                ivDice.setImageResource(R.drawable.dado_3);
                break;
            case 3: // Lado 4;
                ivDice.setImageResource(R.drawable.dado_4);
                break;
            case 4: // Lado 5;
                ivDice.setImageResource(R.drawable.dado_5);
                break;
            case 5: // Lado 6;
                ivDice.setImageResource(R.drawable.dado_6);
                break;
        }
    }

    @Override
    protected Intent getConfig() {
        return null;
    }
}
