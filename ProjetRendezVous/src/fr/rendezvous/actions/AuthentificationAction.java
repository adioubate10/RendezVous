package fr.rendezvous.actions;


import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import fr.rendezvous.javabeans.Etudiant;
import fr.rendezvous.modeles.ModeleEtudiantDAO;


/**
 * diop
 */
@SuppressWarnings("serial")
public class AuthentificationAction extends ActionSupport implements SessionAware{
    private String identifiant;
    private String motDePasse;
	private Map<String,Object> sessionMap;
	

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
		
		ModeleEtudiantDAO modeleEtudiantDAO=null;
		Etudiant etudiant=null;
		
		
		// Initialisation des modèles
		
		modeleEtudiantDAO=new ModeleEtudiantDAO();

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
			/* On récupert un éventuel panier
			panier=(Commande)sessionMap.get("panier");
			// Si le panier n'existe pas on l'initialise
			if(panier==null)
			{
				panier=new Commande();
				panier=(Commande)sessionMap.put("panier",panier);
			}
			// On stocke les paramètres de l'utilisateur dans la session
			 * */
			 
			sessionMap.put("compte",etudiant);
			
			// Utilisateur est correctement connecté
			addActionMessage(getText("succes.authentification"));	
			return "accueil";
		}
		
		
		return ERROR;
	}
	
	
	
    }