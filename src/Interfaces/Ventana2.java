/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import pruebagrafo.Diccionario;
import pruebagrafo.Grafo;
import static pruebagrafo.Main.grafo;
import pruebagrafo.Solucion;

/**
 *
 * @author berna
 */
public class Ventana2 extends javax.swing.JFrame {
    static Diccionario dic;
    static Grafo grafo;
    /**
     * Creates new form Ventana2
     */
    public Ventana2(Diccionario dic, Grafo grafo) {
        initComponents();
        this.setLocationRelativeTo(null); 
        this.setResizable(true);
        this.dic = dic;
        this.grafo = grafo;
        diccionario.setText(this.dic.getDiccionario().imprimir_lista());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        diccionario = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        buscarPalabraNuevaBFS = new javax.swing.JButton();
        mostrarTablero = new javax.swing.JButton();
        buscarPalabrasDiccionario = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(730, 490));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setHorizontalScrollBar(null);

        diccionario.setBackground(new java.awt.Color(255, 255, 255));
        diccionario.setColumns(20);
        diccionario.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        diccionario.setRows(5);
        diccionario.setBorder(null);
        diccionario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        diccionario.setFocusable(false);
        jScrollPane1.setViewportView(diccionario);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 140, 160));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/muneco buscar.gif"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, -1, -1));

        buscarPalabraNuevaBFS.setBackground(new java.awt.Color(255, 255, 255));
        buscarPalabraNuevaBFS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar todas las palabras (17).png"))); // NOI18N
        buscarPalabraNuevaBFS.setBorder(null);
        buscarPalabraNuevaBFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPalabraNuevaBFSActionPerformed(evt);
            }
        });
        jPanel1.add(buscarPalabraNuevaBFS, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 180, 40));

        mostrarTablero.setBackground(new java.awt.Color(255, 255, 255));
        mostrarTablero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar todas las palabras (16).png"))); // NOI18N
        mostrarTablero.setBorder(null);
        mostrarTablero.setBorderPainted(false);
        mostrarTablero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarTableroActionPerformed(evt);
            }
        });
        jPanel1.add(mostrarTablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 180, 40));

        buscarPalabrasDiccionario.setBackground(new java.awt.Color(255, 255, 255));
        buscarPalabrasDiccionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar todas las palabras (18).png"))); // NOI18N
        buscarPalabrasDiccionario.setBorder(null);
        buscarPalabrasDiccionario.setBorderPainted(false);
        buscarPalabrasDiccionario.setOpaque(false);
        buscarPalabrasDiccionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPalabrasDiccionarioActionPerformed(evt);
            }
        });
        jPanel1.add(buscarPalabrasDiccionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 200, 40));

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton exit mas pequeno.png"))); // NOI18N
        exit.setBorder(null);
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jPanel1.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar todas las palabras (15).png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ventana v2 fondo.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void mostrarTableroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarTableroActionPerformed
        Solucion sol = new Solucion();
        sol.mostrarGrafo(this.grafo);
        this.setVisible(false);
    }//GEN-LAST:event_mostrarTableroActionPerformed

    private void buscarPalabrasDiccionarioActionPerformed(java.awt.event.ActionEvent evt) {                                                          
        Ventana4 v4 = new Ventana4(grafo,dic);
        v4.setVisible(true);
        this.setVisible(false);
    }                                                         


    private void buscarPalabraNuevaBFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPalabraNuevaBFSActionPerformed
        Ventana3 v3=new Ventana3(grafo, dic);
        v3.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_buscarPalabraNuevaBFSActionPerformed
/*
    private void buscarPalabrasDiccionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPalabrasDiccionarioActionPerformed
               
       
    }//GEN-LAST:event_buscarPalabrasDiccionarioActionPerformed
*/
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
          
            new Ventana2(dic, grafo).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarPalabraNuevaBFS;
    private javax.swing.JButton buscarPalabrasDiccionario;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextArea diccionario;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mostrarTablero;
    // End of variables declaration//GEN-END:variables
}
