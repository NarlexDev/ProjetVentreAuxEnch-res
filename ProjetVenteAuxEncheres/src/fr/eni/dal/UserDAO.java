package fr.eni.dal;

import fr.eni.bo.User;
import fr.eni.controlers.BusinessException;

public interface UserDAO {
	/**
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet businessException.
	 * @param avis
	 * @throws BusinessException
	 */
	public void insert(User user) throws BusinessException;
}
