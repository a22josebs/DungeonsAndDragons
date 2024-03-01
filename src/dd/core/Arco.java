package src.dd.core;

public class Arco implements Ataque{
    int valorAtaque = 50;
    String nombre = "Arco";
    @Override
    public int lanzaAtaque(Personaje enemigo){
        int danio = calcularAtaque(valorAtaque);
        enemigo.salud -= danio;
        return danio;
    }
    @Override
    public String getNombre(){
        return this.nombre;
    }
}
