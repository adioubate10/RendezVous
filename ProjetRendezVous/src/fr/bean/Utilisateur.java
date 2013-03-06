package fr.bean;
 
/**
 * @author diop
 * 2013 février
 *
 * Bean simpleUtilisateur.
 */
 
public class Utilisateur {
 
	/*
	 * Attributs
	 */
 
	/**
	 * L'identifiant
	 */
	String identifiant;
	/**
	 * Le mot de passe
	 */
	String mdp;
 
	/*
	 * Constructeurs
	 */
 
	/**
	 * Constructeur vide
	 */
	public Utilisateur() {
		// vide
	}	
 
	/**
	 * Constructeur qualifié
	 * @param identifiant
	 * @param mdp
	 */
	public Utilisateur(String identifiant, String mdp) {
		super();
		this.identifiant = identifiant;
		this.mdp = mdp;
	}
 
	/*
	 * Getters et setters
	 */	
 
	/**
	 * @return identifiant
	 */
	public String getIdentifiant() {
		return identifiant;
	}
 
	/**
	 * @param identifiant
	 */
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	/**
	 * @return mdp
	 */
	public String getMdp() {
		return mdp;
	}
	/**
	 * @param mdp
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
 
}
