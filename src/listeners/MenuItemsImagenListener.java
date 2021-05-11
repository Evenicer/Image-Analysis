/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import espacial.BinarizacionAutomatica;
import espacial.Convolucion;
import espacial.Espacial;
import espacial.Histograma;
import gui.JFramePrincipal;
import gui.JInternalFrameBinario;
import gui.JInternalFrameBinario2;
import gui.JInternalFrameConvolucion;
import gui.JInternalFrameExpansiones;
import gui.JInternalFrameHistograma;
import gui.JInternalFrameIluminacion;
import gui.JInternalFrameImagen;
import gui.JInternalFrameModificar;
import gui.JInternalFrameRecortar;
import gui.JInternalFrameRuido;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

/**
 *
 * @author working
 */
public class MenuItemsImagenListener implements ActionListener{
    
     
    public static  JFramePrincipal framePrincipal;

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
            Image grises = espacial.Espacial.Negativo(i);
            
            JInternalFrameImagen internalNuevo = new JInternalFrameImagen(grises);
                       
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
        }
        
        //Escala de Grises
        if (item.getText().equals("Escala de Grises")){
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            Image i = internal.getImagenOriginal();
            // convertimos a escala de grises
            Image grises = espacial.Espacial.EscalaGrises(i);
            
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
        
        //Histograma
        if (item.getText().equals("Graficar Histograma2")){
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            JInternalFrameHistograma internalNuevo = new JInternalFrameHistograma(internal); 
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
            System.out.println("HOLA");
        }
        
        //Binarizacion
        if (item.getText().equals("Binario")) {
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();

            JInternalFrameBinario internalNuevo = new JInternalFrameBinario(internal);

            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
        }
        
        //Binarizacion con 2 umbrales
        if (item.getText().equals("Binario 2 umbrales")) {
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();

            JInternalFrameBinario2 internalNuevo = new JInternalFrameBinario2(internal);

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
        
        //Binarizacion Automatica Metodo Iterativo
        if (item.getText().equals("Binario Automatico")) {
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            Image i = internal.getImagenOriginal();
            // convertimos a escala de grises
            Image grises = espacial.Espacial.EscalaGrises(i);
            Histograma h = new Histograma(grises); 
            h.calcularHistogramas();
            int u = BinarizacionAutomatica.metodoIterativo(h.getGrises());
            Image binario = espacial.Espacial.Binario(grises, u);
            System.out.println(u);
            JInternalFrameImagen internalNuevo = new JInternalFrameImagen(binario);
                       
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
        }
        
        //Binarizacion Automatica OTZU
        if (item.getText().equals("Binarizacion OTZU")) {
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            Image i = internal.getImagenOriginal();
            // convertimos a escala de grises
            Image grises = espacial.Espacial.EscalaGrises(i);
            Histograma h = new Histograma(grises); 
            h.calcularHistogramas();
            double u = BinarizacionAutomatica.Otsu(h.getGrises());
            Image binario = espacial.Espacial.Binario(grises, (int)u);
            System.out.println(u);
            JInternalFrameImagen internalNuevo = new JInternalFrameImagen(binario);
                       
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
        }
        
        //Convolucion
        if (item.getText().equals("Convolucion")){
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            JInternalFrameConvolucion internalNuevo = new JInternalFrameConvolucion(internal);
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
        }
        
        //Expanciones
        if (item.getText().equals("Expansiones")){
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            JInternalFrameExpansiones internalNuevo = new JInternalFrameExpansiones(internal);
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
        }
        
        //Ruido
        if (item.getText().equals("Ruido")){
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            JInternalFrameRuido internalNuevo = new JInternalFrameRuido(internal);
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
        }
        
    }
    
}
