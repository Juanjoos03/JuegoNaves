/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hlanz.juegonaves;

/**
 *
 * @author Juanjoos
 */
public class Nave2 extends Nave {

    public Nave2(int ti, int tde, int tdi) {
        super(ti, tde, tdi, 3, 400, 900, CacheImagenes.getInstancia().getImagen("nave2.png"));
    }

    /*
     * se creará y añadirá a la escena del juego un objeto Disparo en las
     * coordenadas (x,y) de la nave con una
     * velocidad de 0 píxeles en el eje x y -10 píxeles en el eje Y (con esto
     * conseguimos que el disparo se mueva hacia arriba). El
     * disparo creado se añadirá a la escena.
     */
    @Override
    protected void realizarDisparo() {
        Disparo d = new Disparo(1, this.getX() + 60, this.getY() - 20, -3, -3);
        Disparo d2 = new Disparo(1, this.getX() + 60, this.getY() - 20, 3, -3);
        this.juego.getEscena().añadir(d);
        this.juego.getEscena().añadir(d2);
        // d.inicializar();
        // d2.inicializar();
    }

}
