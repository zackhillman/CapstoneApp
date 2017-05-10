package edu.ma.wa.nqueue.capstoneapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by joshu on 5/10/2017.
 */

public class contactlistAdapter extends ArrayAdapter<String> {

    public contactlistAdapter(Context context, String[] contact){
        super(context, R.layout.contactlistitem , contact);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflate = LayoutInflater.from(getContext());
        View customView = inflate.inflate(R.layout.contactlistitem, parent, false);
        String exerciseItem = getItem(position);
        TextView text = (TextView) customView.findViewById(R.id.contacttext);
        ImageView img = (ImageView) customView.findViewById(R.id.nextcont);
        text.setText(exerciseItem);
        img.setImageResource(R.drawable.ic_navigate_next_black_24dp);
        return customView;
    }
}
