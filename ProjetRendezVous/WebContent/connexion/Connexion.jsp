<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<!--  <link rel="stylesheet" type="text/css" href="<s:url value="styles.css"/>" media="all" />-->
		
         <style type="text/css">@import url(css/styles.css);</style>
		
		<title>Formulaire de login</title>
 
	
	</head>
 
	<body>
 <div id="formulaire">
		<s:form action="identificationUtilisateur" method="post" theme="simple"
			cssClass="formulaireLogin">
 
			<p><s:textfield name="utilisateur.identifiant" value="Nom d'utilisateur" size="20" cssClass="inputs" /> 
				<s:textfield name="utilisateur.mdp" value="Mot de passe" size="20" cssClass="inputs" />
				 <s:submit value="Login" align="center" cssClass="boutonLogin"/></p>
 
	
 </s:form>
 </div>	
	</body>
 
</html>