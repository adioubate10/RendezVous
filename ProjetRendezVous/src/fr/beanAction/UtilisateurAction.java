package fr.beanAction;

import java.util.Map;

//import org.apache.struts2.config.Result;
//import javax.servlet.http.HttpServletRequest;
import fr.model.UtilisateurModel;
import fr.bean.Utilisateur;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
 
/**
 * @author diop
 *
 * JEE projet 2013-2014
 *
 * Action Classe : UtilisateurAction
 */
//@Result( value="/connexion/success.jsp" )
public class UtilisateurAction extends ActionSupport {
 
	//-------------------------------------------------------------
	// Properties
	//-------------------------------------------------------------
 
	/**
	 * Description :
	 * long serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
 
	// Objets
	private Utilisateur utilisateur;
 
	/**
	 * utilisateur identifié ?
	 */
	private boolean identificationUtilisateur;
 
	//-------------------------------------------------------------
	// Getters et setters
	//-------------------------------------------------------------		
 
	/**
	 * Accesseur
	 * @return the utilisateur
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
 
	/**
	 * Mutateur
	 * @param utilisateur the utilisateur to set
	 */
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
 
	/* (non-Javadoc)
	 * @see org.apache.struts2.interceptor.ServletRequestAware#setServletRequest(javax.servlet.http.HttpServletRequest)
	 
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
 
	}
 */
	//-------------------------------------------------------------
	// Others methods
	//-------------------------------------------------------------	
 
	/**
	 * Methode
	 * Description : Permet d'identifier un utilisateur en fonction de son mot de passe et login.
	 * @return @struts Error or SUCCESS
	 */
 
	public String identifierUtilisateurs()  {
 
		// on créé un nouveau model
		UtilisateurModel utilisateurModel = new UtilisateurModel();
 
		// on récupère les données du formulaire
 
		String loginForm = utilisateur.getIdentifiant();
		String passwordForm = utilisateur.getMdp();
		System.out.println(loginForm);
		// on interroge le model
		identificationUtilisateur = utilisateurModel.isIdentifier(loginForm, passwordForm);
		// test métier si l'identification est ok
		if (identificationUtilisateur == true) {
 
			//on récupère la session courante
			Map<String, Object> session = ActionContext.getContext().getSession();
			// on renseigne la session
			session.put("authentification","true");
			session.put("nomUtilisateur",utilisateur.getIdentifiant());
			session.put("erreur", "noErreur");
			System.out.println("Vous êtes loggué avec succès enjoy :)");
            
			return SUCCESS;
		}
		return ERROR;
	}
 
}
