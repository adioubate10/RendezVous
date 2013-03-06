package fr.entite.etudiant;

import com.opensymphony.xwork2.ActionSupport;



/* 
 * Action Hello Objis .  Cette action s'attend � recevoir 
 * un nom entr� � partir d'une jsp : Nom.jsp. 
 *  
 * La logique m�tier de cette action : 
 * concat�nation du nom avec un message d'accueil 'static'
 * puis rendre ce message personnalis� disponible pour 
 * le composant Result � qui il le forwarde.  
 */

//@Result( name="SUCCESS" , value="/formulaire/ControlleurEtudiant.jsp" )

public class ControlleurEtudiantAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* Texte d'accueil 'static'. Pas d'internationnalisation (I18N)
	 */
	private static final String GREETING = "Bonjour ";
    



	private Etudiant etudiant;
	/*
	 * Par default, le framework Struts 2  invoke la methode execute() 
	 * de l'objet Action.  Plusieurs strategies existent pour invoquer d'autres methodes
	 * , mais c'est la m�thode invoqu�e par defaut.
	 *  
	 */
	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
    public String execute()  {
    	
    	/* Construit message d'accueil personnalis�.  
    	 * Fait en sorte que ce message personnalis� puisse �tre lu 
    	 * par la vue (Result).
    	 */ 
    	
    	setAccueilPersonalise( GREETING + etudiant.getNom()+" "+etudiant.getPrenom()+" "+etudiant.getAdresse()+" "+etudiant.getTelephone() );
    	
    	/* Ici pas d'echec possible, donc on dit que notre logique m�tier a reussit.
    	 */
    	
    	return SUCCESS;
    }


    
    private String accueilPersonalise;
    
    public String getAccueilPersonalise()
    {
    	return accueilPersonalise;
    }
    
    public void setAccueilPersonalise( String accueilPersonalise ){
    	this.accueilPersonalise = accueilPersonalise;
    }
}
