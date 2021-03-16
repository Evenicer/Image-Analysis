/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import gui.JFramePrincipal;
import gui.JInternalFrameImagen;
import gui.JInternalFrameRecortar;
import gui.JinternalFrameFiltros;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

/**
 *
 * @author Rogelio Valle
 */
public class FiltrosImagenListener implements ActionListener {
    
    private  JFramePrincipal framePrincipal;
    
    public FiltrosImagenListener(JFramePrincipal framePrincipal) {
        this.framePrincipal = framePrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem item = (JMenuItem)e.getSource();
        if (item.getText().equals("Filtros Imagen")){
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            JinternalFrameFiltros internalNuevo = new JinternalFrameFiltros(internal); 
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
        }
    }
    
}
