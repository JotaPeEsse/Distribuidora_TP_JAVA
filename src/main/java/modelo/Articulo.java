package modelo;

import modelo.Tipo_Articulo;

public class Articulo {
	
	private int id;
	private String nombre;
	private Tipo_Articulo ta;
	private String stock;
	private String precio;
	
	public Articulo() {
		
	}
	
	
	public Articulo(int id, String nombre, String stock, String precio, Tipo_Articulo ta) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.stock = stock;
		this.precio = precio;
		this.ta = ta;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
		
	
	}
	
	public Tipo_Articulo getTa() {
		return ta;
	}
	public void setTa(Tipo_Articulo ta) {
		this.ta = ta;
	}

}
