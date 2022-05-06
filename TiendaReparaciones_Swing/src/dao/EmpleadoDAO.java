package dao;

import java.util.Collection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import entidades.Empleado;
import utils.Datos;
import utils.ConexBD;
import utils.Datos;

public class EmpleadoDAO implements operacionesCRUD<Empleado> {
	Connection conex;

	public EmpleadoDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}

	@Override
	public boolean insertarConID(Empleado em) {
		boolean ret = false;

		String consultaInsertStr = "insert into empleado(idempleado, nombre, apellidos, direccion, telefono, nif) values (?,?,?,?,?,?)";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setLong(1, em.getIdEmpleado());
			pstmt.setString(2, em.getNombre());
			pstmt.setString(3, em.getApellidos());
			pstmt.setString(4, em.getDireccion());
			pstmt.setString(5, em.getTelefono());
			pstmt.setString(6, em.getNif());
			int resultadoInsercion = pstmt.executeUpdate();
			ret = (resultadoInsercion == 1);
			
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
		}

		return ret;
	}


	@Override
	public long insertarSinID(Empleado elemento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Empleado buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Empleado> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Empleado elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Empleado elemento) {
		// TODO Auto-generated method stub
		return false;
	}

}
