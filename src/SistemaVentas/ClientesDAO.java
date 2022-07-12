package SistemaVentas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class ClientesDAO {
	int r;
	PreparedStatement ps;
	ResultSet rs;
	Connection con;
	
	conectar acceso = new conectar();
	DatosSucursales DS =  new DatosSucursales();
	
	public List listarUsuario() {

		String sql = "select * from sucursales";
		List<DatosSucursales> listaprod = new ArrayList<>();
		try {
			con = acceso.Conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				DatosSucursales s = new DatosSucursales();
				s.setCodigo(rs.getInt(1));
				s.setNombre(rs.getString(2));
				s.setDireccion(rs.getString(3));
				s.setCorreo(rs.getString(4));
				s.setTelefono(rs.getInt(5));
				listaprod.add(s);
				con = acceso.desconectar();
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return listaprod;
	}
	
	public void delete(int id) {
		String sql = "delete from sucursales where codigo=?";
		try {
			con = acceso.Conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			con = acceso.desconectar();
		}catch(Exception e) {
			
		}
	}
	
	public void modificar(int codigo,String nombre, String direccion, String correo, int telefono) {
	
		String sql = "update sucursales set nombre=?,direccion=?,correo=?,telefono=? where codigo=?";
		try {
			con = acceso.Conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1,nombre);
			ps.setString(2,direccion);
			ps.setString(3,correo);
			ps.setInt(4,telefono);
			ps.setInt(5,codigo);
			
			ps.executeUpdate();
			con = acceso.desconectar();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	public void insertar(int codigo,String nombre, String direccion, String correo, int telefono) {
		String sql = "insert into sucursales(codigo,nombre,direccion,correo,telefono)values(?,?,?,?,?)";
		try {
			
			con = acceso.Conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, codigo);
			ps.setString(2,nombre);
			ps.setString(3,direccion);
			ps.setString(4,correo);
			ps.setInt(5,telefono);
			ps.executeUpdate();
			con = acceso.desconectar();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
}
