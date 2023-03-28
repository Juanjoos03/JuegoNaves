/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hlanz.juegonaves;

import bpc.framework.consola.SpriteGameObject;
import java.awt.Image;

/**
 *
 * @author Juanjoos
 */
public abstract class Enemigo extends SpriteGameObject implements Vidas{
    
    private int vidas;
    
    public Enemigo(int x,int y,Image img){
        super(img,x,y);
        vidas=1;
    }
    public abstract int getPuntuacion();

    @Override
    public void setVidas(int vidas) {
        this.vidas=vidas;
    }

    @Override
    public int getVidas() {
        return vidas;
    }

    @Override
    public void restarVidas() {
        vidas--;
        if(vidas==0){
            this.morir();
        }
    }

    @Override
    public void morir() {
        this.finalizar();
        
    }
}
