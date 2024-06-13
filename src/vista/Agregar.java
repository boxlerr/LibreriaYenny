package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.UsuarioControlador;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

import controlador.*;
import modelos.*;

public class Agregar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private UsuarioControlador controlador = new UsuarioControlador();
	private JTextField InpMail;
	private JTextField InpContrasena;
	private JTextField InpTipo;

	public Agregar() {
		this(new Usuario());
	}
		
	public Agregar(Usuario usuario) {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngreseMail = new JLabel("Ingrese mail del usuario:");
		lblIngreseMail.setBounds(10, 35, 164, 14);
		contentPane.add(lblIngreseMail);
		
		InpMail = new JTextField();
		InpMail.setBounds(11, 58, 131, 20);
		contentPane.add(InpMail);
		InpMail.setColumns(10);
		
		JLabel lblIngreseContrasena = new JLabel("Ingrese contraseña del usuario:");
		lblIngreseContrasena.setBounds(10, 109, 228, 14);
		contentPane.add(lblIngreseContrasena);
		
		InpContrasena = new JTextField();
		InpContrasena.setColumns(10);
		InpContrasena.setBounds(11, 129, 131, 20);
		contentPane.add(InpContrasena);
		
		JLabel lblIngreseTipo = new JLabel("Ingrese tipo del usuario:");
		lblIngreseTipo.setBounds(10, 191, 164, 14);
		contentPane.add(lblIngreseTipo);
		
		InpTipo = new JTextField();
		InpTipo.setColumns(10);
		InpTipo.setBounds(11, 214, 131, 20);
		contentPane.add(InpTipo);
		
		JLabel lblErrorMail = new JLabel("Ingrese un mail válido");
		lblErrorMail.setForeground(new Color(255, 0, 0));
		lblErrorMail.setBounds(157, 61, 146, 14);
		lblErrorMail.setVisible(false);
		contentPane.add(lblErrorMail);
		
		JLabel lblErrorContrasena = new JLabel("Ingrese una contraseña válida");
		lblErrorContrasena.setForeground(Color.RED);
		lblErrorContrasena.setBounds(154, 132, 193, 14);
		lblErrorContrasena.setVisible(false);
		contentPane.add(lblErrorContrasena);
		
		JLabel lblErrorTipo = new JLabel("Ingrese un tipo válido");
		lblErrorTipo.setForeground(Color.RED);
		lblErrorTipo.setBounds(154, 217, 149, 14);
		lblErrorTipo.setVisible(false);
		contentPane.add(lblErrorTipo);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(335, 85, 89, 39);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mails="";
				for (int i = 0; i < controlador.getAllUsers().size(); i++) {
					mails = mails + controlador.getAllUsers().get(i).getMail();
				}
				
				
				if (!InpMail.getText().contains("@") || !InpMail.getText().contains(".")) {
					lblErrorMail.setVisible(true);
					
				} else if (InpContrasena.getText().length()<6) {
					lblErrorContrasena.setVisible(true);
					
				} else if (!InpTipo.getText().equalsIgnoreCase("Gerente") && !InpTipo.getText().equalsIgnoreCase("Empleado") && !InpTipo.getText().equalsIgnoreCase("Escritor")) {
					lblErrorTipo.setVisible(true);
					
				} else {
					usuario.setMail(InpMail.getText());
					usuario.setContraseña(InpContrasena.getText());
					usuario.setTipo(InpTipo.getText());
					controlador.addUser(usuario);
					dispose();
					PantallaCuentas pantallaCuentas = new PantallaCuentas();
				}
				}
		});	
		contentPane.add(btnAgregar);
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PantallaCuentas pantallaCuentas = new PantallaCuentas();
				
			}
			
		});
		btnCancelar.setBounds(335, 151, 89, 45);
		contentPane.add(btnCancelar);
		
		
		
	}
}
