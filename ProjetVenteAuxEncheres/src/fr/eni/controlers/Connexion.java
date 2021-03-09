package fr.eni.controlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.bll.UtilisateurManager;

/**
 * Servlet implementation class Index
 */
@WebServlet("/connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperation de la saisie de connexion
		String pseudo = request.getParameter("nom");
		String email = request.getParameter("email");
		String motDePasse = request.getParameter("motDePasse");
		
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		try {
			if (utilisateurManager.connexion(pseudo, email, motDePasse)) {
				System.out.println(utilisateurManager.connexion(pseudo, email, motDePasse));
				//connexion ouverte
				request.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
			} 
			
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
		}
		
		
		request.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
			
	}

}
