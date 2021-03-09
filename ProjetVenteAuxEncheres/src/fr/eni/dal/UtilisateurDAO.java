package fr.eni.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.bll.CodesErreurBLL;
import fr.eni.bo.Utilisateur;
import fr.eni.controlers.BusinessException;

public class UtilisateurDAO {
	
	
	private static final String INSERT = "INSERT INTO UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit, administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?);";

	public void insert(Utilisateur utilisateur) throws BusinessException {
		try {
			// 1 - Connection � la BDD
			Connection cnx = ConnectionProvider.getConnection();
			// 2 - Pr�paration de la requete
			PreparedStatement pstmt = cnx.prepareStatement(INSERT);
	        pstmt.setString(1, utilisateur.getPseudo());
	        pstmt.setString(2, utilisateur.getNom());
	        pstmt.setString(3, utilisateur.getPrenom());
	        pstmt.setString(4, utilisateur.getEmail());
	        pstmt.setString(5, utilisateur.getTelephone());
	        pstmt.setString(6, utilisateur.getRue());
	        pstmt.setString(7, utilisateur.getCodePostal());
	        pstmt.setString(8, utilisateur.getVille());
	        pstmt.setString(9, utilisateur.getMotDePasse());
	        pstmt.setInt(10, 0);
	        pstmt.setInt(11, 0);
		//	pstmt.setString(4, utilisateur.getConfirmation());
			// 3 - Execution
			pstmt.executeUpdate();
			// 4 - Traitement des donn�es
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if(e.getMessage().contains("UNIQUE_PSEUDO_AND_EMAIL"))
			{
				businessException.ajouterErreur(CodesErreurBLL.INSERT_EXISTANT);
			}
			throw businessException;
		}
		
	}

	public List<Utilisateur> selectTous() {
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement("SELECT * From Utilisateurs;");
			ResultSet rs = null;
			rs = pstmt.executeQuery();
			Utilisateur utilisateur = null;
			List<Utilisateur> liste = new ArrayList<Utilisateur>();
			while (rs.next()) {
				utilisateur = new Utilisateur(rs.getInt("noUtilisateur"), 
						rs.getString("pseudo"), 
						rs.getString("nom"), 
						rs.getString("prenom"), 
						rs.getString("email"), 
						rs.getString("telephone"), 
						rs.getString("rue"), 
						rs.getString("codePostal"), 
						rs.getString("ville"), 
						rs.getString("motDePasse"), 
						rs.getInt("credit"), 
						rs.getInt("administrateur"));
				liste.add(utilisateur);
			}
			cnx.close();
			return liste;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

