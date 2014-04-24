package com.example.florasg.GUI;

import java.util.ArrayList;
import java.util.List;

import com.example.florasg.Controller.PlantDataRetriever;
import com.example.florasg.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;

public class BrowseActivity extends Activity implements  OnItemClickListener, OnItemSelectedListener  {
/*	    
	    //browse name view
		private static final int   SCIENTIFIC_NAME = 1;
		private static final int   COMMON_NAME = 2;
		private static final int   FAMILY_NAME = 3;
		
		List<String> buttonList=new ArrayList<String>();
		
	
     	private LinearLayout buttonNameView;
		private ListView browseListView;
		
		int buttonId = SCIENTIFIC_NAME;
		
		PlantDataRetriever pdr;
		
		Button scientificButton ;
		Button commonButton ;
		Button familyButton ;
		BrowseAdapter browseAdapter;
		//search view
	//	private ListView searchResultListView;
	//	ArrayAdapter<String> adapter;
		//EditText inputSearch;
	//	ArrayList<String[]> searchList;
		

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_browse);

			//buttonNameView = (LinearLayout)findViewById(R.id.buttonNameView);
			//tableScrollView = (TableLayout) findViewById(R.id.tableScrollView);
			buttonList.add("Scientific");
			buttonList.add("Common");
			buttonList.add("Family");
			//call plantDataRetriever and to get the result to display
			pdr = new PlantDataRetriever(this);
			pdr.openDB();
			
			//browse plant name
			for (int i = 0; i < buttonList.size(); i++) {

				Button btn = new Button(this);
				btn.setId(i);
				final int id_ = btn.getId();
				String buttonName = buttonList.get(i);
				btn.setText(buttonName);

				Resources r = getResources();
				int widthDp = (int) (getResources().getDimension(R.dimen.search_category_button_width) / getResources().getDisplayMetrics().density);
				int heightDp = (int) (getResources().getDimension(R.dimen.search_category_button_width) / getResources().getDisplayMetrics().density);

				int widthPx = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, widthDp, r.getDisplayMetrics());
				int heightPx = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, heightDp, r.getDisplayMetrics());
				
				btn.setWidth(widthPx);
				btn.setHeight(heightPx);
				
				buttonNameView.addView(btn);
				Button btn1 = ((Button) findViewById(id_));

				if(buttonName.equals("Scientific"))
					buttonId =  SCIENTIFIC_NAME;
				else if(buttonName.equals("Common"))
					buttonId =  COMMON_NAME;
				else if(buttonName.equals("Family"))
					buttonId =  FAMILY_NAME;


				switch(buttonId){
				case SCIENTIFIC_NAME:
					btn1.setOnClickListener(scientificButtonListener);
					break;
				case COMMON_NAME:
					btn1.setOnClickListener(commonButtonListener);
					break;
				case FAMILY_NAME:
					btn1.setOnClickListener(familyButtonListener);
					break;
				
				}
			}

			}
        
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.browse, menu);
			return true;
		}


		protected void onResume(Bundle savedInstanceState){
			super.onResume();

		}
		
		protected void onPause(Bundle savedInstanceState){
			super.onPause();
		}

		public OnClickListener scientificButtonListener = new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				browseListView.removeAllViews();
				updateBrowseView(SCIENTIFIC_NAME);
			}

		};

		public OnClickListener commonButtonListener = new OnClickListener(){

			@Override
			public void onClick(View v) {
				browseListView.removeAllViews();
				updateBrowseView(COMMON_NAME);
			}

		};

		public OnClickListener familyButtonListener = new OnClickListener(){

			@Override
			public void onClick(View v) {
				browseListView.removeAllViews();
				updateBrowseView(FAMILY_NAME);
			}

		};

		//update the browse view according to the buttonId
		private void updateBrowseView(int buttonId){

			LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			ArrayList<String> resultList=new ArrayList<String>();
			
			        resultList= (ArrayList<String>) pdr.browsePlant(buttonId);
					browseListView = (ListView)findViewById(R.id.listView);
					browseAdapter = new BrowseAdapter(this, R.layout.browse_row, resultList);
					browseListView.setAdapter(browseAdapter);
					registerForContextMenu(browseListView);

					browseListView.setOnItemClickListener(new OnItemClickListener()
					{
						// argument position gives the index of item which is clicked
						public void onItemClick(AdapterView<?> arg0, View v,int position, long arg3)
						{
							TextView text = ((TextView) v.findViewById(R.id.plantName));
							String sciNameStr =  text.getText().toString();
							Intent intent = new Intent(getApplicationContext(), PlantInfo.class);
							intent.putExtra(PlantInfo.SCI_NAME, sciNameStr);
							startActivity(intent);
						}
					});

			}
		search
		ListView searchResultListView = (ListView) findViewById(R.id.searchView);
        EditText inputSearch = (EditText) findViewById(R.id.inputSearch);
        List<ArrayList<String>> results=pdr.searchPlantbyKeyword(inputSearch); 
        // Adding items to listview
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.plant_name, results);
        searchResultListView.setAdapter(adapter);
        
        //Enabling Search Filter
         
        inputSearch.addTextChangedListener(new TextWatcher() {
             
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                BrowseActivity.this.adapter.getFilter().filter(cs);   
            }
             
            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                    int arg3) {
                // TODO Auto-generated method stub
                 
            }
             
           
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
        });
	}*/
	
