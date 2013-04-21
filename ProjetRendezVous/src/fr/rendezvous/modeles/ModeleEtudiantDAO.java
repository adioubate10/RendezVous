package fr.rendezvous.modeles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import fr.rendezvous.boiteoutils.GestionBaseDeDonnees;
//import fr.rendezvous.javabeans.Client;
import fr.rendezvous.javabeans.Etudiant;

public class ModeleEtudiantDAO extends ModeleDAO
{
	// Variables
	Connection connexion=null;
	ResultSet resultat=null;
	
	// Variables de pagination
	private int maxParPage;
	private int pageActuel;
	private int totalElement;
	private String champTri;
	private String typeTri;
	private String recherche;
	private String typerecherche;
	
	
	// Constructeur par défaut
	public ModeleEtudiantDAO ()
	{

	}
	
	public int getMaxParPage() 
	{
		return maxParPage;
	}

	public int getPageActuel() 
	{
		return pageActuel;
	}

	public int getTotalElement() 
	{
		return totalElement;
	}
	
	public String getChampTri()
	{
		return champTri;
	}

	public String getRecherche()
	{
		return recherche;
	}

	public String getTypeTri() 
	{
		return typeTri;
	}
	
	public String getTyperecherche() 
	{
		return typerecherche;
	}
	
	
	
	// Ajouter un client
	public int ajouterClient(Etudiant client) 
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
			requeteString="INSERT INTO etudiant(nom,prenom,mail,adresse,code_postal,ville,pays,tel,dat_nais,sexe,identifiant,mdp,numero_etu,options,niveau,service_social) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
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
			requete.setString(13,(String)client.getNumeroEtudiant());
			requete.setString(14,(String)client.getOption());
			requete.setString(15,(String)client.getNiveau());
			requete.setString(16,(String)client.getServiceSocial());
			
			System.out.println(client.getNom());
			System.out.println(client.getPrenom());
			
			System.out.println("mel"+client.getMail());
			System.out.println(client.getCodePostal());
			System.out.println(client.getAdresse());
			
			System.out.println(client.getVille());
			System.out.println(client.getPays());
			System.out.println(client.getTelephone());
			System.out.println(client.getDateNaissance());
			System.out.println(client.getSexe());
			System.out.println(client.getNumeroEtudiant());
			System.out.println(client.getIdentifiant());
			System.out.println(client.getMotDePasse());
			System.out.println(client.getOption());
			System.out.println(client.getNiveau());
			System.out.println(client.getServiceSocial());
			// On vide le client par sécurité
			client=null;
			
