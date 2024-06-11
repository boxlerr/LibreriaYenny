package vista;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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
    private JButton editarBtn;
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
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 909, 452);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        controlador = new VentasControlador();
        seleccionado = new Ventas();

        String[] columnNames = { "ID Venta", "ID Libro", "ID Empleado", "Cantidad", "Valor Unitario", "Valor Total", "Fecha Venta" };
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        actualizarTabla();
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(5, 19, 911, 190);
        contentPane.add(scrollPane);

        elemento = new JLabel("Seleccionado:");
        elemento.setBounds(5, 5, 911, 14);
        contentPane.add(elemento);

        JButton eliminarBtn = new JButton("Eliminar");
        eliminarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (seleccionado.getIdVenta() != 0) {
                    if (controlador.deleteVenta(seleccionado.getIdVenta())) {
                        JOptionPane.showMessageDialog(null, "Venta eliminada exitosamente");
                        actualizarTabla();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al eliminar la venta");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una venta");
                }
            }
        });
        eliminarBtn.setBounds(53, 280, 187, 58);
        contentPane.add(eliminarBtn);
        editarBtn = new JButton("Editar");
        editarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (seleccionado.getIdVenta() != 0) {        
                    JOptionPane.showMessageDialog(null, "Funcionalidad de edición aún no implementada");
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una venta");
                }
            }
        });
        editarBtn.setBounds(367, 280, 166, 58);
        contentPane.add(editarBtn);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(15, 220, 101, 22);
        contentPane.add(menuBar);

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
    }
    private void actualizarTabla() {
        model.setRowCount(0);
        List<Ventas> ventas = controlador.obtenerListaVentas();
        for (Ventas venta : ventas) {
            model.addRow(new Object[] { venta.getIdVenta(), venta.getIdLibro(), venta.getIdEmpleado(), venta.getCantidad(), venta.getValorUnitario(), venta.getValorTotal(), venta.getFechaVenta() });
        }
    }
}
