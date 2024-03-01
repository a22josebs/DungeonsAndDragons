package src.dd.core;

public class Troll extends Personaje{

    Ataque ataque;
    
    public Troll(String nombre, int salud, Ataque arma){
        super(nombre, salud,arma);
    }
    public Troll(){
        this.nombre = "Troll";
        this.ataque = new Cuchillo();
        this.salud = 1000;
    }

}
