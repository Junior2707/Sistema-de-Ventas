package SistemaVentas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CliDAO {
	int r;
	PreparedStatement ps;
	ResultSet rs;
	Connection con;
	
	conectar acceso = new conectar();
	DatosCli DS =  new DatosCli();
	
	public List listarUsuario() {
		String sql = "select * from clientes";
		List<DatosCli> listaprod = new ArrayList<>();
		try {
			con = acceso.Conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				DatosCli s = new DatosCli();
				s.setCodigo(rs.getInt(1));
				s.setNombre(rs.getString(2));
				s.setNit(rs.getInt(3));
				s.setCorreo(rs.getString(4));
				s.setGenero(rs.getString(5));
				listaprod.add(s);
				con = acceso.desconectar();
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return listaprod;
	}

	public void insertar(int codigo,String nombre, int nit, String correo, String genero) {
		String sql = "insert into clientes(codigo,nombre,nit,correo,genero)values(?,?,?,?,?)";
		try {
			con = acceso.Conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, codigo);
			ps.setString(2,nombre);
			ps.setInt(3,nit);
			ps.setString(4,correo);
			ps.setString(5,genero);
			ps.executeUpdate();
			con = acceso.desconectar();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	public void modificar(int codigo,String nombre, int nit,String correo, String genero) {
		
		String sql = "update clientes set nombre=?,nit=?,correo=?,genero=? where codigo=?";
		try {
			con = acceso.Conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1,nombre);
			ps.setInt(2,nit);
			ps.setString(3,correo);
			ps.setString(4,genero);
			ps.setInt(5,codigo);
			ps.executeUpdate();
			con = acceso.desconectar();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	public void delete(int id) {
		String sql = "delete from clientes where codigo=?";
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
