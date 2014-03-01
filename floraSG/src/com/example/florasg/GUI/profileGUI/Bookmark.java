package com.example.florasg.GUI.profileGUI;

public class Bookmark {
	
	private String speciesID;
	private String name;
	
	public Bookmark(String speciesID, String name) {
		super();
		this.speciesID = speciesID;
		this.name = name;
	}

	public String getSpeciesID() {
		return speciesID;
	}

	public void setSpeciesID(String speciesID) {
		this.speciesID = speciesID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	

}
