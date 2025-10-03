package presentacion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Cliente;
import negocio.ClienteNeg;
import negocio.impl.ClienteNegImpl;

/**
 * Servlet implementation class ServletCliente
 */
@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ClienteNeg ClienteNeg = new ClienteNegImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		if(request.getParameter("btnRegistrarCliente") != null)
		{
			try {
				Cliente c = new Cliente();
				c.setDni(Integer.parseInt(request.getParameter("txtDNI")));
				c.setCuil(Integer.parseInt(request.getParameter("txtCuil")));
				c.setNombre(request.getParameter("txtNombre"));
				c.setApellido(request.getParameter("txtApellido"));
				c.setSexo(request.getParameter("txtSexo"));
				c.setNacionalidad(request.getParameter("txtNacionalidad"));
				c.setFechaNacimiento(java.time.LocalDate.parse(request.getParameter("txtFechaNacimiento")));
				c.setDireccion(request.getParameter("txtDireccion"));
				c.setLocalidad(request.getParameter("txtLocalidad"));
				c.setProvincia(request.getParameter("txtProvincia"));
				c.setCorreoElectronico(request.getParameter("txtCorreoElectronico"));
				c.setTelefono(Integer.parseInt(request.getParameter("txtTelefono")));
				
				boolean  filas = ClienteNeg.insertar(c);
				
				request.setAttribute("filas", filas);
		        request.setAttribute("mensaje", filas ? "Cliente guardado correctamente."
                        : "No se pudo guardar el cliente.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/AltaCliente.jsp");
		        dispatcher.forward(request, response);
		        return;
				
			} catch (Exception e) {
				e.printStackTrace();
		        request.setAttribute("mensaje", "Error al guardar cliente: " + e.getMessage());
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/AltaCliente.jsp");
		        dispatcher.forward(request, response);
		        return;
			}
	}

}
}