//Facu: ville termino las relaciones de esta clase, yo la empece 
//Naiara: corrige y termina la clase
package entidades;

import java.util.Arrays;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import utils.Datos;
import validaciones.Validador;

public class Empleado {
	// id es el identificador único de cada elemento Usuario.
	// es un valor entero > 0
	// tiene un valor por defecto de 0
	protected long idEmpleado;
	protected String nombre;
	protected String apellidos;
	protected String direccion;
	protected String telefono;
	protected String nif;
	protected String[] bajas = null; // coleccion de elementos

//	public static void bajas(String[] args) {

//		Queue<String> bajas = new PriorityQueue<String>();
//
//		bajas.add("1" + Datos.BAJAEMPLEADOS[0]);
//
//
//
//		bajas.add("3" + Datos.BAJAEMPLEADOS[2]);
//
//		bajas.add("4" + Datos.BAJAEMPLEADOS[3]);
//
//		bajas.add("5" + Datos.BAJAEMPLEADOS[4]);
//
//		System.out.println(bajas.remove());
//		bajas.add("2"+ Datos.BAJAEMPLEADOS[1]);
//		System.out.println(bajas.remove());
//
//		System.out.println(bajas.remove());
//
//		System.out.println(bajas.remove());
//
//		System.out.println(bajas.remove());
//	}

	// Para calcular el id del Usuario
	long numEmpleado = 0;

	// Constructores
	public Empleado() {
		numEmpleado++;
		this.idEmpleado = numEmpleado;
	}

	// Para emplear con la clase de Datos
	public Empleado(long idEmpleado, String nombre, String apellidos, String direccion, String telefono, String nif) {
		numEmpleado++;
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.nif = nif;
	}

	// Para registrar un nuevo Empleado
	public static Empleado newEmpleado() {
		Empleado ret = new Empleado();
		Scanner teclado = new Scanner(System.in);
		String nomE1 = "";
		/*
		 * System.out.
		 * println("Introduzca el nombre del empleado para crear el registro:" + "\n");
		 * String nomE1 = ""; nomE1 = teclado.nextLine(); System.out.println(nomE1);
		 * 
		 * System.out.
		 * println("Introduzca los apellidos del empleado para crear el registro:" +
		 * "\n"); String apellE1 = ""; apellE1 = teclado.nextLine();
		 * System.out.println+(apellE1); return ret;
		 */
		// Para validar el nombre del empleado insertado
		boolean nombreValido1 = false;
		do {
			System.out.println(
					"Nombre del Empleado: (La primera letra debe ir en mayúscula. También debe separar el nombres de los apellidos con un espacio.)");
			nomE1 = teclado.nextLine();
			nombreValido1 = Validador.validarNombre(nomE1);
		} while (!nombreValido1);
		ret.setNombre(nomE1);

		// Para validar la dirección del empleado
		String direccionE1 = "";
		// boolean direccionValida = false;
		boolean direccionValido;
		do {
			System.out.println("Dirección del Empleado: (No puede repetirse. La dirección ha de ser única.)");
			direccionE1 = teclado.nextLine();
			direccionValido = Validador.validardireccion(direccionE1);
		} while (!direccionValido);
		ret.setNif(direccionE1);

		// Para validar el teléfono del empleado
		String telefonoE1 = "";
		// boolean telefonoValida = false;
		boolean telefonoValido;
		do {
			System.out.println(
					"Número de teléfono del Empleado: (No puede repetirse. El número de teléfono ha de ser único.)");
			telefonoE1 = teclado.nextLine();
			telefonoValido = Validador.validadortelefono(telefonoE1);
		} while (!telefonoValido);
		ret.setNif(telefonoE1);

		// Para validar el nif del empleado
		String nifEl = "";
		boolean nifValido = false;
		do {
			System.out.println("NIF del Usuario: (debe estar formado por 8 números y 1 letra al final del mismo.)");
			nifEl = teclado.nextLine();
			nifValido = Validador.validarNif(nifEl);
		} while (!nifValido);
		ret.setNif(nifEl);
		teclado.close();
		return ret;
	}

	public long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String[] getBajas() {
		return bajas;
	}

	public void setBajas(String[] bajas) {
		this.bajas = bajas;
	}

	public long getNumEmpleado() {
		return numEmpleado;
	}

	public void setNumEmpleado(long numEmpleado) {
		this.numEmpleado = numEmpleado;
	}

	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion="
				+ direccion + ", telefono=" + telefono + ", nif=" + nif + ", bajas=" + Arrays.toString(bajas)
				+ ", numEmpleado=" + numEmpleado + "]";
	}
}
