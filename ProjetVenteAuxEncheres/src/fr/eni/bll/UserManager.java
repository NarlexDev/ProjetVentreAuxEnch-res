package fr.eni.bll;

import fr.eni.bo.User;
import fr.eni.controlers.BusinessException;
import fr.eni.dal.UserDAO;
import fr.eni.dal.DAOFactory;

public class UserManager {
	
		public User ajouter(String username, String mail, String password, String confirmation) throws BusinessException
		{
			BusinessException exception = new BusinessException();
			User user = new User(username, mail, password, confirmation);
			
			this.validerPasswordConfirmation(password, confirmation, exception);
			this.validerPassword(password, exception);
			this.validerUsername(username, exception);
			this.validerMail(mail, exception);

			if(!exception.hasErreurs())
			{
				DAOFactory.getUserDAO().insert(user);
			}
			
			if(exception.hasErreurs())
			{
				throw exception;
			}
			
			return user;
		}

		private void validerPassword(String password, BusinessException exception) {
			if(password.length() < 4)
				exception.ajouterErreur(CodesErreurBLL.RULE_PASSWORD_ERREUR);
		}

		private void validerPasswordConfirmation(String password, String confirmation, BusinessException exception) {
			if(!(password.equals(confirmation)))
				{
					exception.ajouterErreur(CodesErreurBLL.RULE_PASSWORD_AND_CONFIRMATION_ERREUR);
				}
			
		}

		private void validerMail(String mail, BusinessException exception) {
			if(!(mail.endsWith(".com") || mail.endsWith(".bzh") || mail.endsWith(".fr")))
				exception.ajouterErreur(CodesErreurBLL.RULE_MAIL_ERREUR);
			
		}

		private void validerUsername(String username, BusinessException exception) {
			if(username.length() < 4)
				exception.ajouterErreur(CodesErreurBLL.RULE_USERNAME_ERREUR);
			
		}
		
		

}
