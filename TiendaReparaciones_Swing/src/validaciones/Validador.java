
package validaciones;

import java.util.Scanner;

/*
 * Clase Validador:
 * Para validar las variables del cliente y empleado, interesa que sea publico y
 * no privado para poder utilizarlo en otros lados del codigo
 * 
 */
public class Validador {

	/**
	 * 
	 * @param id
	 * @return
	 * @author Facu
	 */
	public static boolean validarId(long id) {
		/* id tiene q ser mayor que 0 */
		if (id > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param nombre
	 * @return
	 * @author Facu
	 */
	public static boolean validarNombre(String nombre) {
		boolean checkStatusNombre = false;
		if (nombre != null) {
			/* 1. Condicion: que la letra inicial sea mayuscula */
			boolean letraMayuscula = Character.isUpperCase(nombre.charAt(0));

			/* 2. Condicion: que el tamanio sea >= 3 y <= 25 */
			int largoNombre = nombre.length();
			boolean tamValido = (largoNombre >= 3 && largoNombre <= 25);

			/* 3.Condicion: que contenga al menos un espacio */
			boolean tieneEspacio = nombre.contains(" ");

			/* Verificamos que las tres condiciones son verdaderas */
			checkStatusNombre = ((letraMayuscula == true) && (letraMayuscula && tamValido && tieneEspacio));
		}
		return checkStatusNombre;
	}

	/**
	 * 
	 * @param nif
	 * @return
	 * @author Facu
	 */
	public static boolean validarNif(String nif) {
		boolean checkStatusNif = false;
		if (nif != null) {
			/*
			 * 1. condicion: que el largo del nif sea de 9 caracteres (8 numeros + 1 letra)
			 * y mas de 1
			 */
			int tamString = nif.length();
			boolean tamValido = (tamString >= 1 && tamString <= 9);
			/* verificamos que tamValido del nif es de 9 */
			checkStatusNif = tamValido == true;
		}
		return checkStatusNif;
	}

	/**
	 * 
	 * @param direccion
	 * @return
	 * @author Facu
	 */
	public static boolean validarDir(String direccion) {
		/* 1.Condicion: que tenga mas de 1 caracter y igual o menos de 40 */
		if (direccion.length() < 5)
			return false;
		if (direccion.length() > 40)
			return false;
		return true;
	}

	/**
	 * 
	 * @param telefono
	 * @return
	 * @author Facu
	 */
	public static boolean validarTel(String telefono) {
		/*
		 * 1.Condicion: el telefono tiene que tener minimo 9 numeros con caracteristica,
		 * un numero extranjero puede tener mas de 9 numeros, por eso no se pone un
		 * limite maximo. Ej: 634 16 54 85
		 */
		if (telefono.length() > 9)
			return false;
		return true;
	}

	/**
	 * 
	 * @param tarjeta
	 * @return
	 * @author Facu
	 */
	public static boolean validarTarjeta(String tarjeta) {
		/* 1.Condicion: contara con 16 caracteres obligatoriamente */
		if (tarjeta.length() == 17)// si pongo 16 solamente se puede poner 15 caracteres
			return false;
		return true;
	}

	public static boolean ValidarCuentaCorriente(String cuentaCorriente) {
		/*
		 * 1.condicion comprobar que las 2 primeros caracteres sean letras(pais y codigo
		 * de verificacion)
		 */

		/* 2.condicion: que contenga 20 numeros luego de los primeros 4 caracteres */

		return true;
	}

	/**
	 * 
	 * @param metodoPago
	 * @return
	 * @author Martin
	 */
	public static boolean validarMetodoDePago(char metodoPago) {
		char efectivo = 'e';
		char tarjeta = 't';
		if (metodoPago != efectivo)
			return false;
		if (metodoPago != tarjeta)
			return false;
		return true;
		/*
		 * 1. Condicion: pago en efectivo o tarajeta(un caracter unicamente, E o T)
		 * 
		 */
	}

	/**
	 * 
	 * @param precioTotal
	 * @return
	 * @author Martin
	 */

	public static boolean validarPrecio(double precioTotal) {
		if (precioTotal > 0)
			return false;

		return true;

		/*
		 * 1. Condicion: secuencia numerica expresado con puntos y comas 2. no se
		 * permiten caracteres especiales
		 */

	}

	/**
	 * 
	 * @param modelo
	 * @return
	 * @author Martin
	 */
	public static boolean validarModelo(String modelo) {
		boolean tamValido = false;
		// Condicion: que el tamanio sea >= 1 y <= 40
		if (modelo != null) {
			int largoNombre = modelo.length();
			tamValido = (largoNombre >= 1 && largoNombre <= 40);
		}
		return true;

	}
	
	/**
	 * 
	 * @param descuento
	 * @return
	 * @author Naiara
	 */
	public static boolean validarDescuento(double descuento, double precioTotal) {

		if (descuento >= 0 && descuento <= precioTotal)
			return true;
		else
			return false;

	}

	/**
	 * 
	 * @param direccionE1
	 * @return
	 * @author Naiara
	 */
	
	public static boolean validardireccion(String direccionE1) {
		Scanner in = new Scanner(System.in);
		String cadena ="";
		while (!cadena.isEmpty()) {
			System.out.println("Introduzca la cadena a comprobar (Cadena vacia = FIN):");
			cadena = in.nextLine();
			if(validardireccion(cadena))
				System.out.println("La cadena SOLO contiene letras\n");
			else
				System.out.println ("La cadena tiene caracteres que NO son letras\n");
		}
		System.out.println("\n\t\tFIN DE PROGRAMA");
		in.close();
		return false;
	}
 



	/**
	 * 
	 * @param telefonoE1
	 * @return
	 * @author Naiara
	 */
//	  1.Condición: no debe de tener mas de 9 numeros
//	  2.Condicion: el telefono debe estar formado unicamente por numeros


	public static boolean validadortelefono(String telefonoE1) {
		boolean ret = false;

		if (telefonoE1.length() != 9)
			return false;
		if (telefonoE1.trim().chars().allMatch(Character::isDigit))
			return false;

		return ret;
	}
}
