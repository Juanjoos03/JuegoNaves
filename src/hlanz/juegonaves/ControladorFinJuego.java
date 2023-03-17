/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hlanz.juegonaves;

import bpc.framework.consola.GameObject;

/**
 *
 * @author Juanjoos
 */
public class ControladorFinJuego extends GameObject{
    public ControladorFinJuego(){
        
    }

    @Override
    public void inicializar() {
        
    }

    @Override
    public void ejecutarFrame() {
        if(this.escena instanceof JuegoNaves j){
            if(j.getEnemigos().isEmpty()){
                this.juego.detener();
            }
        }
    }

    @Override
    public void finalizar() {
        
    }
}
