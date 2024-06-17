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
import javax.swing.JTextField;
import java.awt.Font;

public class PantallaCuentas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
    private DefaultTableModel model;
    private UsuarioControlador controlador;
    private Usuario seleccionado;
    private JButton Editar;
    private JTextField inpFiltrarMail;
    private JTextField inpFiltrarTipo;


    
	public PantallaCuentas() {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 426);
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
		scrollPane.setBounds(10, 24, 559, 195);
		contentPane.add(scrollPane);
		
		JLabel lblSeleccionado = new JLabel("Seleccionado:");
		lblSeleccionado.setBounds(10, 7, 414, 14);
		contentPane.add(lblSeleccionado);
		
		JButton btnAgregar = new JButton("Agregar ");
		btnAgregar.setBounds(43, 340, 89, 43);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Agregar agregar = new Agregar();
				dispose();
				
			}
		});
		contentPane.add(btnAgregar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(175, 340, 89, 43);
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
		btnEditar.setBounds(307, 340, 89, 43);
		contentPane.add(btnEditar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PantallaGerente pantallaGerente = new PantallaGerente();
			}
		});
		btnVolver.setBounds(439, 340, 89, 43);
		contentPane.add(btnVolver);
		
		JLabel lblFiltrarMail = new JLabel("Ingrese un mail para filtrar");
		lblFiltrarMail.setBounds(10, 230, 266, 14);
		contentPane.add(lblFiltrarMail);
		
		JLabel lblFiltrarTipo = new JLabel("Ingrese un tipo para filtrar");
		lblFiltrarTipo.setBounds(303, 230, 266, 14);
		contentPane.add(lblFiltrarTipo);
		
		
		inpFiltrarMail = new JTextField();
		inpFiltrarMail.setBounds(10, 246, 175, 26);
		contentPane.add(inpFiltrarMail);
		inpFiltrarMail.setColumns(10);
				
		inpFiltrarTipo = new JTextField();
		inpFiltrarTipo.setColumns(10);
		inpFiltrarTipo.setBounds(302, 246, 175, 26);
		contentPane.add(inpFiltrarTipo);
		
		
		JButton btnFiltrarMail = new JButton("Filtrar");
		btnFiltrarMail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtrarMail(inpFiltrarMail.getText());
			}
		});
		btnFiltrarMail.setBounds(189, 245, 89, 28);
		contentPane.add(btnFiltrarMail);
		
		JButton btnFiltrarTipo = new JButton("Filtrar");
		btnFiltrarTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtrarTipo(inpFiltrarTipo.getText());
			}
		});
		btnFiltrarTipo.setBounds(480, 245, 89, 28);
		contentPane.add(btnFiltrarTipo);
		
		JButton btnBorrarFiltros = new JButton("Borrar Filtros");
		btnBorrarFiltros.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBorrarFiltros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarTabla();
				inpFiltrarMail.setText(null);
				inpFiltrarTipo.setText(null);
			}
		});
		btnBorrarFiltros.setBounds(10, 283, 122, 33);
		contentPane.add(btnBorrarFiltros);
		
	
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
	
	private void filtrarTipo(String criterio) {
		model.setRowCount(0);
		
		List<Usuario> usuarios = controlador.getAllUsers();
		
		for (Usuario usuario : usuarios) {
			if (usuario.getTipo().equalsIgnoreCase(criterio)) {
				model.addRow(new Object[]{usuario.getId(), usuario.getMail(), usuario.getContraseña(), usuario.getTipo()});
			}
		}
	}
	
	private void filtrarMail(String criterio) {
		model.setRowCount(0);
		
		List<Usuario> usuarios = controlador.getAllUsers();
		
		for (Usuario usuario : usuarios) {
			if (usuario.getMail().equalsIgnoreCase(criterio)) {
				model.addRow(new Object[]{usuario.getId(), usuario.getMail(), usuario.getContraseña(), usuario.getTipo()});
			}
		}
	}
}
