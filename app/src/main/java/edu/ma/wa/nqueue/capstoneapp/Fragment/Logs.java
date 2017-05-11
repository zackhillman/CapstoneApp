package edu.ma.wa.nqueue.capstoneapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.Toast;

import edu.ma.wa.nqueue.capstoneapp.R;

/**
 * Created by Josh on 5/5/2017.
 */

public class Logs extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_logs,container,false);
        CalendarView calendar = (CalendarView) v.findViewById(R.id.calendar1);

        calendar.setOnDateChangeListener(new OnDateChangeListener() {
             @Override
             public void onSelectedDayChange(CalendarView view, int year, int month, int day) {
                 Toast.makeText(getActivity().getApplicationContext(), day + "/" + month + "/" + year, Toast.LENGTH_LONG).show();
             }
         });



//                 calendar.setOnClickListener(new CalendarView.OnDateChangeListener(){
//
//            @Override
//            public void onSelectedDayChange(CalendarView view, int year, int month, int dayofMonth){
//                Toast.makeText(getContext(),"Selected date "+dayofMonth+"/"+month+year, Toast.LENGTH_LONG).show();
//            }
//        });



        return v;
    }

}