package com.objis.demo;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.objis.demo.dao.EtudiantDao;
import com.objis.demo.domaine.Etudiant;
import com.objis.demo.service.EtudiantService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Configuration
public class ApplicationAnnotationConfig
{

	private static final Logger LOGGER = Logger.getLogger(ApplicationAnnotationConfig.class);

	public static void main(String[] args)
	{

		////////////////////////////////////////////////
		// (01.) CHARGER LE CONTEXTE DE L'APPLICATION
		// -> A partir du fichier de définition de beans
		////////////////////////////////////////////////
		ApplicationContext appContext = new AnnotationConfigApplicationContext(EtudiantServiceConfig.class);

		////////////////////////////////////////////////
		// (02.) RECUPERER UN BEAN
		// -> A partir du contexte de l'application
		////////////////////////////////////////////////
		EtudiantService etudiantService = (EtudiantService) appContext.getBean(EtudiantService.class);

		////////////////////////////////////////////////
		// (03.) EXTRAIRE LES PROPRIETES DU BEAN
		////////////////////////////////////////////////
		
		Etudiant etudiant = new Etudiant("Fatimata", "Ba");
		Etudiant etudiant2 = new Etudiant("Douglas", "Mbiandou");
		
		etudiantService.createEtudiant(etudiant);
		etudiantService.createEtudiant(etudiant2);
		
		////////////////////////////////////////////////
		// (04.) AFFICHER LES PROPRIETES DU BEAN
		////////////////////////////////////////////////

		LOGGER.info("+-------------------------------------------+");
		LOGGER.info("Liste des étudiants :");
		LOGGER.info("+-------------------------------------------+");
		
		for (Etudiant currentEtudiant : etudiantService.getAllEtudiants())
		{
			LOGGER.info("Etudiant : " + currentEtudiant);
		}
	}

}
