/**
 * @author Facu
 */
package entidades;

import java.util.Scanner;

public class Reparacion extends Mantenimiento {
	private long idReparacion;
	private String duraciontotal;

	/* Constructores */
	public Reparacion() {
	}

	public Reparacion(long id) {
		this.idReparacion = id;
	}

	public Reparacion(long id, String dt) {
		this.idReparacion = id;
		this.duraciontotal = dt;
	}

	/* Para crear un nuevo registro de reparacion */
	public static Reparacion nuevaReparacion() {
		Reparacion ret = new Reparacion();
		Scanner teclado = new Scanner(System.in);

		System.out.println("Duracion total de la reparacion: ");
		String duracionRep = teclado.nextLine();

		ret.setDuraciontotal(duracionRep);
		return ret;
	}

	/**
	 * @return orden: id reparacion + duracion total
	 * @author Facu
	 */
	public String data() {
		String ret = "";
		ret = this.idReparacion + "|" + this.duraciontotal;
		return ret;
	}

//	/* Funcion que devuelve el mantenimiento a que pertenece la reparacion */
//	public Mantenimiento idReparacion() {
//		for (Mantenimiento m : Datos.REPARACIONES) {
//			for (int i = 0; i < m.getReparacion().size(); i++)
//				if (m.getReparacion().get(i).equals(this))
//					return m;
//		}
//		return null;
//	}

	// getters, setters y to string*/
	public long getIdReparacion() {
		return idReparacion;
	}

	public void setIdReparacion(long idReparacion) {
		this.idReparacion = idReparacion;
	}

	public String getDuraciontotal() {
		return duraciontotal;
	}

	public void setDuraciontotal(String duraciontotal) {
		this.duraciontotal = duraciontotal;
	}

	@Override
	public String toString() {
		return "Reparacion [idReparacion=" + idReparacion + ", duraciontotal=" + duraciontotal + "]";
	}

}
