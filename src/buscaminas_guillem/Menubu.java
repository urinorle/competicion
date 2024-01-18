package buscaminas_guillem;

import java.util.Scanner;

import tresenratlla.Jugadors;

public class Menubu {
	static Scanner sc = new Scanner(System.in);
	static final int mesura = (Integer) null;

	public static void main(String[] args) {

		Players j1 = null;
		Players j2 = null;

		int a;

		do {
			menu();
			a = sc.nextInt();
			switch (a) {
			case 1:

				break;
			case 2:
				menu2();
				int b = sc.nextInt();
				do {
					switch (b) {
					case 1:
						Players.definirjugador();
						break;
					case 2:
						Players.definirjugador();
						break;
					case 3:
						Players.definirjugador();
						break;
					case 4:
						Players.definirjugador();
						break;
					case 0:
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
