package cntr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Employee;
import service.EmployeeService;

/**
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmployeeService e1;
    public RequestDispatcher rd;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//e1=new EmployeeService();
		//e1.update();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adm= request.getParameter("r1");
		if(adm==null)
			adm="false";
		boolean admin=Boolean.parseBoolean(adm);
		int empId=Integer.parseInt((String)request.getParameter("t1"));
		String firstName=(String)request.getParameter("t2");
		String secondName=(String)request.getParameter("t3");
		int Salary=Integer.parseInt((String)request.getParameter("t4").trim());
		String uName=(String)request.getParameter("t5");
		String pass=(String)request.getParameter("t6");
		EmployeeService e=new EmployeeService();
		Employee change=e.update(empId);
		if(change != null) {
			change.setAdmin(admin);
			change.setEmpId(empId);
			change.setFirstName(firstName);
			change.setLastName(secondName);
			change.setSalary(Salary);
			change.setFirstName(uName);
			change.setPassword(pass);
			//System.out.println(change);
			rd=request.getRequestDispatcher("home.jsp");
			rd.include(request, response);
			
		}
		else {
			request.setAttribute("update", "No User With the id Exist");
			rd=request.getRequestDispatcher("update.jsp");
			rd.include(request, response);
		}
	}

}
