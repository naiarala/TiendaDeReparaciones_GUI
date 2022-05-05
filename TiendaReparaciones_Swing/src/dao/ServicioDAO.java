package dao;

import java.util.Collection;
import entidades.Servicio;

public class ServicioDAO implements operacionesCRUD<Servicio> {

	@Override
	public boolean insertarConID(Servicio elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long insertarSinID(Servicio elemento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Servicio buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Servicio> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Servicio elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Servicio elemento) {
		// TODO Auto-generated method stub
		return false;
	}

}
