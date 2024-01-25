package buscaminasMohamedZekhniniAbjij;

import java.util.Scanner;

public class JUGAR {
	public static Scanner sc = new Scanner(System.in);

	public static void jugar(int x, int y, char[][] tablero, char[][] secreto, int mines) {
		boolean bombaDetected = false;
		boolean win = false;
		PROGRAMA.mostrarTablero(x, y, tablero);
		do {
			System.out.println("Digues la fila de la casella a destapar");
			int filaSeleccionada = sc.nextInt();
			System.out.println("Digues la columna de la casella a destapar");
			int columnaSeleccionada = sc.nextInt();
			if (filaSeleccionada < 0 || filaSeleccionada >= x || columnaSeleccionada < 0 || columnaSeleccionada >= y) {
				System.out.println("Fixa't bé, has introduït una dada invàlida");
			} else {
				PROGRAMA.destaparCasilla(tablero, secreto, filaSeleccionada, columnaSeleccionada);

				PROGRAMA.mostrarTablero(x, y, tablero);

				bombaDetected = PROGRAMA.comprobarBombaExplotada(tablero, secreto, filaSeleccionada,
						columnaSeleccionada, bombaDetected, mines);

				win = PROGRAMA.comprobarSiHemosGanado(tablero, secreto, filaSeleccionada, columnaSeleccionada, win,
						mines);
			}

		} while (bombaDetected == false && win == false);

	}
}
