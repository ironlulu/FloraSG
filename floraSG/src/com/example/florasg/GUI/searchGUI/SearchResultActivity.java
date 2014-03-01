package com.example.florasg.GUI.searchGUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.florasg.R;
import com.example.florasg.Controller.PlantDataRetriever;
import com.example.florasg.GUI.PlantInfo;

public class SearchResultActivity extends Activity {
	public final static  String SCI_NAME = "com.example.florasg.GUI.searchGUI.SCI_NAME";

	private TableLayout newseacrhResultsTableScrollView;
	PlantDataRetriever pdr ;
	List<String[]> searchResults;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		overridePendingTransition(R.anim.fadein, R.anim.fadeout);
		setContentView(R.layout.activity_search_result);
		
		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		Intent intent = getIntent();		
		ArrayList<Integer> descIdList = intent.getIntegerArrayListExtra(SearchActivity.DESC_LIST);

		newseacrhResultsTableScrollView = (TableLayout) findViewById(R.id.seacrhResultsTableScrollView);
		View newSearchResultRow = null;
		
		pdr = new PlantDataRetriever(this);
		
		for(int i=0;i<descIdList.size();i++){

			Log.i("desc id", " id is " + descIdList.get(i));
			

		}

		//TODO
		searchResults = new ArrayList<String[]>();
		pdr.openDB();
		searchResults = pdr.searchPlantbyCharacteristics(descIdList);	

		int noSpecies = searchResults.size();
		Log.i("debug","search result size is "+noSpecies);
		for(int i=0;i<noSpecies;i++){
			String[] plant = searchResults.get(i);
			newSearchResultRow = inflater.inflate(R.layout.search_result_row, null);
			
			TextView newSciName = (TextView) newSearchResultRow.findViewById(R.id.sciNameTextView);
			TextView newComName = (TextView) newSearchResultRow.findViewById(R.id.comNameTextView);
			String speciesCode = plant[0];
			String sciName = plant[1];
			String comName = plant[2];
			
			newSciName.setText(sciName);
			newComName.setText(comName);

			TextView newMatchNum = (TextView) newSearchResultRow.findViewById(R.id.matchNumber);
			String match = null;
			match = "Matches: "+plant[3];
			newMatchNum.setText(match);

			LinearLayout newspeciesImageScrollView = (LinearLayout) newSearchResultRow.findViewById(R.id.speciesImageScrollView);
			ImageView iv;

			LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(160,200);
			lp.setMargins(10,10,10,10);


			/*
			LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(R.dimen.search_result_species_image_width, 
					R.dimen.search_result_species_image_height);
			lp.setMargins(R.dimen.search_result_species_image_margin, 
					R.dimen.search_result_species_image_margin, 
					R.dimen.search_result_species_image_margin, 
					R.dimen.search_result_species_image_margin);
			 */

			/*
			testing by hard-code image source
			if(i%2==0){
				iv = new ImageView(getBaseContext());
				iv.setImageResource(R.drawable.acraur1);	
				newspeciesImageScrollView.addView(iv,lp);
				iv = new ImageView(getBaseContext());
				iv.setImageResource(R.drawable.acraur2);	
				newspeciesImageScrollView.addView(iv,lp);
				iv = new ImageView(getBaseContext());
				iv.setImageResource(R.drawable.acraur3);	
				newspeciesImageScrollView.addView(iv,lp);
				iv = new ImageView(getBaseContext());
				iv.setImageResource(R.drawable.acraur4);	
				newspeciesImageScrollView.addView(iv,lp);
			}
			else if(i%2==1){
				iv = new ImageView(getBaseContext());
				iv.setImageResource(R.drawable.alpaqu1);	
				newspeciesImageScrollView.addView(iv,lp);
				iv = new ImageView(getBaseContext());
				iv.setImageResource(R.drawable.alpaqu2);	
				newspeciesImageScrollView.addView(iv,lp);
				iv = new ImageView(getBaseContext());
				iv.setImageResource(R.drawable.alpaqu3);	
				newspeciesImageScrollView.addView(iv,lp);
				iv = new ImageView(getBaseContext());
				iv.setImageResource(R.drawable.alpaqu4);	
				newspeciesImageScrollView.addView(iv,lp);
				iv = new ImageView(getBaseContext());
				iv.setImageResource(R.drawable.alpaqu5);	
				newspeciesImageScrollView.addView(iv,lp);
				iv = new ImageView(getBaseContext());
				iv.setImageResource(R.drawable.alpaqu6);	
				newspeciesImageScrollView.addView(iv,lp);
			}
			 */

			AssetManager am = getAssets();
			String[] files;
			try {
				files = am.list(speciesCode);

				int noImages = files.length;
				for(int j=0;j<noImages;j++){
					Log.i("species image","species image name: "+speciesCode+"/"+files[j]);
					Bitmap bmp=BitmapFactory.decodeStream(am.open(speciesCode+"/"+files[j]));
					int bmpW = 80;
					int bmpH = 120;
					bmp = Bitmap.createScaledBitmap(bmp, bmpW, bmpH, true);
					iv = new ImageView(getBaseContext());
					iv.setImageBitmap(bmp);	
					newspeciesImageScrollView.addView(iv,lp);
				} 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  



			newseacrhResultsTableScrollView.addView(newSearchResultRow);
			TextView speciesName = (TextView) newSearchResultRow.findViewById(R.id.sciNameTextView);
			speciesName.setOnClickListener(speciesRowListener);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search_result, menu);


		return true;
	}
	
	public OnClickListener speciesRowListener = new OnClickListener(){

		@Override
		public void onClick(View v) {

			Intent intent = new Intent(getBaseContext(), PlantInfo.class);
			//TextView sciName = (TextView) v.findViewById(R.id.sciNameTextView);
			//String sciNameStr = sciName.toString();
			String sciNameStr = v.toString();
			Log.i("sci name", "sci name is "+sciNameStr);
			intent.putExtra(SCI_NAME, sciNameStr);
			startActivity(intent);			
		}

	};

}
