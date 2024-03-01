package src.dd.core;

public class Cuchillo implements Ataque{
    int valorAtaque = 25;
    String nombre = "Espada";

    @Override
    public int lanzaAtaque(Personaje enemigo){
        int danio = calcularAtaque(valorAtaque);
        enemigo.salud -= danio;
        return danio;
    }
    public String getNombre(){
        return this.nombre;
    }
}
