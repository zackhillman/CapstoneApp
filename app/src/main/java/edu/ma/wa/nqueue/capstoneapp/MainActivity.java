package edu.ma.wa.nqueue.capstoneapp;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.startapp.android.publish.adsCommon.StartAppAd;
import com.startapp.android.publish.adsCommon.StartAppSDK;

import edu.ma.wa.nqueue.capstoneapp.Fragment.About;
import edu.ma.wa.nqueue.capstoneapp.Fragment.Exercise;
import edu.ma.wa.nqueue.capstoneapp.Fragment.Maps.Map;
import edu.ma.wa.nqueue.capstoneapp.Fragment.Logs;
import edu.ma.wa.nqueue.capstoneapp.Fragment.Profile;
import edu.ma.wa.nqueue.capstoneapp.Fragment.video;


public class MainActivity extends AppCompatActivity implements Exercise.ExerciseVideoListener {

    private StartAppAd startAppAd = new StartAppAd(this);
    private InterstitialAd interstitial;
    private BottomBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        //StartAppSDK.init(this, "Your app Id", true);
        //StartAppAd.showSplash(this, savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.frame, new Profile()).commit();
        }
        bar = (BottomBar)findViewById(R.id.bottomBar);
        bar.setOnTabSelectListener(new OnTabSelectListener() {
            public void onTabSelected(@IdRes int tabId) {
                Fragment f = new Fragment();
                if (tabId == R.id.tab_profile) {
                    f = new Profile();
                }
                if (tabId == R.id.tab_logs) {
                    f = new Logs();
                }
                if (tabId == R.id.tab_friends) {
                    f = new Map();
                }
                if (tabId == R.id.tab_exercise) {
                    f = new Exercise();
                }
                if (tabId == R.id.tab_about) {
                    f = new About();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, f).commit();
            }

        });
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-1018669573856883/9774887054");
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    public void loadVideo(int i){
        video vid = (video) getSupportFragmentManager().findFragmentById(R.id.frame);
        vid.setVideo(i);
    }


    public void displayInterstitial() {
// If Ads are loaded, show Interstitial else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }

    @Override    public void onBackPressed() {
        startAppAd.onBackPressed();
        super.onBackPressed();
    }
    @Override    public void onResume() {
        super.onResume();
        startAppAd.onResume();
    }
    @Override    public void onPause() {
        super.onPause();
        startAppAd.onPause();
    }

}