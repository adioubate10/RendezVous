package fr.rendezvous.boiteoutils;

import javax.servlet.http.HttpServletRequest;

public class GestionDroit 
{
	private HttpServletRequest request;
	
	public GestionDroit(HttpServletRequest request)
	{
		this.request = request;
	}
	
	public boolean estAutorise(Boolean administrateur, Boolean client, Boolean publique)
	{
		if(request.getSession().getAttribute("compte") == null)
		{
			if(publique == Boolean.FALSE)
			{
				return false;
			}
		}
		else
		{
			if(request.getSession().getAttribute("compte").getClass() == fr.rendezvous.javabeans.Client.class && client == Boolean.FALSE)
			{
				return false;
			}
		}
		
		return true;
	}
}
