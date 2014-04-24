package com.example.florasg.GUI.newsGUI;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.florasg.R;
import com.example.florasg.Model.News;


public class NewsAdapter extends ArrayAdapter<News>{
	private final Context context;
	private final int layoutResourceId; 
	private final ArrayList<News> values;
 
	public NewsAdapter(Context context, int layoutResourceId, ArrayList<News> values) {
        super(context, layoutResourceId, values);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.values = values;
    }
	
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 
		View rowView = inflater.inflate(layoutResourceId, parent, false);
		// Get news title
		TextView textView = (TextView) rowView.findViewById(R.id.newsTitle);		
		textView.setText(values.get(position).getTitle());
		textView.setId(values.get(position).getNews_ID());
		System.out.println(values.get(position).getTitle() +" added id = "+values.get(position).getNews_ID()+"\n");
		
		return rowView;
	}
}
