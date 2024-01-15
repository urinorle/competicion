package tresenratlla;

import java.util.Scanner;

public class Menu {
	static Scanner sc = new Scanner(System.in);
	static final int mesura = 3;

	public static void main(String[] args) {

		char[][] tauler = new char[mesura][mesura];

		Jugadors j1 = null;
		Jugadors j2 = null;

		int a;
		do {

			menu();
			a = sc.nextInt();

			switch (a) {
			case 1:
				Ajuda.info();
				break;
			case 2:
				j1 = Jugadors.definirjugador();
				j2 = Jugadors.definirjugador();
				break;
			case 3:
				menu2();
				int opcio = sc.nextInt();
				switch (opcio) {
				case 1:
					Joc.inicialitzar(j1, tauler);
					if (j1 == null) {
						break;
					}
					Joc.jugada(tauler, j1, j2);
					break;
				case 2:
					j1 = Jugadors.definirjugador();
					Joc.inicialitzar(j1, tauler);
					Joc.mostrar(tauler);
					Joc.jugada(tauler, j1, j2);//aqui es jugada contra bot es diferent a jugada normal cal crear una altra funcio
					break;
				}
				break;
			case 4:
				Jugadors.veureJugador(j1, j2);
				break;
			case 0:
				break;

			default:
				System.out.print("Opció incorrecte");
			}
		} while (a != 0);
		System.out.println("Adeu");
	}

	static void menu() {
		System.out.println("1.- Mostrar Ajuda");
		System.out.println("2.- Definir Jugadors");
		System.out.println("3.- Jugar Partida");
		System.out.println("4.- Veure Jugadors");
		System.out.println("0.- Sortir");
		return;

	}

	public static void menu2() {
		System.out.println("1.- 1vs1");
		System.out.println("2.- 1vsCPU");
	}

}
