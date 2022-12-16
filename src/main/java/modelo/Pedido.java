package modelo;

import java.sql.Date;
import java.util.LinkedList;

public class Pedido {
	
	private int id_pedido;
	private Date fecha;
	private LinkedList<Articulo> articulos = new LinkedList<Articulo>();
	private Cliente cliente;
	private double total;
	private boolean condicion;
	
	public int getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public LinkedList<Articulo> getArticulos() {
		return articulos;
	}
	public void setArticulos(LinkedList<Articulo> articulos) {
		this.articulos = articulos;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public boolean isCondicion() {
		return condicion;
	}
	public void setCondicion(boolean condicion) {
		this.condicion = condicion;
	}
	
	

}
