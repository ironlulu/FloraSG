package com.example.florasg.GUI.newsGUI;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.florasg.R;
import com.example.florasg.Model.Blog;


public class BlogAdapter extends ArrayAdapter<Blog>{
	private final Context context;
	private final int layoutResourceId; 
	private final ArrayList<Blog> values;
 
	public BlogAdapter(Context context, int layoutResourceId, ArrayList<Blog> values) {
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
		ImageView logoImageView = (ImageView)rowView.findViewById(R.id.blogLogo);
		textView.setText(values.get(position).getName());
		textView.setId(position);
		
		if(values.get(position).getName().contains("Wordpress")){
			logoImageView.setImageResource(R.drawable.wp);
		}else if(values.get(position).getName().contains("Tumblr")){
			logoImageView.setImageResource(R.drawable.tumblr);
		}
		//textView.setOnClickListener(BlogOnClickListener);
		
		return rowView;
	}
	
	/*
	public OnClickListener BlogOnClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(values.get(v.getId()).toString()));
				startActivity(browserIntent);
			
			
		}
		
	};
	*/
}


