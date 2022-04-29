/**
* @author Facu
*/
package entidades;

import java.io.Serializable;

import java.util.Scanner;

import validaciones.Validador;

public class Cliente implements Serializable {

	private static final long serialVersionUID = 726468236049300212L;
	/* id de cliente, sirve para identificarlo, se autocalcula. */
	private long idCliente;
	/*
	 * nombre representa el nombre de el nuevo cliente, no acepta numeros ni
	 * caracteres especiales, max 25 caracteres.
	 */
	private String nombre;
	/*
	 * nif del cliente, no puede repetirse entre clientes, podria ser clave
	 * secundaria, es obligatorio
	 */
	private String nif;
	private String direccion = "Sin direccion";
	private String telefono = "Sin telefono disponible";
	private String numeroTarjeta;
	private String cuentaCorriente;

	/* Constructores */
	public Cliente() {
	}

	// Para servicio
	public Cliente(String numeroTarjeta, String cuentaCorriente) {
		this.numeroTarjeta = numeroTarjeta;
		this.cuentaCorriente = cuentaCorriente;
	}

	// Para utilizar con la clase Datos
	public Cliente(long idCliente, String nombre, String nif, String direccion, String telefono) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.nif = nif;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public Cliente(String nombre, String nif, String direccion, String telefono) {
		this.nombre = nombre;
		this.nif = nif;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	/**
	 * @return orden: id+nombre+nif+direccion+telefono
	 * @author Facu
	 */
	public String data() {
		String ret = "";
		ret = this.idCliente + "|" + this.nombre + "|" + this.nif + "|" + this.direccion + "|" + this.telefono;
		return ret;
	}

	/**
	 * @return Objeto del tipo cliente completo preguntando si desea el usuario guardar  los datos de tarjeta o cuenta
	 *         corriente
	 * @author Facu
	 */
	public static Cliente nuevoCliente() {
		/* instancia para el teclado */
		Cliente ret = new Cliente();
		Scanner teclado = new Scanner(System.in);

		System.out.println("Introduce los siguientes datos para registrar un Cliente nuevo:" + "\n");
		String nombreCl = "";
		/* para validar el nombre sea correcto, declarado en la clase Validador */
		boolean nombreValido = false;
		do {
			System.out.println(
					"Nombre del cliente: (la primera letra en mayuscula y separando los nombres y apellidos con espacios)");
			nombreCl = teclado.nextLine();
			nombreValido = Validador.validarNombre(nombreCl);
		} while (!nombreValido);
		ret.setNombre(nombreCl);

		String nifCl = "";
		boolean nifValido = false;
		do {
			System.out.println("Nif del cliente: (unicamente 8 numeros y 1 letra)");
			nifCl = teclado.nextLine();
			nifValido = Validador.validarNif(nifCl);
		} while (!nifValido);
		ret.setNif(nifCl);

		String direccionCl = null;
		boolean direccionClValido = false;
		do {
			System.out.println("direccion del cliente: (maximo 40 caracteres y minimo 5)");
			direccionCl = teclado.nextLine();
			direccionClValido = Validador.validarDir(direccionCl);
		} while (!direccionClValido);
		ret.setDireccion(direccionCl);

		String telCl = null;
		boolean telClValido = false;
		do {
			System.out.println("telefono del cliente: (maximo 9 numeros: xxx xx xx xx)");
			telCl = teclado.nextLine();
			telClValido = Validador.validarTel(telCl);
		} while (!telClValido);
		ret.setTelefono(telCl);

		System.out.println("Desea agregar ahora la cuenta o tarjeta del cliente?");
		boolean tarjetaCuenta = utils.Utilidades.leerBoolean();

		if (tarjetaCuenta) {
			String numTarjCl = null;
			boolean numTarjValido = false;
			do {
				System.out.println("Numero de tarjeta del cliente: (16 caracteres incluido el codigo del pais)");
				numTarjCl = teclado.nextLine();
				numTarjValido = Validador.validarTarjeta(numTarjCl);
			} while (!numTarjValido);
			ret.setNumeroTarjeta(numTarjCl);

			String cuentaCorrienteCl = null;
			boolean cuentaCorrienteValida = false;
			do {
				System.out.println("Numero de cuenta del cliente: ");
				cuentaCorrienteCl = teclado.nextLine();
				cuentaCorrienteValida = Validador.ValidarCuentaCorriente(cuentaCorrienteCl);
			} while (!cuentaCorrienteValida);
			ret.setCuentacorriente(cuentaCorrienteCl);
		}

		teclado.close();
		return ret;
	}

	/* Getters , setters y to string */
	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getCuentacorriente() {
		return cuentaCorriente;
	}

	public void setCuentacorriente(String cuentacorriente) {
		cuentaCorriente = cuentacorriente;
	}

	public String getCuentaCorriente() {
		return cuentaCorriente;
	}

	public void setCuentaCorriente(String cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", nif=" + nif + ", direccion=" + direccion
				+ ", telefono=" + telefono + ", numeroTarjeta=" + numeroTarjeta + ", Cuentacorriente=" + cuentaCorriente
				+ "]";
	}

}
