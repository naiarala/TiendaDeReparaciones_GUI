package dao;


import java.sql.Connection;
import java.util.Collection;

import entidades.EmpleadoTaller;

public class EmpleadoTallerDAO implements operacionesCRUD<EmpleadoTaller> {

	Connection conex;

	public EmpleadoTallerDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}
	
	@Override
	public boolean insertarConID(EmpleadoTaller et) {
		
		return false;
	}

	@Override
	public long insertarSinID(EmpleadoTaller et) {
		
		return 0;
	}

	@Override
	public EmpleadoTaller buscarPorID(long id) {
		
		return null;
	}

	@Override
	public Collection<EmpleadoTaller> buscarTodos() {
		
		return null;
	}

	@Override
	public boolean modificar(EmpleadoTaller et) {
		
		return false;
	}

	@Override
	public boolean eliminar(EmpleadoTaller et) {
		
		return false;
	}

}
