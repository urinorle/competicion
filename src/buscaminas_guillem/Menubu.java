package buscaminas_guillem;

import java.util.Scanner;

public class Menubu {
	static Scanner sc = new Scanner(System.in);

	static Players j1 = null;
	static Players j2 = null;
	static Players j3 = null;
	static Players j4 = null;

	public static void main(String[] args) throws InterruptedException {
		int x = 0;
		int y = 0;
		int mines = 0;
		char[][] tauler = null;
		char[][] secret = null;
		boolean lvl1 = false;
		boolean lvl2 = false;
		boolean lvl3 = false;
		boolean lvl4 = false;

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
						lvl1 = true;
						x = 8;
						y = 8;
						mines = 10;
						tauler = new char[x][y];
						secret = new char[x][y];
						escollirJugador();
						Game.inicializar(x, y, mines, secret, tauler);
						Jugar.jugar(tauler, secret, x, y, mines, lvl1, lvl2, lvl3, lvl4, j1, j2, j3, j4);
						b = 0;
						break;
					case 2:
						lvl2 = true;
						x = 16;
						y = 16;
						mines = 40;
						tauler = new char[x][y];
						secret = new char[x][y];
						escollirJugador();
						Game.inicializar(x, y, mines, secret, tauler);
						Jugar.jugar(tauler, secret, x, y, mines, lvl1, lvl2, lvl3, lvl4, j1, j2, j3, j4);
						b = 0;
						break;
					case 3:
						lvl3 = true;
						x = 16;
						y = 30;
						mines = 99;
						tauler = new char[x][y];
						secret = new char[x][y];
						escollirJugador();
						Game.inicializar(x, y, mines, secret, tauler);
						Jugar.jugar(tauler, secret, x, y, mines, lvl1, lvl2, lvl3, lvl4, j1, j2, j3, j4);
						b = 0;
						break;
					case 4:
						lvl4 = true;
						escollirJugador();
						System.out.println("Escull el nombre de files: ");
						x = sc.nextInt();
						System.out.println("Escull el nombre de columnes: ");
						y = sc.nextInt();
						System.out.println("Escull el nombre de mines: ");
						mines = sc.nextInt();
						tauler = new char[x][y];
						secret = new char[x][y];
						Game.inicializar(x, y, mines, secret, tauler);
						Jugar.jugar(tauler, secret, x, y, mines, lvl1, lvl2, lvl3, lvl4, j1, j2, j3, j4);
						j1 = Game.lvl(lvl4, lvl4, lvl1, lvl2, lvl3, lvl4, j1, j2, j3, j4);
						b = 0;
						break;
					case 0:
						break;
					}

				} while (b != 0);
				break;
			case 3:
				break;
			case 4:
				Players.veureJugador(j1, j2, j3, j4);
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

	private static void escollirJugador() {
		System.out.println("1.- Jugador 1");
		System.out.println("2.- Jugador 2");
		System.out.println("3.- Jugador 3");
		System.out.println("4.- Jugador 4");
		int c = 0;
		c = sc.nextInt();
		if (c == 1) {
			if (j1 == null) {
				j1 = Players.definirjugador();
			} else {
				System.out.println(j1.nom);
			}

		}

		if (c == 2) {
			if (j2 == null) {
				j2 = Players.definirjugador();
			} else {
				System.out.println(j2.nom);
			}
		}

		if (c == 3) {
			if (j3 == null) {
				j3 = Players.definirjugador();
			} else {
				System.out.println(j3.nom);
			}
		}

		if (c == 4) {
			if (j4 == null) {
				j4 = Players.definirjugador();
			} else {
				System.out.println(j4.nom);
			}
		}

	}
}
