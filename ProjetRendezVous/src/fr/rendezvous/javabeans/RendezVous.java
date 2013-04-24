package fr.rendezvous.javabeans;

public class RendezVous {
private int dRdv;
private String titre;
private String description;
private String heureDebut;
private String heuredateFin;
private Etudiant etudiant;
private Patient patient;
public RendezVous(int dRdv, String titre, String description,
		String heureDebut, String heuredateFin, Etudiant etudiant,
		Patient patient) {
	super();
	this.dRdv = dRdv;
	this.titre = titre;
	this.description = description;
	this.heureDebut = heureDebut;
	this.heuredateFin = heuredateFin;
	this.etudiant = etudiant;
	this.patient = patient;
}
public RendezVous() {
	super();
	// TODO Auto-generated constructor stub
}
public int getdRdv() {
	return dRdv;
}
public void setdRdv(int dRdv) {
	this.dRdv = dRdv;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getHeureDebut() {
	return heureDebut;
}
public void setHeureDebut(String heureDebut) {
	this.heureDebut = heureDebut;
}
public String getHeuredateFin() {
	return heuredateFin;
}
public void setHeuredateFin(String heuredateFin) {
	this.heuredateFin = heuredateFin;
}
public Etudiant getEtudiant() {
	return etudiant;
}
public void setEtudiant(Etudiant etudiant) {
	this.etudiant = etudiant;
}
public Patient getPatient() {
	return patient;
}
public void setPatient(Patient patient) {
	this.patient = patient;
}

}
