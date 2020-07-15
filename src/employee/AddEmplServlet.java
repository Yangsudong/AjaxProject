package employee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddEmplServlet
 */
@WebServlet("/AddEmplServlet")
public class AddEmplServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
           
    public AddEmplServlet() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lastName = request.getParameter("last_name"); // signup.html의 name=last_name의 값을가져옴
		String email = request.getParameter("email");
		String hireDate = request.getParameter("hire_date");
		String jobID = request.getParameter("job_id");
		
		Employee emp = new Employee(email, hireDate, lastName, jobID);
		EmpDAO dao = new EmpDAO();
		dao.insertEmp(emp);
		
		request.getRequestDispatcher("employeeList.html").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
