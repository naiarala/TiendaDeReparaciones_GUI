//implementado por nicolás
package entidades;
import java.util.Arrays;
import java.util.Scanner;

public class EmpleadoTaller extends Empleado {
	 /*senior indica si un empleado pertenece o no a varios grupos, en caso de ser
	 false pertenecerá a un único grupo y en caso de ser true pertenecerá a más de
	 uno, es un atributo obligatorio, ya que todos los empleados pertenecen mínimo
	 a un grupo, por eso se inicializa en false*/
	private boolean senior = false;
	//referencia a grupo debido a la multiplicidad N-M
	private Grupo [] grupos;

	public EmpleadoTaller() {
		super();
	}
	
	public EmpleadoTaller(long idEmpleado, String nombre, String apellido, String direccion, String telefono, String nif) {
		super(idEmpleado, nombre, apellido, direccion, telefono, nif);
		this.senior = senior;
	}

	public static EmpleadoTaller nuevoEmpleadoTaller() {
		Scanner teclado = new Scanner(System.in);
		EmpleadoTaller ret = new EmpleadoTaller();

		System.out.println("¿El empleado es senior? Introduce \"true\" en caso afirmativo o \"false\" en caso negativo");
		boolean senior = false;
		senior = teclado.nextBoolean();
		ret.setSenior(senior);

		return ret;
	}
	
	public static EmpleadoTaller nuevoEmpleadoTallerConGrupos() {
		Scanner teclado = new Scanner(System.in);
		EmpleadoTaller ret = new EmpleadoTaller();

		System.out.println("¿El empleado es senior? Introduce \"true\" en caso afirmativo o \"false\" en caso negativo");
		boolean senior = false;
		senior = teclado.nextBoolean();
		ret.setSenior(senior);
		
		//aqui se haria la introducción de los datos del array grupos

		return ret;
	}

	public boolean isSenior() {
		return senior;
	}

	public void setSenior(boolean senior) {
		this.senior = senior;
	}

	public Grupo[] getGrupos() {
		return grupos;
	}

	public void setGrupos(Grupo[] grupos) {
		this.grupos = grupos;
	}

	@Override
	public String toString() {
		return "EmpleadoTaller [senior=" + senior + ", grupos=" + Arrays.toString(grupos) + "]";
	}

}