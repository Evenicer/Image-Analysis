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
}
