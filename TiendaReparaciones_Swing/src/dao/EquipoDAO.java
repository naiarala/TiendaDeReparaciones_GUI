package dao;

import java.util.Collection;
import entidades.Equipo;

public class EquipoDAO implements operacionesCRUD<Equipo> {

	@Override
	public boolean insertarConID(Equipo elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long insertarSinID(Equipo elemento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Equipo buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Equipo> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Equipo elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Equipo elemento) {
		// TODO Auto-generated method stub
		return false;
	}

}
