package edu.ma.wa.nqueue.capstoneapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;

import org.w3c.dom.Text;

import edu.ma.wa.nqueue.capstoneapp.Exercises;
import edu.ma.wa.nqueue.capstoneapp.R;
import edu.ma.wa.nqueue.capstoneapp.exerciselistAdapter;

/**
 * Created by joshu on 5/9/2017.
 */


public class video extends Fragment implements YouTubePlayer.OnInitializedListener {

    private static final int RECOVERY_REQUEST = 1;
    private static final String YOUTUBE_API_KEY = "AIzaSyCd5PvfLc-NhemmBBkgQ9F3MAzQ-fV2gCQ";
    private int exerciseNum;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_video,container,false);
        view = v;


        YouTubePlayerSupportFragment youtubePlayerFragment = new YouTubePlayerSupportFragment();
        youtubePlayerFragment.initialize(YOUTUBE_API_KEY, this);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_fragment, youtubePlayerFragment);
        fragmentTransaction.commit();

        return v;
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored) {
            player.cueVideo(Exercises.linkList[exerciseNum]);
            player.setShowFullscreenButton(false);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(getActivity(), RECOVERY_REQUEST).show();
        } else {
            String error = String.format(getString(R.string.player_error), errorReason.toString());
            Toast.makeText(getActivity(), error, Toast.LENGTH_LONG).show();
        }
    }

    public void setVideo(int i){
        exerciseNum = i;

        String[] workout = Exercises.tutList[exerciseNum].getStep();
        ListAdapter adapt = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, workout );
        ListView listview = (ListView) view.findViewById(R.id.liststeps);
        listview.setAdapter(adapt);
    }


}
