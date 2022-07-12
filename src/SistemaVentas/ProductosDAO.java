package SistemaVentas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ProductosDAO {
	
	int r;
	PreparedStatement ps;
	ResultSet rs;
	Connection con;
	
	conectar acceso = new conectar();
	DatosProductos DS =  new DatosProductos();
	
	public List listarUsuario() {
		String sql = "select * from productos";
		List<DatosProductos> listaprod = new ArrayList<>();
		try {
			con = acceso.Conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				DatosProductos s = new DatosProductos();
				s.setCodigo(rs.getInt(1));
				s.setNombre(rs.getString(2));
				s.setDescripcion(rs.getString(3));
				s.setCantidad(rs.getInt(4));
				s.setPrecio(rs.getInt(5));
				listaprod.add(s);
				con = acceso.desconectar();
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return listaprod;
	}

	public void insertar(int codigo,String nombre, String descripcion, int cantidad, int precio) {
		String sql = "insert into productos(codigo,nombre,descripcion,cantidad,precio)values(?,?,?,?,?)";
		try {
			con = acceso.Conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, codigo);
			ps.setString(2,nombre);
			ps.setString(3,descripcion);
			ps.setInt(4,cantidad);
			ps.setInt(5,precio);
			ps.executeUpdate();
			con = acceso.desconectar();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	public void modificar(int codigo,String nombre, String descripcion, int cantidad, int precio) {
		
		String sql = "update productos set nombre=?,descripcion=?,cantidad=?,precio=? where codigo=?";
		try {
			con = acceso.Conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1,nombre);
			ps.setString(2,descripcion);
			ps.setInt(3,cantidad);
			ps.setInt(4,precio);
			ps.setInt(5,codigo);
			ps.executeUpdate();
			con = acceso.desconectar();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	public void delete(int id) {
		String sql = "delete from productos where codigo=?";
		try {
			con = acceso.Conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			con = acceso.desconectar();
		}catch(Exception e) {
			
		}
	}
}
