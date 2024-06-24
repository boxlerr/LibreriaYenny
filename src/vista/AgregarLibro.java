package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.LibroControlador;
import modelos.Libro;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AgregarLibro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private LibroControlador libroControlador = new LibroControlador();
	private JTextField inpTitulo;
	private JTextField inpAutor;
	private JTextField inpGenero;
	private JLabel lblStock;
	private JTextField inpStock;
	private JLabel lblPrecio;
	private JTextField inpPrecio;
	private JLabel lblIdSucursal;
	private JTextField inpIdSucursal;
	private JButton btnVolver;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarLibro frame = new AgregarLibro();
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
	
	public AgregarLibro() {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Ingrese un titulo");
		lblTitulo.setBounds(61, 11, 105, 14);
		contentPane.add(lblTitulo);
		
		inpTitulo = new JTextField();
		inpTitulo.setBounds(45, 28, 117, 20);
		contentPane.add(inpTitulo);
		inpTitulo.setColumns(10);
		
		JLabel lblAutor = new JLabel("Ingrese un autor");
		lblAutor.setBounds(227, 11, 117, 14);
		contentPane.add(lblAutor);
		
		inpAutor = new JTextField();
		inpAutor.setColumns(10);
		inpAutor.setBounds(211, 28, 117, 20);
		contentPane.add(inpAutor);
		
		JLabel lblGenero = new JLabel("Ingrese un genero");
		lblGenero.setBounds(405, 11, 117, 14);
		contentPane.add(lblGenero);
		
		inpGenero = new JTextField();
		inpGenero.setColumns(10);
		inpGenero.setBounds(393, 28, 117, 20);
		contentPane.add(inpGenero);
		
		lblStock = new JLabel("Ingrese un stock");
		lblStock.setBounds(61, 77, 105, 14);
		contentPane.add(lblStock);
		
		inpStock = new JTextField();
		inpStock.setColumns(10);
		inpStock.setBounds(45, 94, 117, 20);
		contentPane.add(inpStock);
		
		lblPrecio = new JLabel("Ingrese un precio");
		lblPrecio.setBounds(227, 77, 117, 14);
		contentPane.add(lblPrecio);
		
		inpPrecio = new JTextField();
		inpPrecio.setColumns(10);
		inpPrecio.setBounds(211, 94, 117, 20);
		contentPane.add(inpPrecio);
		
		lblIdSucursal = new JLabel("Ingrese un id de sucursal");
		lblIdSucursal.setBounds(405, 77, 140, 14);
		contentPane.add(lblIdSucursal);
		
		inpIdSucursal = new JTextField();
		inpIdSucursal.setColumns(10);
		inpIdSucursal.setBounds(393, 94, 117, 20);
		contentPane.add(inpIdSucursal);
		
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.setBounds(129, 233, 105, 38);
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Libro libro = new Libro(inpTitulo.getText(), inpAutor.getText(), inpGenero.getText(), Integer.parseInt(inpStock.getText()), inpPrecio.getText(), Integer.parseInt(inpIdSucursal.getText()));
				libroControlador.addLibro(libro);
				dispose();
				PantallaAdministrarLibros pantallaAdministrarLibros = new PantallaAdministrarLibros();
			}
		});
		contentPane.add(btnCrear);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(313, 233, 105, 38);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PantallaAdministrarLibros pantallaAdministrarLibros = new PantallaAdministrarLibros();
			}
		});
		contentPane.add(btnVolver);
	}
}
