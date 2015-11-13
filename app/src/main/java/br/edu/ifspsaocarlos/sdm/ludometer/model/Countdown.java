package br.edu.ifspsaocarlos.sdm.ludometer.model;

import android.os.CountDownTimer;
import android.widget.TextView;

import br.edu.ifspsaocarlos.sdm.ludometer.R;

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
        this.timer = new CountDownTimer(startAt, 0) {
            @Override
            public void onTick(long millisUntilFinished) {
                String v = String.format("%02d", millisUntilFinished/60000);
                int va = (int)( (millisUntilFinished%60000)/1000);
                textView.setText(String.format("%02d",va));
            }

            @Override
            public void onFinish() {
                textView.setText(R.string.time_over);
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
