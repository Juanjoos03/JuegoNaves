/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bpc.framework.consola;
import bpc.daw.consola.*;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
/**
 *
 * @author Juanjoos
 */
public abstract class SpriteGameObject extends GameObject {
    private Sprite sprite;
    private Image imagen;
    private Point puntoInicial;
    public SpriteGameObject(Image img,int x,int y){
        imagen=img;
        sprite=null;
        puntoInicial=new Point(x,y);
    }

    @Override
    public void inicializar() {
        sprite=this.consola.getCapaSprites().crearSprite(imagen, 
                new Rectangle(getAnchura(),getAltura()), 
                puntoInicial.x, puntoInicial.y);
    }
    public int getX(){
        return sprite.getX();
    }
    public int getY(){
        return sprite.getY();
    }
    public void moverX(int cx){
        sprite.moverX(cx);
    }
    public void moverY(int cy){
        sprite.moverY(cy);
    }
    public void setX(int cx){
        sprite.setPosicion(sprite.getX()+cx, sprite.getY());
    }
     public void setY(int cy){
        sprite.setPosicion(sprite.getX(), sprite.getY()+cy);
    }
    public int getAnchura(){
        return imagen.getWidth(null);
    }
    public int getAltura(){
        return imagen.getHeight(null);
    }

    @Override
    public void finalizar() {
        this.consola.getCapaSprites().eliminarSprite(sprite);
    }
    
    
}
