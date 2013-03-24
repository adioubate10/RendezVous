package fr.rendezvous.bdd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.rendezvous.bean.Etudiant;

public class ChargeDriver {
	  
		   /*
	       try {
	           Class.forName("com.mysql.jdbc.Driver").newInstance();
	           System.out.println("Le chargement du driver fonctionne");
	       } catch (Exception ex) {
	           // traitement de l'erreur
	       }
	   }  
	   */
		   //new ModelDAO().getConnection();
		   public static void main(String[] args) throws Exception {
			   new EtudiantModel().ajouterEtudiant(new Etudiant());
		   }
	}
