package utils;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

import entidades.BajaEmpleado;
import entidades.Cliente;
import entidades.Empleado;
import entidades.EmpleadoSustituto;
import entidades.Equipo;
import entidades.Reparacion;

/*Almacenar� diferentes arrays de datos v�lidos para ser manejados desde una funci�n
principal. Cada clase dispondr� de un array propio con varios elementos v�lidos de esa clase, y que
ser� static y final. 
*/
public class Datos {
	/*
	 * public Cliente(String nombre, String nif, String direccion, String telefono)
	 * Facu.
	 */

	public static final Cliente CLIENTES[] = { new Cliente(00001, "Luis", "43256743G", "Gijon", "942779900"),
			new Cliente(00002, "Ana", "12345678T", "Madrid", "912331188"),
			new Cliente(00003, "Bruno", "84738925N", "Barcelona", "932432245"),
			new Cliente(00004, "Carla", "57390576B", "Santander", "975073211"),
			new Cliente(00005, "Ramona", "71263894K", "Valencia", "942779900") };
	public static final int numClientes = CLIENTES.length;

	/*
	 * public Reparacion(long id, double horasTrabajadas) Facu.
	 */

	public static final Reparacion REPARACIONES[] = { new Reparacion(000000000001, "2.27"),
			new Reparacion(000000000002, "3.40"), new Reparacion(000000000003, "1.04"),
			new Reparacion(000000000004, "5.30") };
	public static final int numReparaciones = CLIENTES.length;

	/**
	 * public Equipo(long idEquipo, double precio, String modelo) Facu.
	 */
	public static final Equipo EQUIPOS[] = { new Equipo(0000001, 12.23, "cosas missticas"),
			new Equipo(0000002, 360.99, "Ipad-o Pro"), new Equipo(0000003, 1000.99, "MacBookoto Pro 10.5"),
			new Equipo(0000004, 599.99, "Xbot Serie T") };
	public static final int numEquipos = EQUIPOS.length;

	/*
	 * public Empleado (long idEmpleado, String nombre, String apellidos, String
	 * direccion, String telefono, String nif) Naiara
	 */
	public static final Empleado EMPLEADOS[] = {
			new Empleado(00001, "Pedro", "Garcia Perez", "Gijon", "624550212", "35216844P"),
			new Empleado(00002, "Alba", "Lopez Fernandez", "Gijon", "604755298", "24209830A"),
			new Empleado(00003, "Sara", "Alvarez Garcia", "Gijon", "687164711", "39439855S"),
			new Empleado(00004, "Manuel", "Perez Cuevas", "Gijon", "654775478", "22579632M") };
	public static final int numEmpleados = EMPLEADOS.length;

	/*
	 * public BajaEmpleado(long idBaja, LocalDate fechaFin, String motivoBaja)
	 * Naiara
	 */
	public static final BajaEmpleado BAJAEMPLEADOS[] = {
			new BajaEmpleado(00001, LocalDate.parse("08/02/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
					"Accidente laboral"),
			new BajaEmpleado(00002, LocalDate.parse("02/02/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
					"Accidente laboral"),
			new BajaEmpleado(00003, LocalDate.parse("12/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
					"Accidente laboral"),
			new BajaEmpleado(00004, LocalDate.parse("08/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
					"Accidente Laboral"),
			new BajaEmpleado(00005, LocalDate.parse("22/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
					"Accidente Laboral") };
	public static final int numBajasEmpleados = BAJAEMPLEADOS.length;

	/*
	 * public EmpleadoSustituto(long idEmpleado, String nombre, String apellido,
	 * String direccion, String telefono, String nif, String edad, boolean
	 * colectivo, BajaEmpleado baja) super(idEmpleado, nombre, apellido, direccion,
	 * telefono, nif)
	 *  Naiara
	 */
//	public static final int EmpleadoSustituto EMPLEADOSUSTITUTO[]= {
//		new EmpleadoSustituto(00001, "Pedro", "Garcia Perez", "Gijon", "624550212", "35216844P", "32", true, entidades.BajaEmpleado),
//	}

	/*
	 * public Lote(long idLote, double descuento, double precioTotal, double
	 * precioEquipo) Naiara
	 */

}
