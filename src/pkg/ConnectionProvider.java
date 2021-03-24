package pkg;

import java.sql.Connection;
import java.sql.DriverManager;


public final class ConnectionProvider {
  
     private ConnectionProvider()
     {
    	 
     }
     static Connection connection=null;
     public static Connection getConn(){
    	 
    	
    	 try {
    		 if(connection==null)
    	    	{
    		 Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","gitish1577");
			return connection;
			
    	    	}
    		 else
    		 {
    			 return connection;
    		 }
    		 } catch (Exception e) {
			
			e.printStackTrace();
		}
    	return connection;
    	
    	 
     }
}
