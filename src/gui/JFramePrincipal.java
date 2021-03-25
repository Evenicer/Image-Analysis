/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.ActionListener;
import listeners.InternalFrameListener;
import listeners.MenuItemsImagenListener;

/**
 *
 * @author working
 */
public class JFramePrincipal extends javax.swing.JFrame {
     
     
    /**
     * Creates new form JFramePrincipa  
     */
    public JFramePrincipal() {
        initComponents();
        MenuItemsImagenListener lis = new MenuItemsImagenListener(this);
        this.jMenuItem1.addActionListener(new InternalFrameListener(this));
        this.jMenuItemModificarPixeles.addActionListener(lis);
        this.jMenuItemNegativo.addActionListener(lis);
        this.jMenuItemRecortar.addActionListener(lis);
        this.jMenuItemHistograma.addActionListener(lis);
        this.jMenuItemBinario.addActionListener(lis);
        this.jMenuItemGrises.addActionListener(lis);
        this.jMenuItemIluminacion.addActionListener(lis);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPanePrincipal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuHistograma = new javax.swing.JMenu();
        jMenuItemModificarPixeles = new javax.swing.JMenuItem();
        jMenuItemRecortar = new javax.swing.JMenuItem();
        jMenuItemHistograma = new javax.swing.JMenuItem();
        jMenuItemGrises = new javax.swing.JMenuItem();
        jMenuItemNegativo = new javax.swing.JMenuItem();
        jMenuItemBinario = new javax.swing.JMenuItem();
        jMenuItemIluminacion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPanePrincipalLayout = new javax.swing.GroupLayout(jDesktopPanePrincipal);
        jDesktopPanePrincipal.setLayout(jDesktopPanePrincipalLayout);
        jDesktopPanePrincipalLayout.setHorizontalGroup(
            jDesktopPanePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1268, Short.MAX_VALUE)
        );
        jDesktopPanePrincipalLayout.setVerticalGroup(
            jDesktopPanePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 728, Short.MAX_VALUE)
        );

        jMenu1.setText("Imagen");

        jMenuItem1.setText("Abrir Imagen");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenuHistograma.setText("Espacial");

        jMenuItemModificarPixeles.setText("Modificar Pixeles");
        jMenuHistograma.add(jMenuItemModificarPixeles);

        jMenuItemRecortar.setText("Recortar Imagen");
        jMenuItemRecortar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRecortarActionPerformed(evt);
            }
        });
        jMenuHistograma.add(jMenuItemRecortar);

        jMenuItemHistograma.setText("Graficar Histograma");
        jMenuItemHistograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemHistogramaActionPerformed(evt);
            }
        });
        jMenuHistograma.add(jMenuItemHistograma);

        jMenuItemGrises.setText("Escala de Grises");
        jMenuItemGrises.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGrisesActionPerformed(evt);
            }
        });
        jMenuHistograma.add(jMenuItemGrises);

        jMenuItemNegativo.setText("Negativo");
        jMenuItemNegativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNegativoActionPerformed(evt);
            }
        });
        jMenuHistograma.add(jMenuItemNegativo);

        jMenuItemBinario.setText("Binario");
        jMenuItemBinario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBinarioActionPerformed(evt);
            }
        });
        jMenuHistograma.add(jMenuItemBinario);

        jMenuItemIluminacion.setText("Iluminacion");
        jMenuItemIluminacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemIluminacionActionPerformed(evt);
            }
        });
        jMenuHistograma.add(jMenuItemIluminacion);

        jMenuBar1.add(jMenuHistograma);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPanePrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPanePrincipal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemRecortarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRecortarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemRecortarActionPerformed

    private void jMenuItemHistogramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemHistogramaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemHistogramaActionPerformed

    private void jMenuItemBinarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBinarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemBinarioActionPerformed

    private void jMenuItemGrisesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGrisesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemGrisesActionPerformed

    private void jMenuItemNegativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNegativoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemNegativoActionPerformed

    private void jMenuItemIluminacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemIluminacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemIluminacionActionPerformed

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
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFramePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPanePrincipal;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuHistograma;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItemBinario;
    private javax.swing.JMenuItem jMenuItemGrises;
    private javax.swing.JMenuItem jMenuItemHistograma;
    private javax.swing.JMenuItem jMenuItemIluminacion;
    private javax.swing.JMenuItem jMenuItemModificarPixeles;
    private javax.swing.JMenuItem jMenuItemNegativo;
    private javax.swing.JMenuItem jMenuItemRecortar;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the jDesktopPanePrincipal
     */
    public javax.swing.JDesktopPane getjDesktopPanePrincipal() {
        return jDesktopPanePrincipal;
    }

    /**
     * @param jDesktopPanePrincipal the jDesktopPanePrincipal to set
     */
    public void setjDesktopPanePrincipal(javax.swing.JDesktopPane jDesktopPanePrincipal) {
        this.jDesktopPanePrincipal = jDesktopPanePrincipal;
    }
}
