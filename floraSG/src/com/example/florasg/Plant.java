package com.example.florasg;

public class Plant {
	
	private int speciesID;
	private String speciesCode;
	private String sciName;
	private String authorName;
	private String comName;
	private String family;
	private String description;
	private String habitat;
	private int minLeafSize;
	private int maxLeafSize;
	private String distribution;
	private String conservationStatus;
	private String growthReq;
	private String horticulturalFeatures;
	private String uses;
	private String associatedFauna;
	private String reference;
	private String bookmarkStatus;
	
	Plant(int _id, String _speciesCode, String _sciName, String _authorName, String _comName, String _family, String _description, String 
			_habitat, int _minLeafSize, int _maxLeafSize, String _distribution, String _conservationStatus,
			String _growthReq, String _horticulturalFeatures, String _uses, String _associatedFauna,
			String _reference, String _bookmarkStatus) {
		speciesID = _id;
		speciesCode= _speciesCode;
		sciName = _sciName;
		authorName= _authorName;
		comName = _comName;
		family = _family;
		description = _description;
		habitat = _habitat;
		minLeafSize = _minLeafSize;
		maxLeafSize	= _maxLeafSize;
		distribution = _distribution;
		conservationStatus = _conservationStatus;
		growthReq = _growthReq;
		horticulturalFeatures = _horticulturalFeatures;
		uses = _uses;
		associatedFauna = _associatedFauna;
		reference = _reference;
		bookmarkStatus = _bookmarkStatus;				
	}

	public int getSpeciesID() {
		return speciesID;
	}
	
	public String getSpeciesCode(){
		return speciesCode;
	}

	public String getDescription() {
		return description;
	}

	public String getHabitat() {
		return habitat;
	}

	public int getMinLeafSize() {
		return minLeafSize;
	}

	public int getMaxLeafSize() {
		return maxLeafSize;
	}

	public String getDistribution() {
		return distribution;
	}

	public String getConservationStatus() {
		return conservationStatus;
	}

	public String getGrowthReq() {
		return growthReq;
	}

	public String getHorticulturalFeatures() {
		return horticulturalFeatures;
	}

	public String getUses() {
		return uses;
	}

	public String getAssociatedFauna() {
		return associatedFauna;
	}

	public String getBookmarkStatus() {
		return bookmarkStatus;
	}

	public String getSciName() {
		return sciName;
	}

	public String getComName() {
		return comName;
	}

	public String getFamily() {
		return family;
	}
	
	public String getAuthorName(){
		return authorName;
	}
	
	public String getReference(){
		return reference;
	}

} 
