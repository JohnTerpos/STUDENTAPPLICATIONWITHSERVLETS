package mypackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='index.html'>Add New Student</a>");  
        out.println("<h1>Students List</h1>");
        List<Students> list=StudentsDao.getAllStudents();
        out.print("<table border='1' width='100%'");
        out.print("<tr><th>firstname</th><th>lastname</th><th>department</th><th>semester</th><th>passed_lessons</th><th>Edit</th><th>Delete</th></tr>");
        for(Students s: list)
        {
          out.print("<tr><td>" +s.getFirstname() +"</td><td>" +s.getLastname() +"</td><td>" +s.getDepartment()
          +"</td><td>" +s.getSemester() +"</td><td>" +s.getPassed_lessons() +"</td><td><a href='EditServlet?lastname="
          +s.getLastname()+"'>edit</a></td><td><a href='DeleteServlet?lastname="
          +s.getLastname() +"'>delete</a></td></tr>");
        }
        out.print("</table>");  
          
        out.close(); 
    }

}
