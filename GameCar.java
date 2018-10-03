package gamecar;
import java.util.Random;
import java.util.Scanner;
public class GameCar {
    public static void main(String[] args) {
        Auto A1 = new Auto(0, 0, "Lambo", "Rojo", 0);
        Auto A2 = new Auto(0, 0, "BMW", "Negro Mate", 0);
        Auto A3 = new Auto(0, 0, "Audi", "Azul metalizado", 0);
        int aceleracion1,aceleracion2 ,opcJugador,velocidad1 = 0,velocidad2= 0,freno1,freno2;
        String ganador = "";
        Byte opc;
        Scanner entrada = new Scanner(System.in);
        Random rand = new Random(System.nanoTime());
        opc = Menu(entrada);
        opcJugador = rand.nextInt(2) + 1;
        aceleracion1 = rand.nextInt(10) + 1;
        aceleracion2 = rand.nextInt(10) + 1;
        boolean accion = true;
        freno1 = rand.nextInt(10) + 1;
        freno2 = rand.nextInt(10) + 1;
        switch (opc) {
            case 1:
                System.out.println("\t Lambo seleccionado");
                switch (opcJugador) {
                    case 1:
                        System.out.println("\t Vas a correr contra BMW");
                        Lambo_VS_BMW(accion, A1, aceleracion1, A2, aceleracion2, velocidad1, velocidad2, ganador, freno1, freno2);
                        break;
                    case 2:
                        System.out.println("\t Vas a correr contra Audi");
                        Lambo_VS_Audi(accion, A1, aceleracion1, A3, aceleracion2, velocidad1, velocidad2, ganador, freno1, freno2);
                        break;
                }
                break;
            case 2:
                System.out.println("\t BMW seleccionado");
                switch (opcJugador) {
                    case 1:
                        System.out.println("\t Vas a correr contra Lambo");
                        Lambo_VS_BMW(accion, A1, aceleracion1, A2, aceleracion2, velocidad1, velocidad2, ganador, freno1, freno2);
                        break;
                    case 2:
                        System.out.println("\t Vas a correr contra Audi");
                        BMW_VS_Audi(accion, A3, aceleracion1, A2, aceleracion2, velocidad1, velocidad2, ganador, freno1, freno2);
                        break;
                }
                break;
            case 3:
                System.out.println("\t Audi seleccionado");
                switch (opcJugador) {
                    case 1: 
                        System.out.println("\t Vas a correr contra Lambo");
                        Lambo_VS_Audi(accion, A1, aceleracion1, A3, aceleracion2, velocidad1, velocidad2, ganador, freno1, freno2);
                        break;
                    case 2:
                        System.out.println("\t Vas a correr contra BMW");
                        BMW_VS_Audi(accion, A3, aceleracion1, A2, aceleracion2, velocidad1, velocidad2, ganador, freno1, freno2);
                        break;
                }
                break;
            default:
                System.out.println("Entrada Incorrecta");
        }
    }
    private static Byte Menu(Scanner entrada) {
        Byte opc;
        System.out.println("\t =======Menu========");
        System.out.println("\t 1.) Para el Lambo");
        System.out.println("\t 2.) Para el BMW");
        System.out.println("\t 3-) Para el Audi");
        opc = entrada.nextByte();
        return opc;
    }
    private static void BMW_VS_Audi(boolean accion, Auto A3, int aceleracion1, Auto A2, int aceleracion2, int velocidad1, int velocidad2, String ganador,int freno1,int freno2) {
        while (accion) {
            A3.setAceleracion(aceleracion1);
            A2.setAceleracion(aceleracion2);
            System.out.println(" ");
            velocidad1 += aceleracion1;
            velocidad2 += aceleracion2;
            if ((A2.getVelocidad()>20)&&(A3.getVelocidad()>20)) {
                velocidad1=velocidad1 - freno1;
                velocidad2=velocidad2 - freno2;
            }
            A3.setVelocidad(velocidad1);
            A2.setVelocidad(velocidad2);
            if ((A3.getVelocidad() > 200) || (A2.getVelocidad() > 200))accion = false;
            System.out.println("La velociad del BMW es de " + A2.getVelocidad()+"Km/h");
            System.out.println("El BMW freno "+freno1+"Km/h");
            System.out.println("La velociad del Audi es de " + A3.getVelocidad()+"Km/h");
            System.out.println("El Audi freno "+freno2+"Km/h");
            ganador = A2.getVelocidad() > 200 ? "\tEL ganador es BMW" : "\tEl ganador es Audi";
        }
        System.out.println(ganador);
    }
    private static void Lambo_VS_Audi(boolean accion, Auto A1, int aceleracion1, Auto A3, int aceleracion2, int velocidad1, int velocidad2, String ganador,int freno1,int freno2) {
        while (accion) {       
            A1.setAceleracion(aceleracion1);
            A3.setAceleracion(aceleracion2); 
            System.out.println(" ");
            velocidad1 += aceleracion1;
            velocidad2 += aceleracion2;
            if ((A1.getVelocidad()>20)&&(A3.getVelocidad()>20)) {
                velocidad1=velocidad1 - freno1;
                velocidad2=velocidad2 - freno2;
            }
            A1.setVelocidad(velocidad1);
            A3.setVelocidad(velocidad2);
            if ((A1.getVelocidad() > 200) || (A3.getVelocidad() > 200))accion = false;
            System.out.println("La velociad del lambo es de " + A1.getVelocidad()+"Km/h");
            System.out.println("El lambo freno "+freno1+"Km/h");
            System.out.println("La velociad del Audi es de " + A3.getVelocidad()+"Km/h");
            System.out.println("El Audi freno "+freno2+"Km/h");       
            ganador = A1.getVelocidad() > 200 ? "\tEL ganador es Lambo" : "\tEl ganador es Audi";
        }
        System.out.println(ganador);
    }
    private static void Lambo_VS_BMW(boolean accion, Auto A1, int aceleracion1, Auto A2, int aceleracion2, int velocidad1, int velocidad2, String ganador,int freno1,int freno2) {
        while (accion) {
            A1.setAceleracion(aceleracion1);
            A2.setAceleracion(aceleracion2);
            System.out.println(" ");
            velocidad1 += aceleracion1;
            velocidad2 += aceleracion2;
            if ((A1.getVelocidad()>20)&&(A2.getVelocidad()>20)) {
                velocidad1=velocidad1 - freno1;
                velocidad2=velocidad2 - freno2;
            }
            A1.setVelocidad(velocidad1);
            A2.setVelocidad(velocidad2);
            if ((A1.getVelocidad() > 200) || (A2.getVelocidad() > 200))accion = false;
            System.out.println("La velociad del lambo es de " + A1.getVelocidad()+"Km/h");
            System.out.println("El BMW freno "+freno1+"Km/h");
            System.out.println("La velociad del BMW es de " + A2.getVelocidad()+"Km/h");
            System.out.println("El lambo freno "+freno2+"Km/h");
            ganador = A1.getVelocidad() > 200 ? "\tEL ganador es Lambo" : "\tEl ganador es BmW";
        }
        System.out.println(ganador);
    }
}