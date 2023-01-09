package modelo;

public class Usuario {
	 
	private int id;
	private int documento;
	private String nombre;
	private String correo;
	private String password;
	private String rol;
	
	public Usuario() {}
	
	public Usuario(int id, int documento, String nombre, String correo, String password, String rol) {
		super();
		this.id = id;
		this.documento = documento;
		this.nombre = nombre;
		this.correo = correo;
		this.password = password;
		this.rol = rol;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDocumento() {
		return documento;
	}
	public void setDocumento(int documento) {
		this.documento = documento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	

	   

}
