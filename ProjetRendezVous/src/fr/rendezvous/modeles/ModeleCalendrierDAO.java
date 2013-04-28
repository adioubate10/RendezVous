package fr.rendezvous.modeles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import fr.rendezvous.boiteoutils.GestionBaseDeDonnees;
//import fr.rendezvous.javabeans.Client;
import fr.rendezvous.javabeans.Calendrier;
import fr.rendezvous.javabeans.Etudiant;
import fr.rendezvous.javabeans.Professeur;
import fr.rendezvous.javabeans.RendezVous;

public class ModeleCalendrierDAO extends ModeleDAO
{
	// Variables
	Connection connexion=null;
	ResultSet resultat=null;
	
	
	
	
	// Constructeur par défaut
	public ModeleCalendrierDAO ()
	{

	}
	
	
	
	// Ajouter un client
	public int ajouterCalendrier(Calendrier c, String id) 
	{
		// Variables
		PreparedStatement requete=null;
		String requeteString=null;
		int codeErreur=0;
		
		try 
		{	
			// Ouverture d'une connexion
			connexion=super.getConnection();
			
			// Création de la requête
			requeteString="INSERT INTO calendrier(titre,description,dates,couleur,id_professeur,id) VALUES (?,?,?,?,?,?)";
			
			// Préparation de la requête
			requete=connexion.prepareStatement(requeteString);
			requete.setString(1,(String)c.getTitre());
			requete.setString(2,(String)c.getDescription());
			requete.setString(3,(String)c.getDate());
			requete.setString(4,(String)c.getCouleur());
			
			requete.setInt(5,(int)c.getProfesseur());
			requete.setString(6,id);
			System.out.println((String)c.getTitre());
			System.out.println((String)c.getDescription());
			System.out.println((String)c.getDate());
			System.out.println((String)c.getCouleur());
			System.out.println("idcal"+id);
			//requete.setString(4,(String)c.getIdProfesseur());
			// On vide le client par sécurité
			c=null;
			
			// Execution de la requête
			codeErreur=requete.executeUpdate();
			System.out.println(getId(5));
		}
		catch (Exception e) 
		{
			codeErreur=0;
			System.out.println("Erreur dans la requete dans la classe ModeleCalendrier.java fonction creerCalendrier"+e.getMessage());
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
				System.out.println("Erreur lors de la fermeture de la connexion avec la base de données dans la classe ModelClient fonction creerClient");
			}	
		}
		
