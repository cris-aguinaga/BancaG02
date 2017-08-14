/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ingswi.modelo;

import java.sql.Date;

/**
 *
 * @author Sofia Gomez
 */
public class CAmortizacion {
    private int numCuota;
    private String fecha;
    private double cuota;
    private double interesM;
    private double capAmo;
    private double capAde;

    public CAmortizacion(int numCuota, String fecha, double cuota, double interesM, double capAmo, double capAde) {
        this.numCuota = numCuota;
        this.fecha = fecha;
        this.cuota = cuota;
        this.interesM = interesM;
        this.capAmo = capAmo;
        this.capAde = capAde;
    }
    
    public int getNumCuota() {
        return numCuota;
    }

    public void setNumCuota(int numCuota) {
        this.numCuota = numCuota;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }

    public double getInteresM() {
        return interesM;
    }

    public void setInteresM(double interesM) {
        this.interesM = interesM;
    }

    public double getCapAmo() {
        return capAmo;
    }

    public void setCapAmo(double capAmo) {
        this.capAmo = capAmo;
    }

    public double getCapAde() {
        return capAde;
    }

    public void setCapAde(double capAde) {
        this.capAde = capAde;
    }   
}
