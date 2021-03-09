<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
</head>
<body>
<body>
	<header>
		<nav>
			<ul>
				<li><a href="index">Accueil</a></li>
				<li><a href="connexion">Connexion</a></li>
				<li><a href="inscription">Inscription</a></li>
			</ul>
		</nav>
	</header>
	<h1>Formulaire de Connexion</h1>
	<c:if test="${succesInscription == true }">L'inscription à été réalisé avec succès</c:if>

	<form action="connexion" method="post">
		<label for="pseudo">Pseudo :</label> <input type="text" id="pseudo" name="pseudo"><br> 
			
		<label for="motDePasse">Mot de passe :</label> <input type="password" id="motDePasse" name="motDePasse"><br>

		<input type="submit" value="se connecter">
	</form>
</body>
</html>