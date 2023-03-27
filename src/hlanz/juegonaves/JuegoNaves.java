/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hlanz.juegonaves;

import bpc.framework.consola.Escena;
import bpc.framework.consola.GameObject;
import bpc.framework.consola.Juego;
import bpc.framework.consola.Resolucion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juanjoos
 */
public class JuegoNaves extends Escena {

    private List<Enemigo> enemigos = new ArrayList<>();
    private Marcador marcador;// MIO

    public List<Enemigo> getEnemigos() {
        return enemigos;
    }

    public static void main(String[] args) {

        Juego juego = new Juego();
        Escena nave = new JuegoNaves();

        juego.iniciar(nave, Resolucion.VENTANA_FULLHD);
        // System.out.println(juego.getAnchuraPantalla());

    }

    @Override
    public void añadir(GameObject obj) {// protected
        super.añadir(obj);
        if (obj instanceof Enemigo e) {
            enemigos.add(e);
        }
    }

    @Override
    protected void retirar(GameObject obj) {
        super.retirar(obj);
        if (obj instanceof Enemigo e) {
            enemigos.remove(e);
        }
    }

    @Override
    protected void añadirObjetosIniciales() {

        super.añadir(new Fondo(5));// Velocidad puesta por mi
        // W D espacio
        añadir(new Nave1(65, 68, 32));
        // FI FD FA
        añadir(new Nave2(37, 39, 38));

        super.añadir(new ControladorFinJuego());

        // añadir enemigos
        añadir(new Enemigo1(100, 200, 5));
        añadir(new Enemigo1(500, 400, 5));
        añadir(new Enemigo1(1000, 300, 5));
        marcador = new Marcador();
        super.añadir(marcador);
    }

    // MIO
    public Marcador getMarcador() {
        return marcador;
    }
}
