package com.objis.demo;

public class Developpeur
{
	private String nom;
	private int anneesExperience;

	public Developpeur()
	{
		super();
	}

	public Developpeur(String nom, int anneeExperience)
	{
		super();
		this.nom = nom;
		this.anneesExperience = anneeExperience;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public int getAnneesExperience()
	{
		return anneesExperience;
	}

	public void setAnneesExperience(int anneeExperience)
	{
		this.anneesExperience = anneeExperience;
	}

	@Override
	public String toString()
	{
		return "Developpeur [nom=" + nom + ", anneesExperience=" + anneesExperience + "]";
	}

}
