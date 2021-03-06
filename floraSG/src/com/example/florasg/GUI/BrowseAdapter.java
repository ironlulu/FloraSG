package com.example.florasg.GUI;

import java.io.IOException;
import java.util.ArrayList;

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

import com.example.florasg.R;
import com.example.florasg.Model.Plant;

public class BrowseAdapter extends ArrayAdapter<String> {
	private final Context context;
	private final int layoutResourceId; 
	private final ArrayList<String> values;
 
	public BrowseAdapter(Context context, int layoutResourceId, ArrayList<String> values) {
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
		textView.setText(values.get(position));
	
		return rowView;
	}
}

