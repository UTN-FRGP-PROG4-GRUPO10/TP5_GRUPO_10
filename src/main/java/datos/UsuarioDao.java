package datos;

import java.util.List;

import entidad.Usuario;

public interface UsuarioDao {
	
	public List<Usuario> obtenerTodos();
	public Usuario obtenerUno(int id);
	public Usuario obtenerLogin(String usuario, String contrasena);
	public boolean insertar(Usuario articulo);
	public boolean editar(Usuario articulo);
	public boolean borrar(int id);
	
}
