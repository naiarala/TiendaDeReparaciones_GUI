package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import entidades.BajaEmpleado;
import entidades.EmpleadoSustituto;
import utils.ConexBD;

public class EmpleadoSustitutoDAO {

	Connection conex;

	public EmpleadoSustitutoDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}

public boolean insertarConID(EmpleadoSustituto es) {
		boolean ret = false;

		String consultaInsertStr = "insert into empleadosustituto(edad, colectivo, baja, idEmpleado) values (?,?,?,?)";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setString(1, es.getEdad());
			pstmt.setBoolean(2, es.isColectivo());
			pstmt.setObject(3, es.getBaja());
			pstmt.setLong(4, es.getIdEmpleado());
			int resultadoInsercion = pstmt.executeUpdate();
			ret = (resultadoInsercion == 1);

		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
		}

		return ret;
	}

	public long insertarSinID(EmpleadoSustituto es) {
		long ret = -1;

		String consultaInsertStr = "insert into empleadosustituto(edad, colectivo, baja, idEmpleado) values (?,?,?,?)";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setString(1, es.getEdad());
			pstmt.setBoolean(2, es.isColectivo());
			pstmt.setObject(3, es.getBaja());
			pstmt.setLong(4, es.getIdEmpleado());
			int resultadoInsercion = pstmt.executeUpdate();
			if (resultadoInsercion == 1) {
				String consultaSelect = "SELECT id FROM empleadosustituto WHERE (edad=? AND colectivo=? AND baja=?"
						+ "AND idEmpleado=?)";
				PreparedStatement pstmt2 = conex.prepareStatement(consultaSelect);
				pstmt.setString(1, es.getEdad());
				pstmt.setBoolean(2, es.isColectivo());
				pstmt.setObject(3, es.getBaja());
				pstmt.setLong(4, es.getIdEmpleado());
				ResultSet result = pstmt2.executeQuery();
				while (result.next()) {
					long idempleado = result.getLong("id");
					if (idempleado != -1) {
						System.out.println(
								"Se ha insertado correctamente la nueva EmpleadoSustituto de id: " + idempleado);
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

	public EmpleadoSustituto buscarPorID(long id) {
		EmpleadoSustituto ret = null;
		String consultaInsertStr = "select * FROM empleadosustituto WHERE id=?"; 
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setLong(1, id);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				long idBD = result.getLong("idempleado");
				String edad = result.getString("edad");
				boolean colectivo = result.getBoolean("colectivo");
				BajaEmpleado baja = (BajaEmpleado) result.getObject("baja");
				long idEmpleado = result.getLong("idEmpleado");
				ret = new EmpleadoSustituto();
				ret.setIdEmpleado(idBD);
				ret.setEdad(edad);
				ret.setColectivo(colectivo);
				ret.setBaja(baja);
				ret.setIdEmpleado(idEmpleado);
				
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

	public Collection<EmpleadoSustituto> buscarTodos() {
		List<EmpleadoSustituto> todos = new ArrayList<>();
		String consultaInsertStr = "select * FROM empleadosustituto";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				EmpleadoSustituto empleadosustituto;
				long idBD = result.getLong("idempleado");
				String edad = result.getString("edad");
				boolean colectivo = result.getBoolean("colectivo");
				BajaEmpleado baja = (BajaEmpleado) result.getObject("baja");
				long idEmpleado = result.getLong("idEmpleado");
				empleadosustituto = new EmpleadoSustituto();
				empleadosustituto.setIdEmpleado(idBD);
				empleadosustituto.setEdad(edad);
				empleadosustituto.setColectivo(colectivo);
				empleadosustituto.setBaja(baja);
				empleadosustituto.setIdEmpleado(idEmpleado);
				todos.add(empleadosustituto);
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

	public boolean modificar(EmpleadoSustituto es) {
		boolean ret = true;
		Connection conex = ConexBD.establecerConexion();
		String consultaInsertStr = "update empleadosustituto SET edad=?, colectivo=?, baja=? WHRERE id=" + es.getIdEmpleado();
		try {
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setString(1, es.getEdad());
			pstmt.setBoolean(2, es.isColectivo());
			pstmt.setObject(3, es.getBaja());
			pstmt.setLong(4, es.getIdEmpleado());
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

	public boolean eliminar(EmpleadoSustituto es) {
		boolean ret = true;
		Connection conex = ConexBD.establecerConexion();
		String consultaInsertStr = "delete FROM empleadosustituto WHERE id=" + es.getIdEmpleado();
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
