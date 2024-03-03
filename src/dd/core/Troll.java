package src.dd.core;

public class Troll extends Personaje{
    
    public Troll(String nombre, int salud){
        super(nombre, salud);
        //this.ataque = ataque;
    }
    
    public void setSalud(int danio){
        salud -= danio;
    }
    public int getSalud(){
        return salud;
    }
    
    public void setAtaque(Ataque ataque){
        this.ataque = ataque;
    }
   
}