		// Retourne le code d'erreur
		return codeErreur;
	}

	
	
	public List<Calendrier> listeCl(int id_prof)
	{	
		/* Variables */
		PreparedStatement requete = null;
		Calendrier cl = null;
		String requeteString = null;
		List<Calendrier> listeCl = new ArrayList<Calendrier>();
	
		try
		{			
			/* Ouverture d'une connexion */
			connexion = super.getConnection();
		
			/* Création de la requête */
			requeteString = "SELECT * FROM calendrier where id_professeur=?";
			
			/* Préparation de la requête */
			requete = connexion.prepareStatement(requeteString);
    		requete.setInt(1,id_prof);
			/* Execution de la requête */
			resultat = requete.executeQuery();

			/* On stocke le resultat dans une liste */
			if(resultat != null)
			{
				while(resultat.next())
				{
					/* On effectue le mappage des attributs avec les champs de la table SQL */
					cl = clAttribusMapper(resultat);
					
					/* Ajoute l'objet a la liste de client */
					listeCl.add((Calendrier)cl);
				}
			}
		}
		
		catch(Exception e)
		{
			System.out.println("Erreur dans la requete dans la classe ModeleClient fonction listerClient");
		}
		
		finally
		{
			try
			{
				/* Fermeture de la connexion */
				if(resultat != null)
				{
					GestionBaseDeDonnees.closeResulset(resultat);
				}
				if(requete != null)
				{
					GestionBaseDeDonnees.closeRequest(requete);
				}
				if(connexion != null)
				{
					GestionBaseDeDonnees.closeConnection(connexion);
				}
			}
			catch(Exception ex)
			{
				System.out.println("Erreur lors de la fermeture de la connexion avec la base de données dans la classe ModeleClients fonction listerClient");
			}	
		}
		
		/* Retourner la liste des clients */
		return listeCl;
	}


	
	// Retourner les informations d'un client
    public Calendrier getCalendrier(int id_prof)
    {
    	/* Variables */
    	PreparedStatement requete = null;
    	Calendrier cl = null;
    	String requeteString = null;
      
    	try
    	{
    		/* Ouverture d'une connexion */
    		connexion = super.getConnection();
    		
    		/* Création de la requête */
    		requeteString = "SELECT * FROM calendrier where id_professeur=?";
    		
    		/* Preparer la requete */
    		requete = connexion.prepareStatement(requeteString);
    		requete.setInt(1,id_prof);
    			
    		/* Execution de la requête */
    		resultat = requete.executeQuery();
    		
    		/* On stocke le resultat dans la l'objet client */
    		if(resultat != null)
    		{
    			if(resultat.next())
    			{
    				/* On mappe les attribus du client dans la classe avec la base */
    				cl= clAttribusMapper(resultat); 				
    			}
    		}
       	}
    
    	catch(Exception e)
    	{
    		/* Si l'identifant du client n'existe pas, on initialise l'objet client à null */
			cl = null;
    		System.out.println("Erreur dans la requête dans la classe ModeleClient.java fonction getClient");    		
    	}
    	
    	finally
    	{
    		try
    		{
    			/* Fermeture de la connexion */
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
    			System.out.println("Erreur lors de la fermeture de la connexion avec la base de données dans la classe ModeleClient.java fonction getClient");
    		}	
    	}
    	
    	/* Retourner un client */
    	return cl;
    }
    
    
    
    
    // Retourner les informations d'un client à partir de son idClient
    public String getId(int id_prof)
    {
    	// Variables
    	PreparedStatement requete=null;
    	String id=null;
    	String requeteString=null;
    
    	try
    	{
    		// Ouverture d'une connexion
    		connexion=super.getConnection();
    		
    		// Création de la requête
    		requeteString="SELECT * FROM calendrier where id_professeur = ?";
    		
    		// Preparer la requete
    		requete=connexion.prepareStatement(requeteString);
    		requete.setInt(1,id_prof);
    			
    		// Execution de la requête
    		resultat=requete.executeQuery();
    		
    		// On stocke le resultat dans la l'objet client
    		if(resultat!=null)
    		{
    			if(resultat.next())
    			{
    				// On mappe les attribus du client dans la classe avec la base
    				id=resultat.getString("id"); 				
    			}
    		}
       	}
    	catch(Exception e)
    	{
    		// Si l'identifant du client n'existe pas, on initialise l'objet client à null
			id=null;
    		System.out.println("Erreur dans la requête dans la classe ModeleClient.java fonction getClient");    		
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
    			System.out.println("Erreur lors de la fermeture de la connexion avec la base de données dans la classe ModeleClient.java fonction getClient");
    		}	
    	}
    	
    	// Retourner un client
    	return id;
    }
   
    
   
    // Modification d'un client
   



    // Supprimer un client
    public int supprimerClient(int idClient)
	{	
		// Variables
		PreparedStatement requete=null;
		//ModeleRaccourciDAO modeleRaccourciDAO=null;
		String requeteString=null;
		int codeErreur=0;
	
		try
		{	
			// Initialisation du modèle raccourci
			//modeleRaccourciDAO=new ModeleRaccourciDAO();
			
			// Ouverture d'une connexion
			connexion=super.getConnection();
			
			// Annulation de l'autocommit
			connexion.setAutoCommit(false);
			
			// Première requête : suppression du client
			requeteString="DELETE FROM Etudiant WHERE id_etudiant = ?";
			
			// Préparation de la requête
			requete=connexion.prepareStatement(requeteString);
			requete.setInt(1, idClient);
			
			// Execution de la requête
			codeErreur=requete.executeUpdate();
			
			// Si il n'y a pas eut d'erreur durant la suppression du client, on peut supprimer les raccourcis associés au client.
			if(codeErreur==1)
			{
				// Deuxième requête : suppression des raccourcis du client
				//codeErreur=modeleRaccourciDAO.supprimerRaccourcisClient(idClient);
			}
			
			// Si il n'y a pas eu d'erreur durant la suppression des raccourcis du client, ou du client lui même : on fait un commit, sinon un rollback
			if(codeErreur==1)
			{
				GestionBaseDeDonnees.commit(connexion);
			}
			else
			{
				GestionBaseDeDonnees.rollback(connexion);
			}
		}
		catch(Exception e)
		{
			codeErreur=0;
			GestionBaseDeDonnees.rollback(connexion);
			System.out.println("Erreur dans la requete dans la classe ModeleClient fonction supprimerClient");
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
				System.out.println("Erreur lors de la fermeture de la connexion avec la base de données dans la classe ModeleClient fonction supprimerClient");
			}	
		}
		
		// Retourner le code d'erreur
		return codeErreur;
	}

    
    
    
    
    
    // Transformer Relation vers Objet
	public Calendrier clAttribusMapper(ResultSet resultat)
	{
		// Variables
		Calendrier cl=new Calendrier();
		
		try 
		{	
			if (resultat.getInt("id_calendrier")==0)
			{
				cl.setIdentifient(0);	
			}
			else 
			{
				cl.setIdentifient(resultat.getInt("id_calendrier"));	
			}
			
			if (resultat.getString("titre")==null)
			{
				cl.setTitre("");
			}
			else 
			{
				cl.setTitre(resultat.getString("titre"));	
			}
			if (resultat.getString("description")==null)
			{
				cl.setDescription("");
			}
			else 
			{
				cl.setDescription(resultat.getString("description"));	
			}
			if (resultat.getString("couleur")==null)
			{
				cl.setCouleur("");
			}
			else 
			{
				cl.setCouleur(resultat.getString("couleur"));	
			}
			if (resultat.getString("dates")==null)
			{
				cl.setDate("");
			}
			else 
			{
				cl.setDate(resultat.getString("dates"));	
			}
			if (resultat.getString("id")==null)
			{
				cl.setId("");
			}
			else 
			{
				cl.setId(resultat.getString("id"));	
			}
			if (resultat.getInt("id_professeur")==0)
			{
				cl.setProfesseur(0);
			}
			else 
			{
				cl.setProfesseur(resultat.getInt("id_professeur"));	
			}
			
			
		}
	    catch (Exception e)
	    {
	    	// Si il y a une erreur durant le mappage des attributs avec la base on renvoi un objet null
	    	cl=null;
	    	System.out.println("Erreur lors du mappage des attributs d'un cl dans la class ModeleCalendrier, fonction clAttribusMapper"+e.getMessage());
	    }
	    
	    // On retourne le client
	    return cl;
	}



	
}