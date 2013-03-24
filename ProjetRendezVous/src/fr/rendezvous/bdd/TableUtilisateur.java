package fr.rendezvous.bdd;
 
import java.util.ArrayList;
import java.util.List;

import fr.rendezvous.bean.Utilisateur;
 
/**
 * @author diop
 * 2013 f�vrier
 *
 * Table Utilisateurs.
 */
 
public class TableUtilisateur {
 
	/**
	 * On cr�� une lise d'utilisateur.
	 * @return
	 * @return malist
	 */
	public List<Utilisateur > creationList() {
 
		List<Utilisateur > malist = new ArrayList<Utilisateur>();
 
		Utilisateur a = new Utilisateur("diop", "pass");
		Utilisateur b = new Utilisateur("j�rome", "pass2");
		Utilisateur c = new Utilisateur("admin", "admin");
		Utilisateur d = new Utilisateur("user", "user");
 
		malist.add(a);
		malist.add(b);
		malist.add(c);
		malist.add(d);
 
		return malist;
 
	}
 
}
