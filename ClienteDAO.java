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

public class ClienteDAO {
	Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    int r;
    
    public List Listar() {
        String consulta = "SELECT * FROM cliente";
        List<Cliente> lista = new ArrayList();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setDireccion(rs.getString("direccion"));
                lista.add(cliente);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;

    }
    
    public int Agregar(Cliente cliente) {

        String sentencia = "INSERT INTO cliente (nombre,telefono,direccion) VALUES (?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getTelefono());
            ps.setString(3, cliente.getDireccion());
        
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    public Cliente ListarPorId(int id) {
        Cliente cliente = new Cliente();
        String consulta = "SELECT * FROM cliente WHERE id=" + id;
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                cliente.setNombre(rs.getString(2));
                cliente.setTelefono(rs.getString(3));
                cliente.setDireccion(rs.getString(4));
               
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cliente;

    }

    public void Actualizar(Cliente cliente) {
        String sentencia = "UPDATE cliente set nombre=?,telefono=?,direccion=? WHERE id=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getTelefono());
            ps.setString(3, cliente.getDireccion());
         
     
            ps.setInt(4, cliente.getId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Eliminar(int id) {

        String sql = "DELETE FROM cliente WHERE id=" + id;
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

	public Cliente buscarClienteId(int id) {
		Cliente cliente = new Cliente();
		String consulta = "SELECT * FROM cliente WHERE id= ?";
		con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
            	cliente.setId(rs.getInt("id"));
            	cliente.setNombre(rs.getString("nombre"));
            	cliente.setTelefono(rs.getString("telefono"));
            	cliente.setDireccion(rs.getString("apellido"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		return cliente;
	}
    
    
}
