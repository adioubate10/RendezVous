<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="<s:url value="styles.css"/>" media="all" />
		<title>Formulaire de login</title>
	</head>
	<body>
		<s:form action="identificationUtilisateur" method="post" theme="simple"
			cssClass="formulaireLogin">
			</s:form>
			<s:if test="#session.authentification = 'true'">
				<h3>Vous êtes identifié : <span>
				<s:property value="#session.nomUtilisateur" /></span></h3>
			</s:if>
	</body>
</html>


