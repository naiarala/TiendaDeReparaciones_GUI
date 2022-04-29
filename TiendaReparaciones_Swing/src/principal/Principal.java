package principal;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import entidades.BajaEmpleado;
import entidades.Cliente;
import entidades.Envio;
import entidades.Equipo;
import entidades.Servicio;
import utils.Datos;

public class Principal {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		boolean subMenuValido = false;
//entidades.Empleado.bajas(args);

		boolean menuValido = false;
		int menu = -1;

		do {
			utils.Menu.mostrarMenuPrincipal();
			menu = teclado.nextInt();

			menuValido = (menu < 0 || menu > 4 ? false : true);
			if (!menuValido) {
				System.out.println("Opcion invalida, intente de nuevo empanao");
			}

			switch (menu) {
			case 1:
				menuClientes();
				menuValido = false;

				break;
			case 2:
				menuServicios();
				menuValido = false;

				break;
			case 3:
				menuEquipos();
				menuValido = false;

				break;
			case 4:
				menuTarea4();
				menuValido = false;
				break;

			case 0:
				menuValido = true;
				break;

			}
		} while (!menuValido);
		System.out.println("Guardando datos y cerrando el programa, Taluego.");

	}

	public static void menuClientes() {
		Scanner teclado = new Scanner(System.in);
		int subMenuClientes = -1;
		boolean subMenuValidoClientes = false;
		do {
			utils.Menu.mostrarMenuClientes();
			subMenuClientes = teclado.nextInt();

			subMenuValidoClientes = (subMenuClientes < 0 || subMenuClientes > 3 ? false : true);
			if (!subMenuValidoClientes) {
				System.out.println("introduce una opcion valida");
			}

			switch (subMenuClientes) {
			case 1:
				/* Ver Clientes */
				// imprimimos cuantos hay en la clase Datos.

				Cliente[] clientesDb = utils.Datos.CLIENTES;
				System.out.println(
						"-------------------------------------------------------------------------------------");
				System.out.println("Hay " + utils.Datos.numClientes + " clientes en el sistema.");
				System.out.println(
						"-------------------------------------------------------------------------------------");
				// for para imprimir cada cliente
				for (Cliente i : clientesDb)
					System.out.println("ID: " + i.getIdCliente() + " Nombre: " + i.getNombre() + " NIF:" + i.getNif());
				System.out.println(
						"-------------------------------------------------------------------------------------");
				subMenuValidoClientes = false;
				break;
			case 2:
				System.out.println("nuevo Clientes");
				Cliente c = new Cliente();
				c = Cliente.nuevoCliente();
				System.out.println(c);
				subMenuValidoClientes = false;
				break;
			case 3:
				System.out.println("buscar Clientes");
				// buscar clientes
				// Utils.Buscador.buscarClientes;
				subMenuValidoClientes = false;
				break;
			case 0:
				subMenuValidoClientes = true;
				System.out.println("Volviendo...\n");
				return;
			}
		} while (!subMenuValidoClientes);

	}

	public static void menuEquipos() {
		Scanner teclado = new Scanner(System.in);
		int subMenuEquipos = -1;
		boolean subMenuValidoEquipos = false;

		do {
			utils.Menu.mostrarMenuEquipos();
			subMenuEquipos = teclado.nextInt();

			// Validador de opcion
			subMenuValidoEquipos = (subMenuEquipos < 0 || subMenuEquipos > 3 ? false : true);
			if (!subMenuValidoEquipos) {
				System.out.println("introduce una opcion valida");
			}

			switch (subMenuEquipos) {
			case 1:
				Equipo[] equiposDb = utils.Datos.EQUIPOS;
				System.out.println(
						"-------------------------------------------------------------------------------------");
				System.out.println("Hay " + utils.Datos.numClientes + " Equipos en el sistema.");
				System.out.println(
						"-------------------------------------------------------------------------------------");
				for (Equipo e : equiposDb)
					System.out.println("ID: " + e.getIdEquipo() + " Nombre: " + e.getModelo() + " Precio del equipo: "
							+ e.getPrecio() + "€");
				System.out.println(
						"-------------------------------------------------------------------------------------");
				subMenuValidoEquipos = false;
				break;
			case 2:
				System.out.println("Nuevo equipo");
				Equipo e = new Equipo();
				e = Equipo.nuevoEquipo();
				System.out.println(e);
				subMenuValidoEquipos = false;
				break;
			case 3:
				System.out.println("Buscar equipos");
				// Utils.Buscador.buscarEquipos;
				subMenuValidoEquipos = false;
				break;
			case 0:
				subMenuValidoEquipos = true;
				System.out.println("Volviendo...");
				return;
			}
		} while (!subMenuValidoEquipos);
	}

	public static void menuServicios() {
		Scanner teclado = new Scanner(System.in);
		int subMenuServicios = -1;
		boolean subMenuValidoServicios = false;

		// primero hay que seleccionar al cliente para hacer la llamada al constructor
		// que tiene cliente llamado nuevoServicio

		do {
			utils.Menu.mostrarMenuServicios();
			subMenuServicios = teclado.nextInt();

			// Validador de opcion
			subMenuValidoServicios = (subMenuServicios < 0 || subMenuServicios > 3 ? false : true);
			if (!subMenuValidoServicios) {
				System.out.println("introduce una opcion valida");
			}

			switch (subMenuServicios) {
			case 1:
				/* Nueva Compra */
				String c = "c";
				Servicio servicioCompra = Servicio.nuevoServicio(c);
				subMenuValidoServicios = false;
				break;
			case 2:
				/* Nueva Reparacion */
				String m = "m";
				Servicio servicioReparacion = Servicio.nuevoServicio(m);
				subMenuValidoServicios = false;
				break;
			case 3:
				System.out.println("nuevo Envio");
				Envio en = new Envio();
				en = Envio.nuevoEnvio();
				subMenuValidoServicios = false;
				break;
			case 0:
				subMenuValidoServicios = true;
				System.out.println("Volviendo...");
				return;
			}
		} while (!subMenuValidoServicios);

	}

	@SuppressWarnings("unchecked")
	private static void menuTarea4() {
		Scanner teclado = new Scanner(System.in);
		int subMenuTarea = -1;
		boolean subMenuValTarea = false;

		do {
			utils.Menu.mostrarTarea4();
			subMenuTarea = teclado.nextInt();

			// Validador de opcion
			subMenuValTarea = (subMenuTarea < 0 || subMenuTarea > 7 ? false : true);
			if (!subMenuValTarea) {
				System.out.println("introduce una opcion valida");
			}

			switch (subMenuTarea) {
			case 1:
				// Exportar un objeto de esa clase (todos sus datos imprescindibles para una
				// carga ligera) hacia un fichero de texto (con el formato/orden marcado en el
				// método data()).
				System.out.println("Guardando datos en BajaEmpleadotexto.txt...");

				File fOut1 = new File("BajaEmpleadotexto.txt");
				FileWriter fw1 = null;
				BufferedWriter bw1 = null;
				try {
					fw1 = new FileWriter(fOut1);
					bw1 = new BufferedWriter(fw1);
					for (int i = 0; i < Datos.numBajasEmpleados; i++) {
						BajaEmpleado be = new BajaEmpleado();
						be = Datos.BAJAEMPLEADOS[i];
						bw1.write(be.data() + "\n");
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (bw1 != null)
							bw1.close();
						if (fw1 != null)
							fw1.close();

					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				subMenuValTarea = false;
				break;
			case 2:
				// Exportar una colección de objetos de esa clase hacia un fichero de texto.
				System.out.println("Guardando datos en ClientesChar.txt...");

				File fOut = new File("ClienteChar.txt");
				FileWriter fw = null;
				BufferedWriter bw = null;
				ArrayList<BajaEmpleado> arrayList1 = new ArrayList<BajaEmpleado>();

				BajaEmpleado baja2 = new BajaEmpleado(1,
						LocalDate.parse("08/02/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "tobllo", 2);

				arrayList1.add(baja2);
				BajaEmpleado baja3 = new BajaEmpleado(1,
						LocalDate.parse("08/02/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "dedo", 2);

				arrayList1.add(baja3);

				for (BajaEmpleado b : arrayList1) {

					System.out.println(b.getMotivoBaja());

				}
				System.out.println("Datos que vamos a escribir en el fichero:");
				for (int i = 0; i < 5; i++) {
					// BajaEmpleado newBajaEmpleado = new BajaEmpleado(i, null, "MotivoBaja" + i,
					// i);// long idBaja,LocalDate, fechaFin, String motivoBaja, long idEmpleado
					arrayList1.add(new BajaEmpleado(i, null, "MotivoBaja" + i, i));
					System.out.println("arrayList1[" + i + "]" + arrayList1.get(i));
				}
				try {
					System.out.println("Guardando ArrayList en el fichero bajaempleados....");

					fw = new FileWriter(fOut);
					bw = new BufferedWriter(fw);
					for (int i = 0; i < Datos.numClientes; i++) {
						Cliente c = new Cliente();
						c = Datos.CLIENTES[i];
						bw.write(c.data() + "\n");
					}

					File fOutb = new File("bajaempleados.txt");
					FileWriter fwb = new FileWriter(fOutb);
					BufferedWriter bwb = new BufferedWriter(fwb);

					for (BajaEmpleado b : arrayList1) {

						bwb.write(b.data());
						bwb.newLine();

					}
					if (bwb != null)
						bwb.close();
					if (fwb != null)
						fwb.close();

					/*
					 * ObjectOutputStream escribiendoFichero = new ObjectOutputStream( new
					 * FileOutputStream("bajaempleados.txt"));
					 * escribiendoFichero.writeObject(arrayList1); escribiendoFichero.close();
					 * System.out.println("Leyendo ArrayList del fichero bajaempleados.dat...");
					 * ObjectInputStream leyendoFichero = new ObjectInputStream(new
					 * FileInputStream("bajaempleados.dat")); leyendoFichero.readObject();
					 * leyendoFichero.close(); System.out.println("Datos del fichero leídos.");
					 */

				} catch (IOException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();

				} finally {
					try {
						if (bw != null)
							bw.close();
						if (fw != null)
							fw.close();
					} catch (Exception e) {
						System.out.println(e.getMessage());
						e.printStackTrace();

					}
				}

				subMenuValTarea = false;
				break;
			case 3:
				// Exportar un objeto de esa clase hacia un fichero binario
				System.out.println("Guardando datos en clientesbyte.dat...");
				File f;
				FileOutputStream fos = null;
				ObjectOutputStream oos = null;

				try {
					try {

						f = new File("clienteByte.dat"); // creo el archivo
						fos = new FileOutputStream(f); // se lo paso a fos para escribir
						oos = new ObjectOutputStream(fos);// se lo paso a oos para que pueda escribir

						// oos.writeObject(new Cliente(00006, "facu", "58427904S", "calle rio pilonia",
						// "634164170"));
						oos.writeObject((Cliente)Datos.CLIENTES[1]);
						oos.flush();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						try {
							if (oos != null)
								oos.close();
							if (fos != null)
								fos.close();
						} catch (IOException e) {
							e.printStackTrace();
						}

					}

					f = new File("BajaEmpleadoByte.dat");
					fos = new FileOutputStream(f);
					oos = new ObjectOutputStream(fos);

					oos.writeObject((BajaEmpleado)Datos.BAJAEMPLEADOS[1]);
					oos.flush();

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (oos != null)
							oos.close();
						if (fos != null)
							fos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}

				}

				subMenuValTarea = false;
				break;
			case 4:
				// Exportar una colección de objetos de esa clase hacia un fichero binario.
				// facu
				System.out.println("Guardando datos en clientesbyte.dat...");
				File f4;
				FileOutputStream fos4 = null;
				ObjectOutputStream oos4 = null;
				try {
					try {

						f4 = new File("clienteByte.dat"); // creo el archivo
						fos4 = new FileOutputStream(f4); // se lo paso a fos para escribir
						oos4 = new ObjectOutputStream(fos4);// se lo paso a oos para que pueda escribir
						// oos.writeObject(new Cliente(00006, "facu", "58427904S", "calle rio pilonia",
						// "634164170"));
						// oos.writeObject(new Cliente(00001, "Luis", "43256743G", "Gijon",
						// "942779900"));
						for (int i = 0; i < Datos.numClientes; i++) {
							Cliente c = new Cliente();
							c = Datos.CLIENTES[i];
							oos4.writeObject(c);
						}
						// cargo un cliente mas para pruebas
						oos4.writeObject(new Cliente(00006, "facu", "58427904S", "calle rio pilonia", "634164170"));

					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						try {
							if (oos4 != null)
								oos4.close();
							if (fos4 != null)
								fos4.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					f4 = new File("bajaempleado.dat");
					fos4 = new FileOutputStream(f4);
					oos4 = new ObjectOutputStream(fos4);
					for (int i = 0; i < Datos.numBajasEmpleados; i++) {
						BajaEmpleado be = new BajaEmpleado();
						be = Datos.BAJAEMPLEADOS[i];
						oos4.writeObject(be);
					}
					// long idBaja, LocalDate fechaFin, String motivoBaja
					oos4.writeObject(new BajaEmpleado(00001,
							LocalDate.parse("08/02/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")), null));
//					oos4.writeObject((BajaEmpleado)Datos.BAJAEMPLEADOS[1]);
//					oos4.flush();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (oos4 != null)
							oos4.close();
						if (fos4 != null)
							fos4.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				subMenuValTarea = false;
				break;
			case 5:
				// Importar una colección de objetos de esa clase desde un fichero de texto.
				System.out.println("Cargando datos de ClienteChar.txt...");
				File fIn = new File("ClienteChar.txt");
				FileReader fr = null;
				BufferedReader br = null;
				File fInb = new File("bajaempleados.txt");
				FileReader frb = null;
				BufferedReader brb = null;

				try {
					fr = new FileReader(fIn);
					br = new BufferedReader(fr);

					frb = new FileReader(fInb);
					brb = new BufferedReader(frb);
					String c;

					for (int i = 0; i < 6; i++) {
						c = (String) br.readLine();
						System.out.println(c);
					}

					System.out.println("Cargando datos de bajaempleados.txt...");

					ArrayList<BajaEmpleado> arrayList2 = new ArrayList<BajaEmpleado>();

					String linea;
					while ((linea = brb.readLine()) != null) {
						// nuevabaja.setIdBaja(Integer.parseInt(linea));
						String[] args = linea.split("\\|");

						arrayList2.add(new BajaEmpleado(Integer.parseInt(args[0]), LocalDate.parse(args[2]), args[3],
								Integer.parseInt(args[4])));

					}

					for (BajaEmpleado baja : arrayList2) {
						System.out.println(baja.data());
					}

				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (br != null)
							br.close();
						if (fr != null)
							fr.close();
						if (brb != null)
							brb.close();
						if (frb != null)
							frb.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				subMenuValTarea = false;
				break;
			case 6:
				// Importar una colección de objetos de esa clase desde un fichero binario
				// facu
				System.out.println("Cargando datos de clienteByte.dat...");
				File ci;
				FileInputStream fis = null;
				ObjectInputStream ois = null;
				try {
					ci = new File("clienteByte.dat");
					fis = new FileInputStream(ci);
					ois = new ObjectInputStream(fis);

					for (int i = 0; i < 6; i++) { // puedo usar Datos.numClientes para el limite pero no contaria el
													// nuevo cliente.
						Cliente c = (Cliente) ois.readObject();
						System.out.println(c.data());
					}
//					Cliente c = (Cliente) ois.readObject();
//					System.out.println(c.data());

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} finally {
					try {
						if (ois != null)
							ois.close();
						if (fis != null)
							fis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				subMenuValTarea = false;
				break;
			case 7:
//				Buscar un elemento de esa clase por su id en un fichero de texto que dispone de una colección de
//				elementos organizados línea a línea acordemente al formato/orden del método data(). En el caso
//				de que sí se encuentre el id se creará un nuevo objeto completo y, mediante la forma de carga ligera,
//				se cargaran los datos sobre el objeto y se devolverá éste al final de la función. En el caso de no
//				encontrar el id en el fichero, el objeto devuelto será nulo

				int id;
				System.out.println("Dime el id de la Bajaempleado:");
				Scanner in = new Scanner(System.in);
				id = in.nextInt();
				try {
					File fInc = new File("bajaempleados.txt");
					FileReader frc = new FileReader(fInc);
					BufferedReader brc = new BufferedReader(frc);

					BajaEmpleado Bajaempleado = null;
					String linea;
					while ((linea = brc.readLine()) != null) {
						// nuevabaja.setIdBaja(Integer.parseInt(linea));
						String[] args = linea.split("\\|");
						if (id == Integer.parseInt(args[0])) {
							Bajaempleado = new BajaEmpleado(Integer.parseInt(args[0]), LocalDate.parse(args[2]),
									args[3], Integer.parseInt(args[4]));
							System.out.println("Mostrar Bajaempleado:" + Bajaempleado.data());

							break;
						}

					}

				} catch (IOException e) {
					e.printStackTrace();
				}

				subMenuValTarea = false;
				break;
			case 0:
				subMenuValTarea = true;
				System.out.println("Volviendo...");
				return;
			}
		} while (!subMenuValTarea);
		teclado.close();
	}
}
