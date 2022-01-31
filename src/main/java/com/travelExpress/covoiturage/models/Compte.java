package com.travelExpress.covoiturage.models;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_compte")
public abstract class Compte implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCompte;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public Compte() {
		super();
	}

	public Compte(User user) {
		super();
		this.user = user;
	}

	public Integer getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(Integer idCompte) {
		this.idCompte = idCompte;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	
	
}
