package br.edu.ifspsaocarlos.sdm.ludometer;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import br.edu.ifspsaocarlos.sdm.ludometer.model.Countdown;
import br.edu.ifspsaocarlos.sdm.ludometer.model.ITimer;
import br.edu.ifspsaocarlos.sdm.ludometer.util.TimeFormat;

public class TimerActivity extends AppCompatActivity {

    private ITimer timer;
    private long startTime;
    private TextView counterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        startTime = 30000;
        counterView = (TextView)findViewById(R.id.countdown_timer);
        counterView.setText(showDigitalClock(startTime));
        timer = new Countdown(startTime,counterView);
        findViewById(R.id.btnPause).setEnabled(false);
        findViewById(R.id.btnReset).setEnabled(false);
    }

    public void onClickStartTimer (View view) {
        if (timer.getLastTime() > 0) {
            timer.resume();
        } else {
            timer.start();
        }
        findViewById(R.id.btnPause).setEnabled(true);
        findViewById(R.id.btnReset).setEnabled(true);
        findViewById(R.id.btnStart).setEnabled(false);
    }

    public void onClickPauseTimer (View view) {
        timer.pause();
        findViewById(R.id.btnPause).setEnabled(false);
        findViewById(R.id.btnReset).setEnabled(true);
        findViewById(R.id.btnStart).setEnabled(true);
    }

    public void onClickResetTimer (View view) {
        timer.stop();
        counterView.setText(showDigitalClock(startTime));
        timer = new Countdown(startTime,(TextView)findViewById(R.id.countdown_timer));
        findViewById(R.id.btnPause).setEnabled(false);
        findViewById(R.id.btnReset).setEnabled(false);
        findViewById(R.id.btnStart).setEnabled(true);
        ((TextView) findViewById(R.id.countdown_timer)).setTextColor(Color.BLACK);
    }

    public String showDigitalClock (long milliseconds) {
        String digitalClock;
        int[] clock = TimeFormat.milliToTime(milliseconds);

        digitalClock = String.format("%02d:%02d",clock[1],clock[2]);

        return digitalClock;
    }
}

