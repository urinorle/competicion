package buscaminasMohamedZekhniniAbjij;

import java.util.Random;

public class PROGRAMA {
	public static Random rd = new Random();

	public static void inicializarSecreto(int x, int y, int mines, char[][] secreto) {

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
			for (int i = 0; i <= 9; i++) {
				System.out.print(i + "  ");
			}
			for (int i = 10; i < y; i++) {
				System.out.print(i + " ");
			}
			System.out.println();

		}
	}

	public static void mostrarSecreto(int x, int y, char[][] secreto) {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				System.out.print(secreto[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public static boolean comprobarSiHemosGanado(char[][] tablero, char[][] secreto, int filasel, int columnasel,
			boolean win, int mines) {
		if (secreto[filasel][columnasel] >= '1' && secreto[filasel][columnasel] <= '8'
				|| secreto[filasel][columnasel] == '◾') {

			int contador = 0;
			int numfil = tablero.length;
			int numcol = tablero[0].length;
			/*-------------------------------------------------*/
			for (int i = 0; i < numfil; i++) {
				for (int j = 0; j < numcol; j++) {
					if (tablero[i][j] == '⬜') {
						contador++;
					}
				}
			}
			/*-------------------------------------------------*/
			if (contador == mines) {
				win = true;
				System.err.println("HAS GUANYAT!!");
				System.out.println(" ");
			}
			/*-------------------------------------------------*/
		}

		return win;
	}

	public static boolean comprobarBombaExplotada(char[][] tablero, char[][] secreto, int filasel, int columnasel,
			boolean bombaDetected, int mines) {

		if (secreto[filasel][columnasel] == 'B') {
			bombaDetected = true;
			System.out.println("HAS PERDUT!!");
			System.out.println();
			PROGRAMA.vaciarSecretoYTablero(secreto, tablero);
			PROGRAMA.inicializarSecreto((tablero.length), (tablero[0].length), mines, secreto);
			return bombaDetected;
		}

		return bombaDetected;
	}

	private static void vaciarSecretoYTablero(char[][] secreto, char[][] tablero) {
		int x = secreto.length;
		int y = secreto[0].length;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				secreto[i][j] = ' ';
				tablero[i][j] = '⬜';
			}
		}
	}

	public static void destaparCasilla(char[][] tablero, char[][] secreto, int filaSeleccionada,
			int columnaSeleccionada) {
		int numFil = tablero.length;
		int numCol = tablero[0].length;
		if (tablero[filaSeleccionada][columnaSeleccionada] == '⬜' && 
				filaSeleccionada >= 0 && 
				filaSeleccionada < numFil
				&& columnaSeleccionada >= 0 && 
				columnaSeleccionada < numCol) {
			char secretoActual = secreto[filaSeleccionada][columnaSeleccionada];

			if (secretoActual >= '1' && secretoActual <= '8') {
				tablero[filaSeleccionada][columnaSeleccionada] = secretoActual;

			} else if (secretoActual == 'B') {
				tablero[filaSeleccionada][columnaSeleccionada] = secretoActual;

			} else if (secretoActual == '◾') {

				tablero[filaSeleccionada][columnaSeleccionada] = secretoActual;
				
				if (filaSeleccionada + 1 < numFil) {
					destaparCasilla(tablero, secreto, filaSeleccionada + 1, columnaSeleccionada);
				}

				if (columnaSeleccionada + 1 < numCol) {
					destaparCasilla(tablero, secreto, filaSeleccionada, columnaSeleccionada + 1);
				}

				if (filaSeleccionada - 1 >= 0) {
					destaparCasilla(tablero, secreto, filaSeleccionada - 1, columnaSeleccionada);
				}

				if (columnaSeleccionada - 1 >= 0) {
					destaparCasilla(tablero, secreto, filaSeleccionada, columnaSeleccionada - 1);
				}

				if (filaSeleccionada - 1 >= 0 && columnaSeleccionada - 1 >= 0) {
					destaparCasilla(tablero, secreto, filaSeleccionada - 1, columnaSeleccionada - 1);
				}

				if (filaSeleccionada - 1 >= 0 && columnaSeleccionada + 1 < numCol) {
					destaparCasilla(tablero, secreto, filaSeleccionada - 1, columnaSeleccionada + 1);
				}

				if (filaSeleccionada + 1 < numFil && columnaSeleccionada - 1 >= 0) {
					destaparCasilla(tablero, secreto, filaSeleccionada + 1, columnaSeleccionada - 1);
				}

				if (filaSeleccionada + 1 < numFil && columnaSeleccionada + 1 < numCol) {
					destaparCasilla(tablero, secreto, filaSeleccionada + 1, columnaSeleccionada + 1);
				}

			}
		}
	}

}
