package abs.com;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginForm extends HttpServlet{
         private Connection cn;
	
			
			
      protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
    	  try {
    	  Class.forName("oracle.jdbc.driver.OracleDriver");
		  cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		  String ffname=req.getParameter("uid");
          String mmname=req.getParameter("mid");
          String llname=req.getParameter("lid");
          String genders=req.getParameter("gender");
		  long phnoe=Long.parseLong(req.getParameter("phn"));


          PrintWriter out=res.getWriter();
        
		  PreparedStatement ps=cn.prepareStatement("insert into UserTable values(?,?,?,?,?)");
		

		  ps.setString(1,ffname);
		  ps.setString(2,mmname);
          ps.setString(3,llname);
          ps.setString(4,genders);
          ps.setLong(5,phnoe);
		  int re =  ps.executeUpdate();
		  if(re == 1) 
		  out.println("Data Inserted");
		  else
			  out.println("data not inserted");
	  }
       

	    catch(Exception e){
				 System.out.println("Exception thrown from try");
			 }
		 }
}
