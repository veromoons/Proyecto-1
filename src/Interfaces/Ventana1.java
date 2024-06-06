/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import leertxt.LeerTxt;
import static pruebagrafo.Main.grafo;

/**
 *
 * @author sofiagrateron
 */

public class Ventana1 extends javax.swing.JFrame {

    /**
     * Creates new form Ventana1
     */
    public Ventana1() {
        initComponents();
        this.setLocationRelativeTo(null); 
        this.setResizable(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        gifClick = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        escogerarchivo = new javax.swing.JButton();
        instrucciones = new javax.swing.JButton();
        fondoV1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, -1, -1));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gifClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/gif click (1).gif"))); // NOI18N
        jPanel4.add(gifClick, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, -1, -1));

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton exit.png"))); // NOI18N
        exit.setBorder(null);
        exit.setBorderPainted(false);
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jPanel4.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, -1, 50));

        escogerarchivo.setBackground(new java.awt.Color(255, 255, 255));
        escogerarchivo.setFont(new java.awt.Font("Eras Medium ITC", 0, 12)); // NOI18N
        escogerarchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ventana 1 boton.png"))); // NOI18N
        escogerarchivo.setText("Cargar archivo");
        escogerarchivo.setBorder(null);
        escogerarchivo.setBorderPainted(false);
        escogerarchivo.setOpaque(false);
        escogerarchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escogerarchivoActionPerformed(evt);
            }
        });
        jPanel4.add(escogerarchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 190, 40));

        instrucciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton instrucciones.png"))); // NOI18N
        instrucciones.setBorder(null);
        instrucciones.setBorderPainted(false);
        instrucciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instruccionesActionPerformed(evt);
            }
        });
        jPanel4.add(instrucciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, 190, 40));

        fondoV1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ventana 1 fondo.png"))); // NOI18N
        jPanel4.add(fondoV1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Metodo para escojer el archivo con la informacion con el JFileChooser
     * @param evt 
     */
    private void escogerarchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escogerarchivoActionPerformed
        // TODO add your handling code here:
        JFileChooser file=new JFileChooser();
        file.showOpenDialog(this);
        File abre =file.getSelectedFile();
        LeerTxt txt = new LeerTxt();
        txt.crearLista(abre);
        txt.crearArray(abre);
        
        
        grafo.crearGrafo(txt.getArray());
        Ventana2 v2 = new Ventana2(txt.getDic(),grafo);
        this.setVisible(false);
        v2.setVisible(true);
        
        //prueba de si se anade bien todo al grafo
//        for (int i = 0; i < 16; i++) {
//            Vertice vertice = nuevoGrafo.getListaVertices()[i];
//            System.out.print("Vertice " + vertice.getNumVertice() + " (" + vertice.getLetra() + "): ");
//            Nodo aux = vertice.getListaAdy().primero();
//            while (aux != null) {                       //iteramos en la lista de adyacentes (en los nodos que contienen aristas que son a su vez el numero del vertice adyacente o destino y la letra del mismo),
//                System.out.print(aux.getInfo().getLetraDestino() + " "); 
//                aux = aux.getNext();
//            }
//            System.out.println();
//        }
    }//GEN-LAST:event_escogerarchivoActionPerformed
    /**
     * Metodo para cerrar el programa
     * @param evt 
     */
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed
    /**
     * Metodo para mostrar las instrucciones del programa
     * @param evt 
     */
    private void instruccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instruccionesActionPerformed
        JOptionPane.showMessageDialog(null, "Bienvenidos a MetroSopa ☺ Para experimentar con la sopa de letras, debes seguir estas instrucciones:️\n\n✅ El programa debe poder leer un archivo de texto en donde las palabras del  diccionario se  encuentran\nseparadas por saltos de línea y encerradas entre las etiquetas “dic” y “/dic” y las 16 letras que conforman\nel tablero 4x4 se encuentran encerradas entre las etiquetas “tab” y “/tab”.\n\nUn desafío tanto para tu mente y como para el código  😈  ¡Crea y juega con MetroSopa! ");

    }//GEN-LAST:event_instruccionesActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton escogerarchivo;
    private javax.swing.JButton exit;
    private javax.swing.JLabel fondoV1;
    private javax.swing.JLabel gifClick;
    private javax.swing.JButton instrucciones;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
