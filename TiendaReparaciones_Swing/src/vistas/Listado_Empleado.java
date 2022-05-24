package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Collection;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.EmpleadoDAO;
import entidades.Empleado;
import utils.ConexBD;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JLabel;

public class Listado_Empleado extends JFrame {

	private JPanel contentPane;
	private JTable tableEmpleados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Listado_Empleado frame = new Listado_Empleado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Listado_Empleado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		EmpleadoDAO emp=new EmpleadoDAO(ConexBD.getCon());
		Collection<Empleado> todos = emp.buscarTodos();
		DefaultTableModel modelo = new DefaultTableModel();
		Empleado [] listaEmp=new Empleado[todos.size()];
		int contador=0;
		//creo el array de empleados
		for (Empleado e:todos)
		{
			Object[] row = { e.getIdEmpleado(), e.getNombre()};
			modelo.addRow(row);
		}
		
		tableEmpleados = new JTable(modelo);
		contentPane.add(tableEmpleados, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Lista Usuarios");
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		
		
		
		
		
	}

}
