package cntr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmployeeService;

/**
 * Servlet implementation class add
 */
@WebServlet("/add")
public class add extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public RequestDispatcher rd;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adm= request.getParameter("r1");
		if(adm==null)
			adm="false";
		boolean admin=Boolean.parseBoolean(adm);
		String firstName=(String)request.getParameter("t3");
		String secondName=(String)request.getParameter("t4");
		int Salary=Integer.parseInt((String)request.getParameter("t5").trim());
		String uName=(String)request.getParameter("t6");
		String pass=(String)request.getParameter("t7");
		//EmployeeService add=new EmployeeService();
		EmployeeService.addData(admin,firstName,secondName,Salary,uName,pass);
		response.sendRedirect("home.jsp");
	}
}
