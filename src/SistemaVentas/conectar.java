package SistemaVentas;

import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class conectar {
	
	Connection con;
    String user = "root";
    String password = "";
    String url = "jdbc:mysql://localhost:3306/base_sistemaventas";
    Connection connection = null;
    
	 public Connection Conectar(){
	        try{
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	        	con = DriverManager.getConnection(url,user,password);
	        if (connection!=null){
	            //System.out.println("Conexión a base de datos");
	        }
	        }catch(SQLException ex){
	            System.out.println(ex.getMessage());
	        }catch(Exception ex){
	            System.out.println(ex.getMessage());
	        }
	        return con;
	    }
	    
	    public Connection getConnection(){
	        return connection;
	    }
	    
	    public Connection desconectar(){
	        try{
	            //System.out.println("Cerrando conexion");
	            connection.close();
	        }catch(Exception ex){}
			return con;
	    }

	   
}
