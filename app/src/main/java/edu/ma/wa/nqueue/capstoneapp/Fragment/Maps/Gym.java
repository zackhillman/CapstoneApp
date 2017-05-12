package edu.ma.wa.nqueue.capstoneapp.Fragment.Maps;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;

import edu.ma.wa.nqueue.capstoneapp.R;
import edu.ma.wa.nqueue.capstoneapp.Server.MyApiEndpointInterface;
import edu.ma.wa.nqueue.capstoneapp.Server.MyLocation;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Josh on 5/5/2017.
 */
public class Gym extends Fragment implements OnMapReadyCallback, LocationListener{

    public static final String MAPAPI = "AIzaSyD7iGEodKADPTBvzkY2g8a4xhpUsPWj_XQ";
    private GoogleMap mGoogleMap;
    private MapView mMapView;
    private View mView;

    public MyLocation[] locs = null;

    private LatLng currentLocation;
    public static final String BASE_URL = "https://thawing-tundra-28436.herokuapp.com/services/";



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_gym, container, false);
        return mView;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mMapView = (MapView) mView.findViewById(R.id.map);
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

        currentLocation = new LatLng(42.570456, -71.419234);

        LatLng boost = new LatLng(42.570456, -71.419234);
        LatLng koko = new LatLng(42.566434, -71.422394);
        LatLng westfit = new LatLng(42.578005, -71.396997);
        LatLng regency = new LatLng(42.563796, -71.430486);
        LatLng fitnessTogether = new LatLng(42.554261, -71.447419);


        if(locs!=null) {
            for (int i = 0; i < locs.length; i++) {
                LatLng pos = new LatLng(locs[i].getLongitude(), locs[i].getLatitude());
                String title = locs[i].getName();
                googleMap.addMarker(new MarkerOptions().position(pos).title(title));
            }
        }

        googleMap.addMarker(new MarkerOptions().position(boost).title("Boost Fitness"));
        googleMap.addMarker(new MarkerOptions().position(koko).title("Koko FitClub"));
        googleMap.addMarker(new MarkerOptions().position(westfit).title("WestFit"));
        googleMap.addMarker(new MarkerOptions().position(regency).title("Westford Regency"));
        googleMap.addMarker(new MarkerOptions().position(fitnessTogether).title("Fitness Together"));

       if(ActivityCompat.checkSelfPermission(this.getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, PackageManager.PERMISSION_GRANTED); // if the permission wasn't granted so ask for permission
            return;
        }
        if(ActivityCompat.checkSelfPermission(this.getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PackageManager.PERMISSION_GRANTED);
            return;
        }

        googleMap.setMyLocationEnabled(true);

        CameraPosition camera = CameraPosition.builder().target(currentLocation).zoom(16).bearing(0).tilt(45).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(camera));


    }

    @Override
    public void onLocationChanged(Location location) {
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        currentLocation = new LatLng(location.getLatitude(), location.getLongitude());
        Marker marker;
        marker = mGoogleMap.addMarker(new MarkerOptions().position(currentLocation).title("Current MyLocation"));

        CameraPosition camera = CameraPosition.builder().target(currentLocation).zoom(16).bearing(0).tilt(45).build();
        mGoogleMap.moveCamera(CameraUpdateFactory.newCameraPosition(camera));
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}