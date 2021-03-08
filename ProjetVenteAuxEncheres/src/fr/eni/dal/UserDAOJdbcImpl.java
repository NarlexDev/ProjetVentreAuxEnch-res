package fr.eni.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.eni.bll.CodesErreurBLL;
import fr.eni.bo.User;
import fr.eni.controlers.BusinessException;

public class UserDAOJdbcImpl implements UserDAO {
	
	
	private static final String INSERT="INSERT INTO Users(username, mail, motDePasse) VALUES(?,?,?);";

	public void insert(User user) throws BusinessException {
		try {
			// 1 - Connection � la BDD
			Connection cnx = JDBCTools.getConnexion();
			// 2 - Pr�paration de la requete
			PreparedStatement pstmt = cnx.prepareStatement(INSERT);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getMail());
			pstmt.setString(3, user.getPassword());
		//	pstmt.setString(4, user.getConfirmation());
			// 3 - Execution
			pstmt.executeUpdate();
			// 4 - Traitement des donn�es
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if(e.getMessage().contains("CK_UNIQUE_USERNAME_AND_MAIL"))
			{
				businessException.ajouterErreur(CodesErreurBLL.INSERT_EXISTANT);
			}
			throw businessException;
		}
		
	}

}

