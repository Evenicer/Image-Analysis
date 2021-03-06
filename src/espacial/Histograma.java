/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espacial;

import herramientas.Grafica;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Rogelio Valle
 */
public class Histograma {
    
    private Image imagenOriginal;
    private double[]r;
    private double[]g;
    private double[]b;
    private double[]grises;

    public Histograma(Image imagen) {
        this.imagenOriginal = imagen;
        this.r = new double[256];
        this.g = new double[256];
        this.b = new double[256];
        this.grises = new double[256];
    }
    public void calcularHistogramas(){
        // recorrer la imagen
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);
        Color color;
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y< bi.getHeight();y++){
                // extraer el color
                color = new Color(bi.getRGB(x, y));
                int r = color.getRed(); // (0-255)
                int g = color.getGreen(); // (0-255)
                int b = color.getBlue(); // (0-255)
                this.r[r]++;
                this.g[g]++;
                this.b[b]++;
                int prom = (color.getRed()+color.getGreen()+color.getBlue())/3;
                this.grises[prom]++;
            }
    }
       
    public void graficar (){
       
        calcularHistogramas();
        Grafica g1 = new Grafica("RGB","Frecuencia","Histograma");
        g1.agregarSerie("RED:", getR());
        g1.agregarSerie("BLUE", getB());
        g1.agregarSerie("GREEN", getG());
        g1.crearGrafica();
        g1.muestraGrafica();
    
    }
    
    public void graficarRed(){
        calcularHistogramas();
        Grafica g1 = new Grafica("RED","Frecuencia","Histograma");
        g1.agregarSerie("RED:", getR());
        g1.crearGrafica();
        g1.muestraGrafica();
    }
    
    public void graficarGreen(){
        calcularHistogramas();
        Grafica g1 = new Grafica("GREEN","Frecuencia","Histograma");
        g1.agrearSerie(" ");
        g1.agrearSerie("");
        g1.agregarSerie("GREEN:", getG());
        g1.crearGrafica();
        g1.muestraGrafica();
    }
    
    public void graficarBlue(){
        calcularHistogramas();
        Grafica g1 = new Grafica("BLUE","Frecuencia","Histograma");
        g1.agrearSerie(" ");
        g1.agregarSerie("BLUE:", getB());
        g1.agrearSerie("");
        g1.crearGrafica();
        g1.muestraGrafica();
    }
    
    public void graficarRedBlue(){
        calcularHistogramas();
        Grafica g1 = new Grafica("RED & BLUE","Frecuencia","Histograma");
        g1.agregarSerie("RED:", getR());
        g1.agregarSerie("Blue", getB());
        g1.crearGrafica();
        g1.muestraGrafica();
    }
    
    public void graficarRedGreen(){
        calcularHistogramas();
        Grafica g1 = new Grafica("RED & GREEN","Frecuencia","Histograma");
        g1.agregarSerie("RED:", getR());
        g1.agrearSerie("");
        g1.agregarSerie("GREEN:", getG());
        g1.crearGrafica();
        g1.muestraGrafica();
    }
    
    public void graficarGreenBlue(){
        calcularHistogramas();
        Grafica g1 = new Grafica("RED & BLUE","Frecuencia","Histograma");
        g1.agrearSerie("");
        g1.agregarSerie("GREEN:", getG());
        g1.agregarSerie("BLUE:", getB());
        g1.crearGrafica();
        g1.muestraGrafica();
    }
    
    

    /**
     * @return the r
     */
    public double[] getR() {
        return r;
    }

    /**
     * @return the g
     */
    public double[] getG() {
        return g;
    }

    /**
     * @return the b
     */
    public double[] getB() {
        return b;
    }
    
    public double[] getGrises() {
        return grises;
    }
    
}
