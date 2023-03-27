public interface Vidas{
    
    public int setVidas(int vidas);
        //this.vidas=vidas;
    public int getVidas();
        //return vidas;
    public void restarVidas();
        /*vidas--;
        if(this.getVidas()==0){
        this.morir();
        }*/
    public void morir();
        //borrar la nave
}