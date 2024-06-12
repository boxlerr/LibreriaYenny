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

public class PantallaVerInventario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
    private DefaultTableModel model;
    private LibroControlador libroControlador;
    private Libro libroSeleccionado;
   
    
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
		setBounds(100, 100, 787, 478);
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
		scrollPane.setBounds(10, 24, 753, 287);
		contentPane.add(scrollPane);
		
		JLabel lblSeleccionado = new JLabel("Seleccionado:");
		lblSeleccionado.setBounds(10, 7, 753, 14);
		contentPane.add(lblSeleccionado);
		
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PantallaGerente pantallaGerente = new PantallaGerente();
			}
		});
		btnVolver.setBounds(674, 355, 89, 43);
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
                        int idSucursal = (int) table.getValueAt(selectedRow, 5);
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

}
