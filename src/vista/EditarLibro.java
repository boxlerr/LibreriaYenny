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
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;

public class EditarLibro extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private LibroControlador libroControlador = new LibroControlador();
    private JTextField inpTitulo;
    private JTextField inpAutor;
    private JTextField inpStock;
    private JTextField inpPrecio;
    private JButton btnVolver;
    private JLabel lblTituloAnterior;
    private JLabel lblAutorAnterior;
    private JLabel lblStockAnterior;
    private JLabel lblPrecioAnterior;
    private JLabel lblGeneroAnterior;
    private JLabel lblIdSucursalAnterior;
    private JLabel lblErrorStock;
    private JLabel lblErrorPrecio;
    
    public boolean contieneSoloNumeros(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false; 
            }
        }
        return true; 
    }

    public EditarLibro(Libro libro) {
    	this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 378, 347);
        setTitle("Editar Libro");

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("Ingrese un título");
        lblTitulo.setBounds(45, 11, 117, 14);
        contentPane.add(lblTitulo);
        
        lblTituloAnterior = new JLabel("Titulo anterior:");
        lblTituloAnterior.setFont(new Font("Tahoma", Font.PLAIN, 9));
        lblTituloAnterior.setBounds(10, 52, 191, 14);
        contentPane.add(lblTituloAnterior);
        lblTituloAnterior.setText("Titulo anterior: " + libro.getTitulo());
        
        lblAutorAnterior = new JLabel("Autor anterior:");
        lblAutorAnterior.setFont(new Font("Tahoma", Font.PLAIN, 9));
        lblAutorAnterior.setBounds(197, 52, 176, 14);
        contentPane.add(lblAutorAnterior);
        lblAutorAnterior.setText("Autor anterior: " + libro.getAutor());
        
        lblStockAnterior = new JLabel("Stock anterior:");
        lblStockAnterior.setFont(new Font("Tahoma", Font.PLAIN, 9));
        lblStockAnterior.setBounds(10, 118, 152, 14);
        contentPane.add(lblStockAnterior);
        lblStockAnterior.setText("Stock anterior: " + libro.getStock());
        
        lblPrecioAnterior = new JLabel("Precio anterior:");
        lblPrecioAnterior.setFont(new Font("Tahoma", Font.PLAIN, 9));
        lblPrecioAnterior.setBounds(197, 118, 176, 14);
        contentPane.add(lblPrecioAnterior);
        lblPrecioAnterior.setText("Precio anterior: " + libro.getPrecio());
        
        lblGeneroAnterior = new JLabel("Genero anterior:");
        lblGeneroAnterior.setFont(new Font("Tahoma", Font.PLAIN, 9));
        lblGeneroAnterior.setBounds(10, 197, 191, 14);
        contentPane.add(lblGeneroAnterior);
        lblGeneroAnterior.setText("Genero anterior: " + libro.getGenero());
        
        lblIdSucursalAnterior = new JLabel("ID Sucursal anterior:");
        lblIdSucursalAnterior.setFont(new Font("Tahoma", Font.PLAIN, 9));
        lblIdSucursalAnterior.setBounds(197, 197, 176, 14);
        contentPane.add(lblIdSucursalAnterior);
        lblIdSucursalAnterior.setText("ID Sucursal anterior: " + libro.getIdSucursal_fk());


        inpTitulo = new JTextField();
        inpTitulo.setBounds(45, 28, 117, 20);
        contentPane.add(inpTitulo);
        inpTitulo.setColumns(10);

        JLabel lblAutor = new JLabel("Ingrese un autor");
        lblAutor.setBounds(211, 11, 117, 14);
        contentPane.add(lblAutor);

        inpAutor = new JTextField();
        inpAutor.setColumns(10);
        inpAutor.setBounds(211, 28, 117, 20);
        contentPane.add(inpAutor);

        JLabel lblGenero = new JLabel("Ingrese un género");
        lblGenero.setBounds(45, 154, 117, 14);
        contentPane.add(lblGenero);

        JLabel lblStock = new JLabel("Ingrese un stock");
        lblStock.setBounds(45, 77, 117, 14);
        contentPane.add(lblStock);

        inpStock = new JTextField();
        inpStock.setColumns(10);
        inpStock.setBounds(45, 94, 117, 20);
        contentPane.add(inpStock);

        JLabel lblPrecio = new JLabel("Ingrese un precio");
        lblPrecio.setBounds(219, 77, 109, 14);
        contentPane.add(lblPrecio);

        inpPrecio = new JTextField();
        inpPrecio.setColumns(10);
        inpPrecio.setBounds(211, 94, 117, 20);
        contentPane.add(inpPrecio);

        JLabel lblIdSucursal = new JLabel("Ingrese un ID de sucursal");
        lblIdSucursal.setBounds(210, 154, 191, 14);
        contentPane.add(lblIdSucursal);

        lblErrorStock = new JLabel("Stock invalido");
        lblErrorStock.setVisible(false);
        lblErrorStock.setForeground(new Color(255, 0, 0));
        lblErrorStock.setFont(new Font("Tahoma", Font.PLAIN, 9));
        lblErrorStock.setBounds(45, 135, 118, 13);
        contentPane.add(lblErrorStock);
        
        lblErrorPrecio = new JLabel("Precio invalido");
        lblErrorPrecio.setVisible(false);
        lblErrorPrecio.setForeground(Color.RED);
        lblErrorPrecio.setFont(new Font("Tahoma", Font.PLAIN, 9));
        lblErrorPrecio.setBounds(213, 135, 118, 13);
        contentPane.add(lblErrorPrecio);
        
        JComboBox comboBoxGenero = new JComboBox();
        comboBoxGenero.setBounds(45, 173, 114, 22);
        contentPane.add(comboBoxGenero);
        comboBoxGenero.addItem("Terror");
        comboBoxGenero.addItem("Ciencia Ficcion");
        comboBoxGenero.addItem("Novela");
        comboBoxGenero.addItem("Misterio");
        comboBoxGenero.addItem("Romance");
        
        JComboBox comboBoxIdSucursal = new JComboBox();
        comboBoxIdSucursal.setBounds(212, 171, 114, 22);
        contentPane.add(comboBoxIdSucursal);
        comboBoxIdSucursal.addItem("1");
        comboBoxIdSucursal.addItem("2");
        comboBoxIdSucursal.addItem("3");
        
        
        
        
        
        JButton btnEditar = new JButton("Editar");
        btnEditar.setBounds(51, 222, 105, 38);
        btnEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	boolean FlagStock=contieneSoloNumeros(inpStock.getText());
                boolean FlagPrecio=contieneSoloNumeros(inpPrecio.getText());
                
            	if (FlagStock==false&&FlagPrecio==false) {
            		lblErrorStock.setVisible(true);
            		lblErrorPrecio.setVisible(true);
				} else if(FlagStock==false) {
					lblErrorStock.setVisible(true);
            		lblErrorPrecio.setVisible(false);
				} else if(FlagPrecio==false) {
					lblErrorStock.setVisible(false);
            		lblErrorPrecio.setVisible(true);
				} else {
					Libro libroModificado = new Libro(
	                        libro.getIdLibro(),
	                        inpTitulo.getText(),
	                        inpAutor.getText(),
	                        (String) comboBoxGenero.getSelectedItem(),
	                        Integer.parseInt(inpStock.getText()),
	                        inpPrecio.getText(),
	                        (int) Integer.parseInt(comboBoxIdSucursal.getSelectedItem().toString())
	                );
	                libroControlador.updateLibro(libroModificado);
	                dispose();
	                new PantallaAdministrarLibros().setVisible(true);
				}
            	
                
            }
        });
        contentPane.add(btnEditar);

        btnVolver = new JButton("Volver");
        btnVolver.setBounds(217, 222, 105, 38);
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new PantallaAdministrarLibros().setVisible(true);
            }
        });
        contentPane.add(btnVolver);
        
        
        
        
        
    }
}
