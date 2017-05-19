package edu.ma.wa.nqueue.capstoneapp.Fragment.Maps;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import edu.ma.wa.nqueue.capstoneapp.Fragment.video;
import edu.ma.wa.nqueue.capstoneapp.R;
import edu.ma.wa.nqueue.capstoneapp.Server.MyApiEndpointInterface;
import edu.ma.wa.nqueue.capstoneapp.Server.MyLocation;
import edu.ma.wa.nqueue.capstoneapp.exerciselistAdapter;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Josh on 5/5/2017.
 */

public class Friend extends Fragment implements OnMapReadyCallback{

    private GoogleMap mGoogleMap;
    private MapView mMapView;
    private View mView;
    private LatLng currentLocation;

    public static final String BASE_URL = "https://thawing-tundra-28436.herokuapp.com/services/";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_friends, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        mMapView = (MapView) mView.findViewById(R.id.mapfriend);
        if (mMapView != null) {
            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);
        }

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());

        mGoogleMap = googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        if(ActivityCompat.checkSelfPermission(this.getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, PackageManager.PERMISSION_GRANTED); // if the permission wasn't granted so ask for permission
            return;
        }
        if(ActivityCompat.checkSelfPermission(this.getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PackageManager.PERMISSION_GRANTED);
            return;
        }

        LocationManager locationManager = (LocationManager) this.getActivity().getSystemService(this.getActivity().LOCATION_SERVICE);

        Criteria criteria = new Criteria();
        String provider;
        provider = locationManager.getBestProvider(criteria, true);
        Location myLocation = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);

        currentLocation = new LatLng(myLocation.getLatitude(), myLocation.getLongitude());

        CameraPosition camera = CameraPosition.builder().target(currentLocation).zoom(16).bearing(0).tilt(45).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(camera));

        googleMap.setMyLocationEnabled(true);

        //currentLocation = new LatLng(42.577716, -71.463516);
        LatLng andrewmLoc = new LatLng(42.580779, -71.438177);
        LatLng zackLoc = new LatLng(42.545363, -71.401021);
        LatLng derenLoc = new LatLng(42.557553, -71.462112);
        LatLng tahaLoc = new LatLng(42.570456, -71.419234);
        LatLng benLoc = new LatLng(42.600383, -71.489186);
        LatLng andrewLoc = new LatLng(42.565836, -71.425987);

        googleMap.addMarker(new MarkerOptions().position(andrewmLoc).title("Andrew Markoski"));
        googleMap.addMarker(new MarkerOptions().position(zackLoc).title("Zack Hillman"));
        googleMap.addMarker(new MarkerOptions().position(derenLoc).title("Deren Singh"));
        googleMap.addMarker(new MarkerOptions().position(tahaLoc).title("Taha Rangwala"));
        googleMap.addMarker(new MarkerOptions().position(benLoc).title("Ben Pazienza"));
        googleMap.addMarker(new MarkerOptions().position(andrewLoc).title("Andrew Hartnett"));

        //CameraPosition camera = CameraPosition.builder().target(currentLocation).zoom(16).bearing(0).tilt(45).build();
        //googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(camera));
    }
}
