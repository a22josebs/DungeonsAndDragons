package src.dd.main;

import src.dd.core.*;
import java.util.Random;


public class AppConsola {

    public Personaje[] ejercitoCaballeros(){

        Personaje[] ejercito = new Personaje[3];
        ejercito[0] = new Rey("Rey Arturo",2500,new Espada());
        ejercito[1] = new Caballero("Lancelot", 2000,new Espada());
        ejercito[2] = new Caballero("Percival", 2000,new Arco());
        return ejercito;
    }

    public Personaje[] ejercitoTrolls(int numeroTrolls){

        Personaje[] trolls = new Personaje[numeroTrolls];
        for(int i=0;i<numeroTrolls;i++){
            Personaje troll = new Troll("troll",1000);
            trolls[i] = troll;
        }
        return trolls;
    }



    public boolean quedanVivos(Personaje[] ejercito){
        boolean hayVivos = false;
        for(int i=0;i<ejercito.length;i++){
            if(ejercito[i].salud>0){
                hayVivos = true;
            }
        }
        return hayVivos;
    }

    public int contarVivos(Personaje[] ejercito){
        int vivos = 0;
        for(int i=0;i<ejercito.length;i++){
            if(ejercito[i].salud>0){
                vivos++;
            }
        }
        return vivos;
    }

    public void mostrarEjercitoArturo(Personaje[] ejercito){
        int contador = 1;
        System.out.println("Los supervivientes de la batalla fueron:");
        System.out.print("{");
        for(int i=0;i<ejercito.length;i++){
            if(ejercito[i].salud>0){
                if(contador==contarVivos(ejercito)){
                    System.out.println("["+ejercito[i].nombre+": "+ejercito[i].salud+"]}");
                }else{
                    System.out.print("["+ejercito[i].nombre+": "+ejercito[i].salud+"], ");
                    contador++;
                }                
            }
        }
    }

    public void mostrarEjercitoTrolls(Personaje[] ejercito){
        int contador = 1;
        System.out.println("Los supervivientes de la batalla fueron:");
        System.out.print("{");
        for(int i=0;i<ejercito.length;i++){
            if(ejercito[i].salud>0){
                if(contador==contarVivos(ejercito)){
                    System.out.println("["+ejercito[i].nombre+(i+1)+": "+ejercito[i].salud+"]}");
                }else{
                    System.out.print("["+ejercito[i].nombre+(i+1)+": "+ejercito[i].salud+"], ");
                    contador++;
                }                
            }
        }
    }

    public void ataca(Personaje atacante, Personaje atacado,int n){
        if(atacado.salud<=0){
            return;
        }
        int danio = atacante.ataca(atacado);
        if(danio!=0){
            System.out.println("Ataque con "+atacante.ataque.getNombre()+" (-"+danio+")");
        }else{
            System.out.println("Ataque con "+atacante.ataque.getNombre()+" (falla)");
        }
        delay(1000);
        if(atacado.salud<=0){
            System.out.println("--["+atacado.nombre+(n+1)+": "+atacado.salud+" HA MUERTO ]--");
            return;
        }
    }

    public void batalla(){

        Random rnd = new Random();
        int numeroTrolls = rnd.nextInt(0,10);
        Personaje[] arturicos =  new Personaje[3];
        arturicos = ejercitoCaballeros();
        Personaje[] trolls =  new Personaje[numeroTrolls];
        trolls = ejercitoTrolls(numeroTrolls);
        int ataqueRey = 3;
        int ataqueCaballero = 2;
        int index;

        System.out.println("Tal día como hoy, en una húmeda y fría mañana de finales de primavera,");
        System.out.println("la partida formada por: [[Rey Arturo], [Lancelot], [Percival]]");
        System.out.println("hallándose en los frondosos bosques del sitio de Deorham, se topó con una");
        System.out.println("patrulla de "+numeroTrolls+" esas sanguinarias e inhumanas criaturas popularmente");
        System.out.println("conocidas como trolls.");
        System.out.println("De la batalla que aconteció, dejo aquí testimonio:");
        while(quedanVivos(arturicos) && quedanVivos(trolls)){
            for(int i=0;i<arturicos.length;i++){
                do{
                    index = rnd.nextInt(0,trolls.length);
                }while(trolls[index].salud<=0);

                if(arturicos[i].salud>0){
                    if(i==0){
                        System.out.print("["+arturicos[i].nombre+": "+arturicos[i].salud+"] lucha contra ["+trolls[index].nombre+" "+(index+1));
                        System.out.println(": "+trolls[index].salud+"]");
                        for(int j=0;j<ataqueRey;j++){
                            ataca(arturicos[i],trolls[index],index);
                        }
                    }else{
                        System.out.print("["+arturicos[i].nombre+": "+arturicos[i].salud+"] lucha contra ["+trolls[index].nombre+" "+(index+1));
                        System.out.println(": "+trolls[index].salud+"]");
                        for(int j=0;j<ataqueCaballero;j++){
                            ataca(arturicos[i],trolls[index],index);
                        }                   
                    }
                    if(!quedanVivos(trolls)){
                        mostrarGanador(arturicos,trolls);
                    }
                }
            }
            for(int i=0;i<trolls.length;i++){
                if(trolls[i].salud>0){
                    int atack = rnd.nextInt(0,3);
                    if(atack==0){
                        trolls[i].setAtaque(new Espada());
                    }else if(atack==1){
                        trolls[i].setAtaque(new Arco());
                    }else{
                        trolls[i].setAtaque(new Cuchillo());
                    }
                    do{
                        //Random rn = new Random();
                        index = rnd.nextInt(0,arturicos.length);
                    }while(arturicos[index].salud<=0 && quedanVivos(arturicos));
                    if(quedanVivos(arturicos)){
                        System.out.print("["+trolls[i].nombre+(i+1)+": "+trolls[i].salud+"] lucha contra ["+arturicos[index].nombre);
                        System.out.println(": "+arturicos[index].salud+"]");
                        ataca(trolls[i],arturicos[index],i);
                    }
                }
                
            }  
        }
        mostrarGanador(arturicos, trolls);
    }

    public void mostrarGanador(Personaje[] arturios, Personaje[] trols){
        if(quedanVivos(arturios)){
            System.out.println("FELICIDADES HAN GANADO LOS GRANDES CABALLEROS");
            mostrarEjercitoArturo(arturios);
        }else{
            System.out.println("EL REINO DE ARTURO HA CAIDO");
            System.out.println("HAN GANADO LOS TROLLS");
            mostrarEjercitoTrolls(trols);

        }
        System.exit(0);
    }

    public void delay(int x){
        try {
            Thread.sleep(x);
        } catch (InterruptedException e) {
            System.out.println("paciencia");
        }
    }


    public static void main(String[] args) {

        AppConsola app = new AppConsola();
        app.batalla();
        

    }

}
