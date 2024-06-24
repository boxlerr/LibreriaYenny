package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controlador.LibroControlador;
import controlador.PrestamoControlador;
import modelos.Libro;

public class PantallaHacerPrestamo extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> comboBoxSucursales;
    private JComboBox<String> comboBoxLibros;
    private JTextField txtNombreCliente;
    private JTextField txtApellidoCliente;

    private LibroControlador libroControlador;
    private PrestamoControlador prestamoControlador;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PantallaHacerPrestamo frame = new PantallaHacerPrestamo();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public PantallaHacerPrestamo() {
        libroControlador = new LibroControlador();
        prestamoControlador = new PrestamoControlador();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);  // Tamaño original de la ventana
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        contentPane.setBackground(new Color(255, 255, 255));

        JLabel lblTitle = new JLabel("Préstamo de Libros");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setBounds(150, 20, 300, 30);  // Aumentar el ancho para evitar corte
        contentPane.add(lblTitle);

        JLabel lblSucursal = new JLabel("Sucursal:");
        lblSucursal.setFont(new Font("Arial", Font.PLAIN, 16));
        lblSucursal.setBounds(50, 80, 100, 25);
        contentPane.add(lblSucursal);

        comboBoxSucursales = new JComboBox<>(new String[]{"1 - Once", "2 - Belgrano", "3 - Abasto"});
        comboBoxSucursales.setFont(new Font("Arial", Font.PLAIN, 14));
        comboBoxSucursales.setBounds(200, 80, 200, 25);
        comboBoxSucursales.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarLibros();
            }
        });
        contentPane.add(comboBoxSucursales);

        JLabel lblLibro = new JLabel("Libro:");
        lblLibro.setFont(new Font("Arial", Font.PLAIN, 16));
        lblLibro.setBounds(50, 130, 100, 25);
        contentPane.add(lblLibro);

        comboBoxLibros = new JComboBox<>();
        comboBoxLibros.setFont(new Font("Arial", Font.PLAIN, 14));
        comboBoxLibros.setBounds(200, 130, 200, 25);
        contentPane.add(comboBoxLibros);

        JLabel lblNombreCliente = new JLabel("Nombre Cliente:");
        lblNombreCliente.setFont(new Font("Arial", Font.PLAIN, 16));
        lblNombreCliente.setBounds(50, 180, 150, 25);
        contentPane.add(lblNombreCliente);

        txtNombreCliente = new JTextField();
        txtNombreCliente.setFont(new Font("Arial", Font.PLAIN, 14));
        txtNombreCliente.setBounds(200, 180, 200, 25);
        contentPane.add(txtNombreCliente);

        JLabel lblApellidoCliente = new JLabel("Apellido Cliente:");
        lblApellidoCliente.setFont(new Font("Arial", Font.PLAIN, 16));
        lblApellidoCliente.setBounds(50, 230, 150, 25);
        contentPane.add(lblApellidoCliente);

        txtApellidoCliente = new JTextField();
        txtApellidoCliente.setFont(new Font("Arial", Font.PLAIN, 14));
        txtApellidoCliente.setBounds(200, 230, 200, 25);
        contentPane.add(txtApellidoCliente);

        JButton btnPrestar = new JButton("Prestar");
        btnPrestar.setFont(new Font("Arial", Font.BOLD, 16));
        btnPrestar.setBorder(new LineBorder(new Color(0, 0, 0)));
        btnPrestar.setBackground(new Color(50, 205, 50));
        btnPrestar.setForeground(Color.WHITE);
        btnPrestar.setBounds(150, 300, 100, 30);
        btnPrestar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarPrestamo();
            }
        });
        contentPane.add(btnPrestar);

        JButton btnVolver = new JButton("Volver");
        btnVolver.setFont(new Font("Arial", Font.BOLD, 16));
        btnVolver.setBorder(new LineBorder(new Color(0, 0, 0)));
        btnVolver.setBackground(new Color(220, 20, 60));
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setBounds(270, 300, 100, 30);
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                volverPantallaEmpleado();
            }
        });
        contentPane.add(btnVolver);

        actualizarLibros();
    }

    private void actualizarLibros() {
        comboBoxLibros.removeAllItems();
        String sucursalSeleccionada = (String) comboBoxSucursales.getSelectedItem();
        if (sucursalSeleccionada == null) return;

        int idSucursalSeleccionada = Integer.parseInt(sucursalSeleccionada.split(" - ")[0]);
        List<Libro> librosDisponibles = libroControlador.getLibrosBySucursal(idSucursalSeleccionada);
        for (Libro libro : librosDisponibles) {
            comboBoxLibros.addItem(libro.getTitulo());
        }
    }

    private void realizarPrestamo() {
        String libroSeleccionado = (String) comboBoxLibros.getSelectedItem();
        if (libroSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "Seleccione un libro.");
            return;
        }

        int idSucursalSeleccionada = Integer.parseInt(((String) comboBoxSucursales.getSelectedItem()).split(" - ")[0]);
        List<Libro> librosDisponibles = libroControlador.getLibrosBySucursal(idSucursalSeleccionada);
        Libro libro = librosDisponibles.stream()
                .filter(l -> l.getTitulo().equals(libroSeleccionado))
                .findFirst()
                .orElse(null);
        if (libro == null) {
            JOptionPane.showMessageDialog(null, "Libro no disponible.");
            return;
        }

        String nombreCliente = txtNombreCliente.getText();
        String apellidoCliente = txtApellidoCliente.getText();
        if (nombreCliente.isEmpty() || apellidoCliente.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese nombre y apellido del cliente.");
            return;
        }

        int cantidadDisponible = libroControlador.obtenerCantidadDisponible(libro.getIdLibro());
        if (cantidadDisponible > 0) {
            prestamoControlador.realizarPrestamo(libro.getIdLibro(), idSucursalSeleccionada, nombreCliente, apellidoCliente);
            JOptionPane.showMessageDialog(null, "Préstamo realizado con éxito.");
            txtNombreCliente.setText(""); 
            txtApellidoCliente.setText(""); 
        } else {
            JOptionPane.showMessageDialog(null, "No hay suficiente stock para realizar el préstamo.");
        }
    }

    private void volverPantallaEmpleado() {
        dispose();
        PantallaEmpleado pantallaEmpleado = new PantallaEmpleado();
        pantallaEmpleado.setVisible(true);
    }
}
