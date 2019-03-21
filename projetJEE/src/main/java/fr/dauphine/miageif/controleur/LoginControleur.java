package fr.dauphine.miageif.controleur;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dauphine.miageif.config.Configuration;
import fr.dauphine.miageif.db.MysqlDB;

/**
 * Servlet implementation class LoginController
 */

public class LoginControleur extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Configuration cfg = new Configuration(); 
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println(username + " :: " + password);
		String page = "login.jsp";
		if (username.trim().length() >= 0 && username != null && password.trim().length() >= 0 && password != null) {
			MysqlDB db = new MysqlDB();
			try {
				System.out.println(cfg.dbAdminLogin);
				db.open(cfg.dbHost, cfg.dbPort, cfg.dbName, cfg.dbAdminLogin, cfg.dbAdminPwd);
				String req = "SELECT * FROM Utilisateur WHERE USER_NAME='" + username + "'";
				System.out.println(req);
				ResultSet resultUser = db.executeQuery(req);
				if(resultUser.next()) {
				System.out.println("yesss");
				System.out.println(resultUser.getString(2));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

//Imetier loginService = new ImetierImplmentation();
			// boolean flag = loginService.login(username, password);

			request.getRequestDispatcher(page).include(request, response);
		}

	}
}