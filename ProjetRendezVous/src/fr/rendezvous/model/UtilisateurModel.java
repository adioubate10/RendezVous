package fr.rendezvous.model;
 
import java.util.List;
import fr.rendezvous.bdd.TableUtilisateur;
import fr.rendezvous.bean.Utilisateur;
 
/**
 * @author diop
 * 2013 f�vrier
 *
 *  Model Utilisateur.
 */
 
public class UtilisateurModel {
 
	//-------------------------------------------------------------
	// Methodes du model
	//-------------------------------------------------------------	
 
	/**
	 * Methode d'identifiacation de l'utilisateur
	 * @param loginForm
	 * @param passwordForm
	 * @return
	 */
	public boolean isIdentifier(String loginForm, String passwordForm) {
 
		// on r�cup�re la liste dans la base de donn�e (ici en dur)
		TableUtilisateur currentListe = new TableUtilisateur();
		List<Utilisateur> malist = currentListe.creationList();
 
		//on parcour la liste et on teste les entr�es du formulaire.
		for (int i = 0; i <malist.size(); i++) {
			if(loginForm.equalsIgnoreCase(malist.get(i).getIdentifiant()) && passwordForm.equalsIgnoreCase(malist.get(i).getMdp())) {
				return true;
			}
		}
		return false;
	}
 
}
