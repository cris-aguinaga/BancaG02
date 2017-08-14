/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ingswi.modelo;

/**
 *
 * @author AyrtonWladimir
 */
public class CTabla {
    
    private String fecha;
    private double cuota;
    private double interesMonto;
    private double capitalAmortizado;
    private double capitalAdeudado;

    public CTabla() {
    }

    public CTabla(String fecha, double cuota, double interesMonto, double capitalAmortizado, double capitalAdeudado) {
        this.fecha = fecha;
        this.cuota = cuota;
        this.interesMonto = interesMonto;
        this.capitalAmortizado = capitalAmortizado;
        this.capitalAdeudado = capitalAdeudado;
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

    public double getInteresMonto() {
        return interesMonto;
    }

    public void setInteresMonto(double interesMonto) {
        this.interesMonto = interesMonto;
    }

    public double getCapitalAmortizado() {
        return capitalAmortizado;
    }

    public void setCapitalAmortizado(double capitalAmortizado) {
        this.capitalAmortizado = capitalAmortizado;
    }

    public double getCapitalAdeudado() {
        return capitalAdeudado;
    }

    public void setCapitalAdeudado(double capitalAdeudado) {
        this.capitalAdeudado = capitalAdeudado;
    }
    
    
}
