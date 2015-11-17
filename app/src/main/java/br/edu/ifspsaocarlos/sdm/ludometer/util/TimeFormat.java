package br.edu.ifspsaocarlos.sdm.ludometer.util;

/**
 * Created by lcp on 16/11/15.
 *
 * Classe auxiliar para manipulação e conversão de
 * unidades de tempo.
 */
public class TimeFormat {

    /**
     * Método que retorna os segundos inteiros a partir
     * de milisegundos.
     *
     * @param milliseconds
     * @return seconds
     */
    public static int milliToSeconds (Long milliseconds) {
        Long secs = milliseconds/1000;
        return secs.intValue();
    }

    /**
     * Método que retorna os minutos inteiros a partir
     * de segundos.
     *
     * @param seconds
     * @return minutes
     */
    public static int secToMinutes (Integer seconds) {
        Integer mins = seconds/60;
        return mins.intValue();
    }

    /**
     * Método que retorna os minutos inteiros a partir
     * de milisegundos.
     *
     * @param milliseconds
     * @return minutes
     */
    public static int milliToMinutes (Long milliseconds) {
        return secToMinutes(milliToSeconds(milliseconds));
    }

    /**
     * Método que retorna milisegundos a partir
     * de segundos, mesmo que tenham casas decimais.
     *
     * @param seconds
     * @return milliseconds
     */
    public static long secsToMilli (Double seconds) {
        Double secs = seconds * 1000;
        return secs.longValue();
    }

    /**
     * Método que retorna os segundos a partir
     * de minutos, mesmo que tenham casas decimais.
     *
     * @param minutes
     * @return seconds
     */
    public static int minsToSeconds (Double minutes) {
        Double mins = minutes * 60;
        return mins.intValue();
    }

    /**
     * Método que retorna milisegundos a partir
     * de minutos, mesmo que tenham casas decimais.
     *
     * @param minutes
     * @return milliseconds
     */
    public static long minsToMilli (Double minutes) {
        return secsToMilli(minutes * 60);
    }

    /**
     * Método que converte o formato hora, minuto e segundo
     * para milisegundos.
     *
     * @param hours
     * @param minutes
     * @param seconds
     * @return milliseconds
     */
    public static long timeToMilli (int hours, int minutes, int seconds) {
        return ((hours * 3600) + (minutes * 60) + seconds) * 1000;
    }

    /**
     * Método que converte milisegundos para o
     * formato hora, minuto, segundo e milisegundo.
     *
     * @param milliseconds
     * @return int[hour, minute, second, milli]
     */
    public static int[] milliToTime (Long milliseconds) {
        int[] time = new int[4];
        time[3] = milliseconds.intValue() % 1000;
        time[2] = milliToSeconds(milliseconds) % 60;
        time[1] = milliToMinutes(milliseconds) % 60;
        time[0] = milliToMinutes(milliseconds) / 60;
        return time;
    }
}
