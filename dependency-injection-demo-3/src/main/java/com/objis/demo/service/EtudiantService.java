package com.objis.demo.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.objis.demo.dao.EtudiantDao;
import com.objis.demo.domaine.Etudiant;

public class EtudiantService
{
	// Fields
	
	private static final Logger LOG = LogManager.getLogger(EtudiantService.class);
	private EtudiantDao etudiantDao;
	
	// Constructors

	public EtudiantService()
	{
		super();
		LOG.info("Démarrage du service EtudiantService");
	}

	public EtudiantService(EtudiantDao etudiantDao)
	{
		super();
		this.etudiantDao = etudiantDao;
		LOG.info("Démarrage du service EtudiantService");
	}
	
	// Properties
	
	public EtudiantDao getEtudiantDao()
	{
		return etudiantDao;
	}

	public void setEtudiantDao(EtudiantDao etudiantDao)
	{
		this.etudiantDao = etudiantDao;
	}
	
	// Methods
	
	public void createEtudiant(Etudiant etudiant)
	{
		etudiantDao.createEtudiant(etudiant);
	}
	
	public Etudiant getEtudiant(int id)
	{
		return etudiantDao.getEtudiant(id);
	}
	
	public void updateEtudiant(int oldEtudiantId, Etudiant newEtudiant)
	{
		etudiantDao.updateEtudiant(oldEtudiantId, newEtudiant);
	}
	
	public void deleteEtudiant(int id)
	{
		etudiantDao.deleteEtudiant(id);
	}
	
	public List<Etudiant> getAllEtudiants()
	{
		return etudiantDao.getAllEtudiants();
	}
}
