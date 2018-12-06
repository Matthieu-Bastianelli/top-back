package dev.top.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="collegue")
public class Collegue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column
	private String nom;
	
	@Column
	private Integer score;
	
	@Column
	private String lienPhoto;
	
	@Column
	private String email;

	public Collegue() {
	}
	
	public Collegue(String nom, Integer score, String lienPhoto, String email) {
		super(); 
		this.nom = nom;
		this.score = score;
		this.lienPhoto = lienPhoto;
		this.email =email;
	}
	
	public void miseAJourCollegue(String nom, Integer score, String lienPhoto, String email) {
		this.nom = nom;
		this.score = score;
		this.lienPhoto = lienPhoto;
		this.email =email;
	}

	public Integer getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getLienPhoto() {
		return lienPhoto;
	}

	public void setLienPhoto(String lienPhoto) {
		this.lienPhoto = lienPhoto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
