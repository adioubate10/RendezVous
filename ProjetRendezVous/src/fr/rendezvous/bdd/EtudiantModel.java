package fr.rendezvous.bdd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.rendezvous.bean.Etudiant;


public class EtudiantModel  extends ModelDAO {
	
	Connection connection =null;
	ResultSet resultSet = null; 
	private ArrayList<Etudiant> allEtudiants = new ArrayList<Etudiant>();

	public int ajouterEtudiant (Etudiant etudiant){

		PreparedStatement prepStat = null;
		String laRequete = null;
		int valErreur = 0;

		try{
			connection = super.getConnection();
			laRequete = "INSERT INTO Client (id_client,nom, prenom,mail,tel,dat_nais,adresse,sexe,nationalite,service_social,identifiant,mot_de_pass) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
			//laRequete = "INSERT INTO Eleves (Nom, Prenom,Age) VALUES(?,?,?)";
			prepStat = connection.prepareStatement(laRequete);
			  /*prepStat.setString(1,"Dioubate");
			prepStat.setString(2, "Amadou ");
			prepStat.setInt(3, 29);
            
          */
			prepStat.setInt(1,new Integer(0));
			prepStat.setString(2, etudiant.getNom());
			prepStat.setString(3, etudiant.getPrenom());
			prepStat.setString(4, etudiant.getEmail());
			prepStat.setString(5, etudiant.getTelephone());
			prepStat.setString(6, etudiant.getAge());
			prepStat.setString(7, etudiant.getAdresse());
			prepStat.setString(8, etudiant.getSexe());
			prepStat.setString(9, etudiant.getNationalite());
			prepStat.setString(10, etudiant.getMatiere());
			prepStat.setString(11, etudiant.getIdentifiant());
			prepStat.setString(12, etudiant.getMdp());
			//java.sql.Date dateSql = new java.sql.Date(etudiant.getDateInscription().getTime());
			System.out.println("insertion d'un objet");

			valErreur = prepStat.executeUpdate();

		}catch(Exception ex)
		{
			valErreur = 0;
			System.out.println("Erreur lors del'insertion d'un objet");
			ex.printStackTrace();
		}

		try{
			prepStat.close();
			connection.close();
		}catch(Exception ex){
			System.out.println("Impossible de fermer un objet");
			ex.printStackTrace();
		}

		return valErreur;
	}


	public Etudiant getetudiant(String identifiant,String mot_de_pass){
		PreparedStatement prepStat = null;
		Etudiant etudiant  = null;
		String laRequete = null;

		try{
			connection = super.getConnection();
			laRequete = "SELECT * FROM client WHERE identifiant=? and mot_de_pass=?";
			prepStat =connection.prepareStatement(laRequete);
			prepStat.setString(1, identifiant);
			prepStat.setString(2, mot_de_pass);
			resultSet=prepStat.executeQuery();

			if (resultSet!=null){
				if (resultSet.next()){
					etudiant = mapperEtudiant(resultSet);

				}
			}else
				System.out.println("client introuvable dans la base");

		}catch(Exception ex){
			etudiant =null;
			System.out.println("erreur dans la requette" + ex);
		}

		try{
			resultSet.close();
			prepStat.close();
			connection.close();
		}catch(Exception ex){
			System.out.println("Impossible de fermer un objet");
			ex.printStackTrace();
		}

		return etudiant;
	}
	
	/*
	//Rechercher par pseudo en ignorant la casse
	public ArrayList<Developpeur> getDeveloppeurByPseudo(String pseudo,String compte){
		PreparedStatement prepStat = null;
		Developpeur developpeur = null;
		String laRequete = null;

		try{
			connection = super.getConnection();
			laRequete = "SELECT * FROM developpeur WHERE UPPER(PSEUDO) LIKE UPPER(?) and COMPTE=?";
			prepStat =connection.prepareStatement(laRequete);

			prepStat.setString(1, "%"+pseudo+"%");
			prepStat.setString(2, compte);
			resultSet=prepStat.executeQuery();

			if (resultSet!=null){
				while (resultSet.next()){
					developpeur = mapperDeveloppeur(resultSet);
					allDeveloppeurs.add(developpeur);

				}
			}else
				System.out.println("Developpeur introuvable dans la base");

		}catch(Exception ex){
			developpeur =null;
			System.out.println("erreur dans la requette" + ex);
		}

		try{
			resultSet.close();
			prepStat.close();
			connection.close();
		}catch(Exception ex){
			System.out.println("Impossible de fermer un objet");
			ex.printStackTrace();
		}

		return allDeveloppeurs;
	}
	
	*/
	public Etudiant mapperEtudiant(ResultSet resultSet){
		Etudiant etudiant = new Etudiant();
		System.out.println("method mapperetu");
		try
		{
			if(resultSet.getString("identifiant")==null){
				etudiant.setIdentifiant("");
			}
			else
			{
				etudiant.setIdentifiant(resultSet.getString("identifiant"));
			}

			if(resultSet.getString("mot_de_pass")==null){
				etudiant.setMdp("");
			}
			else
			{
				etudiant.setMdp(resultSet.getString("mot_de_pass"));
				System.out.println(resultSet.getString("mot_de_pass"));
			}

			if(resultSet.getString("mail")==null){
				etudiant.setEmail("");
				
			}
			else
			{
				etudiant.setEmail(resultSet.getString("mail"));
				System.out.println(etudiant.getEmail());
			}
			if(resultSet.getString("adresse")==null){
				etudiant.setAdresse("");
			}
			else
			{
				etudiant.setAdresse(resultSet.getString("adresse"));
			}

			if(resultSet.getString("sexe")==null){
				etudiant.setSexe(null);
			}
			else
			{
				etudiant.setSexe(resultSet.getString("sexe"));
			}



		}catch(Exception ex)
		{
			etudiant = null;
			System.out.println("Erreur lors du mapping des attributs"+ex);
		}
		return etudiant;
	}

