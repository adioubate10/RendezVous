package fr.rendezvous.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.*;

@SuppressWarnings("serial")
public class UnicodeToISO extends BodyTagSupport 
{	
	public int doAfterBody()throws JspException
	{	
		/* D�finition des variables */
		BodyContent corpsHTML;
		String texte;
		
		try
		{
			/* On r�cupert le texte entre les balises */
			corpsHTML = this.getBodyContent();
			texte = corpsHTML.getString();
			
			/* Affichage de l'apostrophe */
			texte = texte.replaceAll("&#039;", "'");
			
			/* Affichage du � commercial */
			texte = texte.replaceAll("&amp;", "&");
			
			/* Affichage du r�sum� */
			corpsHTML.getEnclosingWriter().print(texte);
		}
		catch(Exception e)
		{
			throw new JspTagException(e.getMessage());
		}
		return EVAL_BODY_INCLUDE;
	}
}