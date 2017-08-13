/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ingswi.vista;

import ec.edu.espe.ingswi.controlador.CMovimientoDAO;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ec.edu.espe.ingswi.modelo.CCliente;
import ec.edu.espe.ingswi.modelo.CCuenta;
import ec.edu.espe.ingswi.modelo.CMovimiento;

/**
 *
 * @author USER
 */
public class FConsultaMovimientos extends javax.swing.JFrame {

    /**
     * Creates new form FConsultaMovimientos.
     */
    public FConsultaMovimientos() {
        initComponents();
        listado();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private CMovimientoDAO movimientoDAO;

    /**
     * listado Metodo que creara la vista de la BD en tbmovimientos.
     */
    protected final void listado() {
        String vacio = "";
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            String dato = txtbusqueda.getText();
            movimientoDAO = new CMovimientoDAO(new CMovimiento(new CCuenta(txtbusqueda.getText(),
                    new CCliente("", ""), "", 0, ""), "", new Date(0, 0, 0), 0, 0));
            modelo.addColumn("Cod_Cuenta");
            modelo.addColumn("Tipo");
            modelo.addColumn("Fecha");
            modelo.addColumn("Monto");
            modelo.addColumn("Saldo");
            tbmovimientos.setModel(modelo);
            tbmovimientos.setModel(movimientoDAO.visualisarMovimientos((modelo)));
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Error de conexion a la base");
            ex.printStackTrace();
        }
    }

