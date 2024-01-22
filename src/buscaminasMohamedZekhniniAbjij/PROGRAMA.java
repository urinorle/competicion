package buscaminasMohamedZekhniniAbjij;

import java.util.Random;

public class PROGRAMA {
	public static Random rd = new Random();
	public static char[][] secreto = new char[0][0];

	public static void inicializarSecreto(int x, int y, int mines, char[][] tablero) {

		secreto = new char[x][y];
		char Bomba = 'B';
		char SinBombas = '◾';
		int contador = 0;

		while (contador != mines) {

			int Bx = rd.nextInt(x);
			int By = rd.nextInt(y);
			if (secreto[Bx][By] != Bomba) {
				secreto[Bx][By] = Bomba;
				contador++;
			}
		}

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (secreto[i][j] != Bomba) {
					int bombasCercanas = contarBombasCercanas(secreto, i, j, x, y);
					if (bombasCercanas > 0) {
						secreto[i][j] = (char) (bombasCercanas + '0');
					} else if (bombasCercanas == 0) {
						secreto[i][j] = SinBombas;
					}
				}
			}
		}

	}

	private static int contarBombasCercanas(char[][] secret, int fila, int columna, int x, int y) {
		int contador = 0;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				int nuevaFila = fila + i;
				int nuevaColumna = columna + j;
				if (nuevaFila >= 0 && nuevaFila < x && nuevaColumna >= 0 && nuevaColumna < y
						&& secret[nuevaFila][nuevaColumna] == 'B') {
					contador++;
				}
			}
		}
		return contador;
	}

	public static void inicializarTablero(int x, int y, char[][] tablero) {

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				tablero[i][j] = '⬜';
			}
		}

	}

	public static void mostrarTablero(int x, int y, char[][] tablero) {
		if (y < 10) {
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					if (j == 0 && i <= 9) {
						System.out.print(i + "  " + tablero[i][j] + " ");
					} else if (j == 0 && i >= 10) {
						System.out.print(i + " " + tablero[i][j] + " ");
					} else if (j < 10) {
						System.out.print(tablero[i][j] + " ");
					} else {
						System.out.print(tablero[i][j] + "  ");
					}

				}
				System.out.println("");
			}
			System.out.println();
			System.out.print("   ");
			for (int i = 0; i < y; i++) {
				System.out.print(i + " ");
			}
			System.out.println();
		} else {
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					if (j == 0 && i <= 9) {
						System.out.print(i + "  " + tablero[i][j] + "  ");
					} else if (j == 0 && i >= 10) {
						System.out.print(i + " " + tablero[i][j] + "  ");
					} else if (j < 10) {
						System.out.print(tablero[i][j] + "  ");
					} else {
						System.out.print(tablero[i][j] + "  ");
					}

				}
				System.out.println("");
			}
			System.out.println();
			System.out.print("   ");
			for (int i = 0; i <= 9; i++) {
				System.out.print(i + "  ");
			}
			for (int i = 10; i < y; i++) {
				System.out.print(i + " ");
			}
			System.out.println();

		}
	}

	public static void mostrarSecreto(int x, int y, char[][] tablero) {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				System.out.print(secreto[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public static boolean destaparCasilla(char[][] tablero, char[][] secreto2, int filaSeleccionada,
			int columnaSeleccionada, boolean bombaDetected, boolean win, int mines) {
		if (secreto2[filaSeleccionada][columnaSeleccionada] >= '1'
				&& secreto2[filaSeleccionada][columnaSeleccionada] <= '8') {
			tablero[filaSeleccionada][columnaSeleccionada] = secreto2[filaSeleccionada][columnaSeleccionada];
		}
		if (secreto2[filaSeleccionada][columnaSeleccionada] == 'B') {

			tablero[filaSeleccionada][columnaSeleccionada] = secreto2[filaSeleccionada][columnaSeleccionada];
			bombaDetected = true;
		}
		if (secreto2[filaSeleccionada][columnaSeleccionada] == '◾') {
			tablero[filaSeleccionada][columnaSeleccionada] = secreto2[filaSeleccionada][columnaSeleccionada];
			/*RECURSIVIDAD*/
		}
		int contador = 0;
		int numFiles = tablero.length;
		int numColumnes = tablero[0].length;
		for (int i = 0; i < numFiles; i++) {
			for (int j = 0; j < numColumnes; j++) {
				if (tablero[i][j] == '⬜') {
					contador++;
				}
			}
		}
		if (contador == mines) {
			win = true;
		}
		return (bombaDetected || win);

	}

}
