package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import entidades.Lote;
import utils.ConexBD;

public class LoteDAO implements operacionesCRUD<Lote> {

	Connection conex;

	public LoteDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}

	@Override
	public boolean insertarConID(Lote l) {
		boolean ret = false;

		String consultaInsertStr = "insert into lote(idlote, descuento, precioTotal, precioEquipo, idCompra) values (?,?,?,?,?)";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setLong(1, l.getIdLote());
			pstmt.setDouble(2, l.getDescuento());
			pstmt.setDouble(3, l.getPrecioTotal());
			pstmt.setDouble(4, l.getPrecioEquipo());
			pstmt.setLong(5, l.getIdCompra());
			int resultadoInsercion = pstmt.executeUpdate();
			ret = (resultadoInsercion == 1);

		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
		}

		return ret;
	}

	@Override
	public long insertarSinID(Lote l) {
		long ret = -1;

		String consultaInsertStr = "insert into lote(descuento, precioTotal, precioEquipo) values (?,?,?)";

		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setDouble(1, l.getDescuento());
			pstmt.setDouble(2, l.getPrecioTotal());
			pstmt.setDouble(3, l.getPrecioEquipo());
			int resultadoInsercion = pstmt.executeUpdate();
			if (resultadoInsercion == 1) {
				String consultaSelect = "SELECT id FROM lote WHERE (descuento=? AND precioTotal=? AND precioEquipo=?"
						+ "AND idCompra=?)";
				PreparedStatement pstmt2 = conex.prepareStatement(consultaSelect);
				pstmt.setDouble(1, l.getDescuento());
				pstmt.setDouble(2, l.getPrecioTotal());
				pstmt.setDouble(3, l.getPrecioEquipo());
				pstmt.setLong(4, l.getIdCompra());
				ResultSet result = pstmt2.executeQuery();
				while (result.next()) {
					long idLote = result.getLong("id");
					if (idLote != -1) {
						System.out.println("Se ha insertado correctamente el nuevo Lote de id: " + idLote);
						if (conex != null)
							conex.close();
						return idLote;
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
	public Lote buscarPorID(long id) {
		Lote ret = null;
		String consultaInsertStr = "select * FROM lote WHERE id=?";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setLong(1, id);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				long idBD = result.getLong("id");
				Double descuento = result.getDouble("descuento");
				Double precioTotal = result.getDouble("precioTotal");
				Double precioEquipo = result.getDouble("precioEquipo");
				long idCompra = result.getLong("idCompra");
				ret = new Lote();
				ret.setIdLote(idBD);
				ret.setDescuento(descuento);
				ret.setPrecioTotal(precioTotal);
				ret.setPrecioEquipo(precioEquipo);
				ret.setIdCompra(idCompra);
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
	public Collection<Lote> buscarTodos() {
		List<Lote> todos = new ArrayList<>();
		String consultaInsertStr = "select * FROM lote";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				Lote lote;
				long idBD = result.getLong("id");

				lote = new Lote();
				lote.setIdLote(idBD);
				Double descuento = result.getDouble("descuento");
				Double precioTotal = result.getDouble("precioTotal");
				Double precioEquipo = result.getDouble("precioEquipo");
				Long idCompra = result.getLong("idCompra");
				lote.setIdLote(idBD);
				lote.setDescuento(descuento);
				lote.setPrecioTotal(precioTotal);
				lote.setPrecioEquipo(precioEquipo);
				lote.setIdCompra(idCompra);

				todos.add(lote);
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
	public boolean modificar(Lote l) {
		boolean ret = true;
		Connection conex = ConexBD.establecerConexion();
		String consultaInsertStr = "update lote SET descuento=?, precioTotal=?, precioEquipo=?, idCompra=? WHRERE id="
				+ l.getIdLote();
		try {
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setDouble(1, l.getDescuento());
			pstmt.setDouble(2, l.getPrecioTotal());
			pstmt.setDouble(3, l.getPrecioEquipo());
			pstmt.setLong(4, l.getIdCompra());
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
	public boolean eliminar(Lote l) {
		boolean ret = true;
		Connection conex = ConexBD.establecerConexion();
		String consultaInsertStr = "delete FROM lote WHERE id=" + l.getIdLote();
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
