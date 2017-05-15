package edu.ma.wa.nqueue.capstoneapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import edu.ma.wa.nqueue.capstoneapp.R;

/**
 * Created by Josh on 5/5/2017.
 */

public class Logs extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_logs,container,false);
        final CalendarView calendar = (CalendarView) v.findViewById(R.id.calendar1);

        final Button saveButton = (Button)v.findViewById(R.id.saveButton);

        final TextView eventText = (TextView)v.findViewById(R.id.eventText);
        final HashMap<String,CharSequence> eventMap = new HashMap<String,CharSequence>();
        eventMap.put("5/15/2017","Test Event");

        calendar.setOnDateChangeListener(new OnDateChangeListener() {
             @Override
             public void onSelectedDayChange(CalendarView view, int year, int month, int day) {
                 final String dateString = (month+1)+"/"+day+"/"+year;
                 Toast.makeText(getActivity().getApplicationContext(), dateString, Toast.LENGTH_LONG).show();
                 if(eventMap.get(dateString)!=null){
                     eventText.setText(eventMap.get(dateString));
                 }
                 else{
                     eventText.setText("");
                 }
                 saveButton.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View view) {
                         eventMap.put(dateString,eventText.getText());
                     }
                 });
             }
         });



//        public void buttonOnClick(View v){
//            if((Button) v == saveButton){
//
//            }
        return v;
    }

}