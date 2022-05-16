/**
* @author Facu
*/
package entidades;

import java.time.LocalDate;
import java.util.Scanner;

public class Servicio {
	protected long idServicio;
	private String notas;
	private LocalDate fecha;
	protected double precioTotal; // HAY Q BORRARLO; LEER LOS REQUISITOS
	/* Para relacion 1-N con Cliente */
	protected Cliente idCliente;

	/* constructores */
	public Servicio() {
		super();
	}

	public Servicio(long idServicio, Cliente idCl, String notas, LocalDate fecha, double precioTotal) {
		this.notas = notas;
		this.fecha = fecha;
		this.precioTotal = precioTotal;
		this.idServicio = idServicio;
		this.idCliente = idCl;
	}

	

	public Servicio(long idServicio, double precioTotal) {
		super();
		this.idServicio = idServicio;
		this.precioTotal = precioTotal;
	}

	public static Servicio nuevoServicio(String s) {
		/* instancia del teclado */
		Scanner teclado = new Scanner(System.in);

		// preguntar al usuario si quiere usar un cliente ya registrado o crear uno
		// nuevo y guardar el id del Cliente en la variable idCliente en servicios.

		/* nueva instancia de Servicio */
		Servicio ret = new Servicio();

		// comprobamos si el servicio es una compra o un mantenimiento.
		if (s == "c") {
			Compra c = new Compra();
			c = Compra.nuevaCompra();
		} else if (s == "m") {
			Mantenimiento m = new Mantenimiento();
			m = Mantenimiento.nuevoMantenimiento();
		}

		System.out.println("Desea agregar notas?: ");

		System.out.println("Notas: ");
		String notasServ = " ";
		notasServ = teclado.nextLine();
		ret.setNotas(notasServ);

		/*
		 * hay que introducir el precio del servicio ya que por ejemplo un mantenimiento
		 * no se puede calcular el precio.
		 */
		System.out.println("Precio Total: ");
		double precioTotal = 0.0;
		precioTotal = teclado.nextDouble();
		ret.setPrecioTotal(precioTotal);
		/*
		 * hay que esperar a que luis explique como se inicializa, ahora mismo devuelve
		 * null con o sin esta linea
		 */
//		LocalDate fechaToday = null;
//		fechaToday = Utilidades.Fechas();
//		ret.setFechaToday(fechaToday);
		teclado.close();
		return ret;
	}

	/**
	 * @return orden: id Servicio + id Cliente + notas + fecha + Precio Total
	 * @author Facu
	 */
	public String data() {
		String ret = "";
		ret = this.idServicio + "|" + this.idCliente + "|" + this.notas + "|" + this.fecha + "|" + this.precioTotal;
		return ret;
	}

	/* Getters, setters y to string */
	public long getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public Cliente getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}

	@Override
	public String toString() {
		return "Servicio [idServicio=" + idServicio + ", notas=" + notas + ", fecha=" + fecha + ", precioTotal="
				+ precioTotal + ", idCliente=" + idCliente + "]";
	}

}
