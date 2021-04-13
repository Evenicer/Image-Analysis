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
public class Filtros {
    
    public static Image Negativo(Image imagenOriginal) {
        BufferedImage b1 = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);

        for (int i = 0; i < b1.getWidth(); i++) {
            for (int j = 0; j < b1.getHeight(); j++) {
                //Se obtiene el color de la imagen
                Color c = new Color(b1.getRGB(i, j));
                //Se obtienen los valores RGB de la imagen
                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();
                //Se manda la nueva imagen con los colores invertidos
                b1.setRGB(i, j, new Color(255 - r, 255 - g, 255 - b).getRGB());
            }
        }
        return herramientas.HerramientasImagen.toImage(b1);
    }
    
    public static Image EscalaGrises(Image imagenOriginal) {
        BufferedImage b1 = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);
        
        for (int i = 0; i < b1.getWidth(); i++) {
            for (int j = 0; j < b1.getHeight(); j++) {
                //Se obtiene el color de la imagen
                Color c = new Color(b1.getRGB(i, j));
                //Se calcula la media de tonalidades
                int media = (c.getRed() + c.getGreen() + c.getBlue()) / 3;
                //Mando el nuevo color a la imagen
                b1.setRGB(i, j, new Color(media, media, media).getRGB());
            }
        }
        return herramientas.HerramientasImagen.toImage(b1);
    }
    
    public static Image Binario(Image imagenOriginal, int umbral) {
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);
        Color color;

        for (int j = 0; j < bi.getWidth(); j++) {
            for (int m = 0; m < bi.getHeight(); m++) {
                color = new Color(bi.getRGB(j, m));
                //¿ que tenemos que hacer para reducir de 24 a 2? en base a u
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();

                //escala de grises
                int prom = (r + g + b) / 3;

                //Dependiendo del valor del umbral, mando los valores maximo o minimo
                if (prom >= umbral) {
                    bi.setRGB(j, m, Color.BLACK.getRGB());
                } else {
                    bi.setRGB(j, m, Color.WHITE.getRGB());
                }
            }
        }
        return herramientas.HerramientasImagen.toImage(bi);
    }
    
    public static Image Binario(Image imagenOriginal, int umbral , int umbral2) {
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);
        Color color;

        for (int j = 0; j < bi.getWidth(); j++) {
            for (int m = 0; m < bi.getHeight(); m++) {
                color = new Color(bi.getRGB(j, m));
                //¿ que tenemos que hacer para reducir de 24 a 2? en base a u
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();

                //escala de grises
                int prom = (r + g + b) / 3;

                //Dependiendo del valor del umbral, mando los valores maximo o minimo
                if (prom >= umbral && prom <= umbral2) {
                    bi.setRGB(j, m, Color.BLACK.getRGB());
                } else {
                    bi.setRGB(j, m, Color.WHITE.getRGB());
                }
            }
        }
        return herramientas.HerramientasImagen.toImage(bi);
    }
    
    
    public static Image modificarIluminacion(Image imagenOrginal , int valor){ 
        BufferedImage b1 = herramientas.HerramientasImagen.toBufferedImage(imagenOrginal);
        
        for (int i = 0; i < b1.getWidth(); i++) {
            for (int j = 0; j < b1.getHeight(); j++) {
                //Se obtiene el color de la imagen
                Color c = new Color(b1.getRGB(i, j));
                //Se calcula el nuevo color con el valor que se mande
                int r = c.getRed()+valor;
                int g = c.getGreen()+valor;
                int b = c.getBlue()+valor;
                //Se manda el color a la imagen
                c = new Color(verificar(r),verificar(g),verificar(b));
                b1.setRGB(i, j, c.getRGB());
            }
        }
        return herramientas.HerramientasImagen.toImage(b1);
    }
    
    public static int verificar(int valor){
        if(valor > 255) return 255;
        if(valor < 0) return 0;
        return valor;
    }
}
