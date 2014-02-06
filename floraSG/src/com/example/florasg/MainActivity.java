package com.example.florasg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
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
