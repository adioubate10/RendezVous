package fr.rendezvous.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class ListingAction extends ActionSupport {
	@SuppressWarnings("rawtypes")
	private List lstList1 = null;
    private String status="Etu";
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String execute() throws Exception {
		populateDetail();
		return SUCCESS;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void populateDetail() {
		lstList1 = new ArrayList();
		
		lstList1.add("Etudiant");
		lstList1.add("Patient");
		lstList1.add("Professeur");

	}

	@SuppressWarnings("rawtypes")
	public List getLstList1() {
		return lstList1;
	}

	@SuppressWarnings("rawtypes")
	public void setLstList1(List lstList1) {
		this.lstList1 = lstList1;
	}
}