package fr.rendezvous.boiteoutils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
	
public class GestionBaseDeDonnees
{
	/* Permet de fermer un resultset */
	public static void closeResulset(ResultSet resultat)
	{
		if(resultat != null)
		{
			try
			{
				resultat.close();
			}
			
			catch(Exception e)
			{
				System.out.println("Erreur lors de la fermerture d'une connexion d'un resultset");
			}
		}
	}
	
	/* Fermeture d'une requête */
	public static void closeRequest(Statement requete)
	{
		if(requete!=null)
		{
			try
			{
				requete.close();
			}
			catch(Exception e)
			{
				System.out.println("Erreur lors de la fermerture d'une requête");
			}
		}
	}

	/* Fermeture d'une connexion */
	public static void closeConnection(Connection connexion)
	{
		if(connexion!=null)
		{
			try
			{
				connexion.close();
			}
			
			catch(Exception e)
			{
				System.out.println("Erreur lors de la fermerture d'une connexion");
			}
		}
	}
	
	/* Valide la transaction */
	public static void commit(Connection connexion)
	{
		if(connexion!=null)
		{
			try
			{
				connexion.commit();
			}
			catch(Exception e)
			{
				System.out.println("Erreur lors d'un comit");
			}
		}
	}
	
	/* Annulation de la transaction */
	public static void rollback(Connection connexion)
	{
		if(connexion!=null)
		{
			try
			{
				connexion.rollback();
			}
			catch(Exception e)
			{
				System.out.println("Erreur lors d'un rollback");
			}
		}
	}
}
