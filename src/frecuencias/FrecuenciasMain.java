/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frecuencias;

import gui.FFTJFrame;
import herramientas.HerramientasImagen;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Rogelio Valle
 */
public class FrecuenciasMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Image imagen = herramientas.HerramientasImagen.abrirImagen();
//        Image grises = espacial.Espacial.EscalaGrises(imagen);
//        
//        FFTJFrame frame = new FFTJFrame(grises);
//        frame.setTitle("Imagen Original");
//        frame.setVisible(true);
//        
//        BufferedImage bImage = HerramientasImagen.toBufferedImage(grises);
//       
//        Gestor2 gestor = new Gestor2();
//        
//        NumeroComplejo[][] imagenOriginal = gestor.obtenerDatosPorCanal(bImage, HerramientasColor.CanalColor.ROJO);
//        
//        BufferedImage biRes = gestor.obtenerImagenFrecuencias(imagenOriginal, bImage.getWidth(),
//                 bImage.getHeight(), true);
//        
//        Image iRes = herramientas.HerramientasImagen.toImage(biRes);
//        FFTJFrame frame2 = new FFTJFrame(iRes);
//        frame2.setVisible(true);
//        frame2.setTitle("Espectro");
//        
//        // imagenOriginal se le aplica el filtro
//      
//        
//        // despues con imagenOriginal se calcula la fft Inversa
//        BufferedImage res = gestor.obtenerImagenEspacial();
//        Image iRes2 = herramientas.HerramientasImagen.toImage(res);
//        FFTJFrame frame3 = new FFTJFrame(iRes2);
//        frame3.setTitle("Inversa");
//        frame3.setVisible(true);
        
        //Filtro Pasa Bajas
         Image imagen = herramientas.HerramientasImagen.abrirImagen();
         FFTJFrame frame = new FFTJFrame(imagen);
         BufferedImage bImage = HerramientasImagen.toBufferedImage(imagen);
         Gestor gestor = new Gestor(bImage);
         frame.setVisible(true);
         
         BufferedImage iFre = gestor.obtenerImagenFrecuencias(true);
         Image iRes2 = herramientas.HerramientasImagen.toImage(iFre);
         FFTJFrame frame2 = new FFTJFrame(iRes2);
         frame2.setVisible(true);
        
        //Creamos el filtro
//        FiltroIdealPasaBajas FPB = new FiltroIdealPasaBajas(10,new Dimension(256, 256));
//        FPB.crearFiltro();
//        NumeroComplejo [][] filtro = FPB.getFiltroEspacial();
//        FFTJFrame frameFil = new FFTJFrame(FPB.getImagen());
//        gestor.aplicarFiltro(filtro);
//        frameFil.setVisible(true);
        
        BufferedImage res = gestor.obtenerImagenEspacial2();
        Image iRes3 = herramientas.HerramientasImagen.toImage(res);
        FFTJFrame frame3 = new FFTJFrame(iRes3);
        frame3.setTitle("Inversa");
        frame3.setVisible(true);
      
      
       //BufferedImage imagenEspacial = gestor.obtenerImagenEspacial();
       //ImageJFrame frame = new ImageJFrame(ImageManager.toImage(imagenEspacial));
        
    }
    
}
