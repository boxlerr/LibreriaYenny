package vista;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

import controlador.*;
import modelos.*;
import java.awt.Font;
import javax.swing.JComboBox;

public class Agregar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private UsuarioControlador controlador = new UsuarioControlador();
	GerenteControlador gerenteControlador = new GerenteControlador();
	EscritorControlador escritorControlador = new EscritorControlador();
	EmpleadoControlador empleadoControlador = new EmpleadoControlador();
	private JTextField InpMail;
	private JTextField InpTipo;
	private JTextField textField;
	private JTextField inpNombre;
	private JTextField inpApellido;
	private JTextField inpDni;
	private JTextField inpMail;
	private JTextField inpContrasena;
	
	public Agregar() {
		this(new Usuario());
	}
	
	public Agregar(Usuario usuario) {
	this.setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 456, 370);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblNombre = new JLabel("Nombre");
	lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 10));
	lblNombre.setBounds(46, 34, 45, 13);
	contentPane.add(lblNombre);
	
	JLabel lblApellido = new JLabel("Apellido");
	lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 10));
	lblApellido.setBounds(242, 34, 51, 13);
	contentPane.add(lblApellido);
	
	JLabel lblDni = new JLabel("DNI");
	lblDni.setFont(new Font("Tahoma", Font.PLAIN, 10));
	lblDni.setBounds(46, 88, 45, 13);
	contentPane.add(lblDni);
	
	JLabel lblEmail = new JLabel("E-Mail");
	lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 10));
	lblEmail.setBounds(242, 88, 45, 13);
	contentPane.add(lblEmail);
	
	JLabel lblContrasena = new JLabel("Contraseña");
	lblContrasena.setFont(new Font("Tahoma", Font.PLAIN, 10));
	lblContrasena.setBounds(46, 142, 62, 13);
	contentPane.add(lblContrasena);
	
	JLabel lblSucursal = new JLabel("ID Sucursal");
	lblSucursal.setBounds(47, 208, 99, 14);
	contentPane.add(lblSucursal);
	
	JLabel lblErrorMailExistente = new JLabel("Ya existe una cuenta con este mail");
	lblErrorMailExistente.setFont(new Font("Tahoma", Font.PLAIN, 9));
	lblErrorMailExistente.setForeground(new Color(255, 0, 0));
	lblErrorMailExistente.setBounds(273, 88, 165, 13);
	contentPane.add(lblErrorMailExistente);
	lblErrorMailExistente.setVisible(false);
	
	JLabel lblErrorMailInvalido;
	lblErrorMailInvalido = new JLabel("Ingrese un mail válido");
	lblErrorMailInvalido.setFont(new Font("Tahoma", Font.PLAIN, 9));
	lblErrorMailInvalido.setForeground(new Color(255, 0, 0));
	lblErrorMailInvalido.setBounds(273, 88, 165, 13);
	contentPane.add(lblErrorMailInvalido);
	lblErrorMailInvalido.setVisible(false);
	
	JLabel lblErrorContrasenaNumeros = new JLabel("La contraseña debe tener números");
	lblErrorContrasenaNumeros.setForeground(new Color(255, 0, 0));
	lblErrorContrasenaNumeros.setFont(new Font("Tahoma", Font.PLAIN, 9));
	lblErrorContrasenaNumeros.setBounds(46, 187, 148, 13);
	contentPane.add(lblErrorContrasenaNumeros);
	lblErrorContrasenaNumeros.setVisible(false);
	
	JLabel lblErrorContrasenaCaracteres = new JLabel("La contraseña debe contener al menos 6 caracteres");
	lblErrorContrasenaCaracteres.setForeground(new Color(255, 0, 0));
	lblErrorContrasenaCaracteres.setFont(new Font("Tahoma", Font.PLAIN, 9));
	lblErrorContrasenaCaracteres.setBounds(18, 187, 213, 13);
	contentPane.add(lblErrorContrasenaCaracteres);
	lblErrorContrasenaCaracteres.setVisible(false);
	
	JLabel lblErrorContrasenaBlank;
	lblErrorContrasenaBlank = new JLabel("Ingrese una contraseña");
	lblErrorContrasenaBlank.setForeground(new Color(255, 0, 0));
	lblErrorContrasenaBlank.setFont(new Font("Tahoma", Font.PLAIN, 9));
	lblErrorContrasenaBlank.setBounds(101, 142, 101, 13);
	contentPane.add(lblErrorContrasenaBlank);
	lblErrorContrasenaBlank.setVisible(false);
	
	JLabel lblErrorApellido = new JLabel("Ingrese un apellido");
	lblErrorApellido.setFont(new Font("Tahoma", Font.PLAIN, 9));
	lblErrorApellido.setForeground(new Color(255, 0, 0));
	lblErrorApellido.setBounds(282, 34, 108, 13);
	contentPane.add(lblErrorApellido);
	lblErrorApellido.setVisible(false);
	
	JLabel lblErrorApellidoNumeros = new JLabel("Ingrese un apellido válido");
	lblErrorApellidoNumeros.setFont(new Font("Tahoma", Font.PLAIN, 9));
	lblErrorApellidoNumeros.setForeground(new Color(255, 0, 0));
	lblErrorApellidoNumeros.setBounds(282, 34, 116, 13);
	contentPane.add(lblErrorApellidoNumeros);
	lblErrorApellidoNumeros.setVisible(false);
	
	JLabel lblErrorNombre = new JLabel("Ingrese un nombre");
	lblErrorNombre.setFont(new Font("Tahoma", Font.PLAIN, 9));
	lblErrorNombre.setForeground(new Color(255, 0, 0));
	lblErrorNombre.setBounds(86, 34, 108, 13);
	contentPane.add(lblErrorNombre);
	lblErrorNombre.setVisible(false);
	
	JLabel lblErrorNombreNumeros = new JLabel("Ingrese un nombre válido");
	lblErrorNombreNumeros.setFont(new Font("Tahoma", Font.PLAIN, 9));
	lblErrorNombreNumeros.setForeground(new Color(255, 0, 0));
	lblErrorNombreNumeros.setBounds(86, 34, 116, 13);
	contentPane.add(lblErrorNombreNumeros);
	lblErrorNombreNumeros.setVisible(false);
	
	JLabel lblErrorDNIINvalido = new JLabel("Ingrese un DNI válido");
	lblErrorDNIINvalido.setFont(new Font("Tahoma", Font.PLAIN, 9));
	lblErrorDNIINvalido.setForeground(new Color(255, 0, 0));
	lblErrorDNIINvalido.setBounds(70, 88, 124, 13);
	contentPane.add(lblErrorDNIINvalido);
	lblErrorDNIINvalido.setVisible(false);
	
	inpNombre = new JTextField();
	inpNombre.setColumns(10);
	inpNombre.setBounds(46, 48, 148, 29);
	contentPane.add(inpNombre);
	
	inpApellido = new JTextField();
	inpApellido.setColumns(10);
	inpApellido.setBounds(242, 48, 148, 29);
	contentPane.add(inpApellido);
	
	inpDni = new JTextField();
	inpDni.setColumns(10);
	inpDni.setBounds(46, 102, 148, 29);
	contentPane.add(inpDni);
	
	inpMail = new JTextField();
	inpMail.setColumns(10);
	inpMail.setBounds(242, 102, 148, 29);
	contentPane.add(inpMail);
	
	inpContrasena = new JTextField();
	inpContrasena.setColumns(10);
	inpContrasena.setBounds(46, 160, 148, 29);
	contentPane.add(inpContrasena);
	
	JComboBox ListaIdSucursal = new JComboBox();
	ListaIdSucursal.setBounds(46, 227, 148, 29);
	contentPane.add(ListaIdSucursal);
	
	ListaIdSucursal.addItem("1");
	ListaIdSucursal.addItem("2");
	ListaIdSucursal.addItem("3");
	
	JComboBox ListaTipo = new JComboBox();
	ListaTipo.setBounds(242, 163, 148, 29);
	contentPane.add(ListaTipo);
	
	ListaTipo.addItem("Gerente");
	ListaTipo.addItem("Empleado");
	ListaTipo.addItem("Escritor");
	
	JLabel lblTipo = new JLabel("Tipo");
	lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 10));
	lblTipo.setBounds(242, 141, 45, 13);
	contentPane.add(lblTipo);
	
	JLabel lblErrorTipo = new JLabel("Ingrese un tipo válido");
	lblErrorTipo.setForeground(new Color(255, 0, 0));
	lblErrorTipo.setFont(new Font("Tahoma", Font.PLAIN, 10));
	lblErrorTipo.setBounds(273, 141, 117, 14);
	lblErrorTipo.setVisible(false);
	contentPane.add(lblErrorTipo);
	
	JLabel lblAadirCuenta = new JLabel("Añadir cuenta");
	lblAadirCuenta.setFont(new Font("Arial", Font.BOLD, 15));
	lblAadirCuenta.setBounds(163, 11, 124, 13);
	contentPane.add(lblAadirCuenta);
	
	JLabel lblErrorDNI = new JLabel("Ingrese un DNI válido");
	lblErrorDNI.setFont(new Font("Tahoma", Font.PLAIN, 9));
	lblErrorDNI.setForeground(new Color(255, 0, 0));
	lblErrorDNI.setBounds(70, 88, 124, 13);
	contentPane.add(lblErrorDNI);
	lblErrorDNI.setVisible(false);
	
	JLabel lblErrorID = new JLabel("Ingrese un ID válido");
	lblErrorID.setFont(new Font("Tahoma", Font.PLAIN, 9));
	lblErrorID.setForeground(new Color(255, 0, 0));
	lblErrorID.setBounds(117, 208, 114, 14);
	contentPane.add(lblErrorID);
	lblErrorID.setVisible(false);
	
	JButton btnAgregar = new JButton("Agregar");
	btnAgregar.setBounds(76, 277, 89, 45);
	btnAgregar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			boolean flagMailExistencia = controlador.verificarMailExistencia(inpMail.getText());
			boolean flagMailValido = controlador.verificarMailValido(inpMail.getText());
			if (flagMailValido) {
				if (flagMailExistencia) {
					lblErrorMailInvalido.setVisible(false);
					lblErrorMailExistente.setVisible(false);
				} else {
					lblErrorMailInvalido.setVisible(false);
		lblErrorMailExistente.setVisible(true);
				}
			} else {
				lblErrorMailExistente.setVisible(false);
				lblErrorMailInvalido.setVisible(true);
			}
	
			boolean flagContrasenaCaracteres = controlador.verificarContraseñaCaracteres(inpContrasena.getText());
			boolean flagContrasenaNumeros = controlador.verificarNumeros(inpContrasena.getText());
			boolean flagContrasenaBlank = true;
	
			if (inpContrasena.getText().isBlank()) {
				flagContrasenaBlank = false;
			}
	
			if (flagContrasenaBlank) {
				if (flagContrasenaCaracteres) {
					if (flagContrasenaNumeros) {
						lblErrorContrasenaBlank.setVisible(false);
						lblErrorContrasenaCaracteres.setVisible(false);
						lblErrorContrasenaNumeros.setVisible(false);
					} else {
						lblErrorContrasenaBlank.setVisible(false);
						lblErrorContrasenaCaracteres.setVisible(false);
						lblErrorContrasenaNumeros.setVisible(true);
					}
				} else {
					lblErrorContrasenaBlank.setVisible(false);
					lblErrorContrasenaNumeros.setVisible(false);
					lblErrorContrasenaCaracteres.setVisible(true);
				}
			} else {
				lblErrorContrasenaNumeros.setVisible(false);
				lblErrorContrasenaCaracteres.setVisible(false);
				lblErrorContrasenaBlank.setVisible(true);
			}
	
			if (inpNombre.getText().isBlank()) {
				lblErrorNombre.setVisible(true);
			} else {
				lblErrorNombre.setVisible(false);
				if (controlador.verificarNumeros(inpNombre.getText())==false) {
					//Seguir
					lblErrorNombreNumeros.setVisible(false);
					lblErrorNombre.setVisible(false);
				} else {
					lblErrorNombreNumeros.setVisible(true);
				}
			}
	
			if (inpApellido.getText().isBlank()) {
				lblErrorApellido.setVisible(true);
			} else {
				lblErrorApellido.setVisible(false);
				if (controlador.verificarNumeros(inpApellido.getText())==false) {
					//Seguir
					lblErrorApellidoNumeros.setVisible(false);
					lblErrorApellido.setVisible(false);
				} else {
					lblErrorApellidoNumeros.setVisible(true);
				}
			}
	
			boolean flagDNIValido = controlador.VerificarDNI(inpDni.getText());
	
			if (flagDNIValido) {
				lblErrorDNIINvalido.setVisible(false);
			} else {
				lblErrorDNIINvalido.setVisible(true);
			}
	
			if (flagMailExistencia && flagMailValido && flagContrasenaCaracteres && flagContrasenaNumeros && flagContrasenaBlank &&
			!inpNombre.getText().isBlank() && controlador.verificarNumeros(inpNombre.getText())==false && !inpApellido.getText().isBlank() &&
			controlador.verificarNumeros(inpApellido.getText())==false && flagDNIValido) {
			
			Usuario nuevoUsuario = new Usuario(inpMail.getText(), inpContrasena.getText(), (String) ListaTipo.getSelectedItem());
			controlador.addUser(nuevoUsuario);
			
			int idSucursal_fk = Integer.parseInt((String) ListaIdSucursal.getSelectedItem());
			
			switch ((String) ListaTipo.getSelectedItem()) {
			case "Gerente":
				Gerente nuevoGerente = new Gerente(inpMail.getText(), inpContrasena.getText(), "Gerente", inpNombre.getText(), inpApellido.getText(), Integer.parseInt(inpDni.getText()), idSucursal_fk);
				gerenteControlador.addGerente(nuevoGerente, nuevoUsuario);
				
				break;

			case "Empleado":
				Empleado nuevoEmpleado = new Empleado(inpMail.getText(), inpContrasena.getText(), "Empleado", inpNombre.getText(), inpApellido.getText(), Integer.parseInt(inpDni.getText()), idSucursal_fk);
				empleadoControlador.addEmpleado(nuevoEmpleado, nuevoUsuario);
				break;
				
			case "Escritor":
				escritorControlador.addEscritor(controlador.getUserById(inpMail.getText(), inpContrasena.getText()), new Escritor(inpMail.getText(), inpContrasena.getText(), "Escritor",
                        inpNombre.getText(), inpApellido.getText(), Integer.parseInt(inpDni.getText())));
				break;
			}
			
			dispose();
			PantallaCuentas pantallaCuentas = new PantallaCuentas();
	
	}
	
	}
	});
	contentPane.add(btnAgregar);
	
	
	JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(272, 277, 89, 45);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PantallaCuentas pantallaCuentas = new PantallaCuentas();
	}
	
	});
	contentPane.add(btnCancelar);
	

}
}