package fr.rendezvous.actions;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Diop
 * @copyright 2013
 * @version 0.1
 */
@SuppressWarnings("serial")
public class DeconnexionAction extends ActionSupport implements ServletRequestAware, SessionAware{
    
    private HttpServletRequest request;
	private HttpSession session;
	private Map sessionMap;
	
	 public void setServletRequest(HttpServletRequest request)
	 {
		 this.request=request;
	 }

	
	 public void setSession(Map map)
	 {
		 this.sessionMap=map;
	 }
	 

	// D�connexion de l'utilisateur
	public String execute()
	{
		// Variables
		HttpSession session=request.getSession();
		// Destruction de la session
		sessionMap.clear();
		session.invalidate();

		return SUCCESS;
	}
	
	
	   
}