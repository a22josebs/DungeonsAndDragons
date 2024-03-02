package src.dd.core;

public class Rey extends Personaje{
    Ataque espada;
    Ataque arco;
    Ataque cuchillo;

    public Rey(String nombre,int salud,Ataque ataque){
        super(nombre, salud);
        this.ataque = ataque;
    }
    @Override
    public void setEspada(){
        this.ataque = espada;
    }
    @Override
    public void  setArco(){
        this.ataque = arco;

    }
    public int getSalud(){
        return salud;
    }
    public void setSalud(int danio){
        salud -= danio;
    }
}
