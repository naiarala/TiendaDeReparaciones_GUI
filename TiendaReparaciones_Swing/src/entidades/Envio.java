//implementado por nicolás
package entidades;

import java.util.Scanner;
import java.time.LocalDate;

public class Envio extends Servicio {
	/*
	 * idEnvio es el identificador único de cada elemento Envio, es un atributo
	 * obligatorio ya que todos los envíos tienen identificador, su valor es un
	 * entero > 0
	 */
	private long idEnvio;
	/*
	 * fechaEnvio representa la fecha en la que se realiza el envío, es un atributo
	 * obligatorio ya que todos los envíos se envían en una determinada fecha
	 */
	private LocalDate fechaEnvio = null;
	/*
	 * gratuito indica si el envío será gratuito o no, en base al precio total del
	 * servicio, será false cuando el precio total sea inferior a 100 euros y true
	 * cuando el precio total supere los 100 euros. Es un atributo obligatorio, ya
	 * que para todos los envíos será necesario saber si son o no gratuitos
	 */
	private boolean gratuito = false;
	/*
	 * destino indicará si el envio es provincial (se guardará como una p) o
	 * nacional (se guardará como una o) en caso de ser provincial sumará 20 euros
	 * al precio total del servicio y en caso de ser nacional sumará 50 euros al
	 * precio total del servicio. Es un atributo obligatorio, ya que necesitaremos
	 * saber el destino de todos los envíos
	 */
	private char destino;
	/* id de los empleados repartidores, referencia la relacion 1-N */
	private long idEmpleadoRepartidor;

	public Envio() {
		super();
	}

	public Envio(long idServicio, double precioTotal) {
		super(idServicio, precioTotal);
		this.idEnvio = idEnvio;
		this.fechaEnvio = fechaEnvio;
		this.gratuito = gratuito;
		this.destino = destino;
	}

	public static Envio nuevoEnvio() {
		Scanner teclado = new Scanner(System.in);
		Envio ret = new Envio();

		System.out
				.println("¿El envío es gratuito? Introduce \"true\" en caso afirmativo o \"false\" en caso negativo");
		boolean free = false;
		free = teclado.nextBoolean();
		ret.setGratuito(free);

		System.out.println(
				"¿El envío es provincial o nacional? Introduce \"p\" si es provincial u \"o\" si es nacional");
		char lugar = '\u0000';
		lugar = teclado.nextLine().charAt(0);
		ret.setDestino(lugar);

		return ret;
	}

	public static Envio nuevoEnvioConIdRepartidor() {
		Scanner teclado = new Scanner(System.in);
		Envio ret = new Envio();

		System.out
				.println("¿El envío es gratuito? Introduce \"true\" en caso afirmativo o \"false\" en caso negativo");
		boolean free = false;
		free = teclado.nextBoolean();
		ret.setGratuito(free);

		System.out.println(
				"¿El envío es provincial o nacional? Introduce \"p\" si es provincial u \"o\" si es nacional");
		char lugar = '\u0000';
		lugar = teclado.nextLine().charAt(0);
		ret.setDestino(lugar);

		// aqui se introduciría el id repartidor pero aun no se ha explicado lo de los
		// id

		return ret;
	}

	public long getIdEnvio() {
		return idEnvio;
	}

	public void setIdEnvio(long idEnvio) {
		this.idEnvio = idEnvio;
	}

	public LocalDate getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(LocalDate fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public boolean isGratuito() {
		return gratuito;
	}

	public void setGratuito(boolean gratuito) {
		this.gratuito = gratuito;
	}

	public char getDestino() {
		return destino;
	}

	public void setDestino(char destino) {
		this.destino = destino;
	}

	public long getIdEmpleadoRepartidor() {
		return idEmpleadoRepartidor;
	}

	public void setIdEmpleadoRepartidor(long idEmpleadoRepartidor) {
		this.idEmpleadoRepartidor = idEmpleadoRepartidor;
	}

	@Override
	public String toString() {
		return "Envio [idEnvio=" + idEnvio + ", fechaEnvio=" + fechaEnvio + ", gratuito=" + gratuito + ", destino="
				+ destino + ", idEmpleadoRepartidor=" + idEmpleadoRepartidor + "]";
	}

}