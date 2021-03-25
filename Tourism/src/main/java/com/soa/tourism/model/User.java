package com.soa.tourism.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="User")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="nom")
	private String nom;
	
	
	@Column(name="prenom")
	private String prenom;
	
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	

	@Enumerated(EnumType.STRING)
	private com.soa.tourism.model.Role role;
	
	
	@ManyToMany(mappedBy="Participants", cascade = CascadeType.ALL)
	private Set<Evenement> evenement;

	public User(int id, String nom, String prenom, String email, String password, Role role) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	



	
	
	
	public User() {
		super();
	}








	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}





	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public com.soa.tourism.model.Role getRole() {
		return role;
	}


	public void setRole(com.soa.tourism.model.Role role) {
		this.role = role;
	}
	
	

}
