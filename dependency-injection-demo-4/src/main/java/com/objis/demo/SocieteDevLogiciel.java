package com.objis.demo;

public class SocieteDevLogiciel
{

	private Developpeur developpeurDebutant;
	private Developpeur chefDeveloppeur;

	public SocieteDevLogiciel()
	{
		super();
	}

	public SocieteDevLogiciel(Developpeur developpeurDebutant, Developpeur chefDeveloppeur)
	{
		super();
		this.developpeurDebutant = developpeurDebutant;
		this.chefDeveloppeur = chefDeveloppeur;
	}

	public Developpeur getDeveloppeurDebutant()
	{
		return developpeurDebutant;
	}

	public void setDeveloppeurDebutant(Developpeur developpeurDebutant)
	{
		this.developpeurDebutant = developpeurDebutant;
	}

	public Developpeur getChefDeveloppeur()
	{
		return chefDeveloppeur;
	}

	public void setChefDeveloppeur(Developpeur chefDeveloppeur)
	{
		this.chefDeveloppeur = chefDeveloppeur;
	}

	@Override
	public String toString()
	{
		return "SocieteDevLogiciel [developpeurDebutant=" + developpeurDebutant + ", chefDeveloppeur=" + chefDeveloppeur
				+ "]";
	}

}
