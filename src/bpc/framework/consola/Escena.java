/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bpc.framework.consola;
import bpc.daw.consola.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juanjoos
 */
public abstract class Escena implements ElementoJuego{
    protected Juego juego;
    protected Consola consola;
    private List<GameObject>objetos;
    
    public Escena(){
        objetos=null;
        consola=null;
        juego=null;
    }
    @Override
    public void inicializar() {
        if(juego==null||consola==null){
            throw new IllegalStateException("Hay que añadir la escena al juego para poder inicializarla");
        }else{
            objetos=new ArrayList<>();
            añadirObjetosIniciales();
        }
    }
    protected abstract void añadirObjetosIniciales();
    public void añadir(GameObject obj){//protected
        //D.I.
        obj.juego=this.juego;
        obj.consola=this.consola;
        obj.escena=this;
        objetos.add(obj);
        obj.inicializar();
    }
    protected void retirar(GameObject obj){
        obj.finalizar();
        objetos.remove(obj);
        obj.consola=null;
        obj.escena=null;
    }
    @Override
    public void ejecutarFrame() {
        for(int i=0;i<objetos.size();i++){
            objetos.get(i).ejecutarFrame();
        }
    }

    @Override
    public void finalizar() {
        for(int i=0;i<objetos.size();i++){
            this.retirar(objetos.get(i));
        }
    }
    
}
