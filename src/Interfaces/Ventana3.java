/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import javax.swing.JOptionPane;
import pruebagrafo.Diccionario;
import pruebagrafo.Grafo;
import pruebagrafo.Solucion;

/**
 *
 * @author sofiagrateron, veronicaluna
 */
public class Ventana3 extends javax.swing.JFrame {
    static Grafo grafo;
    static Ventana2 v2;
    static Diccionario diccionario;
    /**
     * Constructor
     */
    public Ventana3(Grafo grafo, Diccionario diccionario) {
        initComponents();
        this.setLocationRelativeTo(null); 
        this.setResizable(true);
        this.grafo = grafo;
        this.tablero.setText(grafo.mostrarGrafoTablero());
        this.v2 = new Ventana2(diccionario, grafo);
        tEjec.setText("");
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
        palabraABuscar = new javax.swing.JTextField();
        tEjec = new javax.swing.JTextField();
        milisegs = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        atrás = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        tRecorridoTitulo = new javax.swing.JLabel();
        palabraBuscarTitulo = new javax.swing.JLabel();
        barraDecoracionRosada = new javax.swing.JLabel();
        introd1V3 = new javax.swing.JLabel();
        introd2V3 = new javax.swing.JLabel();
        introd3V3 = new javax.swing.JLabel();
        fondoV3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setHorizontalScrollBar(null);

        tablero.setBackground(new java.awt.Color(255, 255, 255));
        tablero.setColumns(20);
        tablero.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        tablero.setRows(5);
        tablero.setTabSize(12);
        tablero.setBorder(null);
        tablero.setFocusable(false);
        jScrollPane1.setViewportView(tablero);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 150, 180));

        buscarNuevaPalabraBFS.setBackground(new java.awt.Color(255, 255, 255));
        buscarNuevaPalabraBFS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ventana 3 fondo (7).png"))); // NOI18N
        buscarNuevaPalabraBFS.setBorder(null);
        buscarNuevaPalabraBFS.setBorderPainted(false);
        buscarNuevaPalabraBFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarNuevaPalabraBFSActionPerformed(evt);
            }
        });
        jPanel1.add(buscarNuevaPalabraBFS, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 130, 40));

        palabraABuscar.setBackground(new java.awt.Color(255, 255, 255));
        palabraABuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                palabraABuscarActionPerformed(evt);
            }
        });
        jPanel1.add(palabraABuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 130, 30));

        tEjec.setBackground(new java.awt.Color(255, 255, 255));
        tEjec.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tEjec.setFocusable(false);
        tEjec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tEjecActionPerformed(evt);
            }
        });
        jPanel1.add(tEjec, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 50, 30));

        milisegs.setForeground(new java.awt.Color(0, 0, 0));
        milisegs.setText("ms");
        jPanel1.add(milisegs, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton exit mas pequeno.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 0, 20, 20));

        atrás.setBackground(new java.awt.Color(255, 255, 255));
        atrás.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras boton.png"))); // NOI18N
        atrás.setBorder(null);
        atrás.setBorderPainted(false);
        atrás.setOpaque(false);
        atrás.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrásActionPerformed(evt);
            }
        });
        jPanel1.add(atrás, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 50, 20));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ventana 3 fondo (8).png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setOpaque(false);
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 130, 40));

        tRecorridoTitulo.setForeground(new java.awt.Color(0, 0, 0));
        tRecorridoTitulo.setText("Tiempo de recorrido:");
        jPanel1.add(tRecorridoTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, -1, -1));

        palabraBuscarTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ventana 3 fondo (3).png"))); // NOI18N
        jPanel1.add(palabraBuscarTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 150, 30));

        barraDecoracionRosada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ventana 3 fondo (11).png"))); // NOI18N
        jPanel1.add(barraDecoracionRosada, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 0, -1, -1));

        introd1V3.setForeground(new java.awt.Color(51, 51, 51));
        introd1V3.setText("Introduzca una palabra que desee buscar ");
        jPanel1.add(introd1V3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, 20));

        introd2V3.setForeground(new java.awt.Color(51, 51, 51));
        introd2V3.setText("De ser una palabra nueva, tiene la opción de guardarla en el TXT");
        jPanel1.add(introd2V3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, 20));

        introd3V3.setForeground(new java.awt.Color(51, 51, 51));
        introd3V3.setText("*Debe tener más de 3 letras, no incluir acentos, números o símbolos ");
        jPanel1.add(introd3V3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 20));

        fondoV3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ventana 3 fondo (10).png"))); // NOI18N
        jPanel1.add(fondoV3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Metodo para buscar palabra por BFS
     * 
     * @param evt 
     */
    private void buscarNuevaPalabraBFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarNuevaPalabraBFSActionPerformed
        
        String palabraBuscada = palabraABuscar.getText().toUpperCase().strip();
    
        if (palabraBuscada.length() ==0 || palabraBuscada=="") {
            JOptionPane.showMessageDialog(null, "Por favor, introduzca una palabra.");
            return;
        }
        
        if (!palabraBuscada.matches("[A-Z]+")) {
            JOptionPane.showMessageDialog(null, "❗ " +"La palabra no puede incluir símbolos, espacios, números o acentos.\nIntente de nuevo.");
            return;
        }
    
        if (palabraBuscada.length() >=1 && palabraBuscada.length()< 3) {
            JOptionPane.showMessageDialog(null,"❗ "+ "La palabra debe tener al menos 3 letras.\nIntente de nuevo.");
            return;
        }
       
        Solucion solucion = new Solucion();

        //aqui mide el tiempo de inicio
        long startTime = System.currentTimeMillis();

        //aqui es dondr corre la funcion de busqueda BSF por palabra
        boolean encontrada= solucion.bfs(palabraBuscada,0, grafo);

        //se mide el tiempo de fin
        long endTime = System.currentTimeMillis();
        //calculo en miliseg
        long executionTime = endTime - startTime;
        tEjec.setText(Long.toString(executionTime));

        if (encontrada) {
            JOptionPane.showMessageDialog(null, "La palabra indicada \"" + palabraBuscada + "\" se encontró en la sopa de letras.");
            solucion.mostrarRecorrido(grafo, solucion.getPalabrabfs());
        } else {
            JOptionPane.showMessageDialog(null, "La palabra indicada \"" + palabraBuscada + "\" no se encuentra en la sopa de letras.");
        }

        palabraABuscar.setText("");
        tEjec.setText("");
    }//GEN-LAST:event_buscarNuevaPalabraBFSActionPerformed

    private void tEjecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tEjecActionPerformed
        
    }//GEN-LAST:event_tEjecActionPerformed

    private void palabraABuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_palabraABuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_palabraABuscarActionPerformed
    /**
     * Metodo para cerrar la ventana 3
     * @param evt 
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed
    /**
     * Metodo para volver a la ventana anterior
     * @param evt 
     */
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
    private javax.swing.JLabel barraDecoracionRosada;
    private javax.swing.JButton buscarNuevaPalabraBFS;
    private javax.swing.JLabel fondoV3;
    private javax.swing.JLabel introd1V3;
    private javax.swing.JLabel introd2V3;
    private javax.swing.JLabel introd3V3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel milisegs;
    private javax.swing.JTextField palabraABuscar;
    private javax.swing.JLabel palabraBuscarTitulo;
    private javax.swing.JTextField tEjec;
    private javax.swing.JLabel tRecorridoTitulo;
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
