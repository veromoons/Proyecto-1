/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;


import pruebagrafo.Grafo;
import pruebagrafo.Solucion;
import pruebagrafo.Diccionario;

/**
 *
 * @author veronicaluna, ruthsenior
 */
public class Ventana4 extends javax.swing.JFrame {
    static Solucion solucion;
    static Grafo grafo;
    static Diccionario diccionario;
    static Ventana2 v2;

    /**
     * Constructor
     */
    public Ventana4(Grafo grafo,Diccionario dic) {
        initComponents();
        palabrasDiccionarioEncontradas.setText("");  
        this.diccionario = dic;
        this.setLocationRelativeTo(null); 
        this.grafo = grafo;
        this.solucion = new Solucion(); 
        this.v2 = new Ventana2(diccionario, grafo);
        tEjecucion.setText("");
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
        palabrasDiccionarioEncontradas = new javax.swing.JTextArea();
        atras = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        tEjecucion = new javax.swing.JTextField();
        miliseg = new javax.swing.JLabel();
        tiempoRecorrTitulo = new javax.swing.JLabel();
        decoracionBarraRosa = new javax.swing.JLabel();
        introduccionV4 = new javax.swing.JLabel();
        fondoV4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        busquedaBFS.setBackground(new java.awt.Color(255, 255, 255));
        busquedaBFS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ventana 4 boton 1.png"))); // NOI18N
        busquedaBFS.setBorder(null);
        busquedaBFS.setBorderPainted(false);
        busquedaBFS.setOpaque(false);
        busquedaBFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busquedaBFSActionPerformed(evt);
            }
        });
        jPanel1.add(busquedaBFS, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 130, 30));

        busquedaDFS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ventana 4 boton 2.png"))); // NOI18N
        busquedaDFS.setBorder(null);
        busquedaDFS.setBorderPainted(false);
        busquedaDFS.setOpaque(false);
        busquedaDFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busquedaDFSActionPerformed(evt);
            }
        });
        jPanel1.add(busquedaDFS, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 130, 30));

        jScrollPane1.setHorizontalScrollBar(null);

        palabrasDiccionarioEncontradas.setBackground(new java.awt.Color(255, 255, 255));
        palabrasDiccionarioEncontradas.setColumns(20);
        palabrasDiccionarioEncontradas.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        palabrasDiccionarioEncontradas.setRows(5);
        palabrasDiccionarioEncontradas.setFocusable(false);
        jScrollPane1.setViewportView(palabrasDiccionarioEncontradas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 150, 150));

        atras.setBackground(new java.awt.Color(255, 255, 255));
        atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras boton.png"))); // NOI18N
        atras.setBorder(null);
        atras.setBorderPainted(false);
        atras.setOpaque(false);
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });
        jPanel1.add(atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 50, 20));

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton exit mas pequeno.png"))); // NOI18N
        exit.setBorder(null);
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jPanel1.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(374, 0, 20, 20));

        tEjecucion.setBackground(new java.awt.Color(255, 255, 255));
        tEjecucion.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        tEjecucion.setFocusable(false);
        jPanel1.add(tEjecucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 50, -1));

        miliseg.setForeground(new java.awt.Color(0, 0, 0));
        miliseg.setText("ms");
        jPanel1.add(miliseg, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, -1, -1));

        tiempoRecorrTitulo.setForeground(new java.awt.Color(0, 0, 0));
        tiempoRecorrTitulo.setText("Tiempo de recorrido:");
        jPanel1.add(tiempoRecorrTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, -1, -1));

        decoracionBarraRosa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ventana 3 fondo (11).png"))); // NOI18N
        jPanel1.add(decoracionBarraRosa, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 0, 470, -1));

        introduccionV4.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        introduccionV4.setForeground(new java.awt.Color(51, 51, 51));
        introduccionV4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        introduccionV4.setText("<html>Puede  elegir  entre  dos  tipos  de  búsquedas  (DFS  y  BFS)   y  <br>se mostrarán aquellas palabras encontradas del diccionario<br>proporcionado en el TXT ingresado</html>");
        jPanel1.add(introduccionV4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        fondoV4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ventana 3 fondo (10).png"))); // NOI18N
        jPanel1.add(fondoV4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 400, 310));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents
                                         
    /**
     * Metodo para busqueda DFS
     * @author veronicaluna
     * @param evt 
     */
    private void busquedaBFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busquedaBFSActionPerformed

        Solucion soluc=new Solucion();
        
        //aqui mide el tiempo de inicio
        long startTime = System.currentTimeMillis();
        
        //aqui es donde corre la funcion de busqueda BFS para cada palabra del diccionario
        palabrasDiccionarioEncontradas.setText("Palabras encontradas \ncon BFS: \n" +soluc.busquedaDiccionarioBFS(this.diccionario.getDiccionario(),this.grafo));
        
        //se mide el tiempo de fin
        long endTime = System.currentTimeMillis();
        //calculo en miliseg
        long executionTime = endTime - startTime;
        
        tEjecucion.setText(Long.toString(executionTime));
        
    }//GEN-LAST:event_busquedaBFSActionPerformed
    /**
     * Metodo para llamar a la funcion de busqueda DFS de todas las palabras y mostrar el resultado
     * @param evt 
     */
    private void busquedaDFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busquedaDFSActionPerformed
        
        Solucion soluc2=new Solucion();
        //aqui mide el tiempo de inicio
        long startTime = System.currentTimeMillis();
        
        //aqui es donde corre la funcion de busqueda DFS para cada palabra del diccionario
        palabrasDiccionarioEncontradas.setText("Palabras encontradas \ncon DFS: \n" +soluc2.busquedaDiccionarioDFS(this.diccionario.getDiccionario(),this.grafo));
        
        //se mide el tiempo de fin
        long endTime = System.currentTimeMillis();
        //calculo en miliseg
        long executionTime = endTime - startTime;
        
        tEjecucion.setText(Long.toString(executionTime));
        
    }//GEN-LAST:event_busquedaDFSActionPerformed

    /**
     * Metodo para regresar a la ventana anterior
     * @param evt 
     */
    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        v2.setVisible(true);
    }//GEN-LAST:event_atrasActionPerformed
    /**
     * Metodo para cerrar el programa
     * @param evt 
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
            
            new Ventana4(grafo,dic).setVisible(true);    

}
                
            
        });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atras;
    private javax.swing.JButton busquedaBFS;
    private javax.swing.JButton busquedaDFS;
    private javax.swing.JLabel decoracionBarraRosa;
    private javax.swing.JButton exit;
    private javax.swing.JLabel fondoV4;
    private javax.swing.JLabel introduccionV4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel miliseg;
    private javax.swing.JTextArea palabrasDiccionarioEncontradas;
    private javax.swing.JTextField tEjecucion;
    private javax.swing.JLabel tiempoRecorrTitulo;
    // End of variables declaration//GEN-END:variables
}
