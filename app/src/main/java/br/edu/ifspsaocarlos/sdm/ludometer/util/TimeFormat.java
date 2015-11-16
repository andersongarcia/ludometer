package br.edu.ifspsaocarlos.sdm.ludometer.util;

/**
 * Created by lcp on 16/11/15.
 */
public class TimeFormat {

    public static int milliToSeconds (Long milliseconds) {
        Long secs = milliseconds/1000;
        return secs.intValue();
    }

    public static int secToMinutes (Integer seconds) {
        Integer mins = seconds/60;
        return mins.intValue();
    }

    public static int milliToMinutes (Long milliseconds) {
        return secToMinutes(milliToSeconds(milliseconds));
    }
}
