<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
    <title>Gestion des rendez vous</title>
	</head>

	<body>
	    <hr>
		<h4>Entrez votre nom. Nous allons personnaliser un message d'accueil !</h4> 	
		<s:form action="valider" method="post">
    	<s:textfield name="etudiant.nom" label="Nom"/>
    	<s:textfield name="etudiant.prenom" label="Prenom"/>
    	<s:textfield name="etudiant.adresse" label="Adresse"/>
    	<s:textfield name="etudiant.telephone" label="Tel"/>
    	<s:submit value="Creer" align="center" cssClass="boutonLogin"/>
    	
		</s:form>
	    <hr>	
	</body>
	
</html>
