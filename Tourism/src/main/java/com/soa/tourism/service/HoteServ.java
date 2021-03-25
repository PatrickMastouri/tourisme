package com.soa.tourism.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.soa.tourism.model.Hote;
import com.soa.tourism.repository.HoteRepository;

@Service
@Transactional
public class HoteServ implements HoteService {
	
	@Autowired	
	HoteRepository hoterepo;

	@Override
	public List<Hote> getAllHotes() {
		System.out.println("une liste trié ******>");
		return (List<Hote>) hoterepo.findAll();
	}

	@Override
	public Hote getHoteById(long id) {
		
		return hoterepo.findById(id).get();
	}

	@Override
	public void saveOrUpdate(Hote hote) {
		hoterepo.save(hote);
		
	}

	@Override
	public void deleteHote(long id) {
		hoterepo.deleteById(id);
		
	}

}
