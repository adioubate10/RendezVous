<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- Entete de la page -->
<%@ include file="../outils/entete.jspf" %>
<head>

<title>Listing</title>
</head>

<body>

<s:form  action="Validercalendrier"  theme="simple">



<table cellpadding="5" cellspacing="0" class="formulaire">
	<tr><td><s:property value="%{getText('calendrier.titre')}"/> : </td><td><s:textfield name="calendrier.titre" cssClass="input" cssErrorStyle="background-color:#D53A3E" value="Titre"/></td></tr>
	<tr><td><s:property value="%{getText('calendrier.description')}"/> : </td><td><s:textfield name="calendrier.description" cssClass="input" cssErrorStyle="background-color:#D53A3E" value="description"/></td></tr>
	<tr><td><s:property value="%{getText('calendrier.date')}"/> : </td><td><s:textfield name="calendrier.date" cssClass="input" cssErrorStyle="background-color:#D53A3E" value="America/Los_Angeles"/></td></tr>
	<tr><td><s:property value="%{getText('calendrier.couleur')}"/> : </td><td><s:textfield name="calendrier.couleur" cssClass="input" cssErrorStyle="background-color:#D53A3E" value="#2952A3"/></td></tr>
	<tr><td><s:property value="%{getText('calendrier.lieu')}"/> : </td><td><s:textfield name="calendrier.lieu" cssClass="input" cssErrorStyle="background-color:#D53A3E" value="Oakland"/></td></tr>
	<c:out value="${compte.idClient}"/>
	
	    <tr><td>Id prof:</td><td><select id="sexe" name="calendrier.professeur"><option value="<c:out value="${compte.idClient}"/>"><c:out value="${compte.idClient}"/></option>
	    
</select></td></tr>
	<tr><td colspan="2" align="center"><s:submit type="image" src="images/application/enregistrer.gif"></s:submit></td></tr>
	
	</table>
</s:form>

</body>
</html>