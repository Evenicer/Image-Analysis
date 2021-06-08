/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import frecuencias.FiltroButterWorth;
import frecuencias.FiltroGaussiano;
import frecuencias.FiltroIdealPasaAltas;
import frecuencias.FiltroIdealPasaBajas;
import frecuencias.Gestor;
import frecuencias.HerramientasColor;
import frecuencias.NumeroComplejo;
import herramientas.HerramientasImagen;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import listeners.MenuItemsImagenListener;

/**
 *
 * @author Rogelio Valle
 */
public class JInternalFrameFrecuencias extends javax.swing.JInternalFrame {

    /**
     * Creates new form JInternalFrameFrecuencias
     */
    
    private JInternalFrameImagen internal;
    
    public JInternalFrameFrecuencias(JInternalFrameImagen internal) {
        this.internal = internal;
        initComponents();
        
        this.jButtonFrecuencia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Image imagen = internal.getImagenOriginal();
                Image grises = espacial.Espacial.EscalaGrises(imagen);
                BufferedImage bImage = HerramientasImagen.toBufferedImage(grises);
                Gestor gestor = new Gestor();
                Gestor gestor2 = new Gestor(bImage);
                
                if(jRadioButtonRojo.isSelected() == false && jRadioButtonVerde.isSelected() == false && jRadioButtonAzul.isSelected() == false ){
                
                 BufferedImage iFre = gestor2.obtenerImagenFrecuencias(true);
                 Image iRes3 = herramientas.HerramientasImagen.toImage(iFre);
                
                JInternalFrameImagen internalNuevo3 = new JInternalFrameImagen(iRes3);
                internalNuevo3.setVisible(true);
                MenuItemsImagenListener.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo3);
                
                BufferedImage res4 = gestor2.obtenerImagenEspacial2();
                Image iRes4 = herramientas.HerramientasImagen.toImage(res4);
                
                JInternalFrameImagen internalNuevo4 = new JInternalFrameImagen(iRes4);
                internalNuevo4.setVisible(true);
                MenuItemsImagenListener.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo4);
                }
                

                if(jRadioButtonRojo.isSelected() == true){
                    NumeroComplejo[][] imagenOriginal = gestor.obtenerDatosPorCanal(bImage, HerramientasColor.CanalColor.ROJO);
                    BufferedImage biRes = gestor.obtenerImagenFrecuencias(imagenOriginal, bImage.getWidth(),bImage.getHeight(), true , HerramientasColor.CanalColor.ROJO);
                    Image iRes = herramientas.HerramientasImagen.toImage(biRes);
                    JInternalFrameImagen internalNuevo = new JInternalFrameImagen(iRes);
                    internalNuevo.setVisible(true);
                    MenuItemsImagenListener.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
                    
                    BufferedImage res = gestor.obtenerImagenEspacial(HerramientasColor.CanalColor.ROJO);
                    Image iRes2 = herramientas.HerramientasImagen.toImage(res);
                    JInternalFrameImagen internalNuevo2 = new JInternalFrameImagen(iRes2);
                    internalNuevo2.setVisible(true);
                    MenuItemsImagenListener.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo2);
                    
                }else if(jRadioButtonVerde.isSelected() == true){
                    NumeroComplejo[][] imagenOriginal = gestor.obtenerDatosPorCanal(bImage, HerramientasColor.CanalColor.VERDE);
                    BufferedImage biRes = gestor.obtenerImagenFrecuencias(imagenOriginal, bImage.getWidth(),bImage.getHeight(), true , HerramientasColor.CanalColor.VERDE);
                    Image iRes = herramientas.HerramientasImagen.toImage(biRes);
                    JInternalFrameImagen internalNuevo = new JInternalFrameImagen(iRes);
                    internalNuevo.setVisible(true);
                    MenuItemsImagenListener.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
                    
                    BufferedImage res = gestor.obtenerImagenEspacial(HerramientasColor.CanalColor.VERDE);
                    Image iRes2 = herramientas.HerramientasImagen.toImage(res);
                    JInternalFrameImagen internalNuevo2 = new JInternalFrameImagen(iRes2);
                    internalNuevo2.setVisible(true);
                    MenuItemsImagenListener.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo2);
                   
                    
                }else if(jRadioButtonAzul.isSelected() == true){
                    NumeroComplejo[][] imagenOriginal = gestor.obtenerDatosPorCanal(bImage, HerramientasColor.CanalColor.AZUL);
                    BufferedImage biRes = gestor.obtenerImagenFrecuencias(imagenOriginal, bImage.getWidth(),bImage.getHeight(), true, HerramientasColor.CanalColor.AZUL);
                    Image iRes = herramientas.HerramientasImagen.toImage(biRes);
                    JInternalFrameImagen internalNuevo = new JInternalFrameImagen(iRes);
                    internalNuevo.setVisible(true);
                    MenuItemsImagenListener.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
                    
                    BufferedImage res = gestor.obtenerImagenEspacial(HerramientasColor.CanalColor.AZUL);
                    Image iRes2 = herramientas.HerramientasImagen.toImage(res);
                    JInternalFrameImagen internalNuevo2 = new JInternalFrameImagen(iRes2);
                    internalNuevo2.setVisible(true);
                    MenuItemsImagenListener.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo2);
                    
                }
                jRadioButtonAzul.setSelected(false);
                jRadioButtonVerde.setSelected(false);
                jRadioButtonRojo.setSelected(false);
            }
        });
        
        
        this.jButtonFIPB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int radio = Integer.parseInt(jTextFieldRadio.getText());
                
                Image imagen = internal.getImagenOriginal();
                BufferedImage bImage = HerramientasImagen.toBufferedImage(imagen);
                Gestor gestor = new Gestor(bImage);
                
                //Frecuencias
                BufferedImage iFre = gestor.obtenerImagenFrecuencias(true);
                Image iRes = herramientas.HerramientasImagen.toImage(iFre);
                JInternalFrameImagen internalNuevo = new JInternalFrameImagen(iRes);
                internalNuevo.setVisible(true);
                MenuItemsImagenListener.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
                
                //Creamos el filtro
                FiltroIdealPasaBajas FPB = new FiltroIdealPasaBajas(radio, new Dimension(256, 256));
                FPB.crearFiltro();
                NumeroComplejo[][] filtro = FPB.getFiltroEspacial();
                JInternalFrameImagen internalNuevo2 = new JInternalFrameImagen(FPB.getImagen());
                gestor.aplicarFiltro(filtro);
                internalNuevo2.setVisible(true);
                MenuItemsImagenListener.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo2);
            }
        });
        
        this.jButtonFIPA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int radio = Integer.parseInt(jTextFieldRadio.getText());
                Image imagen = internal.getImagenOriginal();
                BufferedImage bImage = HerramientasImagen.toBufferedImage(imagen);
                Gestor gestor = new Gestor(bImage);
                
                //Frecuencias
                BufferedImage iFre = gestor.obtenerImagenFrecuencias(true);
                Image iRes = herramientas.HerramientasImagen.toImage(iFre);
                JInternalFrameImagen internalNuevo = new JInternalFrameImagen(iRes);
                internalNuevo.setVisible(true);
                MenuItemsImagenListener.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
                
                //Creamos el filtro
                FiltroIdealPasaAltas FPA = new FiltroIdealPasaAltas(radio, new Dimension(256, 256));
                FPA.crearFiltro();
                NumeroComplejo[][] filtro = FPA.getFiltroEspacial();
                JInternalFrameImagen internalNuevo2 = new JInternalFrameImagen(FPA.getImagen());
                gestor.aplicarFiltro(filtro);
                internalNuevo2.setVisible(true);
                MenuItemsImagenListener.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo2);
            }
        });
        
        this.jButtonFBPA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int radio = Integer.parseInt(jTextFieldRadio.getText());
                Image imagen = internal.getImagenOriginal();
                BufferedImage bImage = HerramientasImagen.toBufferedImage(imagen);
                Gestor gestor = new Gestor(bImage);
                
                //Frecuencias
                BufferedImage iFre = gestor.obtenerImagenFrecuencias(true);
                Image iRes = herramientas.HerramientasImagen.toImage(iFre);
                JInternalFrameImagen internalNuevo = new JInternalFrameImagen(iRes);
                internalNuevo.setVisible(true);
                MenuItemsImagenListener.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
                
                //Creamos el filtro
                FiltroButterWorth FBPA = new FiltroButterWorth(100,radio,new Dimension(256, 256),true);
                FBPA.crearFiltro();
                NumeroComplejo[][] filtro = FBPA.getFiltroEspacial();
                JInternalFrameImagen internalNuevo2 = new JInternalFrameImagen(FBPA.getImagen());
                gestor.aplicarFiltro(filtro);
                internalNuevo2.setVisible(true);
                MenuItemsImagenListener.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo2);
            }
        });
        
        this.jButtonFBPB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int radio = Integer.parseInt(jTextFieldRadio.getText());
                Image imagen = internal.getImagenOriginal();
                BufferedImage bImage = HerramientasImagen.toBufferedImage(imagen);
                Gestor gestor = new Gestor(bImage);
                
                //Frecuencias
                BufferedImage iFre = gestor.obtenerImagenFrecuencias(true);
                Image iRes = herramientas.HerramientasImagen.toImage(iFre);
                JInternalFrameImagen internalNuevo = new JInternalFrameImagen(iRes);
                internalNuevo.setVisible(true);
                MenuItemsImagenListener.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
                
                //Creamos el filtro
                FiltroButterWorth FBPB = new FiltroButterWorth(10,radio,new Dimension(256, 256),false);
                FBPB.crearFiltro();
                NumeroComplejo[][] filtro = FBPB.getFiltroEspacial();
                JInternalFrameImagen internalNuevo2 = new JInternalFrameImagen(FBPB.getImagen());
                gestor.aplicarFiltro(filtro);
                internalNuevo2.setVisible(true);
                MenuItemsImagenListener.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo2);
            }
        });
        
        this.jButtonFGPA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int radio = Integer.parseInt(jTextFieldRadio.getText());
                Image imagen = internal.getImagenOriginal();
                BufferedImage bImage = HerramientasImagen.toBufferedImage(imagen);
                Gestor gestor = new Gestor(bImage);
                
                //Frecuencias
                BufferedImage iFre = gestor.obtenerImagenFrecuencias(true);
                Image iRes = herramientas.HerramientasImagen.toImage(iFre);
                JInternalFrameImagen internalNuevo = new JInternalFrameImagen(iRes);
                internalNuevo.setVisible(true);
                MenuItemsImagenListener.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
                
                //Creamos el filtro
                FiltroGaussiano FGPA = new FiltroGaussiano(radio,new Dimension(256, 256),true);
                FGPA.crearFiltro();
                NumeroComplejo[][] filtro = FGPA.getFiltroEspacial();
                JInternalFrameImagen internalNuevo2 = new JInternalFrameImagen(FGPA.getImagen());
                gestor.aplicarFiltro(filtro);
                internalNuevo2.setVisible(true);
                MenuItemsImagenListener.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo2);
            }
        });
        
        this.jButtonFGPB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int radio = Integer.parseInt(jTextFieldRadio.getText());
                Image imagen = internal.getImagenOriginal();
                BufferedImage bImage = HerramientasImagen.toBufferedImage(imagen);
                Gestor gestor = new Gestor(bImage);
                
                //Frecuencias
                BufferedImage iFre = gestor.obtenerImagenFrecuencias(true);
                Image iRes = herramientas.HerramientasImagen.toImage(iFre);
                JInternalFrameImagen internalNuevo = new JInternalFrameImagen(iRes);
                internalNuevo.setVisible(true);
                MenuItemsImagenListener.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
                
                //Creamos el filtro
                FiltroGaussiano FGPA = new FiltroGaussiano(radio,new Dimension(256, 256),false);
                FGPA.crearFiltro();
                NumeroComplejo[][] filtro = FGPA.getFiltroEspacial();
                JInternalFrameImagen internalNuevo2 = new JInternalFrameImagen(FGPA.getImagen());
                gestor.aplicarFiltro(filtro);
                internalNuevo2.setVisible(true);
                MenuItemsImagenListener.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo2);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonFrecuencia = new javax.swing.JButton();
        jRadioButtonRojo = new javax.swing.JRadioButton();
        jRadioButtonVerde = new javax.swing.JRadioButton();
        jRadioButtonAzul = new javax.swing.JRadioButton();
        jButtonFIPB = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonFIPA = new javax.swing.JButton();
        jButtonFBPA = new javax.swing.JButton();
        jButtonFBPB = new javax.swing.JButton();
        jButtonFGPA = new javax.swing.JButton();
        jButtonFGPB = new javax.swing.JButton();
        jTextFieldRadio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

        jButtonFrecuencia.setText("Aplicar FFT");

        jRadioButtonRojo.setText("Rojo");

        jRadioButtonVerde.setText("Verde");

        jRadioButtonAzul.setText("Azul");

        jButtonFIPB.setText("Filtro Ideal Pasa-Bajas");

        jLabel1.setText("FILTROS:");

        jButtonFIPA.setText("Filtro Ideal Pasa-Altas");

        jButtonFBPA.setText("Butterworth Pasa-Altas");

        jButtonFBPB.setText("Butterworth Pasa-Bajas");

        jButtonFGPA.setText("Gaussiano Pasa-Altas");

        jButtonFGPB.setText("Gaussiano Pasa-Bajas");

        jLabel2.setText("Radio:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonFIPB, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButtonRojo)
                                    .addComponent(jRadioButtonVerde))
                                .addGap(30, 30, 30)
                                .addComponent(jButtonFrecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jRadioButtonAzul)
                            .addComponent(jButtonFIPA, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonFBPA, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonFBPB, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonFGPA, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonFGPB, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jTextFieldRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jRadioButtonRojo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFrecuencia)
                    .addComponent(jRadioButtonVerde))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonAzul)
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jTextFieldRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonFIPB)
                .addGap(18, 18, 18)
                .addComponent(jButtonFIPA)
                .addGap(18, 18, 18)
                .addComponent(jButtonFBPA)
                .addGap(18, 18, 18)
                .addComponent(jButtonFBPB)
                .addGap(18, 18, 18)
                .addComponent(jButtonFGPA)
                .addGap(18, 18, 18)
                .addComponent(jButtonFGPB)
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFBPA;
    private javax.swing.JButton jButtonFBPB;
    private javax.swing.JButton jButtonFGPA;
    private javax.swing.JButton jButtonFGPB;
    private javax.swing.JButton jButtonFIPA;
    private javax.swing.JButton jButtonFIPB;
    private javax.swing.JButton jButtonFrecuencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jRadioButtonAzul;
    private javax.swing.JRadioButton jRadioButtonRojo;
    private javax.swing.JRadioButton jRadioButtonVerde;
    private javax.swing.JTextField jTextFieldRadio;
    // End of variables declaration//GEN-END:variables
}
