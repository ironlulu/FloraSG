package com.example.florasg.GUI.profileGUI;

import java.io.IOException;
import java.util.ArrayList;

import com.example.florasg.R;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BookmarkAdapter extends ArrayAdapter<Bookmark> {
	
	private final Context context;
	private final int layoutResourceId; 
	private final ArrayList<Bookmark> values;
 
	public BookmarkAdapter(Context context, int layoutResourceId, ArrayList<Bookmark> values) {
        super(context, layoutResourceId, values);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.values = values;
    }
	
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 
		View rowView = inflater.inflate(layoutResourceId, parent, false);
		// Get plant name
		TextView textView = (TextView) rowView.findViewById(R.id.plantName);		
		textView.setText(values.get(position).getName());
		
		// Get plant img
		ImageView imageView = (ImageView) rowView.findViewById(R.id.plantImg);
		String speciesCode = values.get(position).getSpeciesID();
				
		AssetManager am = context.getAssets();
        //String[] files;
        try {
        	//files = am.list(speciesCode);
        	Bitmap bmp=BitmapFactory.decodeStream(am.open(speciesCode+"/"+speciesCode+".jpeg"));
        	int bmpW = 120;
        	int bmpH = 180;
        	bmp = Bitmap.createScaledBitmap(bmp, bmpW, bmpH, true);
        	imageView.setImageBitmap(bmp);	
        	 
        } catch (IOException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        }
		
		//imageView.setImageResource(R.drawable.ic_launcher);
 
		return rowView;
	}

}
