package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Articulo;
import modelo.ArticuloDAO;
import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.TipoArticuloDAO;
import modelo.Tipo_Articulo;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Cliente cliente = new Cliente();
	ClienteDAO clienteDAO = new ClienteDAO();

	Articulo articulo = new Articulo();
	ArticuloDAO articuloDAO = new ArticuloDAO();
	
	Tipo_Articulo tipoArt = new Tipo_Articulo();
	TipoArticuloDAO tipoArtDAO = new TipoArticuloDAO();

	int idCliente;
	int idArticulo;
	int idTipo;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controlador() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String menu = request.getParameter("menu");
		String accion = request.getParameter("accion");
		if (menu.equals("Principal")) {
			request.getRequestDispatcher("Principal.jsp").forward(request, response);
		}

		if (menu.equals("Articulos")) {
			switch (accion) {
			case "Listar":
				List lista = articuloDAO.Listar();
				request.setAttribute("articulo", lista);

				break;
			
		
			case "Agregar":
				
				articulo.setTa(tipoArt);
				String nombre = request.getParameter("txtnombre"); 
				String id_tipo_articulo = request.getParameter("txtid_producto");
				String stock = request.getParameter("txtstock"); 
				String precio = request.getParameter("txtprecio"); 
				articulo.setNombre(nombre);
				tipoArt.setId(Integer.parseInt(id_tipo_articulo)); 
				articulo.setStock(stock);
				articulo.setPrecio(precio);
		  
				articuloDAO.Agregar(articulo, tipoArt);
				request.getRequestDispatcher("Controlador?menu=Articulos&accion=Listar").forward(request, response);
		  
		  	break;
		  	
			case "Actualizar":
				Articulo articulo1 = new Articulo();
				articulo1.setTa(tipoArt);
				String nombreUpdate = request.getParameter("txtnombre"); 
				String id_tipo_articuloUpdate = request.getParameter("txtid_producto");
				String stockUpdate = request.getParameter("txtstock"); 
				String precioUpdate = request.getParameter("txtprecio"); 
				articulo1.setNombre(nombreUpdate);
				tipoArt.setId(Integer.parseInt(id_tipo_articuloUpdate));
				articulo1.setStock(stockUpdate);
				articulo1.setPrecio(precioUpdate);
				articulo1.setId(idArticulo);
				articuloDAO.Actualizar(articulo1, tipoArt);
				request.getRequestDispatcher("Controlador?menu=Articulos&accion=Listar").forward(request, response);

				break;
				
			case "Cargar":

				idArticulo = Integer.parseInt(request.getParameter("id"));
				Articulo articulo = articuloDAO.ListarPorId(idArticulo);
				request.setAttribute("articuloSeleccionado", articulo);
				request.getRequestDispatcher("Controlador?menu=Articulos&accion=Listar").forward(request, response);

				break;
			case "Eliminar":

				idArticulo = Integer.parseInt(request.getParameter("id"));
				clienteDAO.Eliminar(idArticulo);
				request.getRequestDispatcher("Controlador?menu=Articulos&accion=Listar").forward(request, response);

				break;
			}
			
			request.getRequestDispatcher("Articulos.jsp").forward(request, response);
		}

		if (menu.equals("Clientes")) {

			switch (accion) {
			case "Listar":
				List lista = clienteDAO.Listar();
				request.setAttribute("cliente", lista);

				break;

			case "Agregar":

				String nombre = request.getParameter("txtnombre");
				String apellido = request.getParameter("txtapellido");
				String telefono = request.getParameter("txttelefono");
				String direccion = request.getParameter("txtdireccion");
				cliente.setNombre(nombre);
				cliente.setApellido(apellido);
				cliente.setTelefono(telefono);
				cliente.setDireccion(direccion);

				clienteDAO.Agregar(cliente);
				request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);

				break;

			case "Actualizar":
				Cliente cliente1 = new Cliente();
				String nombreUpdate = request.getParameter("txtnombre");
				String apellidoUpdate = request.getParameter("txtapellido");
				String telefonoUpdate = request.getParameter("txttelefono");
				String direccionUpdate = request.getParameter("txtdireccion");
				cliente1.setNombre(nombreUpdate);
				cliente1.setApellido(apellidoUpdate);
				cliente1.setTelefono(telefonoUpdate);
				cliente1.setDireccion(direccionUpdate);
				cliente1.setId(idCliente);
				clienteDAO.Actualizar(cliente1);
				request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);

				break;
			case "Cargar":

				idCliente = Integer.parseInt(request.getParameter("id"));
				Cliente cliente = clienteDAO.ListarPorId(idCliente);
				request.setAttribute("clienteSeleccionado", cliente);
				request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);

				break;
			case "Eliminar":

				idCliente = Integer.parseInt(request.getParameter("id"));
				clienteDAO.Eliminar(idCliente);
				request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);

				break;
			}

			request.getRequestDispatcher("Clientes.jsp").forward(request, response);
		}
		
		  if (menu.equals("TipoArticulo")) {
			  switch (accion) {
				case "Listar":
					List lista = tipoArtDAO.Listar();
					request.setAttribute("tipo_articulo", lista);
					
					break;
					
				case "Agregar":

					String id = request.getParameter("txtid");
					String descripcion = request.getParameter("txtdescripcion");
					tipoArt.setId(Integer.parseInt(id));
					tipoArt.setDescripcion(descripcion);

					tipoArtDAO.Agregar(tipoArt);
					request.getRequestDispatcher("Controlador?menu=TipoArticulo&accion=Listar").forward(request, response);

					break;
				case "Actualizar":
					Tipo_Articulo tipo_art1 = new Tipo_Articulo();
					String descripcionUpdate = request.getParameter("txtdescripcion");
					tipo_art1.setDescripcion(descripcionUpdate);
					tipoArtDAO.Actualizar(tipo_art1);
					request.getRequestDispatcher("Controlador?menu=TipoArticulo&accion=Listar").forward(request, response);

					break;
				case "Cargar":

					idTipo = Integer.parseInt(request.getParameter("id"));
					Tipo_Articulo tipo_articulo = tipoArtDAO.ListarPorId(idTipo);
					request.setAttribute("clienteSeleccionado", cliente);
					request.getRequestDispatcher("Controlador?menu=TipoArticulo&accion=Listar").forward(request, response);
			  
					
			  }
		  request.getRequestDispatcher("TipoArticulo.jsp").forward(request, response); 
			  }
		  if (menu.equals("Pedidos")) {
				request.getRequestDispatcher("Pedidos.jsp").forward(request, response);
			}
		 

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
