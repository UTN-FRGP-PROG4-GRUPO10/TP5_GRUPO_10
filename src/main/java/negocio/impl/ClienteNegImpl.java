package negocio.impl;

import datos.ClienteDao;
import datos.impl.ClienteDaoImpl;
import entidad.Cliente;
import negocio.ClienteNeg;


public class ClienteNegImpl implements ClienteNeg {
	
	private ClienteDao clienteDao = new ClienteDaoImpl();
	
	public ClienteNegImpl() {}
	
	public ClienteNegImpl(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}

	@Override
	public boolean insertar(Cliente cliente) {
		return clienteDao.insertar(cliente);
	}

	@Override
	public Cliente obtenerUno(int dni) {
		return clienteDao.obtenerUno(dni);
	}
	
	@Override
	public boolean editar(Cliente cliente) {
		return clienteDao.editar(cliente);
	}
	@Override
	public boolean borrar(int dni) {
		return clienteDao.borrar(dni);
	}
	@Override
	public java.util.List<Cliente> obtenerTodos() {
		return clienteDao.obtenerTodos();
	}
}
