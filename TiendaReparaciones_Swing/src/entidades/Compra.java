 /**
 * @author Facu
 */
//hace martins
package entidades;

import java.util.Scanner;

import utils.Utilidades;

public class Compra extends Servicio{

	private long idCompra;
	// idEquipo es el identificador del elemento compra
	// valor entero > 0
	// y valor por defecto 0
	private char metodoDePago;
	// metodoDePago expresa la modalidad de dicho pago
	// se expresa en caracteres// se puede introducir "e" para efectivo y "t" para
	// tarjeta
	protected double precioTotal;
	// indica el computo total del precio de equipo
	// expresado en numero reales con simbolos de puntuacion

	protected Servicio s;
	
	protected Equipo e;
	protected Lote l;

	/* Constructores */
	public Compra() {
		super();
	}

	private Compra(Servicio s ,long idCompra, char metodoDePago, double precioTotal) {
		this.idCompra = idCompra;
		this.metodoDePago = metodoDePago;
		this.precioTotal = precioTotal;
		this.s= s;
	}
//Equipo y lote
	private Compra(Servicio s,long idCompra, char metodoDePago, double precioTotal, Equipo e, Lote l) {
		this.idCompra = idCompra;
		this.metodoDePago = metodoDePago;
		this.precioTotal = precioTotal;
		this.e = e;
		this.l = l;
		this.s= s;

	}
//solo lote
	private Compra(Servicio s,long idCompra, char metodoDePago, double precioTotal, Lote l) {
		this.idCompra = idCompra;
		this.metodoDePago = metodoDePago;
		this.precioTotal = precioTotal;
		this.l = l;
		this.s= s;

	}
//solo Equipo
	private Compra(Servicio s,long idCompra, char metodoDePago, double precioTotal, Equipo e) {
		this.idCompra = idCompra;
		this.metodoDePago = metodoDePago;
		this.precioTotal = precioTotal;
		this.e = e;
		this.s= s;

	}

	/**
	 * Pregunta al usurio el tipo de pago(e o t), crea una lista(array) con los id
	 * de los equipos o los lotes de la compra y calcula el precio total solo desde
	 * los precios de los equipos y aplica los descuentos de los lotes.
	 * 
	 * @return Devuelve un objeto del tipo compra que contiene un array de los
	 *         equipos y lotes
	 * @author Facu
	 */
	public static Compra nuevaCompra() {
		/* instancia para el teclado */
		Compra ret = new Compra();
		Scanner teclado = new Scanner(System.in);

		System.out.println("Introduce los siguientes datos para registrar una nueva Compra \n");
		boolean tipoPago = false;

		System.out.println("Metodo de pago: (e para efectivo, t para tarjeta)");
		tipoPago = Utilidades.leerPago();

		// aca tiene q crearse el array y llamar a una funcion que sea capaz de devolver
		// objetos del tipo equipo o lote para que los
		// guarde en el array recien creado

		// obtinee los precio de los equipos y los suma en una variable llamada
		// precioTotal

		// se obtiene el modelo del equipo del lote para obtener el precio y
		// multiplicarlo por la cantidad del lote y se guarda
		// en una variable llamada precioTotalLote, y se realiza el descuento que tiene
		// el lote al precio total del lote.

		// por ultimo se suma precioTotal con precioTotalLote.

		return ret;
	}
	
	/**
	 * @return Orden: idCompra + id Cliente + metodoDePago + Precio Total
	 * @author Facu
	 */
	public String data() {
		String ret = "";
		ret = this.idCompra + "|" + this.idCliente + "|" + this.metodoDePago + "|" + this.precioTotal + "|" ;
		return ret;
	}

	//// Getters , setters and to string
	public long getIdEquipo() {
		return idCompra;
	}

	public void setIdEquipo(long idEquipo) {
		this.idCompra = idEquipo;
	}

	public char getMetodoDePago() {
		return metodoDePago;
	}

	public void setMetodoDePago(char metodoDePago) {
		this.metodoDePago = metodoDePago;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	// to string
	@Override
	public String toString() {
		return "Compra [idCompra=" + idCompra + ", metodoDePago=" + metodoDePago + ", precioTotal=" + precioTotal + "]";
	}

}
