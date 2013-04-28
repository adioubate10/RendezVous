<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!-- Entete de la page -->
<%@ include file="../outils/entete.jspf" %>
<head>
<sx:head/>
<title>Listing</title>
</head>

<body>

<s:form  action="Validerrdv"  theme="simple">



<table cellpadding="5" cellspacing="0" class="formulaire">
	<tr><td><s:property value="%{getText('rendezvous.titre')}"/> : </td><td><s:textfield name="rendezvous.titre" cssClass="input" cssErrorStyle="background-color:#D53A3E" value="Titre"/></td></tr>
	<tr><td><s:property value="%{getText('rendezvous.adresse')}"/> : </td><td><s:textfield name="rendezvous.adresse" cssClass="input" cssErrorStyle="background-color:#D53A3E" value="description"/></td></tr>
	<tr><td><s:property value="%{getText('rendezvous.heuredeb')}"/> : </td><td><s:textfield value="2013-04-25T16:00:00-08:00" name="rendezvous.heureDebut" cssClass="input" cssErrorStyle="background-color:#D53A3E" /></td></tr>
	<tr><td><s:property value="%{getText('rendezvous.heurefin')}"/> : </td><td><s:textfield value="2013-04-25T18:00:00-08:00" name="rendezvous.heureFin" cssClass="input" cssErrorStyle="background-color:#D53A3E" /></td></tr>
	  <tr><td>MDP:</td><td><select hidden="false" id="mail" name="professeur.motDePasse"><option hidden="false" value="<c:out value="${compte.motDePasse}"/>"></option></select></td></tr>
	  
	    <tr><td>Mail:</td><td><select id="mail" name="professeur.mail"><option value="<c:out value="${compte.mail}"/>"></option></select></td></tr>
	    <tr><td>titre:</td><td hidden="true"><select id="titre" name="calendrier.id"><option value="<c:out value="${calendrier.id}"/>"><c:out value="${calendrier.id}"/></option>
	    
</select></td></tr>
	<tr><td colspan="2" align="center"><s:submit type="image" src="images/application/enregistrer.gif"></s:submit></td></tr>
	
	</table>
</s:form>

</body>
</html>