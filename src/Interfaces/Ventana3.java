/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import javax.swing.JOptionPane;
import pruebagrafo.Diccionario;
import pruebagrafo.Grafo;
import pruebagrafo.NodoNumVertice;
import pruebagrafo.Solucion;

/**
 *
 * @author berna
 */
public class Ventana3 extends javax.swing.JFrame {
    static Grafo grafo;
    static Ventana2 v2;
    static Diccionario diccionario;
    /**
     * Creates new form Ventana3
     */
    public Ventana3(Grafo grafo, Diccionario diccionario) {
        initComponents();
        this.setLocationRelativeTo(null); 
        this.setResizable(true);
        this.grafo = grafo;
        this.tablero.setText(grafo.mostrarGrafo());
        this.v2 = new Ventana2(diccionario, grafo);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablero = new javax.swing.JTextArea();
        buscarNuevaPalabraBFS = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        palabraABuscar = new javax.swing.JTextField();
        tEjec = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        atrás = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablero.setColumns(20);
        tablero.setRows(5);
        jScrollPane1.setViewportView(tablero);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 210, 210));

        buscarNuevaPalabraBFS.setText("Buscar palabra");
        buscarNuevaPalabraBFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarNuevaPalabraBFSActionPerformed(evt);
            }
        });
        jPanel1.add(buscarNuevaPalabraBFS, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, -1, -1));

        jLabel1.setText("Palabra a buscar:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        palabraABuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                palabraABuscarActionPerformed(evt);
            }
        });
        jPanel1.add(palabraABuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 130, -1));

        tEjec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tEjecActionPerformed(evt);
            }
        });
        jPanel1.add(tEjec, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 30, -1));

        jLabel2.setText("ms");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton exit mas pequeno.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 10, -1, 30));

        atrás.setText("Atrás");
        atrás.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrásActionPerformed(evt);
            }
        });
        jPanel1.add(atrás, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarNuevaPalabraBFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarNuevaPalabraBFSActionPerformed
        
         String palabraBuscada = palabraABuscar.getText().toUpperCase();
    
    if (palabraBuscada.length() < 3) {
        JOptionPane.showMessageDialog(this, "La palabra debe tener al menos 3 letras.");
        return;
    }
    
    if (!palabraBuscada.matches("[A-Z]+")) {
        JOptionPane.showMessageDialog(this, "La palabra no puede tener símbolos, espacios, números, o acentos.");
        return;
    }
       
            Solucion solucion = new Solucion(grafo);

            
            //medir el tiempo de inicio
            long startTime = System.currentTimeMillis();
            
            //corre la funcion de busqueda BSF por palabra
            boolean encontrada= solucion.bfs(palabraBuscada,0, grafo);
            
            //medir el tiempo de fin
            long endTime = System.currentTimeMillis();
            //calcular el tiempo de ejecución en milisegundos
            long executionTime = endTime - startTime;
            tEjec.setText(Long.toString(executionTime));
            
            if (encontrada) {
                JOptionPane.showMessageDialog(null, "La palabra \"" + palabraBuscada + "\" ha sido encontrada en el tablero. Tiempo de ejecución: " + executionTime + " ms");
                solucion.mostrarRecorrido(grafo, solucion.getPalabrabfs());
            } else {
                JOptionPane.showMessageDialog(null, "La palabra \"" + palabraBuscada + "\" no ha sido encontrada en el tablero. Tiempo de ejecución: " + executionTime + " ms");
            }
            
            palabraABuscar.setText("");
      
      
    }//GEN-LAST:event_buscarNuevaPalabraBFSActionPerformed

    private void tEjecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tEjecActionPerformed
        
    }//GEN-LAST:event_tEjecActionPerformed

    private void palabraABuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_palabraABuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_palabraABuscarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void atrásActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrásActionPerformed
        // TODO add your handling code here:
        v2.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_atrásActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() { 
            public void run() {
                new Ventana3(grafo, diccionario).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atrás;
    private javax.swing.JButton buscarNuevaPalabraBFS;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField palabraABuscar;
    private javax.swing.JTextField tEjec;
    private javax.swing.JTextArea tablero;
    // End of variables declaration//GEN-END:variables

    private static class campoPalabra {

        private static String getText() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public campoPalabra() {
        }
    }
}
