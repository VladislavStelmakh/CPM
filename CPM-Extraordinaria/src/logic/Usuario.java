package logic;

public class Usuario {

	public String DNI;
	public String nombre;
	public String apellidos;
	public String contraseña;
	
	public Usuario(String DNI, String nombre, String apellidos, String contraseña) {
		this.DNI = DNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.contraseña = contraseña;
	}
	
	private void setDNI(String dNI) {
		DNI = dNI;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	private void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	public String getDNI() {
		return DNI;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getContraseña() {
		return contraseña;
	}
	
}
