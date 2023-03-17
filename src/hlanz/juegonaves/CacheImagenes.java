/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hlanz.juegonaves;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

/**
 *
 * @author Juanjoos
 */
public class CacheImagenes {
    private static CacheImagenes instancia;
    private Map<String,Image> imagenes;
    
    private CacheImagenes(){
        imagenes=new HashMap<>();
    }
    public static CacheImagenes getInstancia(){
        if(instancia==null){
            instancia=new CacheImagenes();
        }
        return instancia;
    }
    public Image getImagen(String archivo){
        Image x=null;
        if(imagenes.containsKey(archivo)){
            x=imagenes.get(archivo);
        }else{
            try{
              x=ImageIO.read(new File(archivo));  
            }catch(IOException e){
                System.out.println("La ruta pasada como parámetro no se ha encontrado");
            }
        }
        imagenes.put(archivo, x);
        return x;
    }
}
