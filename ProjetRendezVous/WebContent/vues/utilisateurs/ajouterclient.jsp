<!-- Entete de la page -->
<%@ include file="../outils/entete.jspf" %>
<head>
<script type="text/javascript">
function populate(s1,s2){
var s1 = document.getElementById(s1);
var s2 = document.getElementById(s2);
s2.innerHTML = "";
if(s1.value == "etudiant"){
var optionArray = ["|","diop|M","corvette|F"];
} else if(s1.value == "patient"){
	var optionArray = ["|","diop|M","corvette|F"];
} else if(s1.value == "professeur"){
	var optionArray = ["|","diop|M","corvette|F"];
}
for(var option in optionArray){
var pair = optionArray[option].split("|");
var newOption = document.createElement("option");
newOption.value = pair[0];
newOption.innerHTML = pair[1];
s2.options.add(newOption);
}
}
</script>
<script type="text/javascript">
function populate2(s1){
var s1 = document.getElementById(s1);

if(s1.value == "etudiant"){
var optionArray = ["|","diop|M","corvette|F"];
} else if(s1.value == "patient"){
	var optionArray = ["|","diop|M","corvette|F"];
} else if(s1.value == "professeur"){
	var optionArray = ["|","diop|M","corvette|F"];
}

}
</script>
</head>
<body>
	
	
	<center>
	<s:form action="validerAjouter_Client" method="post" theme="simple">
	<table cellpadding="5" cellspacing="0" class="formulaire">
	
	<tr><td colspan="2" class="titreformulaire">Cr&eacute;ation d'un compte client</td></tr>
	

	
	   <tr><td>Selectionner le status:</td><td><select id="slct1" name="slct1" onchange="populate2(this.id,'numero')">
  <option value=""></option>
  
    <option value="etudiant">Etudiant</option> 
    <option value="patient">Patient</option> 
    <option value="professeur">Professeur</option> 
    <option value="medecin">Medecin</option> 
</select></td></tr>
	    <tr><td>Selectionner le sexe:</td><td><select id="slct2" name="slct2"></select></td></tr>
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
	
	</table>	
	</s:form>
	</center>
</body>
<!-- Pieds de page -->
<%@ include file="../outils/piedpage.jspf" %>