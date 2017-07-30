package ec.edu.espe.ingswi.modelo;
/**
 * 
 * @author dovac
 */
public class CUsuario {
    /**
     * Varaibale que guarda el nombre del usuario del sistema bancario.
     */
    private String nombre;
    /**
     * Variable que guarda la clave del usuario.
     */
    private String clave;
    /**
     * Constructor de la clase.
     * @param nombre
     * @param clave 
     */
    public CUsuario(final String nombre, final String clave) {
        this.nombre = nombre;
        this.clave = clave;
    }
    /**
     * Metodo que devuelve el nombre del usuario.
     * @return 
     */
    public final String getNombre() {
        return nombre;
    }
    /**
     * Metdodo que guarda el nombre del usuario.
     * @param nombre 
     */
    public final void setNombre(final String nombre) {
        this.nombre = nombre;
    }
    /**
     * Metodo que devuelve la clave del usuario.
     * @return 
     */
    public final String getClave() {
        return clave;
    }
    /**
     * Metdodo que guarda la clave del usuario.
     * @param clave 
     */
    public final void setClave(final String clave) {
        this.clave = clave;
    }
}
