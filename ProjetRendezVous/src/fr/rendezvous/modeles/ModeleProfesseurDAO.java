package fr.rendezvous.modeles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import fr.rendezvous.boiteoutils.GestionBaseDeDonnees;
//import fr.rendezvous.javabeans.Client;
import fr.rendezvous.javabeans.Client;
import fr.rendezvous.javabeans.Etudiant;
import fr.rendezvous.javabeans.Professeur;

public class ModeleProfesseurDAO extends ModeleDAO
{
	// Variables
	Connection connexion=null;
	ResultSet resultat=null;
	
	
	
	
	// Constructeur par défaut
	public ModeleProfesseurDAO ()
	{

	}
	
	
	
	// Ajouter un client
	public int ajouterClient(Professeur client1,Client client) 
	{
		// Variables
		PreparedStatement requete=null;
		String requeteString=null;
		int codeErreur=0;
		if(getMail(client.getMail())==null){
		try 
		{	
			// Ouverture d'une connexion
			connexion=super.getConnection();
			
			// Création de la requête
			requeteString="INSERT INTO professeur(nom,prenom,mail,adresse,code_postal,ville,pays,tel,dat_nais,sexe,identifiant,mdp,tel_fixe,grade,specialite,description_spec) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			// Préparation de la requête
			requete=connexion.prepareStatement(requeteString);
			requete.setString(1,(String)client.getNom());
			requete.setString(2,(String)client.getPrenom());
			requete.setString(3,(String)client.getMail());
			requete.setString(4,(String)client.getAdresse());
			requete.setString(5,(String)client.getCodePostal());
			requete.setString(6,(String)client.getVille());
			requete.setString(7,(String)client.getPays());
			requete.setString(8,(String)client.getTelephone());
			requete.setString(9,(String)client.getDateNaissance());
			requete.setString(10,(String)client.getSexe());
			requete.setString(11,(String)client.getIdentifiant());
			requete.setString(12,(String)client.getMotDePasse());
			
			//attribut de etudiant
			requete.setString(13,(String)client1.getTelFixe());
			requete.setString(14,(String)client1.getGrade());
			requete.setString(15,(String)client1.getSpecialite());
			requete.setString(16,(String)client1.getSpecialiteDesc());
			
			System.out.println(client.getNom());
			System.out.println(client.getPrenom());
			
			System.out.println(client.getMail());
			System.out.println(client.getCodePostal());
			System.out.println(client.getAdresse());
			
			System.out.println(client.getVille());
			System.out.println(client.getPays());
			System.out.println(client.getTelephone());
			System.out.println(client.getDateNaissance());
			System.out.println(client.getSexe());
			System.out.println(client1.getGrade());
			System.out.println(client.getIdentifiant());
			System.out.println(client.getMotDePasse());
			System.out.println(client1.getTelFixe());
			System.out.println(client1.getSpecialite());
			System.out.println(client1.getSpecialiteDesc());
			// On vide le client par sécurité
			client=null;
			
			// Execution de la requête
			codeErreur=requete.executeUpdate();
		}
		catch (Exception e) 
		{
			codeErreur=0;
			System.out.println("Erreur dans la requete dans la classe ModeleClient.java fonction creerProf "+e.getMessage());
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
				System.out.println("Erreur lors de la fermeture de la connexion avec la base de données dans la classe ModelClie "+ex.getMessage());
			}	
		}
	}
		// Retourne le code d'erreur
		return codeErreur;
	}

	
	
	public List<Professeur> listeClient()
	{	
		/* Variables */
		PreparedStatement requete = null;
		Professeur client = null;
		String requeteString = null;
		List<Professeur> listeClients = new ArrayList<Professeur>();
	
		try
		{			
			/* Ouverture d'une connexion */
			connexion = super.getConnection();
		
			/* Création de la requête */
			requeteString = "SELECT * FROM client WHERE 1";
			
			/* Préparation de la requête */
			requete = connexion.prepareStatement(requeteString);
			
			/* Execution de la requête */
			resultat = requete.executeQuery();

			/* On stocke le resultat dans une liste */
			if(resultat != null)
			{
				while(resultat.next())
				{
					/* On effectue le mappage des attributs avec les champs de la table SQL */
					client = clientAttribusMapper(resultat);
					
					/* Ajoute l'objet a la liste de client */
					listeClients.add((Professeur)client);
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
				System.out.println("Erreur lors de la fermeture de la connexion avec la base de données dans la classe ModeleClients fonction listerClient"+ex.getMessage());
			}	
		}
		
		/* Retourner la liste des clients */
		return listeClients;
	}


	
	// Retourner les informations d'un client
    public Professeur getClient(String identifiant)
    {
    	/* Variables */
    	PreparedStatement requete = null;
    	Professeur client = null;
    	String requeteString = null;
      
    	try
    	{
    		/* Ouverture d'une connexion */
    		connexion = super.getConnection();
    		
    		/* Création de la requête */
    		requeteString = "SELECT * FROM professeur where identifiant=?";
    		
    		/* Preparer la requete */
    		requete = connexion.prepareStatement(requeteString);
    		requete.setString(1,identifiant);
    			
    		/* Execution de la requête */
    		resultat = requete.executeQuery();
    		
    		/* On stocke le resultat dans la l'objet client */
    		if(resultat != null)
    		{
    			if(resultat.next())
    			{
    				/* On mappe les attribus du client dans la classe avec la base */
    				client = clientAttribusMapper(resultat); 				
    			}
    		}
       	}
    
    	catch(Exception e)
    	{
    		/* Si l'identifant du client n'existe pas, on initialise l'objet client à null */
			client = null;
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
    			System.out.println("Erreur lors de la fermeture de la connexion avec la base de données dans la classe ModeleClient.java fonction getClient"+ex.getMessage());
    		}	
    	}
    	
    	/* Retourner un client */
    	return client;
    }
    
    
    
    
    // Retourner les informations d'un client à partir de son idClient
    public Professeur getClient(int idClient)
    {
    	// Variables
    	PreparedStatement requete=null;
    	Professeur client=null;
    	String requeteString=null;
    
    	try
    	{
    		// Ouverture d'une connexion
    		connexion=super.getConnection();
    		
    		// Création de la requête
    		requeteString="SELECT * FROM professeur where id_professeur = ?";
    		
    		// Preparer la requete
    		requete=connexion.prepareStatement(requeteString);
    		requete.setInt(1,idClient);
    			
    		// Execution de la requête
    		resultat=requete.executeQuery();
    		
    		// On stocke le resultat dans la l'objet client
    		if(resultat!=null)
    		{
    			if(resultat.next())
    			{
    				// On mappe les attribus du client dans la classe avec la base
    				client=clientAttribusMapper(resultat); 				
    			}
    		}
       	}
    	catch(Exception e)
    	{
    		// Si l'identifant du client n'existe pas, on initialise l'objet client à null
			client=null;
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
    			System.out.println("Erreur lors de la fermeture de la connexion avec la base de données dans la classe ModeleClient.java fonction getClient"+ex.getMessage());
    		}	
    	}
    	
    	// Retourner un client
    	return client;
    }
   
    public Professeur getId(String nomClient)
    {
    	// Variables
    	PreparedStatement requete=null;
    	Professeur client=null;
    	String requeteString=null;
    
    	try
    	{
    		// Ouverture d'une connexion
    		connexion=super.getConnection();
    		
    		// Création de la requête
    		requeteString="SELECT * FROM professeur where nom = ?";
    		
    		// Preparer la requete
    		requete=connexion.prepareStatement(requeteString);
    		requete.setString(1,nomClient);
    			
    		// Execution de la requête
    		resultat=requete.executeQuery();
    		
    		// On stocke le resultat dans la l'objet client
    		if(resultat!=null)
    		{
    			if(resultat.next())
    			{
    				// On mappe les attribus du client dans la classe avec la base
    				client=clientAttribusMapper(resultat); 				
    			}
    		}
       	}
    	catch(Exception e)
    	{
    		// Si l'identifant du client n'existe pas, on initialise l'objet client à null
			client=null;
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
    			System.out.println("Erreur lors de la fermeture de la connexion avec la base de données dans la classe ModeleClient.java fonction getClient"+ex.getMessage());
    		}	
    	}
    	
    	// Retourner un client
    	return client;
    }
   
    // Retourner les informations d'un client à partir de son mail
    public Professeur getMail(String mail)
    {
    	// Variables
    	PreparedStatement requete=null;
    	Professeur client=null;
    	String requeteString=null;
    
    	try
    	{
    		// Ouverture d'une connexion
    		connexion=super.getConnection();
    		
    		// Création de la requête
    		requeteString="SELECT * FROM professeur where mail = ?";
    		
    		// Preparer la requete
    		requete=connexion.prepareStatement(requeteString);
    		requete.setString(1,mail);
    			
    		// Execution de la requête
    		resultat=requete.executeQuery();
    		
    		// On stocke le resultat dans la l'objet client
    		if(resultat!=null)
    		{
    			if(resultat.next())
    			{
    				// On mappe les attribus du client dans la classe avec la base
    				client=clientAttribusMapper(resultat); 				
    			}
    		}
       	}
    	catch(Exception e)
    	{
    		// Si l'identifant du client n'existe pas, on initialise l'objet client à null
			client=null;
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
    			System.out.println("Erreur lors de la fermeture de la connexion avec la base de données dans la classe ModeleClient.java fonction "+ex.getMessage());
    		}	
    	}
    	
    	// Retourner un client
    	return client;
    }
   
    
    // Modification d'un client
    public int modifierClient(Professeur client) 
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
			requeteString="UPDATE client set nomclient=?, prenomclient=?,emailclient=?,adresseclient=?,codepostalclient=?,identifiantclient=?,motdepasseclient=?,telephoneclient=?,villeclient=?,paysclient=? WHERE id_client=?";
				
			// Préparation de la requête 
			requete=connexion.prepareStatement(requeteString);
			requete.setString(1,client.getNom());
			requete.setString(2,client.getPrenom());
			requete.setString(3,client.getMail());
			requete.setString(4,client.getAdresse());
			requete.setString(5,client.getCodePostal());
			requete.setString(6,client.getIdentifiant());
			requete.setString(7,(client.getMotDePasse()));
			requete.setString(8,client.getTelephone());
			requete.setString(9,client.getVille());
			requete.setString(10,client.getPays());
			requete.setInt(11,client.getIdClient());
			
			// Execution de la requête
			codeErreur = requete.executeUpdate();
		}
		catch(Exception e) 
		{
			codeErreur=0;
			System.out.println("Erreur dans la requete dans la classe ModeleClient.java fonction modifierClient");
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
				System.out.println("Erreur lors de la fermeture de la connexion avec la base de données dans la classe ModelClient fonction modifierClient");
			}	
		}
		
		// Retourne le code d'erreur
		return codeErreur;
	}



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
			System.out.println("Erreur dans la requete dans la classe ModeleClient fonction supprimerClient"+e.getMessage());
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
	public Professeur clientAttribusMapper(ResultSet resultat)
	{
		// Variables
		Professeur client=new Professeur();
		
		try 
		{	
			if (resultat.getString("id_professeur")==null)
			{
				client.setIdClient(0);	
			}
			else 
			{
				client.setIdClient(resultat.getInt("id_professeur"));	
			}
			
			if (resultat.getString("nom")==null)
			{
				client.setNom("");
			}
			else 
			{
				client.setNom(resultat.getString("nom"));	
			}
			
			if (resultat.getString("prenom")==null)
			{
				client.setPrenom("");	
			}
			else 
			{
				client.setPrenom(resultat.getString("prenom"));	
			}	
			
			if (resultat.getString("mail")==null)
			{
				client.setMail("");
			}
			else 
			{
				client.setMail(resultat.getString("mail"));	
			}
			
			
			
			if (resultat.getString("adresse")==null)
			{
				client.setAdresse("");
			}
			else 
			{
				client.setAdresse(resultat.getString("adresse"));	
			}
			
			if (resultat.getString("tel")==null)
			{
				client.setTelephone("");
			}
			else 
			{
				client.setTelephone(resultat.getString("tel"));	
			}
			
			if (resultat.getString("ville")==null)
			{
				client.setVille("");
			}
			else 
			{
				client.setVille(resultat.getString("ville"));	
			}
			
			if (resultat.getString("code_postal")==null)
			{
				client.setCodePostal("");
			}
			else 
			{
				client.setCodePostal(resultat.getString("code_postal"));	
			}
			
			if (resultat.getString("pays")==null)
			{
				client.setPays("");
			}
			else 
			{
				client.setPays(resultat.getString("pays"));	
			}
			if (resultat.getString("sexe")==null)
			{
				client.setSexe("");
			}
			else 
			{
				client.setSexe(resultat.getString("sexe"));	
			}
			if (resultat.getString("dat_nais")==null)
			{
				client.setDateNaissance("");
			}
			else 
			{
				client.setDateNaissance(resultat.getString("dat_nais"));	
			}
			
			if (resultat.getString("identifiant")==null)
			{
				client.setIdentifiant("");
			}
			else 
			{
				client.setIdentifiant(resultat.getString("identifiant"));	
			}
			
			
			if (resultat.getString("mdp")==null)
			{
				client.setMotDePasse("");
			}
			else 
			{
				client.setMotDePasse(resultat.getString("mdp"));	
			}
			if (resultat.getString("mdp")==null)
			{
				client.setConfirmationMotDePasse("");
			}
			else 
			{
				client.setConfirmationMotDePasse(resultat.getString("mdp"));	
			}
			
			if (resultat.getString("grade")==null)
			{
				client.setGrade("");
			}
			else 
			{
				client.setGrade(resultat.getString("grade"));	
			}
			if (resultat.getString("tel_fixe")==null)
			{
				client.setTelFixe("");
			}
			else 
			{
				client.setTelFixe(resultat.getString("tel_fixe"));	
			}
			if (resultat.getString("specialite")==null)
			{
				client.setSpecialite("");
			}
			else 
			{
				client.setSpecialite(resultat.getString("specialite"));	
			}
			if (resultat.getString("description_spec")==null)
			{
				client.setSpecialiteDesc("");
			}
			else 
			{
				client.setSpecialiteDesc(resultat.getString("description_spec"));	
			}
			
		}
	    catch (Exception e)
	    {
	    	// Si il y a une erreur durant le mappage des attributs avec la base on renvoi un objet null
	    	client=null;
	    	System.out.println("Erreur lors du mappage des attributs d'un client dans la class ModeleClient, fonction clientAttribusMapper");
	    }
	    
	    // On retourne le client
	    return client;
	}
}