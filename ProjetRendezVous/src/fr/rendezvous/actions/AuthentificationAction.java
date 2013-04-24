package fr.rendezvous.actions;


import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import fr.rendezvous.javabeans.Calendrier;
import fr.rendezvous.javabeans.Etudiant;
import fr.rendezvous.javabeans.Professeur;
import fr.rendezvous.modeles.ModeleCalendrierDAO;
import fr.rendezvous.modeles.ModeleEtudiantDAO;
import fr.rendezvous.modeles.ModeleProfesseurDAO;


/**
 * diop
 */
@SuppressWarnings("serial")
public class AuthentificationAction extends ActionSupport implements SessionAware{
    private String identifiant;
    private String motDePasse;
	private Map<String,Object> sessionMap;
	

	public AuthentificationAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthentificationAction(String identifiant, String motDePasse,
			Map<String, Object> sessionMap) {
		super();
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.sessionMap = sessionMap;
	}

	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSession(Map<String,Object> map)
	{
		 this.sessionMap=map;
	}
	 
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
    
	
	@SuppressWarnings("unused")
	public String execute()
	{
		// Variables
		ModeleProfesseurDAO modeleProfesseurDAO=null;
		ModeleEtudiantDAO modeleEtudiantDAO=null;
		ModeleCalendrierDAO modeleCalendrierDAO=null;
		Etudiant etudiant=null;
		Professeur professeur=null;
		Calendrier calendrier=null;
		// Initialisation des modèles
		 modeleCalendrierDAO=new ModeleCalendrierDAO();
		 modeleEtudiantDAO=new ModeleEtudiantDAO();
		 modeleProfesseurDAO=new ModeleProfesseurDAO();
		 if((etudiant=modeleEtudiantDAO.getClient(identifiant))!=null)
		{
			// Si c'est le cas on test le mot de passe
			if(!etudiant.getMotDePasse().equals(motDePasse))
			{
				// Si le mot de passe est incorrect on envoie un message d'erreur
				addActionError(getText("erreur.authentificationclient"));
				return ERROR;
			}
		}
		 else if((professeur=modeleProfesseurDAO.getClient(identifiant))!=null)
			{    if(!professeur.getMotDePasse().equals(motDePasse))
				{
					// Si le mot de passe est incorrect on envoie un message d'erreur
					addActionError(getText("erreur.authentificationclient"));
					return ERROR;
				}
			}
		// Si l'identifiant n'appartient ni à un administrateur ni à un client, l'identifiant est incorrect
		else
		{
			addActionError(getText("erreur.compte"));
			return ERROR;
		}
		
		 /*
		// Si il n'y a pas d'erreurs on créé en session un objet compte contenant les informations du client ou de l'administrateur 
		if(administrateur!=null)
		{
			//l'administrateur est correctement connecté	
			sessionMap.put("compte", administrateur);
			addActionMessage(getText("succes.authentification"));
			return "admin";
		}
		*/
		//Pour les clients
		if(etudiant!=null)
		{
			
			 
			sessionMap.put("compte",etudiant);
			
			// Utilisateur est correctement connecté
			addActionMessage(getText("succes.authentification"));	
			return "accueil";
		}
		if(professeur!=null)
		{   calendrier=modeleCalendrierDAO.getCalendrier(professeur.getIdClient());
			// On récupert un éventuel calendrier
			if(calendrier!=null){
			   sessionMap.put("calendrier",calendrier);
						// Si le calendrier n'existe pas on l'initialise
			
			// Si c'est le cas on test le mot de passe
		    // System.out.println(calendrier.getId());
		    // System.out.println(calendrier.getProfesseur());
		    // System.out.println(calendrier.getTitre());
			}
			else
						{
							calendrier=new Calendrier();
							//calendrier=(Calendrier)sessionMap.put("calendrier",calendrier);
						}
			 
			sessionMap.put("compte",professeur);
			//sessionMap.put("compte",calendrier);
			// Utilisateur est correctement connecté
			addActionMessage(getText("succes.authentification"));	
			return "accueil";
		}
		
		return ERROR;
	}
	
	
	
    }