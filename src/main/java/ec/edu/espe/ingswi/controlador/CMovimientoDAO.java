/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ingswi.controlador;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ec.edu.espe.ingswi.modelo.CCliente;
import ec.edu.espe.ingswi.modelo.CCuenta;
import ec.edu.espe.ingswi.modelo.CMovimiento;

/**
 *
 * @author Adrián
 */
public class CMovimientoDAO {
    /**
    * Variable que establece la conexion con la BD.
    */
    private Conexion conexion;
    /**
    * Objeto que maneja los datos del movimiento.
    */
    private CMovimiento movimiento;
    /**
    * Constructor de la clase.
    * @param movimiento
    */
    public CMovimientoDAO(final CMovimiento movimiento) {
        this.movimiento = movimiento;
        this.conexion = new Conexion();
    }
    /**
    * metodo para la insercion del movimiento.
    */
    public final void insert() {
        PreparedStatement sentencia = null;
        final Connection con = conexion.getConnection();
        // insertar los datos en movimiento dentro de la BD
        try {
            sentencia = con.prepareCall("call transaccion(?,?,?);");
            sentencia.setString(1, movimiento.getCuenta().getCodigoCuenta());
            sentencia.setString(2, movimiento.getTipo());
            sentencia.setDouble(3, movimiento.getMonto());
            sentencia.execute();
            JOptionPane.showMessageDialog(null, "Operacion Exitosa");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, "Error");
            e.printStackTrace();
        }
    }
    /**
    * Metodo para visualizar los moviemtos hechos.
    * @param tablaMovimientos
    * @return tablaMovimientos
    */
    public final DefaultTableModel visualisarMovimientos(DefaultTableModel tablaMovimientos) {
        DefaultTableModel aux = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Codigo_movimiento", "Cuenta", "Tipo", "Fecha", "Monto", "Saldo"
                }
        );
        tablaMovimientos = aux;
        PreparedStatement sentencia = null;
        final Connection con = conexion.getConnection();
        // select de todos los clientes y llenado de jtable
        try {
            sentencia = con.prepareStatement("select * from movimiento");
            final ResultSet res = sentencia.executeQuery();
            int cont = 0;
            while (res.next()) {
                cont++;
                movimiento = new CMovimiento(new CCuenta(res.getString(2), 
                        new CCliente("", ""), "", 0, ""), res.getString(3),
                        res.getDate(4), res.getDouble(5), res.getDouble(6));
                tablaMovimientos.addRow(new String[]{res.getString(1), 
                        movimiento.getCuenta().getCodigoCuenta(), movimiento.getTipo(), 
                        movimiento.getFecha().toString(), "$" + 
                        movimiento.getMonto(), "$" + movimiento.getSaldo()});
            }
            if (cont == 0) {
                JOptionPane.showMessageDialog(null, "No se encontraron Movimientos");
                return aux;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return tablaMovimientos;
    }
    /**
    * Metodo para realizar una busqueda de los movimientos hechos.
    * @param tablaMovimientos
    * @param numero
    * @return tablaMovimientos
    */
    public final DefaultTableModel busquedaMovimiento( DefaultTableModel tablaMovimientos, final int numero) {
        DefaultTableModel aux = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Codigo_movimiento", "Cuenta", "Tipo", "Fecha", "Monto", "Saldo"
                }
        );
        tablaMovimientos = aux;
        PreparedStatement sentencia = null;
        final Connection con = conexion.getConnection();
        // select de todos los clientes y llenado de jtable
        try {
            sentencia = con.prepareStatement("select * from movimiento where cod_cuenta = ?");
            sentencia.setString(1, movimiento.getCuenta().getCodigoCuenta());
            final ResultSet res = sentencia.executeQuery();
            int cont = 0;
            while (res.next()) {
                cont++;
                movimiento = new CMovimiento(new CCuenta(res.getString(2), 
                        new CCliente("", ""), "", 0, ""), res.getString(3), 
                        res.getDate(4), res.getDouble(5), res.getDouble(6));
                tablaMovimientos.addRow(new String[]{res.getString(1), 
                        movimiento.getCuenta().getCodigoCuenta(), 
                        movimiento.getTipo(), movimiento.getFecha().toString(), 
                        "$" + movimiento.getMonto(), "$" + movimiento.getSaldo()});
                if (cont == numero) {
                    return tablaMovimientos;
                }
            }
            if (cont == 0) {
                JOptionPane.showMessageDialog(null, "No se encontraron movimientos");
                return aux;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return tablaMovimientos;
    }
    /**
    * Metodo para visualizar los moviemtos hechos entre dos fechas.
    * @param tablaMovimientos
    * @param desde
    * @param hasta
    * @return tablaMovimientos
    */
    public final DefaultTableModel busquedaMovimientoFecha(DefaultTableModel tablaMovimientos, final Date desde, final Date hasta) {
        DefaultTableModel aux = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Codigo_movimiento", "Cuenta", "Tipo", "Fecha", "Monto", "Saldo"
                }
        );
        tablaMovimientos = aux;
        PreparedStatement sentencia = null;
        final Connection con = conexion.getConnection();
        // select de todos los clientes y llenado de jtable
        try {
            sentencia = con.prepareStatement("select * from movimiento where fecha < ? and fecha > ?");
            sentencia.setDate(1, desde);
            sentencia.setDate(2, hasta);
            final ResultSet res = sentencia.executeQuery();
            int cont = 0;
            while (res.next()) {
                cont++;
                movimiento = new CMovimiento(new CCuenta(res.getString(2), 
                        new CCliente("", ""), "", 0, ""), res.getString(3), 
                        res.getDate(4), res.getDouble(5), res.getDouble(6));
                tablaMovimientos.addRow(new String[]{res.getString(1), 
                        movimiento.getCuenta().getCodigoCuenta(), movimiento.getTipo(),
                        movimiento.getFecha().toString(), "$" + movimiento.getMonto(), 
                        "$" + movimiento.getSaldo()});
            }
            if (cont == 0) {
                JOptionPane.showMessageDialog(null, "No se encontraron movimientos");
                return aux;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error ");
        }
        return tablaMovimientos;
    }
}
