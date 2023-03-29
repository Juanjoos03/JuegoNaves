/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hlanz.juegonaves;

/**
 *
 * @author Juanjoos
 */
public class Enemigo3 extends Enemigo {

    private int velocidad;
    private int tiempoActivo;
    
    public Enemigo3(int x, int y, int v) {
        super(x, y, CacheImagenes.getInstancia().getImagen("malo1.png"));
        velocidad = v;
    }

    @Override
    public int getPuntuacion() {
        return Math.abs(velocidad * 3); //triple de puntos
    }

    @Override
    public void ejecutarFrame() {
        this.moverX(velocidad);
        if ((this.getX() == 0) || this.getX() + this.getAnchura() == this.juego.getAnchuraPantalla()) {
            velocidad = (-velocidad);
        }
        /*Aumenta la velocidad la raíz cuadrada del tiempo que el enemigo ha
        estado activo*/
        tiempoActivo++;
        velocidad += Math.sqrt(tiempoActivo);
    }

}
