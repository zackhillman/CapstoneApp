package edu.ma.wa.nqueue.capstoneapp.Fragment.Maps;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edu.ma.wa.nqueue.capstoneapp.PlaceJSONParser;
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

    private LatLng currentLocation;
    private double mLatitude=0, mLongitude=0;


    public static final String BASE_URL = "https://thawing-tundra-28436.herokuapp.com/services/";

    private String mPlaceType="gym";
    private String mPlaceTypeName="Gym";


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

        //mLatitude = currentLocation.latitude;
        //mLongitude = currentLocation.longitude;

        mLatitude = 42.570456;
        mLongitude = -71.419234;

        LocationManager locationManager = (LocationManager) this.getActivity().getSystemService(this.getActivity().LOCATION_SERVICE);

        StringBuilder sb = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");

        System.out.println("LATITUDE: " + mLatitude + "LONGITUDE: " + mLongitude);
        sb.append("location="+mLatitude+","+mLongitude);
        sb.append("&radius=5000");
        sb.append("&types="+mPlaceType);
        sb.append("&sensor=true");
        sb.append("&key=AIzaSyDOwxlkH52mv1OcoI7FlI999r7v7TYPFpg");

        System.out.println(sb.toString());

        PlacesTask placesTask = new PlacesTask();
        placesTask.execute(sb.toString());



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

    /** Receives a JSONObject and returns a list */
    public List<HashMap<String,String>> parse(JSONObject jObject){

        JSONArray jPlaces = null;
        try {
            /** Retrieves all the elements in the 'places' array */
            jPlaces = jObject.getJSONArray("results");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        /** Invoking getPlaces with the array of json object
         * where each json object represent a place
         */
        return getPlaces(jPlaces);
    }

    private List<HashMap<String, String>> getPlaces(JSONArray jPlaces){
        int placesCount = jPlaces.length();
        List<HashMap<String, String>> placesList = new ArrayList<HashMap<String,String>>();
        HashMap<String, String> place = null;

        /** Taking each place, parses and adds to list object */
        for(int i=0; i<placesCount;i++){
            try {
                /** Call getPlace with place JSON object to parse the place */
                place = getPlace((JSONObject)jPlaces.get(i));
                placesList.add(place);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return placesList;
    }

    private HashMap<String, String> getPlace(JSONObject jPlace){

        HashMap<String, String> place = new HashMap<String, String>();
        String placeName = "-NA-";
        String vicinity="-NA-";
        String latitude="";
        String longitude="";

        try {
            // Extracting Place name, if available
            if(!jPlace.isNull("name")){
                placeName = jPlace.getString("name");
            }

            // Extracting Place Vicinity, if available
            if(!jPlace.isNull("vicinity")){
                vicinity = jPlace.getString("vicinity");
            }

            latitude = jPlace.getJSONObject("geometry").getJSONObject("location").getString("lat");
            longitude = jPlace.getJSONObject("geometry").getJSONObject("location").getString("lng");

            place.put("place_name", placeName);
            place.put("vicinity", vicinity);
            place.put("lat", latitude);
            place.put("lng", longitude);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return place;
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

    private String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try{
            URL url = new URL(strUrl);

            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();

            // Connecting to url
            urlConnection.connect();

            // Reading data from url
            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb  = new StringBuffer();

            String line = "";
            while( ( line = br.readLine())  != null){
                sb.append(line);
            }

            data = sb.toString();

            br.close();

        }catch(Exception e){

        }finally{
            iStream.close();
            urlConnection.disconnect();
        }

        return data;
    }

    /** A class, to download Google Places */
    private class PlacesTask extends AsyncTask<String, Integer, String> {

        String data = null;

        // Invoked by execute() method of this object
        @Override
        protected String doInBackground(String... url) {
            try{
                data = downloadUrl(url[0]);
            }catch(Exception e){
                Log.d("Background Task",e.toString());
            }
            return data;
        }

        // Executed after the complete execution of doInBackground() method
        @Override
        protected void onPostExecute(String result){
            ParserTask parserTask = new ParserTask();

            // Start parsing the Google places in JSON format
            // Invokes the "doInBackground()" method of the class ParseTask
            parserTask.execute(result);
        }

    }

    private class ParserTask extends AsyncTask<String, Integer, List<HashMap<String,String>>>{

        JSONObject jObject;

        // Invoked by execute() method of this object
        @Override
        protected List<HashMap<String,String>> doInBackground(String... jsonData) {

            List<HashMap<String, String>> places = null;
            PlaceJSONParser placeJsonParser = new PlaceJSONParser();

            try{
                jObject = new JSONObject(jsonData[0]);

                /** Getting the parsed data as a List construct */
                places = placeJsonParser.parse(jObject);

            }catch(Exception e){
                Log.d("Exception",e.toString());
            }
            return places;
        }

        // Executed after the complete execution of doInBackground() method
        @Override
        protected void onPostExecute(List<HashMap<String,String>> list){

            // Clears all the existing markers
            mGoogleMap.clear();

            for(int i=0;i<list.size();i++){

                // Creating a marker
                MarkerOptions markerOptions = new MarkerOptions();

                // Getting a place from the places list
                HashMap<String, String> hmPlace = list.get(i);

                // Getting latitude of the place
                double lat = Double.parseDouble(hmPlace.get("lat"));

                // Getting longitude of the place
                double lng = Double.parseDouble(hmPlace.get("lng"));

                // Getting name
                String name = hmPlace.get("place_name");

                // Getting vicinity
                String vicinity = hmPlace.get("vicinity");

                LatLng latLng = new LatLng(lat, lng);

                // Setting the position for the marker
                markerOptions.position(latLng);

                // Setting the title for the marker.
                //This will be displayed on taping the marker
                markerOptions.title(name + " : " + vicinity);

                // Placing a marker on the touched position
                mGoogleMap.addMarker(markerOptions);
            }
        }
    }





}