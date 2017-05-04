package edu.ma.wa.nqueue.capstoneapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

//import nqueue.wa.ma.edu.tictactoe.R;

public class Calendar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        MaterialCalendarView materialCalendarView = (MaterialCalendarView)findViewById(R.id.calendarView);
    }
}
