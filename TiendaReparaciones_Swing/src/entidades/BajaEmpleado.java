//Naiara
package entidades;

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
import java.io.PrintWriter;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import utils.Datos;

public class BajaEmpleado implements Serializable {
	private long idBaja;
	private LocalDate fechaInicio = LocalDate.now();
	private LocalDate fechaFin;
	private String motivoBaja;
	private Empleado em;

	/**
	 * Carga ligera: Implementar en esta clase la relación (1-N) que tiene con la
	 * clase Empleado
	 */

	private long idEmpleado; // (clave foránea)

	public BajaEmpleado(long idBaja, LocalDate fechaFin, String motivoBaja) {
		this.idBaja = idBaja;
		this.fechaFin = fechaFin;
		this.motivoBaja = motivoBaja;
	}

	public BajaEmpleado() {

	}

//	public BajaEmpleado(long idBaja) {
//		this.idBaja = idBaja;
//
//	}

	public BajaEmpleado(long idBaja, LocalDate fechaFin, String motivoBaja, long idEmpleado) {
		this.idBaja = idBaja;
		this.fechaFin = fechaFin;
		this.motivoBaja = motivoBaja;
		this.idEmpleado = idEmpleado;
	}

	/* Para relacion 1-N con Servicio */
	public Empleado newEmpleado() {
		Empleado ret = new Empleado();
//		e.setBajaEmpleado(this);
		ret = Empleado.newEmpleado();
		return ret;
	}

	// metodo nuevoClase

	public static BajaEmpleado newBajaEmpleado() {
		BajaEmpleado ret = new BajaEmpleado();
		Scanner teclado = new Scanner(System.in);
		long id = 0;
		id = teclado.nextLong();
		ret.setIdBaja(id);

		LocalDate fechaFin = null;
		fechaFin = LocalDate.of(teclado.nextInt(), teclado.nextInt(), teclado.nextInt());
		ret.setFechaFin(fechaFin);

		System.out.println("Motivo baja: ");
		String motivo;
		motivo = teclado.nextLine();
		ret.setMotivoBaja(motivo);
		return ret;
	}

	// getters y setters

	public long getIdBaja() {
		return idBaja;
	}

	public void setIdBaja(long idBaja) {
		this.idBaja = idBaja;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getMotivoBaja() {
		return motivoBaja;
	}

	public void setMotivoBaja(String motivoBaja) {
		this.motivoBaja = motivoBaja;
	}

	public long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	// toString

	@Override
	public String toString() {
		return "BajaEmpleado [idBaja=" + idBaja + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin
				+ ", motivoBaja=" + motivoBaja + ", idEmpleado=" + idEmpleado + "]";
	}

	// Para exportar un fichero binario
	// Habría que poner dentro del main (en la clase principal) lo siguiente:
	// BajaEmpleado.exportarBajaEmpleado();
	// Hay más formas de exportar un fichero binario (mirar clase principal)
	public static void exportarBajaEmpleado() {
		String path = "Baja.dat";
		BajaEmpleado nuevabaja = new BajaEmpleado();
		ObjectOutputStream oos = null;
		try {
			oos.writeObject(Datos.BAJAEMPLEADOS[1]);
			FileOutputStream fichero = new FileOutputStream("Baja.dat");

			ObjectOutputStream baja = new ObjectOutputStream(fichero);

			baja.writeObject(nuevabaja);
			// fichero.flush();

			fichero.close();
			// baja.flush();
			baja.close();

			ObjectInputStream bajaLeer = new ObjectInputStream(new FileInputStream("Baja.dat"));
			BajaEmpleado aux = (BajaEmpleado) bajaLeer.readObject();

			System.out.println(aux.idBaja + "Nueva Baja");

			bajaLeer.close();

		} catch (FileNotFoundException e) {

			System.out.println("Se ha producido una FileNotFoundException" + e.getMessage());

		} catch (IOException e) {

			System.out.println("Se ha producido una IOException" + e.getMessage());

		} catch (Exception e) {

			System.out.println("Se ha producido una Exception" + e.getMessage());
		}

	}

//Para exportar un fichero de texto
	public static void exportarBajaEmpleadotexto() {
		BajaEmpleado nuevabaja = new BajaEmpleado();
		ObjectOutputStream oos = null;
		try {
			oos.writeObject(Datos.BAJAEMPLEADOS[1]);
			File archivo = new File("Baja.txt");
			FileReader lector = new FileReader(archivo);
			BufferedReader br = new BufferedReader(lector);

			String linea;
			while ((linea = br.readLine()) != null) {
				nuevabaja.setIdBaja(Integer.parseInt(linea));

			}
			System.out.println(nuevabaja.idBaja + "Baja");

		} catch (FileNotFoundException e) {

			System.out.println("Se ha producido una FileNotFoundException" + e.getMessage());

		} catch (IOException e) {

			System.out.println("Se ha producido una IOException" + e.getMessage());

		} catch (Exception e) {

			System.out.println("Se ha producido una Exception" + e.getMessage());
		}
	}

	/***
	 * Método data()
	 * @return
	 */
	public String data() {
		String ret = "";
		ret = this.idBaja + "|" + this.fechaInicio.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))  + "|" + this.fechaFin.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))  + "|" + this.motivoBaja + "|"
				+ this.idEmpleado;
		return ret;
	}

	/***
	 * Función que exporta los datos de cada una de las bajaempleados de una
	 * colección que se le pasa como parámetro, a través del método data() anterior.
	 * 
	 * @param bajaempleado la coleccion de bajaempleado a exportar
	 */
	private static void exportar(BajaEmpleado[] bajaempleado) {
		String path = "bajaempleado.txt";
		File fichero = new File(path);
		FileWriter escritor = null;
		PrintWriter buffer = null;
		try {
			try {
				escritor = new FileWriter(fichero, false);
				buffer = new PrintWriter(escritor);
				for (BajaEmpleado be : bajaempleado) {
					buffer.println(be.data());
				}
			} finally {
				if (buffer != null) {
					buffer.close();
				}
				if (escritor != null) {
					escritor.close();
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Se ha producido una FileNotFoundException" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Se ha producido una IOException" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception" + e.getMessage());
		}
	}
	
//	public static void crearArchivo (ArrayList lista) {
//		FileWriter flwriter = null;
//		try {
//			flwriter = new FileWriter ("bajaempleadolista.txt");
//			BufferedWriter bfwriter = new BufferedWriter(flwriter);
//			for (BajaEmpleado bajaempleado: lista) {
//				bfwriter.write(bajaempleado.getIdBaja() + "," + bajaempleado.getFechaInicio() + "," + bajaempleado.getFechaFin() + "," + bajaempleado.getMotivoBaja() + "," + bajaempleado.getIdEmpleado() + "\n");
//			
//			}
//			bfwriter.close();
//			System.out.println("Archivo creado");
//		}catch (IOException e) {
//			e.printStackTrace();
//			
//		}finally {
//			if (flwriter !=null) {
//				try {
//					flwriter.close();
//				}catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}

}
