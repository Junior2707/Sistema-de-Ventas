package SistemaVentas;

public class DatosVendedores {
	private int codigo;
	private String nombre;
	private int caja;
	private int ventas;
	private String genero;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	//
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	//
	public int getCaja() {
		return caja;
	}
	public void setCaja(int caja) {
		this.caja = caja;
	}
	//
	public int getVentas() {
		return ventas;
	}
	public void setVentas(int ventas) {
		this.ventas =ventas;
	}
	//
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
}
