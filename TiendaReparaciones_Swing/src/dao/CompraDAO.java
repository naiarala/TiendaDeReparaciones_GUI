package dao;

import java.util.Collection;
import entidades.Compra;

public class CompraDAO implements operacionesCRUD<Compra> {

	@Override
	public boolean insertarConID(Compra elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long insertarSinID(Compra elemento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Compra buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Compra> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Compra elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Compra elemento) {
		// TODO Auto-generated method stub
		return false;
	}

}
