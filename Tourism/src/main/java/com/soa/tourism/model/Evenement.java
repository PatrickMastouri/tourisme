package com.soa.tourism.model;



import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="evenements")
public class Evenement  {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="date")
	private String date ;
	
	@Column(name="categorie")
	private String categorie;
	
	//@JsonBackReference
		@JoinColumn(name="ID_hote",referencedColumnName="id")
		@ManyToOne(optional=false)
		private Hote hote;
		
		
		@ManyToMany(cascade = CascadeType.ALL)
		private Set<User> Participants;
	

	public Hote getHote() {
			return hote;
		}

		public void setHote(Hote hote) {
			hote=new Hote();
		}

	public Evenement(long id, String nom, String date, String categorie, Hote hote) {
			super();
			this.id = id;
			this.nom = nom;
			this.date = date;
			this.categorie = categorie;
			this.hote = hote;
		}

	public Evenement() {
		super();
		this.hote=hote;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "Evenement [id=" + id + ", nom=" + nom + ", date=" + date + ", categorie=" + categorie + "]";
	}
	
	
}
