/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ingswi.controlador;

import ec.edu.espe.ingswi.modelo.CCliente;
import ec.edu.espe.ingswi.modelo.CPrestamo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Sofia Gomez
 */
public class CPrestamoDAO {

    //Atributos
    private CPrestamo prestamo;
    private JFrame frame = new JFrame("Mensaje de Error");
    private double promTotal;
    /**
     * conexion establece la conexion con la base de datos.
     */
    private Conexion conexion;
    /**
     * resultado guarda las acciones DML en la BD.
     */
    private ResultSet resultado;

    /**
     *
     */
    public CPrestamoDAO() {
        this.conexion = new Conexion();
    }

    public final double obtener_promedio(String cedula) {
        PreparedStatement sentencia = null;
        double promedio = 0;
        final Connection con = conexion.getConnection();
        // insertar los datos en movimiento dentro de la BD
        try {
            sentencia = con.prepareCall("select promedio(?)");
            sentencia.setString(1, cedula);
            resultado = sentencia.executeQuery();
            resultado.next();
            promedio = resultado.getDouble(1);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, "Error");
            e.printStackTrace();
        }
        promedio = promedio * 3;
        promTotal = promedio;
        return promedio;
    }
    
    public double generarPrestamo(double monto, int plazo) {
        double tasaInteres = 0;
        if(monto > 0 || monto < promTotal){
            if(plazo >=3 || plazo <= 36){
                if(plazo <= 12){
                    tasaInteres = 0.1;
                }else{
                    tasaInteres = 0.16;
                }
                JOptionPane.showMessageDialog(null, "Usted puede obtener el prestamo.");
            }
        }else{
            JOptionPane.showMessageDialog(null, "El mónto del prestamo es superior al límite de su cuenta.");            
        }
        return tasaInteres;
    }
}
