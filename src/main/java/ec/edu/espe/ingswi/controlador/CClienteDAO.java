package ec.edu.espe.ingswi.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

import ec.edu.espe.ingswi.modelo.CCliente;
import java.text.DecimalFormat;

/**
 *
 * @author Jonathan
 */
public class CClienteDAO {
    
    /**
    * cliente es un objeto con los datos del cliente.
    */
    private CCliente cliente;
    /**
    * conexion establece la conexion con la base de datos.
    */
    private Conexion conexion;
    /**
    * resultado guarda las acciones DML en la BD.
    */
    private ResultSet resultado;
    /**
     * atributo que permitira que el valor del ingreso se muestre con dos decimales
     */
    private DecimalFormat df = new DecimalFormat("#.00");
    /**
    * contructor de la clase.
    * @param cliente
    */
    public CClienteDAO(final CCliente cliente) {
        this.cliente = cliente;
        this.conexion = new Conexion();
    }
    /**
    * Metodo que hace la insercion de un cliente.
    */
    public final void insert() {
        PreparedStatement sentencia = null;
        final Connection con = conexion.getConnection();
        // insertar los datos del cliente dentro de la BD
        try {
            sentencia = con.prepareStatement("insert into cliente (cedula,nombre,genero,ingreso) values (?,?,?,?)");
            sentencia.setString(1, cliente.getCedula());
            sentencia.setString(2, cliente.getNombre());
            sentencia.setString(3, cliente.getGenero());
            sentencia.setFloat(4, cliente.getIngreso());
            sentencia.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
        }
    }
    /**
    * Metodo para ver los clientes que estan en la BD.
    * @param tablaClientes
    * @return tablaClientes
    */
    public final DefaultTableModel visualisarClientes(final DefaultTableModel tablaClientes) {
        PreparedStatement sentencia = null;
        final Connection con = conexion.getConnection();
        // select de todos los clientes y llenado de jtable
        
        try {
            sentencia = con.prepareStatement("select * from cliente");
            final ResultSet res = sentencia.executeQuery();
            int cont = 0;
            while (res.next()) {
                cont++;
                cliente = new CCliente(res.getString(1), res.getString(2),res.getString(3),res.getFloat(4));
                tablaClientes.addRow(new String[]{"" + cont, cliente.getCedula(), cliente.getNombre(),
                    cliente.getGenero(),df.format(cliente.getIngreso())+""});
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
        }
        return tablaClientes;
    }
    /**
    * Metodo que hace la busqueda de un cliente por cedula.
    * @param tablaClientes
    * @return tablaClientes
    */
    public final DefaultTableModel busquedaCedula(final DefaultTableModel tablaClientes) {
        PreparedStatement sentencia = null;
        final Connection con = conexion.getConnection();
        // select de todos los clientes y llenado de jtable
        try {
            sentencia = con.prepareStatement("select * from cliente where cedula=?");
            sentencia.setString(1, cliente.getCedula());
            final ResultSet res = sentencia.executeQuery();
            int cont = 0;
            while (res.next()) {
                cont++;
                 cliente = new CCliente(res.getString(1), res.getString(2),res.getString(3),res.getFloat(4));
                tablaClientes.addRow(new String[]{"" + cont, cliente.getCedula(), cliente.getNombre(),
                    cliente.getGenero(),cliente.getIngreso()+""});
            }
            if (cont == 0) {
                JOptionPane.showMessageDialog(null, "No se encontraron clientes");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
        }
        return tablaClientes;
    }
    /**
    * Metodo que hace la busqueda de un cliente por nombre.
    * @param tablaClientes
    * @return tablaClientes
    */
    public final DefaultTableModel busquedaNombre(final DefaultTableModel tablaClientes) {
        PreparedStatement sentencia = null;
        final Connection con = conexion.getConnection();
        // select de todos los clientes y llenado de jtable
        try {
            sentencia = con.prepareStatement("select * from cliente where nombre=?");
            sentencia.setString(1, cliente.getNombre());
            final ResultSet res = sentencia.executeQuery();
            int cont = 0;
            while (res.next()) {
                cont++;
                 cliente = new CCliente(res.getString(1), res.getString(2),res.getString(3),res.getFloat(4));
                tablaClientes.addRow(new String[]{"" + cont, cliente.getCedula(), cliente.getNombre(),
                    cliente.getGenero(),cliente.getIngreso()+""});
            }
            if (cont == 0) {
                JOptionPane.showMessageDialog(null, "No se encontraron clientes");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
        }
        return tablaClientes;
    }
    /**
    * Metodo que actualiza la tabla clientes de la BD.
    */
    public final void actualizarClientes() {
        PreparedStatement sentencia = null;
        final Connection con = conexion.getConnection();
        // update del cliente dentro de la BD
        try {
            sentencia = con.prepareStatement("update cliente set nombre = ?,genero=?, ingreso =?  where cedula = ?");
            sentencia.setString(1, cliente.getNombre());
            sentencia.setString(2,cliente.getGenero());
            sentencia.setFloat(3, cliente.getIngreso());
            sentencia.setString(4, cliente.getCedula());
            final int respuesta = sentencia.executeUpdate();
            if (respuesta > 0) {
                JOptionPane.showMessageDialog(null, "Datos correctamente modificados");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
        }
    }
    /**
    * Metodo que elimina un cliente de la BD.
    */
    public final void eliminarCliente() {
        PreparedStatement sentencia = null;
        final Connection con = conexion.getConnection();
        // insertar los datos del cliente dentro de la BD
        try {
            sentencia = con.prepareStatement("delete from cliente where cedula = ?");
            sentencia.setString(1, cliente.getCedula());
            final int respuesta = sentencia.executeUpdate();
            if (respuesta > 0) {
                JOptionPane.showMessageDialog(null, "Datos correctamente eliminados");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
        }
    }
    /**
    * Metodo que hace la busqueda de un cliente.
    */
    public final void buscar() {
        PreparedStatement sentencia = null;
        final Connection con = conexion.getConnection();
        try {
            sentencia = con.prepareStatement("select * from cliente where cedula = ?");
            sentencia.setString(1, cliente.getCedula());
            resultado = sentencia.executeQuery();
            if (resultado.next()) {
                JOptionPane.showMessageDialog(null, "Cliente Ya consta en la Base de Datos");
            } else {
                insert();
                JOptionPane.showMessageDialog(null, "Datos correctamente ingresados");
            }
        } catch (Exception ex) {
        }
    }
    
    public final void buscarC() {
        PreparedStatement sentencia = null;
        final Connection con = conexion.getConnection();
        // select de todos los clientes y llenado de jtable
        try {
            sentencia = con.prepareStatement("select * from cliente where cedula=?");
            sentencia.setString(1, cliente.getCedula());
            final ResultSet res = sentencia.executeQuery();
            int cont = 0;
            while (res.next()) {
                cont++;              
            }
            if (cont == 0) {
                JOptionPane.showMessageDialog(null, "No se encontraron clientes");
            }else{
                JOptionPane.showMessageDialog(null, "Cliente encontrado");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
        }
    }
}
