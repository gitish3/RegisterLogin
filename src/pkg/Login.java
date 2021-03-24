package pkg;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String uemail=request.getParameter("uemail");
	    String upass=request.getParameter("upass");
	    response.setContentType("text/html");
	    Connection connection=ConnectionProvider.getConn();
	    
	     
		try {
			PreparedStatement ps = connection.prepareStatement("select * from login where email=? and pass=?");
		ps.setString(1,uemail);
		ps.setString(2,upass);
	    ResultSet rs=ps.executeQuery();
	    if(rs.next())
	    {
	    	RequestDispatcher rd=request.getRequestDispatcher("Welcome.html");
	    	rd.forward(request,response);
	    }
	    else
	    {
	    	RequestDispatcher rd=request.getRequestDispatcher("index.html");
	    	
	    	response.getWriter().println("<h1>INVALID USER</h1>");
	    	rd.include(request,response);
	    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
