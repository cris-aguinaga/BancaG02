/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ingswi.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ec.edu.espe.ingswi.modelo.CCliente;
import ec.edu.espe.ingswi.modelo.CCuenta;

/**
 *
 * @author Adrián
 */
public class CCuentaDAO {
    /**
    * Variable que establece la conexion.
    */
    private Conexion conexion;
    /**
    * Se crea un objeto para guardar los datos de la cuenta.
    */
    private CCuenta cuenta;
    /**
    * Constructor de la clase.
    * @param cuenta
    */
    public CCuentaDAO(final CCuenta cuenta) {
        this.cuenta = cuenta;
        this.conexion = new Conexion();
    }
    /**
    * Metodo que desactiva la cuenta segun un parametro.
    * @param parametro
    */
    public final void desactivarCuenta(final String parametro) {
        PreparedStatement sentencia = null;
        final Connection con = conexion.getConnection();
        final String auxiliar = "update cuenta set estado = 'ina'  "
                        + "where cedula like ? or cod_cuenta like ?";
        // update del cliente dentro de la BD
        try {
            sentencia = con.prepareStatement(auxiliar);// revisar
            sentencia.setString(1, parametro);
            sentencia.setString(2, parametro);
            sentencia.execute();
            JOptionPane.showMessageDialog(null, "Operacion Exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error");
            e.printStackTrace();
        }
    }
    /**
    * Metodo para la insercion de una nueva cuenta.
    */
    public final void insert() {
        PreparedStatement sentencia = null;
        final Connection con = conexion.getConnection();
        final String auxiliar = "INSERT INTO `ingswbancario`.`cuenta` "
                + "(`COD_CUENTA`, `CEDULA`, `TIPO`, `SALDO`, "
                + "`ESTADO`) VALUES (?, ?, ?, ?, 'act');";
        try {
            sentencia = con.prepareStatement(auxiliar);
            sentencia.setString(1, cuenta.getCodigoCuenta());
            sentencia.setString(2, cuenta.getCliente().getCedula());
            sentencia.setString(3, cuenta.getTipo());
            sentencia.setDouble(4, cuenta.getSaldo());
            sentencia.executeUpdate();
            JOptionPane.showMessageDialog(null, "Operacion Exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error");
            e.printStackTrace();
        }
    }
    /**
    * Metodo para visualizar las cuentas creadas.
    * @param tablaClientes
     *@return tablaClientes
    */
    public final DefaultTableModel visualisarCuentas(DefaultTableModel tablaClientes) {
        tablaClientes = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Codigo", "Propietario", "Tipo", "Saldo", "Estado"
                }
        ) {
            private boolean[] canEdit = new boolean[]{
                false, false, false, true, false
            };

            public boolean isCellEditable(final int rowIndex, final int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        PreparedStatement sentencia = null;
        final Connection con = conexion.getConnection();
        // select de todos las cuentas y llenado de jtable
        try {
            sentencia = con.prepareStatement("select * from cuenta;");
            final ResultSet res = sentencia.executeQuery();

            while (res.next()) {

                cuenta = new CCuenta(res.getString(1), new CCliente("", res.getString(2)),
                        res.getString(3), res.getDouble(4), res.getString(5));
                tablaClientes.addRow(new String[]{cuenta.getCodigoCuenta(), 
                        cuenta.getCliente().getNombre(), cuenta.getTipo(), 
                        "$" + cuenta.getSaldo(), cuenta.getEstado()});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tablaClientes;
    }
    /**
    * Metodo para realizar la busqueda y oder verla.
    * @param tablaClientes es la tabla de los clientes
    * @param parametro es el parametro por el cual buscara
    * @return tablaClientes
    */
    public final DefaultTableModel visualisarBusqueda(DefaultTableModel tablaClientes, final String parametro) {
        DefaultTableModel aux = tablaClientes;
        tablaClientes = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Codigo", "Propietario", "Tipo", "Saldo", "Estado"
                }
        ) {
            private boolean[] canEdit = new boolean[]{
                false, false, false, true, false
            };

            public boolean isCellEditable(final int rowIndex, final int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        PreparedStatement sentencia = null;
        final Connection con = conexion.getConnection();
        // select de todos las cuentas y llenado de jtable
        try {
            sentencia = con.prepareStatement("select * from cuenta where cod_cuenta like ? or cedula like ?;");
            sentencia.setString(1, parametro);
            sentencia.setString(2, parametro);
            final ResultSet res = sentencia.executeQuery();
            int cont = 0;
            while (res.next()) {
                cont++;
                cuenta = new CCuenta(res.getString(1), new CCliente("", res.getString(2)),
                        res.getString(3), res.getDouble(4), res.getString(5));
                tablaClientes.addRow(new String[]{cuenta.getCodigoCuenta(), 
                        cuenta.getCliente().getNombre(), cuenta.getTipo(), 
                        "$" + cuenta.getSaldo(), cuenta.getEstado()});
            }
            if (cont == 0) {
                JOptionPane.showMessageDialog(null, "No se encontraron cuentas");
                return aux;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return tablaClientes;
    }

}
