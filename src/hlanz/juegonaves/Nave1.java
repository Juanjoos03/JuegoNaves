/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hlanz.juegonaves;

/**
 *
 * @author Juanjoos
 */
public class Nave1 extends Nave {

    public Nave1(int ti, int tde, int tdi) {
        super(ti, tde, tdi, 5, 100, 900, CacheImagenes.getInstancia().getImagen("nave1.png"));
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
        Disparo d = new Disparo(0, this.getX() + 60, this.getY() - 20, 0, -10);
        this.juego.getEscena().añadir(d);
        // d.inicializar();
    }

}
