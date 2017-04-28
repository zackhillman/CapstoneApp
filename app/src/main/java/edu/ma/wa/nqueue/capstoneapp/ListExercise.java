package edu.ma.wa.nqueue.capstoneapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ListExercise extends AppCompatActivity {

    public Button Exe1, Exe2, Exe3;

    public void init(){
        Exe1 = (Button)findViewById(R.id.exercise1);
        Exe2 = (Button)findViewById(R.id.exercise2);
        Exe3 = (Button)findViewById(R.id.exercise3);
    }

    public void buttonClicked(View v){
        if((Button)v == Exe1){
            Intent next = new Intent(ListExercise.this, ExerciseVid.class);
            next.putExtra("Video","2LeOH9AGJQM");
            startActivity(next);
        }else if((Button)v == Exe2){
            Intent next = new Intent(ListExercise.this, ExerciseVid.class);
            next.putExtra("Video","Qo3fT0xPeHs");
            startActivity(next);
        }else if((Button)v == Exe3) {
            Intent next = new Intent(ListExercise.this, ExerciseVid.class);
            next.putExtra("Video","dQw4w9WgXcQ");
            startActivity(next);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_exercise);
        init();
    }
}
