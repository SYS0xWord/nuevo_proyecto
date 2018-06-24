/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario2;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author chr97lubuntu
 */
public class resultados extends javax.swing.JFrame {
    Conexion con = new Conexion();
   
    Connection Consulta = con.conexion();
    /**
     * Creates new form resultados
     */
    public resultados() {
        initComponents();
        dia.setText(" ");
        mes.setText(" ");
        anio.setText(" ");
        
        
         this.setDefaultCloseOperation(this.HIDE_ON_CLOSE); 
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();    
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        DefaultTableModel modelo = new DefaultTableModel() {
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return false;
                }
            };
            modelo.addColumn("                          ");
            modelo.addColumn("                ");
            modelo.addColumn("                ");
            modelo.addColumn("                ");
            cuentas.setModel(modelo);
            
            String datos[] = new String[4];
           
            datos[0]="      Ingresos         ";
            datos[1]="";
            datos[2]="";
            datos[3]="";
            modelo.addRow(datos);
                    

          try {

            Statement sx = Consulta.createStatement();
            ResultSet Ca = sx.executeQuery("SELECT nombre, saldo from  cuentasestador");
          
            while (Ca.next()) {
               
                datos[0] = Ca.getString(1);
                datos[1] = Ca.getString(2);
                datos[2] = "";
                datos[3]="";
                
                modelo.addRow(datos);
                
                if(datos[0].equals("Ventas netas")){
                    datos[0] = "           Costo de Ventas";
                    datos[1] = "";
                    datos[2] = "";
                    datos[3]="";
                    modelo.addRow(datos);
                }
                if(datos[0].equals("(+) Gastos sobre compras")){
                    datos[0] = "Compras brutas";
                    datos[1] = "";
                    datos[2] = "";
                    datos[3]="";
                    modelo.addRow(datos);
                    
                }
                if(datos[0].equals("(-) Devoluciones y rebajas sobre compras")){
                   
                    datos[0] = "Compras netas";
                    datos[1] = "";
                    datos[2] = "";
                    datos[3]="";
                    modelo.addRow(datos);
                      datos[0] = "Mercaderias disponibles";
                    datos[1] = "";
                    datos[2] = "";
                    datos[3]="";
                    modelo.addRow(datos);
                }
                if(datos[0].equals("(-) Mercaderias (Inventario Final)")){
                   
                    datos[0] = "Costo de ventas";
                    datos[1] = "";
                    datos[2] = "";
                    datos[3]="";
                    modelo.addRow(datos);
                    datos[0] = "Margen bruto";
                    datos[1] = "";
                    datos[2] = "";
                    datos[3]="";
                    modelo.addRow(datos);
                       datos[0] = "         Gastos de operacion ";
                    datos[1] = "";
                    datos[2] = "";
                    datos[3]="";
                    modelo.addRow(datos);
                       datos[0] = "Gastos de distribución";
                    datos[1] = "";
                    datos[2] = "";
                    datos[3]="";
                    modelo.addRow(datos);
                }//
                 if(datos[0].equals("Gastos diversos sala de ventas")){
                   
                    datos[0] = "Gastos de administración";
                    datos[1] = "";
                    datos[2] = "";
                    datos[3]="";
                    modelo.addRow(datos);
                    
                }//Gastos diversos de oficina
                if(datos[0].equals("Gastos diversos de oficina")){
                   
                    datos[0] = "Otros gastos de operación";
                    datos[1] = "";
                    datos[2] = "";
                    datos[3]="";
                    modelo.addRow(datos);
                    
                }
                if(datos[0].equals("Regalías")&&datos[1].equals("0")){
                   
                    //eliminar las dos filas inseertadas
                    
                }   
            }
            cuentas.setModel(modelo);
            
        } catch (SQLException ex) {
            Logger.getLogger(Ingreso.class.getName()).log(Level.SEVERE, null, ex);
        }
        cuentas.setVisible(true);
        cuentas.getColumn("                          ").setPreferredWidth(200);
        
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dia = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        mes = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        anio = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cuentas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(189, 189, 189));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("VENTA DE REPUESTOS SHALOM");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 20, 850, -1));

        jLabel2.setText("Estado de resultados al");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, -1));

        dia.setText("jLabel3");
        jPanel1.add(dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, -1, -1));

        jLabel3.setText("de");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, -1, -1));

        mes.setText("jLabel4");
        jPanel1.add(mes, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 130, -1));

        jLabel4.setText("de");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, -1, -1));

        anio.setText("jLabel5");
        jPanel1.add(anio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, -1, -1));

        jLabel5.setText("(Cifras en quetzales)");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, 180, -1));

        cuentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(cuentas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 830, 280));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(resultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(resultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(resultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(resultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new resultados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anio;
    private javax.swing.JTable cuentas;
    private javax.swing.JLabel dia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mes;
    // End of variables declaration//GEN-END:variables
}
