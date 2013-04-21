package fr.rendezvous.javabeans;

public class Client2 {
private String nom;
private String prenom;
private String age;
private String adresse;
private String profession;
private String sexe;
private String nationalite;
private String email;
private String telephone;
private String identifiant;
private String mdp;
private String mdpconf;
public Client2(String nom, String prenom, String age, String adresse,
		String profession, String sexe, String nationalite, String email,
		String telephone, String identifiant, String mdp,String mdpconf) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.age = age;
	this.adresse = adresse;
	this.profession = profession;
	this.sexe = sexe;
	this.nationalite = nationalite;
	this.email = email;
	this.telephone = telephone;
	this.identifiant = identifiant;
	this.mdp = mdp;
	this.mdpconf = mdpconf;
}

public Client2() {
	super();
	this.nom="diop";
	this.prenom="pape";
	this.age="27";
	this.sexe="M";
	this.nationalite="sn";
	this.adresse="94 bv embouchure";
	this.telephone="0619462854";
	this.identifiant="diop";
	this.mdp="diop";
	this.email="diop@live.fr";
	this.profession="etudiant";
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}
public String getAdresse() {
	return adresse;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}
public String getProfession() {
	return profession;
}
public void setProfession(String profession) {
	this.profession = profession;
}
public String getSexe() {
	return sexe;
}
public void setSexe(String sexe) {
	this.sexe = sexe;
}
public String getNationalite() {
	return nationalite;
}
public void setNationalite(String nationalite) {
	this.nationalite = nationalite;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getTelephone() {
	return telephone;
}

public void setTelephone(String telephone) {
	this.telephone = telephone;
}

public String getIdentifiant() {
	return identifiant;
}

public void setIdentifiant(String identifiant) {
	this.identifiant = identifiant;
}

public String getMdp() {
	return mdp;
}

public void setMdp(String mdp) {
	this.mdp = mdp;
}
public String getMdpconf() {
	return mdpconf;
}

public void setMdpconf(String mdpconf) {
	this.mdpconf = mdpconf;
}
}
