<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
	<style type="text/css">@import url(css/styles.css);</style>
    <title>Gestion des rendez vous</title>
    <s:property value="%{getText('rendezvous.page.saisir')}"/>
	</head>

	<body>
	    <hr>
		<h4>Entrez votre nom. Nous allons personnaliser un message d'accueil !</h4> 
		<div id="formulaire">		
		<s:form action="valider" method="post">
		
    	<s:textfield name="etudiant.nom" label="Nom"/>
    	<s:textfield name="etudiant.prenom" label="Prenom"/>
    	<s:textfield name="etudiant.adresse" label="Adresse"/>
    	<s:textfield name="etudiant.telephone" label="Tel"/>
    	<s:textfield name="etudiant.sexe" label="Sexe"/>
    	<s:textfield name="etudiant.email" label="Mail"/>
    	<s:textfield name="etudiant.nationalite" label="Nationalite"/>
    	<s:textfield name="etudiant.profession" label="Profession"/>
    	<s:textfield name="etudiant.identifiant" label="identifiant"/>
    	<s:password name="etudiant.mdp" label="Mot de passe"/>
    	<s:password name="etudiant.mdpconf" label="Confirmation de Mot de passe"/>
    	<s:textfield name="etudiant.matiere" label="Matiere"/>
    	<s:textfield name="etudiant.specialite" label="Specialite"/>
    	<s:textfield name="etudiant.niveau" label="Annne"/>
    	<s:textfield name="etudiant.numerocarte" label="Numero"/>
    	<s:submit value="Creer" align="right"  cssClass="boutonLogin"/>
    	
		</s:form>
		</div>
	    <hr>
	    <p>
			<a href="lister_Etudiant.action"><s:text name="developpez.lien.lister"/></a><br/>
			<a href="supprimer_Developpeur.action"><s:text name="developpez.lien.supprimer"/></a><br/>
			<a href="rechercher_Developpeur.action"><s:text name="developpez.lien.rechercher"/></a><br/>
			<a href="demoajax_Developpeur.action"><s:text name="developpez.lien.ajaxdemo"/></a>
		</p>	
	</body>
	
</html>
