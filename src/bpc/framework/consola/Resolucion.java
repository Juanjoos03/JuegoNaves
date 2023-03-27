/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bpc.framework.consola;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author Juanjoos
 */
public enum Resolucion {
    PANTALLA_COMPLETA(Toolkit.getDefaultToolkit().getScreenSize()),
    VENTANA_4K(new Dimension(4096,2160)),
    VENTANA_FULLHD(new Dimension(1920,1080)),
    VENTANA_QHD(new Dimension(2560,1440)),
    VENTANA_VGA(new Dimension(800,600));
    
    private Dimension resolucion;
    private Resolucion(Dimension r){
        resolucion=r;
    }
    public Dimension getResolucion(){
        return resolucion;
    }
}
