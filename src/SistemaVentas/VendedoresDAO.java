package SistemaVentas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VendedoresDAO {
	int r;
	PreparedStatement ps;
	ResultSet rs;
	Connection con;
	
	conectar acceso = new conectar();
	DatosVendedores DS =  new DatosVendedores();
	
	public List listarUsuario() {
		String sql = "select * from vendedores";
		List<DatosVendedores> listaprod = new ArrayList<>();
		try {
			con = acceso.Conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				DatosVendedores s = new DatosVendedores();
				s.setCodigo(rs.getInt(1));
				s.setNombre(rs.getString(2));
				s.setCaja(rs.getInt(3));
				s.setVentas(rs.getInt(4));
				s.setGenero(rs.getString(5));
				listaprod.add(s);
				con = acceso.desconectar();
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return listaprod;
	}

	public void insertar(int codigo,String nombre, int caja, int ventas, String genero) {
		String sql = "insert into vendedores(codigo,nombre,caja,ventas,genero)values(?,?,?,?,?)";
		try {
			con = acceso.Conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, codigo);
			ps.setString(2,nombre);
			ps.setInt(3,caja);
			ps.setInt(4,ventas);
			ps.setString(5,genero);
			ps.executeUpdate();
			con = acceso.desconectar();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	public void modificar(int codigo,String nombre, int caja,int ventas, String genero) {
		
		String sql = "update vendedores set nombre=?,caja=?,ventas=?,genero=? where codigo=?";
		try {
			con = acceso.Conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1,nombre);
			ps.setInt(2,caja);
			ps.setInt(3,ventas);
			ps.setString(4,genero);
			ps.setInt(5,codigo);
			ps.executeUpdate();
			con = acceso.desconectar();
		}catch(Exception e) {
			System.out.println(e);
		}
}

	public void delete(int id) {
		String sql = "delete from vendedores where codigo=?";
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
