package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.*;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaGerente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaGerente frame = new PantallaGerente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PantallaGerente() {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblQueDeseaHacer = new JLabel("¿Que desea hacer?");
		lblQueDeseaHacer.setFont(new Font("Arial", Font.BOLD, 16));
		lblQueDeseaHacer.setBounds(143, 24, 155, 32);
		contentPane.add(lblQueDeseaHacer);
		
		JButton btnAdministrarLibros = new JButton("Administrar Libros");
		btnAdministrarLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PantallaAdministrarLibros pantallaAdministrarLibros = new PantallaAdministrarLibros();
			}
		});
		btnAdministrarLibros.setBounds(40, 96, 154, 34);
		contentPane.add(btnAdministrarLibros);
		
		JButton btnAdministrarCuentas = new JButton("Administrar Cuentas");
		btnAdministrarCuentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PantallaCuentas pantallaCuentas = new PantallaCuentas();
			}
		});
		btnAdministrarCuentas.setBounds(40, 155, 154, 32);
		contentPane.add(btnAdministrarCuentas);
		
		JButton btnVerInventario = new JButton("Ver Inventario");
		btnVerInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PantallaVerInventario pantallaVerInventario = new PantallaVerInventario();
			}
		});
		btnVerInventario.setBounds(234, 96, 153, 34);
		contentPane.add(btnVerInventario);
		
		JButton btnAplicarDescuento = new JButton("Aplicar Descuento");
		btnAplicarDescuento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PantallaAplicarDescuento pantallaAplicarDescuento = new PantallaAplicarDescuento();
			}
		});
		btnAplicarDescuento.setBounds(233, 155, 155, 32);
		contentPane.add(btnAplicarDescuento);
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PantallaInicio pantallaInicio = new PantallaInicio();
				
			}
			
		});
		btnCerrarSesion.setBounds(162, 216, 117, 34);
		contentPane.add(btnCerrarSesion);
	}
}
