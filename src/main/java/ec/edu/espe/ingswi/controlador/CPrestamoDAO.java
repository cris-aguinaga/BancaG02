/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ingswi.controlador;

import ec.edu.espe.ingswi.modelo.CPrestamo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sofia Gomez
 */
public class CPrestamoDAO {

    //Atributos
    private CPrestamo prestamo;
    private JFrame frame = new JFrame("Mensaje de Error");
    private double promTotal;
    private int control;
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
        control = 0;
    }

    public int getControl() {
        return control;
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
        if (monto > 0 && monto <= promTotal) {
            if (plazo >= 3 && plazo <= 36) {
                if (plazo <= 12) {
                    tasaInteres = 10;
                } else {
                    tasaInteres = 16;
                }
                JOptionPane.showMessageDialog(null, "Usted puede obtener el prestamo.");
                control = 1;
            }
        } else {
            JOptionPane.showMessageDialog(null, "El monto del prestamo es superior al límite de su cuenta.");
        }
        return tasaInteres;
    }

    public final DefaultTableModel TAmortizacion(double cantidadPrestamo, int meses, double interes, final DefaultTableModel tablaA) {
        DecimalFormat df = new DecimalFormat("#.00");
        double capitalAdeuda[] = new double[36];
        double cuota;
        interes = (interes / 100) / 12;
        cuota = cantidadPrestamo * ((interes * (Math.pow((1 + interes), meses))) / ((Math.pow((1 + interes), meses)) - 1));
        double interesmonto;
        double reduccionCapital;
        for (int i = 0; i < meses; i++) {
            interesmonto = cantidadPrestamo * interes;
            reduccionCapital = cuota - interesmonto;
            capitalAdeuda[i] = cantidadPrestamo - reduccionCapital;
            tablaA.addRow(new String[]{"" + (i + 1), String.valueOf(df.format(cuota)), 
                String.valueOf(df.format(interesmonto)), 
                String.valueOf(df.format(reduccionCapital)), 
                String.valueOf(df.format(capitalAdeuda[i]))});
            cantidadPrestamo = capitalAdeuda[i];
        }
        return tablaA;
    }
}
