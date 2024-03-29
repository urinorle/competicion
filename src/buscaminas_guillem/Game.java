package buscaminas_guillem;

import java.util.Random;

public class Game {
	public static void inicializar(int x, int y, int mines, char[][] secret, char[][] tauler) {
		Random rd = new Random();

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				tauler[i][j] = '⬜';
			}
		}
		char Bomba = 'B';
		char SinBombas = '◾';
		int contador = 0;

		while (contador != mines) {

			int Bx = rd.nextInt(x);
			int By = rd.nextInt(y);
			if (secret[Bx][By] != Bomba) {
				secret[Bx][By] = Bomba;
				contador++;
			}
		}
		mostrar(tauler, x, y);

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (secret[i][j] != Bomba) {
					int bombasCercanas = contarBombasCercanas(secret, i, j, x, y);
					if (bombasCercanas > 0) {
						secret[i][j] = (char) (bombasCercanas + '0');
					} else {
						secret[i][j] = SinBombas;
					}
				}
			}
		}
		mostrarsecret(secret, x, y);
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

	public static void mostrar(char[][] tauler, int x, int y) {
		if (y < 10) {
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					if (j == 0 && i <= 9) {
						System.out.print(i + "  " + tauler[i][j] + " ");
					} else if (j == 0 && i >= 10) {
						System.out.print(i + " " + tauler[i][j] + " ");
					} else if (j < 10) {
						System.out.print(tauler[i][j] + " ");
					} else {
						System.out.print(tauler[i][j] + "  ");
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
						System.out.print(i + "  " + tauler[i][j] + "  ");
					} else if (j == 0 && i >= 10) {
						System.out.print(i + " " + tauler[i][j] + "  ");
					} else if (j < 10) {
						System.out.print(tauler[i][j] + "  ");
					} else {
						System.out.print(tauler[i][j] + "  ");
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

	public static void mostrarsecret(char[][] secret, int x, int y) {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				System.out.print(secret[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static boolean destaparcaselles(char[][] tauler, char[][] secret, int filasel, int columnasel, boolean win,
			int mines) {

		int contador = 0;
		int numfil = tauler.length;
		int numcol = tauler[0].length;
		for (int i = 0; i < numfil; i++) {
			for (int j = 0; j < numcol; j++) {
				if (tauler[i][j] == '⬜') {
					contador++;
				}
			}

		}
		if (contador == mines) {
			win = true;
			System.out.println("Has guanyat!!!");
			return win;
		}

		return win;

	}

	public static boolean destaparbomba(char[][] tauler, char[][] secret, int filasel, int columnasel, boolean bombadet,
			int mines) {

		if (secret[filasel][columnasel] == 'B') {
			bombadet = true;
			System.out.println("Has perdut!!!");
			return bombadet;
		}

		return bombadet;

	}

	public static void recursivitat(char[][] tablero, char[][] secreto, int filaSeleccionada,
			int columnaSeleccionada) {
		int numFil = tablero.length;
		int numCol = tablero[0].length;
		if (tablero[filaSeleccionada][columnaSeleccionada] == '⬜' && filaSeleccionada >= 0 && filaSeleccionada < numFil
				&& columnaSeleccionada >= 0 && columnaSeleccionada < numCol) {
			char secretoActual = secreto[filaSeleccionada][columnaSeleccionada];

			if (secretoActual >= '1' && secretoActual <= '8') {
				tablero[filaSeleccionada][columnaSeleccionada] = secretoActual;

			} else if (secretoActual == 'B') {
				tablero[filaSeleccionada][columnaSeleccionada] = secretoActual;

			} else if (secretoActual == '◾') {

				tablero[filaSeleccionada][columnaSeleccionada] = secretoActual;
				
				if (filaSeleccionada + 1 < numFil) {
					recursivitat(tablero, secreto, filaSeleccionada + 1, columnaSeleccionada);
				}

				if (columnaSeleccionada + 1 < numCol) {
					recursivitat(tablero, secreto, filaSeleccionada, columnaSeleccionada + 1);
				}

				if (filaSeleccionada - 1 >= 0) {
					recursivitat(tablero, secreto, filaSeleccionada - 1, columnaSeleccionada);
				}

				if (columnaSeleccionada - 1 >= 0) {
					recursivitat(tablero, secreto, filaSeleccionada, columnaSeleccionada - 1);
				}

				if (filaSeleccionada - 1 >= 0 && columnaSeleccionada - 1 >= 0) {
					recursivitat(tablero, secreto, filaSeleccionada - 1, columnaSeleccionada - 1);
				}

				if (filaSeleccionada - 1 >= 0 && columnaSeleccionada + 1 < numCol) {
					recursivitat(tablero, secreto, filaSeleccionada - 1, columnaSeleccionada + 1);
				}

				if (filaSeleccionada + 1 < numFil && columnaSeleccionada - 1 >= 0) {
					recursivitat(tablero, secreto, filaSeleccionada + 1, columnaSeleccionada - 1);
				}

				if (filaSeleccionada + 1 < numFil && columnaSeleccionada + 1 < numCol) {
					recursivitat(tablero, secreto, filaSeleccionada + 1, columnaSeleccionada + 1);
				}

			}
		}
	}

	public static int lvl(boolean bombadet, boolean win, boolean lvl1, boolean lvl2, boolean lvl3, boolean lvl4, Players j1, Players j2, Players j3,
			Players j4) {
		if (lvl1 == true) {
			if (win == true) {
				j1.exp += 1;
				if (j1.exp >= 10) {
					j1.exp++;
				}
			}
			if (bombadet == true) {
				j1.exp += 0;
				if (j1.exp >= 10) {
					j1.exp++;
				}
			}
		}
		if (lvl2 == true) {
			if (win == true) {
				j1.exp += 2;
				if (j1.exp >= 10) {
					j1.exp++;
				}
			}
			if (bombadet == true) {
				j1.exp += 1;
				if (j1.exp >= 10) {
					j1.exp++;
				}
			}
		}
		if (lvl3 == true) {
			if (win == true) {
				j1.exp += 4;
				if (j1.exp >= 10) {
					j1.exp++;
				}
			}
			if (bombadet == true) {
				j1.exp += 3;
				if (j1.exp >= 10) {
					j1.exp++;
				}
			}
		}
		if (lvl4 == true) {
			if (win == true) {
				j1.exp += 50;
				if (j1.exp >= 10) {
					j1.exp++;
				}
			}
			if (bombadet == true) {
				j1.exp += 4;
				if (j1.exp >= 10) {
					j1.exp++;
				}
			}
			return j1.lvl;
		}
		return j1.lvl;

	}

}