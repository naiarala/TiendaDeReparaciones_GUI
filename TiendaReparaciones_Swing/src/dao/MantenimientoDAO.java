package dao;

import java.util.Collection;
import entidades.Mantenimiento;

public class MantenimientoDAO implements operacionesCRUD<Mantenimiento> {

	@Override
	public boolean insertarConID(Mantenimiento elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long insertarSinID(Mantenimiento elemento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Mantenimiento buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Mantenimiento> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Mantenimiento elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Mantenimiento elemento) {
		// TODO Auto-generated method stub
		return false;
	}

}
