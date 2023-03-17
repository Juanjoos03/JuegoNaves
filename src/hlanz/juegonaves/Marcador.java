/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hlanz.juegonaves;

import bpc.framework.consola.GameObject;
import java.awt.Color;

/**
 *
 * @author Juanjoos
 */
public class Marcador extends GameObject{
    private int [] puntos;
    public Marcador(){
        puntos=new int[2];
    }
    public void incrementarPuntos(int jugador,int puntos){
        if(puntos<0){
            throw new IllegalArgumentException("La puntuacion no puede ser negativa");
        }
        this.puntos[jugador]+=puntos;
    }
    
    @Override
    public void inicializar() {
        puntos[0]=0;
        puntos[1]=0;
        
    }

    @Override
    public void ejecutarFrame() {
        this.consola.getCapaCanvas().getGraphics().setColor(Color.red);
        this.consola.getCapaCanvas().getGraphics().drawString("Jugador 1: "+puntos[0]+" || Jugador 2: "+puntos[1], 100, 100);
    }

    @Override
    public void finalizar() {
        
    }
    
}
