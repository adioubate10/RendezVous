package fr.entite.etudiant;

//import org.apache.struts2.config.Result;

//import com.opensymphony.xwork2.ActionSupport;
public class Etudiant {
	/*
     * Action struts 2 = Javabean = propri�r�s + m�thodes
     * Necessaire au m�canisme de transfer de donn�es de Struts 2.
     * le 'nom' et le 'messageAcceuilPersonalis�' seront disponible dans ValueStack
     */
    
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
 
    public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
}
