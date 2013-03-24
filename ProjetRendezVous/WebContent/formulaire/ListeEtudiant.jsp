<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">@import url(css/styles.css);</style>
<title><s:property value="%{getText('rendezvous.page.lister')}"></s:property>
</title>
</head>
<body>

<center>
<div>
	
	
	

	
		<table border="1" cellpadding="5" cellspacing="2">
			<tr bgcolor="#DEA254">
				<td><s:text name="rendezvous.form.identifiant"></s:text></td>
				<td><s:text name="rendezvous.form.pseudo"></s:text></td>
				<td><s:text name="rendezvous.form.email"></s:text></td>
				<td><s:text name="rendezvous.form.codepostal"></s:text></td>
				<td><s:text name="rendezvous.form.dateinscription"></s:text></td>
				<td><s:text name="rendezvous.form.iconesupp"></s:text></td>
				
				
				
			</tr>
				
				<tr>
					<td><s:property value="identifiant" /><br/>
					</td>
					<td><s:property value="est" /><br/>
					</td>
					<td><s:property value="etudiant.email" /><br/>
					</td>
					<td><s:property value="etudiant.adresse" /><br/>
					</td>
					<td><s:property value="etudiant.sexe" /><br/>
					</td>
					<td align="center"><a href="supprimer1_Developpeur?pseudo=${pseudo}">
						<img src="./images/supprimer.png" border="0"></a></td>
					
				</tr>
		
		</table>
	
</div>

<p></p>
<a href="saisir_Developpeur"><s:text name="rendezvous.lien.ajouter"/></a><br />
<a href="supprimer_Developpeur.action"><s:text name="rendezvous.lien.supprimer"/></a> <br/>
<a href="rechercher_Developpeur.action"><s:text name="rendezvous.lien.rechercher"/></a><br/>
<a href="demoajax_Developpeur.action"><s:text name="rendezvous.lien.ajaxdemo"/></a><br/>
<a href="deconnecter_Developpeur.action"><s:text name="rendezvous.lien.deconnecter"/></a>

<s:debug />
</center>


</body>
</html>