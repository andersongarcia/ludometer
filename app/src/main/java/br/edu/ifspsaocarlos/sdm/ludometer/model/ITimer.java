package br.edu.ifspsaocarlos.sdm.ludometer.model;

/**
 * Interface para temporizador genérico
 */
public interface ITimer {
    /** zera cronômetro e inicia a contagem */
    void start();
    /** interrompe a contagem */
    void stop();
    /** reinicia a contagem */
    void resume();
}
