package br.edu.ifspsaocarlos.sdm.ludometer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import br.edu.ifspsaocarlos.sdm.ludometer.model.Countdown;
import br.edu.ifspsaocarlos.sdm.ludometer.model.ITimer;

public class TimerActivity extends AppCompatActivity {

    private ITimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        timer = new Countdown(30000,(TextView)findViewById(R.id.countdown_timer));
    }

    public void onClickStartTimer (View view) {

        timer.start();

    }

    public void onClickStopTimer (View view) {
        timer.stop();
    }
}

