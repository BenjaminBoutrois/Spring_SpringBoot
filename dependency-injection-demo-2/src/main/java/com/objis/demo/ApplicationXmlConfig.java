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
		// -> A partir du fichier de d�finition de beans
		// -> Cr�ation du container d'objets
		// -> Ce container permet d'injecter des objets dans le code
		////////////////////////////////////////////////
		ApplicationContext context = (ApplicationContext) new ClassPathXmlApplicationContext("demo-beans.xml");

		////////////////////////////////////////////////
		// (02.) RECUPERER UN BEAN
		// -> A partir de l'identifiant du Bean
		// -> Injection dans le code
		// -> L'Identifiant est d�fini dans le fichier de d�finition des beans(xml)
//      -> On passe l'identifiant � la m�thode getBean du container pour recup�rer l'objet
		////////////////////////////////////////////////
		EtudiantService etudiantService = (EtudiantService) context.getBean("etudiantService");

		////////////////////////////////////////////////
		// (03.) EXTRAIRE LES PROPRIETES DU BEAN
		////////////////////////////////////////////////
		
		Etudiant etudiant = new Etudiant("Giovanni", "Simon");
		Etudiant etudiant2 = new Etudiant("Ahmadou", "Lo");
		
		etudiantService.createEtudiant(etudiant);
		etudiantService.createEtudiant(etudiant2);

		LOGGER.info("+-------------------------------------------+");
		LOGGER.info("Liste des �tudiants :");
		LOGGER.info("+-------------------------------------------+");
		
		for (Etudiant currentEtudiant : etudiantService.getAllEtudiants())
		{
			LOGGER.info("Etudiant : " + currentEtudiant);
		}
	}

}
