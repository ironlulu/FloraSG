package com.example.florasg.GUI.profileGUI;

import com.example.florasg.R;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends Activity {
	
	static final LatLng HAMBURG = new LatLng(53.558, 9.927);
	static final LatLng KIEL = new LatLng(53.551, 9.993);
	private GoogleMap map;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.activity_map);
		
		try {
            // Loading map
            initilizeMap();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}

	@SuppressLint("NewApi")
	private void initilizeMap() {
		// TODO Auto-generated method stub
		// create map
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
		        .getMap();
		    
		if (map != null) {
			LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            Criteria criteria = new Criteria();
            Location location = locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));
            
            if (location != null){
            	// gets the users current longitude and latitude.
            	LatLng latlng=new LatLng(location.getLatitude(),location.getLongitude());
            	
            	//Moves the camera to users current longitude and latitude
                map.moveCamera(CameraUpdateFactory.newLatLng(latlng));
                //Animates camera and zooms to preferred state on the user's current location.
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng,(float) 12));
            
            }
            
            Marker hamburg = map.addMarker(new MarkerOptions()
				.position(HAMBURG).title("Hamburg"));
            Marker kiel = map.addMarker(new MarkerOptions()
				.position(KIEL)
				.title("Kiel")
				.snippet("Kiel is cool")
				.icon(BitmapDescriptorFactory
					.fromResource(R.drawable.ic_launcher)));
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map, menu);
		return true;
	}

}
