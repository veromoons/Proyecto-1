/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import javax.swing.JOptionPane;
import pruebagrafo.Grafo;
import pruebagrafo.Solucion;
import pruebagrafo.Diccionario;
import pruebagrafo.Main;
/**
 *
 * @author verol
 */
public class Ventana4 extends javax.swing.JFrame {
    private Solucion solucion;
    private Grafo grafo;
    private Diccionario diccionario;

    /**
     * Creates new form VentanaInicio
     */
    public Ventana4(Diccionario dic) {
        initComponents();
        this.diccionario = dic;
        this.grafo = grafo;
        this.solucion = new Solucion(grafo); 
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
        busquedaBFS = new javax.swing.JButton();
        busquedaDFS = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablero = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        busquedaBFS.setText("Búsqueda BFS");
        busquedaBFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busquedaBFSActionPerformed(evt);
            }
        });
        jPanel1.add(busquedaBFS, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, -1, -1));

        busquedaDFS.setText("Búsqueda DFS");
        busquedaDFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busquedaDFSActionPerformed(evt);
            }
        });
        jPanel1.add(busquedaDFS, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        tablero.setColumns(20);
        tablero.setRows(5);
        jScrollPane1.setViewportView(tablero);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 210, 150));

        jLabel1.setText("PALABRAS ENCONTRADAS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void busquedaBFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busquedaBFSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_busquedaBFSActionPerformed

    private void busquedaDFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busquedaDFSActionPerformed
        // TODO add your handling code here:
         Solucion solucion = new Solucion(Main.grafo);
   
        solucion.buscarPalabrasValidadasDFS(diccionario);

        String[] palabrasValidadas = solucion.getPalabraValidada();
    
        tablero.setText("");
  
        for (String palabra : palabrasValidadas) {
            tablero.append(palabra + "\n");

    }//GEN-LAST:event_busquedaDFSActionPerformed
}

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
            java.util.logging.Logger.getLogger(Ventana4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            Diccionario dic = new Diccionario();
            
            new Ventana4(dic).setVisible(true);    

}
                
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton busquedaBFS;
    private javax.swing.JButton busquedaDFS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea tablero;
    // End of variables declaration//GEN-END:variables
}
