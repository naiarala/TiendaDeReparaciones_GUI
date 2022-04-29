//implementado por nicolás
package entidades;
import java.util.Scanner;

public class EmpleadoRepartidor extends Empleado {
	/*este atributo almacena en km el radio de reparto de cada empleado repartidor, es un atributo
	obligatorio, ya que se guarda para todos los empleados repartidores, su valor es un double > 0*/
	private double radioReparto;

	public EmpleadoRepartidor() {
		super();
	}
	
	public EmpleadoRepartidor(long idEmpleado, String nombre, String apellido, String direccion, String telefono, String nif) {
		super(idEmpleado, nombre, apellido, direccion, telefono, nif);
		this.radioReparto = radioReparto;
	}
	
	public static EmpleadoRepartidor nuevoEmpleadoRepartidor() {
		Scanner teclado = new Scanner(System.in);
		EmpleadoRepartidor ret = new EmpleadoRepartidor();

		System.out.println("Introduzca el radio de reparto en km");
		double radio = 0.0;
		radio = teclado.nextDouble();
		ret.setRadioReparto(radio);

		return ret;
	}

	public double getRadioReparto() {
		return radioReparto;
	}

	public void setRadioReparto(double radioReparto) {
		this.radioReparto = radioReparto;
	}

	@Override
	public String toString() {
		return "EmpleadoRepartidor [radioReparto=" + radioReparto + "]";
	}

}