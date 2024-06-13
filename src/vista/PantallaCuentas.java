package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controlador.*;
import modelos.*;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PantallaCuentas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
    private DefaultTableModel model;
    private UsuarioControlador controlador;
    private Usuario seleccionado;
    private JButton Editar;


    
	public PantallaCuentas() {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		controlador = new UsuarioControlador();
		Usuario seleccionado = new Usuario();
		
		String[] columnNames = {"ID", "Mail", "Contraseña", "Tipo"};
		model = new DefaultTableModel(columnNames, 0);
		table = new JTable(model);
		actualizarTabla();
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 24, 414, 156);
		contentPane.add(scrollPane);
		
		JLabel lblSeleccionado = new JLabel("Seleccionado:");
		lblSeleccionado.setBounds(10, 7, 75, 14);
		contentPane.add(lblSeleccionado);
		
		JButton btnAgregar = new JButton("Agregar ");
		btnAgregar.setBounds(15, 207, 89, 43);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Agregar agregar = new Agregar();
				dispose();
				
			}
		});
		contentPane.add(btnAgregar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(119, 207, 89, 43);
		btnEliminar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		if (seleccionado.getId()!=0) {
					
        			controlador.deleteUser(seleccionado.getId());
        			JOptionPane.showMessageDialog(null, "Eliminado");
        			 actualizarTabla();
				} else {
					JOptionPane.showMessageDialog(null, "Seleccione un usuario");
				}
        	}
        });
		contentPane.add(btnEliminar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (seleccionado.getId()!=0) {
					
        			Editar editar = new Editar(seleccionado);
        			dispose();			
				} else {
					JOptionPane.showMessageDialog(null, "Seleccione un usuario");
				}		
        	}
        });
		btnEditar.setBounds(223, 207, 89, 43);
		contentPane.add(btnEditar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PantallaGerente pantallaGerente = new PantallaGerente();
			}
		});
		btnVolver.setBounds(327, 207, 89, 43);
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
                        String mail = (String) table.getValueAt(selectedRow, 1);
                        String contraseña = (String) table.getValueAt(selectedRow, 2);
                        String tipo = (String) table.getValueAt(selectedRow, 3);
                        lblSeleccionado.setText("Seleccionado: ID = " + id + ", Mail = " + mail + ", Contraseña = " + contraseña + "Tipo de Usuario = " + tipo );
                        seleccionado.setMail(mail);
                        seleccionado.setContraseña(contraseña);
                        seleccionado.setId(id);
                        seleccionado.setTipo(tipo);
                    }
                }
            }
        });
		
	}
	
	private void actualizarTabla() {
		model.setRowCount(0);
		
		List<Usuario> usuarios = controlador.getAllUsers();
		
		for (Usuario usuario : usuarios) {
			model.addRow(new Object[]{usuario.getId(), usuario.getMail(), usuario.getContraseña(), usuario.getTipo()});
		}
	}
}
