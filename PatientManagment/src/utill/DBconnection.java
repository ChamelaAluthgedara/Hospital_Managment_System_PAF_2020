package utill;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
	
	//Method for the connect to DB	
		public static Connection connection() {
			
			Connection con = null ;
					
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						
						//DB Connection
						con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/patient", "root" , "pasindupasi1998");
					}
					catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					return con;
		}

}
