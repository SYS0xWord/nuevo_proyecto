/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario2;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author chr97lubuntu
 */
public class pl extends javax.swing.JFrame {
    Conexion con = new Conexion();
    Connection Consulta = con.conexion();
    Connection Insertar = con.conexion();
    Connection detalle = con.conexion();
    Connection prestamo = con.conexion();
     Connection cn = con.conexion();

    /**
     * Creates new form pl
     */
    public pl() {
        initComponents();
        this.setDefaultCloseOperation(this.HIDE_ON_CLOSE); 
          Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();    
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        planilla = new javax.swing.JButton();
        mes = new javax.swing.JComboBox<>();
        anio = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(189, 189, 189));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        planilla.setBackground(new java.awt.Color(189, 189, 189));
        planilla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/plani28.png"))); // NOI18N
        planilla.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 102), 1, true));
        planilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                planillaActionPerformed(evt);
            }
        });
        jPanel1.add(planilla, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 100, -1));

        mes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        jPanel1.add(mes, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 110, -1));

        anio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" }));
        jPanel1.add(anio, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 110, -1));

        jLabel1.setText("Crear planilla");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        jLabel2.setText("Visualizar planillas");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, -1, -1));

        ver.setBackground(new java.awt.Color(189, 189, 189));
        ver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ver45.png"))); // NOI18N
        ver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verActionPerformed(evt);
            }
        });
        jPanel1.add(ver, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 100, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private String cont(){
        String em="0";
        
        try {
            Statement sx = Consulta.createStatement();
            ResultSet Ca = sx.executeQuery("SELECT COUNT(*) FROM planilla");
            while(Ca.next()){
               int tam = Integer.parseInt(Ca.getString(1))+1;
               em=String.valueOf(tam);
            }
            
            
            }
            catch (SQLException ex) {
                Logger.getLogger(IngresarProve.class.getName()).log(Level.SEVERE, null, ex);
            }
         return em;
    }
    
    private void planillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_planillaActionPerformed
        // TODO add your handling code here:
        valorusuario();

    }//GEN-LAST:event_planillaActionPerformed
   private void insertardetalle(String sb, String des, String name, String lastn){
        float igss = (float) ((4.83/100)*Float.parseFloat(sb));
      try {
            PreparedStatement CrearEm = cn.prepareStatement("INSERT INTO detalleplanilla(igss,sueldobase,descuento,nombre,apellido,mes,anio) VALUES(?,?,?,?,?,?,?)");
            CrearEm.setString(1, String.valueOf(igss));
            CrearEm.setString(2, sb);
            CrearEm.setString(3, des);
            CrearEm.setString(4, name);
            CrearEm.setString(5, lastn);
            CrearEm.setString(6, mes.getSelectedItem().toString());
            CrearEm.setString(7, anio.getSelectedItem().toString());
            //CrearEm.setString(2, anio.getSelectedItem().toString());
            //CrearEm.setString(3, cont());
            CrearEm.executeUpdate();
            CrearEm.close();
                        
            
                }
            catch (SQLException ex) {
                Logger.getLogger(IngresarProve.class.getName()).log(Level.SEVERE, null, ex);
            }
       
 
   }
    private String valorusuario(){
        String em="0";
       try {
            Statement sx = Consulta.createStatement();
            ResultSet Ca = sx.executeQuery("SELECT Usuario FROM empleados");
            while(Ca.next()){
                insertardetalle(valorsueldo(Ca.getString(1)),valordes(Ca.getString(1)),valorname(Ca.getString(1)),valorape(Ca.getString(1)));
                ajustarprestamos(Ca.getString(1));
            }
            
            
            }
            catch (SQLException ex) {
                Logger.getLogger(IngresarProve.class.getName()).log(Level.SEVERE, null, ex);
            }
       return em;
    }
    private String valorape(String us){
        String em="0";
       try {
            Statement sx = Consulta.createStatement();
            ResultSet Ca = sx.executeQuery("SELECT Apellido FROM empleados WHERE Usuario='"+us+"'");
            while(Ca.next()){
               em=Ca.getString(1); 
            }
            
            
            }
            catch (SQLException ex) {
                Logger.getLogger(IngresarProve.class.getName()).log(Level.SEVERE, null, ex);
            }
       return em;
    }
    private String valorsueldo(String us){
        String em="0";
       try {
            Statement sx = Consulta.createStatement();
            ResultSet Ca = sx.executeQuery("SELECT Sueldo FROM empleados WHERE Usuario='"+us+"'");
            while(Ca.next()){
               em=Ca.getString(1); 
            }
            
            
            }
            catch (SQLException ex) {
                Logger.getLogger(IngresarProve.class.getName()).log(Level.SEVERE, null, ex);
            }
       return em;
    }
    private String valorname(String us){
        String em="0";
       try {
            Statement sx = Consulta.createStatement();
            ResultSet Ca = sx.executeQuery("SELECT Nombre FROM empleados WHERE Usuario='"+us+"'");
            while(Ca.next()){
               em=Ca.getString(1); 
            }
            
            
            }
            catch (SQLException ex) {
                Logger.getLogger(IngresarProve.class.getName()).log(Level.SEVERE, null, ex);
            }
       return em;
    }
    private String valordes(String us){
        String em="0";
       try {
            Statement sx = Consulta.createStatement();
            ResultSet Ca = sx.executeQuery("SELECT mensualidad FROM prestamo WHERE empleados_Usuario='"+us+"'AND Monto>0");
            while(Ca.next()){
               em=Ca.getString(1); 
            }
            
            
            }
            catch (SQLException ex) {
                Logger.getLogger(IngresarProve.class.getName()).log(Level.SEVERE, null, ex);
            }
       return em;
    }
    private void insertardetalles(String sb, String des, String name, String lastn){
        float igss = (float) ((4.83/100)*Float.parseFloat(sb));
        try {
            PreparedStatement CrearD = detalle.prepareStatement("INSERT INTO detalleplanilla(igss,sueldobase,descuento,nombre,apellido,planilla_id) VALUES(?,?,?,?,?,?)");
            CrearD.setString(1, String.valueOf(igss));
            CrearD.setString(2,sb);
            CrearD.setString(3,des);
            CrearD.setString(4,name);
            CrearD.setString(5,lastn);
            CrearD.setString(6,cont());
            
            CrearD.executeUpdate();
            CrearD.close();
            
            
            
                }
            catch (SQLException ex) {
                Logger.getLogger(IngresarProve.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
            
    private int tamañoempleados(){
        int em=0;
         try {
            Statement sx = Consulta.createStatement();
            ResultSet Ca = sx.executeQuery("SELECT COUNT(*) FROM empleados");
            while(Ca.next()){
               em=Integer.parseInt(Ca.getString(1)); 
            }
            
            
            }
            catch (SQLException ex) {
                Logger.getLogger(IngresarProve.class.getName()).log(Level.SEVERE, null, ex);
            }
         return em;
        
    }
    private void ajustarprestamos(String u){
        float abono=0;
             try {
            PreparedStatement Actualizar = Insertar.prepareStatement("UPDATE prestamo set Monto=Monto-mensualidad where Monto>0 && empleados_Usuario='"+u+"'");
                   Actualizar.executeUpdate();
                   Actualizar.close();
            
            }
            catch (SQLException ex) {
                Logger.getLogger(IngresarProve.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        
        
    }
    private void verActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verActionPerformed
        // TODO add your handling code here:
        planilla pll = new planilla();
        pll.setVisible(true);
    }//GEN-LAST:event_verActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(pl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pl().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> anio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> mes;
    private javax.swing.JButton planilla;
    private javax.swing.JButton ver;
    // End of variables declaration//GEN-END:variables
}
