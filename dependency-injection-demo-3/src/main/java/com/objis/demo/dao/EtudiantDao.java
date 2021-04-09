package com.objis.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.objis.demo.domaine.Etudiant;

public class EtudiantDao
{
	// Fields

	private static final Logger LOG = LogManager.getLogger(EtudiantDao.class);

	// Constructors

	public EtudiantDao()
	{
		super();
		LOG.info("Démarrage du dao EtudiantDao");
	}

	// Methods
	
	public void createEtudiant(Etudiant etudiant)
	{
		LOG.info("Création d'un étudiant : \"" + etudiant + "\"");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demojpa-pu");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		entityManager.persist(etudiant);

		entityTransaction.commit();

		entityManager.close();
		entityManagerFactory.close();
	}

	public Etudiant getEtudiant(int id)
	{
		LOG.info("Récupération de l'étudiant à l'id : \"" + id + "\"");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demojpa-pu");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Etudiant etudiant = entityManager.find(Etudiant.class, id);

		entityManager.close();
		entityManagerFactory.close();

		return etudiant;
	}

	public void updateEtudiant(int oldEtudiantId, Etudiant newEtudiant)
	{
		LOG.info("Mise à jour de l'étudiant à l'id : \"" + oldEtudiantId + "\" avec les données : \"" + newEtudiant + "\"");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demojpa-pu");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Etudiant oldStudent = entityManager.merge(getEtudiant(oldEtudiantId));

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		oldStudent.setNom(newEtudiant.getNom());
		oldStudent.setPrenom(newEtudiant.getPrenom());

		entityTransaction.commit();

		entityManager.close();
		entityManagerFactory.close();
	}

	public void deleteEtudiant(int id)
	{
		LOG.info("Suppression de l'étudiant à l'id : \"" + id + "\"");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demojpa-pu");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Etudiant etudiant = entityManager.merge(getEtudiant(id));

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		entityManager.remove(etudiant);

		entityTransaction.commit();

		entityManager.close();
		entityManagerFactory.close();
	}

	public List<Etudiant> getAllEtudiants()
	{
		LOG.info("Récupération de tous les étudiants");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demojpa-pu");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		List<Etudiant> students = entityManager.createQuery("SELECT e FROM Etudiant e", Etudiant.class).getResultList();

		entityManager.close();
		entityManagerFactory.close();

		return students;
	}
}
