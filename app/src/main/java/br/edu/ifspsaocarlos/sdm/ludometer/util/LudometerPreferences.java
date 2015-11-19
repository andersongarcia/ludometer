package br.edu.ifspsaocarlos.sdm.ludometer.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by lcp on 19/11/15.
 */
public class LudometerPreferences {

    private final static String PREF_NAME = "LudometerPreferences";
    private final static String TIMER_START_TIME = "TimerStartTime";

    public static long getTimerPreference (Activity activity) {
        SharedPreferences sp = activity.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sp.getLong(TIMER_START_TIME,30000);
    }
}
