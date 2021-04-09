package com.objis.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

import com.objis.demo.domaine.Etudiant;
import com.objis.demo.service.EtudiantService;

@SpringBootApplication
public class Application
{
	private static final Logger LOGGER = Logger.getLogger(Application.class);

	public static void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
		
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
