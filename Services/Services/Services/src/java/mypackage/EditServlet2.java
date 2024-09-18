package mypackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditServlet2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html");  
       PrintWriter out=response.getWriter();
       
       String lastname=request.getParameter("lastname");
       String firstname=request.getParameter("firstname");
       String department=request.getParameter("department");
       String ssemester=request.getParameter("semester");
       String spassedlessons=request.getParameter("passedlessons");
       int semester=Integer.parseInt(ssemester);
       int passedlessons=Integer.parseInt(spassedlessons);
       
       Students student=new Students();
       student.setFirstname(firstname);
       student.setLastname(lastname);
       student.setDepartment(department);
       student.setSemester(semester);
       student.setPassed_lessons(passedlessons);
       
        int status=StudentsDao.update(student);  
        if(status>0){  
            response.sendRedirect("ViewServlet");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();
    }

}
