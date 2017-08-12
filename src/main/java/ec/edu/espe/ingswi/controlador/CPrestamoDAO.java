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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sofia Gomez
 */
public class CPrestamoDAO {

    //Atributos
    private CPrestamo prestamo;
    private double promTotal;
    private int control;
    private Calendar c1 = GregorianCalendar.getInstance();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    private DecimalFormat df = new DecimalFormat("#.00");
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
        String fechaP = "";
        double capitalAdeuda[] = new double[36];
        double cuota;
        interes = (interes / 100) / 12;
        cuota = cantidadPrestamo * ((interes * (Math.pow((1 + interes), meses))) / ((Math.pow((1 + interes), meses)) - 1));
        double interesmonto;
        double reduccionCapital;
        for (int i = 0; i <= meses; i++) {
            if (i == 0) {
                tablaA.addRow(new String[]{"" + i, "", "", "", "", ""});
            } else {
                if (i > 1) {
                    try {
                        c1.setTime(sdf.parse(fechaP));
                    } catch (ParseException ex) {
                        Logger.getLogger(CPrestamoDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                c1.add(Calendar.MONTH, 1);
                interesmonto = cantidadPrestamo * interes;
                reduccionCapital = cuota - interesmonto;
                capitalAdeuda[i] = cantidadPrestamo - reduccionCapital;
                tablaA.addRow(new String[]{"" + i, sdf.format(c1.getTime()), String.valueOf(df.format(cuota)),
                    String.valueOf(df.format(interesmonto)),
                    String.valueOf(df.format(reduccionCapital)),
                    String.valueOf(df.format(capitalAdeuda[i]))});
                cantidadPrestamo = capitalAdeuda[i];
            }
            fechaP = sdf.format(c1.getTime());
        }
        return tablaA;
    }

    public String calcularCouta(double cantidadPrestamo, int meses, double interes, String cedula) {
        PreparedStatement sentencia = null;
        final Connection con = conexion.getConnection();
        String resultado = "";
        double cuota = 0;
        double ingreso = 0;
        try {
            sentencia = con.prepareStatement("select ingreso from cliente where cedula=?");
            sentencia.setString(1, cedula);
            final ResultSet res = sentencia.executeQuery();
            int cont = 0;
            while (res.next()) {
                cont++;
                ingreso = res.getDouble(1);
            }
            interes = (interes / 100) / 12;
            cuota = cantidadPrestamo * ((interes * (Math.pow((1 + interes), meses))) / ((Math.pow((1 + interes), meses)) - 1));
            if(cuota > (ingreso * 0.3)){
                resultado = "Prestamo solicitado:\n" + "Monto: " + cantidadPrestamo + "\t\t Tasa de interes: "+ df.format(interes) 
                        + "\t\t Plazo: " + meses + " meses" + "\n\n Cuota a pagar: " + df.format(cuota) + "\n Ingresos (30%) = " 
                        + df.format(ingreso * 0.3) 
                        + "\n\n El prestamo solicitado no se puede realizar, la cuota supera el 30% de sus ingresos.";
            }else{
                resultado = "Prestamo solicitado:\n" + "Monto: " + cantidadPrestamo + "\t Tasa de interes: "+ df.format(interes) 
                        + "\t Plazo: " + meses + "meses" + "\n\n Cuota a pagar = " + df.format(cuota) + "\n Ingresos (30%) = " 
                        + df.format(ingreso * 0.3) 
                        + "\n\n Prestamo solicitado autorizado.";
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
        }
        return resultado;
    }
}
