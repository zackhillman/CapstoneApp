package edu.ma.wa.nqueue.capstoneapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
/**
 * Created by Andrew M on 4/27/2017.
 */

public class ExerciseListActivity extends AppCompatActivity {

    public Button ex1, ex2, ex3;

    public void init(){
        ex1 = (Button)findViewById(R.id.excersise);
        ex2 = (Button)findViewById(R.id.friends);
        ex3 = (Button)findViewById(R.id.options);
    }

    public void buttonClicked(View v) {

        if ((Button) v == ex1) {

        } else if ((Button) v == ex2) {

        } else if ((Button) v == ex3) {

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exerciselist);
        init();
    }

}
