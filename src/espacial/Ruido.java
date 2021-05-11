/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espacial;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 * @author Rogelio Valle
 */
public class Ruido {
    
      public static Image GenerarRuidoPimienta(Image imagenOriginal, int porcentage){
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);
          
        int tp = bi.getHeight()*bi.getWidth();
        int pix=(tp*porcentage)/100;
        Random r= new Random();
        Color c= new Color(0,0,0);
        for(int x=1;x<pix;x++){
            bi.setRGB(r.nextInt(bi.getWidth()),r.nextInt(bi.getHeight()) , c.getRGB());
        }
        return herramientas.HerramientasImagen.toImage(bi);
        
    }
    public static Image GenerarRuidoSal(Image imagenOriginal, int porcentage){
        
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);
        
        int tp = bi.getHeight()*bi.getWidth();
        int pix = (tp*porcentage)/100;
        Random r = new Random();
        Color c = new Color(255,255,255);
        for(int x=1;x<pix;x++){
            bi.setRGB(r.nextInt(bi.getWidth()),r.nextInt(bi.getHeight()) , c.getRGB());
        }
        return herramientas.HerramientasImagen.toImage(bi);
        
    }
    public static Image GenerarRuidoMixto(Image imagenOriginal, int porcentage){
        
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);
        
        int tp=bi.getHeight()*bi.getWidth();
        int pix=(tp*porcentage)/100;
        pix=pix/2;
        Random r= new Random();
        Color c;
        for(int x=1;x<pix;x++){
            c= new Color(0,0,0);
            bi.setRGB(r.nextInt(bi.getWidth()),r.nextInt(bi.getHeight()) , c.getRGB());
            c= new Color(255,255,255);
            bi.setRGB(r.nextInt(bi.getWidth()),r.nextInt(bi.getHeight()) , c.getRGB());
        }        
        return herramientas.HerramientasImagen.toImage(bi);
    }
}
