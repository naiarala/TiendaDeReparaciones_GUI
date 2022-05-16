package dao;


import java.sql.Connection;
import java.util.Collection;

import entidades.EmpleadoRepartidor;

public class EmpleadoRepartidorDAO implements operacionesCRUD<EmpleadoRepartidor> {

	Connection conex;

	public EmpleadoRepartidorDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}
	
	@Override
	public boolean insertarConID(EmpleadoRepartidor er) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long insertarSinID(EmpleadoRepartidor er) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public EmpleadoRepartidor buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<EmpleadoRepartidor> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(EmpleadoRepartidor er) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(EmpleadoRepartidor er) {
		// TODO Auto-generated method stub
		return false;
	}

}
