package fr.rendezvous.actions;


import org.apache.struts2.config.Result;

import com.opensymphony.xwork2.ActionSupport;

/* 
 * Action Hello Objis .  Cette action s'attend à recevoir 
 * un nom entré à partir d'une jsp : Nom.jsp. 
 *  
 * La logique métier de cette action : 
 * concaténation du nom avec un message d'accueil 'static'
 * puis rendre ce message personnalisé disponible pour 
 * le composant Result à qui il le forwarde.  
 */

//@Result( name="SUCCESS",value="vues/utilisateurs/ControlleurEtudiant.jsp" )

public class HelloObjis2Action extends ActionSupport{
	
	/* Texte d'accueil 'static'. Pas d'internationnalisation (I18N)
	 */
	private static final String GREETING = "Bonjour ";

	/*
	 * Par default, le framework Struts 2  invoke la methode execute() 
	 * de l'objet Action.  Plusieurs strategies existent pour invoquer d'autres methodes
	 * , mais c'est la méthode invoquée par defaut.
	 *  
	 */
	
    public String execute()  {
    	
    	/* Construit message d'accueil personnalisé.  
    	 * Fait en sorte que ce message personnalisé puisse être lu 
    	 * par la vue (Result).
    	 */ 
    	
    	setAccueilPersonalise( GREETING + getNom() );
    	
    	/* Ici pas d'echec possible, donc on dit que notre logique métier a reussit.
    	 */
    	
    	return SUCCESS;
    }


    /*
     * Action struts 2 = Javabean = propriérés + méthodes
     * Necessaire au mécanisme de transfer de données de Struts 2.
     * le 'nom' et le 'messageAcceuilPersonalisé' seront disponible dans ValueStack
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
