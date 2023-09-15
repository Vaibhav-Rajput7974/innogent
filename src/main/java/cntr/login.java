package cntr;
import java.util.ArrayList;
import java.util.List;

import entity.Employee;
import service.EmployeeService;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RequestDispatcher rd;
    public EmployeeService es;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest 	`, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession(false); // Pass false to prevent creating a new session if it doesn't exist

			if (session != null) {
				// Invalidate (delete) the session
				session.invalidate();
			}
			rd=request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uName=(String)request.getParameter("username");
		String uPass=(String)request.getParameter("password");
		String operation=(String)request.getParameter("submit");
		System.out.println(uName+" "+uPass+" "+operation);
		es=new EmployeeService();
		if(operation.equals("login")) {
			Employee emp=es.login(uName,uPass);
			//System.out.println(emp);
			if(emp != null) {
				HttpSession session=request.getSession();
				session.setAttribute("emp", emp);
				rd=request.getRequestDispatcher("home.jsp");
				rd.include(request, response);
			}
			else {
				request.setAttribute("msg","Invalid id Password");
				rd=request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
			}
		}
		//doGet(request, response);
	}

}
