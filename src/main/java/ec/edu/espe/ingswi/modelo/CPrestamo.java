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

    //Atributos
    private JFrame frame = new JFrame("Mensaje de Error");
    private ResultSet resultado;
    private String cod_cuenta;
    private final Conexion conn;
    
   /**
    * 
    */
    public CPrestamo() {
        conn = new Conexion();
    }
    
//   public String obtenerSaldo() {
//        float aux = 0;
//        String cod = "0";        
//        try {
//            resultado = conn.ejecutarSQLSelect("Select SALDO from CUENTA where CODIGO_CUENTA like '%" + cod_cuenta + "%'");
//            while (resultado.next()) {
//                cod = resultado.getString(1);
//            }
//            //aux = Float.parseFloat(cod);
//        } catch (SQLException ex) {
//
//        }
//        return cod;
//    } 
    
    /**
     * 
     * @return 
     */
    public int CalculoMontoMaximo() {
        int n = 0;
        n = n * 3;
        return n;
    }
}
