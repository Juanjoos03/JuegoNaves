/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hlanz.juegonaves;

/**
 *
 * @author Juanjoos
 */
public class Enemigo2 extends Enemigo {
    private int centroX;
    private int centroY;
    private int radio;
    private double angulo;
    private double velocidad;

    public Enemigo2(int x, int y, int cx, int cy, int r, int v) {
        super(x, y, CacheImagenes.getInstancia().getImagen("malo2.png"));
        centroX = cx;
        centroY = cy;
        radio = r;
        velocidad = v;
        angulo = 0;
    }

    @Override
    public int getPuntuacion() {
        return (int) Math.abs(velocidad * 2);
    }

    @Override
    public void ejecutarFrame() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
