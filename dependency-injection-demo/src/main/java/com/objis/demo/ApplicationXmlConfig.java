/**
 * 
 */
package com.objis.demo;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
		SocieteDevLogiciel societe = (SocieteDevLogiciel) context.getBean("societeDevLogiciel");

		////////////////////////////////////////////////
		// (03.) EXTRAIRE LES PROPRIETES DU BEAN
		////////////////////////////////////////////////
		Developpeur devDebutant = societe.getDeveloppeurDebutant();
		Developpeur chefDev = societe.getChefDeveloppeur();

		////////////////////////////////////////////////
		// (04.) AFFICHER LES PROPRIETES DU BEAN
		////////////////////////////////////////////////
		LOGGER.info("+-------------+------------------------------+");
		LOGGER.info("| NOM DU BEAN | VALEUR DU BEAN               |");
		LOGGER.info("+-------------+------------------------------+");
		LOGGER.info("| devDebutant | " + devDebutant);
		LOGGER.info("| chefDev     | " + chefDev);
		LOGGER.info("+-------------+------------------------------+");
	}

}
