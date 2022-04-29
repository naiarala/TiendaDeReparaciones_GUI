/**
 * @author facu
 */
//hace Martintin
package entidades;

import java.util.Scanner;


import validaciones.Validador;

public class Equipo {

	private long idEquipo;

	private double precio;
	// modelo es la expresion que identifica el modelo de equipo
	// expresado en cadenas de caractere
	private String modelo = "Sin modelo disponible";

	/* Constructores */
	public Equipo() {
	}

	public Equipo(long idEquipo, double precio, String modelo) {
		this.idEquipo = idEquipo;
		this.precio = precio;
		this.modelo = modelo;
	}

	public static Equipo nuevoEquipo() {
		Scanner teclado = new Scanner(System.in);
		Equipo ret = null;
		long id = 0;
		double precio = 0;
		String modelo;
		boolean modeloValido = false;
		boolean precioValido = false;

		do {
			System.out.println("modelo: ");
			modelo = teclado.nextLine();
			modeloValido = Validador.validarModelo(modelo);
		} while (!modeloValido);

		do {
			System.out.println("precio: ");
			precio = teclado.nextDouble();
			precioValido = Validador.validarPrecio(precio);
		} while (!precioValido);

		ret = new Equipo(id, precio, modelo);
		teclado.close();
		return ret;
	}

	/**
	 * @return orden: id + modelo + precio
	 * @author Facu
	 */
	public String data() {
		String ret = "";
		ret = this.idEquipo + "|" + this.modelo + "|" + this.precio;
		return ret;
	}

////Getters , setters and to string
	public long getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(long idEquipo) {
		this.idEquipo = idEquipo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	// to string
	@Override
	public String toString() {
		return "Equipo [idEquipo=" + idEquipo + ", precio=" + precio + ", modelo=" + modelo + "]";
	}
}
