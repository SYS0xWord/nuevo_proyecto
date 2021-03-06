/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;


/**
 *
 * @author sys515
 */
public class MostrarLotes extends javax.swing.JFrame {
    
    Conexion con = new Conexion();
   
    Connection Consulta = con.conexion();
    /**
     * Creates new form MostrarLotes
     */
    public MostrarLotes(String Marca,String Nombre) {
        initComponents();
        this.setSize(1200, 1000);
        this.Marca.setText(Marca);
        this.Nombre.setText(Nombre);
        this.setDefaultCloseOperation(this.HIDE_ON_CLOSE); 

       
      
          
            DefaultTableModel modeloBusqueda = new DefaultTableModel() {
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return false;
                }
            };
            modeloBusqueda.addColumn("No Lote");
            modeloBusqueda.addColumn("Fecha");
            modeloBusqueda.addColumn("Cantidad");
            modeloBusqueda.addColumn("Costo Unitario");
            modeloBusqueda.addColumn("Costo Total");
            modeloBusqueda.addColumn("Descripcion");
            modeloBusqueda.addColumn("Precio Unitario");
            modeloBusqueda.addColumn("Precio Total");
            modeloBusqueda.addColumn("Proveedor");
            modeloBusqueda.addColumn("Ganancia");
            Lote.setModel(modeloBusqueda);
            
            
           
      
            
            String datos[] = new String[10];

          try {

            Statement sx = Consulta.createStatement();
            ResultSet Ca = sx.executeQuery("SELECT L.NoLote, L.Fecha,L.Cantidad,L.CostoUnitario,L.CostoTotal,L.Descripcion,L.PrecioUnitario,L.PrecioTotal,V.Nombre,L.Ganancia FROM Producto P \n" +
"inner JOIN Lote L \n" +
"on P.id=L.Producto_id \n" +
"inner JOIN FacturaCompra F\n" +
"on L.FacturaCompra_id=F.id\n" +
"inner JOIN Proveedor V \n" +
"on V.id=F.Proveedor_id\n" +
"WHERE P.Marca= '"+Marca+"'&& L.Disponible=true &&P.Nombre='"+Nombre+"' ORDER BY L.Fecha;");
          
            while (Ca.next()) {
               
                datos[0] = Ca.getString(1);
                datos[1] = Ca.getString(2);
                datos[2] = Ca.getString(3);
                datos[3] = Ca.getString(4);
                datos[4] = Ca.getString(5);
                datos[5] = Ca.getString(6);
                datos[6] = Ca.getString(7);
                datos[7] = Ca.getString(8);
                datos[8] = Ca.getString(9);
                datos[9] = Ca.getString(10)+"%";
                modeloBusqueda.addRow(datos);
                
            }
            Lote.setModel(modeloBusqueda);
            
        } catch (SQLException ex) {
            Logger.getLogger(Ingreso.class.getName()).log(Level.SEVERE, null, ex);
        }
        Lote.setVisible(true);
        Lote.getColumn("No Lote").setPreferredWidth(15);
        Lote.getColumn("Fecha").setPreferredWidth(120);
        Lote.getColumn("Cantidad").setPreferredWidth(10);
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
        Nombre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Marca = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Lote = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(17, 111, 172));

        Nombre.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Nombre.setForeground(new java.awt.Color(255, 255, 255));
        Nombre.setText("Nombre");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Producto");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Marca");

        Marca.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Marca.setForeground(new java.awt.Color(255, 255, 255));
        Marca.setText("jLabel4");

        Lote.setModel(new javax.swing.table.DefaultTableModel(
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
        Lote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Lote);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Nombre)
                    .addComponent(Marca))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nombre)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Marca))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_LoteMouseClicked

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
            java.util.logging.Logger.getLogger(MostrarLotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MostrarLotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MostrarLotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MostrarLotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new MostrarLotes("","").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Lote;
    private javax.swing.JLabel Marca;
    private javax.swing.JLabel Nombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
