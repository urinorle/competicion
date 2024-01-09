package memory;

import java.util.Random;
import java.util.Scanner;

public class Programa {

	static Scanner sc = new Scanner(System.in);
	static Random rd = new Random();

	static final char Tapat = '?';
	static final char Files = 4;
	static final char Columnes = 4;

	public static void main(String[] args) {
		
		int a;
		char[][] tauler = new char[Files][Columnes];
		char[][] taulerSecret = new char[Files][Columnes];

		Jugador j1 = null; 
		Jugador j2 = null; 
		do {

			menu();
			a = sc.nextInt();

			switch (a) {
			case 1:
				Partida.inicilitzar(tauler);
				break;
			case 2:
				Partida.visualitzar(tauler);
				break;
			case 3:
				Partida.iniSecret(taulerSecret);
				break;
			case 4:
				Partida.visualitzar(taulerSecret);
				break;
			case 7:  //definir jugadors
					j1=Jugador.crearJugador();
					j2=Jugador.crearJugador();
				break;
			case 8://veure jugadors
				Jugador.veureJugador(j1);
				Jugador.veureJugador(j2);					
				break;
			case 9:
				Ajuda.mostrarAjuda();
			case 0:
				break;

			default:
				System.out.print("Opció incorrecte");
			}
		} while (a != 0);
		System.out.println("Adeu");
	}

	static void menu() {
		System.out.println("1.- Tauler");
		System.out.println("2.- Mostrar taula");
		System.out.println("3.- Inicialitzar Secret");
		System.out.println("4.- Veure Secret (trampa)");
		System.out.println("7.- Definir Jugadors");
		System.out.println("8.- Veure Jugadors");
		System.out.println("9.- Ajuda");
		System.out.println("0.- Sortir");
		return;

	}
}
