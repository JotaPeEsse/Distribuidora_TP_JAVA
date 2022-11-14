package modelo;

public class Tipo_Articulo {
	
	private int id;
	private String descripcion;
	
	public Tipo_Articulo() {}
	
	
	public Tipo_Articulo(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}


