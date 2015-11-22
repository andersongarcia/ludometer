package br.edu.ifspsaocarlos.sdm.ludometer.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import br.edu.ifspsaocarlos.sdm.ludometer.R;

public class CircularAdapter extends BaseAdapter {
    private static LayoutInflater inflater;
    private Integer[] colorPalette;
    private static View viewHolder;

    public CircularAdapter(Context c, Integer[] colors) {
        CircularAdapter.inflater = LayoutInflater.from(c);
        this.colorPalette = colors;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Object getItem(int position) {
        // you can do your own tricks here. to let it display the right item in your array.
        return position % colorPalette.length;
    }

    @Override
    public long getItemId(int position) {
        return position;
        // return position % colorPalette.length;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.roulette_cell, null);
            viewHolder = convertView.findViewById(R.id.rouletteBar);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (View) convertView.getTag();
        }

        viewHolder.setBackgroundColor(this.colorPalette[position % colorPalette.length]);
        viewHolder.setMinimumHeight(parent.getHeight() / 3);
        return convertView;
    }

}
