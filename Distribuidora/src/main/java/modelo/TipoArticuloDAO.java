package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import config.Conexion;

public class TipoArticuloDAO {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Conexion cn = new Conexion();
	int r;

	public List Listar() {
		String consulta = "SELECT * FROM tipo_articulo";
		List<Tipo_Articulo> lista = new ArrayList();

		try {
			con = cn.Conexion();
			ps = con.prepareStatement(consulta);
			rs = ps.executeQuery();
			while (rs.next()) {
				Tipo_Articulo ta = new Tipo_Articulo();
				ta.setId(rs.getInt("id_tipo_articulo"));
				ta.setDescripcion(rs.getString("descripcion"));
				lista.add(ta);

			}
		} catch (SQLException ex) {
			Logger.getLogger(TipoArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return lista;

	}

	public int Agregar(Tipo_Articulo tipoArt) {
		String sentencia = "INSERT INTO tipo_articulo (descripcion) VALUES (?)";
		try {
			con = cn.Conexion();
			ps = con.prepareStatement(sentencia);
			ps.setString(1, tipoArt.getDescripcion());

			ps.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(TipoArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return r;

	}
	
	public Tipo_Articulo ListarPorId(int id) {
		Tipo_Articulo ta = new Tipo_Articulo();
        String consulta = "SELECT * FROM tipo_articulo WHERE id_tipo_articulo=" + id;
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
            	ta.setDescripcion(rs.getString(2));              
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ta;

    }
	
	public void Actualizar(Tipo_Articulo ta) {
        String sentencia = "UPDATE tipo_articulo set descripcion=? WHERE id_tipo_articulo=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setString(1, ta.getDescripcion());
            ps.setInt(2, ta.getId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(TipoArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
	public void Eliminar(int id) {

        String sql = "DELETE FROM tipo_articulo WHERE id_tipo_articulo=" + id;
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
          

    }
	
	public Tipo_Articulo buscarTipo(String descripcion) {
		Tipo_Articulo ta = new Tipo_Articulo();
		String consulta = "SELECT * FROM tipo_articulo WHERE descripcion= ?";
		con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            ps.setString(1, descripcion);
            rs = ps.executeQuery();
            while (rs.next()) {
            	ta.setId(rs.getInt("id_tipo_articulo"));
            	ta.setDescripcion(rs.getString("descripcion")); 
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		return ta;
	}
	
	public Tipo_Articulo buscarTipoId(int id) {
		Tipo_Articulo ta = new Tipo_Articulo();
		String consulta = "SELECT * FROM tipo_articulo WHERE id_tipo_articulo= ?";
		con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
            	ta.setId(rs.getInt("id_tipo_articulo"));
            	ta.setDescripcion(rs.getString("descripcion")); 
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		return ta;
	}
	
}
