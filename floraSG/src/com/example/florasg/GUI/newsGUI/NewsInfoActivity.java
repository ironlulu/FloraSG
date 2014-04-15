package com.example.florasg.GUI.newsGUI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.example.florasg.R;
import com.example.florasg.Controller.NewsListRetriever;
import com.example.florasg.Model.News;

public class NewsInfoActivity extends Activity {
	
	public final static  String NEWS_ID = "com.example.florasg.GUI.newsGUI.NEWS_ID";
	
	private NewsListRetriever nlr;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news_info);
		
		Intent intent = getIntent();
		int newsId = intent.getExtras().getInt(NEWS_ID);
		News item = nlr.getNewsItem(newsId);
		
		TextView newsTitle = (TextView)findViewById(R.id.newsInfoTitle);
		TextView newsContent = (TextView)findViewById(R.id.newsInfoContent);
		TextView newsDate = (TextView)findViewById(R.id.newsInfoDate);
		TextView newsUrl = (TextView)findViewById(R.id.newsInfoUrl);
		
		newsTitle.setText(item.getTitle());
		newsContent.setText(item.getContent());
		newsDate.setText(item.getDate().toString());
		newsUrl.setText(item.getUrl().toString());
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.news_info, menu);
		return true;
	}

}
