package fr.rendezvous.actions;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import fr.rendezvous.javabeans.Professeur;


@SuppressWarnings("serial")
public class ProfesseurAction extends ActionSupport {
	private String lst;
	@SuppressWarnings("rawtypes")
	private List lstList = null;

	private String txtgrade;
	private String txttelfixe;
	private String txtspecialite;
	
	private String txtspecialitedescrip;
    private Professeur professeur;

	public Professeur getProfesseur() {
		return professeur;
	}

	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}

	public String getTxtspecialitedescrip() {
		return txtspecialitedescrip;
	}

	public void setTxtspecialitedescrip(String txtspecialitedescrip) {
		this.txtspecialitedescrip = txtspecialitedescrip;
	}

	public String getTxtgrade() {
		return txtgrade;
	}

	public void setTxtgrade(String txtgrade) {
		this.txtgrade = txtgrade;
	}

	public String getTxttelfixe() {
		return txttelfixe;
	}

	public void setTxttelfixe(String txttelfixe) {
		this.txttelfixe = txttelfixe;
	}

	public String getTxtspecialite() {
		return txtspecialite;
	}

	public void setTxtspecialite(String txtspecialite) {
		this.txtspecialite = txtspecialite;
	}

	public String execute() throws Exception {

		if (getLst() != null && !getLst().equals("")) {
			populateDetail(getLst());
			return SUCCESS;
		}
		else
		{
			return SUCCESS;
		}
	}

	private void populateDetail(String id) {

		if (id.equalsIgnoreCase("Etudiant")) {

			txtgrade=getText("professeur.numero");
			txttelfixe=getText("professeur.serviceSocial");
			txtspecialite=getText("professeur.option");
			txtspecialitedescrip=getText("professeur.niveau");
		} 
	}

	public List getLstList() {
		return lstList;
	}

	public void setLstList(List lstList) {
		this.lstList = lstList;
	}

	public String getLst() {
		return lst;
	}

	public void setLst(String lst) {
		this.lst= lst;
	}
}