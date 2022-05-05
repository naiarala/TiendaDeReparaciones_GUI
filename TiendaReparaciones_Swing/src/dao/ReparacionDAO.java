package dao;

import java.util.Collection;
import entidades.Reparacion;

public class ReparacionDAO implements operacionesCRUD<Reparacion> {

	@Override
	public boolean insertarConID(Reparacion elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long insertarSinID(Reparacion elemento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Reparacion buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Reparacion> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Reparacion elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Reparacion elemento) {
		// TODO Auto-generated method stub
		return false;
	}

}
