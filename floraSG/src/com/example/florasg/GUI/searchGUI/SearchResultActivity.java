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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.florasg.R;
import com.example.florasg.Controller.PlantDataRetriever;

public class SearchResultActivity extends Activity {

	private TableLayout newseacrhResultsTableScrollView;
	PlantDataRetriever pdr = new PlantDataRetriever(this);
	List<String[]> searchResults = new ArrayList<String[]>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_result);
		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		Intent intent = getIntent();		
		ArrayList<Integer> descIdList = intent.getIntegerArrayListExtra(SearchActivity.DESC_LIST);

		newseacrhResultsTableScrollView = (TableLayout) findViewById(R.id.seacrhResultsTableScrollView);
		View newSearchResultRow = null;

		//Print out the checked characteristics for testing
		/*
		String s = "The desc ids are\n";
		s += Integer.toString(descIdList.size());
		s += "\n";

		for(int i=0;i<descIdList.size();i++){

			s = s + descIdList.get(i);
			s = s+"\n";

		}

		TextView searchResult = (TextView) findViewById(R.id.searchResult);
		searchResult.setText(s);
		 */

		//TODO
		pdr.openDB();
		searchResults = pdr.searchPlantbyCharacteristics(descIdList);
		//hard code the searchPlants for testing

		/*
		Plant p = new Plant(1, null,  "sciName1", null, "comName1", null, null, null, 0, 0, null, null, null, null, null, null, null, null);
		searchResults.add(p);
		p = new Plant(2, null,  "sciName2", null, "comName2", null, null, null, 0, 0, null, null, null, null, null, null, null, null);
		searchResults.add(p);
		p = new Plant(3, null,  "sciName3", null, "comName3", null, null, null, 0, 0, null, null, null, null, null, null, null, null);
		searchResults.add(p);
		p = new Plant(4, null,  "sciName4", null, "comName4", null, null, null, 0, 0, null, null, null, null, null, null, null, null);
		searchResults.add(p);
		p = new Plant(5, null,  "sciName5", null, "comName5", null, null, null, 0, 0, null, null, null, null, null, null, null, null);
		searchResults.add(p);
		p = new Plant(6, null,  "sciName6", null, "comName6", null, null, null, 0, 0, null, null, null, null, null, null, null, null);
		searchResults.add(p);
		p = new Plant(7, null,  "sciName7", null, "comName7", null, null, null, 0, 0, null, null, null, null, null, null, null, null);
		searchResults.add(p);
		 */

		int noSpecies = searchResults.size();
		for(int i=0;i<noSpecies;i++){
			String[] plant = searchResults.get(i);
			newSearchResultRow = inflater.inflate(R.layout.search_result_row, null);

			TextView newSpeciesName = (TextView) newSearchResultRow.findViewById(R.id.speciesNameTextView);
			String speciesCode = plant[0];
			String name = plant[1]+ "; "+ plant[2];
			newSpeciesName.setText(name);

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
					int bmpW = 120;
					int bmpH = 80;
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
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search_result, menu);


		return true;
	}

}
