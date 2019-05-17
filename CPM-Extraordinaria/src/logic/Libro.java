package logic;

public class Libro {
	
	public Long ISBN;
	public String titulo;
	public String editorial;
	public String autor;
	public String genero;
	public String resumen;
	public double precio;
	
	public Libro(Long ISBN, String titulo, String editorial, String autor, String genero, String resumen, double precio) {
		this.ISBN = ISBN;
		this.titulo = titulo;
		this.editorial = editorial;
		this.autor = autor;
		this.genero = genero;
		this.resumen = resumen;
		this.precio = precio;
	}
	
	private void setISBN(Long iSBN) {
		ISBN = iSBN;
	}
	private void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	private void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	private void setAutor(String autor) {
		this.autor = autor;
	}
	private void setGenero(String genero) {
		this.genero = genero;
	}
	private void setResumen(String resumen) {
		this.resumen = resumen;
	}
	private void setPrecio(double precio) {
		this.precio = precio;
	}
	public Long getISBN() {
		return ISBN;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getEditorial() {
		return editorial;
	}
	public String getAutor() {
		return autor;
	}
	public String getGenero() {
		return genero;
	}
	public String getResumen() {
		return resumen;
	}
	public double getPrecio() {
		return precio;
	}
	
	

}
