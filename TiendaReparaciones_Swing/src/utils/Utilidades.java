package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Utilidades {

	/**
	 * Funcion que pide al usuario que introduce un valor para una fecha a partir de
	 * 3 enteros para el dia, mes y anio respectivamente. Si los valores
	 * introducidos no producen una fecha correcta, avisa al usuario y le pide que
	 * los introduzca de nuevo. Si no lo consigue, devolvera null
	 *
	 * @return una fecha de la clase LocalDate o null si hay error
	 */
	public static LocalDate leerFecha() {
		LocalDate ret = null;
		int dia, mes, anio;
		boolean correcto = false;
		Scanner in;
		do {
			System.out.println("Introduzca un valor para el d�a (1...31)");
			in = new Scanner(System.in, "ISO-8859-1");
			dia = in.nextInt();
			System.out.println("Introduzca un valor para el mes (1...12)");
			in = new Scanner(System.in, "ISO-8859-1");
			mes = in.nextInt();
			System.out.println("Introduzca un valor para el a�o");
			in = new Scanner(System.in, "ISO-8859-1");
			anio = in.nextInt();

			try {
				ret = LocalDate.of(anio, mes, dia);
				correcto = true;
			} catch (Exception e) {
				System.out.println("Fecha introducida incorrecta.");
				correcto = false;
			}
		} while (!correcto);
		return ret;
	}

	/**
	 * Funci�n que pide al usuario que introduzca 's' o 'S' para S� o 'n' o 'N' para
	 * No y devuelve true o false en cada caso. Si el usuario no introduce ni 's' ni
	 * 'S' ni 'n' ni 'N' entonces avisa al usuario y le vuelve a pedir a que lo
	 * introduzca de nuevo.
	 *
	 * @return true si el usuario introduce 's' o 'S'; false si el usuario introduce
	 *         'n' o 'N'
	 */
	public static boolean leerBoolean() {
		boolean ret;
		Scanner in;
		char resp;
		do {
			System.out.println("Pulse s para S� o n para No");
			in = new Scanner(System.in, "ISO-8859-1");
			resp = in.nextLine().charAt(0);
			if (resp != 's' && resp != 'S' && resp != 'n' && resp != 'N') {
				System.out.println("Valor introducido incorrecto.");
			}
		} while (resp != 's' && resp != 'S' && resp != 'n' && resp != 'N');
		if (resp == 's' || resp != 'S') {
			ret = true;
		} else {
			ret = false;
		}
		return ret;
	}

	/**
	 * Funcion que pide al usuario que introduzca 'e' o 'E' para Efectivo o 't' o
	 * 'T' para Tarjeta y devuelve true o false en cada caso. Si el usuario no
	 * introduce ninguna letra valida, entonces avisa al usuario y le vuelve a pedir
	 * a que lo introduzca de nuevo.
	 * 
	 * @return true si el usuario introduce 'e' o 'E'; false si el usuario introduce
	 *         't' o 'T'
	 * 
	 * @author Facu
	 */
	public static boolean leerPago() {
		boolean ret;
		Scanner in;
		char resp;
		do {
			System.out.println("Pulse e para Efectivo  o t para Tarjeta");
			in = new Scanner(System.in, "ISO-8859-1");
			resp = in.nextLine().charAt(0);
			if (resp != 'e' && resp != 'E' && resp != 't' && resp != 'T') {
				System.out.println("Valor introducido incorrecto.");
			}
		} while (resp != 'e' && resp != 'E' && resp != 't' && resp != 'T');
		if (resp == 'e' || resp != 'E') {
			ret = true;
		} else {
			ret = false;
		}
		return ret;
	}

}