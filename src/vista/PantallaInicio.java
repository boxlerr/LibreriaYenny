package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PantallaInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(178, 11, 156, 67);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnNewButton.setBounds(205, 274, 102, 45);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(116, 204, 280, 45);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(116, 123, 280, 45);
		contentPane.add(textField_1);
		
		JLabel InputNombre = new JLabel("Nombre:");
		InputNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		InputNombre.setBounds(116, 98, 73, 14);
		contentPane.add(InputNombre);
		
		JLabel InputContrasena = new JLabel("Contraseña:");
		InputContrasena.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		InputContrasena.setBounds(116, 179, 73, 14);
		contentPane.add(InputContrasena);
		
		JLabel lblNewLabel_2 = new JLabel("Error al ingresar nombre");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(198, 98, 208, 14);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);
		
		JLabel lblNewLabel_3 = new JLabel("Error al ingresar contraseña");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(203, 179, 193, 14);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setVisible(false);
		btnNewButton.addActionListener(new ActionListener ( ) {
			public void ActionPerformed(ActionEvent e) {
				boolean flag=true;
				if (InputNombre.getText().isEmpty()) {
					lblNewLabel_2.setVisible(true);
					flag=false;
				} else {
					lblNewLabel_2.setVisible(false);
				}
				if (InputContrasena.getText().isEmpty()) {
					lblNewLabel_3.setVisible(true);
					flag=false;
				} else {
					lblNewLabel_3.setVisible(false);
				}
				if (flag) {
					PantallaHome nueva = new PantallaHome();
					dispose();
				}
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
