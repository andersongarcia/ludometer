package br.edu.ifspsaocarlos.sdm.ludometer.model.timers;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.widget.TextView;

import br.edu.ifspsaocarlos.sdm.ludometer.util.TimeFormat;

/**
 * Cronômetro de contagem regressiva
 */
public class Countdown implements ITimer {
    private long startTime;
    private long lastTime;
    private CountDownTimer timer;
    private TextView textView;

    /** Construtor
     * @param startTime onde deve inciar o cronômetro
     * @param tv objeto gráfico para exibição da contagem de tempo */
    public Countdown(long startTime, TextView tv){
        this.startTime = startTime;
        this.textView = tv;
    }

    @Override
    public void start() {
        this.timer = new CountDownTimer(startTime, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int[] time = TimeFormat.milliToTime(millisUntilFinished);
                textView.setText(String.format("%02d:%02d",time[1],time[2]));
                lastTime = millisUntilFinished;

                if (millisUntilFinished < 10100) {
                    textView.setTextColor(Color.RED);
                }
            }

            @Override
            public void onFinish() {
                textView.setText("00:00");
                stop();
            }
        };
        this.timer.start();
    }

    @Override
    public void stop() {
        this.timer.cancel();
        lastTime = 0;
    }

    @Override
    public void pause() {
        if (lastTime > 0) {
            startTime = lastTime;
            this.timer.cancel();
        } else {
            stop();
        }
    }

    @Override
    public void resume() {
        start();
    }

    @Override
    public void reset() {
        this.stop();
    }

    @Override
    public long getLastTime() {
        return this.lastTime;
    }
}
