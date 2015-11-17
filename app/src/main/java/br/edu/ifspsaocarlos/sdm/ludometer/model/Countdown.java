package br.edu.ifspsaocarlos.sdm.ludometer.model;

import android.os.CountDownTimer;
import android.widget.TextView;

import br.edu.ifspsaocarlos.sdm.ludometer.R;
import br.edu.ifspsaocarlos.sdm.ludometer.util.TimeFormat;

/*
 * Chronômetro de contagem regressiva
 */
public class Countdown implements ITimer {
    private long startAt;
    private CountDownTimer timer;
    private TextView textView;

    /** Construtor
     * @param startAt onde deve inciar o cronômetro
     * @param tv objeto gráfico para exibição da contagem de tempo */
    public Countdown(long startAt, TextView tv){
        this.startAt = startAt;
        this.textView = tv;
    }

    @Override
    public void start() {
        this.timer = new CountDownTimer(startAt, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int[] time = TimeFormat.milliToTime(millisUntilFinished);
                textView.setText(String.format("%02d:%02d",time[1],time[2]));
            }

            @Override
            public void onFinish() {
                textView.setText(R.string.times_up);
            }
        };
        this.timer.start();
    }

    @Override
    public void stop() {
        this.timer.cancel();
    }

    @Override
    public void resume() {
        this.timer.start();
    }
}
