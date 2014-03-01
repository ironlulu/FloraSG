package com.example.florasg.GUI.profileGUI;

import java.util.ArrayList;

import com.example.florasg.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BookmarkAdapter extends ArrayAdapter<String> {
	
	private final Context context;
	private final int layoutResourceId; 
	private final ArrayList<String> values;
 
	public BookmarkAdapter(Context context, int layoutResourceId, ArrayList<String> values) {
        super(context, layoutResourceId, values);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.values = values;
    }
	
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 
		View rowView = inflater.inflate(layoutResourceId, parent, false);
		TextView textView = (TextView) rowView.findViewById(R.id.plantName);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.plantImg);
		textView.setText(values.get(position));
		imageView.setImageResource(R.drawable.ic_launcher);
 
		return rowView;
	}

}
