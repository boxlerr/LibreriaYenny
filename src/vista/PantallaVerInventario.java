package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controlador.LibroControlador;
import controlador.UsuarioControlador;
import modelos.*;
import javax.swing.JTextField;

public class PantallaVerInventario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
    private DefaultTableModel model;
    private LibroControlador libroControlador;
    private Libro libroSeleccionado;
    private JTextField inpFiltroSucursal;
    private JTextField inpFiltrarGenero;
    private JTextField inpFiltrarAutor;
    private JTextField inpFiltrarTitulo;
   
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaVerInventario frame = new PantallaVerInventario();
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
	public PantallaVerInventario() {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 858, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		libroControlador = new LibroControlador();
		libroSeleccionado = new Libro();
		
		
		String[] columnNames = {"ID", "Título", "Autor", "Género", "Stock", "Precio", "ID_Sucursal"};
		model = new DefaultTableModel(columnNames, 0);
		table = new JTable(model);
		actualizarTabla();
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 24, 824, 287);
		contentPane.add(scrollPane);
		
		JLabel lblSeleccionado = new JLabel("Seleccionado:");
		lblSeleccionado.setBounds(10, 7, 824, 14);
		contentPane.add(lblSeleccionado);
		
		JLabel lblFiltroSucursal = new JLabel("Ingrese un ID_ sucursal para filtrar");
		lblFiltroSucursal.setBounds(10, 320, 255, 13);
		contentPane.add(lblFiltroSucursal);
		
		inpFiltroSucursal = new JTextField();
		inpFiltroSucursal.setBounds(10, 335, 160, 19);
		contentPane.add(inpFiltroSucursal);
		inpFiltroSucursal.setColumns(10);
		
		JButton btnFiltrarSucursal = new JButton("Filtrar");
		btnFiltrarSucursal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtrarSucursal(Integer.parseInt(inpFiltroSucursal.getText()));
			}
		});
		btnFiltrarSucursal.setBounds(175, 334, 85, 21);
		contentPane.add(btnFiltrarSucursal);
		
		JLabel lblIngreseUnGenero = new JLabel("Ingrese un genero para filtrar");
		lblIngreseUnGenero.setBounds(10, 364, 255, 13);
		contentPane.add(lblIngreseUnGenero);
		
		inpFiltrarGenero = new JTextField();
		inpFiltrarGenero.setColumns(10);
		inpFiltrarGenero.setBounds(10, 379, 160, 19);
		contentPane.add(inpFiltrarGenero);
		
		JButton btnFiltrarGenero = new JButton("Filtrar");
		btnFiltrarGenero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtrarGenero(inpFiltrarGenero.getText());
			}
		});
		btnFiltrarGenero.setBounds(175, 378, 85, 21);
		contentPane.add(btnFiltrarGenero);
		
		JLabel lblIngreseUnAutor = new JLabel("Ingrese un autor para filtrar");
		lblIngreseUnAutor.setBounds(275, 321, 255, 13);
		contentPane.add(lblIngreseUnAutor);
		
		inpFiltrarAutor = new JTextField();
		inpFiltrarAutor.setColumns(10);
		inpFiltrarAutor.setBounds(275, 336, 160, 19);
		contentPane.add(inpFiltrarAutor);
		
		JButton btnFiltrarAutor = new JButton("Filtrar");
		btnFiltrarAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtrarAutor(inpFiltrarAutor.getText());
			}
		});
		btnFiltrarAutor.setBounds(440, 335, 85, 21);
		contentPane.add(btnFiltrarAutor);
		
		JLabel lblIngreseUnTitulo = new JLabel("Ingrese un titulo para filtrar");
		lblIngreseUnTitulo.setBounds(275, 364, 255, 13);
		contentPane.add(lblIngreseUnTitulo);
		
		inpFiltrarTitulo = new JTextField();
		inpFiltrarTitulo.setColumns(10);
		inpFiltrarTitulo.setBounds(275, 379, 160, 19);
		contentPane.add(inpFiltrarTitulo);
		
		JButton btnFiltrarTitulo = new JButton("Filtrar");
		btnFiltrarTitulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtrarTitulo(inpFiltrarTitulo.getText());
			}
		});
		btnFiltrarTitulo.setBounds(440, 378, 85, 21);
		contentPane.add(btnFiltrarTitulo);
		
		JButton btnEliminarFiltros = new JButton("Eliminar Filtros");
		btnEliminarFiltros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarTabla();
			}
		});
		btnEliminarFiltros.setBounds(575, 345, 139, 43);
		contentPane.add(btnEliminarFiltros);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PantallaGerente pantallaGerente = new PantallaGerente();
			}
		});
		btnVolver.setBounds(762, 345, 72, 43);
		contentPane.add(btnVolver);
		
		
		
		
	
		ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        int id = (int) table.getValueAt(selectedRow, 0);
                        String titulo = (String) table.getValueAt(selectedRow, 1);
                        String autor = (String) table.getValueAt(selectedRow, 2);
                        String genero = (String) table.getValueAt(selectedRow, 3);
                        int stock = (int) table.getValueAt(selectedRow, 4);
                        String precio = (String) table.getValueAt(selectedRow, 5);
                        int idSucursal = (int) table.getValueAt(selectedRow, 6);
                        lblSeleccionado.setText("Seleccionado: ID = " + id + ", Título = " + titulo + ", Autor = " + autor + "Género = " + genero + "Stock = " + stock + "Precio = " + precio + "ID_Sucursal = " + idSucursal );
                        libroSeleccionado.setIdLibro(id);
                        libroSeleccionado.setTitulo(titulo);
                        libroSeleccionado.setAutor(autor);
                        libroSeleccionado.setGenero(genero);
                        libroSeleccionado.setStock(stock);
                        libroSeleccionado.setPrecio(precio);
                        libroSeleccionado.setIdSucursal_fk(idSucursal);
                    }
                }
            }
        });
		
	}

	private void actualizarTabla() {
		model.setRowCount(0);
		
		List<Libro> libros = libroControlador.getAllLibros();
		
		for (Libro libro : libros) {
			model.addRow(new Object[]{libro.getIdLibro(), libro.getTitulo(), libro.getAutor(), libro.getGenero(), libro.getStock(), libro.getPrecio(), libro.getIdSucursal_fk()});
			
		}
	}
	private void filtrarSucursal(int criterio) {
		model.setRowCount(0);
		
		List<Libro> libros = libroControlador.getAllLibros();
		
		for (Libro libro : libros) {
			if (libro.getIdSucursal_fk()==criterio) {
				model.addRow(new Object[]{libro.getIdLibro(), libro.getTitulo(), libro.getAutor(), libro.getGenero(), libro.getStock(), libro.getPrecio(), libro.getIdSucursal_fk()});
			}
			
			
		}
	}
	private void filtrarGenero(String criterio) {
		model.setRowCount(0);
		
		List<Libro> libros = libroControlador.getAllLibros();
		
		for (Libro libro : libros) {
			if (libro.getGenero().equalsIgnoreCase(criterio)) {
				model.addRow(new Object[]{libro.getIdLibro(), libro.getTitulo(), libro.getAutor(), libro.getGenero(), libro.getStock(), libro.getPrecio(), libro.getIdSucursal_fk()});
			}
			
			
		}
	}
	private void filtrarAutor(String criterio) {
		model.setRowCount(0);
		
		List<Libro> libros = libroControlador.getAllLibros();
		
		for (Libro libro : libros) {
			if (libro.getAutor().equalsIgnoreCase(criterio)) {
				model.addRow(new Object[]{libro.getIdLibro(), libro.getTitulo(), libro.getAutor(), libro.getGenero(), libro.getStock(), libro.getPrecio(), libro.getIdSucursal_fk()});
			}
			
			
		}
	}
	private void filtrarTitulo(String criterio) {
		model.setRowCount(0);
		
		List<Libro> libros = libroControlador.getAllLibros();
		
		for (Libro libro : libros) {
			if (libro.getTitulo().equalsIgnoreCase(criterio)) {
				model.addRow(new Object[]{libro.getIdLibro(), libro.getTitulo(), libro.getAutor(), libro.getGenero(), libro.getStock(), libro.getPrecio(), libro.getIdSucursal_fk()});
			}
			
			
		}
	}
}