    /**
     * Codigo generado.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnbuscar = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        txtbusqueda = new javax.swing.JTextField();
        txtdate1 = new javax.swing.JFormattedTextField();
        txtdate2 = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rdbtFecha = new javax.swing.JRadioButton();
        rdbtNumero = new javax.swing.JRadioButton();
        txtNumero = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbmovimientos = new javax.swing.JTable();
        btnvolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(280, 20));
        setPreferredSize(new java.awt.Dimension(865, 605));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Código de cuenta :");

        btnbuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnbuscar.setText("Buscar");
        btnbuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnbuscarMouseClicked(evt);
            }
        });

        btnlimpiar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnlimpiar.setText("Limpiar Campos");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });

        txtbusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbusquedaKeyTyped(evt);
            }
        });

        txtdate1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        txtdate1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdate1KeyTyped(evt);
            }
        });

        txtdate2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        txtdate2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdate2KeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Desde:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Hasta:");

        rdbtFecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbtFecha.setSelected(true);
        rdbtFecha.setLabel("Fecha");
        rdbtFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdbtFechaMouseClicked(evt);
            }
        });

        rdbtNumero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbtNumero.setText("Numero de movimientos");
        rdbtNumero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdbtNumeroMouseClicked(evt);
            }
        });

        txtNumero.setEnabled(false);
        txtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Numero");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rdbtNumero)
                                        .addGap(124, 124, 124))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(71, 71, 71)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(rdbtFecha))
                                .addGap(18, 18, 18)
                                .addComponent(txtdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtdate2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbtNumero)
                    .addComponent(rdbtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtdate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtdate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        tbmovimientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo_movimiento", "Cuenta", "Tipo", "Fecha", "Monto", "Saldo"
            }
        ));
        jScrollPane1.setViewportView(tbmovimientos);

        btnvolver.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnvolver.setText("Volver");
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnvolver, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnvolver))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     *
     * @param evt evento del boton.
     */
    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        FMenu obj = new FMenu();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnvolverActionPerformed
    /**
     *
     * @param evt evento del boton.
     */
    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        txtbusqueda.setText("");
        txtNumero.setText("");
        txtdate2.setText("");
        txtdate1.setText("");
    }//GEN-LAST:event_btnlimpiarActionPerformed
    /**
     *
     * @param evt evento del boton.
     */
    private void txtbusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbusquedaKeyTyped
        if (evt.getKeyChar() < (char) 48 || evt.getKeyChar() > (char) 57) {
            evt.consume();
        }
    }//GEN-LAST:event_txtbusquedaKeyTyped
    /**
     *
     * @param evt evento del boton.
     */
    private void rdbtFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbtFechaMouseClicked
        visible = !visible;
        rdbtNumero.doClick();
        txtdate1.setEnabled(visible);
        txtdate2.setEnabled(visible);
        txtNumero.setEnabled(!visible);
        txtNumero.setText("");
    }//GEN-LAST:event_rdbtFechaMouseClicked
    /**
     *
     * @param evt evento del boton.
     */
    private void rdbtNumeroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbtNumeroMouseClicked
        visible = !visible;
        rdbtFecha.doClick();
        txtdate1.setEnabled(visible);
        txtdate1.setText("");
        txtdate2.setEnabled(visible);
        txtdate2.setText("");
        txtNumero.setEnabled(!visible);
    }//GEN-LAST:event_rdbtNumeroMouseClicked

    /**
     *
     * @param evt evento del boton.
     */
    private void btnbuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbuscarMouseClicked
        String vacio = "";
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            String dato = txtbusqueda.getText();
            movimientoDAO = new CMovimientoDAO(new CMovimiento(new CCuenta(txtbusqueda.getText(),
                    new CCliente("", ""), "", 0, ""), "", new Date(0, 0, 0), 0, 0));
            modelo.addColumn("Cod:_Cuenta");
            modelo.addColumn("Tipo");
            modelo.addColumn("Fecha");
            modelo.addColumn("Monto");
            modelo.addColumn("Saldo");
            tbmovimientos.setModel(modelo);
            if (txtNumero.getText().length() == 0 || txtbusqueda.getText().length() == 0
                    && txtdate1.getText().length() == 0 && txtdate2.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Campos Vacios");
                return;
            }
            for (int i = 0; i < txtbusqueda.getText().length(); i++) {
                if (txtbusqueda.getText().charAt(i) < (char) 48 || txtbusqueda.getText().charAt(i) > (char) 57) {
                    JOptionPane.showMessageDialog(null, "Cuenta invalida");
                    return;
                }
            }
            for (int i = 0; i < txtNumero.getText().length(); i++) {
                if (txtNumero.getText().charAt(i) < (char) 48 || txtNumero.getText().charAt(i) > (char) 57) {
                    JOptionPane.showMessageDialog(null, "Numero invalido");
                    return;
                }
            }
            for (int i = 0; i < txtdate1.getText().length(); i++) {
                if (txtdate1.getText().charAt(i) < (char) 48 || txtdate1.getText().charAt(i) > (char) 57) {
                    JOptionPane.showMessageDialog(null, "Fecha de inicio invalida");
                    return;
                }
            }
            for (int i = 0; i < txtdate2.getText().length(); i++) {
                if (txtdate2.getText().charAt(i) < (char) 48 || txtdate2.getText().charAt(i) > (char) 57) {
                    JOptionPane.showMessageDialog(null, "Fecha de fin invalida");
                    return;
                }
            }
            if (rdbtNumero.isSelected()) {
                tbmovimientos.setModel(movimientoDAO.busquedaMovimiento((modelo), 
                        Integer.parseInt(txtNumero.getText())));
            } else if (rdbtFecha.isSelected()) {
                java.sql.Date.valueOf(txtdate1.getText());
                tbmovimientos.setModel(movimientoDAO.busquedaMovimientoFecha(
                        (modelo), java.sql.Date.valueOf(txtdate1.getText()), 
                        java.sql.Date.valueOf(txtdate2.getText())));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion a la base");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnbuscarMouseClicked
    /**
     *
     * @param evt evento del boton.
     */
    private void txtNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroKeyTyped
        if ((evt.getKeyChar() < (char) 48 || evt.getKeyChar() > (char) 57)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNumeroKeyTyped
    /**
     *
     * @param evt evento del boton.
     */
    private void txtdate1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdate1KeyTyped
        if ((evt.getKeyChar() < (char) 48 || evt.getKeyChar() > (char) 57)
                && evt.getKeyChar() != (char) 45 && evt.getKeyChar() != (char) 47) {
            evt.consume();
        }
    }//GEN-LAST:event_txtdate1KeyTyped
    /**
     *
     * @param evt evento del boton.
     */
    private void txtdate2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdate2KeyTyped
        if ((evt.getKeyChar() < (char) 48 || evt.getKeyChar() > (char) 57)
                && evt.getKeyChar() != (char) 45 && evt.getKeyChar() != (char) 47) {
            evt.consume();
        }
    }//GEN-LAST:event_txtdate2KeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FConsultaMovimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FConsultaMovimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FConsultaMovimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FConsultaMovimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FConsultaMovimientos().setVisible(true);
            }
        });
    }

    /**
     * @param visible Variable auxiliar para menu desplegable.
     */
    private boolean visible = true;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JButton btnvolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdbtFecha;
    private javax.swing.JRadioButton rdbtNumero;
    private javax.swing.JTable tbmovimientos;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtbusqueda;
    private javax.swing.JFormattedTextField txtdate1;
    private javax.swing.JFormattedTextField txtdate2;
    // End of variables declaration//GEN-END:variables
}
