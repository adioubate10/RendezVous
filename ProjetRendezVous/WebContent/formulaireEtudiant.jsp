<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
	<style type="text/css">@import url(css/styles.css);</style>
    <title>Gestion des rendez vous</title>
   
	</head>

	<body>
	<!-- Entete de la page -->
<%@ include file="/vues/outils/entete.jspf" %>
	   <s:form action="helloObjis">
    	<s:textfield name="accueil" label="Votre Nom"/>
    	<s:submit/>
		</s:form>
	    
		<!-- Pieds de page -->
<%@ include file="vues/outils/piedpage.jspf" %>
	</body>
	
</html>
