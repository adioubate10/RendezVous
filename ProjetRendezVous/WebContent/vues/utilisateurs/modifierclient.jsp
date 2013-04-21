<!-- Entete de la page -->
<%@ include file="../outils/entete.jspf" %>

	<br/><br/>
	<center>
	
	<s:form action="validerModifier_Client" method="post" theme="simple">
	<s:hidden key="client.idClient"/>
	<table cellpadding="5" cellspacing="0" class="formulaire">
	<tr><td colspan="2" class="titreformulaire">Vos informations</td></tr>
	<tr><td>
	<tr><td><s:property value="%{getText('client.nom')}"/> : </td><td><s:textfield key="client.nom" cssClass="input" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.prenom')}"/> : </td><td><s:textfield key="client.prenom" cssClass="input" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.mail')}"/> : </td><td><s:textfield key="client.mail" cssClass="input" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.telephone')}"/> : </td><td><s:textfield key="client.telephone" cssClass="input" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.adresse')}"/> : </td><td><s:textfield key="client.adresse" cssClass="input" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.codePostal')}"/> : </td><td><s:textfield key="client.codePostal" cssClass="input" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.ville')}"/> : </td><td><s:textfield key="client.ville" cssClass="input" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.pays')}"/> : </td><td><s:textfield key="client.pays" cssClass="input" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.identifiant')}"/> : </td><td><s:textfield key="client.identifiant" cssClass="input" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.motDePasse')}"/> : </td><td><s:textfield key="client.motDePasse" cssClass="input" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.confirmationMotDePasse')}"/> : </td><td><s:textfield key="client.confirmationMotDePasse" cssClass="input" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td colspan="2" align="center"><s:submit type="image" src="images/application/enregistrer.gif"></s:submit></td></tr>
	</td></tr>
	</table>	
	</s:form>
	
	</center>	
	
<!-- Pieds de page -->
<%@ include file="../outils/piedpage.jspf" %>