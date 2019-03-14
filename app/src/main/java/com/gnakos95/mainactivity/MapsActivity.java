package com.gnakos95.mainactivity;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, OnMarkerClickListener {

    private GoogleMap mMap;
    ArrayList<Integer> selectedPositions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        selectedPositions = (ArrayList<Integer>) getIntent().getSerializableExtra("selectedPositions");

        if(selectedPositions.contains(10)){
            Button button = (Button)findViewById(R.id.button9);
            button.setText("Information about the places");
        }
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        init();
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    LatLng konitsa = new LatLng(40.036589, 20.745182);
    LatLng zagori = new LatLng(39.95792,20.81017);
    LatLng vikos = new LatLng(39.951261, 20.708287);
    LatLng molivdoskepasti = new LatLng(40.067758,20.569553);
    LatLng papigo = new LatLng(39.970483,20.718826);

    int[] flag = {0, 0, 0, 0, 0, 9};

    @Override

    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        // Add a marker
        if(selectedPositions.contains(10)){
            flag[5]=0;
            if(selectedPositions.contains(3)){
                mMap.addMarker(new MarkerOptions().position(zagori).title("Zagori"));
            }
            if (selectedPositions.contains(5) || selectedPositions.contains(1)) {
                mMap.addMarker(new MarkerOptions().position(konitsa).title("Konitsa"));

            }
            if (selectedPositions.contains(4) || selectedPositions.contains(1)) {
                mMap.addMarker(new MarkerOptions().position(vikos).title("Vikos"));
                mMap.addMarker(new MarkerOptions().position(papigo).title("Papigo"));
            }
            if(selectedPositions.contains(2)){
                mMap.addMarker(new MarkerOptions().position(molivdoskepasti).title("Molivdoskepastos"));
            }
        }else{
            if(selectedPositions.contains(3)){
                mMap.addMarker(new MarkerOptions().position(zagori).title("Ζαγόρι"));
            }

            if (selectedPositions.contains(5) || selectedPositions.contains(1)) {
                mMap.addMarker(new MarkerOptions().position(konitsa).title("Κόνιτσα"));

            }
            if (selectedPositions.contains(4) || selectedPositions.contains(1)) {
                mMap.addMarker(new MarkerOptions().position(vikos).title("Βίκος"));
                mMap.addMarker(new MarkerOptions().position(papigo).title("Πάπιγκο"));

            }
            if(selectedPositions.contains(2)){
                mMap.addMarker(new MarkerOptions().position(molivdoskepasti).title("Μολυβδοσκέπαστος"));
            }
        }



        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(konitsa, 7));
        mMap.setOnMarkerClickListener(this);
    }

    public boolean onMarkerClick(final Marker marker) {

        if (marker.getTitle().equals("Konitsa")||marker.getTitle().equals("Κόνιτσα") ) {
            marker.hideInfoWindow();
            if (flag[4] == 0) {
                flag[4] = 1;
                marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
            } else {
                flag[4] = 0;
                marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
                return true;
            }

        }

        if (marker.getTitle().equals("Vikos")||marker.getTitle().equals("Βίκος")) {
            marker.hideInfoWindow();
            if (flag[3] == 0) {
                flag[3] = 1;
                marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
            } else {
                flag[3] = 0;
                marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
                return true;
            }
        }

        if (marker.getTitle().equals("Zagori")||marker.getTitle().equals("Ζαγόρι")){
            if(flag[2]==0){
                flag[2] = 1;
                marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
            }else{
                flag[2] =0;
                marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
                return true;

            }
        }

        if(marker.getTitle().equals("Molivdoskepastos")||marker.getTitle().equals("Μολυβδοσκέπαστος")){
            if(flag[1]==0){
                flag[1]=1;
                marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
            }else{
                flag[1]=0;
                marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
                return true;
            }
        }

        if(marker.getTitle().equals("Papigo")||marker.getTitle().equals("Πάπιγκο")){
            if(flag[0]==0){
                flag[0]=1;
                marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
            }else{
                flag[0]=0;
                marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
                return true;
            }
        }

        // Return false to indicate that we have not consumed the event and that we wish
        // for the default behavior to occur (which is for the camera to move such that the
        // marker is centered and for the marker's info window to open, if it has one).
        return false;
    }

    public Button show;

    public void init() {
        show = (Button) findViewById(R.id.button9);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag[0] == flag[1] && flag[1]== flag[2]&& flag[2] == flag[3] && flag[3]== flag[4] &&
                        flag[0]==0 && selectedPositions.contains(9)) {
                    Toast.makeText(MapsActivity.this,"Πρέπει να επιλέξεις τουλάχιστον μία περιοχή",
                            Toast.LENGTH_LONG).show();

                }else if(flag[0] == flag[1] && flag[1]== flag[2]&& flag[2] == flag[3] && flag[3]== flag[4] &&
                        flag[0]==0 && selectedPositions.contains(10)){
                    Toast.makeText(MapsActivity.this,"You have to choose at least one place",
                            Toast.LENGTH_LONG).show();
                }
                else{
                    //Intent startNewActivity = new Intent(MapsActivity.this, MakeKonitsa2.class);
                    Intent startNewActivity = new Intent(MapsActivity.this, ShowSelectedPlaces.class);
                    startNewActivity.putExtra("flag", flag);
                    startActivity(startNewActivity);
                }
            }
        });

    }
}