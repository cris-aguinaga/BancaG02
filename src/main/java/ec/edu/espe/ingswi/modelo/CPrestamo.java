/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ingswi.modelo;

import ec.edu.espe.ingswi.controlador.Conexion;
import java.sql.ResultSet;
import javax.swing.JFrame;

/**
 *
 * @author Sofia Gomez
 */
public class CPrestamo {
    /**
     * Variable que acoge el valor de tasa de interés
     */
    private double tasaInteres;
    /**
     * Variable que acoge el valor del monto del prestamo
     */
    private double monto;
    /**
     * Variable que acoge el plazo del prestamo
     */
    private int plazo;
    
    /**
     * Constructor de la clase CPrestamo
     * @param tasaInteres
     * @param monto
     * @param plazo 
     */
    public CPrestamo(double tasaInteres, double monto, int plazo) {
        this.tasaInteres = tasaInteres;
        this.monto = monto;
        this.plazo = plazo;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(float tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }   
    
     public String TAmortizacion(double cantidadPrestamo, int meses, float interes) {
        
        double capitalAdeuda[] = new double[36];
        double cuota;
        interes = (interes / 100) / 12;
        String cuot = "";
        String tab = "";
        cuota = cantidadPrestamo * ((interes * (Math.pow((1 + interes), meses))) / ((Math.pow((1 + interes), meses)) - 1));
        double interesmonto;
        double reduccionCapital;
        for (int i = 0; i < meses; i++) {
            interesmonto = cantidadPrestamo * interes;
            reduccionCapital = cuota - interesmonto;
            capitalAdeuda[i] =  Math.round(cantidadPrestamo - reduccionCapital)*100/100;            
            cuot =cuot+cuota+"\t"+interesmonto+"\t"+reduccionCapital+"\t"+capitalAdeuda[i] + "\n";
            cantidadPrestamo=capitalAdeuda[i];
        }
        return cuot;

    }
}
