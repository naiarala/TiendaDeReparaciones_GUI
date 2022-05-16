package dao;


import java.sql.Connection;
import java.util.Collection;

import entidades.Grupo;

public class GrupoDAO implements operacionesCRUD<Grupo> {

	Connection conex;

	public GrupoDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}
	
	@Override
	public boolean insertarConID(Grupo g) {
		
		return false;
	}

	@Override
	public long insertarSinID(Grupo g) {
		
		return 0;
	}

	@Override
	public Grupo buscarPorID(long id) {
		
		return null;
	}

	@Override
	public Collection<Grupo> buscarTodos() {
		
		return null;
	}

	@Override
	public boolean modificar(Grupo g) {
		
		return false;
	}

	@Override
	public boolean eliminar(Grupo g) {
		
		return false;
	}

}
