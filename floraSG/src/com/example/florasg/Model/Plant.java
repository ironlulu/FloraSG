package com.example.florasg.Model;

public class Plant {
	
	private int speciesID;
	private String sciName;
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
	private boolean bookmarkStatus;
	
	public Plant(int _id, String _sciName, String _comName, String _family, String _description, String 
			_habitat, int _minLeafSize, int _maxLeafSize, String _distribution, String _conservationStatus,
			String _growthReq, String _horticulturalFeatures, String _uses, String _associatedFauna,
			boolean _bookmarkStatus) {
		speciesID = _id;
		sciName = _sciName;
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
		bookmarkStatus = _bookmarkStatus;				
	}

	public int getSpeciesID() {
		return speciesID;
	}

	public void setSpeciesID(int speciesID) {
		this.speciesID = speciesID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHabitat() {
		return habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	public int getMinLeafSize() {
		return minLeafSize;
	}

	public void setMinLeafSize(int minLeafSize) {
		this.minLeafSize = minLeafSize;
	}

	public int getMaxLeafSize() {
		return maxLeafSize;
	}

	public void setMaxLeafSize(int maxLeafSize) {
		this.maxLeafSize = maxLeafSize;
	}

	public String getDistribution() {
		return distribution;
	}

	public void setDistribution(String distribution) {
		this.distribution = distribution;
	}

	public String getConservationStatus() {
		return conservationStatus;
	}

	public void setConservationStatus(String conservationStatus) {
		this.conservationStatus = conservationStatus;
	}

	public String getGrowthReq() {
		return growthReq;
	}

	public void setGrowthReq(String growthReq) {
		this.growthReq = growthReq;
	}

	public String getHorticulturalFeatures() {
		return horticulturalFeatures;
	}

	public void setHorticulturalFeatures(String horticulturalFeatures) {
		this.horticulturalFeatures = horticulturalFeatures;
	}

	public String getUses() {
		return uses;
	}

	public void setUses(String uses) {
		this.uses = uses;
	}

	public String getAssociatedFauna() {
		return associatedFauna;
	}

	public void setAssociatedFauna(String associatedFauna) {
		this.associatedFauna = associatedFauna;
	}

	public boolean getBookmarkStatus() {
		return bookmarkStatus;
	}

	public void setBookmarkStatus(boolean bookmarkStatus) {
		this.bookmarkStatus = bookmarkStatus;
	}

	public void setSciName(String sciName) {
		this.sciName = sciName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public void setFamily(String family) {
		this.family = family;
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

} 
