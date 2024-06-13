package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import controlador.PrestamoControlador;
import modelos.Prestamos;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PantallaPrestamos extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    private PrestamoControlador prestamoControlador;
    private Prestamos prestamoSeleccionado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PantallaPrestamos frame = new PantallaPrestamos();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public PantallaPrestamos() {
		this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        prestamoControlador = new PrestamoControlador();

        String[] columnNames = {"ID", "ID Libro", "ID Sucursal", "Fecha Préstamo", "Fecha Devolución", "Nombre Cliente", "Apellido Cliente"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        actualizarTabla();

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 24, 564, 256);
        contentPane.add(scrollPane);

        JLabel lblSeleccionado = new JLabel("Seleccionado:");
        lblSeleccionado.setBounds(10, 7, 564, 14);
        contentPane.add(lblSeleccionado);

        JButton btnDevolver = new JButton("Devolver");
        btnDevolver.setBounds(10, 291, 100, 43);
        btnDevolver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                if (prestamoSeleccionado != null) {
                    try {
                        prestamoControlador.devolverLibro(prestamoSeleccionado.getIdPrestamo());
                        JOptionPane.showMessageDialog(null, "Libro devuelto con éxito.");
                        actualizarTabla();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error al devolver el libro: " + ex.getMessage());
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un préstamo.");
                }
            }
        });
        contentPane.add(btnDevolver);

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnVolver.setBounds(474, 291, 100, 43);
        contentPane.add(btnVolver);

        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selectionModel.addListSelectionListener(new ListSelectionListener() {
        	@Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        try {
                            int idPrestamo = (int) table.getValueAt(selectedRow, 0);
                            int idLibro = (int) table.getValueAt(selectedRow, 1);
                            int idSucursal = (int) table.getValueAt(selectedRow, 2);
                            LocalDate fechaPrestamo = LocalDate.parse(table.getValueAt(selectedRow, 3).toString());

                            LocalDate fechaDevolucion = null;
                            Object cellValue = table.getValueAt(selectedRow, 4);
                            if (cellValue != null) {
                                fechaDevolucion = LocalDate.parse(cellValue.toString());
                            }

                            String nombreCliente = (String) table.getValueAt(selectedRow, 5);
                            String apellidoCliente = (String) table.getValueAt(selectedRow, 6);

                            lblSeleccionado.setText("Seleccionado: ID Préstamo = " + idPrestamo + ", Cliente = " + nombreCliente + " " + apellidoCliente);

                            prestamoSeleccionado = new Prestamos(idPrestamo, idLibro, idSucursal, fechaPrestamo, fechaDevolucion, nombreCliente, apellidoCliente);
                        } catch (DateTimeParseException | ClassCastException ex) {
                            JOptionPane.showMessageDialog(null, "Error al seleccionar el préstamo: ");
                            ((Throwable) ex).printStackTrace();
                        }
                    }
                }
            }
        });
    }

    private void actualizarTabla() {
        model.setRowCount(0);
        List<Prestamos> prestamos = prestamoControlador.obtenerListaPrestamos();
        for (Prestamos prestamo : prestamos) {
            model.addRow(new Object[]{
                prestamo.getIdPrestamo(),
                prestamo.getIdLibro(),
                prestamo.getIdSucursal(),
                prestamo.getFechaPrestamo(),
                prestamo.getFechaDevolucion(),
                prestamo.getNombreCliente(),
                prestamo.getApellidoCliente()
            });
        }
    }
}
