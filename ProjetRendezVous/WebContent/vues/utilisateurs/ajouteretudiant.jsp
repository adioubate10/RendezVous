<%@ taglib prefix="s" uri="/struts-tags"%>

<s:if test="txtnumeroEtudiant != null">

<br>&nbsp;<s:property  value="txtnumeroEtudiant"/> : &nbsp; &nbsp;<s:textfield name="etudiant.numeroEtudiant" cssClass="input" cssErrorStyle="background-color:#D53A3E"/>
<br> &nbsp;  <s:property  value="txtserviceSocial"/> :&nbsp; <s:textfield name="etudiant.serviceSocial" cssClass="input" cssErrorStyle="background-color:#D53A3E"/>	
<br><br>&nbsp; <s:property  value="txtoption"/> :&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp; <s:textfield name="etudiant.option" cssClass="input" cssErrorStyle="background-color:#D53A3E"/>
<br><br>&nbsp; <s:property  value="txtniveau"/> : &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;<s:textfield name="etudiant.niveau" cssClass="input" cssErrorStyle="background-color:#D53A3E"/>
</s:if> 
