package src.dd.core;

import java.util.Random;

public interface Ataque {
    int lanzaAtaque(Personaje enemigo);
    String getNombre();

    public default int calcularAtaque(int ataque){
        Random rnd = new Random();
        int danio = Math.round((rnd.nextInt(0,2))*(rnd.nextFloat(0,1))*ataque);
        return danio;
    }
}
