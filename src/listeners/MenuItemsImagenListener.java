/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import espacial.Filtros;
import gui.JFramePrincipal;
import gui.JInternalFrameBinario;
import gui.JInternalFrameHistograma;
import gui.JInternalFrameIluminacion;
import gui.JInternalFrameImagen;
import gui.JInternalFrameModificar;
import gui.JInternalFrameRecortar;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

/**
 *
 * @author working
 */
public class MenuItemsImagenListener implements ActionListener{
    
     
    private  JFramePrincipal framePrincipal;

    public MenuItemsImagenListener(JFramePrincipal framePrincipal) {
        this.framePrincipal = framePrincipal;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem item = (JMenuItem)e.getSource();
        
        //Modificar pixeles
        if (item.getText().equals("Modificar Pixeles")){
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            JInternalFrameModificar internalNuevo = new JInternalFrameModificar(internal);
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
        }
        
        //Negativo
        if (item.getText().equals("Negativo")){
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            Image i = internal.getImagenOriginal();
            // convertimos a negativo
            Image grises = espacial.Filtros.Negativo(i);
            
            JInternalFrameImagen internalNuevo = new JInternalFrameImagen(grises);
                       
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
        }
        
        //Escala de Grises
        if (item.getText().equals("Escala de Grises")){
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            Image i = internal.getImagenOriginal();
            // convertimos a escala de grises
            Image grises = espacial.Filtros.EscalaGrises(i);
            
            JInternalFrameImagen internalNuevo = new JInternalFrameImagen(grises);
                       
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
        }
        
        //Recortar imagen
        if (item.getText().equals("Recortar Imagen")) {
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            JInternalFrameRecortar internalNuevo = new JInternalFrameRecortar(internal);
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
        }
        
        //Histograma
        if (item.getText().equals("Graficar Histograma")){
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            JInternalFrameHistograma internalNuevo = new JInternalFrameHistograma(internal); 
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
        }
        
        //Binarizacion
        if (item.getText().equals("Binario")) {
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();

            JInternalFrameBinario internalNuevo = new JInternalFrameBinario(internal);

            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
        }
        
        //Iluminacion
        if (item.getText().equals("Iluminacion")) {
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            
            JInternalFrameIluminacion i = new JInternalFrameIluminacion(internal);

            i.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(i);
        }
    }
    
}
