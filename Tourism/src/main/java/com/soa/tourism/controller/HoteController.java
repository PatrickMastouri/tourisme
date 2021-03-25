package com.soa.tourism.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

import com.soa.tourism.model.Hote;
import com.soa.tourism.repository.HoteRepository;



@RestController
@RequestMapping("/api/v1")
public class HoteController {
	
	@Autowired
	HoteRepository agent;
	@GetMapping("/hotes")
	public List<Hote> getAllHote() {
		List<Hote> listhote = agent.findAll();
		// Sort.by("specialite").ascending()
		return (listhote); 
	}
	
	@GetMapping("/hotes/{id}")
	public ResponseEntity<Hote> getMedecinById(@PathVariable(value = "id") Long hoteId)
			throws ResourceNotFoundException {

		Hote hote = agent.findById(hoteId)
				.orElseThrow(
						() -> new ResourceNotFoundException("hote not found for this id :: " + hoteId));
		return ResponseEntity.ok().body(hote);
	}
	
	@PostMapping("/hotes")
	public Hote createHote(@Valid @RequestBody Hote hote) {

		return agent.save(hote);
	}
	
	@PutMapping("/hotes/{id}")
	public ResponseEntity<Hote> updateHote(@PathVariable(value = "id") Long hoteId,
			@Valid @RequestBody Hote HoteDetails) throws ResourceNotFoundException {
		Hote hote = agent.findById(hoteId)
				.orElseThrow(() ->
						new ResourceNotFoundException("hote not found for this id :: " + hoteId));

		hote.setId(HoteDetails.getId());
		hote.setNom(HoteDetails.getNom());
		hote.setType(HoteDetails.getType());
		hote.setEmail(HoteDetails.getEmail());
		hote.setTelephone(HoteDetails.getTelephone());
		hote.setVille(HoteDetails.getVille());
		hote.setCodePostal(HoteDetails.getCodePostal());
		hote.setActivite(HoteDetails.getActivite());
		hote.setPrix(HoteDetails.getPrix());
		hote.setDescription(HoteDetails.getDescription());

		//medDetails.setId(med.getId());

		hote = agent.save(hote);
		return ResponseEntity.ok(hote);
	}
	
	@DeleteMapping("/hotes/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
		Hote hote = agent.findById(id)
				.orElseThrow(
				() -> new ResourceNotFoundException("hote not found for "
						+ "this id :: " + id));

		agent.delete(hote);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	

}
