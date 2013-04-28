package fr.rendezvous.javabeans;

public class RendezVous {
private int idRdv;
private String titre;
private String adresse;
private String heureDebut;
private String heureFin;
private int etudiant;
private int patient;

public RendezVous() {
	super();
	// TODO Auto-generated constructor stub
}

public RendezVous(int idRdv, String titre, String adresse, String heureDebut,
		String heureFin, int etudiant, int patient) {
	super();
	this.idRdv = idRdv;
	this.titre = titre;
	this.adresse = adresse;
	this.heureDebut = heureDebut;
	this.heureFin = heureFin;
	this.etudiant = etudiant;
	this.patient = patient;
}

public void setHeureFin(String heureFin) {
	this.heureFin = heureFin;
}

public int getIdRdv() {
	return idRdv;
}

public void setIdRdv(int idRdv) {
	this.idRdv = idRdv;
}

public String getTitre() {
	return titre;
}

public void setTitre(String titre) {
	this.titre = titre;
}

public String getAdresse() {
	return adresse;
}

public void setAdresse(String adresse) {
	this.adresse = adresse;
}

public String getHeureDebut() {
	return heureDebut;
}

public void setHeureDebut(String heureDebut) {
	this.heureDebut = heureDebut;
}

public String getHeureFin() {
	return heureFin;
}

public void setHeuredateFin(String heureFin) {
	this.heureFin = heureFin;
}

public int getEtudiant() {
	return etudiant;
}

public void setEtudiant(int etudiant) {
	this.etudiant = etudiant;
}

public int getPatient() {
	return patient;
}

public void setPatient(int patient) {
	this.patient = patient;
}

}
