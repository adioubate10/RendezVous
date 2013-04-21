<!-- Entete de la page -->
<%@ include file="../outils/entete.jspf" %>

	<br/><br/>
	<center>
	
	<s:form action="modifier_Client" method="post">
	<table cellpadding="5" cellspacing="0" class="formulaire">
	<tr><td colspan="2" class="titreformulaire">Vos informations</td></tr>
	<tr><td>	
	<s:textfield key="#session.compte.identifiant" label="%{getText('client.identifiant')}" cssClass="input" readonly="true"/>		
	<s:textfield key="#session.compte.nom" label="%{getText('client.nom')}" cssClass="input" readonly="true"/>
	<s:textfield key="#session.compte.prenom" label="%{getText('client.prenom')}" cssClass="input" readonly="true"/>
	<s:textfield key="#session.compte.sexe" label="%{getText('client.sexe')}" cssClass="input" readonly="true"/>
	<s:textfield key="#session.compte.dateNaissance" label="%{getText('client.dateNaissance')}" cssClass="input" readonly="true"/>
	<s:textfield key="#session.compte.mail" label="%{getText('client.mail')}" cssClass="input" readonly="true"/>
	<s:textfield key="#session.compte.telephone" label="%{getText('client.telephone')}" cssClass="input" readonly="true"/>
	<s:textfield key="#session.compte.adresse" label="%{getText('client.adresse')}" cssClass="input" readonly="true"/>
	<s:textfield key="#session.compte.codePostal" label="%{getText('client.codePostal')}" cssClass="input" readonly="true"/>
	<s:textfield key="#session.compte.ville" label="%{getText('client.ville')}" cssClass="input" readonly="true"/>
	<s:textfield key="#session.compte.pays" label="%{getText('client.pays')}" cssClass="input" readonly="true"/>
	
	<s:textfield key="#session.compte.numeroEtudiant" label="%{getText('etudiant.numeroEtudiant')}" cssClass="input" readonly="true"/>
	<s:textfield key="#session.compte.option" label="%{getText('etudiant.option')}" cssClass="input" readonly="true"/>
	<s:textfield key="#session.compte.niveau" label="%{getText('etudiant.niveau')}" cssClass="input" readonly="true"/>
	<s:textfield key="#session.compte.serviceSocial" label="%{getText('etudiant.serviceSocial')}" cssClass="input" readonly="true"/>
	</td></tr>
	<tr>
	<td colspan="2" align="center">
	<input type="hidden" name="idClient" value="<c:out value="${compte.idClient}"/>"/>
	<s:submit type="image" src="images/application/modifier.gif" align="center"></s:submit>
	</td>
	</tr>
	</table>
	</s:form>
	
	</center>										

<!-- Pieds de page -->
<%@ include file="../outils/piedpage.jspf" %>