package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    private static Connection conexion;

// Datos de la base de datos y usuario
    private final String bd = "aplicacionrestaurante";
    private final String user = "root";
    private final String pass = "";
    private final String host = "localhost";
    private final String server = "jdbc:mysql://" + host + "/" + bd + "?useTimezone=true&serverTimezone=UTC";
    static ResultSet datos;
    static String driver = "com.mysql.cj.jdbc.Driver";

    public Connection conectar(String user, String pass) {
        try {
            if (conexion == null) {
                Class.forName(driver);
                conexion = DriverManager.getConnection(server, user, pass);
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "No conexión" + ex.getMessage());
            conexion = null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos" + ex.getMessage());
        }
        return conexion;
    }
}