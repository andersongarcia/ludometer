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

    static SharedPreferences getSp (Activity activity) {
        return activity.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static long getTimerPreference (Activity activity) {
        return getSp(activity).getLong(TIMER_START_TIME, 30000);
    }

    public static void setTimerPreference (Activity activity, long startTime) {
        SharedPreferences.Editor ed = getSp(activity).edit();
        ed.putLong(TIMER_START_TIME, startTime);
        ed.commit();
    }
}
