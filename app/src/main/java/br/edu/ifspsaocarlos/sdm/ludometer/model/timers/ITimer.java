package br.edu.ifspsaocarlos.sdm.ludometer.model.timers;

/**
 * Interface para temporizador genérico
 */
public interface ITimer {
    /** inicia uma nova contagem */
    void start();
    /** termina a contagem */
    void stop();
    /** interrompe a contagem */
    void pause();
    /** reinicia a contagem */
    void resume();
    /** retorna tempo restante */
    long getLastTime();
}
