package edu.ma.wa.nqueue.capstoneapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by joshu on 5/9/2017.
 */

public class exerciselistAdapter extends ArrayAdapter<String>{

    public exerciselistAdapter(Context context, String[] exercise){
        super(context, R.layout.exerciselistitem ,exercise);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflate = LayoutInflater.from(getContext());
        View customView = inflate.inflate(R.layout.exerciselistitem, parent, false);
        String exerciseItem = getItem(position);
        TextView text = (TextView) customView.findViewById(R.id.exercisetext);
        ImageView img = (ImageView) customView.findViewById(R.id.next);
        text.setText(exerciseItem);
        img.setImageResource(R.drawable.ic_navigate_next_black_24dp);
        return customView;
    }


}
