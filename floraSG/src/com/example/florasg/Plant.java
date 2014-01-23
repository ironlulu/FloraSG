package com.example.florasg;

public class Plant {
	
	int speciesID;
	String sciName;
	String comName;
	String family;
	String description;
	String habitat;
	int minLeafSize;
	int maxLeafSize;
	String distribution;
	String conservationStatus;
	String growthReq;
	String horticulturalFeatures;
	String uses;
	String associatedFauna;
	boolean bookmarkStatus;
	
	Plant(int _id, String _sciName, String _comName, String _family, String _description, String 
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
	

} 
