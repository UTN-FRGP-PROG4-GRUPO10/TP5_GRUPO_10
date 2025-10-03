package negocio.impl;

import java.util.List;

import datos.UsuarioDao;
import datos.impl.UsuarioDaoImpl;
import entidad.Usuario;
import negocio.UsuarioNeg;

public class UsuarioNegImpl implements UsuarioNeg {

	private UsuarioDao usuarioDao = new UsuarioDaoImpl();
	
	public UsuarioNegImpl() {}
	
	public UsuarioNegImpl(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	@Override
	public List<Usuario> obtenerTodos() {
		return usuarioDao.obtenerTodos();
	}

	@Override
	public Usuario obtenerUno(int id) {
		return usuarioDao.obtenerUno(id);
	}

	@Override
	public Usuario obtenerLogin(String usuario, String contrasena) {
		return usuarioDao.obtenerLogin(usuario, contrasena);
	}

	@Override
	public boolean insertar(Usuario usuario) {
		return usuarioDao.insertar(usuario);
	}

	@Override
	public boolean editar(Usuario usuario) {
		return usuarioDao.editar(usuario);
	}

	@Override
	public boolean borrar(int id) {
		return usuarioDao.borrar(id);
	}
	
	
	
}
