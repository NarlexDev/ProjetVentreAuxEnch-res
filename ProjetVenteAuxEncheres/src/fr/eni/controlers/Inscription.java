package fr.eni.controlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.bll.UserManager;
import fr.eni.bo.User;

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

		String username;
		String mail;
		String confirmation;
		String password;
		
		try 
		{
			username = request.getParameter("username");
			mail = request.getParameter("mail");
			confirmation = request.getParameter("confirmation");
			password = request.getParameter("password");
			
			UserManager userManager = new UserManager();
			User user =  userManager.ajouter(username, mail, password, confirmation);
			request.setAttribute("user", user);
		}
		catch (BusinessException e) {
			request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
		}
		request.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
	}
}

