package com.soa.tourism.service;

import java.util.List;

import com.soa.tourism.model.Evenement;

public interface EvenementService {
	
 public List<Evenement> getAllEvenement();
	 
	 public Evenement getEvenemenetById(long id);
	  
	 public void saveOrUpdate(Evenement evenement);
	 
	 public void deleteEvenement(long id);

}
