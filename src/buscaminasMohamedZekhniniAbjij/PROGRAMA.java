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
					} else {
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

	public static void mostrarSecreto(int x, int y) {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				System.out.print(secreto[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public static boolean verificarSiQuedanCasillasPorDestapar(int x, int y, char[][] tablero) {
		boolean hayCasillasSinAbrir = false;
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				if (tablero[i][j] == '⬜') {
					hayCasillasSinAbrir = true;
				}
			}
		}
		return hayCasillasSinAbrir;
	}

	public static void destaparCasilla(int x, int y, char[][] tablero, char[][] secreto2, boolean bombaDetected2,
			int mines) {
		int filas = secreto.length;
		int columnas = secreto[0].length;
		boolean bombaDetected = false;

		if (x < 0 || x >= filas || y < 0 || y >= columnas) {

		}

		if (tablero[x][y] != 0) {

		}

		if (secreto[x][y] >= '1' && secreto[x][y] <= '8') {
			tablero[x][y] = secreto[x][y];
		} else if (secreto[x][y] == '◾') {
			tablero[x][y] = secreto[x][y];

			destaparCasilla((x + 1), y, tablero, secreto, bombaDetected, mines);
			destaparCasilla((x - 1), y, tablero, secreto, bombaDetected, mines);
			destaparCasilla(x, (y + 1), tablero, secreto, bombaDetected, mines);
			destaparCasilla(x, (y - 1), tablero, secreto, bombaDetected, mines);
		} else if (secreto[x][y] == 'B') {
			tablero[x][y] = secreto[x][y];
			System.out.println("HAS TREPITJAT UNA MINA, joc finalitzat");
			PROGRAMA.mostrarTablero(x, y, tablero);
			System.out.println();
			PROGRAMA.inicializarTablero(x, y, tablero);
			PROGRAMA.inicializarSecreto(x, y, mines, tablero);
			bombaDetected = true;
		}
	}

}
