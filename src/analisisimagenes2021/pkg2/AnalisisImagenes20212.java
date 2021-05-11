/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisimagenes2021.pkg2;

import espacial.BinarizacionAutomatica;
import espacial.Convolucion;
import espacial.Histograma;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 *
 * @author working
 */
public class AnalisisImagenes20212 {

    /** 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // visualización de la imagen dentro de la GUI
        Image imagen = herramientas.HerramientasImagen.abrirImagen(); 
        // para cuantización de la imagen vamos a un ocupar BufferedImage
        BufferedImage bImagen = herramientas.HerramientasImagen.toBufferedImage(imagen);
        
        double[][] kernel = {{1,2},{3,4},{5,6}};
        Convolucion c = new Convolucion();
        c.Convolucionar(kernel, 3, imagen);
        
        
        
        System.out.println();
    }
    
}
