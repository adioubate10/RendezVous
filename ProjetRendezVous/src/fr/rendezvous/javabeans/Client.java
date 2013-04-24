package fr.rendezvous.javabeans;

import java.util.List;


public class Client 
{
	// variable
	private int idClient;
	private String nom;
	private String prenom;
	private String mail;
	private String telephone;
	private String adresse;
	private String codePostal;
	private String ville;
	private String pays;
	private String identifiant;
	private String motDePasse;
	private String confirmationMotDePasse;
	private String sexe;
	private String dateNaissance;
	//private List<Raccourci> listeFavoris;
	
	
	public Client()
	{
		super();
		
	}
	
	
	public Client(String status) {
		super();
		
	}


	public Client(int idClient, String nom, String prenom, String mail,
			String telephone, String adresse, String codePostal, String ville,
			String pays, String identifiant, String motDePasse,
			String confirmationMotDePasse, String sexe, String dateNaissance) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.telephone = telephone;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.confirmationMotDePasse = confirmationMotDePasse;
		this.sexe = sexe;
		this.dateNaissance = dateNaissance;
		
	}


	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getAdresse()
	{
		return adresse;
	}

	public void setAdresse(String adresse) 
	{
		this.adresse = adresse;
	}

	public String getCodePostal() 
	{
		return codePostal;
	}

	public void setCodePostal(String codePostal) 
	{
		this.codePostal = codePostal;
	}

	
	public String getIdentifiant()
	{
		return identifiant;
	}

	public void setIdentifiant(String identifiant)
	{
		this.identifiant = identifiant;
	}

	public String getMail() 
	{
		return mail;
	}

	public void setMail(String mail)
	{
		this.mail = mail;
	}

	public String getMotDePasse()
	{
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse)
	{
		this.motDePasse = motDePasse;
	}

	public String getNom() 
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public String getPays()
	{
		return pays;
	}

	public void setPays(String pays)
	{
		this.pays = pays;
	}

	public String getPrenom()
	{
		return prenom;
	}

	public void setPrenom(String prenom) 
	{
		this.prenom = prenom;
	}

	public String getTelephone()
	{
		return telephone;
	}

	public void setTelephone(String telephone) 
	{
		this.telephone = telephone;
	}

	public String getVille() 
	{
		return ville;
	}

	public void setVille(String ville) 
	{
		this.ville = ville;
	}
	

	public String getConfirmationMotDePasse() {
		return confirmationMotDePasse;
	}

	public void setConfirmationMotDePasse(String confirmationMotDePasse) {
		this.confirmationMotDePasse = confirmationMotDePasse;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	private String status="Professeur";


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
}
