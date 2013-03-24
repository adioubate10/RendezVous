package fr.rendezvous.bean;

import fr.rendezvous.bean.Client;

//import org.apache.struts2.config.Result;

//import com.opensymphony.xwork2.ActionSupport;
public class Etudiant extends Client{
	/*
     * Action struts 2 = Javabean = propriérés + méthodes
     * Necessaire au mécanisme de transfer de données de Struts 2.
     * le 'nom' et le 'messageAcceuilPersonalisé' seront disponible dans ValueStack
     */
    
    private String matiere;
    private String specialite;
    private String niveau;
    private String numerocarte;
	
	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
		this.matiere="dl";
	}
	
	

	public Etudiant(String nom, String prenom, String age, String adresse,
			String profession, String sexe, String nationalite, String email,
			String telephone, String identifiant, String mdp,String mdpconf) {
		super(nom, prenom, age, adresse, profession, sexe, nationalite, email,
				telephone, identifiant, mdp,mdpconf);
		// TODO Auto-generated constructor stub
	}
	public Etudiant(String nom, String prenom, String age, String adresse,
			String profession, String sexe, String nationalite, String email,
			String telephone, String identifiant, String mdp,String mdpconf,String matiere, String specialite, String niveau, String numerocarte) {
		super(nom, prenom, age, adresse, profession, sexe, nationalite, email,
				telephone, identifiant, mdp,mdpconf);
		this.matiere = matiere;
		this.specialite = specialite;
		this.niveau = niveau;
		this.numerocarte = numerocarte;
		// TODO Auto-generated constructor stub
	}
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	public String getNumerocarte() {
		return numerocarte;
	}
	public void setNumerocarte(String numerocarte) {
		this.numerocarte = numerocarte;
	}
 
    
}
