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
		 public void init(){
			
			 
			 try{
				 Class.forName("oracle.jdbc.driver.OracleDriver");
				 cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			 }


			 catch(Exception e){
				 e.printStackTrace();
			 }
		 }
	
      protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		  String ffname=req.getParameter("uid");
          String mmname=req.getParameter("mid");
          String llname=req.getParameter("lid");
          String genders=req.getParameter("gender");
		  int phnoe=Integer.parseInt("phn");


          PrintWriter out=res.getWriter();
        try {  
		  PreparedStatement ps=cn.prepareStatement("insert into UserTable values(?,?,?,?,?)");
		

		  ps.setString(1,ffname);
		  ps.setString(2,mmname);
          ps.setString(3,llname);
          ps.setString(4,genders);
          ps.setInt(5,phnoe);
		  ps.executeUpdate();
		  out.println("Data Inserted");
	  }
       

	    catch(Exception e){
				 out.println("Error in Registering User");
			 }
		 }
}
