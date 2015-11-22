package br.edu.ifspsaocarlos.sdm.ludometer.activities.raffles;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

import br.edu.ifspsaocarlos.sdm.ludometer.R;
import br.edu.ifspsaocarlos.sdm.ludometer.adapters.CircularAdapter;

/**
 * Tela de roleta de cores
 * Implementação de scroll em lista circular (infinita)
 */
public class RouletteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roulette);

        final ListView listRoulette = (ListView) findViewById(R.id.listRoulette);

        // Cria paleta de cores
        Integer[] colors = new Integer[]{ Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW };

        // Chama adapter circular
        CircularAdapter adapter = new CircularAdapter(this, colors);
        listRoulette.setAdapter(adapter);
        // Seta listener para o scroll. Quando parar o scroll, deve posicionar os itens visíveis
        //  de forma a exibir trës inteiros na tela
        listRoulette.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState){
                    case SCROLL_STATE_IDLE:
                        // encontra o primeiro item visível (geralmente parcialmente visível)
                        TextView bar = (TextView) view.findViewById(R.id.rouletteBar);
                        // rola até o início do próximo
                        listRoulette.smoothScrollToPosition(view.getLastVisiblePosition());
                        break;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            }
        });
    }
}
