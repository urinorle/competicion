package buscaminas_guillem;

import java.util.Scanner;

public class Jugar {
	public static Scanner sc = new Scanner(System.in);
	
	public static void jugar(char[][] tauler, char[][] secret, int x, int y, int mines) {
		boolean bombadet = false;
		boolean win = false;
		
		do {
			Game.mostrar(tauler, x, y);
			System.out.println("Digues la fila: ");
			int filasel = sc.nextInt();
			System.out.println("Digues una columna: ");
			int columnasel = sc.nextInt();
			Game.destaparcaselles(tauler, secret, filasel, columnasel, bombadet, win, mines);
		} while (!bombadet || !win);
		
		if (bombadet == true) {
			System.out.println("Has perdut!!!");
			Game.mostrar(tauler, x, y);
		}
		if (win == true) {
			System.out.println("Has guanyat!!!");
			Game.mostrar(tauler, x, y);
		}
		

	}
}
