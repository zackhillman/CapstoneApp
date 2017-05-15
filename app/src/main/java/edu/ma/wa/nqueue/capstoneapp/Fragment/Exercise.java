package edu.ma.wa.nqueue.capstoneapp.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import edu.ma.wa.nqueue.capstoneapp.Fragment.Maps.Friend;
import edu.ma.wa.nqueue.capstoneapp.Fragment.Maps.Gym;
import edu.ma.wa.nqueue.capstoneapp.R;
import edu.ma.wa.nqueue.capstoneapp.exerciselistAdapter;

/**
 * Created by Josh on 5/5/2017.
 */

public class Exercise extends Fragment {


    ExerciseVideoListener activityCommander;

    public interface ExerciseVideoListener{
        public void loadVideo(int i);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            activityCommander = (ExerciseVideoListener) context;
        }catch(ClassCastException e){
            throw new ClassCastException(context.toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_exercise,container,false);
        String[] workout = {"Preacher Curl", "Squats", "Dumbbell Bench Press"};
        ListAdapter adapt = new exerciselistAdapter(getActivity(), workout);
        ListView listview = (ListView) v.findViewById(R.id.list);
        listview.setAdapter(adapt);
        listview.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                        Fragment f = new Fragment();
                        f = new video();
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame, f, "vid").commit();
                        getActivity().getSupportFragmentManager().executePendingTransactions();
                        activityCommander.loadVideo(position);
                    }
                }
        );
        return v;
    }

}

