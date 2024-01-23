package buscaminas_guillem;

import java.util.Scanner;

public class Jugar {
	public static Scanner sc = new Scanner(System.in);
	
	public static void jugar(char[][] tauler, char[][] secret, int x, int y, int mines, boolean lvl1, boolean lvl2, boolean lvl3, boolean lvl4, Players j1, Players j2, Players j3, Players j4) {
		boolean bombadet = false;
		boolean win = false;
		
		do {
			Game.mostrar(tauler, x, y);
			System.out.println("Digues la fila: ");
			int filasel = sc.nextInt();
			System.out.println("Digues una columna: ");
			int columnasel = sc.nextInt();
			
			Game.recursivitat(tauler, secret, filasel, columnasel);
			
			bombadet = Game.destaparbomba(tauler, secret, filasel, columnasel, bombadet, mines);
			win = Game.destaparcaselles(tauler, secret, filasel, columnasel, win, mines);
		} while (bombadet == false && win == false);
		
		Game.lvl(bombadet, win, lvl1, lvl2, lvl3, lvl4, j1, j2, j3, j4);

	}
}
