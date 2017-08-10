/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ingswi.vista;

import ec.edu.espe.ingswi.controlador.CClienteDAO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ec.edu.espe.ingswi.modelo.CCliente;

/**
 *
 * @author jona
 */
public class FCliente extends javax.swing.JFrame {

    /**
     * Constructor de la clase.
     */
    public FCliente() {
        initComponents();
        listado();
        this.setTitle("Gestión de Clientes");
    }
    /**
     * @param aux Elemento quesera el que se devuelve en validadCedula.
     */
    private int aux;
    /**
     * @param frame Elemento del mensaje de error.
     */
    private JFrame frame = new JFrame("Mensaje de Error");
    /**
     * @param clienteDao Objeto de la clase CClienteDao.
     */
    private CClienteDAO clienteDAO;

    /**
     *
     * @param cedula Cedula ingresada por el usuario.
     * @return aux
     */
    public final int validarCedula(final int cedula) {
        String cedula1 = Integer.toString(cedula);
        try {
            if (cedula1.length() == 10) {
                int tercerDigito = Integer.parseInt(cedula1.substring(2, 3));
                if (tercerDigito < 6) {
                    int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int verificador = Integer.parseInt(cedula1.substring(9, 10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (cedula1.length() - 1); i++) {
                        digito = Integer.parseInt(cedula1.substring(i, i + 1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }
                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        aux = 1;
                    } else if ((10 - (suma % 10)) == verificador) {
                        aux = 1;
                    } else {
                        aux = 0;
                    }
                } else {
                    aux = 0;
                }
            } else {
                aux = 0;
            }
        } catch (NumberFormatException nfe) {
            aux = 0;
        }
        return aux;
    }

    /**
     * Codigo generado.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegresar = new javax.swing.JButton();
        jpaneldatos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtcedula = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtIngreso = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblcliente = new javax.swing.JTable();
        btnactualizar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btncreacionCliente = new javax.swing.JButton();
        btnbuscar = new javax.swing.JButton();
        btnactualizarCliente = new javax.swing.JButton();
        btneliminarCliente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(380, 200));

        btnRegresar.setText("Volver");
        btnRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegresarMouseClicked(evt);
            }
        });
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jpaneldatos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jpaneldatos.setEnabled(false);

        jLabel2.setText("Nombre");

        txtcedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcedulaKeyTyped(evt);
            }
        });

        jLabel3.setText("Cédula");

        jLabel1.setText("Género");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Femenino", "Masculino" }));

        jLabel4.setText("Ingresos Mensuales");

        txtIngreso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIngresoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jpaneldatosLayout = new javax.swing.GroupLayout(jpaneldatos);
        jpaneldatos.setLayout(jpaneldatosLayout);
        jpaneldatosLayout.setHorizontalGroup(
            jpaneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpaneldatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpaneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGap(46, 46, 46)
                .addGroup(jpaneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtcedula, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIngreso))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jpaneldatosLayout.setVerticalGroup(
            jpaneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpaneldatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpaneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpaneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpaneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpaneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        tblcliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblcliente.setEnabled(false);
        jScrollPane1.setViewportView(tblcliente);

        btnactualizar.setText("Actualizar Tabla");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btncreacionCliente.setText("Creación de Clientes");
        btncreacionCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncreacionClienteActionPerformed(evt);
            }
        });

        btnbuscar.setText("Buscar Cliente");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btnactualizarCliente.setText("Actualizar Clientes");
        btnactualizarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnactualizarClienteMouseClicked(evt);
            }
        });
        btnactualizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarClienteActionPerformed(evt);
            }
        });

        btneliminarCliente.setText("Eliminar Cliente");
        btneliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btneliminarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(btnactualizarCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnbuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btncreacionCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btncreacionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnactualizarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btneliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(406, Short.MAX_VALUE)
                .addComponent(btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(btnRegresar))
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jpaneldatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(333, Short.MAX_VALUE)
                .addComponent(btnRegresar))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpaneldatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     * @param evt evento del boton.
     */
    private void btnactualizarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnactualizarClienteMouseClicked
        FgestionCuentas obj = new FgestionCuentas();
        obj.setVisible(true);
    }//GEN-LAST:event_btnactualizarClienteMouseClicked
    /**
     *
     * @param evt evento del boton.
     */
    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnRegresarMouseClicked
    /**
     *
     * @param evt evento del boton.
     */
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        FMenu obj = new FMenu();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed
    /**
     * Metodo que limpia los campos del JFrame.
     */
    public final void limpiarDatos() {
        txtnombre.setText("");
        txtcedula.setText("");
        txtIngreso.setText("");
    }

    /**
     * Metodo que muetra datos de la Base de datos.
     */
    protected final void listado() {
        String vacio = "";
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            String cedula1 = txtcedula.getText();
            String nombre = txtnombre.getText();
            //String genero = jComboBox1.getSelectedItem().toString();
            //String ingreso = txtIngreso.getText();
            //clienteDAO = new CClienteDAO(new CCliente(cedula1, nombre,genero,Float.parseFloat(ingreso)));
            clienteDAO = new CClienteDAO(new CCliente(cedula1, nombre));
            modelo.addColumn("Cliente");
            modelo.addColumn("Cédula");
            modelo.addColumn("Nombre");
            modelo.addColumn("Género");
            modelo.addColumn("Ingreso");
            tblcliente.setModel(modelo);
            tblcliente.setModel(clienteDAO.visualisarClientes((modelo)));
            limpiarDatos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error aqui");
            ex.printStackTrace();
        }
    }

