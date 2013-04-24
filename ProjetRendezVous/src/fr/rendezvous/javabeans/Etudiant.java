package fr.rendezvous.javabeans;

//import org.apache.struts2.config.Result;

//import com.opensymphony.xwork2.ActionSupport;
public class Etudiant extends Client{
	/*
     * Action struts 2 = Javabean = proprieres + methodes
     * Necessaire au mecanisme de transfer de donnees de Struts 2.
     * le 'nom' et le 'messageAcceuilPersonalisé' seront disponible dans ValueStack
     */
	private String numeroEtudiant;
	private String option;
	private String matiere;
	private String niveau;
	private String serviceSocial;
	private String jeton;
	public String getNumeroEtudiant() {
		return numeroEtudiant;
	}

	public void setNumeroEtudiant(String numeroEtudiant) {
		this.numeroEtudiant = numeroEtudiant;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getMatiere() {
		return matiere;
	}

	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getServiceSocial() {
		return serviceSocial;
	}

	public void setServiceSocial(String serviceSociale) {
		this.serviceSocial = serviceSociale;
	}
	public String getJeton() {
		return jeton;
	}

	public void setJeton(String jeton) {
		this.jeton = jeton;
	}

	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Etudiant(int idClient, String nom, String prenom, String mail,
			String telephone, String adresse, String codePostal, String ville,
			String pays, String identifiant, String motDePasse,
			String confirmationMotDePasse, String sexe, String dateNaissance) {
		super(idClient, nom, prenom, mail, telephone, adresse, codePostal, ville, pays,
				identifiant, motDePasse, confirmationMotDePasse, sexe, dateNaissance);
		// TODO Auto-generated constructor stub
	}

	
    
}
