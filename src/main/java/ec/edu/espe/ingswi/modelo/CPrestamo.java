/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ingswi.modelo;

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
}
