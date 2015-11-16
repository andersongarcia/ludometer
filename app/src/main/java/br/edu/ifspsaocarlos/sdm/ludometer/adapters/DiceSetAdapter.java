package br.edu.ifspsaocarlos.sdm.ludometer.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.List;

import br.edu.ifspsaocarlos.sdm.ludometer.R;
import br.edu.ifspsaocarlos.sdm.ludometer.model.GeneralDice;
import br.edu.ifspsaocarlos.sdm.ludometer.model.Raffle;

public class DiceSetAdapter extends ArrayAdapter<Raffle> {
    private LayoutInflater inflator;
    public DiceSetAdapter(Activity activity, List<Raffle> list) {
        super(activity, R.layout.dice_cell, list);
        inflator = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){
            // infla nova celula
            convertView = inflator.inflate(R.layout.dice_cell, null);
            holder = new ViewHolder();
            holder.image_dice = (ImageView)convertView.findViewById(R.id.img_dice);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        GeneralDice dice = (GeneralDice) getItem(position);
        holder.image_dice.setImageResource(getImageResourceId(dice.getResult()));
        return convertView;
    }

    private int getImageResourceId(int position){
        return getContext().getResources().getIdentifier("drawable/dado_" + (position+1),
                null, getContext().getPackageName());
    }

    static class ViewHolder {
        public ImageView image_dice;
    }
}
