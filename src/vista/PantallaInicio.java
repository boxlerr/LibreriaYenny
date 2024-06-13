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

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class PantallaInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inpMail;
	private JPasswordField inpContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaInicio frame = new PantallaInicio();
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
	public PantallaInicio() {
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
		
		JLabel lblTextoInicio = new JLabel("Bienvenido a la Librería Yenny");
		lblTextoInicio.setFont(new Font("Arial", Font.BOLD, 16));
		lblTextoInicio.setBounds(104, 32, 235, 32);
		contentPane.add(lblTextoInicio);
		
		JLabel lblInicioSesion = new JLabel("Inicio de sesión");
		lblInicioSesion.setFont(new Font("Arial", Font.PLAIN, 12));
		lblInicioSesion.setBounds(173, 68, 90, 13);
		contentPane.add(lblInicioSesion);
		
		inpMail = new JTextField();
		inpMail.setFont(new Font("Tahoma", Font.PLAIN, 10));
		inpMail.setBounds(130, 106, 175, 26);
		contentPane.add(inpMail);
		inpMail.setColumns(10);
		
		
		JLabel lblMail = new JLabel("Ingrese su e-mail");
		lblMail.setForeground(new Color(128, 128, 128));
		lblMail.setFont(new Font("Arial", Font.PLAIN, 11));
		lblMail.setBounds(130, 91, 99, 13);
		contentPane.add(lblMail);
		
		JLabel lblContrasena = new JLabel("Ingrese su contraseña");
		lblContrasena.setForeground(Color.GRAY);
		lblContrasena.setFont(new Font("Arial", Font.PLAIN, 11));
		lblContrasena.setBounds(130, 142, 113, 13);
		contentPane.add(lblContrasena);
		
		inpContrasena = new JPasswordField();
		inpContrasena.setBounds(130, 161, 175, 26);
		contentPane.add(inpContrasena);
		
		JLabel lblError = new JLabel("Ese usuario no se encuentra registrado, mail o contraseña incorrecta");
		lblError.setFont(new Font("Arial", Font.PLAIN, 9));
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBounds(86, 185, 295, 26);
		contentPane.add(lblError);
		lblError.setVisible(false);
		JLabel lblErrorCliente = new JLabel("No se puede ingresar con cuentas cliente");
		lblErrorCliente.setFont(new Font("Arial", Font.PLAIN, 9));
		lblErrorCliente.setForeground(new Color(255, 0, 0));
		lblErrorCliente.setBounds(133, 185, 184, 26);
		contentPane.add(lblErrorCliente);
		lblErrorCliente.setVisible(false);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (usuarioControlador.getUserById(inpMail.getText(), inpContrasena.getText())!=null) {
					lblError.setVisible(false);
					lblErrorCliente.setVisible(false);
					
					switch (usuarioControlador.getUserById(inpMail.getText(), inpContrasena.getText()).getTipo()) {
					case "gerente":
						dispose();
						PantallaGerente pantallaGerente = new PantallaGerente();
						break;
					case "empleado":
						dispose();
						empleadoControlador.getEmpleadoById(usuarioControlador.getUserById(inpMail.getText(), inpContrasena.getText())).Ingreso(libroControlador, bibliotecaControlador, usuarioControlador, gerenteControlador, empleadoControlador, escritorControlador);
			
						break;
						
					case "escritor":
						dispose();
						escritorControlador.getEscritorById(usuarioControlador.getUserById(inpMail.getText(), inpContrasena.getText())).Ingreso(libroControlador, bibliotecaControlador, usuarioControlador, gerenteControlador, empleadoControlador, escritorControlador);
						break;
					case "cliente":
						lblErrorCliente.setVisible(true);
						break;
					}
				} else {
					lblErrorCliente.setVisible(false);
					lblError.setVisible(true);
				}
				
			}
			
		});
		btnIngresar.setBounds(104, 210, 105, 32);
		contentPane.add(btnIngresar);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Registrarse registrarse = new Registrarse();
				
			}
			
		});
		btnRegistrarse.setBounds(235, 210, 105, 32);
		contentPane.add(btnRegistrarse);
	}
}
