package buscaminas_guillem;

import java.util.Scanner;

public class Menubu {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException {
		int x = 0;
		int y = 0;
		int mines = 0;

		Players j1 = null;

		int a;

		do {
			menu();
			a = sc.nextInt();
			if (a < 0 || a > 4) {
				do {
					System.out.println("Escull una opcio correcte: ");
					a = sc.nextInt();
				} while (a < 0 || a > 4);
			}
			switch (a) {
			case 1:
				Ajuda.ajuda(args);
				break;
			case 2:
				menu2();
				int b = sc.nextInt();
				do {
					if (b < 0 || b > 4) {
						do {
							System.out.println("Escull una opcio correcte: ");
							b = sc.nextInt();
						} while (b < 0 || b > 4);
					}
					switch (b) {
					case 1:
						x = 8;
						y = 8;
						mines = 10;
						Game.inicializar(x, y, mines);
						Game.mostrar(null, null, b, b);
						j1 = Players.definirjugador();
						break;
					case 2:
						x = 20;
						j1 = Players.definirjugador();
						break;
					case 3:
						j1 = Players.definirjugador();
						break;
					case 4:
						j1 = Players.definirjugador();
						break;
					case 0:
						break;
					}

				} while (b != 0);
				break;
			case 3:
				break;
			case 4:
				Players.veureJugador(j1);
				break;
			case 0:
				break;
			}
		} while (a != 0);

	}

	private static void menu() {
		System.out.println("1.- Mostrar Ajuda");
		System.out.println("2.- Opcions");
		System.out.println("3.- Jugar Partida");
		System.out.println("4.- Veure Ranking");
		System.out.println("0.- Sortir");

	}

	private static void menu2() {
		System.out.println("1.- Nivel principiant: 8 x 8 caselles i 10 mines");
		System.out.println("2.- Nivel intermig: 16 x 16 caselles i 40 mines");
		System.out.println("3.- Nivel expert: 16 x  30 caselles i 99 mines");
		System.out.println("4.- Nivel personalitzat");
		System.out.println("0.- Sortir");

	}
}
