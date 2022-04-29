//hace martins

//Naiara
package entidades;

import java.util.Scanner;


import validaciones.Validador;

public class Lote {

	private long idLote = 0;
	// idEquipo es el identificador del elemento lote
	// valor entero > 0
	// y valor por defecto 0
	private double descuento = 0;
	// indica el computo que se calcula de un porcentaje de lote
	// expresado en numero reales con simbolos de puntuacion
	protected double precioTotal = 0;
	// indica el computo total del calcula entre descuento y precio de equipo
	// expresado en numero reales con simbolos de puntuacion
	private double precioEquipo;

	/**
	 *  Carga ligera: Implementar en esta clase la relación (1-N) que tiene con la clase Compra
	 */
	
	 private long idCompra; //(clave foránea)

	public Lote() {

	}

	public Lote(long idLote, double descuento, double precioTotal, double precioEquipo) {
		this.idLote = idLote;
		this.descuento = descuento;
		this.precioTotal = precioTotal;
		this.precioEquipo = precioEquipo;
	}
	// Nueva Clase

	public static Lote newLote() {
		Lote Lote = new Lote();
		Scanner teclado = new Scanner(System.in);

		System.out.println("precio: descuento ");
		double descuento = '0';
		descuento = teclado.nextDouble();
		Lote.setDescuento(descuento);

		System.out.println("precioTotal: precio total: secuencia de numeros con puntos y comas");
		double precioTotal = 0;
		precioTotal = teclado.nextDouble();
		Lote.setPrecioTotal(precioTotal);

		boolean descuentoValido = false;
		do {
			System.out.println("Descuento a aplicar");
			descuento = teclado.nextInt();
			descuentoValido = Validador.validarDescuento(descuento, precioTotal);
		} while (!descuentoValido);

		return Lote;

	}

	// Getters , setters and to string
	public long getIdLote() {
		return idLote;
	}

	public void setIdLote(long idLote) {
		this.idLote = idLote;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
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
		return "Lote [idLote=" + idLote + ", descuento=" + descuento + ", precioTotal=" + precioTotal + "]";
	}

}