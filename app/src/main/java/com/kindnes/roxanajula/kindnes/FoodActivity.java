package com.kindnes.roxanajula.kindnes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FoodActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Help with food");
        setContentView(R.layout.activity_food);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //Get data from Firebase database
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference().child("locations").child("foodLocations");
        rootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (int i=1; i<=snapshot.getChildrenCount(); i++) {
                    Location loc = snapshot.child(""+i).getValue(Location.class);
                    LatLng pin = new LatLng(loc.getLat(), loc.getLng());
                    mMap.addMarker(new MarkerOptions().position(pin).title(loc.getTitle()));
                }
            }
            @Override
            public void onCancelled(DatabaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });
        LatLng aarhus = new LatLng(56.152315, 10.196079);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(aarhus, 12));

    }
}
