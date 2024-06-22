package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaEmpleado extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PantallaEmpleado frame = new PantallaEmpleado();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public PantallaEmpleado() { 
        this.setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 400);  // Aumentar el tamaño de la ventana
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblQueDeseaHacer = new JLabel("¿Qué desea hacer?");
        lblQueDeseaHacer.setFont(new Font("Arial", Font.BOLD, 16));
        lblQueDeseaHacer.setBounds(143, 24, 155, 32);
        contentPane.add(lblQueDeseaHacer);

        JButton btnVenderLibro = new JButton("Vender Libro");
        btnVenderLibro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                venderLibro();
            }
        });
        btnVenderLibro.setBounds(46, 96, 142, 34);
        contentPane.add(btnVenderLibro);

        JButton btnPrestarLibro = new JButton("Prestar Libro");
        btnPrestarLibro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                prestarLibro();
            }
        });
        btnPrestarLibro.setBounds(234, 96, 153, 34);
        contentPane.add(btnPrestarLibro);

        JButton btnVerInventario = new JButton("Ver Inventario");
        btnVerInventario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                verInventario();
            }
        });
        btnVerInventario.setBounds(46, 155, 142, 34);
        contentPane.add(btnVerInventario);

        JButton btnVerPrestamos = new JButton("Ver Préstamos");
        btnVerPrestamos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                verPrestamos();
            }
        });
        btnVerPrestamos.setBounds(234, 155, 153, 34);
        contentPane.add(btnVerPrestamos);

        JButton btnVerVentas = new JButton("Ver Ventas");
        btnVerVentas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                verVentas();
            }
        });
        btnVerVentas.setBounds(46, 214, 153, 34);
        contentPane.add(btnVerVentas);

        JButton btnCerrarSesion = new JButton("Cerrar Sesión");
        btnCerrarSesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cerrarSesion();
            }
        });
        btnCerrarSesion.setBounds(234, 214, 153, 34);
        contentPane.add(btnCerrarSesion);
    }

    private void venderLibro() {
        // Implementación del método venderLibro basado en tu código original
        // Aquí deberías abrir la pantalla de vender libro
    }

    private void prestarLibro() {
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

    private void verInventario() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PantallaVerInventario frame = new PantallaVerInventario();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void verPrestamos() {
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

    private void verVentas() {
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

    private void cerrarSesion() {
        JOptionPane.showMessageDialog(this, "Gracias por usar el software de Yenny.");
        dispose();
    }
}
