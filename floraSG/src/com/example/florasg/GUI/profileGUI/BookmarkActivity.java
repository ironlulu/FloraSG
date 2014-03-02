package com.example.florasg.GUI.profileGUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.florasg.MainActivity;
import com.example.florasg.R;
import com.example.florasg.Controller.BookmarkManager;
import com.example.florasg.GUI.PlantInfo;
import com.example.florasg.Model.Bookmark;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class BookmarkActivity extends Activity {

	private ListView bookmarkListView;
	private List<ArrayList<String>> tempList = new ArrayList<ArrayList<String>>();
	private ArrayList<Bookmark> bookmarkList = new ArrayList<Bookmark>();
	BookmarkManager bm;
	BookmarkAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.activity_bookmark);
		
		//open bookmarkManager and get the bookmarkList
		bm = new BookmarkManager(this);
		
		tempList = bm.viewBookmark();
		
		if(tempList.isEmpty()){
			
			Toast toast = Toast.makeText(getApplicationContext(),"Your Bookmark List is empty!", Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();			
		} else {

			for (ArrayList<String>e: tempList){
				Bookmark item = new Bookmark(e.get(0),e.get(1));
				bookmarkList.add(item);
			}
			Log.d("Bookmark List Size", Integer.toString(bookmarkList.size()));

			adapter = new BookmarkAdapter(this, 
					R.layout.bookmark_row, bookmarkList);

			bookmarkListView = (ListView)findViewById(R.id.listView);

			bookmarkListView.setAdapter(adapter);

			bookmarkListView.setOnItemClickListener(new OnItemClickListener()
			{
				// argument position gives the index of item which is clicked
				public void onItemClick(AdapterView<?> arg0, View v,int position, long arg3)
				{
					TextView text = ((TextView) v.findViewById(R.id.plantName));
					//MainActivity.plant = text.getText().toString();
					String sciNameStr =  text.getText().toString();
					Intent intent = new Intent(getApplicationContext(), PlantInfo.class);
					intent.putExtra(PlantInfo.SCI_NAME, sciNameStr);
					startActivity(intent);
				}
			});

			bookmarkListView.setOnItemLongClickListener(new OnItemLongClickListener()
			{
				// argument position gives the index of item which is clicked
				public boolean onItemLongClick(AdapterView<?> arg0, View v,int position, long arg3)
				{
					final int pos = position;
					TextView text = ((TextView) v.findViewById(R.id.plantName));
					String sciNameStr =  text.getText().toString();

					AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(BookmarkActivity.this);

					// set title
					alertDialogBuilder.setTitle("Delete");

					// set dialog message
					alertDialogBuilder
					.setMessage("Confirm to delete this bookmark?")
					.setCancelable(false)
					.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,int id) {
							// if this button is clicked, close
							// current activity
							
							bookmarkList.remove(pos);
							adapter.notifyDataSetChanged();
						}
					})
					.setNegativeButton("No",new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,int id) {
							// if this button is clicked, just close
							// the dialog box and do nothing
							dialog.cancel();
						}
					});

					// create alert dialog
					AlertDialog alertDialog = alertDialogBuilder.create();

					// show it
					alertDialog.show();
					return true;
				}
			});
		}
		
	}
	
	public void onRestart() { 
	    super.onRestart();
	    //When BACK BUTTON is pressed, the activity on the stack is restarted
	    //Do what you want on the refresh procedure here
	    Log.d("TAG", "BookmarkList: onRestart()");
	    	    
	    bookmarkList.clear();
	    tempList.clear();
	    
	    tempList = bm.viewBookmark();
	    		
	    for (ArrayList<String>e: tempList){
	    	Bookmark item = new Bookmark(e.get(0),e.get(1));
			bookmarkList.add(item);
	    }
	    Log.d("New Bookmark List Size", Integer.toString(bookmarkList.size()));

	    adapter.notifyDataSetChanged();
	    
	    if(bookmarkList.isEmpty()){
	    	Toast toast = Toast.makeText(getApplicationContext(),"Your Bookmark List is empty!", Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();
	    }
	}
	
	
	/*
	private TableLayout bookmarkTable;
	private List<ArrayList<String>> bookmarkList = new ArrayList<ArrayList<String>>();
	BookmarkManager bm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.activity_bookmark);

		bm = new BookmarkManager(this);

		
		bm.toggleBookmark(5);
		bm.toggleBookmark(30);
		bm.toggleBookmark(3);
		bm.toggleBookmark(7);
		bm.toggleBookmark(9);
		bm.toggleBookmark(10);
		bm.toggleBookmark(20);
		bm.toggleBookmark(60);
		bm.toggleBookmark(45);
		bm.toggleBookmark(13);
		bm.toggleBookmark(27);
		bm.toggleBookmark(34);
		bm.toggleBookmark(1);
		bm.toggleBookmark(4);
		bm.toggleBookmark(25);
		bm.toggleBookmark(18);
		bm.toggleBookmark(21);
		bm.toggleBookmark(12);
		bm.toggleBookmark(2);
		bm.toggleBookmark(44);
		


		bookmarkList = bm.viewBookmark();
		Log.d("Bookmark List Size", Integer.toString(bookmarkList.size()));

		bookmarkTable = (TableLayout) findViewById(R.id.bookmarkListTable);

		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		for (int i=0;i<bookmarkList.size();i++){
			//TableRow tr = new TableRow(this);
			//tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
			View newRow = inflater.inflate(R.layout.bookmark_row, null);
			
			ImageView newImage = (ImageView) newRow.findViewById(R.id.plantImg);
			String speciesCode = bookmarkList.get(i).get(0);			
			AssetManager am = getAssets();
	        //String[] files;
	        try {
	        	//files = am.list(speciesCode);
	        	//Log.d("No of imgs", Integer.toString(files.length));
	        	       	
	        	//Log.i("species image","species image name: "+speciesCode+"/"+files[j]);
	        	Bitmap bmp=BitmapFactory.decodeStream(am.open(speciesCode+"/"+speciesCode+".jpeg"));
	        	int bmpW = 120;
	        	int bmpH = 180;
	        	bmp = Bitmap.createScaledBitmap(bmp, bmpW, bmpH, true);
	        	newImage.setImageBitmap(bmp);	
	        	 
	        } catch (IOException e) {
	        	// TODO Auto-generated catch block
	        	e.printStackTrace();
	        }
	        
			//newImage.setImageResource(R.drawable.ic_launcher);
			Button newBtn = (Button) newRow.findViewById(R.id.plantName);
			newBtn.setText(bookmarkList.get(i).get(1));
			
			bookmarkTable.addView(newRow);

			newBtn.setOnClickListener(btnclick);
			newBtn.setOnLongClickListener(btnlongclick);
		}

	}

	Button.OnClickListener btnclick = new Button.OnClickListener(){

		@Override
		public void onClick(View v) {

			Button btn = (Button)v;
			//Toast.makeText(getApplicationContext(), button.getText().toString(),2).show(); 
			MainActivity.plant = btn.getText().toString();
			Intent intent = new Intent(getApplicationContext(), PlantInfo.class);  
			startActivity(intent);
		}

	};

	Button.OnLongClickListener btnlongclick = new Button.OnLongClickListener(){

		@Override
		public boolean onLongClick(View v) {

			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
					v.getContext());

			Log.d("Dialog", "Build Dialog!");

			// set title
			alertDialogBuilder.setTitle("Delete");

			// set dialog message
			alertDialogBuilder
			.setMessage("Are you sure you want to delete this item?")
			.setCancelable(false)
			.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {
					// if this button is clicked, close
					// current activity
					dialog.cancel();
				}
			})
			.setNegativeButton("No",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {
					// if this button is clicked, just close
					// the dialog box and do nothing
					dialog.cancel();
				}
			});

			// create alert dialog
			AlertDialog alertDialog = alertDialogBuilder.create();
			Log.d("Dialog", "Dialog created!");

			// show it
			alertDialog.show();

			return true;
		}

	};

	public void onRestart() { 
		super.onRestart();
		//When BACK BUTTON is pressed, the activity on the stack is restarted
		//Do what you want on the refresh procedure here
		Log.d("TAG", "BookmarkList: onRestart()");

		bookmarkTable.removeAllViews();	
		bookmarkList.clear();

		bookmarkList = bm.viewBookmark();
		Log.d("Bookmark List Size", Integer.toString(bookmarkList.size()));

		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		for (int i=0;i<bookmarkList.size();i++){
			//TableRow tr = new TableRow(this);
			//tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
			View newRow = inflater.inflate(R.layout.bookmark_row, null);
			
			ImageView newImage = (ImageView) newRow.findViewById(R.id.plantImg);
			String speciesCode = bookmarkList.get(i).get(0);			
			AssetManager am = getAssets();
	        //String[] files;
	        try {
	        	//files = am.list(speciesCode);
	        	Bitmap bmp=BitmapFactory.decodeStream(am.open(speciesCode+"/"+speciesCode+".jpeg"));
	        	int bmpW = 120;
	        	int bmpH = 180;
	        	bmp = Bitmap.createScaledBitmap(bmp, bmpW, bmpH, true);
	        	newImage.setImageBitmap(bmp);	
	        	 
	        } catch (IOException e) {
	        	// TODO Auto-generated catch block
	        	e.printStackTrace();
	        }
	        
			//newImage.setImageResource(R.drawable.ic_launcher);
			Button newBtn = (Button) newRow.findViewById(R.id.plantName);
			newBtn.setText(bookmarkList.get(i).get(1));
			
			bookmarkTable.addView(newRow);

			newBtn.setOnClickListener(btnclick);
			newBtn.setOnLongClickListener(btnlongclick);
		}
	}
	*/
}


