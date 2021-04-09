/**
 * 
 */
package com.objis.demo;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.objis.demo.domaine.Etudiant;
import com.objis.demo.service.EtudiantService;

/**
 * @author TD
 *
 */
public class ApplicationXmlConfig
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		final Logger LOGGER = Logger.getLogger(ApplicationXmlConfig.class);

		////////////////////////////////////////////////
		// (01.) CHARGER LE CONTEXTE DE L'APPLICATION
		// -> A partir du fichier de définition de beans
		// -> Creation du container d'objets
		// -> Ce container permet d'injecter des objets dans le code
		////////////////////////////////////////////////
		ApplicationContext context = (ApplicationContext) new ClassPathXmlApplicationContext("demo-beans.xml");

		////////////////////////////////////////////////
		// (02.) RECUPERER UN BEAN
		// -> A partir de l'identifiant du Bean
		// -> Injection dans le code
		// -> L'Identifiant est défini dans le fichier de definition des beans(xml)
		//      -> On passe l'identifiant à la methode getBean du container pour récupérer l'objet
		////////////////////////////////////////////////
		EtudiantService etudiantService = (EtudiantService) context.getBean("etudiantService");

		////////////////////////////////////////////////
		// (03.) EXTRAIRE LES PROPRIETES DU BEAN
		////////////////////////////////////////////////
		
		Etudiant etudiant = new Etudiant("Fatimata", "Ba");
		Etudiant etudiant2 = new Etudiant("Douglas", "Mbiandou");
		
		etudiantService.createEtudiant(etudiant);
		etudiantService.createEtudiant(etudiant2);

		LOGGER.info("+-------------------------------------------+");
		LOGGER.info("Liste des étudiants :");
		LOGGER.info("+-------------------------------------------+");
		
		for (Etudiant currentEtudiant : etudiantService.getAllEtudiants())
		{
			LOGGER.info("Etudiant : " + currentEtudiant);
		}
	}

}
