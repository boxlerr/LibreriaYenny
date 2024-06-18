package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controlador.VentasControlador;
import modelos.Ventas;

public class tablaVentas extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    private VentasControlador controlador;
    private JLabel elemento;
    private Ventas seleccionado;
    private JButton btnEditar;
    private JButton eliminarBtn;
    private JTextField filterIdLibro;
    private JTextField filterIdEmpleado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    tablaVentas frame = new tablaVentas();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public tablaVentas() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 909, 500); // Adjusted height for better layout
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        controlador = new VentasControlador();
        seleccionado = new Ventas();

        String[] columnNames = { "ID Venta", "ID Libro", "ID Empleado", "Cantidad", "Valor Unitario", "Valor Total", "Fecha Venta" };
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(5, 19, 880, 190);
        contentPane.add(scrollPane);

        elemento = new JLabel("Seleccionado:");
        elemento.setBounds(5, 5, 880, 14);
        contentPane.add(elemento);

        JLabel lblFilterIdLibro = new JLabel("Filtrar por Libro:");
        lblFilterIdLibro.setBounds(50, 220, 150, 15);
        contentPane.add(lblFilterIdLibro);

        filterIdLibro = new JTextField();
        filterIdLibro.setBounds(50, 240, 150, 25);
        contentPane.add(filterIdLibro);

        JLabel lblFilterIdEmpleado = new JLabel("Filtrar por Empleado:");
        lblFilterIdEmpleado.setBounds(250, 220, 150, 15);
        contentPane.add(lblFilterIdEmpleado);

        filterIdEmpleado = new JTextField();
        filterIdEmpleado.setBounds(250, 240, 150, 25);
        contentPane.add(filterIdEmpleado);

        JButton btnFiltrar = new JButton("Aplicar Filtros");
        btnFiltrar.setBounds(450, 240, 150, 25);
        btnFiltrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarTabla();
            }
        });
        contentPane.add(btnFiltrar);

        eliminarBtn = new JButton("Eliminar");
        eliminarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (seleccionado.getIdVenta() != 0) {
                    controlador.deleteVenta(seleccionado.getIdVenta());
                    JOptionPane.showMessageDialog(null, "Venta eliminada exitosamente");
                    actualizarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar la venta");
                }
            }
        });
        eliminarBtn.setBounds(53, 280, 187, 58);
        contentPane.add(eliminarBtn);

        btnEditar = new JButton("Editar");
        btnEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (seleccionado.getIdVenta() != 0) {
                    datoAModificar();
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una venta");
                }
            }
        });
        btnEditar.setBounds(367, 280, 166, 58);
        contentPane.add(btnEditar);

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                PantallaEmpleado pantallaEmpleado = new PantallaEmpleado();
            }
        });
        btnVolver.setBounds(672, 280, 166, 58);
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
                        int idLibro = (int) table.getValueAt(selectedRow, 1);
                        int idEmpleado = (int) table.getValueAt(selectedRow, 2);
                        int cantidad = (int) table.getValueAt(selectedRow, 3);
                        double valorUnitario = (double) table.getValueAt(selectedRow, 4);
                        double valorTotal = (double) table.getValueAt(selectedRow, 5);
                        LocalDate fechaVenta = (LocalDate) table.getValueAt(selectedRow, 6);
                        elemento.setText("Seleccionado: ID Venta=" + id + ", ID Libro=" + idLibro + ", ID Empleado=" + idEmpleado + ", Cantidad=" + 
                        cantidad + ", Valor Unitario=" + valorUnitario + ", Valor Total=" + valorTotal + ", Fecha Venta=" + fechaVenta);
                        seleccionado.setIdVenta(id);
                        seleccionado.setIdLibro(idLibro);
                        seleccionado.setIdEmpleado(idEmpleado);
                        seleccionado.setCantidad(cantidad);
                        seleccionado.setValorUnitario(valorUnitario);
                        seleccionado.setValorTotal(valorTotal);
                        seleccionado.setFechaVenta(fechaVenta);
                    }
                }
            }
        });
        actualizarTabla();
    }

    private void actualizarTabla() {
        model.setRowCount(0);
        List<Ventas> ventas = controlador.obtenerListaVentas();

        String filtroIdLibro = filterIdLibro.getText().trim();
        String filtroIdEmpleado = filterIdEmpleado.getText().trim();

        if (!filtroIdLibro.isEmpty()) {
            try {
                int idLibro = Integer.parseInt(filtroIdLibro);
                ventas = ventas.stream()
                        .filter(venta -> venta.getIdLibro() == idLibro)
                        .collect(Collectors.toList());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ID Libro debe ser un número.");
            }
        }

        if (!filtroIdEmpleado.isEmpty()) {
            try {
                int idEmpleado = Integer.parseInt(filtroIdEmpleado);
                ventas = ventas.stream()
                        .filter(venta -> venta.getIdEmpleado() == idEmpleado)
                        .collect(Collectors.toList());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ID Empleado debe ser un número.");
            }
        }

        for (Ventas venta : ventas) {
            model.addRow(new Object[] { venta.getIdVenta(), venta.getIdLibro(), venta.getIdEmpleado(), venta.getCantidad(), venta.getValorUnitario(), venta.getValorTotal(), venta.getFechaVenta()});
        }
    }

    private void datoAModificar() {
        JFrame dialog = new JFrame("Editar Venta");
        dialog.setSize(400, 400);
        dialog.getContentPane().setLayout(null);

        JLabel lblIdLibro = new JLabel("ID Libro:");
        lblIdLibro.setBounds(10, 10, 80, 25);
        dialog.getContentPane().add(lblIdLibro);

        JTextField fieldIdLibro = new JTextField(String.valueOf(seleccionado.getIdLibro()));
        fieldIdLibro.setBounds(100, 10, 160, 25);
        dialog.getContentPane().add(fieldIdLibro);

        JLabel lblIdEmpleado = new JLabel("ID Empleado:");
        lblIdEmpleado.setBounds(10, 40, 80, 25);
        dialog.getContentPane().add(lblIdEmpleado);

        JTextField fieldIdEmpleado = new JTextField(String.valueOf(seleccionado.getIdEmpleado()));
        fieldIdEmpleado.setBounds(100, 40, 160, 25);
        dialog.getContentPane().add(fieldIdEmpleado);

        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setBounds(10, 70, 80, 25);
        dialog.getContentPane().add(lblCantidad);

        JTextField fieldCantidad = new JTextField(String.valueOf(seleccionado.getCantidad()));
        fieldCantidad.setBounds(100, 70, 160, 25);
        dialog.getContentPane().add(fieldCantidad);

        JLabel lblValorUnitario = new JLabel("Valor Unitario:");
        lblValorUnitario.setBounds(10, 100, 80, 25);
        dialog.getContentPane().add(lblValorUnitario);

        JTextField fieldValorUnitario = new JTextField(String.valueOf(seleccionado.getValorUnitario()));
        fieldValorUnitario.setBounds(100, 100, 160, 25);
        dialog.getContentPane().add(fieldValorUnitario);

        JButton saveButton = new JButton("Editar");
        saveButton.setBounds(100, 150, 100, 25);
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int idLibro = Integer.parseInt(fieldIdLibro.getText());
                    int idEmpleado = Integer.parseInt(fieldIdEmpleado.getText());
                    int cantidad = Integer.parseInt(fieldCantidad.getText());
                    double valorUnitario = Double.parseDouble(fieldValorUnitario.getText());
                    double valorTotal = cantidad * valorUnitario;
                    LocalDate fechaVenta = seleccionado.getFechaVenta();
                    if (!controlador.existeLibro(idLibro)) {
                        JOptionPane.showMessageDialog(null, "El ID del libro no existe.");
                        return;
                    }
                    if (!controlador.existeEmpleado(idEmpleado)) {
                        JOptionPane.showMessageDialog(null, "El ID del empleado no existe.");
                        return;
                    }

                    Ventas updatedVenta = new Ventas(seleccionado.getIdVenta(), idLibro, idEmpleado, cantidad, valorUnitario, valorTotal, fechaVenta);

                    if (controlador.updateVenta(updatedVenta)) {
                        actualizarTabla();
                        dialog.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al actualizar la venta");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese valores válidos.");
                }
            }
        });
        dialog.getContentPane().add(saveButton);
        dialog.setVisible(true);
    }
}
