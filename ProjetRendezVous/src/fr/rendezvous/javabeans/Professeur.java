package fr.rendezvous.javabeans;

public class Professeur extends Client {
	private String id;
	private String telFixe;
	private String grade;
	private String specialite;
	private String specialiteDesc;
	public Professeur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Professeur(int idClient, String nom, String prenom, String mail,
			String telephone, String adresse, String codePostal, String ville,
			String pays, String identifiant, String motDePasse,
			String confirmationMotDePasse, String sexe, String dateNaissance,String id, String telFixe, String grade,
			String specialite, String specialiteDesc) {
		super(idClient, nom, prenom, mail, telephone, adresse, codePostal, ville, pays,
				identifiant, motDePasse, confirmationMotDePasse, sexe, dateNaissance);
		// TODO Auto-generated constructor stub
		
		this.id = id;
		this.telFixe = telFixe;
		this.grade = grade;
		this.specialite = specialite;
		this.specialiteDesc = specialiteDesc;
	}
	
	public Professeur(String id, String telFixe, String grade,
			String specialite, String specialiteDesc) {
		super();
		this.id = id;
		this.telFixe = telFixe;
		this.grade = grade;
		this.specialite = specialite;
		this.specialiteDesc = specialiteDesc;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTelFixe() {
		return telFixe;
	}
	public void setTelFixe(String telFixe) {
		this.telFixe = telFixe;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public String getSpecialiteDesc() {
		return specialiteDesc;
	}
	public void setSpecialiteDesc(String specialiteDesc) {
		this.specialiteDesc = specialiteDesc;
	}
	
	
}
