package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.LibroControlador;
import controlador.VentasControlador;
import modelos.Libro;
import modelos.Ventas;

public class pantallaVender extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> comboBoxSucursales;
    private JComboBox<String> comboBoxLibros;
    private JTextField txtCantidad;
    private JLabel lblPrecio;

    private LibroControlador libroControlador;
    private VentasControlador ventasControlador;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    pantallaVender frame = new pantallaVender();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public pantallaVender() {
        libroControlador = new LibroControlador();
        ventasControlador = new VentasControlador();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblSucursal = new JLabel("Sucursal:");
        lblSucursal.setBounds(50, 50, 100, 25);
        contentPane.add(lblSucursal);

        comboBoxSucursales = new JComboBox<>(new String[]{"1 - Once", "2 - Belgrano", "3 - Abasto"});
        comboBoxSucursales.setBounds(200, 50, 200, 25);
        comboBoxSucursales.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarLibros();
            }
        });
        contentPane.add(comboBoxSucursales);

        JLabel lblLibro = new JLabel("Libro:");
        lblLibro.setBounds(50, 100, 100, 25);
        contentPane.add(lblLibro);

        comboBoxLibros = new JComboBox<>();
        comboBoxLibros.setBounds(200, 100, 200, 25);
        comboBoxLibros.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarPrecio();
            }
        });
        contentPane.add(comboBoxLibros);

        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setBounds(50, 150, 100, 25);
        contentPane.add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(200, 150, 200, 25);
        contentPane.add(txtCantidad);

        lblPrecio = new JLabel("Precio:");
        lblPrecio.setBounds(50, 200, 350, 25);
        contentPane.add(lblPrecio);

        JButton btnVender = new JButton("Vender");
        btnVender.setBounds(150, 250, 100, 25);
        btnVender.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarVenta();
            }
        });
        contentPane.add(btnVender);

        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(250, 250, 100, 25);
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

    private void actualizarPrecio() {
        String libroSeleccionado = (String) comboBoxLibros.getSelectedItem();
        if (libroSeleccionado == null) return;

        List<Libro> librosDisponibles = libroControlador.getLibrosBySucursal(
                Integer.parseInt(((String) comboBoxSucursales.getSelectedItem()).split(" - ")[0]));
        Libro libro = librosDisponibles.stream()
                .filter(l -> l.getTitulo().equals(libroSeleccionado))
                .findFirst()
                .orElse(null);
        if (libro != null) {
            lblPrecio.setText("Precio: " + libroControlador.obtenerPrecioLibro(libro.getIdLibro()));
        }
    }

    private void realizarVenta() {
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

        int cantidadVenta;
        try {
            cantidadVenta = Integer.parseInt(txtCantidad.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese una cantidad válida.");
            return;
        }

        int cantidadDisponible = libroControlador.obtenerCantidadDisponible(libro.getIdLibro());
        double valorUnitario = libroControlador.obtenerPrecioLibro(libro.getIdLibro());
        if (cantidadVenta <= cantidadDisponible) {
            double valorTotal = valorUnitario * cantidadVenta;
            LocalDate fechaVenta = LocalDate.now();
            Ventas venta = new Ventas(0, libro.getIdLibro(), 1, cantidadVenta, valorUnitario, valorTotal, fechaVenta);
            if (ventasControlador.registrarVenta(venta)) {
                JOptionPane.showMessageDialog(null, "Venta hecha con éxito. Valor total: " + valorTotal);
            } else {
                JOptionPane.showMessageDialog(null, "Error al realizar la venta.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay suficiente stock para realizar la venta.");
        }
    }

    private void volverPantallaEmpleado() {
        dispose();
        PantallaEmpleado pantallaEmpleado = new PantallaEmpleado();
        pantallaEmpleado.setVisible(true);
    }
}
