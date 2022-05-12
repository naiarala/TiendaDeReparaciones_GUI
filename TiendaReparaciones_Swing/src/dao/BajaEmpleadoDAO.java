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
import entidades.Empleado;
import utils.ConexBD;

public class BajaEmpleadoDAO implements operacionesCRUD <BajaEmpleado>{
	Connection conex;

	public BajaEmpleadoDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}
	 public static LocalDate asLocalDate(Date date) {
		    return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
		  }

		@Override
		public boolean insertarConID(BajaEmpleado be) {
		boolean ret = false;

		String consultaInsertStr = "insert into bajaempleado(idbaja, fechaInicio, fechaFin, motivoBaja, idEmpleado) values (?,?,?,?,?)";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setLong(1, be.getIdBaja());
			java.sql.Date fechaSQL = java.sql.Date.valueOf(be.getFechaInicio());
			pstmt.setDate(2, fechaSQL);
			java.sql.Date fechaSQL1 = java.sql.Date.valueOf(be.getFechaFin());
			pstmt.setDate(3, fechaSQL1);
			pstmt.setString(4, be.getMotivoBaja());
			pstmt.setLong(5, be.getIdEmpleado());
			int resultadoInsercion = pstmt.executeUpdate();
			ret = (resultadoInsercion == 1);

		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
		}

		return ret;
	}

	@Override
	public long insertarSinID(BajaEmpleado be) {
		long ret = -1;

		String consultaInsertStr = "insert into bajaempleado( fechaInicio, fechaFin, motivoBaja, idEmpleado) values (?,?,?,?,?)";

		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			java.sql.Date fechaSQL = java.sql.Date.valueOf(be.getFechaInicio());
			pstmt.setDate(1, fechaSQL);
			java.sql.Date fechaSQL1 = java.sql.Date.valueOf(be.getFechaFin());
			pstmt.setDate(2, fechaSQL1);
			pstmt.setString(3, be.getMotivoBaja());
			pstmt.setLong(4, be.getIdEmpleado());
			int resultadoInsercion = pstmt.executeUpdate();
			if (resultadoInsercion == 1) {
				String consultaSelect = "SELECT id FROM empleado WHERE (fechaInicio=? AND fechaFin=? AND motivoBaja=?"
						+ "AND idEmpleado=?)";
				PreparedStatement pstmt2 = conex.prepareStatement(consultaSelect);
				java.sql.Date fechaSQL2 = java.sql.Date.valueOf(be.getFechaInicio());
				pstmt.setDate(1, fechaSQL2);
				java.sql.Date fechaSQL3 = java.sql.Date.valueOf(be.getFechaFin());
				pstmt.setDate(2, fechaSQL3);
				pstmt.setString(3, be.getMotivoBaja());
				pstmt.setLong(4, be.getIdEmpleado());
				ResultSet result = pstmt2.executeQuery();
				while (result.next()) {
					long idbaja = result.getLong("id");
					if (idbaja != -1) {
						System.out.println(
								"Se ha insertado correctamente la nueva BajaEmpleado de id: " + idbaja);
						if (conex != null)
							conex.close();
						return idbaja;
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
	public BajaEmpleado buscarPorID(long id) {
		BajaEmpleado ret = null;
		String consultaInsertStr = "select * FROM bajaempleado WHERE id=?"; 
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setLong(1, id);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				long idBD = result.getLong("idbaja");
				BajaEmpleado bajaempleado;
				
				
				//Lo consigo en Localdate y lo inserto en ret (BajaEmpleado)
				LocalDate fechaInicio = LocalDate.parse(result.getString(1));
				ret.setFechaInicio(fechaInicio);
				LocalDate FechaFin = LocalDate.parse(result.getString(2));
				ret.setFechaFin(FechaFin);
				///////////////////////////
				
				
				//lo conseguimos en tipo Date y luego lo pasamos a Localdate
				//Date fechaInicio=Date.valueOf(result.getString(1));
				//Date fechaFin=Date.valueOf(result.getString(2));
				
				//ret.setFechaInicio(fechaInicio.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
				//ret.setFechaFin(fechaFin.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
				//////////////////////
				
				
				
			

				String motivoBaja = result.getString("motivoBaja");
				long idEmpleado = result.getLong("idEmpleado");
				ret = new BajaEmpleado();
				ret.setIdBaja(idBD);
				
				ret.setMotivoBaja(motivoBaja);
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
	
	@Override
	public Collection<BajaEmpleado> buscarTodos() {
		List<BajaEmpleado> todos = new ArrayList<>();
		String consultaInsertStr = "select * FROM bajaempleado";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				BajaEmpleado bajaempleado;
				long idBD = result.getLong("id");
				float altura = result.getFloat("altura");
				float peso = result.getFloat("peso");
				bajaempleado = new BajaEmpleado();
//				LocalDate fechaInicio = result.getDate(fechaInicio);
//				LocalDate fechaFin = result.getDate(fechaFin);
				String motivoBaja = result.getString("motivoBaja");
				long idEmpleado = result.getLong("idEmpleado");
				bajaempleado.setIdBaja(idBD);
//				bajaempleado.setFechaInicio(fechaInicio);
//				bajaempleado.setFechaFin(fechaFin);
				bajaempleado.setMotivoBaja(motivoBaja);
				bajaempleado.setIdEmpleado(idEmpleado);
				todos.add(bajaempleado);
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
	public boolean modificar(BajaEmpleado be) {
		boolean ret = true;
		Connection conex = ConexBD.establecerConexion();
		String consultaInsertStr = "update bajaempleado SET fechainicio=?, fechafin=?, motivobaja=?, idempleado=? WHRERE id=" + be.getIdBaja();
		try {
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setLong(1, be.getIdBaja());
			java.sql.Date fechaSQL = java.sql.Date.valueOf(be.getFechaInicio());
			pstmt.setDate(2, fechaSQL);
			java.sql.Date fechaSQL1 = java.sql.Date.valueOf(be.getFechaFin());
			pstmt.setDate(3, fechaSQL1);
			pstmt.setString(4, be.getMotivoBaja());
			pstmt.setLong(5, be.getIdEmpleado());
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
	public boolean eliminar(BajaEmpleado be) {
		boolean ret = true;
		Connection conex = ConexBD.establecerConexion();
		String consultaInsertStr = "delete FROM bajaempleado WHERE id=" + be.getIdBaja();
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
