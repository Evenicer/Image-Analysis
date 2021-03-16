/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import gui.JFramePrincipal;
import gui.JInternalFrameHistograma;
import gui.JInternalFrameImagen;
import gui.JinternalFrameFiltros;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

/**
 *
 * @author Rogelio Valle
 */
public class HistogramaListener implements ActionListener {
    
    private  JFramePrincipal framePrincipal;
    
    public HistogramaListener(JFramePrincipal framePrincipal) {
        this.framePrincipal = framePrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem item = (JMenuItem)e.getSource();
        if (item.getText().equals("Graficar Histograma")){
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            JInternalFrameHistograma internalNuevo = new JInternalFrameHistograma(internal); 
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
        }
         
    }
    
}
