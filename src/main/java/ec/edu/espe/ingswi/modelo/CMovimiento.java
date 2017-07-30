package ec.edu.espe.ingswi.modelo;

import java.sql.Date;
/**
 * 
 * @author dovac
 */
public class CMovimiento {
    /**
     * Variable que guarda los datos de la cuenta.
     */
    private CCuenta cuenta;
    /**
     * Variable que especifica que tipo de movimiento es.
     */
    private String tipo;
    /**
     * Variable que especifica la fecha.
     */
    private Date fecha;
    /**
     * Variable que guarda el monto del movimiento.
     */
    private double monto;
    /**
     * Variable que guarda el saldo que queda despues del movimiento.
     */
    private double saldo;
    /**
     * Constructor de la clase.
     * @param cuenta
     * @param tipo
     * @param fecha
     * @param monto
     * @param saldo 
     */
    public CMovimiento(final CCuenta cuenta, final String tipo, final Date fecha, final double monto, final double saldo) {
        this.cuenta = cuenta;
        this.tipo = tipo;
        this.fecha = fecha;
        this.monto = monto;
        this.saldo = saldo;
    }
    /**
     * Metodo para devolver la cuenta.
     * @return 
     */
    public final CCuenta getCuenta() {
        return cuenta;
    }
    /**
     * Metodo para guaradar los datos de la cuenta.
     * @param cuenta 
     */
    public final void setCuenta(final CCuenta cuenta) {
        this.cuenta = cuenta;
    }
    /**
     * Metodo para devolver el tipo de movimiento.
     * @return 
     */
    public final String getTipo() {
        return tipo;
    }
    /**
     * Metodo para guardar el tipo de movimiento.
     * @param cuenta 
     */
    public final void setTipo(final String tipo) {
        this.tipo = tipo;
    }
    /**
     * Metodo para devolver la fecha del movimiento.
     * @return 
     */
    public final Date getFecha() {
        return fecha;
    }
    /**
     * Metodo para guardar la fecha de movimiento.
     * @param cuenta 
     */
    public final void setFecha(final Date fecha) {
        this.fecha = fecha;
    }
    /**
     * Metodo para devolver el monto del movimiento.
     * @return 
     */
    public final double getMonto() {
        return monto;
    }
    /**
     * Metodo para guardar el monto de movimiento.
     * @param cuenta 
     */
    public final void setMonto(final double monto) {
        this.monto = monto;
    }
    /**
     * Metodo para devolver el slado del cliente despues del movimiento.
     * @return 
     */
    public final double getSaldo() {
        return saldo;
    }
    /**
     * Metodo para guardar el saldo de movimiento.
     * @param cuenta 
     */
    public final void setSaldo(final double saldo) {
        this.saldo = saldo;
    }

}
