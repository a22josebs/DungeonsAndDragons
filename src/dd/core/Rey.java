package src.dd.core;

public class Rey extends Personaje{
    Ataque espada;
    Ataque arco;
    Ataque cuchillo;

    public Rey(String nombre,int salud, Ataque arma){
        super(nombre, salud,arma);
        this.ataque = new Espada();
    }
}
