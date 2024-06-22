package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import controlador.PrestamoControlador;

public class PantallaHacerPrestamo extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField inpIdLibro;
    private JTextField inpIdSucursal;
    private JTextField inpNombreCliente;
    private JTextField inpApellidoCliente;
    private PrestamoControlador prestamoControlador;

    public PantallaHacerPrestamo() {
        prestamoControlador = new PrestamoControlador();
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 452, 319);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblCrearPrestamo = new JLabel("Crear Préstamo");
        lblCrearPrestamo.setFont(new Font("Arial", Font.BOLD, 15));
        lblCrearPrestamo.setBounds(163, 10, 120, 13);
        contentPane.add(lblCrearPrestamo);

        inpIdLibro = new JTextField();
        inpIdLibro.setBounds(46, 50, 148, 28);
        contentPane.add(inpIdLibro);
        inpIdLibro.setColumns(10);

        JLabel lblIdLibro = new JLabel("ID Libro");
        lblIdLibro.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblIdLibro.setBounds(46, 34, 45, 13);
        contentPane.add(lblIdLibro);

        inpIdSucursal = new JTextField();
        inpIdSucursal.setColumns(10);
        inpIdSucursal.setBounds(242, 50, 148, 28);
        contentPane.add(inpIdSucursal);

        JLabel lblIdSucursal = new JLabel("ID Sucursal");
        lblIdSucursal.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblIdSucursal.setBounds(242, 34, 70, 13);
        contentPane.add(lblIdSucursal);

        inpNombreCliente = new JTextField();
        inpNombreCliente.setColumns(10);
        inpNombreCliente.setBounds(46, 104, 148, 28);
        contentPane.add(inpNombreCliente);

        JLabel lblNombreCliente = new JLabel("Nombre Cliente");
        lblNombreCliente.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblNombreCliente.setBounds(46, 88, 90, 13);
        contentPane.add(lblNombreCliente);

        inpApellidoCliente = new JTextField();
        inpApellidoCliente.setColumns(10);
        inpApellidoCliente.setBounds(242, 104, 148, 28);
        contentPane.add(inpApellidoCliente);

        JLabel lblApellidoCliente = new JLabel("Apellido Cliente");
        lblApellidoCliente.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblApellidoCliente.setBounds(242, 88, 90, 13);
        contentPane.add(lblApellidoCliente);

        JButton btnRegistrarPrestamo = new JButton("Registrar Préstamo");
        btnRegistrarPrestamo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int idLibro = Integer.parseInt(inpIdLibro.getText());
                    int idSucursal = Integer.parseInt(inpIdSucursal.getText());
                    String nombreCliente = inpNombreCliente.getText();
                    String apellidoCliente = inpApellidoCliente.getText();

                    if (nombreCliente.isBlank() || apellidoCliente.isBlank()) {
                        JOptionPane.showMessageDialog(null, "Ingrese todos los datos del cliente", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    prestamoControlador.realizarPrestamo(idLibro, idSucursal, nombreCliente, apellidoCliente);
                    JOptionPane.showMessageDialog(null, "Préstamo registrado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un ID válido para el libro y la sucursal", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al registrar el préstamo", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnRegistrarPrestamo.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnRegistrarPrestamo.setBounds(78, 210, 150, 28);
        contentPane.add(btnRegistrarPrestamo);

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnVolver.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnVolver.setBounds(242, 210, 116, 28);
        contentPane.add(btnVolver);
    }
}