	   // Initialize variables
	      
	    AutoCompleteTextView textView=null;
	    private ArrayAdapter<ArrayList<String>> adapter;
	    PlantDataRetriever pdr;
	    
	    
	    /** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle bundle) {
	        super.onCreate(bundle);
	         
	        setContentView(R.layout.activity_browse);
	        pdr = new PlantDataRetriever(this);
			pdr.openDB();
	          
	        // Initialize AutoCompleteTextView values
	         
	            // Get AutoCompleteTextView reference from xml
	            textView = (AutoCompleteTextView) findViewById(R.id.searchInput);
	          //These values show in autocomplete
	            List<ArrayList<String>> results=pdr.searchPlantbyKeyword(textView.getText().toString()); 
	            //Create adapter    
	            adapter = new ArrayAdapter<ArrayList<String>>(this, android.R.layout.simple_dropdown_item_1line, results);
	             
	            textView.setThreshold(1);
	             
	           //Set adapter to AutoCompleteTextView
	            textView.setAdapter(adapter);
	            textView.setOnItemSelectedListener(this);
	            textView.setOnItemClickListener(this);
	         
	           
	    }
	 
	     
	    @Override
	    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,
	            long arg3) {
	        // TODO Auto-generated method stub
	        //Log.d("AutocompleteContacts", "onItemSelected() position " + position);
	    }
	 
	    @Override
	    public void onNothingSelected(AdapterView<?> arg0) {
	        // TODO Auto-generated method stub
	         
	        InputMethodManager imm = (InputMethodManager) getSystemService(
	                INPUT_METHOD_SERVICE);
	            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
	 
	    }
	 
	    @Override
	    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
	        // TODO Auto-generated method stub
	    	TextView text = ((TextView) arg1.findViewById(R.id.plantName));
			String sciNameStr =  text.getText().toString();
			Intent intent = new Intent(getApplicationContext(), PlantInfo.class);
			intent.putExtra(PlantInfo.SCI_NAME, sciNameStr);
			startActivity(intent);
	        // Show Alert       
	        Toast.makeText(getBaseContext(), "Position:"+arg2+" Plant:"+arg0.getItemAtPosition(arg2),
	                Toast.LENGTH_LONG).show();
	         
	        Log.d("AutocompleteContacts", "Position:"+arg2+" Plant:"+arg0.getItemAtPosition(arg2));
	         
	    }
	     
	    protected void onResume() {
	        super.onResume();
	    }
	  
	    protected void onDestroy() {
	        super.onDestroy();
	    }
	    
	}
