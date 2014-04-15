package com.example.florasg.GUI.newsGUI;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.example.florasg.R;
import com.example.florasg.Controller.NewsListRetriever;
import com.example.florasg.GUI.PlantInfo;
import com.example.florasg.Model.Bookmark;
import com.example.florasg.Model.News;

public class NewsActivity extends Activity {

	private NewsListRetriever nlr;
	private NewsAdapter adapter;
	private ListView newsListView;
	private ArrayList<News> newsList = new ArrayList<News>();
	private List<News> tempList = new ArrayList<News>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news);

		nlr = new NewsListRetriever(this);
		tempList = nlr.getLatestNews();

		if(tempList.isEmpty()){

			Toast toast = Toast.makeText(getApplicationContext(),"Your news list is empty!", Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();			
		} else {
			for (News e: tempList){
				newsList.add(e);
			}
			
			LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			newsListView = (ListView) findViewById(R.id.newsListView);
			
			//newsListView.removeAllViews();
			//View newsRow = null;

			/*
			int noNews = newsList.size(); 
			for(int i=0;i<noNews;i++){

				News news = newsList.get(i);
				newsRow = inflater.inflate(R.layout.news_row, null);
				TextView newsTitle = (TextView) newsRow.findViewById(R.id.newsTitle);
				newsTitle.setText(news.getTitle());
				
				newsListView.addView(newsRow);
				
			}
			*/
			
			adapter = new NewsAdapter(this, R.layout.news_row, newsList);
			newsListView.setAdapter(adapter);
			registerForContextMenu(newsListView);
			
			newsListView.setOnItemClickListener(new OnItemClickListener()
			{
				// argument position gives the index of item which is clicked
				public void onItemClick(AdapterView<?> arg0, View v,int position, long arg3)
				{
					TextView text = ((TextView) v.findViewById(R.id.newsTitle));
					//int newsId =  text.getId();
					int newsId = 1;
					Intent intent = new Intent(getApplicationContext(), NewsInfoActivity.class);
					intent.putExtra(NewsInfoActivity.NEWS_ID, newsId);
					startActivity(intent);
				}
			});
	
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.news, menu);
		return true;
	}

}
