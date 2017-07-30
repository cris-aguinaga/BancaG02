package ec.edu.espe.ingswi.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ec.edu.espe.ingswi.modelo.CUsuario;
/**
 *
 * @author Jonathan.
 */
public class CUsuarioDAO {
    /**
    * Crea un objeto que guarda los datos del usuario.
    */
    private CUsuario usuario;
    /**
    * Variable que establece la conexion con la BD.
    */
    private Conexion conexion;
    /**
    * Constructor de la clase.
    * @param usuario
    */
    public CUsuarioDAO(final CUsuario usuario) {
        this.usuario = usuario;
        this.conexion = new Conexion();
    }
    /**
    * Metodo que devuelve un objeto de tipo usuario.
    * @param usuario
    */
    public final CUsuario getUsuario() {
        return usuario;
    }
    /**
    * Metodo que setea los datos del usuario.
    * @param usuario
    */
    public final void setUsuario(final CUsuario usuario) {
        this.usuario = usuario;
    }
    /**
    * Metodo que los datos del usuario.
    * @return boolean
    */
    public final boolean validacionIngreso() {
        PreparedStatement sentencia = null;
        final Connection con = conexion.getConnection();
        // select para validar clave y usuario
        try {
            sentencia = con.prepareStatement(
                    "select count(nombre) from usuario where nombre like ? and clave like ?;");
            sentencia.setString(1, usuario.getNombre());
            sentencia.setString(2, usuario.getClave());
            final ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                if (resultado.getInt(1) == 0) {
                    return false;
                } else {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
