package dao;


import java.sql.Connection;
import java.util.Collection;

import entidades.Envio;

public class EnvioDAO implements operacionesCRUD<Envio> {

	Connection conex;

	public EnvioDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}
	
	@Override
	public boolean insertarConID(Envio e) {
		
		return false;
	}

	@Override
	public long insertarSinID(Envio e) {
		
		return 0;
	}

	@Override
	public Envio buscarPorID(long id) {
		
		return null;
	}

	@Override
	public Collection<Envio> buscarTodos() {
		
		return null;
	}

	@Override
	public boolean modificar(Envio e) {
		
		return false;
	}

	@Override
	public boolean eliminar(Envio e) {
		
		return false;
	}

}
