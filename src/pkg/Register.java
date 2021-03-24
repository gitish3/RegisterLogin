

package pkg;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pkg.ConnectionProvider;

/**
 * Servlet implementation class Rejister
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String upass=request.getParameter("upass");
		String uemail=request.getParameter("uemail");
		String uphone=request.getParameter("uphone");
		//System.out.println(uname + " " + upass + " " + uemail + " " + uphone);
		//response.getWriter().println(ConnectionProvider.getConn());
		Connection connection=ConnectionProvider.getConn();
		try {
			java.sql.PreparedStatement ps = connection.prepareStatement("insert into login values(?,?,?,?)");
			ps.setString(1,uname);
			ps.setString(2,uemail);
			ps.setString(3,upass);
			ps.setString(4,uphone);
			int i=ps.executeUpdate();
			if(i>0){
				RequestDispatcher rd=request.getRequestDispatcher("Welcome.html");
		    	rd.forward(request,response);
			}
				//response.getWriter().println("Data inserted in database");
			else{
				RequestDispatcher rd=request.getRequestDispatcher("index.html");
		    	response.getWriter().println("Invalid user");
		    	rd.include(request,response);
			}
				//response.getWriter().println("Data not inserted in database");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
