/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espacial;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Rogelio Valle
 */
public class ExpansionesHistograma {
    
    public static Image expansionLineal(int r1, int r2, Image imagenOrginal){

        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagenOrginal);
        Color color;
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int r = (color.getRed()-r1)*(255/r2-r1);
            int g = (color.getGreen()-r1)*(255/r2-r1);
            int b = (color.getBlue()-r1)*(255/r2-r1);
            color = new Color(verificar(r),verificar(g),verificar(b));
            bi.setRGB(x,y,color.getRGB());
        }
        return herramientas.HerramientasImagen.toImage(bi);
    }
     
     public static Image expansionLogaritmica(Image imagenOrginal){

        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagenOrginal);
        Color color;
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int r = (int)((255*Math.log(1+color.getRed()))/(Math.log(1+255)));
            int g = (int)((255*Math.log(1+color.getGreen()))/(Math.log(1+255)));
            int b = (int)((255*Math.log(1+color.getBlue()))/(Math.log(1+255)));
            color = new Color(verificar(r),verificar(g),verificar(b));
            bi.setRGB(x,y,color.getRGB());
        }
        return herramientas.HerramientasImagen.toImage(bi);
    }
     
    public static Image expansionExponencial(Image imagenOrginal , int e){

        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagenOrginal);
        Color color;
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int r = (int)(Math.pow(1+e,color.getRed())/e);
            int g = (int)(Math.pow(1+e,color.getGreen())/e);
            int b = (int)(Math.pow(1+e,color.getBlue())/e);
            color = new Color(verificar(r),verificar(g),verificar(b));
            bi.setRGB(x,y,color.getRGB());
        }
        return herramientas.HerramientasImagen.toImage(bi);
    } 
    
    public static Image ecualizarImagen(Image imagenOrginal){
        int nxm = imagenOrginal.getWidth(null)*imagenOrginal.getHeight(null);
        Histograma h = new Histograma(imagenOrginal);
        h.calcularHistogramas();
        double[] ho = h.getR();
        double[] daf = new double[256];
        int[] nt = new int[256];
        daf[0] = (int)ho[0];
        nt[0] = (int)Math.round((daf[0]/nxm)*255);
        // recorremos el histograma para acumular
        for(int x=1; x<ho.length;x++){
            daf[x] = (int)(ho[x]+daf[x-1]);
            double aux = daf[x]/nxm;
            int tmp = (int) Math.round(aux * 255);
            nt[x] = tmp;
        }

        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagenOrginal);
        Color color;
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int t = color.getRed();
            int t2 = nt[t];
            color = new Color(verificar(t2),verificar(t2),verificar(t2));     
            bi.setRGB(x,y,color.getRGB());
        }
        return herramientas.HerramientasImagen.toImage(bi);
    }
    
    public static int verificar(int valor){
        if(valor > 255) return 255;
        if(valor < 0) return 0;
        return valor;
    }
}