    /**
     *
     * @param evt evento del boton.
     */
    private void btncreacionClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncreacionClienteActionPerformed
        jpaneldatos.enable(true);
        String vacio = "";
        try {
            if (!vacio.equals(txtnombre.getText())) {
                if (vacio.equals(txtcedula.getText())) {
                    JOptionPane.showMessageDialog(frame, "Ingrese cédula");
                } else {
                    int cedula = Integer.parseInt(txtcedula.getText());
                    validarCedula(cedula);
                    String cedula1;
                    String nombre;
                    float ingreso;
                    String genero;
                    if (aux == 1) {
                        cedula1 = Integer.toString(cedula);
                        nombre = txtnombre.getText();
                        genero = jComboBox1.getSelectedItem().toString();
                        ingreso = Float.parseFloat(txtIngreso.getText());
                        clienteDAO = new CClienteDAO(new CCliente(cedula1, nombre, genero, ingreso));
                        clienteDAO.buscar();
                        limpiarDatos();
                    } else {
                        JOptionPane.showMessageDialog(frame, "La cédula ingresada es incorrecta");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Ingrese nombre");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion a la base");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btncreacionClienteActionPerformed
    /**
     *
     * @param evt evento del boton.
     */
    private void btnactualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarClienteActionPerformed
        jpaneldatos.enable(true);
        String vacio = "";
        try {
            if (!vacio.equals(txtnombre.getText())) {
                if (vacio.equals(txtcedula.getText())) {
                    JOptionPane.showMessageDialog(frame, "Ingrese cédula");
                } else {
                    int cedula = Integer.parseInt(txtcedula.getText());
                    validarCedula(cedula);
                    String cedula1;
                    String nombre;
                    float ingreso;
                    String genero;
                    if (aux == 1) {
                        cedula1 = Integer.toString(cedula);
                        nombre = txtnombre.getText();
                        genero = jComboBox1.getSelectedItem().toString();
                        ingreso = Float.parseFloat(txtIngreso.getText());
                        clienteDAO = new CClienteDAO(new CCliente(cedula1, nombre, genero, ingreso));
                        clienteDAO.actualizarClientes();
                        limpiarDatos();
                    } else {
                        JOptionPane.showMessageDialog(frame, "La cédula ingresada es incorrecta");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Ingrese nombre");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion a la base");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnactualizarClienteActionPerformed
    /**
     *
     * @param evt evento del boton.
     */
    private void btneliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarClienteActionPerformed
        jpaneldatos.enable(true);
        String vacio = "";
        int confirmar = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar al cliente?");
        if (JOptionPane.OK_OPTION == confirmar) {
            try {
                if (vacio.equals(txtcedula.getText())) {
                    JOptionPane.showMessageDialog(null, "Ingrese un campo para eliminar al cliente");
                } else {
                    int cedula = Integer.parseInt(txtcedula.getText());
                    validarCedula(cedula);
                    String cedula1;
                    String nombre;
                    String genero;
                    Float ingreso;
                    if (aux == 1) {
                        cedula1 = Integer.toString(cedula);
                        nombre = txtnombre.getText();
                        genero = jComboBox1.getSelectedItem().toString();
                        ingreso = Float.parseFloat(txtIngreso.getText());
                        clienteDAO = new CClienteDAO(new CCliente(cedula1, nombre,genero,ingreso));
                        clienteDAO.eliminarCliente();
                        limpiarDatos();
                    } else {
                        JOptionPane.showMessageDialog(frame, "La cédula ingresada es incorrecta");
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error de conexion a la base");
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btneliminarClienteActionPerformed
    /**
     *
     * @param evt evento del boton.
     */
    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        if ((evt.getKeyChar() < (char) 48 || evt.getKeyChar() > (char) 57) && evt.getKeyChar() != (char) 46) {
            evt.consume();
        }
    }//GEN-LAST:event_txtnombreKeyTyped
    /**
     *
     * @param evt evento del boton.
     */
    private void txtcedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaKeyTyped
        if (evt.getKeyChar() < (char) 48 || evt.getKeyChar() > (char) 57) {
            evt.consume();
        }
    }//GEN-LAST:event_txtcedulaKeyTyped
    /**
     *
     * @param evt evento del boton.
     */
    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        txtcedula.setText("");
        txtnombre.setText("");
    }//GEN-LAST:event_btnlimpiarActionPerformed
    /**
     *
     * @param evt evento del boton.
     */
    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed

        DefaultTableModel modelo = new DefaultTableModel();
        String vacio = "";
        try {
            if (vacio.equals(txtnombre.getText())) {
                if (vacio.equals(txtcedula.getText())) {
                    JOptionPane.showMessageDialog(frame, "Ingrese cédula");
                } else {
                    int cedula = Integer.parseInt(txtcedula.getText());
                    validarCedula(cedula);
                    String cedula1;
                    String nombre;
                    String genero;
                    float ingreso;
                    if (aux == 1) {
                        cedula1 = Integer.toString(cedula);
                        nombre = txtnombre.getText();
                        genero = jComboBox1.getSelectedItem().toString();
                        ingreso = Float.parseFloat(txtIngreso.getText());
                        clienteDAO = new CClienteDAO(new CCliente(cedula1, nombre, genero, ingreso));
                        modelo.addColumn("Cliente");
                        modelo.addColumn("Cédula");
                        modelo.addColumn("Nombre");
                        modelo.addColumn("Genero");
                        modelo.addColumn("Ingreso");
                        tblcliente.setModel(modelo);
                        tblcliente.setModel(clienteDAO.busquedaCedula((modelo)));
                    } else {
                        JOptionPane.showMessageDialog(frame, "La cédula no esta en la base de datos");
                    }
                }
            } else {
                if (vacio.equals(txtcedula.getText())) {
                    String cedula1 = txtcedula.getText();
                    String nombre = txtnombre.getText();
                    String genero = jComboBox1.getSelectedItem().toString();
                    float ingreso = Float.parseFloat(txtIngreso.getText());
                    clienteDAO = new CClienteDAO(new CCliente(cedula1, nombre, genero, ingreso));
                    modelo.addColumn("Cliente");
                    modelo.addColumn("Cédula");
                    modelo.addColumn("Nombre");
                    modelo.addColumn("Genero");
                    modelo.addColumn("Ingreso");
                    tblcliente.setModel(modelo);
                    tblcliente.setModel(clienteDAO.busquedaNombre((modelo)));
                } else {
                    int cedula = Integer.parseInt(txtcedula.getText());
                    validarCedula(cedula);
                    String cedula1;
                    String nombre;
                    if (aux == 1) {

                        cedula1 = Integer.toString(cedula);
                        nombre = txtnombre.getText();
                        String genero = jComboBox1.getSelectedItem().toString();
                        float ingreso = Float.parseFloat(txtIngreso.getText());
                        clienteDAO = new CClienteDAO(new CCliente(cedula1, nombre, genero, ingreso));
                        modelo.addColumn("Cliente");
                        modelo.addColumn("Cédula");
                        modelo.addColumn("Nombre");
                        modelo.addColumn("Genero");
                        modelo.addColumn("Ingreso");
                        tblcliente.setModel(modelo);
                        tblcliente.setModel(clienteDAO.busquedaCedula((modelo)));
                    } else {
                        JOptionPane.showMessageDialog(frame, "La cédula no esta en la base de datos");
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion a la base");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnbuscarActionPerformed
    /**
     *
     * @param evt evento del boton.
     */
    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        listado();
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void txtIngresoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIngresoKeyTyped
        // TODO add your handling code here:
         if (evt.getKeyChar() < (char) 48 || evt.getKeyChar() > (char) 57) {
            evt.consume();
        }
    }//GEN-LAST:event_txtIngresoKeyTyped
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
            java.util.logging.Logger.getLogger(FCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FCliente().setVisible(true);
            }
        });
    }

    /**
     * btnRegresar Boton que regresa al menu principal. btnactualizar Boton que
     * actualiza los datos dentro del tblcliente btnactualizarCliente Boton que
     * actualiza datos dentro de la BD btnbuscar Boton que busca a cliente
     * dentro de la BD btncreacionCliente Boton que ingresa nuevos datos dentro
     * de la BD btneliminarCliente Boton que elimina a cliente jLabel2 Label
     * Cedula jLabel3 Label Nombre jPanel1 Panel que tiene las opciones del CRUD
     * jScrollPane1 Espacio que contiene a tblcliente jpaneldatos Panel donde se
     * ingresa datos del cliente tblcliente Tabla donde se muestra los datos
     * txtcedula Cuadro de texto de cedula txtnombre Cuadro de texto de nombre
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnactualizarCliente;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncreacionCliente;
    private javax.swing.JButton btneliminarCliente;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpaneldatos;
    private javax.swing.JTable tblcliente;
    private javax.swing.JTextField txtIngreso;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
