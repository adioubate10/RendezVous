package fr.rendezvous.actions;


//import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionSupport;

import fr.rendezvous.javabeans.Calendrier;
import fr.rendezvous.javabeans.Client;
import fr.rendezvous.javabeans.Etudiant;
import fr.rendezvous.javabeans.Professeur;
import fr.rendezvous.modeles.ModeleCalendrierDAO;
import fr.rendezvous.modeles.ModeleProfesseurDAO;
import fr.rendezvous.boiteoutils.GestionDroit;



/**
 * @author Dioubate
 * @copyright 2013
 * @version 0.1
 */
@SuppressWarnings("serial")
public class CalendrierAction extends ActionSupport 
{
	// Attributs
	private GestionDroit gestionDroit=null;
	//private HttpServletRequest request;
	// Objets
	private Client client=new Client();
	// id du client
	private Professeur professeur=null;
	
	
	private Etudiant etudiant=new Etudiant();

	private Calendrier calendrier;
	

	public Calendrier getCalendrier() {
		return calendrier;
	}

	public void setCalendrier(Calendrier calendrier) {
		this.calendrier = calendrier;
	}

	
	
	


	
	 
	// Afficher le formulaire d'inscription d'un nouvel utilisateur
	public String ajouter()
	{	
		// Initialisation de la gestion des droits
		//gestionDroit=new GestionDroit(this.request);
		
		// On autorise uniquement les utilisateur anonyme
		
			return SUCCESS;
		
	}
	
	
	public String valider()
	{
	ModeleProfesseurDAO modeleProfesseurDAO=null;
	modeleProfesseurDAO=new ModeleProfesseurDAO();
	professeur=modeleProfesseurDAO.getClient(calendrier.getProfesseur());
	System.out.println(professeur.getMail());
	//au.getSessionMap().put("compte",professeur);
		String resultat=ERROR;
		int codeErreur=0;
		CalendarAction c=new CalendarAction();
		String id=c.ajouter(calendrier.getTitre(), calendrier.getDescription(),calendrier.getLieu(), calendrier.getDate(), calendrier.getCouleur(),professeur.getMail(),professeur.getMotDePasse());
			
		ModeleCalendrierDAO modeletu=new ModeleCalendrierDAO();
	 codeErreur=modeletu.ajouterCalendrier(calendrier,id);
		if (codeErreur==1) 	{
			// Succ�s lors de la cr�ation
			addActionMessage(getText("succes.creationclient"));
			// retourner sur la page d'accueil du site
			resultat=SUCCESS;
			
		} else {
			// Erreur lors de la cr�ation
			addActionError(getText("erreur.creationclient"));
			resultat=ERROR;
		}
	
		return resultat;
	}
	
	// Afficher le formulaire de modification � partir des informations du mod�le
		public String modifier()
		{	
			return SUCCESS;
		}
		
	
	// Afficher le formulaire de consultation d'un nouvel utilisateur
		public String consulter()
		{	
			return SUCCESS;
		}

		
	
	
	
	
}
