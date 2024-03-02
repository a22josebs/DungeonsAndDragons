package src.dd.core;

public class Personaje{
    public String nombre;
    public int salud;
    public Ataque ataque;

    public Personaje(){}

    public Personaje(String nombre, int salud){
        this.nombre = nombre;
        this.salud = salud;
    }

    public void setAtaque(Ataque ataque){
        this.ataque = ataque;
    }

    public String toString(){
        return ("["+nombre+": "+salud+" HP.");
    }

    public int ataca(Personaje enemigo){
        int danio = 0;
        danio += this.ataque.lanzaAtaque(enemigo);
        return danio;
    }

    public void setEspada(){
    }
    public void setArco(){
    }
    public void stCuchillo(){
    }

}