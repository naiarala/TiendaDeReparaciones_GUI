//Naiara
package entidades;

import java.util.Scanner;

public class EmpleadoSustituto extends Empleado {

	private String edad;
	private boolean colectivo;
	private BajaEmpleado baja; // carga de un objeto completo

	/**
	 * Carga ligera: Implementar en esta clase la relación (1-1) que tiene con la
	 * clase Empleado
	 */

	private long idEmpleado; // (clave foránea)

	// private Empleado e;
	public EmpleadoSustituto() {
	}

	public EmpleadoSustituto(long idEmpleado, String nombre, String apellido, String direccion, String telefono,
			String nif, String edad, boolean colectivo, BajaEmpleado baja) {
		super(idEmpleado, nombre, apellido, direccion, telefono, nif);
		this.edad = edad;
		this.colectivo = colectivo;
		this.baja = baja;
	}

	public EmpleadoSustituto(String edad, boolean colectivo, BajaEmpleado baja, long idEmpleado) {
		this.edad = edad;
		this.colectivo = colectivo;
		this.baja = baja;
		this.idEmpleado = idEmpleado;
	}

	// Método nuevoEmpladoSustituto

	public static EmpleadoSustituto newEmpleadoSus() {
		EmpleadoSustituto ret = new EmpleadoSustituto();
		Scanner teclado = new Scanner(System.in);
		System.out.println("edad: ");
		String edad = "0";
		edad = teclado.nextLine();
		ret.setEdad(edad);

		System.out.println("colectivo: ");
		boolean colectivo = false;
		colectivo = teclado.nextBoolean();
		ret.setColectivo(colectivo);

		return ret;
	}

	// getters y setters

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public boolean isColectivo() {
		return colectivo;
	}

	public void setColectivo(boolean colectivo) {
		this.colectivo = colectivo;
	}

	public BajaEmpleado getBaja() {
		return baja;
	}

	public void setBaja(BajaEmpleado baja) {
		this.baja = baja;
	}

	public long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	// toString

	@Override
	public String toString() {
		return "EmpleadoSustituto [edad=" + edad + ", colectivo=" + colectivo + ", baja=" + baja + ", idEmpleado="
				+ idEmpleado + "]";
	}

}
