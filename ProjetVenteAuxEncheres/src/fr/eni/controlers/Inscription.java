package fr.eni.controlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.bll.UserManager;
import fr.eni.bll.UtilisateurManager;
import fr.eni.bo.User;
import fr.eni.ecole.login.bo.Utilisateur;
import fr.eni.ecole.login.dal.UtilisateurDAO;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

//		String username;
//		String mail;
//		String confirmation;
//		String password;
//		
//		try 
//		{
//			username = request.getParameter("username");
//			mail = request.getParameter("mail");
//			confirmation = request.getParameter("confirmation");
//			password = request.getParameter("password");
//			
//			UserManager userManager = new UserManager();
//			User user =  userManager.ajouter(username, mail, password, confirmation);
//			request.setAttribute("user", user);
//		}
//		catch (BusinessException e) {
//			request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
//		}
//		request.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
		
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String motDePasse = request.getParameter("motDePasse");
		String motDePasseBis = request.getParameter("motDePasseBis");
		//int credit = Integer.parseInt(request.getParameter("credit"));
		int credit = 0;
		int administrateur = 0;
		//int administrateur = Integer.parseInt(request.getParameter("administrateur"));
		
		//stocker l'utilisateur dans la session
		request.getSession().setAttribute("pseudo", pseudo);
		request.getSession().setAttribute("nom", nom);
		request.getSession().setAttribute("prenom", prenom);
		request.getSession().setAttribute("email", email);
		request.getSession().setAttribute("telephone", telephone);
		request.getSession().setAttribute("rue", rue);
		request.getSession().setAttribute("codePostal", codePostal);
		request.getSession().setAttribute("ville", ville);
		request.getSession().setAttribute("motDePasse", motDePasse);
				
		UtilisateurManager utilisateurManager = new UtilisateurManager(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit, administrateur);
		System.out.println(utilisateurManager);
		utilisateurManager.insert(utilisateurManager);
		
		//IL FAUT CREER LA CLASSE UtilisateurManager
		
		//redirection vers la page de connexion
		request.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
	}
}

