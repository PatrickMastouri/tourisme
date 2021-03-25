package com.soa.tourism.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="hotes")
public class Hote implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	
	@Column(name="nom")
	private String nom;
	
	
	@Column(name="type")
	private String type;
	
	
	@Column(name="email")
	private String email;
	
	
	@Column(name="telephone")
	private String telephone;
	
	
	@Column(name="ville")
	private String ville;
	
	
	@Column(name="codepostal")
	private long codePostal;
	
	
	@Column(name="activite")
	private String activite;
	
	
	@Column(name="prix")
	private String prix;
	
	
	@Column(name="description")
	private String description;
	
	public Hote() {}

	public Hote(long id, String nom, String type, String email, String telephone, String ville, long codePostal,
			String activite, String prix, String description) {
		super();
		this.id = id;
		this.nom = nom;
		this.type = type;
		this.email = email;
		this.telephone = telephone;
		this.ville = ville;
		this.codePostal = codePostal;
		this.activite = activite;
		this.prix = prix;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public long getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(long codePostal) {
		this.codePostal = codePostal;
	}

	public String getActivite() {
		return activite;
	}

	public void setActivite(String activite) {
		this.activite = activite;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Hote [id=" + id + ", nom=" + nom + ", type=" + type + ", email=" + email + ", telephone=" + telephone
				+ ", ville=" + ville + ", codePostal=" + codePostal + ", activite=" + activite + ", prix=" + prix
				+ ", description=" + description + "]";
	}
	
	//@JsonManagedReference 
	@OneToMany(mappedBy="hote",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	private List<Evenement> levents;

	public List<Evenement> getLevents() {
		return levents;
	}

	public void setLevents(List<Evenement> levents) {
		this.levents = levents;
	}
	


	
	
}
