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
public abstract class Enemigo extends SpriteGameObject{
    public Enemigo(int x,int y,Image img){
        super(img,x,y);
    }
    public abstract int getPuntuacion();
}
