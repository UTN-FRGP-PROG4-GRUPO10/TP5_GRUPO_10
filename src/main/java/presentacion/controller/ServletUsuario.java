package presentacion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Usuario;
import negocio.UsuarioNeg;
import negocio.impl.UsuarioNegImpl;

@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UsuarioNeg usuarioNeg = new UsuarioNegImpl();
       
    public ServletUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnLogin") != null) {
			String usuario = request.getParameter("txtUsuario");
			String contrasena = request.getParameter("txtContrasena");
			Usuario u = usuarioNeg.obtenerLogin(usuario, contrasena);
			
			if(u != null) {
				request.getSession().setAttribute("usuario", u.getUsuario());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarClientes.jsp");
				dispatcher.forward(request, response);
			}
			else {
				request.setAttribute("usuario", u);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.jsp");
				dispatcher.forward(request, response);				
			}
			
		}
		
	}

}
