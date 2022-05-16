//implementado por nicolás
package entidades;
import java.util.Arrays;
import java.util.Scanner;

public class Grupo {
	/*nombreGrupo representa el nombre que identifica a cada grupo, su valor es una cadena de texto de longitud String 
	(mínimo 0 caracteres, máximo 4 bytes de caracteres) Es un atributo obligatorio, ya que todos los grupos tienen un nombre*/
	private String nombreGrupo;
	//referencia a empleados taller debido a la multiplicidad N-M
	private EmpleadoTaller [] empleadosTaller;
	//la referencia a grupo se supone se haria en reparacion
	private Reparacion [] reparaciones;
	
	public Grupo() {

	}
	
	public static Grupo nuevoGrupo() {
		Scanner teclado = new Scanner(System.in);
		Grupo ret = new Grupo();

		System.out.println("Introduzca el nombre del grupo");
		String nom = "";
		nom = teclado.nextLine();
		ret.setNombreGrupo(nom);

		return ret;
	}
	
	public static Grupo nuevoGrupoConEmpleadosTaller() {
		Scanner teclado = new Scanner(System.in);
		Grupo ret = new Grupo();

		System.out.println("Introduzca el nombre del grupo");
		String nom = "";
		nom = teclado.nextLine();
		ret.setNombreGrupo(nom);
		
		//aqui se haria la introducción de los datos del array empleadosTaller

		return ret;
	}

	
	public Reparacion[] getReparaciones() {
		return reparaciones;
	}

	public void setReparaciones(Reparacion[] reparaciones) {
		this.reparaciones = reparaciones;
	}

	public String getNombreGrupo() {
		return nombreGrupo;
	}

	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	public EmpleadoTaller[] getEmpleadosTaller() {
		return empleadosTaller;
	}

	public void setEmpleadosTaller(EmpleadoTaller[] empleadosTaller) {
		this.empleadosTaller = empleadosTaller;
	}

	@Override
	public String toString() {
		return "Grupo [nombreGrupo=" + nombreGrupo + ", empleadosTaller=" + Arrays.toString(empleadosTaller) + "]";
	}

}
