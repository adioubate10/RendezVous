package fr.rendezvous.actions;


import org.apache.struts2.config.Result;

import com.opensymphony.xwork2.ActionSupport;

/* 
 * Action Hello Objis .  Cette action s'attend recevoir 
 * un nom entree partir d'une jsp : Nom.jsp. 
 *  
 * La logique metier de cette action : 
 * concatenation du nom avec un message d'accueil 'static'
 * puis rendre ce message personnalise disponible pour 
 * le composant Result  qui il le forwarde.  
 */

//@Result( name="SUCCESS",value="vues/utilisateurs/ControlleurEtudiant.jsp" )

public class HelloObjis2Action extends ActionSupport{
	
	/* Texte d'accueil 'static'. Pas d'internationnalisation (I18N)
	 */
	private static final String GREETING = "Bonjour ";

	/*
	 * Par default, le framework Struts 2  invoke la methode execute() 
	 * de l'objet Action.  Plusieurs strategies existent pour invoquer d'autres methodes
	 * , mais c'est la methode invoqu�e par defaut.
	 *  
	 */
	
    public String execute()  {
    	
    	/* Construit message d'accueil personnalise.  
    	 * Fait en sorte que ce message personnalise puisse etre lu 
    	 * par la vue (Result).
    	 */ 
    	
    	setAccueilPersonalise( GREETING + getNom() );
    	
    	/* Ici pas d'echec possible, donc on dit que notre logique metier a reussit.
    	 */
    	
    	return SUCCESS;
    }


    /*
     * Action struts 2 = Javabean = proprieres + methodes
     * Necessaire au mecanisme de transfer de donnees de Struts 2.
     * le 'nom' et le 'messageAcceuilPersonalise' seront disponible dans ValueStack
     */
    
    private String nom;
    
 
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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
