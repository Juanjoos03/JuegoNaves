/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hlanz.juegonaves;

import bpc.framework.consola.SpriteGameObject;

/**
 *
 * @author Juanjoos
 */
public class Disparo extends SpriteGameObject {

    private int idjugador;
    private int vx;
    private int vy;

    public Disparo(int id, int x, int y, int vx, int vy) {
        super(CacheImagenes.getInstancia().getImagen("disparo.png"), x, y);
        idjugador = id;
        this.vx = vx;
        this.vy = vy;
        // this.inicializar();
    }

    @Override
    public void ejecutarFrame() {
        this.moverX(vx);
        this.moverY(vy);
        if ((this.getX() < 0 || this.getX() > this.juego.getAnchuraPantalla()) ||
                (this.getY() < 0 || this.getY() > this.juego.getAlturaPantalla())) {
            this.finalizar();
        }
        JuegoNaves jn = (JuegoNaves) this.escena;
        /*
         * for(Enemigo e:jn.getEnemigos()){
         * if((this.getX()<e.getX()+e.getAnchura()&&this.getX()>e.getX())&&
         * (this.getY()<e.getY()+e.getAltura()&&this.getY()>e.getY())){
         * e.finalizar();
         * this.finalizar();
         * //Incrementar puntos
         * jn.getMarcador().incrementarPuntos(idjugador, e.getPuntuacion());
         * }
         * }
         */
        for (int i = 0; i < jn.getEnemigos().size(); i++) {
            Enemigo e = jn.getEnemigos().get(i);
            if ((this.getX() < e.getX() + e.getAnchura() && this.getX() > e.getX()) &&
                    (this.getY() < e.getY() + e.getAltura() && this.getY() > e.getY())) {
                e.finalizar();
                jn.retirar(e);
                this.finalizar();
                // Incrementar puntos
                jn.getMarcador().incrementarPuntos(idjugador, e.getPuntuacion());
            }
        }

        /*
         * if(this.escena instanceof JuegoNaves j){
         * List <Enemigo> lista= j.getEnemigos();
         * for(int i=0;i<lista.size();i++){
         * /*if(this.getX()>=j.getEnemigos().get(i).getY()&&this.getX()>=j.getEnemigos()
         * .get(i).getX()&&this.getX()>=j.getEnemigos().get(i).getAnchura()){
         * j.getEnemigos().get(i).finalizar();
         * this.finalizar();
         * //Incrementar puntos
         * 
         * }
         * if(this.getX()>=j.getEnemigos().get(i).getY()-j.getEnemigos().get(i).
         * getAnchura()&&this.getX()<=j.getEnemigos().get(i).getY()){
         * j.getEnemigos().get(i).finalizar();
         * this.finalizar();
         * //Incrementar puntos
         * 
         * }
         * }
         */
        /*
         * for(Enemigo e:lista){
         * /*
         * if(this.getX()>=e.getY()&&this.getX()<=e.getAnchura()){
         * e.finalizar();
         * this.finalizar();
         * //Incrementar puntos
         * 
         * }
         * if(this.getY()>=e.getY() && this.getX()>=e.getX() &&
         * this.getX()<=e.getAnchura()){
         * e.finalizar();
         * this.finalizar();
         * }
         * }
         * }
         */

    }

}
