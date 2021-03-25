package com.soa.tourism.service;

import java.util.List;

import com.soa.tourism.model.Hote;

public interface HoteService {
	
 public List<Hote> getAllHotes();
	 
	 public Hote getHoteById(long id);
	  
	 public void saveOrUpdate(Hote hote);
	 
	 public void deleteHote(long id);


}
