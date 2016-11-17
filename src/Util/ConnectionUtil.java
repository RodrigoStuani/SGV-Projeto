package Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {

	private static Connection con;
	
	public static Connection getConnection(){
		try{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/SistemasDeVendas";
		con = DriverManager.getConnection(url,"root","root");
		return con;
		}catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return null;
	}
}
