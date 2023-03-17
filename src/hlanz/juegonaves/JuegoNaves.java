/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hlanz.juegonaves;

import bpc.framework.consola.Escena;
import bpc.framework.consola.GameObject;
import bpc.framework.consola.Juego;
import bpc.framework.consola.Resolucion;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juanjoos
 */
public class JuegoNaves extends Escena{
    
    private List<Enemigo> enemigos=new ArrayList<>();
    private Marcador marcador;//MIO
    
    public List<Enemigo> getEnemigos(){
        return enemigos;
    }
    
    public static void main(String[] args) {

        Juego juego=new Juego();
        Escena nave=new JuegoNaves();
        
        juego.iniciar(nave, Resolucion.VENTANA_FULLHD);
        //System.out.println(juego.getAnchuraPantalla());
        
    }
    
    @Override
    public void añadir(GameObject obj) {//protected
        super.añadir(obj);
        if(obj instanceof Enemigo e){
            enemigos.add(e);
        }
    }
    @Override
    protected void retirar(GameObject obj) {
        super.retirar(obj);
         if(obj instanceof Enemigo e){
            enemigos.remove(e);
        }
    }
    @Override
    protected void añadirObjetosIniciales() {
        super.añadir(new ControladorFinJuego());
        super.añadir(new Fondo(5));//Velocidad puesta por mi
        //W     D       X
        añadir(new Nave1(65,68,88));
        //FI        FD      FA
        añadir(new Nave2(37,39,38));
        
        try{
            FileReader a=new FileReader("nivel1.txt");
            BufferedReader b=new BufferedReader(a);
            String linea=b.readLine();
            while(linea!=null){
                String [] trozos= linea.split(" ");
                String nombreClase="hlanz.juegonaves."+trozos[0];
                Class clase=Class.forName(nombreClase);
                Constructor constructor=clase.getConstructor(
                        Integer.class,
                        Integer.class,
                        Integer.class
                );
                GameObject g=(GameObject)constructor.newInstance(
                        Integer.parseInt(trozos[1]),
                        Integer.parseInt(trozos[2]),
                        Integer.parseInt(trozos[3])
                );
                this.añadir(g);
                linea=b.readLine();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        
        /*
        //añadir enemigos
        añadir(new Enemigo1(100,200,5));
        añadir(new Enemigo1(500,400,5));
        añadir(new Enemigo1(1000,300,5));*/
        //añadir(new Enemigo2(1000,30000,5));
        marcador=new Marcador();
        super.añadir(marcador);
    }
    //MIO
    public Marcador getMarcador(){
        return marcador;
    }
}
