package edu.ma.wa.nqueue.capstoneapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
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
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE|WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        final CalendarView calendar = (CalendarView) v.findViewById(R.id.calendar1);

        final Button saveButton = (Button)v.findViewById(R.id.saveButton);

        final TextView eventText = (TextView)v.findViewById(R.id.eventText);
        final HashMap<String,CharSequence> eventMap = new HashMap<String,CharSequence>();
        eventMap.put("05/15/2017","Test Event");
        final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String currentDate = sdf.format(new Date(calendar.getDate()));
        eventText.setText(eventMap.get(currentDate));
        if(eventMap.get(currentDate)!=null){
            eventText.setText(eventMap.get(currentDate));
        }
        else{
            eventText.setText("");
            //Toast.makeText(getActivity().getApplicationContext(), currentDate, Toast.LENGTH_LONG).show();
        }
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String selectedDate = sdf.format(new Date(calendar.getDate()));
                eventMap.put(selectedDate,eventText.getText());
            }
        });


        calendar.setOnDateChangeListener(new OnDateChangeListener() {
             @Override
             public void onSelectedDayChange(CalendarView view, int year, int month, int day) {
                 final String selectedDate = sdf.format(new Date(calendar.getDate()));
                 //Toast.makeText(getActivity().getApplicationContext(), selectedDate, Toast.LENGTH_LONG).show();
                 if(eventMap.get(selectedDate)!=null){
                     eventText.setText(eventMap.get(selectedDate));
                 }
                 else{
                     eventText.setText("");
                 }

             }
         });

        return v;
    }

}