	public int supprimerAllEtudiant(String identifiant){

		PreparedStatement prepStat = null;
		String laRequete = null;
		int valErreur = 0;

		try{
			connection = super.getConnection();
			laRequete = "DELETE FROM client WHERE nom=?";
			prepStat = connection.prepareStatement(laRequete);
			prepStat.setString(1, identifiant);

			valErreur = prepStat.executeUpdate();
		}catch(Exception ex)
		{
			valErreur = 0;
			System.out.println("Erreur lors de l'insertion d'un objet");
			ex.printStackTrace();
		}

		try{
			prepStat.close();
			connection.close();
		}catch(Exception ex){
			System.out.println("Impossible de fermer un objet");
			ex.printStackTrace();
		}

		return valErreur;
	}


	public int supprimerUnEtudiant(String identifiant, String mdp){

		PreparedStatement prepStat = null;
		String laRequete = null;
		int valErreur = 0;

		try{
			connection = super.getConnection();
			laRequete = "DELETE FROM developpeur WHERE PSEUDO = ? AND COMPTE=?";
			prepStat = connection.prepareStatement(laRequete);
			prepStat.setString(1, identifiant);
			prepStat.setString(2, mdp);

			valErreur = prepStat.executeUpdate();
		}catch(Exception ex)
		{
			valErreur = 0;
			System.out.println("Erreur lors de l'insertion d'un objet");
			ex.printStackTrace();
		}

		try{
			prepStat.close();
			connection.close();
		}catch(Exception ex){
			System.out.println("Impossible de fermer un objet");
			ex.printStackTrace();
		}

		return valErreur;
	}
	
	
	
	
	public ArrayList<Etudiant> getAllEtudiant(String identifiant){
		PreparedStatement prepStat = null;
		Etudiant etudiant = null;
		String laRequete = null;
		System.out.println("methode getAlletu");
		try{
			connection = super.getConnection();
			laRequete = "SELECT * FROM client where identifiant=?";
			prepStat =connection.prepareStatement(laRequete);
			prepStat.setString(1, identifiant);
			resultSet=prepStat.executeQuery();

			if (resultSet!=null){
				while (resultSet.next()){
					etudiant = mapperEtudiant(resultSet);
					System.out.println(etudiant.getSexe());
					allEtudiants.add(etudiant);
				}
			}else
				System.out.println("Aucun client dans la base");

		}catch(Exception ex){
			etudiant=null;
			System.out.println("erreur dans la requette " + ex);
		}

		try{
			resultSet.close();
			prepStat.close();
			connection.close();
		}catch(Exception ex){
			System.out.println("Impossible de fermer un objet");
			ex.printStackTrace();
		}
		System.out.println(allEtudiants.isEmpty());
		return allEtudiants;
	}	


	public boolean isEtudiantExist(String identifiant){
		PreparedStatement prepStat = null;
		String laRequete = null;

		try{
			connection = super.getConnection();
			laRequete = "SELECT * FROM client WHERE identifiant=?";
			prepStat =connection.prepareStatement(laRequete);
			prepStat.setString(1, identifiant);
			resultSet=prepStat.executeQuery();

			if (resultSet!=null){
				if (resultSet.next()){
					return true;

				}
			}else
				System.out.println("client introuvable dans la base");

		}catch(Exception ex){
			System.out.println("erreur dans la requette" + ex);
		}

		try{
			resultSet.close();
			prepStat.close();
			connection.close();
		}catch(Exception ex){
			System.out.println("Impossible de fermer un objet");
			ex.printStackTrace();
		}

		return false;
	}
	
	
	public boolean isEtudiantExist(int identifiant){
		PreparedStatement prepStat = null;
		String laRequete = null;
		boolean isExist = false;

		try{
			connection = super.getConnection();
			laRequete = "SELECT * FROM developpeur WHERE IDENTIFIANT=?";
			prepStat =connection.prepareStatement(laRequete);
			prepStat.setInt(1, identifiant);
			resultSet=prepStat.executeQuery();

			if (resultSet!=null){
				if (resultSet.next()){
					isExist = true;

				}
			}

		}catch(Exception ex){
			System.out.println("erreur dans la requette" + ex);
		}

		try{
			resultSet.close();
			prepStat.close();
			connection.close();
		}catch(Exception ex){
			System.out.println("Impossible de fermer un objet");
			ex.printStackTrace();
		}

		return isExist;
	}

	//Renvoi tous les pseudos - valable pour Ajax demo 
	public ArrayList<String> getAllPseudo(String compte){
		PreparedStatement prepStat = null;
		String laRequete = null;
		ArrayList<String> listPseudo=new ArrayList<String>();
		try{
			connection = super.getConnection();
			laRequete = "SELECT pseudo FROM client where identifiant=?";
			prepStat =connection.prepareStatement(laRequete);
			prepStat.setString(1, compte);
			resultSet=prepStat.executeQuery();

			if (resultSet!=null){
				while (resultSet.next()){
					listPseudo.add(resultSet.getString("identifiant"));
				}
			}else
				System.out.println("Aucun developpeur dans la base");

		}catch(Exception ex){
			System.out.println("erreur dans la requette " + ex);
		}

		try{
			resultSet.close();
			prepStat.close();
			connection.close();
		}catch(Exception ex){
			System.out.println("Impossible de fermer un objet");
			ex.printStackTrace();
		}

		return listPseudo;
	
	
	

	
	}

























}







