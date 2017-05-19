package edu.ma.wa.nqueue.capstoneapp.Fragment;

import android.content.Context;
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

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import edu.ma.wa.nqueue.capstoneapp.R;
import edu.ma.wa.nqueue.capstoneapp.Server.Log;
import edu.ma.wa.nqueue.capstoneapp.Server.MyApiEndpointInterface;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Josh on 5/5/2017.
 */

public class Logs extends Fragment {

    public static final String BASE_URL = "https://thawing-tundra-28436.herokuapp.com/services/";
    public String selectedDate;

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_logs,container,false);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE|WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        final CalendarView calendar = (CalendarView) v.findViewById(R.id.calendar1);

        final Button saveButton = (Button)v.findViewById(R.id.saveButton);

        final TextView eventText = (TextView)v.findViewById(R.id.eventText);
       // final HashMap<String,CharSequence> eventMap = new HashMap<String,CharSequence>();
        
    //    eventMap.put("05/15/2017","Test Event");
        final SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy");
        String currentDate = sdf.format(new Date(calendar.getDate()));
        selectedDate = sdf.format(new Date(calendar.getDate()));









        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //   eventMap.put(selectedDate,eventText.getText());


            try {
                FileOutputStream fos = getActivity().openFileOutput(selectedDate, Context.MODE_PRIVATE);
                fos.write(eventText.getText().toString().getBytes());
                fos.close();
         //       getActivity().fileList();
            }catch (Exception e){

            }


            }
        });


        calendar.setOnDateChangeListener(new OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int day) {
                DecimalFormat df = new DecimalFormat("00");
                selectedDate = df.format(month+1) +"" + df.format(day)+""  + year;

                StringBuffer datax = new StringBuffer("");
                try {
                    FileInputStream fIn = getActivity().openFileInput ( selectedDate ) ;
                    InputStreamReader isr = new InputStreamReader ( fIn ) ;
                    BufferedReader buffreader = new BufferedReader ( isr ) ;

                    String readString = buffreader.readLine ( ) ;
                    while ( readString != null ) {
                        datax.append(readString);
                        readString = buffreader.readLine ( ) ;
                    }

                    isr.close ( ) ;
                    fIn.close();
                } catch ( IOException ioe ) {
                    ioe.printStackTrace ( ) ;
                }
                eventText.setText(datax.toString());


                Toast.makeText(getActivity().getApplicationContext(), selectedDate, Toast.LENGTH_LONG).show();


            }
        });



        return v;
    }

}