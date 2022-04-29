package utils;

public class Menu {
	public static void mostrarMenuPrincipal() {
		System.out.println("\nMENU PRINCIPAL");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("Que desea hacer?" + "\n");
		System.out.println("1- Gestion de Clientes");
		System.out.println("2- Gestion de Servicios");
		System.out.println("3- Gestion de Equipos");
		System.out.println("4- Tarea 4- Ficheros");
		System.out.println("0- Salir");
		System.out.println("-------------------------------------------------------------------------------------");
	}

	public static void mostrarMenuClientes() {
		System.out.println("\nMENU CLIENTES");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("Que desea hacer?" + "\n");
		System.out.println("1- Ver Cliente/s");
		System.out.println("2- Nuevo Cliente");
		System.out.println("3- Buscar Cliente");
		System.out.println("0- Atrá"
				+ "s");
		System.out.println("-------------------------------------------------------------------------------------");

	}

	public static void mostrarMenuEquipos() {
		System.out.println("\nMENU EQUIPOS");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("Que desea hacer?" + "\n");
		System.out.println("1- Ver Equipo/s");
		System.out.println("2- Nuevo Equipo");
		System.out.println("3- Buscar Equipo/s");
		System.out.println("0- Atrás");
		System.out.println("-------------------------------------------------------------------------------------");
	}

	public static void mostrarMenuServicios() {
		System.out.println("\nMENU SERVICIOS");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("Que desea hacer?" + "\n");
		System.out.println("1- Nueva Compra");
		System.out.println("2- Nueva Reparación");
		System.out.println("3- Nuevo Envío");
		System.out.println("0- Atrás");
		System.out.println("-------------------------------------------------------------------------------------");
	}

	public static void mostrarTarea4() {
		System.out.println("\nMENU TAREA4");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("Que desea hacer?" + "\n");
		System.out.println("1- Exportar un objeto de esa clase hacia un fichero de texto");
		System.out.println("2- Exportar una colección de objetos de esa clase hacia un fichero de texto");
		System.out.println("3-Exportar un objeto de esa clase hacia un fichero binario. ");
		System.out.println("4- Exportar una colección de objetos de esa clase hacia un fichero binario.");
		System.out.println("5- Importar una colección de objetos de esa clase desde un fichero de texto.");
		System.out.println("6- Importar una colección de objetos de esa clase desde un fichero binario. ");
		System.out.println(
				"7- Buscar un elemento de esa clase por su id en un fichero de texto que dispone de una colección. ");
		System.out.println("0- Atras");
		System.out.println("-------------------------------------------------------------------------------------");

	}

}
