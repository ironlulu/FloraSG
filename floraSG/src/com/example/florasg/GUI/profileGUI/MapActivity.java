package com.example.florasg.GUI.profileGUI;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import com.example.florasg.R;
import com.example.florasg.Controller.ImageLocationRetriever;

public class MapActivity extends Activity {
		
	static final LatLng PGP = new LatLng(1.290, 103.780);
	static final LatLng place1 = new LatLng(1.2828013, 103.8659992);
	static final LatLng place2 = new LatLng(1.3191185, 103.7071972);
	static final LatLng USS = new LatLng(1.254347,103.82324199999994);
	static final LatLng Hill = new LatLng(1.3931172,103.774174);
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
			
			Log.d("map", "map created!");
			/*
			// get current location
			LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            Criteria criteria = new Criteria();
            Location location = locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));
            LatLng latlng = null;
            
            if (location != null){
            	// gets the users current longitude and latitude.
            	latlng=new LatLng(location.getLatitude(),location.getLongitude());
            	
            	//Moves the camera to users current longitude and latitude
                map.moveCamera(CameraUpdateFactory.newLatLng(latlng));
                //Animates camera and zooms to preferred state on the user's current location.
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng,(float) 12));
            
            }
            */
            
			
            Marker marker = map.addMarker(new MarkerOptions()
				.position(PGP));
            
            Marker marker1 = map.addMarker(new MarkerOptions()
			.position(place1));
            
            Marker marker2 = map.addMarker(new MarkerOptions()
			.position(place2));
            
            Marker marker3 = map.addMarker(new MarkerOptions()
			.position(USS));
            
            Marker marker4 = map.addMarker(new MarkerOptions()
			.position(Hill));
            
            //Moves the camera to users current longitude and latitude
            map.moveCamera(CameraUpdateFactory.newLatLng(PGP));
            //Animates camera and zooms to preferred state on the user's current location.
            map.animateCamera(CameraUpdateFactory.newLatLngZoom(PGP,(float) 12));
            
            //Provide a filename for the imagelocationretriever to retrieve the latitude and
            //longitude of the image
            /*ImageLocationRetriever ILRetriever = new ImageLocationRetriever();
            float[] dataLatLong = new float[]{0, 0};
            
            if(ILRetriever.hasLatLongData(filename)) {
            	dataLatLong = ILRetriever.getLatLongFromImage(filename);
            }*/
            /*Marker kiel = map.addMarker(new MarkerOptions()
				.position(KIEL)
				.title("Kiel")
				.snippet("Kiel is cool")
				.icon(BitmapDescriptorFactory
					.fromResource(R.drawable.ic_launcher)));*/
            
            // set custom info window for marker
            map.setInfoWindowAdapter(new InfoWindowAdapter() {
                
                // Use default InfoWindow frame
                @Override
                public View getInfoWindow(Marker arg0) {                
                    return null;
                }            
                
                // Defines the contents of the InfoWindow
                @Override
                public View getInfoContents(Marker arg0) {
                    
                    // Getting view from the layout file info_window_layout
                    View v = getLayoutInflater().inflate(R.layout.info_window, null);
                                      
                    // Getting reference to the Imageview to set image
                    ImageView img = (ImageView) v.findViewById(R.id.photo);
            		Bitmap bmp= BitmapFactory.decodeResource(getResources(), R.drawable.logo);
            		int bmpW = 260;
    				int bmpH = 360;
    				bmp = Bitmap.createScaledBitmap(bmp, bmpW, bmpH, true);
    				img.setImageBitmap(bmp);
            		
    				// get address
    				LatLng position = arg0.getPosition();
    				String strCompleteAddress= "";
    				Geocoder geoCoder = new Geocoder(getBaseContext(), Locale.getDefault());
    		        try {
						List<Address>addresses = geoCoder.getFromLocation(position.latitude, position.longitude, 1);
						//Log.d("latitude:", Double.toString(position.latitude));
						//Log.d("longitude:", Double.toString(position.longitude));
    				
						for (int i = 0; i < addresses.get(0)
								.getMaxAddressLineIndex(); i++) {
							strCompleteAddress += addresses.get(0)
									.getAddressLine(i) + "\n";
						}
    		        } catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    		        // Getting reference to the TextView to set address
                    TextView addr = (TextView) v.findViewById(R.id.address);                    
                    // Setting the date
                    addr.setText(strCompleteAddress);
    				
            		// Getting reference to the TextView to set date
                    TextView txt = (TextView) v.findViewById(R.id.date);                    
                    // Setting the date
                    txt.setText("Date: 11/01/2014");
                   
                    // Returning the view containing InfoWindow contents
                    return v;                   
                }
                
            });
		}
		
	}
	
	protected void onResume() {
		super.onResume();
		initilizeMap();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map, menu);
		return true;
	}
	
	

}
