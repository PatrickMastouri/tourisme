package com.soa.tourism.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.soa.tourism.model.Evenement;
import com.soa.tourism.repository.EvenementRepository;


@Service
@Transactional
public class EvenementServ implements EvenementService {
	
	@Autowired
	EvenementRepository agent;


	@Override
	public List<Evenement> getAllEvenement() {
		
		return (List<Evenement>)agent.findAll();
	}

	@Override
	public Evenement getEvenemenetById(long id) {
		
		return agent.findById(id).get();
	}

	@Override
	public void saveOrUpdate(Evenement evenement) {
		agent.save(evenement);
		
	}

	@Override
	public void deleteEvenement(long id) {
		agent.deleteById(id);
		
	}

}
