package com.example.florasg.Controller;

import java.util.ArrayList;
import java.util.List;

import com.example.florasg.Model.Plant;

public class BookmarkManager {
private List<Plant> bookmarked_plant;

	public BookmarkManager() {
		bookmarked_plant = new ArrayList<Plant>(); //ArrayList or LinkList or Vector??
	}
	
	public boolean toggleBookmark(int species_id) {
		//fill in the method
		
		
		return true;
	}
	
	public List<Plant> viewBookmark() {
		//fill in the method
		
		
		return bookmarked_plant;
	}
}
