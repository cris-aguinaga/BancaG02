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
    private String genero;
    private float ingreso;

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public float getIngreso() {
        return ingreso;
    }

    public void setIngreso(float ingreso) {
        this.ingreso = ingreso;
    }

    public CCliente(String cedula, String nombre, String genero, float ingreso) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.genero = genero;
        this.ingreso = ingreso;
    }
    /**
     * Constructor de la clase CCliente.
     * @param cedula
     * @param nombre 
     */
    public CCliente(final String cedula, final String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }
     public CCliente() {
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
