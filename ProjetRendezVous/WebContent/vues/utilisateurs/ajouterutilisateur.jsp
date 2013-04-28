<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@page import="fr.rendezvous.actions.AjaxClientAction"%>
<%@ page import="java.io.*"  %> 
<!-- Entete de la page -->
<%@ include file="../outils/entete.jspf" %>
<head>
<sx:head/>
<title>Listing</title>
</head>
<script>
function show_details() {
	var status="test";
dojo.event.topic.publish("show_detail");
}
</script>
<body>


<p  class="titreformulaire">Cr&eacute;ation d'un compte client<p>
<% AjaxClientAction ajcl=new AjaxClientAction() ;
int id=0;
		if(ajcl.getLst()=="Etudiant"){
				 id=0;
		}%>
		<s:if test="%{lstList1.get(0).equals('Etudiant')}">
<s:form  action="validerAjouter_Client" id="frm_demo" name="frm_demo" value="" theme="simple">
		
<table cellpadding="5" cellspacing="0" class="formulaire">
<tr>
<td>Status<s:select list="lstList1" name="lst"
onchange="javascript:show_details();return false;" ></s:select>
</td>
<br>
<br>
<td><s:url id="d_url" action="AjaxClientAction" /> <sx:div id="details"  href="%{d_url}" listenTopics="show_detail" formId="frm_demo" showLoadingText=""></sx:div>

</tr>
</table>
<br>
<br>


<table cellpadding="5" cellspacing="0" class="formulaire">
	
	<tr><td colspan="2" class="titreformulaire">
</select></td></tr>
	    <tr><td>Sexe:</td><td><select id="sexe" name="client.sexe"><option value="<c:out value="${calendrier.titre}"/>"></option>
  
    <option value="M">M</option> 
    <option value="F">F</option> </select></td></tr>
	<tr><td><s:property value="%{getText('client.nom')}"/> : </td><td><s:textfield key="client.nom" cssClass="input" value="Diop" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.prenom')}"/> : </td><td><s:textfield key="client.prenom" cssClass="input" value="Pape" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.mail')}"/> : </td><td><s:textfield key="client.mail" cssClass="input" value="diopref@gmail.com" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.telephone')}"/> : </td><td><s:textfield key="client.telephone" cssClass="input" value="0619462854" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.adresse')}"/> : </td><td><s:textfield key="client.adresse" cssClass="input" value="94 bvd de l'embouchure" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.codePostal')}"/> : </td><td><s:textfield key="client.codePostal" cssClass="input" value="31200" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.ville')}"/> : </td><td><s:textfield key="client.ville" cssClass="input" value="Toulouse" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.pays')}"/> : </td><td><s:textfield key="client.pays" cssClass="input" value="France" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.dateNaissance')}"/> : </td><td><sx:datetimepicker name="client.dateNaissance"  cssClass="input" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.identifiant')}"/> : </td><td><s:textfield key="client.identifiant" cssClass="input" value="diopref" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.motDePasse')}"/> : </td><td><s:password key="client.motDePasse" cssClass="input" value="diop2011" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.confirmationMotDePasse')}"/> : </td><td><s:password key="client.confirmationMotDePasse" cssClass="input" value="diop2011" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	
	<tr><td colspan="2" align="center"><s:submit type="image" src="images/application/enregistrer.gif"></s:submit></td></tr>
	
	</table>
</s:form>
</s:if>
<s:if test="%{lstList1.get(21).equals('Professeur')}">
<s:form  action="validerAjouter2_Client" theme="simple">
<table cellpadding="5" cellspacing="0" class="formulaire">
	
	<tr><td colspan="2" class="titreformulaire">
</select></td></tr>
	    <tr><td>Sexe:</td><td><select id="sexe" name="client.sexe"><option value=""></option>
  
    <option value="M">M</option> 
    <option value="F">F</option> </select></td></tr>
	<tr><td><s:property value="%{getText('client.nom')}"/> : </td><td><s:textfield key="client.nom" cssClass="input" value="Diop" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.prenom')}"/> : </td><td><s:textfield key="client.prenom" cssClass="input" value="Pape" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.mail')}"/> : </td><td><s:textfield key="client.mail" cssClass="input" value="diopref@gmail.com" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.telephone')}"/> : </td><td><s:textfield key="client.telephone" cssClass="input" value="0619462854" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.adresse')}"/> : </td><td><s:textfield key="client.adresse" cssClass="input" value="94 bvd de l'embouchure" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.codePostal')}"/> : </td><td><s:textfield key="client.codePostal" cssClass="input" value="31200" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.ville')}"/> : </td><td><s:textfield key="client.ville" cssClass="input" value="Toulouse" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.pays')}"/> : </td><td><s:textfield key="client.pays" cssClass="input" value="France" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.dateNaissance')}"/> : </td><td><sx:datetimepicker name="client.dateNaissance" value="02/01/1986" cssClass="input" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.identifiant')}"/> : </td><td><s:textfield key="client.identifiant" cssClass="input" value="diopref" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.motDePasse')}"/> : </td><td><s:password key="client.motDePasse" cssClass="input" value="diop2011" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	<tr><td><s:property value="%{getText('client.confirmationMotDePasse')}"/> : </td><td><s:password key="client.confirmationMotDePasse" cssClass="input" value="diop2011" cssErrorStyle="background-color:#D53A3E"/></td></tr>
	
	
	<tr><td colspan="2" align="center"><s:submit type="image" src="images/application/enregistrer.gif"></s:submit></td></tr>
	
	</table>
</s:form>
</s:if>
</body>
</html>