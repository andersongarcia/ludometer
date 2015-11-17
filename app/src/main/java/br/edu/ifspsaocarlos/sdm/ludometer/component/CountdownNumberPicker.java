package br.edu.ifspsaocarlos.sdm.ludometer.component;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.NumberPicker;

/**
 * Created by lcp on 17/11/15.
 */
public class CountdownNumberPicker extends NumberPicker {

    public CountdownNumberPicker(Context context) {
        super(context);
    }

    public CountdownNumberPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CountdownNumberPicker(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        processAttributeSet(attrs);
    }

    private void processAttributeSet(AttributeSet attrs) {
        //This method reads the parameters given in the xml file and sets the properties according to it
        this.setMinValue(attrs.getAttributeIntValue(null, "min", 0));
        this.setMaxValue(attrs.getAttributeIntValue(null, "max", 0));
    }
}
