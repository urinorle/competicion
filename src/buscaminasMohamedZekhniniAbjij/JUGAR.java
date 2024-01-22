package buscaminasMohamedZekhniniAbjij;

import java.util.Scanner;

public class JUGAR {
	public static Scanner sc = new Scanner(System.in);

	public static void jugar(int x, int y, char[][] tablero, char[][] secreto, int mines) {
		boolean bombaDetected = false;
		boolean win = false;

		do {
			PROGRAMA.mostrarTablero(x, y, tablero);
			System.out.println("Digues la fila de la casella a destapar");
			int filaSeleccionada = sc.nextInt();
			System.out.println("Digues la columna de la casella a destapar");
			int columnaSeleccionada = sc.nextInt();
			PROGRAMA.destaparCasilla(tablero, secreto, filaSeleccionada, columnaSeleccionada, bombaDetected, win, mines);
		} while (!bombaDetected || !win);
		if (bombaDetected == true) {
			System.out.println("HAS PERDUT");
			PROGRAMA.mostrarTablero(x, y, tablero);
		}
		if (win == true) {
			System.out.println("HAS GUANYAT");
			PROGRAMA.mostrarSecreto(x, y, tablero);
		}

	}
}
