package br.edu.ifspsaocarlos.sdm.ludometer.model;

import android.os.SystemClock;
import android.widget.Chronometer;

/**
 * Cronômetro de contagem progressiva
 */
public class Stopwatch implements ITimer {
    private Chronometer chronometer;
    private long time;
    private boolean isStarted = false;

    /** Construtor
     *
     * @param chronometer recebe objeto gráfico do cronômetro
     */
    public Stopwatch(Chronometer chronometer){
        this.chronometer = chronometer;
    }

    @Override
    public void start() {
        this.time = 0;  // zera contagem
        this.chronometer.setBase(SystemClock.elapsedRealtime() - this.time);
        this.chronometer.start();
        this.isStarted = true;
    }

    @Override
    public void stop() {
        this.time = SystemClock.elapsedRealtime() - this.chronometer.getBase();
        this.chronometer.stop();
    }

    @Override
    public void resume() {
        /** Se cronômetro já estiver iniciado, continua contagem */
        if(isStarted){
            this.chronometer.setBase(SystemClock.elapsedRealtime() - this.time);
            this.chronometer.start();
        }
        /** Caso contrário, inicia contagem */
        else
            this.start();
    }

}
