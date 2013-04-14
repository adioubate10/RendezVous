package fr.rendezvous.modeles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import fr.rendezvous.boiteoutils.GestionBaseDeDonnees;
import fr.rendezvous.javabeans.Client;

public class ModeleClientDAO extends ModeleDAO
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
	
	
	// Constructeur par d�faut
	public ModeleClientDAO ()
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
			requeteString="INSERT INTO client(nomclient,prenomclient,emailclient,adresseclient,codepostalclient,identifiantclient,motdepasseclient,telephoneclient,villeclient,paysclient) VALUES (?,?,?,?,?,?,?,?,?,?)";
			
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

	
	
	
	// Liste pagin�e des clients
	public List<Client> listeClientPaginer(int maxParPage, int pageActuel, String recherche, String typerecherche, String champTri, String typeTri)
	{	
		// Variables
		PreparedStatement requete=null;
		Client client=null;
		String requeteString=null;
		List<Client> listeClients=new ArrayList<Client>();
		int position=0;
	
		try
		{			
			// Ouverture d'une connexion
			connexion = super.getConnection();
			
			// Premi�re requ�te : on r�cupert le nombre total de clients

			// On cr�� la requ�te 
			requeteString="SELECT COUNT(DISTINCT(client.id_client)) as total FROM client WHERE 1";
			
			// Si il s'agit d'une recherche, on modifie la requ�te en cons�quence
			if((recherche!=null && !recherche.equalsIgnoreCase("")) && (typerecherche != null && !typerecherche.equals("")))
			{
				requeteString+=" AND " + typerecherche + " like ?";
				
				// Pr�paration de la requ�te
				requete=connexion.prepareStatement(requeteString);
				requete.setString(1,"%" + recherche + "%");
			}
			// Dans le cas contraire on prend en compte tous les clients
			else
			{
				// Pr�paration de la requ�te
				requete=connexion.prepareStatement(requeteString);
			}
			
			// Execution de la requ�te 
			resultat=requete.executeQuery();
			
			// On r�cupert le nombre de clients
			if(resultat!=null)
			{
				if(resultat.next())
				{
					this.totalElement=resultat.getInt("total");
				}
			}
			
			// On v�rifie que la page demand� est valable
			position=maxParPage*(pageActuel-1);
			if(position>totalElement || maxParPage>totalElement)
			{
				// On modifie les variables de pagination envoy� dans la requ�te
				pageActuel=1;
			}
			
			// On d�finit les variables de pagination finales
			position=maxParPage*(pageActuel-1);
			this.maxParPage=maxParPage;
			this.pageActuel=pageActuel;
			this.recherche=recherche;
			this.champTri=champTri;
			this.typeTri=typeTri;
			this.typerecherche=typerecherche;
		
			// Deuxi�me requ�te : on r�cupert la liste suivant une pagination

			// Cr�ation de la requ�te
			requeteString="SELECT * FROM client WHERE 1";
			
			// Si il s'agit d'une recherche, on modifie la requ�te en cons�quence
			if((recherche!=null && !recherche.equalsIgnoreCase("")) && (typerecherche != null && !typerecherche.equals("")))
			{
				requeteString+=" AND " + typerecherche + " like ?";
				requeteString+=" ORDER BY " + champTri + " " + typeTri + " LIMIT " + position + "," + maxParPage;
				
				// Pr�paration de la requ�te
				requete=connexion.prepareStatement(requeteString);
				requete.setString(1,"%" + recherche + "%");
			}
			// Dans le cas contraire on liste tous les clients
			else
			{
				requeteString+=" ORDER BY " + champTri + " " + typeTri + " LIMIT " + position + "," + maxParPage;
				
				// Pr�paration de la requ�te
				requete=connexion.prepareStatement(requeteString);
			}
	
			// Execution de la requ�te
			resultat=requete.executeQuery();

			// On stocke le resultat dans une liste
			if(resultat!=null)
			{
				while(resultat.next())
				{
					// On effectue le mappage des attributs avec les champs de la table SQL
					client=clientAttribusMapper(resultat);
					
					// Ajoute l'objet a la liste de client
					listeClients.add((Client)client);
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
				System.out.println("Erreur lors de la fermeture de la connexion avec la base de donn�es dans la classe ModeleClients fonction listerClient");
			}	
		}
		
		// Retourner la liste des clients
		return listeClients;
	}
	
	
	
	
	
	public List<Client> listeClient()
	{	
		/* Variables */
		PreparedStatement requete = null;
		Client client = null;
		String requeteString = null;
		List<Client> listeClients = new ArrayList<Client>();
	
		try
		{			
			/* Ouverture d'une connexion */
			connexion = super.getConnection();
		
			/* Cr�ation de la requ�te */
			requeteString = "SELECT * FROM client WHERE 1";
			
			/* Pr�paration de la requ�te */
			requete = connexion.prepareStatement(requeteString);
			
			/* Execution de la requ�te */
			resultat = requete.executeQuery();

			/* On stocke le resultat dans une liste */
			if(resultat != null)
			{
				while(resultat.next())
				{
					/* On effectue le mappage des attributs avec les champs de la table SQL */
					client = clientAttribusMapper(resultat);
					
					/* Ajoute l'objet a la liste de client */
					listeClients.add((Client)client);
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
				System.out.println("Erreur lors de la fermeture de la connexion avec la base de donn�es dans la classe ModeleClients fonction listerClient");
			}	
		}
		
		/* Retourner la liste des clients */
		return listeClients;
	}


	
	// Retourner les informations d'un client
    public Client getClient(String identifiant)
    {
    	/* Variables */
    	PreparedStatement requete = null;
    	Client client = null;
    	String requeteString = null;
    
    	try
    	{
    		/* Ouverture d'une connexion */
    		connexion = super.getConnection();
    		
    		/* Cr�ation de la requ�te */
    		requeteString = "SELECT * FROM client where identifiantclient=?";
    		
    		/* Preparer la requete */
    		requete = connexion.prepareStatement(requeteString);
    		requete.setString(1,identifiant);
    			
    		/* Execution de la requ�te */
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
    		/* Si l'identifant du client n'existe pas, on initialise l'objet client � null */
			client = null;
    		System.out.println("Erreur dans la requ�te dans la classe ModeleClient.java fonction getClient");    		
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
    			System.out.println("Erreur lors de la fermeture de la connexion avec la base de donn�es dans la classe ModeleClient.java fonction getClient");
    		}	
    	}
    	
    	/* Retourner un client */
    	return client;
    }
    
    
    
    
    // Retourner les informations d'un client � partir de son idClient
    public Client getClient(int idClient)
    {
    	// Variables
    	PreparedStatement requete=null;
    	Client client=null;
    	String requeteString=null;
    
    	try
    	{
    		// Ouverture d'une connexion
    		connexion=super.getConnection();
    		
    		// Cr�ation de la requ�te
    		requeteString="SELECT * FROM client where id_client = ?";
    		
    		// Preparer la requete
    		requete=connexion.prepareStatement(requeteString);
    		requete.setInt(1,idClient);
    			
    		// Execution de la requ�te
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
    		// Si l'identifant du client n'existe pas, on initialise l'objet client � null
			client=null;
    		System.out.println("Erreur dans la requ�te dans la classe ModeleClient.java fonction getClient");    		
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
    			System.out.println("Erreur lors de la fermeture de la connexion avec la base de donn�es dans la classe ModeleClient.java fonction getClient");
    		}	
    	}
    	
    	// Retourner un client
    	return client;
    }
   
    
    
    // Modification d'un client
    public int modifierClient(Client client) 
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
			requeteString="UPDATE client set nomclient=?, prenomclient=?,emailclient=?,adresseclient=?,codepostalclient=?,identifiantclient=?,motdepasseclient=?,telephoneclient=?,villeclient=?,paysclient=? WHERE id_client=?";
				
			// Pr�paration de la requ�te 
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
			
			// Execution de la requ�te
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
				System.out.println("Erreur lors de la fermeture de la connexion avec la base de donn�es dans la classe ModelClient fonction modifierClient");
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
			// Initialisation du mod�le raccourci
			//modeleRaccourciDAO=new ModeleRaccourciDAO();
			
			// Ouverture d'une connexion
			connexion=super.getConnection();
			
			// Annulation de l'autocommit
			connexion.setAutoCommit(false);
			
			// Premi�re requ�te : suppression du client
			requeteString="DELETE FROM client WHERE id_client = ?";
			
			// Pr�paration de la requ�te
			requete=connexion.prepareStatement(requeteString);
			requete.setInt(1, idClient);
			
			// Execution de la requ�te
			codeErreur=requete.executeUpdate();
			
			// Si il n'y a pas eut d'erreur durant la suppression du client, on peut supprimer les raccourcis associ�s au client.
			if(codeErreur==1)
			{
				// Deuxi�me requ�te : suppression des raccourcis du client
				//codeErreur=modeleRaccourciDAO.supprimerRaccourcisClient(idClient);
			}
			
			// Si il n'y a pas eu d'erreur durant la suppression des raccourcis du client, ou du client lui m�me : on fait un commit, sinon un rollback
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
				System.out.println("Erreur lors de la fermeture de la connexion avec la base de donn�es dans la classe ModeleClient fonction supprimerClient");
			}	
		}
		
		// Retourner le code d'erreur
		return codeErreur;
	}

    
    
    
    
    
    // Transformer Relation vers Objet
	public Client clientAttribusMapper(ResultSet resultat)
	{
		// Variables
		Client client=new Client();
		
		try 
		{	
			if (resultat.getString("id_client")==null)
			{
				client.setIdClient(0);	
			}
			else 
			{
				client.setIdClient(resultat.getInt("id_client"));	
			}
			
			if (resultat.getString("nomclient")==null)
			{
				client.setNom("");
			}
			else 
			{
				client.setNom(resultat.getString("nomclient"));	
			}
			
			if (resultat.getString("prenomclient")==null)
			{
				client.setPrenom("");	
			}
			else 
			{
				client.setPrenom(resultat.getString("prenomclient"));	
			}	
			
			if (resultat.getString("emailclient")==null)
			{
				client.setMail("");
			}
			else 
			{
				client.setMail(resultat.getString("emailclient"));	
			}
			
			if (resultat.getString("telephoneclient")==null)
			{
				client.setTelephone("");
			}
			else 
			{
				client.setTelephone(resultat.getString("telephoneclient"));	
			}
			
			if (resultat.getString("adresseclient")==null)
			{
				client.setAdresse("");
			}
			else 
			{
				client.setAdresse(resultat.getString("adresseclient"));	
			}
			
			if (resultat.getString("telephoneclient")==null)
			{
				client.setTelephone("");
			}
			else 
			{
				client.setTelephone(resultat.getString("telephoneclient"));	
			}
			
			if (resultat.getString("villeclient")==null)
			{
				client.setVille("");
			}
			else 
			{
				client.setVille(resultat.getString("villeclient"));	
			}
			
			if (resultat.getString("codepostalclient")==null)
			{
				client.setCodePostal("");
			}
			else 
			{
				client.setCodePostal(resultat.getString("codepostalclient"));	
			}
			
			if (resultat.getString("paysclient")==null)
			{
				client.setPays("");
			}
			else 
			{
				client.setPays(resultat.getString("paysclient"));	
			}
			
			if (resultat.getString("identifiantclient")==null)
			{
				client.setIdentifiant("");
			}
			else 
			{
				client.setIdentifiant(resultat.getString("identifiantclient"));	
			}
			
			
			if (resultat.getString("motdepasseclient")==null)
			{
				client.setMotDePasse("");
			}
			else 
			{
				client.setMotDePasse(resultat.getString("motdepasseclient"));	
			}
			
			if (resultat.getString("motdepasseclient")==null)
			{
				client.setConfirmationMotDePasse("");
			}
			else 
			{
				client.setConfirmationMotDePasse(resultat.getString("motdepasseclient"));	
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