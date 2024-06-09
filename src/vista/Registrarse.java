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

public class Registrarse extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inpNombre;
	private JTextField inpApellido;
	private JTextField inpDNI;
	private JTextField inpMail;
	private JTextField inpContrasena;
	private JTextField inpRepetirContrasena;

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
		
		JLabel lblContrasena = new JLabel("Contrasena");
		lblContrasena.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblContrasena.setBounds(46, 142, 62, 13);
		contentPane.add(lblContrasena);
		
		inpRepetirContrasena = new JTextField();
		inpRepetirContrasena.setColumns(10);
		inpRepetirContrasena.setBounds(242, 158, 148, 28);
		contentPane.add(inpRepetirContrasena);
		
		JLabel lblRepetirContrasena = new JLabel("Repetir contrasena");
		lblRepetirContrasena.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblRepetirContrasena.setBounds(242, 142, 116, 13);
		contentPane.add(lblRepetirContrasena);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flagMailExistencia = usuarioControlador.verificarMailExistencia(inpMail.getText());
				boolean flagMailValido = usuarioControlador.verificarMailValido(inpMail.getText());
				if (flagMailValido) {
					if (flagMailExistencia) {
						//Seguir
					} else if (flagMailExistencia=false) {
						//Mostrar error ya existe
					}
				} else if (flagMailValido=false) {
					//Mostrar error mail invalido
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
		btnRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegistrarse.setBounds(163, 210, 116, 28);
		contentPane.add(btnRegistrarse);
	}

}
