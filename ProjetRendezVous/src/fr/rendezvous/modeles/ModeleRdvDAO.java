package fr.rendezvous.modeles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.rendezvous.boiteoutils.GestionBaseDeDonnees;
import fr.rendezvous.javabeans.Client;

public class ModeleRdvDAO extends ModeleDAO
{
	// Variables
	Connection connexion=null;
	ResultSet resultat=null;
	
	
	// Constructeur par d�faut
	public ModeleRdvDAO ()
	{

	}
	
	
	
	
	// Ajouter un client
	public int ajouterClient(Client client) 
	{
		// Variables
		PreparedStatement requete=null;
		String requeteString=null;
		int codeErreur=0;
		
		try 
		{	
			// Ouverture d'une connexion
			connexion=super.getConnection();
			
			// Cr�ation de la requ�te
			requeteString="INSERT INTO rendez_vous(adresse_rdv,titre_rdv,description_rdv,heure_deb,huere_fin,id_calendrier,id_etudiant,id_patient) VALUES (?,?,?,?,?,?,?,?)";
			
			// Pr�paration de la requ�te
			requete=connexion.prepareStatement(requeteString);
			requete.setString(1,(String)client.getNom());
			requete.setString(2,(String)client.getPrenom());
			requete.setString(3,(String)client.getMail());
			requete.setString(4,(String)client.getAdresse());
			requete.setString(5,(String)client.getCodePostal());
			requete.setString(6,(String)client.getIdentifiant());
			requete.setString(7,(String)client.getMotDePasse());
			requete.setString(8,(String)client.getTelephone());
			requete.setString(9,(String)client.getVille());
			requete.setString(10,(String)client.getPays());
			
			// On vide le client par securité
			client=null;
			
			// Execution de la requete
			codeErreur=requete.executeUpdate();
		}
		catch (Exception e) 
		{
			codeErreur=0;
			System.out.println("Erreur dans la requete dans la classe ModeleClient.java fonction creerClient");
		}
		finally
		{
			try
			{
				// Fermeture de la connexion
				if(resultat!=null)
				{
					GestionBaseDeDonnees.closeResulset(resultat);
				}
				if(requete!=null)
				{
					GestionBaseDeDonnees.closeRequest(requete);
				}
				if(connexion!=null)
				{
					GestionBaseDeDonnees.closeConnection(connexion);
				}
			}
			catch(Exception ex)
			{
				System.out.println("Erreur lors de la fermeture de la connexion avec la base de donn�es dans la classe ModelClient fonction creerClient");
			}	
		}
		
		// Retourne le code d'erreur
		return codeErreur;
	}

	
	
	
}
