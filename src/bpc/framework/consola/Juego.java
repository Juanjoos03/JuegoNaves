/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bpc.framework.consola;
import bpc.daw.consola.*;
import java.awt.event.KeyEvent;
/**
 *
 * @author Juanjoos
 */
public class Juego {
    private Consola consola;
    private Escena escena;
    private boolean detener;
    private Resolucion resolucion;
    
    public void iniciar(Escena e, Resolucion r){
        if(r==Resolucion.PANTALLA_COMPLETA){
            consola=new Consola();
        }else{
            consola=new Consola("Game",r.getResolucion().width,r.getResolucion().height);
        }
        resolucion=r;
        this.setEscena(e);
        detener=false;
        while(!detener){
            consola.esperarSiguienteFrame();
            if(consola.getTeclado().teclaPulsada(KeyEvent.VK_ESCAPE)){
                this.detener();
            }
            this.escena.ejecutarFrame();//
        } 
    }
    public void setEscena(Escena e){
        escena=e;
        escena.juego=this;
        escena.consola=this.consola;
        escena.inicializar(); 
    }
    public void detener(){
        detener=true;
    }
    public int getAnchuraPantalla(){
        return (resolucion.getResolucion().width);
    }
    public int getAlturaPantalla(){
        return resolucion.getResolucion().height;
    }
    //MIO
    public Escena getEscena(){
        return escena;
    }
}
