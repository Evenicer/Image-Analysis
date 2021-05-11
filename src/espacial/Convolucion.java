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
public class Convolucion {

    private int dim;
    private double kernel[][];

    public Image Convolucionar(double kernel[][], int divisor, Image imagen) {
        this.dim = kernel[0].length;
        this.kernel = kernel;
        BufferedImage nueva = new BufferedImage(imagen.getWidth(null), imagen.getHeight(null), BufferedImage.TYPE_INT_RGB);
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagen);

        for (int x = 0; x < imagen.getWidth(null); x++) {
            for (int y = 0; y < imagen.getHeight(null); y++) {
                double muestra[][] = extraerMuestra(x, y, bi);
                //Valido que la muestra si tenga algo
                if (muestra != null) {
                    Color colorRes = convolucion(kernel, muestra, divisor);
                    nueva.setRGB(x, y, colorRes.getRGB());
                } else {
                    nueva.setRGB(x, y, new Color(255, 255, 255).getRGB());
                }
            }
        }
        return herramientas.HerramientasImagen.toImage(nueva);
    }

    public static Color convolucion(double[][] kernel, double[][] muestra, int divisor) {
        int acumuladorR = 0;
        int acumuladorG = 0;
        int acumuladorB = 0;
        Color aux;
        // Recorro el kernel y la muestra
        for (int x = 0; x < kernel[0].length; x++) {
            for (int y = 0; y < kernel[0].length; y++) {
                aux = new Color((int) muestra[x][y]);
                acumuladorR += (kernel[x][y] * aux.getRed());
                acumuladorG += (kernel[x][y] * aux.getGreen());
                acumuladorB += (kernel[x][y] * aux.getBlue());
            }
        }
        acumuladorR = acumuladorR / divisor;
        acumuladorG = acumuladorG / divisor;
        acumuladorB = acumuladorB / divisor;

        return new Color(Validar(acumuladorR), Validar(acumuladorG), Validar(acumuladorB));

    }

    private double[][] extraerMuestra(int x, int y, BufferedImage bi) {
        double matriz[][] = new double[this.kernel[0].length][this.kernel[0].length];
        int AuxX = 0;
        int Auxy = 0;
        try {
            // recorremos la imagen 
            for (int i = x - (this.kernel[0].length - 1) / 2; i <= x + (this.kernel[0].length - 1) / 2; i++) {
                for (int j = y - (this.kernel[0].length - 1) / 2; j <= y + (this.kernel[0].length - 1) / 2; j++) {
                    matriz[AuxX][Auxy] = bi.getRGB(i, j);
                    Auxy++;
                }
                Auxy = 0;
                AuxX++;
            }
            return matriz;
        } catch (Exception e) {
            return null;
        }

    }

    public static int Validar(int valor) {
        if (valor > 255) {
            return 255;
        }
        if (valor < 0) {
            return 0;
        }
        return valor;
    }
    
    //Kirsch
     private Color convolucionarKirsch(double[][] muestra, int divisor) {
        // recorremos las mascaras 
        int mayorR = -1;
        int mayorG = -1;
        int mayorB = -1;
        int r,g,b;
        for(int i=0; i<8;i++){
           Color color = convolucion(MascaraBordes.arregloMascaras[i], muestra, divisor);
           r = color.getRed();
           g = color.getGreen();
           b = color.getBlue();
           if(r>mayorR)mayorR=r;
           if(g>mayorG)mayorG=g;
           if(b>mayorB)mayorB=b;
        
        }
        return new Color(Validar(mayorR),Validar(mayorG), Validar(mayorB));
        
    }
     
      public Image aplicarKirsch(int divisor , Image imagen){
       this.kernel = new double[3][3];
       BufferedImage nueva = new BufferedImage(imagen.getWidth(null), imagen.getHeight(null), BufferedImage.TYPE_INT_RGB);
       BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagen);
       
       //proceso iterativo para generar un imagen nueva
       for(int x=0; x<imagen.getWidth(null);x++){
           for(int y=0; y<imagen.getHeight(null);y++){
           double muestra[][] =extraerMuestra(x,y,bi);
           
            // validar que la muestra se generó 
            if(muestra!=null){
             // proceso evolutivo para Kirsch
            Color colorRes = convolucionarKirsch(muestra,divisor);
            
            nueva.setRGB(x, y, colorRes.getRGB());
            
            }else{
            nueva.setRGB(x, y, new Color(255,255,255).getRGB());
            
            }
                 
           }
       }
       
       return herramientas.HerramientasImagen.toImage(nueva);
    }
    

}
