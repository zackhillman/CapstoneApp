package edu.ma.wa.nqueue.capstoneapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button Exercises, findFriends, Options;

    public void init(){
        Exercises = (Button)findViewById(R.id.excersise);
        findFriends = (Button)findViewById(R.id.friends);
        Options = (Button)findViewById(R.id.options);
    }

    public void buttonClicked(View v){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