			// Execution de la requête
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
				System.out.println("Erreur lors de la fermeture de la connexion avec la base de données dans la classe ModelClient fonction creerClient");
			}	
		}
		
		// Retourne le code d'erreur
		return codeErreur;
	}

	
	
	
	// Liste paginée des clients
	public List<Etudiant> listeClientPaginer(int maxParPage, int pageActuel, String recherche, String typerecherche, String champTri, String typeTri)
	{	
		// Variables
		PreparedStatement requete=null;
		Etudiant client=null;
		String requeteString=null;
		List<Etudiant> listeClients=new ArrayList<Etudiant>();
		int position=0;
	
		try
		{			
			// Ouverture d'une connexion
			connexion = super.getConnection();
			
			// Première requête : on récupert le nombre total de clients

			// On créé la requête 
			requeteString="SELECT COUNT(DISTINCT(etudiant.id_etudiant)) as total FROM Etudiant WHERE 1";
			
			// Si il s'agit d'une recherche, on modifie la requête en conséquence
			if((recherche!=null && !recherche.equalsIgnoreCase("")) && (typerecherche != null && !typerecherche.equals("")))
			{
				requeteString+=" AND " + typerecherche + " like ?";
				
				// Préparation de la requête
				requete=connexion.prepareStatement(requeteString);
				requete.setString(1,"%" + recherche + "%");
			}
			// Dans le cas contraire on prend en compte tous les clients
			else
			{
				// Préparation de la requête
				requete=connexion.prepareStatement(requeteString);
			}
			
			// Execution de la requête 
			resultat=requete.executeQuery();
			
			// On récupert le nombre de clients
			if(resultat!=null)
			{
				if(resultat.next())
				{
					this.totalElement=resultat.getInt("total");
				}
			}
			
			// On vérifie que la page demandé est valable
			position=maxParPage*(pageActuel-1);
			if(position>totalElement || maxParPage>totalElement)
			{
				// On modifie les variables de pagination envoyé dans la requête
				pageActuel=1;
			}
			
			// On définit les variables de pagination finales
			position=maxParPage*(pageActuel-1);
			this.maxParPage=maxParPage;
			this.pageActuel=pageActuel;
			this.recherche=recherche;
			this.champTri=champTri;
			this.typeTri=typeTri;
			this.typerecherche=typerecherche;
		
			// Deuxième requête : on récupert la liste suivant une pagination

			// Création de la requête
			requeteString="SELECT * FROM client WHERE 1";
			
			// Si il s'agit d'une recherche, on modifie la requête en conséquence
			if((recherche!=null && !recherche.equalsIgnoreCase("")) && (typerecherche != null && !typerecherche.equals("")))
			{
				requeteString+=" AND " + typerecherche + " like ?";
				requeteString+=" ORDER BY " + champTri + " " + typeTri + " LIMIT " + position + "," + maxParPage;
				
				// Préparation de la requête
				requete=connexion.prepareStatement(requeteString);
				requete.setString(1,"%" + recherche + "%");
			}
			// Dans le cas contraire on liste tous les clients
			else
			{
				requeteString+=" ORDER BY " + champTri + " " + typeTri + " LIMIT " + position + "," + maxParPage;
				
				// Préparation de la requête
				requete=connexion.prepareStatement(requeteString);
			}
	
			// Execution de la requête
			resultat=requete.executeQuery();

			// On stocke le resultat dans une liste
			if(resultat!=null)
			{
				while(resultat.next())
				{
					// On effectue le mappage des attributs avec les champs de la table SQL
					client=clientAttribusMapper(resultat);
					
					// Ajoute l'objet a la liste de client
					listeClients.add((Etudiant)client);
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
				System.out.println("Erreur lors de la fermeture de la connexion avec la base de données dans la classe ModeleClients fonction listerClient");
			}	
		}
		
		// Retourner la liste des clients
		return listeClients;
	}
	
	
	
	
	
	public List<Etudiant> listeClient()
	{	
		/* Variables */
		PreparedStatement requete = null;
		Etudiant client = null;
		String requeteString = null;
		List<Etudiant> listeClients = new ArrayList<Etudiant>();
	
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
					listeClients.add((Etudiant)client);
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
		return listeClients;
	}


	
	// Retourner les informations d'un client
    public Etudiant getClient(String identifiant)
    {
    	/* Variables */
    	PreparedStatement requete = null;
    	Etudiant client = null;
    	String requeteString = null;
    
    	try
    	{
    		/* Ouverture d'une connexion */
    		connexion = super.getConnection();
    		
    		/* Création de la requête */
    		requeteString = "SELECT * FROM etudiant where identifiant=?";
    		
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
    			System.out.println("Erreur lors de la fermeture de la connexion avec la base de données dans la classe ModeleClient.java fonction getClient");
    		}	
    	}
    	
    	/* Retourner un client */
    	return client;
    }
    
    
    
    
    // Retourner les informations d'un client à partir de son idClient
    public Etudiant getClient(int idClient)
    {
    	// Variables
    	PreparedStatement requete=null;
    	Etudiant client=null;
    	String requeteString=null;
    
    	try
    	{
    		// Ouverture d'une connexion
    		connexion=super.getConnection();
    		
    		// Création de la requête
    		requeteString="SELECT * FROM client where id_client = ?";
    		
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
    			System.out.println("Erreur lors de la fermeture de la connexion avec la base de données dans la classe ModeleClient.java fonction getClient");
    		}	
    	}
    	
    	// Retourner un client
    	return client;
    }
   
    
    
    // Modification d'un client
    public int modifierClient(Etudiant client) 
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
	public Etudiant clientAttribusMapper(ResultSet resultat)
	{
		// Variables
		Etudiant client=new Etudiant();
		
		try 
		{	
			if (resultat.getString("id_etudiant")==null)
			{
				client.setIdClient(0);	
			}
			else 
			{
				client.setIdClient(resultat.getInt("id_etudiant"));	
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
			
			if (resultat.getString("numero_etu")==null)
			{
				client.setNumeroEtudiant("");
			}
			else 
			{
				client.setNumeroEtudiant(resultat.getString("numero_etu"));	
			}
			if (resultat.getString("options")==null)
			{
				client.setOption("");
			}
			else 
			{
				client.setOption(resultat.getString("options"));	
			}
			if (resultat.getString("niveau")==null)
			{
				client.setNiveau("");
			}
			else 
			{
				client.setNiveau(resultat.getString("niveau"));	
			}
			if (resultat.getString("service_social")==null)
			{
				client.setServiceSocial("");
			}
			else 
			{
				client.setServiceSocial(resultat.getString("service_social"));	
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