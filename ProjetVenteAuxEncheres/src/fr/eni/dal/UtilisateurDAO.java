package fr.eni.dal;

import fr.eni.bo.Utilisateur;
import fr.eni.controlers.BusinessException;

public interface UtilisateurDAO {
	/**
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet businessException.
	 * @param avis
	 * @throws BusinessException
	 */
	public void insert(Utilisateur utilisateur) throws BusinessException;
}
