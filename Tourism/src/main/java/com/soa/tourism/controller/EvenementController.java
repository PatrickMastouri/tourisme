package com.soa.tourism.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soa.tourism.exception.ResourceNotFoundException;
import com.soa.tourism.model.Evenement;
import com.soa.tourism.repository.EvenementRepository;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class EvenementController {
	
	@Autowired
	EvenementRepository agent;
	
	
	@GetMapping("/evenements")
	public List<Evenement> getAllEvenement() {
		return agent.findAll();
	}
	
	@GetMapping("/evenements/{id}")
	public ResponseEntity<Evenement> getEvenementById(@PathVariable(value = "id") Long evenementId)
			throws ResourceNotFoundException {
		Evenement evenement = agent.findById(evenementId)
				.orElseThrow(() -> new ResourceNotFoundException("evenement not found for this id :: " + evenementId));
		return ResponseEntity.ok().body(evenement);
	}
	
	@PostMapping("/evenements")
	public Evenement createHote(@Valid @RequestBody Evenement evenement) {
		evenement.toString();
		return agent.save(evenement);
	}
	
	@PutMapping("/evenements/{id}")
	public ResponseEntity<Evenement> updateRdv(@PathVariable(value = "id") Long evenementId,
			@Valid @RequestBody Evenement evenementDetails) throws ResourceNotFoundException {
		Evenement evenement = agent.findById(evenementId)
				.orElseThrow(() -> new ResourceNotFoundException("evenement not found for this id :: " + evenementId));

		evenement.setId(evenementDetails.getId());
		evenement.setNom(evenementDetails.getNom());
		evenement.setDate(evenementDetails.getDate());
		evenement.setCategorie(evenementDetails.getCategorie());
		evenement.setHote(evenementDetails.getHote());
		final Evenement updatedevenement = agent.save(evenement);
		return ResponseEntity.ok(updatedevenement);
	}
	
	@DeleteMapping("/evenements/{id}")
	public Map<String, Boolean> deleteRdv(@PathVariable(value = "id") Long evenementId)
			throws ResourceNotFoundException {
		Evenement evenement = agent.findById(evenementId)
				.orElseThrow(() -> new ResourceNotFoundException("evenement not found for this id :: " + evenementId));

		agent.delete(evenement);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
