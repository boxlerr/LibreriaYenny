package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.LibroControlador;
import modelos.Libro;

public class AgregarLibro extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private LibroControlador libroControlador = new LibroControlador();
    private JTextField inpTitulo;
    private JTextField inpAutor;
    private JTextField inpGenero;
    private JTextField inpStock;
    private JTextField inpPrecio;
    private JTextField inpIdSucursal;

    public AgregarLibro() {
    	this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 453, 398);
        setTitle("Agregar Libro");

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("Ingrese un título:");
        lblTitulo.setBounds(45, 30, 100, 20);
        contentPane.add(lblTitulo);

        inpTitulo = new JTextField();
        inpTitulo.setBounds(190, 30, 150, 20);
        contentPane.add(inpTitulo);

        JLabel lblAutor = new JLabel("Ingrese un autor:");
        lblAutor.setBounds(45, 70, 100, 20);
        contentPane.add(lblAutor);

        inpAutor = new JTextField();
        inpAutor.setBounds(190, 70, 150, 20);
        contentPane.add(inpAutor);

        JLabel lblGenero = new JLabel("Ingrese un género:");
        lblGenero.setBounds(45, 110, 110, 20);
        contentPane.add(lblGenero);

        inpGenero = new JTextField();
        inpGenero.setBounds(190, 110, 150, 20);
        contentPane.add(inpGenero);

        JLabel lblStock = new JLabel("Ingrese un stock:");
        lblStock.setBounds(45, 150, 110, 20);
        contentPane.add(lblStock);

        inpStock = new JTextField();
        inpStock.setBounds(190, 150, 150, 20);
        contentPane.add(inpStock);

        JLabel lblPrecio = new JLabel("Ingrese un precio:");
        lblPrecio.setBounds(45, 190, 110, 20);
        contentPane.add(lblPrecio);

        inpPrecio = new JTextField();
        inpPrecio.setBounds(190, 190, 150, 20);
        contentPane.add(inpPrecio);

        JLabel lblIdSucursal = new JLabel("Ingrese un ID de sucursal:");
        lblIdSucursal.setBounds(45, 230, 155, 20);
        contentPane.add(lblIdSucursal);

        inpIdSucursal = new JTextField();
        inpIdSucursal.setBounds(190, 230, 150, 20);
        contentPane.add(inpIdSucursal);

        JButton btnCrear = new JButton("Crear");
        btnCrear.setBounds(100, 280, 100, 30);
        btnCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Libro libro = new Libro(
                        inpTitulo.getText(),
                        inpAutor.getText(),
                        inpGenero.getText(),
                        Integer.parseInt(inpStock.getText()),
                        inpPrecio.getText(),
                        Integer.parseInt(inpIdSucursal.getText())
                );
                libroControlador.addLibro(libro);
                dispose();
                new PantallaAdministrarLibros().setVisible(true);
            }
        });
        contentPane.add(btnCrear);

        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(250, 280, 100, 30);
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new PantallaAdministrarLibros().setVisible(true);
            }
        });
        contentPane.add(btnVolver);
    }

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
}
