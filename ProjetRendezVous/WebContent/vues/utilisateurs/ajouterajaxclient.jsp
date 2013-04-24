<%@ taglib prefix="s" uri="/struts-tags"%>

<s:if test="lst == 'Etudiant'">

<br>&nbsp;<s:property  value="txtnumeroEtudiant"/> : &nbsp; &nbsp;<s:textfield name="etudiant.numeroEtudiant" value="20110929" cssClass="input" cssErrorStyle="background-color:#D53A3E"/>
<br> &nbsp;  <s:property  value="txtserviceSocial"/> :&nbsp; <s:textfield name="etudiant.serviceSocial" value="s1" cssClass="input" cssErrorStyle="background-color:#D53A3E"/>	
<br><br>&nbsp; <s:property  value="txtoption"/> :&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp; <s:textfield name="etudiant.option" value="DL" cssClass="input" cssErrorStyle="background-color:#D53A3E"/>
<br><br>&nbsp; <s:property  value="txtniveau"/> : &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;<s:textfield name="etudiant.niveau" value="M1" cssClass="input" cssErrorStyle="background-color:#D53A3E"/>

</s:if> 

<s:if test="lst=='Professeur'">

<table>
<tr><td>&nbsp;<s:property  value="txtgrade" /> : &nbsp; &nbsp;<s:textfield name="professeur.grade" value="Maitre Conferencier" cssClass="input" cssErrorStyle="background-color:#D53A3E"/></td>
</tr><tr><td> &nbsp;  <s:property  value="txttelfixe"/> :&nbsp; <s:textfield name="professeur.telFixe" value="0512457845" cssClass="input" cssErrorStyle="background-color:#D53A3E"/>	</td>
</tr><tr><td>&nbsp; <s:property  value="txtspecialite"/> :&nbsp; &nbsp;&nbsp; &nbsp; <s:textfield name="professeur.specialite" value="DLC" cssClass="input" cssErrorStyle="background-color:#D53A3E"/></td>
</tr><tr><td>&nbsp; <s:property  value="txtspecialitedescrip"/> : <s:textfield name="professeur.specialiteDesc" value="Developpememt Logiciel Critique" cssClass="input" cssErrorStyle="background-color:#D53A3E"/>
</td>
</tr></table>

</s:if>
