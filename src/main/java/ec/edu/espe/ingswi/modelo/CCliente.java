package ec.edu.espe.ingswi.modelo;
/**
 * 
 * @author dovac
 */
public class CCliente {
    /**
     * Variable que acoge la cedula del cliente.
     */
    private String cedula;
    /**
     * Variable que acoge el nombre del usuario.
     */
    private String nombre;
    /**
     * Constructor de la clase CCliente.
     * @param cedula
     * @param nombre 
     */
    public CCliente(final String cedula, final String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }
    /**
     * Metodo que obtiene la cedula del cliente.
     * @return 
     */
    public final String getCedula() {
        return cedula;
    }
    /**
     * Metodo que ingresa la cedula dentro del objeto cliente.
     * @param cedula 
     */
    public final void setCedula(final String cedula) {
        this.cedula = cedula;
    }
    /**
     * Metodo que devuelve el nombre del cliente.
     * @return 
     */
    public final String getNombre() {
        return nombre;
    }
    /**
     * Metodo que ingresa el nombre en el objeto cliente.
     * @param nombre 
     */
    public final void setNombre(final String nombre) {
        this.nombre = nombre;
    }
}
