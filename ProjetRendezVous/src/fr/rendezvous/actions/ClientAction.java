package fr.rendezvous.actions;


//import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import fr.rendezvous.javabeans.Client;
import fr.rendezvous.javabeans.Etudiant;
import fr.rendezvous.modeles.ModeleClientDAO;
import fr.rendezvous.modeles.ModeleEtudiantDAO;
import fr.rendezvous.boiteoutils.GestionDroit;



/**
 * @author Jérôme Lafosse
 * @copyright 2008
 * @version 0.1
 */
@SuppressWarnings("serial")
public class ClientAction extends ActionSupport 
{
	// Attributs
	private GestionDroit gestionDroit=null;
	//private HttpServletRequest request;
	// Objets
	private Client client;
	// id du client
	private EtudiantAction etudiantaction;

	private int idClient;
	private Etudiant etudiant;


	
	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Object getModel() {
		return client;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
	// Préparer les données pour les formulaires en modification
	public void prepare() throws Exception {
		// Initialisation du modèle
		ModeleClientDAO modeleClientDAO=new ModeleClientDAO();
		
		if(idClient==0) {
			client=new Client();
		} else {
			client=modeleClientDAO.getClient(idClient);
		}
	}
	
	


	
	 
	// Afficher le formulaire d'inscription d'un nouvel utilisateur
	public String ajouter()
	{	
		// Initialisation de la gestion des droits
		//gestionDroit=new GestionDroit(this.request);
		
		// On autorise uniquement les utilisateur anonyme
		
			return SUCCESS;
		
	}
	
	
	
	
	public String validerAjouter()
	{
		/* Varibales
				int codeErreur=0;
				// Initialisation du modèle
				ModeleClientDAO modeleClientDAO=new ModeleClientDAO();
				
				// On ajoute le client à la base de donnée, renvoi 1 si l'ajout s'est déroulé avec succès
				codeErreur=modeleClientDAO.ajouterClient(client);
					
				// On test le code de retour pour afficher un message de succes ou d'erreur
				if(codeErreur!=1)
				{		
					// Erreur lors de la création
					addActionError(getText("erreur.creationclient"));
					return ERROR;
				}
				else
				{	
					// Succès lors de la création
					addActionMessage(getText("succes.creationclient"));
					// retourner sur la page d'accueil du site
					return "accueil";
				}
				*/
		int codeErreur=0;
		ModeleEtudiantDAO modeletu=new ModeleEtudiantDAO();
		codeErreur=modeletu.ajouterClient(etudiant);
		if (codeErreur==1){
			// Succès lors de la création
			addActionMessage(getText("succes.creationclient"));
			// retourner sur la page d'accueil du site
			return "accueil";
		} else {
			// Erreur lors de la création
			addActionError(getText("erreur.creationclient"));
			return ERROR;
		}
			}
	
	// Afficher le formulaire de modification à partir des informations du modèle
		public String modifier()
		{	
			return SUCCESS;
		}
		
	
	// Modifier un utilisateur après vérification des saisies
	public String validerModifier()
	{
		// Varibales
		int codeErreur=0;
		// Initialisation du modèle
		ModeleClientDAO modeleClientDAO=new ModeleClientDAO();

		// Si l'utilisateur à changé son mot de passe on l'enregiste et on le Hash
		if(!client.getMotDePasse().equals(""))
		{
			client.setMotDePasse(client.getMotDePasse());
		}
		// Si l'utilisateur n'a pas changé son mot de passe, on récupert son mot de passe haché en session
		else
		{
		  String ancienMotDePasse = null;//=((Client)request.getSession().getAttribute("compte")).getMotDePasse();
			if(ancienMotDePasse!=null)
			{	
				client.setMotDePasse(ancienMotDePasse);
			}
			else
			{
				// Erreur lors de la lecture dans la session
				addActionError(getText("erreur.session"));
				return ERROR;
			}
		}
		
		// On modifie le client dans la base de données, on renvoie 1 si la modification s'est déroulée avec succès
		codeErreur=modeleClientDAO.modifierClient(client);
			
		// On test le code de retour pour afficher un message de succes ou d'erreur
		if(codeErreur!=1)
		{		
			// Erreur lors de la modification
			addActionError(getText("erreur.modificationclient"));
			return ERROR;
		}
		else
		{	
			// On remplace l'objet client dans la session par le nouvel objet
			//request.getSession().setAttribute("compte", client);
			// Succès lors de la modification
			addActionMessage(getText("succes.modificationclient"));
			// retourner sur la page d'accueil du site
			return "accueil";
		}
	}
	// Afficher le formulaire de consultation d'un nouvel utilisateur
		public String consulter()
		{	
			return SUCCESS;
		}

		public EtudiantAction getEtudiantaction() {
			return etudiantaction;
		}

		public void setEtudiantaction(EtudiantAction etudiantaction) {
			this.etudiantaction = etudiantaction;
		}
	
	
	
	
}
