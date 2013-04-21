package fr.rendezvous.actions;


import org.apache.struts2.config.Result;

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

//@Result( name="SUCCESS",value="vues/utilisateurs/ControlleurEtudiant.jsp" )

public class HelloObjis2Action extends ActionSupport{
	
	/* Texte d'accueil 'static'. Pas d'internationnalisation (I18N)
	 */
	private static final String GREETING = "Bonjour ";

	/*
	 * Par default, le framework Struts 2  invoke la methode execute() 
	 * de l'objet Action.  Plusieurs strategies existent pour invoquer d'autres methodes
	 * , mais c'est la m�thode invoqu�e par defaut.
	 *  
	 */
	
    public String execute()  {
    	
    	/* Construit message d'accueil personnalis�.  
    	 * Fait en sorte que ce message personnalis� puisse �tre lu 
    	 * par la vue (Result).
    	 */ 
    	
    	setAccueilPersonalise( GREETING + getNom() );
    	
    	/* Ici pas d'echec possible, donc on dit que notre logique m�tier a reussit.
    	 */
    	
    	return SUCCESS;
    }


    /*
     * Action struts 2 = Javabean = propri�r�s + m�thodes
     * Necessaire au m�canisme de transfer de donn�es de Struts 2.
     * le 'nom' et le 'messageAcceuilPersonalis�' seront disponible dans ValueStack
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
