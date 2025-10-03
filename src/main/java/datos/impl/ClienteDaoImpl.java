package datos.impl;

import java.sql.ResultSet;
//import java.time.LocalDate;
import java.util.List;

import datos.ClienteDao;
import entidad.Cliente;

public class ClienteDaoImpl implements ClienteDao{
	
	private Conexion cn;
	
	public ClienteDaoImpl() {}
	
	@Override
	public boolean insertar(Cliente cliente) {
		boolean estado=true;
		cn = new Conexion();
		cn.Open();
		try 
		{
			String query = "INSERT INTO clientes (dni, cuil, nombre, apellido, sexo, nacionalidad, fecha_nacimiento, direccion, localidad, provincia, correo_electronico, telefono) "
					+ "VALUES ("+cliente.getDni()+", "+cliente.getCuil()+", '"+cliente.getNombre()+"', '"+cliente.getApellido()+"', '"+cliente.getSexo()+"', '"+cliente.getNacionalidad()+"', '"+cliente.getFechaNacimiento()+"', '"+cliente.getDireccion()+"', '"+cliente.getLocalidad()+"', '"+cliente.getProvincia()+"', '"+cliente.getCorreoElectronico()+"', "+cliente.getTelefono()+")";
			cn.execute(query);
		} 
		catch (Exception e) 
		{
			estado=false;
			e.printStackTrace();
		} 
		finally 
		{
			cn.close();
		}
		return estado;
	}
	
	@Override
	public Cliente obtenerUno(int dni) {
		
		cn = new Conexion();
		cn.Open();
		Cliente c = null;
		try 
		{
			String query = "SELECT * FROM clientes WHERE dni = "+dni;
			ResultSet rs = cn.query(query);
			if(rs.next()) {
				c = new Cliente(rs.getInt("dni"), dni, rs.getString("nombre"), rs.getString("apellido"), rs.getString("telefono"), rs.getString("email"), null, query, query, query, query, dni);			
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
		return c;
		
	}
	
	@Override
	public List<Cliente> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean editar(Cliente cliente) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean borrar(int dni) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
