package com.example.florasg.GUI.newsGUI;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.florasg.R;
import com.example.florasg.Controller.NewsListRetriever;
import com.example.florasg.Model.Blog;
import com.example.florasg.Model.News;

public class NewsActivity extends Activity {

	private NewsListRetriever nlr;
	private BlogAdapter adapter;
	private ListView newsListView;
	private ArrayList<News> newsList = new ArrayList<News>();
	private List<News> tempList = new ArrayList<News>();
	private ArrayList<Blog> blogList = new ArrayList<Blog>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news);

		//nlr = new NewsListRetriever(this);
		//tempList = nlr.getLatestNews();
		
		try {
			blogList.add(new Blog("floraofsingapore Wordpress", new URL("http://floraofsingapore.wordpress.com/")));
			blogList.add(new Blog("sgflowering Tumblr", new URL("http://sgflowering.tumblr.com/")));
			
			blogList.add(new Blog("weefoong Flickr", new URL("https://www.flickr.com/photos/weefoong")));
			blogList.add(new Blog("siyangteo Flickr", new URL("https://www.flickr.com/photos/siyangteo")));
			blogList.add(new Blog("loupok Flickr", new URL("https://www.flickr.com/photos/loupok")));
			blogList.add(new Blog("89906643@N06 Flickr", new URL("https://www.flickr.com/photos/89906643@N06")));
			blogList.add(new Blog("reulim Flickr", new URL("https://www.flickr.com/photos/reulim")));
			blogList.add(new Blog("75589925@N03 Flickr", new URL("https://www.flickr.com/photos/75589925@N03")));
			blogList.add(new Blog("yeochowkhoon Flickr", new URL("https://www.flickr.com/photos/yeochowkhoon/")));

			
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		if(blogList.isEmpty()){

			Toast toast = Toast.makeText(getApplicationContext(),"Your news list is empty!", Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();			
		} else {
			/*
			for (News e: tempList){
				newsList.add(e);
			}
			*/

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

			//adapter = new NewsAdapter(this, R.layout.news_row, newsList);
			
			adapter = new BlogAdapter(this, R.layout.news_row, blogList);
			newsListView.setAdapter(adapter);
			registerForContextMenu(newsListView);

			newsListView.setOnItemClickListener(new OnItemClickListener()
			{
				// argument position gives the index of item which is clicked
				public void onItemClick(AdapterView<?> arg0, View v,int position, long arg3)
				{
					//TextView text = ((TextView) v.findViewById(R.id.newsTitle));
					//int newsId =  text.getId();
					
					/*
					int newsId = 1;
					Intent intent = new Intent(getApplicationContext(), NewsInfoActivity.class);
					intent.putExtra(NewsInfoActivity.NEWS_ID, newsId);
					startActivity(intent);
					*/
					
					/*
					Log.i("the id is ","is "+ text.getText().toString());
					Log.i("the url is ","is "+ blogList.get(text.getId()).toString());
					*/
					Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(blogList.get(position).getURL().toString()));
					startActivity(browserIntent);
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
