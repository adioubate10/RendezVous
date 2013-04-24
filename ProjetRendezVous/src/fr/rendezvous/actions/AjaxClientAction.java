package fr.rendezvous.actions;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import fr.rendezvous.javabeans.Client;
import fr.rendezvous.javabeans.Etudiant;
import fr.rendezvous.javabeans.Professeur;

@SuppressWarnings("serial")
public class AjaxClientAction extends ActionSupport {
	private String lst;
	@SuppressWarnings("rawtypes")
	private List lstList = null;

	private String txtnumeroEtudiant;
	private String txtserviceSocial;
	private String txtoption;
	private String txtniveau;
	private Etudiant etudiant;
	private String txtgrade;
	private String txttelfixe;
	private String txtspecialite;
	private Client client=new Client();
	private String txtspecialitedescrip;
    private Professeur professeur;
    private ListingAction list;
	private static String status="etu56";
	
	public AjaxClientAction() {
		super();
		// TODO Auto-generated constructor stub
		
		setStatus(getLst());
		
	}

	public static String getStatus() {
		return status;
	}

	public ListingAction getList() {
		return list;
	}

	public void setList(ListingAction list) {
		this.list = list;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

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

	public Object getModel() {
		return etudiant;
	}
	
	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public String getTxtserviceSocial() {
		return txtserviceSocial;
	}

	public void setTxtserviceSocial(String txtserviceSocial) {
		this.txtserviceSocial = txtserviceSocial;
	}

	public String getTxtoption() {
		return txtoption;
	}

	public void setTxtoption(String txtoption) {
		this.txtoption = txtoption;
	}

	public String getTxtniveau() {
		return txtniveau;
	}

	public void setTxtniveau(String txtniveau) {
		this.txtniveau = txtniveau;
	}

	public String getTxtnumeroEtudiant() {
		return txtnumeroEtudiant;
	}

	public void setTxtnumeroEtudiant(String txtnumeroEtudiant) {
		this.txtnumeroEtudiant = txtnumeroEtudiant;
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

	public String populateDetail(String id) {

		if (id.equalsIgnoreCase("Etudiant")) {
            
			txtnumeroEtudiant=getText("etudiant.numero");
			txtserviceSocial=getText("etudiant.serviceSocial");
			txtoption=getText("etudiant.option");
			txtniveau=getText("etudiant.niveau");
			setStatus("Etudiant");
			System.out.println("list="+getLst());
		} 
		if (id.equalsIgnoreCase("Professeur")) {

			txtgrade=getText("professeur.grade");
			txttelfixe=getText("professeur.telfixe");
			txtspecialite=getText("professeur.specialite");
			txtspecialitedescrip=getText("professeur.specialitedesc");
			setStatus("Professeur");
		} 
		return getStatus();
	}

	public static void setStatus(String status) {
		// TODO Auto-generated method stub
		AjaxClientAction.status=status;
	}

	public List getLstList() {
		return lstList;
	}

	public void setLstList(List lstList) {
		this.lstList = lstList;
	}

	public  String getLst() {
		return lst;
	}

	public void setLst(String lst) {
		this.lst= lst;
	}
}