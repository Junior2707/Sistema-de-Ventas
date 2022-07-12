package SistemaVentas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VentasDAO {
	int r;
	PreparedStatement ps;
	ResultSet rs;
	Connection con;
	
	conectar acceso = new conectar();
	DatosVentas DS =  new DatosVentas();
	
	public void insertar(int id,String nombre, int cantidad, int precio, int total) {
		String sql = "insert into ventas(id,nombre,cantidad,precio, total)values(?,?,?,?,?)";
		try {
			con = acceso.Conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2,nombre);
			ps.setInt(3,cantidad);
			ps.setInt(4,precio);
			ps.setInt(5,total);
			ps.executeUpdate();
			con = acceso.desconectar();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
