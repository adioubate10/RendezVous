package fr.rendezvous.beanAction;


import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.profiling.UtilTimerStack;

import fr.rendezvous.bdd.EtudiantModel;
import fr.rendezvous.bean.Etudiant;





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

public class EtudiantAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* Texte d'accueil 'static'. Pas d'internationnalisation (I18N)
	 */
	private static final String GREETING = "Bonjour ";
	private ArrayList<Etudiant> listEtudiants = new ArrayList<Etudiant>();

	private String est="c bon";

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
    public String inscrire()  {
    	
    	/* Construit message d'accueil personnalis�.  
    	 * Fait en sorte que ce message personnalis� puisse �tre lu 
    	 * par la vue (Result).
    	 */ 
    	if(etudiant.getMdp().equals(etudiant.getMdpconf())){
    	//setAccueilPersonalise( GREETING +etudiant.getNom() );	
    	//setAccueilPersonalise( GREETING +etudiant.getMatiere() );
    	setAccueilPersonalise( GREETING + etudiant.getSpecialite()+" "+etudiant.getNom()+etudiant.getNiveau()+" "+etudiant.getNumerocarte()+" "+etudiant.getMatiere()+" "+etudiant.getProfession() );
    	/* Ici pas d'echec possible, donc on dit que notre logique m�tier a reussit.
    	 */
    	new Etudiant(etudiant.getNom(),etudiant.getPrenom(),etudiant.getAge(),etudiant.getAdresse(),etudiant.getProfession(),etudiant.getSexe(),etudiant.getNationalite(),etudiant.getEmail(),
    			etudiant.getTelephone(),etudiant.getIdentifiant(),etudiant.getMdp(),etudiant.getMdpconf(),etudiant.getSpecialite(),etudiant.getMatiere(),etudiant.getNiveau(),etudiant.getNumerocarte());
    	//EtudiantModel etudiantModel=new EtudiantModel();
    	 new EtudiantModel().ajouterEtudiant(etudiant);
    	return SUCCESS;
    	}
    	
    	
    	else 
    		return
    				ERROR;
    }
public String listeinscrit()  {
	System.out.println("dans la m�thode lister().....");
//	Map<String, Object> session = ActionContext.getContext().getSession();
	//UtilTimerStack.setActive(true);
	EtudiantModel etudiantModel = new EtudiantModel();
	//String leCompte = (String) session.get("compte");
	listEtudiants =  etudiantModel.getAllEtudiant("diop");
	System.out.println("taille"+listEtudiants.size());
	System.out.println("fin");
	/*
	 session.put("listEtudiant","true");
	session.put("identifiant","dio");
	session.put("mdp","dio");
	session.put("email","dio");
	session.put("adresse","dio");
	session.put("sexe","dio");
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
