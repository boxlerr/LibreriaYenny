package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DatabaseConnection {
   private static final String URL = "jdbc:mysql://localhost:3306/libreria";
   private static final String USER = "root";
   private static final String PASSWORD = "";
    
    private static DatabaseConnection instance;
    
    private Connection connection;
    
    //genera la bdd cuanto usa el constructor
    private DatabaseConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            JOptionPane.showMessageDialog(null, "Se conecto");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error conecto");

            e.printStackTrace();
        }
    }
    
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
    
    public Connection getConnection() {
        return connection;
    }
}
