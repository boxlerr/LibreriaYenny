package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.*;
import modelos.*;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;

public class Descuento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private UsuarioControlador controlador = new UsuarioControlador();
	private LibroControlador libroControlador = new LibroControlador();
	private JTextField InpDescuento;
	private static boolean contieneNumeros(String texto) {
        for (char c : texto.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
	
	public Descuento(Libro libro) {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 918, 234);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		InpDescuento = new JTextField();
		InpDescuento.setBounds(19, 86, 875, 20);
		contentPane.add(InpDescuento);
		InpDescuento.setColumns(10);
		
		JLabel lblLibro = new JLabel("Libro");
		lblLibro.setBounds(19, 10, 875, 14);
		contentPane.add(lblLibro);
		lblLibro.setText("Libro: " + libro.toString());
		
		JLabel lblErrorMail = new JLabel("Ingrese correctamente el descuento");
		lblErrorMail.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblErrorMail.setForeground(new Color(255, 0, 0));
		lblErrorMail.setBounds(380, 116, 152, 14);
		contentPane.add(lblErrorMail);
		lblErrorMail.setVisible(false);
		
		JLabel lblIngreseDescuento = new JLabel("Ingrese el descuento, especificando el % de descuento y el nuevo precio");
		lblIngreseDescuento.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblIngreseDescuento.setBounds(19, 73, 392, 14);
		contentPane.add(lblIngreseDescuento);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PantallaAplicarDescuento pantallaAplicarDescuento = new PantallaAplicarDescuento();
				
			}
			
		});
		btnCancelar.setBounds(488, 140, 96, 45);
		contentPane.add(btnCancelar);
		
		JLabel lblPrecioAnterior = new JLabel("Precio anterior: ");
		lblPrecioAnterior.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrecioAnterior.setBounds(19, 49, 351, 14);
		contentPane.add(lblPrecioAnterior);
		lblPrecioAnterior.setText("Precio anterior: " + libro.getPrecio());
		
		
		JButton btnAplicar = new JButton("Aplicar");
		btnAplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (InpDescuento.getText().contains("%") && contieneNumeros(InpDescuento.getText())) {
					libro.setPrecio(InpDescuento.getText());
					libroControlador.updateLibro(libro);
					dispose();
					PantallaAplicarDescuento pantallaAplicarDescuento = new PantallaAplicarDescuento();
				} else {
					lblErrorMail.setVisible(true);
				}
			}
			
		});
		btnAplicar.setBounds(315, 140, 96, 45);
		contentPane.add(btnAplicar);
		
		
		
	}
}
