package edu.ma.wa.nqueue.capstoneapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


public class ListExercise extends AppCompatActivity {

    public Button Exe1, Exe2, Exe3;
    InterstitialAd mInterstitialAd;
    private InterstitialAd interstitial;

    public void init(){
        Exe1 = (Button)findViewById(R.id.exercise1);
        Exe2 = (Button)findViewById(R.id.exercise2);
        Exe3 = (Button)findViewById(R.id.exercise3);
    }

    public void buttonClicked(View v){
        if((Button)v == Exe1){
            Intent next = new Intent(ListExercise.this, ExerciseVid.class);
            next.putExtra("Video",0);
            startActivity(next);
        }else if((Button)v == Exe2){
            Intent next = new Intent(ListExercise.this, ExerciseVid.class);
            next.putExtra("Video",1);
            startActivity(next);
        }else if((Button)v == Exe3) {
            Intent next = new Intent(ListExercise.this, ExerciseVid.class);
            next.putExtra("Video",2);
            startActivity(next);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_exercise);
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

// Prepare the Interstitial Ad
        interstitial = new InterstitialAd(ListExercise.this);
// Insert the Ad Unit ID
        interstitial.setAdUnitId(getString(R.string.admob_interstitial_id));

        interstitial.loadAd(adRequest);
// Prepare an Interstitial Ad Listener
        interstitial.setAdListener(new AdListener() {
            public void onAdLoaded() {
                // Call displayInterstitial() function
                displayInterstitial();
            }
        });
        init();
    }

    public void displayInterstitial() {
// If Ads are loaded, show Interstitial else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }
}
