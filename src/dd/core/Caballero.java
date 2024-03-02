package src.dd.core;

public class Caballero extends Personaje{
    public Caballero(String nombre,int salud,Ataque ataque){
        super(nombre,salud);
        this.ataque = ataque;
    }
    public void setSalud(int danio){
        salud -= danio;
    }
    public int getSalud(){
        return salud;
    }
}
