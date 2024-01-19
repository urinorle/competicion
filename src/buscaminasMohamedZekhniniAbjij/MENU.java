package buscaminasMohamedZekhniniAbjij;

import java.util.Scanner;

public class MENU {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int a;
		boolean haElegidoNivel = false;
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
				menuDificultats();
				int b = sc.nextInt();
				do {
					int x, y, mines;
					switch (b) {
					case 1:
						x = 8;
						y = 8;
						mines = 10;
						PROGRAMA.inicializarSecreto(x,y,mines);
						haElegidoNivel = true;
						break;
					case 2:
						x = 16;
						y = 16;
						mines = 40;
						haElegidoNivel = true;
						break;
					case 3:
						x = 16;
						y = 30;
						mines = 99;
						haElegidoNivel = true;
						break;
					case 4:
						System.out.println("Quantes fileres tindrà el mapa?");
						x = sc.nextInt();
						System.out.println("Quantes columnes tindrà el mapa?");
						y = sc.nextInt();
						System.out.println("I quantes mines enterrem?");
						mines = sc.nextInt();
						haElegidoNivel = true;
						break;
					case 0:
						haElegidoNivel = false;
						break;
					default:
						System.out.println("Escull una opcio correcte: ");
						System.out.println("");
						break;
					}
				} while (b > 4 && b < 0);
				break;
			case 3:
				if (haElegidoNivel) {
					/* Jugar */
				} else {
					System.out.println("Abans has de seleccionar un nivell");
					System.out.println();
				}
				break;
			case 4:
				if (haElegidoNivel) {
					/* Mostrar ranking */
				} else {
					System.out.println("Abans has de jugar");
					System.out.println();
				}
				break;
			case 0:
				break;
			default:
				System.out.println("Escull una opcio correcte: ");
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
		System.out.println("4.➡️ Veure Ranking");
		System.out.println("0.➡️ Sortir");

	}

}
