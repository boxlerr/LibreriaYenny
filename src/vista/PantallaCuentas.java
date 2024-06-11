package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
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
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAgregar.setBounds(41, 207, 89, 43);
		contentPane.add(btnAgregar);
		
		JButton btnEliminar = new JButton("Eliminar");
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
		btnEliminar.setBounds(171, 207, 89, 43);
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
		btnEditar.setBounds(301, 207, 89, 43);
		contentPane.add(btnEditar);
		
	
	}
	
	private void actualizarTabla() {
		model.setRowCount(0);
		
		List<Usuario> usuarios = controlador.getAllUsers();
		
		for (Usuario usuario : usuarios) {
			model.addRow(new Object[]{usuario.getId(), usuario.getMail(), usuario.getContraseña(), usuario.getTipo()});
		}
	}
}
