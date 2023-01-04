package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import config.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import config.Conexion;

public class ArticuloDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Conexion cn = new Conexion();
	int r;

	public List Listar() {
		String consulta = "SELECT * FROM articulo";
		List<Articulo> lista = new ArrayList();
		try {
			con = cn.Conexion();
			ps = con.prepareStatement(consulta);
			rs = ps.executeQuery();
			while (rs.next()) {
				Articulo articulo = new Articulo();
				Tipo_Articulo ta = new Tipo_Articulo();
				TipoArticuloDAO tDAO = new TipoArticuloDAO();
				articulo.setId(rs.getInt("id_articulo"));
				articulo.setNombre(rs.getString("nombre"));
				ta = tDAO.buscarTipoId(rs.getInt("id_tipo_articulo"));
				articulo.setTa(ta);
				articulo.setStock(rs.getString("stock"));
				articulo.setPrecio(rs.getString("precio"));	
				lista.add(articulo);

			}
		} catch (SQLException ex) {
			Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return lista;

	}
	
	 public int Agregar(Articulo articulo) {
		 
	 String sentencia =
	 "INSERT INTO articulo (nombre,id_tipo_articulo,stock,precio) VALUES (?,?,?,?)"
	 ; try { 
		 con = cn.Conexion(); 
		 ps = con.prepareStatement(sentencia);
		 ps.setString(1, articulo.getNombre()); 
		 ps.setInt(2,articulo.getTa().getId()); 
		 ps.setString(3, articulo.getStock());
		 ps.setString(4, articulo.getPrecio());
		 ps.executeUpdate(); 
		 } catch (SQLException ex) {
	 Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex); }
	 return r; 
	 }
	 
	 public Articulo ListarPorId(int id) {
			con = cn.Conexion();
	        String consulta = "SELECT * FROM articulo WHERE id_articulo=" + id;
	        Articulo articulo = new Articulo();
	        try {
	            ps = con.prepareStatement(consulta);
	            rs = ps.executeQuery();
	            while (rs.next()) {
	    			Tipo_Articulo ta = new Tipo_Articulo();
	    			TipoArticuloDAO tDAO = new TipoArticuloDAO();
	            	articulo.setNombre(rs.getString("nombre"));
	            	ta = tDAO.buscarTipoId(rs.getInt("id_tipo_articulo"));
					articulo.setTa(ta);
	            	articulo.setStock(rs.getString("stock"));
	            	articulo.setPrecio(rs.getString("precio"));
	               
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
	        }
			return articulo;
		}
	 
	 public void Actualizar(Articulo articulo) {
	        String sentencia = "UPDATE articulo set nombre=?,id_tipo_articulo=?,stock=?,precio=? WHERE id_articulo=?";
	        try {
	            con = cn.Conexion();
	            ps = con.prepareStatement(sentencia);
	            ps.setString(1, articulo.getNombre());
	            ps.setInt(2, articulo.getTa().getId());
	            ps.setString(3, articulo.getStock());
	            ps.setString(4,  articulo.getPrecio());
	            
	            
	            ps.setInt(5, articulo.getId());
	            ps.executeUpdate();

	        } catch (SQLException ex) {
	            Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }

	
	
	 public void Eliminar(int id) {

	        String sql = "DELETE FROM articulo WHERE id_articulo=" + id;
	        con = cn.Conexion();
	        try {
	            ps = con.prepareStatement(sql);
	            ps.executeUpdate();
	        } catch (SQLException ex) {
	            Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
	        }

	    }
	 
	 public void EliminarTipo(int id) {

	        String sql = "DELETE FROM articulo WHERE id_tipo_articulo = ?";
	        con = cn.Conexion();
	        try {
	            ps = con.prepareStatement(sql);
	            ps.setInt(1, id);
	            ps.executeUpdate();
	        } catch (SQLException ex) {
	            Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
	        }

	    }
	public Articulo buscarArticuloId(int id) {
		Articulo articulo = new Articulo();
		Tipo_Articulo ta = new Tipo_Articulo();
		TipoArticuloDAO taDAO = new TipoArticuloDAO();
		String consulta = "SELECT * FROM articulo WHERE id_articulo= ?";
		con = cn.Conexion();
	       try {
	           ps = con.prepareStatement(consulta);
	           ps.setInt(1, id);
	           rs = ps.executeQuery();
	           while (rs.next()) {
	        	articulo.setId(rs.getInt("id_articulo"));
	        	articulo.setNombre(rs.getString("nombre"));
	        	ta = taDAO.buscarTipoId(rs.getInt("id_tipo_articulo"));
	        	articulo.setTa(ta);
	        	articulo.setStock(rs.getString("stock"));
	        	articulo.setPrecio(rs.getString("precio"));
	           }
	       } catch (SQLException ex) {
	           Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
	       }
			
		return articulo;
		}
	 

}