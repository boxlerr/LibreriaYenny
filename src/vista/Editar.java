package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.*;
import modelos.*;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;

public class Editar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private UsuarioControlador controlador = new UsuarioControlador();
	private JTextField InpMail;
	private JTextField InpContrasena;
	private JTextField InpTipo;

	public Editar(Usuario usuario) {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		InpMail = new JTextField();
		InpMail.setBounds(19, 62, 86, 20);
		contentPane.add(InpMail);
		InpMail.setColumns(10);
		
		JLabel lblMailAnterior = new JLabel("Mail Anterior");
		lblMailAnterior.setBounds(20, 20, 254, 14);
		contentPane.add(lblMailAnterior);
		lblMailAnterior.setText("Mail anterior: " + usuario.getMail());
		
		JLabel lblContrasenaAnterior = new JLabel("Contraseña Anterior");
		lblContrasenaAnterior.setBounds(20, 106, 254, 14);
		contentPane.add(lblContrasenaAnterior);
		lblContrasenaAnterior.setText("Contraseña anterior: " + usuario.getContraseña());
		
		JLabel lblTipoAnterior = new JLabel("Tipo Anterior");
		lblTipoAnterior.setBounds(20, 190, 254, 14);
		contentPane.add(lblTipoAnterior);
		lblTipoAnterior.setText("Tipo anterior: " + usuario.getTipo());
		
		InpTipo = new JTextField();
		InpTipo.setColumns(10);
		InpTipo.setBounds(19, 236, 86, 20);
		contentPane.add(InpTipo);
		
		JLabel lblErrorMail = new JLabel("Ingrese  un mail válido");
		lblErrorMail.setForeground(new Color(255, 0, 0));
		lblErrorMail.setBounds(119, 65, 155, 14);
		contentPane.add(lblErrorMail);
		lblErrorMail.setVisible(false);
		
		JLabel lblErrorContrasena = new JLabel("Ingrese  una contraseña válida");
		lblErrorContrasena.setForeground(Color.RED);
		lblErrorContrasena.setBounds(119, 151, 184, 14);
		contentPane.add(lblErrorContrasena);
		lblErrorContrasena.setVisible(false);
		
		JLabel lblErrorTipo = new JLabel("Ingrese  un tipo válido");
		lblErrorTipo.setForeground(Color.RED);
		lblErrorTipo.setBounds(119, 239, 155, 14);
		contentPane.add(lblErrorTipo);
		lblErrorTipo.setVisible(false);
		
		InpContrasena = new JTextField();
		InpContrasena.setColumns(10);
		InpContrasena.setBounds(19, 147, 86, 20);
		contentPane.add(InpContrasena);
		
		JLabel lblIngreseNuevoMail = new JLabel("Ingrese nuevo mail:");
		lblIngreseNuevoMail.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblIngreseNuevoMail.setBounds(21, 41, 103, 14);
		contentPane.add(lblIngreseNuevoMail);
		
		JLabel lblIngreseNuevaContrasea = new JLabel("Ingrese nueva contraseña:");
		lblIngreseNuevaContrasea.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblIngreseNuevaContrasea.setBounds(21, 128, 145, 14);
		contentPane.add(lblIngreseNuevaContrasea);
		
		JLabel lblIngreseNuevoTipo = new JLabel("Ingrese nuevo tipo:");
		lblIngreseNuevoTipo.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblIngreseNuevoTipo.setBounds(21, 214, 103, 14);
		contentPane.add(lblIngreseNuevoTipo);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(335, 91, 76, 45);
		btnEditar.addActionListener(new ActionListener() {
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
					controlador.updateUser(usuario);
					dispose();
					PantallaCuentas pantallaCuentas = new PantallaCuentas();
				} 
			}
		});
		contentPane.add(btnEditar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PantallaCuentas pantallaCuentas = new PantallaCuentas();
				
			}
			
		});
		btnCancelar.setBounds(335, 151, 76, 45);
		contentPane.add(btnCancelar);
		
		
		
	}
}
