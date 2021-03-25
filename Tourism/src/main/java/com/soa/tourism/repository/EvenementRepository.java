package com.soa.tourism.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soa.tourism.model.Evenement;

public interface EvenementRepository extends JpaRepository<Evenement,Long> {

}
