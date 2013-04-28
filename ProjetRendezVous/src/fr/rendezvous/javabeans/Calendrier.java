package fr.rendezvous.javabeans;

import java.util.List;

public class Calendrier {
 private String titre;
 private String description;
 private String date;
 private String couleur;
 private String lieu;
 private String id;
 private int identifient;
 private int professeur;
private List<RendezVous> listeRendezVous;
 public Calendrier(String titre, String description, String date,
		String couleur, String lieu, String id, int identifient,
		int professeur) {
	super();
	this.titre = titre;
	this.description = description;
	this.date = date;
	this.couleur = couleur;
	this.lieu = lieu;
	this.id = id;
	this.identifient = identifient;
	this.professeur = professeur;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public int getIdentifient() {
	return identifient;
}
public void setIdentifient(int identifient) {
	this.identifient = identifient;
}


public int getProfesseur() {
	return professeur;
}
public void setProfesseur(int professeur) {
	this.professeur = professeur;
}
public Calendrier() {
	super();
	// TODO Auto-generated constructor stub
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
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getCouleur() {
	return couleur;
}
public void setCouleur(String couleur) {
	this.couleur = couleur;
}
public String getLieu() {
	return lieu;
}
public void setLieu(String lieu) {
	this.lieu = lieu;
}
public List<RendezVous> getListeRendezVous() 
{
	return listeRendezVous;
}

public void setListeRendezVous(List<RendezVous> listeRendezVous) 
{
	this.listeRendezVous = listeRendezVous;
}
}
