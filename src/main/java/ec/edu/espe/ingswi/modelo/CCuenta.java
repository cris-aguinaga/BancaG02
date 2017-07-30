package ec.edu.espe.ingswi.modelo;
/**
 * 
 * @author dovac
 */
public class CCuenta {
    /**
     * Variable qeu tiene el codigo de la cuenta.
     */
    private String codigoCuenta;
    /**
     * Variable que gurada los datos del cliente.
     */
    private CCliente cliente;
    /**
     * Variable que especifica el tipo de cuenta si es debito corriente.
     */
    private String tipo;
    /**
     * Variable que guarda el saldo del cliente.
     */
    private double saldo;
    /**
     * Variable que especifca el estado de la cuenta si esa ctiva o inactiva.
     */
    private String estado;
    /**
     * Constructor de la clase CCuenta.
     * @param codigoCuenta
     * @param cliente
     * @param tipo
     * @param saldo
     * @param estado 
     */
    public CCuenta(final String codigoCuenta, final CCliente cliente, final String tipo, final double saldo, final String estado) {
        this.codigoCuenta = codigoCuenta;
        this.cliente = cliente;
        this.tipo = tipo;
        this.saldo = saldo;
        this.estado = estado;
    }
    /**
     * Metodo que devuelve el codigo de la cuenta.
     * @return 
     */
    public final String getCodigoCuenta() {
        return codigoCuenta;
    }
    /**
     * Metodo que gurada el codigo de la cuenta.
     * @param codigoCuenta 
     */
    public final void setCodigoCuenta(final String codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }
    /**
     * Metodo que devuelve el cliente de la cuenta.
     * @return 
     */
    public final CCliente getCliente() {
        return cliente;
    }
    /**
     * Metodo que guarda el cliente de la cuenta.
     * @param cliente 
     */
    public final void setCliente(final CCliente cliente) {
        this.cliente = cliente;
    }
    /**
     * Metodo que devuelve el tipo de cuenta.
     * @return 
     */
    public final String getTipo() {
        return tipo;
    }
    /**
     * Metodo que guarda el tipod de cuenta.
     * @param tipo 
     */
    public final void setTipo(final String tipo) {
        this.tipo = tipo;
    }
    /**
     * Metodo que devuelve el saldo de la cuenta.
     * @return 
     */
    public final double getSaldo() {
        return saldo;
    }
    /**
     * Metodo que gurada el saldo de la cuenta.
     * @param saldo 
     */
    public final void setSaldo(final double saldo) {
        this.saldo = saldo;
    }
    /**
     * Metodo que devuelve el estado de la cuenta.
     * @return 
     */
    public final String getEstado() {
        return estado;
    }
    /**
     * Metodo que guarda el estado de la cuenta.
     * @param estado 
     */
    public final void setEstado(final String estado) {
        this.estado = estado;
    }

}
