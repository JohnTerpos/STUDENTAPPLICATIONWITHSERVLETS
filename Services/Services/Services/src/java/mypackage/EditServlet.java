package mypackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Student</h1>");
        String lastname=request.getParameter("lastname");
        
        Students student=StudentsDao.getStudentbylastname(lastname);
        
        out.print("<form action='EditServlet2' method='post'>");  
        out.print("<table>"); 
        out.print("<tr><td>Firstname:</td><td><input type='text' name='firstname' value='" +student.getFirstname()+ "'/></td></tr>");
        out.print("<tr><td>Lastname:</td><td><input type='text' name='lastname' value='" +student.getLastname()+ "'/></td></tr>");
        out.print("<tr><td>Department:</td><td><input type='text' name='department' value='" +student.getDepartment()+ "'/></td></tr>");
        out.print("<tr><td>Semester:</td><td><input type='text' name='semester' value='" +student.getSemester()+ "'/></td></tr>");
        out.print("<tr><td>Passed Lessons:</td><td><input type='text' name='passedlessons' value='" +student.getPassed_lessons()+ "'/></td></tr>");
        
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();
    }
}
