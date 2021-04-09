package com.objis.demo.domaine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Etudiant
{
	// Fields
	
	@Id
	@GeneratedValue
	private int id;
	private String prenom;
	private String nom;
	
	// Constructors
	
	public Etudiant()
	{
		super();
	}
	
	public Etudiant(String prenom, String nom)
	{
		super();
		this.prenom = prenom;
		this.nom = nom;
	}
	
	// Properties

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}
	public String getPrenom()
	{
		return prenom;
	}
	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}
	public String getNom()
	{
		return nom;
	}
	public void setNom(String nom)
	{
		this.nom = nom;
	}
	
	@Override
	public String toString()
	{
		return "Etudiant [id=" + id + ", prenom=" + prenom + ", nom=" + nom + "]";
	}
}
