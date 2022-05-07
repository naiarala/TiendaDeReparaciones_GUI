package dao;

import java.util.Collection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	public long insertarSinID(Empleado em) {
		long ret = -1;

		String consultaInsertStr = "insert into empleado( nombre, apellidos, direccion, telefono, nif) values (?,?,?,?,?)";

		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setString(1, em.getNombre());
			pstmt.setString(2, em.getApellidos());
			pstmt.setString(3, em.getDireccion());
			pstmt.setString(4, em.getTelefono());
			pstmt.setString(5, em.getNif());
			int resultadoInsercion = pstmt.executeUpdate();
			if (resultadoInsercion == 1) {
				String consultaSelect = "SELECT id FROM empleado WHERE (nombre=? AND telefono=? " + "AND nif=?)";
				PreparedStatement pstmt2 = conex.prepareStatement(consultaSelect);
				pstmt2.setString(1, em.getNombre());
				pstmt2.setString(2, em.getApellidos());
				pstmt2.setString(3, em.getDireccion());
				pstmt2.setString(4, em.getTelefono());
				pstmt2.setString(5, em.getNif());
				ResultSet result = pstmt2.executeQuery();
				while (result.next()) {
					long idempleado = result.getLong("id");
					if (idempleado != -1) {
						System.out.println("Se ha insertado correctamente el nuevo Empleado de id: " + idempleado);
						if (conex != null)
							conex.close();
						return idempleado;
					}
				}
				result.close();
				pstmt2.close();
				if (conex != null)
					conex.close();
			}
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
			return -1;
		}

		return ret;
	}

	@Override
	public Empleado buscarPorID(long id) {
		Empleado ret = null;
		String consultaInsertStr = "select * FROM emplado WHERE id=?";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setLong(1, id);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				long idBD = result.getLong("id");
				String nombre = result.getString("nombre");
				String apellidos = result.getString("apellidos");
				String direccion = result.getString("direccion");
				String telefono = result.getString("telefono");
				String nif = result.getString("nif");
				ret = new Empleado();
				ret.setIdEmpleado(idBD);
				ret.setNombre(nombre);
				ret.setApellidos(apellidos);
				ret.setDireccion(direccion);
				ret.setTelefono(telefono);
				ret.setNif(nif);
			}
			if (conex != null)
				conex.close();
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception:" + e.getMessage());
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public Collection<Empleado> buscarTodos() {
		List<Empleado> todos = new ArrayList<>();
		String consultaInsertStr = "select * FROM empleado";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				Empleado empleado;
				long idBD = result.getLong("id");
				float altura = result.getFloat("altura");
				float peso = result.getFloat("peso");
				empleado = new Empleado();
				empleado.setIdEmpleado(idBD);
				String nombre = result.getString("nombre");
				String apellidos = result.getString("apellidos");
				String direccion = result.getString("direccion");
				String telefono = result.getString("telefono");
				String nif = result.getString("nif");
				empleado = new Empleado();
				empleado.setIdEmpleado(idBD);
				empleado.setNombre(nombre);
				empleado.setApellidos(apellidos);
				empleado.setDireccion(direccion);
				empleado.setTelefono(telefono);
				empleado.setNif(nif);

				todos.add(empleado);
			}
			if (conex != null)
				conex.close();
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception:" + e.getMessage());
			e.printStackTrace();
		}
		return todos;
	}

	@Override
	public boolean modificar(Empleado em) {
		boolean ret = true;
		Connection conex = ConexBD.establecerConexion();
		String consultaInsertStr = "update atletas SET altura=?,peso=?,idpersona=? WHRERE id=" + em.getIdEmpleado();
		try {
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setLong(1, em.getIdEmpleado());
			pstmt.setString(2, em.getNombre());
			pstmt.setString(3, em.getApellidos());
			pstmt.setString(4, em.getDireccion());
			pstmt.setString(5, em.getTelefono());
			pstmt.setString(6, em.getNif());
			int resultado = pstmt.executeUpdate();
			ret = (resultado == 1);
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
			ret = false;
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception:" + e.getMessage());
			e.printStackTrace();
			ret = false;
		}
		return ret;
	}

	@Override
	public boolean eliminar(Empleado em) {
		boolean ret = true;
		Connection conex = ConexBD.establecerConexion();
		String consultaInsertStr = "delete FROM atletas WHERE id=" + em.getIdEmpleado();
		try {
			Statement stmt = conex.createStatement();
			stmt.executeUpdate(consultaInsertStr);

		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
			ret = false;
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception:" + e.getMessage());
			e.printStackTrace();
			ret = false;
		}
		return ret;
	}

}
