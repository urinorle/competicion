package buscaminasMohamedZekhniniAbjij;

import java.util.Scanner;

import buscaminas_guillem.Players;

public class MENU {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int a;
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
					switch (b) {
					case 1:
						
						break;
					case 2:
						
						break;
					case 3:
						
						break;
					case 4:
						
						break;
					case 0:
						break;
					}
					if (a < 0 || a > 4) {
						System.out.println("Escull una opcio correcte: ");
						break;
					}
				} while (b != 0);
				break;
			case 3:
				break;
			case 4:
				break;
			case 0:
				break;
			}
			if (a < 0 || a > 4) {
				System.out.println("Escull una opcio correcte: ");
				break;
			}
		} while (a != 0);
		
	}

	private static void menuDificultats() {
		System.out.println("1.- Nivell principiant: 8 x 8 caselles i 10 mines");
		System.out.println("2.- Nivell intermig: 16 x 16 caselles i 40 mines");
		System.out.println("3.- Nivell expert: 16 x  30 caselles i 99 mines");
		System.out.println("4.- Nivell personalitzat");
	}

	private static void menu() {
		System.out.println("1.- Mostrar Ajuda");
		System.out.println("2.- Opcions");
		System.out.println("3.- Jugar Partida");
		System.out.println("4.- Veure Ranking");
		System.out.println("0.- Sortir");

	}

}
