package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
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
import javax.swing.JTextField;
import java.awt.Font;

public class PantallaPrestamos extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    private PrestamoControlador prestamoControlador;
    private Prestamos prestamoSeleccionado;
    private JTextField inpFiltrarId;
    private JTextField inpFiltrarNombre;

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
        setTitle("Gestión de Préstamos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        prestamoControlador = new PrestamoControlador();

        String[] columnNames = {"ID", "ID Libro", "ID Sucursal", "Fecha Préstamo", "Fecha Devolución", "Nombre Cliente", "Apellido Cliente"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        actualizarTabla();

        JScrollPane scrollPane = new JScrollPane(table);

        JLabel lblSeleccionado = new JLabel("Seleccionado:");
        lblSeleccionado.setFont(new Font("Tahoma", Font.BOLD, 12));

        JButton btnDevolver = new JButton("Devolver");
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

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (prestamoSeleccionado != null) {
                    int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar este préstamo?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        try {
                            prestamoControlador.eliminarPrestamo(prestamoSeleccionado.getIdPrestamo());
                            JOptionPane.showMessageDialog(null, "Préstamo eliminado con éxito.");
                            actualizarTabla();
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Error al eliminar el préstamo: " + ex.getMessage());
                            ex.printStackTrace();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un préstamo.");
                }
            }
        });

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
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });

        JLabel lblFiltrarId = new JLabel("Ingrese un ID para filtrar:");
        JLabel lblFiltrarNombre = new JLabel("Ingrese un nombre para filtrar:");

        inpFiltrarId = new JTextField();
        inpFiltrarId.setColumns(10);

        inpFiltrarNombre = new JTextField();
        inpFiltrarNombre.setColumns(10);

        JButton btnFiltrarId = new JButton("Filtrar");
        btnFiltrarId.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(inpFiltrarId.getText());
                    filtrarId(id);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un ID válido.");
                }
            }
        });

        JButton btnFiltrarNombre = new JButton("Filtrar");
        btnFiltrarNombre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                filtrarNombre(inpFiltrarNombre.getText());
            }
        });

        JButton btnBorrarFiltros = new JButton("Borrar Filtros");
        btnBorrarFiltros.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnBorrarFiltros.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarTabla();
                inpFiltrarId.setText(null);
                inpFiltrarNombre.setText(null);
            }
        });

        // GroupLayout
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                        .addComponent(lblSeleccionado, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addComponent(lblFiltrarId)
                                .addComponent(inpFiltrarId, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnFiltrarId, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
                            .addGap(18)
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addComponent(lblFiltrarNombre)
                                .addComponent(inpFiltrarNombre, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnFiltrarNombre, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addComponent(btnDevolver, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                            .addGap(18)
                            .addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                            .addGap(18)
                            .addComponent(btnBorrarFiltros, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblSeleccionado)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblFiltrarId)
                        .addComponent(lblFiltrarNombre))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(inpFiltrarId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(inpFiltrarNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btnFiltrarId)
                        .addComponent(btnFiltrarNombre))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btnDevolver, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBorrarFiltros, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(24, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
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

    private void filtrarId(int id) {
        model.setRowCount(0);
        List<Prestamos> prestamos = prestamoControlador.PrestamoporID(id);
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

    private void filtrarNombre(String nombre) {
        model.setRowCount(0);
        List<Prestamos> prestamos = prestamoControlador.PrestramoporNombre(nombre);
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
