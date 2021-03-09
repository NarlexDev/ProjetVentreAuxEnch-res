package fr.eni.bll;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.eni.bo.Utilisateur;
import fr.eni.controlers.BusinessException;
import fr.eni.dal.DAOFactory;
import fr.eni.dal.UtilisateurDAO;

public class UtilisateurManager {
	
	public void modificationUtilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse, String motDePasseBis, int credit, int administrateur) throws BusinessException {
		BusinessException exception = new BusinessException();
		Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville,
				motDePasse, motDePasseBis, credit, administrateur);

		validerPseudo(pseudo, exception);
		validermotDePasse(motDePasse, motDePasseBis, exception);
		if (!exception.hasErreurs()) {
			DAOFactory.getUtilisateurDAO().modificationUtilisateur(0, utilisateur);
		}

		if (exception.hasErreurs()) {
			throw exception;
		}

	}

	public boolean connexion(String pseudo, String email, String motDePasse) throws BusinessException {
		BusinessException exception = new BusinessException();
		Utilisateur utilisateur = new Utilisateur(pseudo, email, motDePasse);

		// recuperation de la liste d'utilisateurs
		List<Utilisateur> liste = new ArrayList<Utilisateur>();
		UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
		liste = utilisateurDAO.selectTous();
		System.out.println(liste);

		if (liste.contains(utilisateur)) {
			return true;
		} else {
			exception.ajouterErreur(CodesErreurBLL.RULE_AUTHENTIFICATION);
			throw exception;
		}
	}

	public int ajouter(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse, String motDePasseBis, int credit, int administrateur)
			throws BusinessException {
		int noUtilisateur = 0;
		BusinessException exception = new BusinessException();
		Utilisateur utilisateur = new Utilisateur(noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville,
				motDePasse, credit, administrateur);

		validerPseudo(pseudo, exception);
		validermotDePasse(motDePasse, motDePasseBis, exception);
		if (!exception.hasErreurs()) {
			noUtilisateur = DAOFactory.getUtilisateurDAO().insert(utilisateur);
		}

		if (exception.hasErreurs()) {
			throw exception;
		}

		return noUtilisateur;
	}

	private void validerPseudo(String pseudo, BusinessException exception) {

		// Regex to check valid username.
		String regex = "^[A-Za-z]\\w{5,29}$";
		// Compile the ReGex
		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(pseudo);

		if (!m.matches()) {
			exception.ajouterErreur(CodesErreurBLL.RULE_USERNAME_ERREUR);
		}

	}

	private void validermotDePasse(String motDePasse, String motDePasseBis, BusinessException exception) {
		if (!(motDePasse.equals(motDePasseBis))) {
			exception.ajouterErreur(CodesErreurBLL.RULE_PASSWORD_AND_CONFIRMATION_ERREUR);
		}
	}
}
