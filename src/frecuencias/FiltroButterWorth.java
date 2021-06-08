/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frecuencias;

import java.awt.Dimension;
import java.awt.Image;

/**
 *
 * @author Rogelio Valle
 */
public class FiltroButterWorth extends FiltroFrecuencia{
    
    private int orden;
    private int radio;
    private Dimension dim;
    private Image imagen;
    private boolean PasaAltas;
    public FiltroButterWorth(int n, int r, Dimension dim, boolean PasaAltas) {
        super(dim.width,dim.height);
        this.orden = n;
        this.radio = r;
        this.dim = dim;
        this.imagen = null;
        this.PasaAltas = PasaAltas;
    }
    
    @Override
    public void crearFiltro() {
        int tamanoImagen = (int)dim.getWidth();
        int center = (tamanoImagen/2);
        int n2 = 2*orden;
        for(int i=0; i < tamanoImagen;i++){
            for(int j=0; j < tamanoImagen;j++){            
                int u = i-center;
                int v = j-center;
                double Distance = Math.sqrt(Math.pow(u,2)+Math.pow(v, 2));
                double FI;
                 if(!PasaAltas) FI = Math.pow((Distance/radio),2*orden);
                 else FI = Math.pow((radio/Distance),2*orden);
                double valor = 1/Math.sqrt((1+FI));
               
                getFiltroEspacial()[i][j] = new NumeroComplejo(valor,valor);
               
            //double valor = Math.exp(-Math.pow(Distance, 2)/Math.pow(radio, 2));
                     
            }
        }    
        this.imagen = FiltroFrecuencia.toImageDeComplejo(super.getFiltroEspacial());
    }
    public void modificarFiltro(int orden, int radio){
      this.orden = orden;
      this.radio = radio;
      crearFiltro();
    }

    /**
     * @return the imagen
     */
    public Image getImagen() {
        return imagen;
    }
    
}
