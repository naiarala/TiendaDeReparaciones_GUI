package utils;

import java.util.Scanner;

import entidades.Cliente;

public class Buscador {

	/**
	 * Metodo el cual es capaz de buscar clientes con los siguientes filtros que el
	 * usuario desee: por nombre, por nif, por telefono y por id
	 * 
	 * @author Facu
	 */
	public static void buscarClientes() {
		System.out.println("Ha seleccionado Buscador de Clientes");
		Scanner teclado = new Scanner(System.in);
		boolean validar = false;
		boolean nombreSi = false;
		boolean nifSi = false;
		boolean telefonoSi = false;
		boolean idSi = false;

		do {
			// Se pregunta al usuario que filtros quiere aplicar al hacer la busqueda
			System.out.println("Seleccione qu� tipo de Clientes quiere filtar: \n");

			System.out.println("�Desea buscar por nombre?");
			nombreSi = Utilidades.leerBoolean();
			System.out.println("�Desea buscar por nif?");
			nifSi = Utilidades.leerBoolean();
			System.out.println("�Desea buscar por telefono?");
			telefonoSi = Utilidades.leerBoolean();
			System.out.println("�Desea buscar por id?");
			idSi = Utilidades.leerBoolean();

			validar = nombreSi || nifSi || telefonoSi || idSi;// comprueba que al menos se selecciono un filtro
			if (!validar) {
				System.out.println("ERROR: Debe seleccionar al menos un filtro para aplicar.");
				continue;
			}
			System.out.print("Ha seleccionado los filtros de: " + (nombreSi ? "nombre," : " ") + (nifSi ? "nif " : " ")
					+ (telefonoSi ? "telefono" : " ") + (idSi ? "id" : " "));
			System.out.println("\n�Es correcto?");
			validar = Utilidades.leerBoolean();
		} while (!validar);

		// Guardo el nombre
		if (nombreSi) {
			boolean nombreValido = false;
			String nombre;
			do {
				System.out.println("Introduzca el nombre que desea buscar: ");
				nombre = teclado.nextLine();
				nombreValido = validaciones.Validador.validarNombre(nombre);
				if (!nombreValido)
					System.out.println("ERROR: el nombre introducido no es valido.");
			} while (!nombreValido);
		}

		// guardo el nif
		if (nifSi) {
			boolean nifValido = false;
			String nif;
			do {
				System.out.println("Introduzca el nif que desea buscar: ");
				nif = teclado.nextLine();
				nifValido = validaciones.Validador.validarNif(nif);
				if (!nifValido)
					System.out.println("ERROR: el nif introducido no es valido. ");
			} while (!nifValido);
		}

		// guardo el telefono
		if (telefonoSi) {
			boolean telefonoValido = false;
			String telefono;
			do {
				System.out.println("Introduzca el nif que desea buscar: ");
				telefono = teclado.nextLine();
				telefonoValido = validaciones.Validador.validarTel(telefono);
				if (!telefonoValido)
					System.out.println("ERROR: el telefono introducido no es valido. ");
			} while (!telefonoValido);
		}

		// guardo el id
		if (idSi) {
			boolean idValido = false;
			long id;
			do {
				System.out.println("Introduzca el nif que desea buscar: ");
				id = teclado.nextLong();
				idValido = validaciones.Validador.validarId(id);
				if (!idValido)
					System.out.println("ERROR: el id introducido no es valido. ");
			} while (!idValido);
		}

		/// Ahora hay que hacer un bucle que interactue con un array de Clientes creados
		/// a partir de los datos en la clase Datos, en donde se pregunte primero si el
		/// filtro se applica, si se aplica se recorre el array en comparando lo que
		/// tengo guardado en las variables superiores con cada objeto del tipo persona
		/// en el array.Cuando coincida el cliente con algun filtro, se guarda en un
		/// index
		/// de enteros

		Cliente[] clientesFiltrados = Datos.CLIENTES;
		int nroClientes = Datos.numClientes;

		for (int i = 0; i < nroClientes; i++) {
			if (nombreSi) {

			}
		}

	}
}