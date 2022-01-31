package com.travelExpress.covoiturage.models;


import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User{	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;
	
	@Basic
	@Column(name="username",length= 30, nullable=false)
    private String username;
	
	@Basic
	@Column(name="prenom",length= 30, nullable=false)
    private String prenom;
	
	@Basic
	@Column(name="email",length= 255, nullable=false)
	private String email;
	
	@Basic
	@Column(name="password",length= 255, nullable=false)
	private String password;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Compte> compte;
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User( String username, String prenom, String email, String password) {
		super();
		this.username = username;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
	}


	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
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
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Compte> getCompte() {
		return compte;
	}

	public void setCompte(List<Compte> compte) {
		this.compte = compte;
	}

	

}
