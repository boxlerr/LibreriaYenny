package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.BibliotecaControlador;
import controlador.EmpleadoControlador;
import controlador.EscritorControlador;
import controlador.GerenteControlador;
import controlador.LibroControlador;
import controlador.UsuarioControlador;
import modelos.Escritor;
import modelos.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class Registrarse extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inpNombre;
	private JTextField inpApellido;
	private JTextField inpDNI;
	private JTextField inpMail;
	private JTextField inpContrasena;
	private JTextField inpRepetirContrasena;
	private JLabel lblErrorMailInvalido;
	private JLabel lblErrorContrasenaCaracteres;
	private JLabel lblErrorContrasenaBlank;
	private JLabel lblErrorNoCoinciden;
	private JLabel lblErrorNombreNumeros;
	private JLabel lblErrorApellido;
	private JLabel lblErrorApellidoNumeros;

	/**
	 * Launch the application.
	 */
	public Registrarse() {
		UsuarioControlador usuarioControlador = new UsuarioControlador();
		GerenteControlador gerenteControlador = new GerenteControlador();
		EmpleadoControlador empleadoControlador = new EmpleadoControlador();
		EscritorControlador escritorControlador = new EscritorControlador();
		LibroControlador libroControlador = new LibroControlador();
		BibliotecaControlador bibliotecaControlador = new BibliotecaControlador();
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCrearCuenta = new JLabel("Crear cuenta");
		lblCrearCuenta.setFont(new Font("Arial", Font.BOLD, 15));
		lblCrearCuenta.setBounds(163, 10, 96, 13);
		contentPane.add(lblCrearCuenta);
		
		inpNombre = new JTextField();
		inpNombre.setBounds(46, 50, 148, 28);
		contentPane.add(inpNombre);
		inpNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setBounds(46, 34, 45, 13);
		contentPane.add(lblNewLabel);
		
		inpApellido = new JTextField();
		inpApellido.setColumns(10);
		inpApellido.setBounds(242, 50, 148, 28);
		contentPane.add(inpApellido);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblApellido.setBounds(242, 34, 51, 13);
		contentPane.add(lblApellido);
		
		inpDNI = new JTextField();
		inpDNI.setColumns(10);
		inpDNI.setBounds(46, 104, 148, 28);
		contentPane.add(inpDNI);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblDni.setBounds(46, 88, 45, 13);
		contentPane.add(lblDni);
		
		inpMail = new JTextField();
		inpMail.setColumns(10);
		inpMail.setBounds(242, 104, 148, 28);
		contentPane.add(inpMail);
		
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblEmail.setBounds(242, 88, 45, 13);
		contentPane.add(lblEmail);
		
		inpContrasena = new JTextField();
		inpContrasena.setColumns(10);
		inpContrasena.setBounds(46, 158, 148, 28);
		contentPane.add(inpContrasena);
		
		JLabel lblContrasena = new JLabel("Contraseña");
		lblContrasena.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblContrasena.setBounds(46, 142, 62, 13);
		contentPane.add(lblContrasena);
		
		inpRepetirContrasena = new JTextField();
		inpRepetirContrasena.setColumns(10);
		inpRepetirContrasena.setBounds(242, 158, 148, 28);
		contentPane.add(inpRepetirContrasena);
		
		JLabel lblRepetirContrasena = new JLabel("Repetir contraseña");
		lblRepetirContrasena.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblRepetirContrasena.setBounds(242, 142, 116, 13);
		contentPane.add(lblRepetirContrasena);
		
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
		lblErrorContrasenaCaracteres.setBounds(14, 187, 213, 13);
		contentPane.add(lblErrorContrasenaCaracteres);
		lblErrorContrasenaCaracteres.setVisible(false);
		
		JLabel lblErrorContrasenaBlank;
		lblErrorContrasenaBlank = new JLabel("Ingrese una contraseña");
		lblErrorContrasenaBlank.setForeground(new Color(255, 0, 0));
		lblErrorContrasenaBlank.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblErrorContrasenaBlank.setBounds(70, 187, 101, 13);
		contentPane.add(lblErrorContrasenaBlank);
		lblErrorContrasenaBlank.setVisible(false);
		
		JLabel lblErrorNoCoinciden;
		lblErrorNoCoinciden = new JLabel("No coinciden las contraseñas");
		lblErrorNoCoinciden.setForeground(new Color(255, 0, 0));
		lblErrorNoCoinciden.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblErrorNoCoinciden.setBounds(254, 187, 124, 13);
		contentPane.add(lblErrorNoCoinciden);
		lblErrorNoCoinciden.setVisible(false);
		
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
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flagMailExistencia = usuarioControlador.verificarMailExistencia(inpMail.getText());
				boolean flagMailValido = usuarioControlador.verificarMailValido(inpMail.getText());
				if (flagMailValido) {
					if (flagMailExistencia) {
						//Seguir
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
				
				boolean flagContrasenaCaracteres = usuarioControlador.verificarContraseñaCaracteres(inpContrasena.getText());
				boolean flagContrasenaNumeros = usuarioControlador.verificarNumeros(inpContrasena.getText());
				boolean flagContrasenaBlank = true;
				
				if (inpContrasena.getText().isBlank()) {
					flagContrasenaBlank = false;
				}
				
				if (flagContrasenaBlank) {
					if (flagContrasenaCaracteres) {
						if (flagContrasenaNumeros) {
							//Seguir
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
				
				
				if (inpContrasena.getText().equals(inpRepetirContrasena.getText())) {
					lblErrorNoCoinciden.setVisible(false);
				} else {
					lblErrorNoCoinciden.setVisible(true);
				}
				
				
				if (inpNombre.getText().isBlank()) {
					lblErrorNombre.setVisible(true);
				} else {
					lblErrorNombre.setVisible(false);
					if (usuarioControlador.verificarNumeros(inpNombre.getText())==false) {
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
					if (usuarioControlador.verificarNumeros(inpApellido.getText())==false) {
						//Seguir
						lblErrorApellidoNumeros.setVisible(false);
						lblErrorApellido.setVisible(false);
					} else {
						lblErrorApellidoNumeros.setVisible(true);
					}
				}
				
				boolean flagDNIValido = usuarioControlador.VerificarDNI(inpDNI.getText());
				
				if (flagDNIValido) {
					lblErrorDNIINvalido.setVisible(false);
				} else {
					lblErrorDNIINvalido.setVisible(true);
				}
				
				if (flagMailExistencia && flagMailValido && flagContrasenaCaracteres && flagContrasenaNumeros && flagContrasenaBlank && 
						inpContrasena.getText().equals(inpRepetirContrasena.getText()) && !inpNombre.getText().isBlank() && 
						usuarioControlador.verificarNumeros(inpNombre.getText())==false && !inpApellido.getText().isBlank() &&
						usuarioControlador.verificarNumeros(inpApellido.getText())==false && flagDNIValido) {
					usuarioControlador.addUser(new Usuario(inpMail.getText(), inpContrasena.getText(), "Escritor"));
					escritorControlador.addEscritor(usuarioControlador.getUserById(inpMail.getText(), inpContrasena.getText()), new Escritor(inpMail.getText(), inpContrasena.getText(), "Escritor", inpNombre.getText(), inpApellido.getText(), Integer.parseInt(inpDNI.getText())));
					dispose();
					PantallaInicio pantallaInicio = new PantallaInicio();
					
				}
				
				
				
//				String contraseña2 = "";
//				contraseña2=usuarioControlador.verificarContraseña(contraseña2);
//				
//				
//				String nombre = JOptionPane.showInputDialog("Ingrese nombre");
//				String apellido = JOptionPane.showInputDialog("Ingrese apellido");
//				int dni = Integer.parseInt(JOptionPane.showInputDialog("Ingrese dni"));
//				
//				usuarioControlador.addUser(new Usuario(mail, contraseña2, "Escritor"));
//				escritorControlador.addEscritor(usuarioControlador.getUserById(mail, contraseña2), new Escritor(mail, contraseña2, "Escritor", nombre, apellido, dni));
//				
				
			}
			
		});
		btnRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegistrarse.setBounds(78, 210, 116, 28);
		contentPane.add(btnRegistrarse);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PantallaInicio pantallaInicio = new PantallaInicio();
				
			}
			
		});
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVolver.setBounds(242, 210, 116, 28);
		contentPane.add(btnVolver);
		
		
		
		
		
		
		
	}
}
