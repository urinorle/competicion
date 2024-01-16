package TresEnRayaJeicker;

import java.util.Scanner;

public class Menu {
    static final int Medida = 3;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        char[][] tablero = new char[Medida][Medida];
        Jugadors j1 = null;
        Jugadors j2 = null;
        int opcio;
        int a, b, c;
        do {
            menu();
            a = sc.nextInt();

            switch (a) {
                case 1:
                    Ajuda.info();
                    break;
                case 2:
                    do {
                        b = menu2();
                        switch (b) {
                            case 1:
                                j1 = Jugadors.crearJugador();
                                j2 = Jugadors.crearJugador();
                                break;
                            case 2:
                                Partida.inicialitzar(j1, tablero);
                                if(j1 == null) {
                                	break;
                                }
                                Partida.jugada(tablero, j1, j2);
                                break;
                            case 3:
                                Jugadors.veureJugador(j1, j2);
                                break;
                            case 0:
                                break;
                            default:
                                System.out.print("Opción incorrecta");
                        }
                    } while (b != 0);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    break;
                default:
                    System.out.print("Opción incorrecta");
            }
        } while (a != 0);
        System.out.println("Adios");
    }

    static void menu() {
        System.out.println("1.- Ayuda");
        System.out.println("2.- Partida 1vs1");
        System.out.println("3.- Partida 1vsBOT");
        System.out.println("0.- Salir");
        System.out.println("Escoge una opción");
    }

    static int menu2() {
        int Opcio;
        System.out.println("1.- Definir Jugadores");
        System.out.println("2.- Jugar Partida");
        System.out.println("3.- Ver Jugadores");
        System.out.println("0.- Salir");
        System.out.println("Escoge una opción");
        return Opcio = sc.nextInt();
    }
}
