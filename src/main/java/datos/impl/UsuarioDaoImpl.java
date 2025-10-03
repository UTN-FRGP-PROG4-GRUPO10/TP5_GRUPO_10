package datos.impl;

import java.sql.ResultSet;
import java.util.List;

import datos.UsuarioDao;
import entidad.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {
	
	private Conexion cn;
	
	public UsuarioDaoImpl() {}
	
	@Override
	public boolean insertar(Usuario usuario) {
		
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "INSERT INTO usuarios (usuario,contrasena) VALUES ('"+usuario.getUsuario()+"','"+usuario.getContrasena()+"')";
		System.out.println(query);
		try
		 {
			estado=cn.execute(query);
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return estado;
	}
	
	@Override
	public Usuario obtenerLogin(String usuario, String contrasena) {
		
		cn = new Conexion();
		cn.Open();
		Usuario u = null;
		try 
		{
			String query = "SELECT id_usuario FROM usuarios WHERE usuario = '"+usuario+"' AND contrasena = '"+contrasena+"'";
			ResultSet rs = cn.query(query);
			if(rs.next()) {
				u = new Usuario(rs.getInt("id_usuario"), usuario, contrasena);			
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			cn.close();
		}
		
		return u;
	}

	@Override
	public List<Usuario> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario obtenerUno(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean editar(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrar(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
