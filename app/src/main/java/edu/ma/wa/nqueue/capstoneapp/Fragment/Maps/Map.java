package edu.ma.wa.nqueue.capstoneapp.Fragment.Maps;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.gigamole.navigationtabstrip.NavigationTabStrip;

import edu.ma.wa.nqueue.capstoneapp.R;

/**
 * Created by Josh on 5/5/2017.
 */

public class Map extends Fragment {

    private NavigationTabStrip navbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_map,container,false);
        navbar = (NavigationTabStrip) v.findViewById(R.id.nts_nav);
        if (savedInstanceState == null) {
            getActivity().getSupportFragmentManager().beginTransaction().add(R.id.friendframe, new Friend()).commit();
            navbar.setTabIndex(0, true);
        }
        navbar.setOnTabStripSelectedIndexListener(new NavigationTabStrip.OnTabStripSelectedIndexListener() {
            @Override
            public void onStartTabSelected(String title, int index) {
                Fragment f = new Fragment();
                if (index == 0) {
                    f = new Friend();
                }
                if (index == 1) {
                    f = new Gym();
                }
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.friendframe, f).commit();
            }
            @Override
            public void onEndTabSelected(String title, int index) {}
        });
        return v;
    }

}

