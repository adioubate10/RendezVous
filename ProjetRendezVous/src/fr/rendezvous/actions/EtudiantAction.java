package fr.rendezvous.actions;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import fr.rendezvous.javabeans.Etudiant;

@SuppressWarnings("serial")
public class EtudiantAction extends ActionSupport {
private String lst;
@SuppressWarnings("rawtypes")
private List lstList = null;

private String txtnumeroEtudiant;
private String txtserviceSocial;
private String txtoption;
private String txtniveau;
private Etudiant etudiant;
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
} else {
return SUCCESS;
}
}

private void populateDetail(String id) {

if (id.equalsIgnoreCase("Etudiant")) {

txtnumeroEtudiant=getText("client.numero");
txtserviceSocial=getText("client.serviceSocial");
txtoption=getText("client.option");
txtniveau=getText("client.niveau");
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