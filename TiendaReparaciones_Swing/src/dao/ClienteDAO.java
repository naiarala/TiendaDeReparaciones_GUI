package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import entidades.Cliente;
import utils.ConexBD;
import utils.Datos;

public class ClienteDAO implements operacionesCRUD<Cliente> {

	@Override
	public boolean insertarConID(Cliente c) {
		boolean ret = false;
		Connection conex = ConexBD.establecerConexion();
		String consultaInsertStr = "insert into cliente(idcliente, nombre, nif, direccion, telefono) values (?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);

			pstmt.setLong(1, c.getIdCliente());
			pstmt.setNString(2, c.getNombre());
			pstmt.setNString(3,c.getNif());
			pstmt.setString(4, c.getDireccion());
			pstmt.setString(5, c.getTelefono());

			int resultadoInsercion = pstmt.executeUpdate();
			ret = (resultadoInsercion == 1);
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
		}
		return ret;		
	}

	@Override
	public long insertarSinID(Cliente elemento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Cliente buscarPorID(long id) {
		Cliente ret = null;
		Connection conex = ConexBD.establecerConexion();
		String consultaInsertStr = "select * FROM clientes WHERE id=?";
		try {
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setLong(1, id);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				//(idcliente, nombre, nif, direccion, telefono
				//long idBD = result.getLong("id");
				long idCliente = result.getLong("idcliente");
				String nombre = result.getString("nombre");
				String nif = result.getString("nif");
				String direccion = result.getString("direccion");
				String telefono = result.getString("telefono");

				ret = new Cliente();
				ret.setIdCliente(idCliente);
				
				ret.setTelefono(telefono);
				ret.setDireccion(direccion);
				ret.setPersona(Datos.buscarPersonaPorId(idCliente));
			}
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception:" + e.getMessage());
			e.printStackTrace();
		}
		return ret;		return null;
	}

	@Override
	public Collection<Cliente> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Cliente elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Cliente elemento) {
		// TODO Auto-generated method stub
		return false;
	}

}
