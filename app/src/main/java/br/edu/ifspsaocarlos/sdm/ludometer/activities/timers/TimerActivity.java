package br.edu.ifspsaocarlos.sdm.ludometer.activities.timers;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import br.edu.ifspsaocarlos.sdm.ludometer.R;
import br.edu.ifspsaocarlos.sdm.ludometer.model.timers.Countdown;
import br.edu.ifspsaocarlos.sdm.ludometer.model.timers.ITimer;
import br.edu.ifspsaocarlos.sdm.ludometer.util.LudometerPreferences;
import br.edu.ifspsaocarlos.sdm.ludometer.util.TimeFormat;

public class TimerActivity extends AppCompatActivity {

    private ITimer timer;
    private long startTime;
    private TextView counterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        // Busca tempo inicial do arquivo de preferencias.
        startTime = LudometerPreferences.getTimerPreference(this);

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
        findViewById(R.id.plus_time).setEnabled(false);
        findViewById(R.id.minus_time).setEnabled(false);
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
        timer = new Countdown(startTime,counterView);
        findViewById(R.id.btnPause).setEnabled(false);
        findViewById(R.id.btnReset).setEnabled(false);
        findViewById(R.id.btnStart).setEnabled(true);
        findViewById(R.id.plus_time).setEnabled(true);
        findViewById(R.id.minus_time).setEnabled(true);
        ((TextView) findViewById(R.id.countdown_timer)).setTextColor(Color.BLACK);
    }

    public String showDigitalClock (long milliseconds) {
        String digitalClock;
        int[] clock = TimeFormat.milliToTime(milliseconds);

        digitalClock = String.format("%02d:%02d",clock[1],clock[2]);

        return digitalClock;
    }

    public void onClickChangeTime (View view) {
        int button = view.getId();

        if (button == findViewById(R.id.plus_time).getId()) {
            startTime += (startTime<3595000) ? 5000 : 0;
        } else if (button == findViewById(R.id.minus_time).getId()) {
            startTime -= (startTime>5000) ? 5000 : 0;
        }

        counterView.setText(showDigitalClock(startTime));
        timer = new Countdown(startTime,counterView);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Grava ultimo tempo do cronometro utilizado.
        LudometerPreferences.setTimerPreference(this, startTime);
    }
}

