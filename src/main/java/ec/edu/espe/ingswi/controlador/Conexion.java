package ec.edu.espe.ingswi.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;
/**
 * @author dovac
 */
public class Conexion {
    /**
     * Variable de tipo conexion1 para enlazarse con la BD del Sistema Bancario.
     */
    private Connection conexion1;
    /**
     * Variable que tiene el nombre del usario de la BD del Sistema Bancario.
     */
    private final String usuario = "root";
    /**
     * Variable que tiene la clave de la BD del Sistema Bancario.
     */
    private final String clave = "1234";
    /**
     * Variable que tiene el url de la BD del Sistema Bancario.
     */
    private final String url = "jdbc:mysql://localhost:3306/banca?autoReconnect=true&useSSL=false";

    public final Connection getConnection() {
        conexion1 = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try {
            conexion1 = DriverManager.getConnection(url, usuario, clave);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, "Error de conexion a la base");
            e.printStackTrace();
        }
        return conexion1;
    }
}
