<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!-- Entete de la page -->
<%@ include file="../outils/entete.jspf" %>
<head>
<sx:head/>
<title>Listing</title>
</head>
<script>
function show_details() {
dojo.event.topic.publish("show_detail");
}
</script>
<body>
<s:form action="validerAjouter_Client" id="frm_demo" name="frm_demo" method="post" theme="simple">
<p  class="titreformulaire">Cr&eacute;ation d'un compte client<p>

<table cellpadding="5" cellspacing="0" class="formulaire">
<tr>
<td>Status<s:select list="lstList1" name="lst"
onchange="javascript:show_details();return false;" ></s:select>
</td>
<br>
<br>
<td><s:url id="d_url" action="EtudiantAction" /> <sx:div id="details" href="%{d_url}" listenTopics="show_detail" formId="frm_demo" showLoadingText=""></sx:div>

</tr>
</table>
<br>
<br>
<table cellpadding="5" cellspacing="0" class="formulaire">
	
	   <tr><td>Sexe:</td><td><select id="sexe" name="etudiant.sexe">
  <option value=""></option>
  
    <option value="M">M</option> 
    <option value="F">F</option> 
</select></td></tr>
	 
	<tr><td><s:property value="%{getText('client.nom')}"/> : </td><td><s:textfield key="etudiant.nom" cssClass="input" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.prenom')}"/> : </td><td><s:textfield key="etudiant.prenom" cssClass="input" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.mail')}"/> : </td><td><s:textfield key="etudiant.mail" cssClass="input" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.telephone')}"/> : </td><td><s:textfield key="etudiant.telephone" cssClass="input" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.adresse')}"/> : </td><td><s:textfield key="etudiant.adresse" cssClass="input" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.codePostal')}"/> : </td><td><s:textfield key="etudiant.codePostal" cssClass="input" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.ville')}"/> : </td><td><s:textfield key="etudiant.ville" cssClass="input" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.pays')}"/> : </td><td><s:textfield key="etudiant.pays" cssClass="input" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.dateNaissance')}"/> : </td><td><s:textfield key="etudiant.dateNaissance" cssClass="input" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.identifiant')}"/> : </td><td><s:textfield key="etudiant.identifiant" cssClass="input" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.motDePasse')}"/> : </td><td><s:textfield key="etudiant.motDePasse" cssClass="input" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.confirmationMotDePasse')}"/> : </td><td><s:textfield key="etudiant.confirmationMotDePasse" cssClass="input" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td colspan="2" align="center"><s:submit type="image" src="images/application/enregistrer.gif"></s:submit></td></tr>
	
	
</table>
</s:form>
</body>
</html>