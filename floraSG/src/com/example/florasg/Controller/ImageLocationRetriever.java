package com.example.florasg.Controller;

import java.io.File;
import java.io.IOException;

import android.media.ExifInterface;

public class ImageLocationRetriever {
	private ExifInterface exifData;
	private static float[] LatLong;

	public ImageLocationRetriever() {	
		LatLong = new float[2]; 
	}
	
	public boolean hasLatLongData(String filename) {
		File f = new File(filename);
		
		if(f.exists() && !f.isDirectory()) {
			try {
				exifData = new ExifInterface(filename);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			return exifData.getLatLong(LatLong);
		}
		
		return false;
	}
	
	public float[] getLatLongFromImage(String filename) {
		try {
			exifData = new ExifInterface(filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		if(!exifData.getLatLong(LatLong)) {
			//If the image does not contain exif data with
			//latitude longitude tag, use default values
			// PGP
			LatLong[0] = (float)1.290;
			LatLong[1] = (float)103.780;	
		}
		return LatLong;
	}
}
