package com.example.rizki.talentbdgproject.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rizki.talentbdgproject.R;
import com.example.rizki.talentbdgproject.models.Geometry;
import com.example.rizki.talentbdgproject.models.ResultResponse;
import com.example.rizki.talentbdgproject.models.Results;
import com.example.rizki.talentbdgproject.rest.ApiClient;
import com.example.rizki.talentbdgproject.rest.ApiInterface;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import Modules.DirectionFinder;
import Modules.DirectionFinderListener;
import Modules.Route;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener, DirectionFinderListener {

    private double lat, lng;
    private String nama, origin;

    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    private static final String TAG = MapsActivity.class.getSimpleName();
    private static final String API_SERVER = "AIzaSyAgEFGPZOkByzfuzNJENiJaNapt_ufuezs";
    private GoogleMap mMap;
    GoogleApiClient googleApiClient;
    Location lastLocation;
    Marker currentLocationMarker;
    LocationRequest locationRequest;

    private List<Polyline> polylinePaths = new ArrayList<>();
    private List<Marker> originMarkers = new ArrayList<>();
    private List<Marker> destinationMarkers = new ArrayList<>();
    private List<Results> resultsList = new ArrayList<>();
    private List<Results> restaurant = new ArrayList<>();
    private List<Results> spbu = new ArrayList<>();
    private List<Results> mesjid = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            checkLocationPermission();
        }

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            lat = bundle.getDouble("lat");
            lng = bundle.getDouble("lng");
            nama = bundle.getString("lokasi");
        }

        Button btnCari = findViewById(R.id.findWay);
        btnCari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();
            }
        });

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /*private void requestLastLocation(){
        if (ContextCompat.checkSelfPermission (this,
                Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED )
        {
            //belum ada ijin, tampilkan dialog
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION},
                    MY_PERMISSIONS_REQUEST_LOCATION);
            return;
        }

        lastLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);

        if (lastLocation != null){
            origin = Double.toString(lastLocation.getLatitude()) + "," + Double.toString(lastLocation.getLongitude());
        }
    }*/


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera

        /*mMap.setMyLocationEnabled(true);*/

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) ==
                    PackageManager.PERMISSION_GRANTED){
                buildGoogleApiClient();

                LatLng mark = new LatLng(lat, lng);
                mMap.addMarker(new MarkerOptions().position(mark).title("Lokasi Wisata "+nama));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mark, 17));
                mMap.setMyLocationEnabled(true);
            }
        }
        else {
            buildGoogleApiClient();

            LatLng mark = new LatLng(lat, lng);
            mMap.addMarker(new MarkerOptions().position(mark).title("Lokasi Wisata "+nama));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mark, 17));
            mMap.setMyLocationEnabled(true);
        }
    }

    protected synchronized void buildGoogleApiClient(){
        googleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        googleApiClient.connect();
    }

    @Override
    public void onLocationChanged(Location location) {
        lastLocation = location;
        origin = Double.toString(lastLocation.getLatitude()) + "," + Double.toString(lastLocation.getLongitude());

        if (currentLocationMarker != null){
            currentLocationMarker.remove();
        }

        LatLng current = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(current);
        markerOptions.title("I'm Here!");
        currentLocationMarker = mMap.addMarker(markerOptions);

//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(current, 15));

        if (googleApiClient != null){
            LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient, this);
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        locationRequest = new LocationRequest();
        locationRequest.setInterval(1000);
        locationRequest.setFastestInterval(1000);
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, this);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    protected void onStart() {
        super.onStart();
//        googleApiClient.connect();
    }

    @Override
    protected void onStop() {
//        googleApiClient.disconnect();
        super.onStop();
    }

    public boolean checkLocationPermission(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_COARSE_LOCATION)){
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
                googleApiClient.connect();
            }
            else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
                googleApiClient.connect();
            }
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                        if (googleApiClient == null){
                            buildGoogleApiClient();
                        }
                        mMap.setMyLocationEnabled(true);
                    }
                }
                else {
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void sendRequest() {
        if (ActivityCompat.checkSelfPermission (this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED ){
            //belum ada ijin, tampilkan dialog
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION},
                    MY_PERMISSIONS_REQUEST_LOCATION);
            return;
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            lastLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
        }

        origin = Double.toString(lastLocation.getLatitude()) + "," + Double.toString(lastLocation.getLongitude());

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<ResultResponse> call = apiService.getNearbyResults("atm", origin, 2000, API_SERVER);
        Call<ResultResponse> calling = apiService.getNearbyResults("restaurant", origin, 2000, API_SERVER);
        Call<ResultResponse> called = apiService.getNearbyResults("gas_station", origin, 2000, API_SERVER);
        Call<ResultResponse> panggil = apiService.getNearbyResults("mosque", origin, 2000, API_SERVER);

        call.enqueue(new Callback<ResultResponse>() {
            @Override
            public void onResponse(Call<ResultResponse> call, Response<ResultResponse> response) {
                resultsList = response.body().getResultsList();
                addMarker(resultsList, 0);
//                Log.d(TAG, "onResponse: "+resultsList.size());
//                Log.d(TAG, "onResponse: "+origin);
            }

            @Override
            public void onFailure(Call<ResultResponse> call, Throwable t) {
                Log.d("Log:", t.toString());
            }
        });

        calling.enqueue(new Callback<ResultResponse>() {
            @Override
            public void onResponse(Call<ResultResponse> call, Response<ResultResponse> response) {
                restaurant = response.body().getResultsList();
                addMarker(restaurant, 1);
            }

            @Override
            public void onFailure(Call<ResultResponse> call, Throwable t) {
                Log.d("Log:", t.toString());
            }
        });

        called.enqueue(new Callback<ResultResponse>() {
            @Override
            public void onResponse(Call<ResultResponse> call, Response<ResultResponse> response) {
                spbu = response.body().getResultsList();
                addMarker(spbu, 2);
            }

            @Override
            public void onFailure(Call<ResultResponse> call, Throwable t) {
                Log.d("Log:", t.toString());
            }
        });

        panggil.enqueue(new Callback<ResultResponse>() {
            @Override
            public void onResponse(Call<ResultResponse> call, Response<ResultResponse> response) {
                mesjid = response.body().getResultsList();
                addMarker(mesjid, 3);
            }

            @Override
            public void onFailure(Call<ResultResponse> call, Throwable t) {
                Log.d("Log:", t.toString());
            }
        });

        String destination = Double.toString(lat) + "," + Double.toString(lng);
        try {
            new DirectionFinder(this, origin, destination).execute();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void addMarker(List<Results> list, int choose){
        for (Results results : list){
            Geometry geometry = results.getGeometry();
            com.example.rizki.talentbdgproject.models.Location loc = geometry.getLocation();

            LatLng current = new LatLng(Double.valueOf(loc.getLat()), Double.valueOf(loc.getLng()));
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(current);
            markerOptions.title(results.getName()+" di "+results.getVicinity());

            if (choose == 0){
                markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.atm));
            }
            else if (choose == 1){
                markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.resto));
            }
            else if (choose == 2){
                markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.gas));
            }
            else if (choose == 3){
                markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.mesjid));
            }

            currentLocationMarker = mMap.addMarker(markerOptions);
        }
    }

    @Override
    public void onDirectionFinderStart() {

        if (originMarkers != null) {
            for (Marker marker : originMarkers) {
                marker.remove();
            }
        }

        if (destinationMarkers != null) {
            for (Marker marker : destinationMarkers) {
                marker.remove();
            }
        }

        if (polylinePaths != null) {
            for (Polyline polyline:polylinePaths ) {
                polyline.remove();
            }
        }
    }

    @Override
    public void onDirectionFinderSuccess(List<Route> routes) {
//        List<Polyline> polylinePaths = new ArrayList<>();
//        List<Marker> originMarkers = new ArrayList<>();
//        List<Marker> destinationMarkers = new ArrayList<>();

        for (Route route : routes) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(route.startLocation, 16));
            ((TextView) findViewById(R.id.tvDuration)).setText(route.duration.text);
            ((TextView) findViewById(R.id.tvDistance)).setText(route.distance.text);

            originMarkers.add(mMap.addMarker(new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.start_blue))
                    .title(route.startAddress)
                    .position(route.startLocation)));
            destinationMarkers.add(mMap.addMarker(new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.end_green))
                    .title(route.endAddress)
                    .position(route.endLocation)));

            PolylineOptions polylineOptions = new PolylineOptions()
                    .geodesic(true)
                    .color(R.color.colorPrimaryDark)
                    .width(15);

            for (int i = 0; i < route.points.size(); i++)
                polylineOptions.add(route.points.get(i));

            polylinePaths.add(mMap.addPolyline(polylineOptions));
        }
    }
}
