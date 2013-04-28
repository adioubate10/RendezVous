package fr.rendezvous.actions;


//import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.google.gdata.data.calendar.CalendarEventEntry;
import com.google.gdata.util.ServiceException;
import com.opensymphony.xwork2.ActionSupport;

import fr.rendezvous.javabeans.Calendrier;
import fr.rendezvous.javabeans.Client;
import fr.rendezvous.javabeans.Etudiant;
import fr.rendezvous.javabeans.Professeur;
import fr.rendezvous.javabeans.RendezVous;
import fr.rendezvous.modeles.ModeleCalendrierDAO;
import fr.rendezvous.modeles.ModeleProfesseurDAO;
import fr.rendezvous.modeles.ModeleRendezVousDAO;
import fr.rendezvous.boiteoutils.GestionDroit;



/**
 * @author Dioubate
 * @copyright 2013
 * @version 0.1
 */
@SuppressWarnings("serial")
public class CalendrierAction extends ActionSupport implements SessionAware
{
	// Attributs
	private GestionDroit gestionDroit=null;
	//private HttpServletRequest request;
	// Objets
	private Client client=new Client();
	// id du client
	private Professeur professeur;
	
	
	private Etudiant etudiant=new Etudiant();

	private Calendrier calendrier;
	
	private RendezVous rendezvous;
	
	private CalendarEventEntry id;
	private Map<String, Object> sessionMap;
	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSession(Map<String,Object> map)
	{
		 this.sessionMap=map;
	}
	 
	public RendezVous getRendezvous() {
		return rendezvous;
	}

	public void setRendezvous(RendezVous rendezvous) {
		this.rendezvous = rendezvous;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Professeur getProfesseur() {
		return professeur;
	}

	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}

	public Calendrier getCalendrier() {
		return calendrier;
	}

	public void setCalendrier(Calendrier calendrier) {
		this.calendrier = calendrier;
	}

	
	
	


	
	 
	// Afficher le formulaire d'inscription d'un nouvel utilisateur
	public String ajouter()
	{	
		
		
			return SUCCESS;
		
	}
	public String synchroniser()
	{	
		
		   String id=getIdAgenda(professeur.getMail());
		 sessionMap.put("idgcalendrier",id);
		  
		  if(id!=null){
			  addActionMessage(getText("synchronisation succed"));
			return SUCCESS;
		  }
		  else
		  {
			  
			  addActionError(getText("erreur de synchonisation"));
			  return ERROR;
		  }
	}
	public String desynchroniser()
	{	
		
		 
		sessionMap.put("idgcalendrier",null);
		  
		 
	addActionMessage(getText("desynchronisation succed"));
			return SUCCESS;
		 
	}
	public String ajouterrdv()
	{	
		
		
			return SUCCESS;
		
	}
	public String getIdAgenda(String mail){
		
		return mail.substring(0, mail.length()-10);
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
		GCalendar c=new GCalendar();
		String id=c.ajouter(calendrier.getTitre(), calendrier.getDescription(),calendrier.getLieu(), calendrier.getDate(), calendrier.getCouleur(),professeur.getMail(),professeur.getMotDePasse());
			
		ModeleCalendrierDAO modeletu=new ModeleCalendrierDAO();
		codeErreur=modeletu.ajouterCalendrier(calendrier,id);
	// codeErreur=modeletu.ajouterCalendrier(calendrier,id);
		if (codeErreur==1) 	{
			// Succï¿½s lors de la crï¿½ation
			addActionMessage(getText("succes.creationcl"));
			// retourner sur la page d'accueil du site
			resultat=SUCCESS;
			
		} else {
			// Erreur lors de la crï¿½ation
			addActionError(getText("erreur.creationcl"));
			resultat=ERROR;
		}
	
		return resultat;
	}
	public String validerrdv() throws IOException, ServiceException
	{
	
	System.out.println(getIdAgenda(professeur.getMail()).concat("@gmail.com"));
	System.out.println(professeur.getMotDePasse());
	//au.getSessionMap().put("compte",professeur);
		String resultat=ERROR;
		int codeErreur=0;
		GRendezVous r=new GRendezVous();
		//if(professeur.getMail().equals(sessionMap.get(id)))
			//id=r.creerRdv(rendezvous.getTitre(),rendezvous.getAdresse(),rendezvous.getHeureDebut(),rendezvous.getHeureFin(),professeur.getMail(),professeur.getMotDePasse(),getIdAgenda(professeur.getMail()).concat("@gmail.com"));
		
		id=r.creerRdv(rendezvous.getTitre(),rendezvous.getAdresse(),rendezvous.getHeureDebut(),rendezvous.getHeureFin(),professeur.getMail(),professeur.getMotDePasse(),calendrier.getId().concat("@group.calendar.google.com"));
		
		 	if(id!=null){
		 ModeleRendezVousDAO modelerdv=new ModeleRendezVousDAO();
	     codeErreur=modelerdv.ajouterrdv(rendezvous,18);
			}
		if (codeErreur==1) 	{
			// Succï¿½s lors de la crï¿½ation
			addActionMessage(getText("succes.creationrdv"));
			// retourner sur la page d'accueil du site
			resultat=SUCCESS;
			
		} else {
			// Erreur lors de la crï¿½ation
			addActionError(getText("erreur.creationrdv"));
			resultat=ERROR;
		}
	
		return resultat;
	}
	
	// Afficher le formulaire de modification ï¿½ partir des informations du modï¿½le
		public String modifier()
		{	
			return SUCCESS;
		}
		
	
	// Afficher le formulaire de consultation d'un nouvel utilisateur
		public String consulter()
		{	
			
			return SUCCESS;
		}
		public String validerrecherche()
		{	ModeleProfesseurDAO modeleProfesseurDAO=null;
		    ModeleCalendrierDAO modeleCalendrierDAO=null;
		    modeleProfesseurDAO=new ModeleProfesseurDAO();
		    System.out.println(client.getNom());
			professeur=modeleProfesseurDAO.getId(client.getNom());
			sessionMap.put("cprofesseur",professeur);
			Calendrier calendrier=null;
			// Initialisation des modèles
			 modeleCalendrierDAO=new ModeleCalendrierDAO();
			 calendrier=modeleCalendrierDAO.getCalendrier(professeur.getIdClient());
			 sessionMap.put("pcalendrier",calendrier);
		
		if (professeur!=null) 	{
			// Succï¿½s lors de la crï¿½ation
			// retourner sur la page d'accueil du site
			return SUCCESS;
			
		} else {
			// Erreur lors de la crï¿½ation
			addActionError(getText("professeur de n'exite pas"));
			return ERROR;
		}
	
		}
		
	
	
	
	
}
