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
		InpMail.setBounds(26, 47, 86, 20);
		contentPane.add(InpMail);
		InpMail.setColumns(10);
		
		JLabel lblMailAnterior = new JLabel("Mail Anterior");
		lblMailAnterior.setBounds(26, 22, 129, 14);
		contentPane.add(lblMailAnterior);
		lblMailAnterior.setText("Mail anterior: " + usuario.getMail());
		
		JLabel lblContrasenaAnterior = new JLabel("Contraseña Anterior");
		lblContrasenaAnterior.setBounds(26, 100, 164, 14);
		contentPane.add(lblContrasenaAnterior);
		lblContrasenaAnterior.setText("Contraseña anterior: " + usuario.getContraseña());
		
		JLabel lblTipoAnterior = new JLabel("Tipo Anterior");
		lblTipoAnterior.setBounds(26, 178, 129, 14);
		contentPane.add(lblTipoAnterior);
		lblTipoAnterior.setText("Tipo anterior: " + usuario.getTipo());
		
		InpTipo = new JTextField();
		InpTipo.setColumns(10);
		InpTipo.setBounds(26, 203, 86, 20);
		contentPane.add(InpTipo);
		
		JLabel lblErrorMail = new JLabel("Ingrese  un mail válido");
		lblErrorMail.setForeground(new Color(255, 0, 0));
		lblErrorMail.setBounds(122, 50, 117, 14);
		contentPane.add(lblErrorMail);
		lblErrorMail.setVisible(false);
		
		JLabel lblErrorContrasena = new JLabel("Ingrese  una contraseña válida");
		lblErrorContrasena.setForeground(Color.RED);
		lblErrorContrasena.setBounds(122, 128, 158, 14);
		contentPane.add(lblErrorContrasena);
		lblErrorContrasena.setVisible(false);
		
		JLabel lblErrorTipo = new JLabel("Ingrese  un tipo válido");
		lblErrorTipo.setForeground(Color.RED);
		lblErrorTipo.setBounds(122, 206, 117, 14);
		contentPane.add(lblErrorTipo);
		lblErrorTipo.setVisible(false);
		
		InpContrasena = new JTextField();
		InpContrasena.setColumns(10);
		InpContrasena.setBounds(26, 125, 86, 20);
		contentPane.add(InpContrasena);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flagMailValido = controlador.verificarMailValido(InpMail.getText());
				boolean flagMailExistencia = controlador.verificarMailExistencia(InpMail.getText());
				
				if (!flagMailValido) {
					lblErrorMail.setVisible(true);
				} else if (!flagMailExistencia) {
					lblErrorMail.setVisible(true);
				} else {
					usuario.setMail(InpMail.getText());
					usuario.setContraseña(InpContrasena.getText());
					usuario.setTipo(InpTipo.getText());
					controlador.updateUser(usuario);
				}
				
			}
		});
		
		btnEditar.setBounds(323, 191, 76, 45);
		contentPane.add(btnEditar);
		
		
	}
}
