package examenIndumentaria;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConexion {
	public static void main(String[] args) {
		Conexion conexion= new Conexion();
		Connection cn =null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM articulos");			
			while(rs.next()) {
				int id = rs.getInt(1);
				String categoria = rs.getString(2);
				String descripcion = rs.getString(3);
				int precio = rs.getInt(4);
				int stock = rs.getInt(5);
				int stockMinimo = rs.getInt(6);
				int stockMaximo = rs.getInt(7);
				int costo = rs.getInt(8);
				
				System.out.println(id + "-" + categoria+ "-" +descripcion+ "-" +precio+ "-" +stock+ "-" + stockMinimo + "-" +stockMaximo+ "-" +costo);				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
