<%@page import="fr.eni.controlers.LecteurMessage"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inscription</title>
</head>
<body>
		<header>
		<nav>
			<ul>
				<li><a href="accueil">Accueil</a></li>
				<li><a href="inscription">Inscription</a></li>
			</ul>
		</nav>
	</header>
	
	<c:if test="${fn:length(listeCodesErreur) > 0}">
			<p style="color:red;">Erreur, l'inscription a echoué :</p>
			<c:forEach items="${ listeCodesErreur }" var="messageErreur">
				${LecteurMessage.getMessageErreur(messageErreur)} <br>
				
				
			</c:forEach>
	</c:if>
	
	<c:if test="${user != null}">
	Inscription realisée avec succes !
	</c:if>
	<form action="inscription" method="POST">
		<label for="username">Username :</label>
		<input type="text" id="iDusername" name="username" /><br/>
		<label for="mail">Mail :</label>
		
		<input type="text" id="mail" name="mail"/><br/>
		<label for="username">Password :</label>
		<input type="text" id="password" name="password"/><br/>
		<label for="username">Confirmation :</label>
		<input type="text" id="confirmation" name="confirmation"/><br/>
		<input type="submit" value="s'inscrire"/>
	</form>
	
</body>
</html>