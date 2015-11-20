package br.edu.ifspsaocarlos.sdm.ludometer.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by lcp on 19/11/15.
 *
 * Classe auxiliar para leitura e gravação de SharedPreferences.
 */
public class LudometerPreferences {

    private final static String PREF_NAME = "LudometerPreferences";
    private final static String TIMER_START_TIME = "TimerStartTime";
    public final static String NUMBER_OF_DICES = "NumberOfDices";

    /**
     * Permite o acesso às preferências do aplicativo.
     *
     * @param activity de origem
     * @return SharedPreferences PREF_NAME
     */
    static SharedPreferences getSp (Activity activity) {
        return activity.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    /**
     * Busca o tempo inicial para a origem da contagem regressiva.
     *
     * @param activity de origem
     * @return TIMER_START_TIME em milissegundos (30s por padrão)
     */
    public static long getTimerPreference (Activity activity) {
        return getSp(activity).getLong(TIMER_START_TIME, 30000);
    }

    /**
     * Grava o último tempo inicial ajustado na contagem regressiva.
     *
     * @param activity de origem
     * @param startTime em milissegundos
     */
    public static void setTimerPreference (Activity activity, long startTime) {
        SharedPreferences.Editor ed = getSp(activity).edit();
        ed.putLong(TIMER_START_TIME, startTime);
        ed.commit();
    }

    /**
     * Busca o número de dados utilizados pela última vez.
     *
     * @param activity de origem
     * @return NUMBER_OF_DICES (6 dados por padrão)
     */
    public static int getNumberOfDices(Activity activity){
        return getSp(activity).getInt(NUMBER_OF_DICES, 6);
    }

    /**
     * Grava o número de dados utilizados pela última vez.
     *
     * @param activity de origem
     * @param numberOfDices
     */
    public static void setNumberOfDices (Activity activity, int numberOfDices) {
        SharedPreferences.Editor ed = getSp(activity).edit();
        ed.putInt(NUMBER_OF_DICES, numberOfDices);
        ed.commit();
    }
}
