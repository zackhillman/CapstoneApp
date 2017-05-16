package edu.ma.wa.nqueue.capstoneapp.Fragment.Maps;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import edu.ma.wa.nqueue.capstoneapp.Fragment.video;
import edu.ma.wa.nqueue.capstoneapp.R;
import edu.ma.wa.nqueue.capstoneapp.exerciselistAdapter;

/**
 * Created by Josh on 5/5/2017.
 */

public class Friend extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_friends,container,false);
        String[] contact = {"Andrew Hartnett", "Josh Vasilevsky", "Zack Hillman"};
        ListAdapter adapt = new exerciselistAdapter(getActivity(), contact);
        ListView listview = (ListView) v.findViewById(R.id.listfriend);
        listview.setAdapter(adapt);
        listview.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                        Fragment f = new Fragment();
                        if (position == 0) {
                            f = new Gym();
                        }
                        if (position == 1) {
                            f = new Gym();
                        }
                        if (position == 1) {
                            f = new Gym();
                        }
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.friendframe, f).commit();
                    }
                }
        );
        return v;
    }

}
