package br.edu.ifspsaocarlos.sdm.ludometer.activities.raffles;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

import br.edu.ifspsaocarlos.sdm.ludometer.R;
import br.edu.ifspsaocarlos.sdm.ludometer.activities.BaseActivity;
import br.edu.ifspsaocarlos.sdm.ludometer.adapters.CircularAdapter;

public class RouletteActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roulette);

        final ListView listRoulette = (ListView) findViewById(R.id.listRoulette);

        Integer[] colors = new Integer[]{ Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW };
        CircularAdapter adapter = new CircularAdapter(this, colors);

        listRoulette.setAdapter(adapter);
        listRoulette.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState){
                    case SCROLL_STATE_IDLE:
                        TextView bar = (TextView) view.findViewById(R.id.rouletteBar);
                        listRoulette.smoothScrollToPosition(view.getLastVisiblePosition());
                        break;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
    }

    @Override
    protected Intent getConfig() {
        return null;
    }
}
