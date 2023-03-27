/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hlanz.juegonaves;

import java.awt.Image;
import java.time.Instant;
import bpc.framework.consola.*;
import java.time.Duration;

/**
 *
 * @author Juanjoos
 */
public abstract class Nave extends SpriteGameObject {
    private int teclaIzquierda;
    private int teclaDerecha;
    private int teclaDisparo;
    private int velocidad;
    private Instant ultimoDisparoRealizado;

    public Nave(int ti, int tde, int tdi, int v, int x, int y, Image imagen) {
        super(imagen, x, y);
        teclaIzquierda = ti;
        teclaDerecha = tde;
        teclaDisparo = tdi;
        velocidad = v;
        ultimoDisparoRealizado = Instant.now();
    }

    @Override
    public void ejecutarFrame() {
        if (this.consola.getTeclado().teclaPulsada(teclaIzquierda) && this.getX() > 0) {
            this.moverX(-velocidad);
        }
        if (this.consola.getTeclado().teclaPulsada(teclaDerecha)
                && this.getX() + this.getAnchura() < this.juego.getAnchuraPantalla()) {
            this.moverX(+velocidad);
        }
        if (this.consola.getTeclado().teclaPulsada(teclaDisparo)) {
            this.disparar();
        }

    }

    public void disparar() {
        Instant now = Instant.now();
        if (Duration.between(ultimoDisparoRealizado, now).getNano() > 340000000) {
            ultimoDisparoRealizado = now;
            this.realizarDisparo();
        }
        // this.realizarDisparo();
    }

    protected abstract void realizarDisparo();

}
