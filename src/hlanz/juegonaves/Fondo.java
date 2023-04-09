/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hlanz.juegonaves;

import bpc.framework.consola.GameObject;
import java.awt.Image;
import java.awt.Rectangle;

/**
 *
 * @author Juanjoos
 */
public class Fondo extends GameObject {
    private Image imagen;
    private Rectangle camara;
    private int velocidadCamara;

    public Fondo(int vc) {
        velocidadCamara = vc;
        imagen = CacheImagenes.getInstancia().getImagen("fondo.png");
        camara = new Rectangle();
    }
    
    @Override
    public void inicializar() {
        camara = new Rectangle(0, 0, this.juego.getAnchuraPantalla(), this.juego.getAlturaPantalla());
    }

    @Override
    public void ejecutarFrame() {
        consola.getCapaCanvas().getGraphics().drawImage(imagen, camara.x, camara.y, null);
        camara.y=camara.y+velocidadCamara;
        camara.setLocation(0, camara.y);
        if (camara.y >= 0) {
            camara.x = 0;
            camara.y = -imagen.getHeight(null)/2;
        }
    }

    @Override
    public void finalizar() {
    
    }
    
}
