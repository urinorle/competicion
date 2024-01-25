package buscaminasMohamedZekhniniAbjij;

import java.util.Scanner;

public class MENU {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int a;
		int x = 0, y = 0, mines = 0;
		boolean haElegidoNivel = false;
		char[][] tablero = null;
		char[][] secreto = null;
		do {
			menu();
			a = sc.nextInt();
			switch (a) {
			case 1:
				try {
					AJUDA.main(args);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				boolean salirDificultades = false;
				int b;
				do {
					menuDificultats();
					b = sc.nextInt();
					switch (b) {
					case 1:
						x = 8;
						y = 8;
						mines = 10;
						tablero = new char[x][y];
						secreto = new char[x][y];
						PROGRAMA.inicializarSecreto(x, y, mines, secreto);
						PROGRAMA.inicializarTablero(x, y, tablero);
						haElegidoNivel = true;
						break;
					case 2:
						x = 16;
						y = 16;
						mines = 40;
						tablero = new char[x][y];
						secreto = new char[x][y];
						PROGRAMA.inicializarSecreto(x, y, mines, secreto);
						PROGRAMA.inicializarTablero(x, y, tablero);
						haElegidoNivel = true;
						break;
					case 3:
						x = 16;
						y = 30;
						mines = 99;
						tablero = new char[x][y];
						secreto = new char[x][y];
						PROGRAMA.inicializarSecreto(x, y, mines, secreto);
						PROGRAMA.inicializarTablero(x, y, tablero);
						haElegidoNivel = true;
						break;
					case 4:
						System.out.println("Quantes fileres tindrà el mapa?");
						x = sc.nextInt();
						System.out.println("Quantes columnes tindrà el mapa?");
						y = sc.nextInt();
						System.out.println("I quantes mines enterrem?");
						mines = sc.nextInt();
						tablero = new char[x][y];
						secreto = new char[x][y];
						PROGRAMA.inicializarSecreto(x, y, mines, secreto);
						PROGRAMA.inicializarTablero(x, y, tablero);
						haElegidoNivel = true;
						break;
					case 0:
						haElegidoNivel = false;
						break;
					default:
						System.out.println("Si us plau, escull una opció correcte: ");
						System.out.println();
						break;
					}
				} while (!salirDificultades && (b < 0 || b > 4));
				break;
			case 3:
				if (haElegidoNivel) {
					JUGAR.jugar(x, y, tablero, secreto, mines);
				} else {
					System.out.println("Abans has de seleccionar un nivell");
					System.out.println();
				}
				break;
			case 0:
				break;
			default:
				System.out.println("Si us plau, escull una opció correcte: ");
				System.out.println();
				break;
			}
		} while (a != 0);
	}

	private static void menuDificultats() {
		System.out.println("1.➡️ Nivell principiant: 8 x 8 caselles i 10 mines");
		System.out.println("2.➡️ Nivell intermig: 16 x 16 caselles i 40 mines");
		System.out.println("3.➡️ Nivell expert: 16 x  30 caselles i 99 mines");
		System.out.println("4.➡️ Nivell personalitzat");
		System.out.println("0.🔙 Tornar enrere");
	}

	private static void menu() {
		System.out.println("1.➡️ Mostrar Ajuda");
		System.out.println("2.➡️ Escollir nivell");
		System.out.println("3.➡️ Jugar Partida");
		System.out.println("0.➡️ Sortir");
	}

	public static int[] menuJugar() {
		System.out.println("Digues quina casella vols trepitjar.");
		System.out.println("Escull fila:");
		int filaAdestapar = sc.nextInt();
		System.out.println("Escull columna:");
		int columnaAdestapar = sc.nextInt();

		int[] coordenadas = { filaAdestapar, columnaAdestapar };
		return coordenadas;
	}
}
