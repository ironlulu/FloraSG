package com.example.florasg;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private PlantDataRetriever pdr;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		pdr=new PlantDataRetriever(this);
		pdr.openDB();
		
		pdr.getAllGlossary();
		
		TextView tv=(TextView) findViewById(R.id.helloID);
        tv.setText(pdr.getGlossary(24));
        
        List<Integer>description_id=new ArrayList<Integer>();
        
        description_id.add(5);
        description_id.add(6);
        description_id.add(15);
        
        List<Plant> values = pdr.searchPlantbyCharacteristics(description_id);

        // use the SimpleCursorAdapter to show the
        // elements in a ListView
        ArrayAdapter<Plant> adapter = new ArrayAdapter<Plant>(this,
            android.R.layout.simple_list_item_1, values);
        ListView lv = (ListView) findViewById(R.id.list);
        lv.setAdapter(adapter);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/*public void goIntoApp(View view) {
		Intent intent = new Intent(this, SearchActivity.class);    
		startActivity(intent);
		//A comment here
		// I add another comment :3
	}*/


}
