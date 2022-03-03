package database;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession(false);
    	if(session != null) {
    		session.invalidate();
    		response.sendRedirect("login.jsp");
    	}
    }
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String customerId = request.getParameter("customerId");
		String password = request.getParameter("customerPassword");
		
		HttpSession session = request.getSession(true);
		LoginBean lb = (LoginBean) session.getAttribute("login");
		if(lb == null) {
			lb = new LoginBean();
			session.setAttribute("login", lb);
		}
		
		if(lb.authenticate(customerId, password)) {
			response.sendRedirect("order.jsp");
		}else {
			response.sendRedirect("login.jsp?failed=true");
		}
	}

}
