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
 * @author Dioubate
 * @copyright 2013
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
	
	
	// Pr�parer les donn�es pour les formulaires en modification
	public void prepare() throws Exception {
		// Initialisation du mod�le
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
				// Initialisation du mod�le
				ModeleClientDAO modeleClientDAO=new ModeleClientDAO();
				
				// On ajoute le client � la base de donn�e, renvoi 1 si l'ajout s'est d�roul� avec succ�s
				codeErreur=modeleClientDAO.ajouterClient(client);
					
				// On test le code de retour pour afficher un message de succes ou d'erreur
				if(codeErreur!=1)
				{		
					// Erreur lors de la cr�ation
					addActionError(getText("erreur.creationclient"));
					return ERROR;
				}
				else
				{	
					// Succ�s lors de la cr�ation
					addActionMessage(getText("succes.creationclient"));
					// retourner sur la page d'accueil du site
					return "accueil";
				}
				*/
		int codeErreur=0;
		ModeleEtudiantDAO modeletu=new ModeleEtudiantDAO();
		codeErreur=modeletu.ajouterClient(etudiant);
		if (codeErreur==1){
			// Succ�s lors de la cr�ation
			addActionMessage(getText("succes.creationclient"));
			// retourner sur la page d'accueil du site
			return "accueil";
		} else {
			// Erreur lors de la cr�ation
			addActionError(getText("erreur.creationclient"));
			return ERROR;
		}
			}
	
	// Afficher le formulaire de modification � partir des informations du mod�le
		public String modifier()
		{	
			return SUCCESS;
		}
		
	
	// Modifier un utilisateur apr�s v�rification des saisies
	public String validerModifier()
	{
		// Varibales
		int codeErreur=0;
		// Initialisation du mod�le
		ModeleClientDAO modeleClientDAO=new ModeleClientDAO();

		// Si l'utilisateur � chang� son mot de passe on l'enregiste et on le Hash
		if(!client.getMotDePasse().equals(""))
		{
			client.setMotDePasse(client.getMotDePasse());
		}
		// Si l'utilisateur n'a pas chang� son mot de passe, on r�cupert son mot de passe hach� en session
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
		
		// On modifie le client dans la base de donn�es, on renvoie 1 si la modification s'est d�roul�e avec succ�s
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
			// Succ�s lors de la modification
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
