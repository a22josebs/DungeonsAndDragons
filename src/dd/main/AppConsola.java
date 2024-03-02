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
            Personaje troll = new Troll("troll",1000,new Espada());
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

    public void mostrarEjercitos(Personaje[] ejercito){
        for(int i=0;i<ejercito.length;i++){
            System.out.println(ejercito[i].nombre+i+" "+ejercito[i].salud);
        }
    }

    public void ataca(Personaje atacante, Personaje atacado){
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
    }

    public void batalla(){

        Random rnd = new Random();
        int numeroTrolls = rnd.nextInt(0,10);
        Personaje[] arturicos =  new Personaje[3];
        arturicos = ejercitoCaballeros();
        Personaje[] trolls =  new Personaje[numeroTrolls];
        trolls = ejercitoTrolls(numeroTrolls);
        Personaje atacado;
        int ataqueRey = 3;
        int ataqueCaballero = 2;
        int index;

        System.out.println("Tal día como hoy, en una húmeda y fría mañana de finales de primavera,");
        System.out.println("la partida formada por: [[Rey Arturo], [Lancelot], [Percival]]");
        System.out.println("hallándose en los frondosos bosques del sitio de Deorham, se topó con una");
        System.out.println("patrulla de "+numeroTrolls+" esas sanguinarias e inhumanas criaturas popularmente");
        System.out.println("conocidas como trolls.");
        System.out.println("De la batalla que aconteció, dejo aquí testimonio:");
        //while(quedanVivos(arturicos) && quedanVivos(trolls)){
            for(int i=0;i<arturicos.length;i++){
                index = rnd.nextInt(0,trolls.length);
                if(i==0){
                    System.out.print("["+arturicos[i].nombre+": "+arturicos[i].salud+"] lucha contra ["+trolls[index].nombre+" "+index);
                    System.out.println(": "+trolls[index].salud+"]");
                    for(int j=0;j<ataqueRey;j++){
                        ataca(arturicos[i],trolls[index]);
                    }
                }else{
                    System.out.print("["+arturicos[i].nombre+": "+arturicos[i].salud+"] lucha contra ["+trolls[index].nombre+" "+(index+1));
                    System.out.println(": "+trolls[index].salud+"]");
                    for(int j=0;j<ataqueCaballero;j++){
                        ataca(arturicos[i],trolls[index]);
                    }                   
                }
            }
            for(int i=0;i<trolls.length;i++){
                index = rnd.nextInt(0,arturicos.length);
                System.out.print("["+trolls[i].nombre+(index+1)+": "+trolls[i].salud+"] lucha contra ["+arturicos[index].nombre);
                System.out.println(": "+arturicos[index].salud+"]");
                ataca(trolls[i],arturicos[index]);
            }     
        //}
        mostrarEjercitos(arturicos);
        mostrarEjercitos(trolls);

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
