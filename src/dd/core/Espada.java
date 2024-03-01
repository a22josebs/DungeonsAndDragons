package src.dd.core;

public class Espada  implements Ataque{
    int valorAtaque = 100;
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
