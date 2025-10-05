package datos.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
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
		List<Cliente> Clientes = new ArrayList<Cliente>();
		
		cn = new Conexion();
		cn.Open();
		
		try {
			String query = "SELECT * FROM Clientes";
			ResultSet rs = cn.query(query);
			
			while(rs.next()) {
				Cliente Cliente = new Cliente();
				Cliente.setDni(rs.getString("dni"));
				Cliente.setCuil(rs.getString("cuil"));
				Cliente.setNombre(rs.getString("nombre"));
				Cliente.setApellido(rs.getString("apellido"));	
				Cliente.setSexo(rs.getString("sexo"));
				Cliente.setFechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
				Cliente.setDireccion(rs.getString("direccion"));
				Cliente.setNacionalidad(rs.getString("nacionalidad"));
				Cliente.setLocalidad(rs.getString("localidad"));
				Cliente.setProvincia(rs.getString("provincia"));
				Clientes.add(Cliente);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return Clientes;
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
