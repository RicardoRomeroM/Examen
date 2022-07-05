package examenIndumentaria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	//Creando atributo
	public static final String CONTROLADOR="com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/db_indumentaria";
	public static final String USUARIO = "root";
	public static final String CONTRASEÑA = "Curso123";
	
	static {
		try {
			Class.forName(CONTROLADOR);
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR  al cargar el controlador");
			e.printStackTrace();
		}
	}
			
	//creando un metodo donde se va a generar la conexion
	public Connection conectar() {
		Connection conexion = null;
		try {	
			conexion=DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
			System.out.println("Conexion OK");
		 
		}catch(SQLException e) {
			System.out.println("Error en la conexion");
			e.printStackTrace();
			
		}
		return conexion;
	}

}
