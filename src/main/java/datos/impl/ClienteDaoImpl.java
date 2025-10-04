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
			String query = "INSERT INTO clientes (dni, cuil, nombre, apellido, sexo, fecha_nacimiento, direccion, nacionalidad, localidad, provincia, correo_electronico, telefono) "
					+ "VALUES ("+cliente.getDni()+", "+cliente.getCuil()+", '"+cliente.getNombre()+"', '"+cliente.getApellido()+"', '"+cliente.getSexo()+"', '"+cliente.getFechaNacimiento()+"', '"+cliente.getDireccion()+"', '"+cliente.getNacionalidad()+"', '"+cliente.getLocalidad()+"', '"+cliente.getProvincia()+"', '"+cliente.getCorreoElectronico()+"', "+cliente.getTelefono()+")";
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
	public Cliente obtenerUno(String dni) {
		Cliente c = null;
		cn = new Conexion();
		cn.Open();
		try 
		{
			String query = "SELECT * FROM clientes WHERE dni = "+dni;
			ResultSet rs = cn.query(query);
			if(rs.next()) {
				c = new Cliente(rs.getString("dni"), rs.getString("cuil"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("sexo"), rs.getString("nacionalidad"), rs.getDate("fecha_nacimiento").toLocalDate(), rs.getString("direccion"), rs.getString("localidad"), rs.getString("provincia"), rs.getString("correo_electronico"), rs.getString("telefono"));			
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
	public boolean borrar(String dni) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
