package examenJavaGuillemFuncions;

import java.util.Random;
import java.util.Scanner;

public class Partida {

	public static Scanner sc = new Scanner(System.in);
	public static Random rd = new Random();

	static int inicialitzar(int[][] tauler, int TAMANY) {
		for (int i = 0; i < TAMANY; i++) {
			for (int j = 0; j < TAMANY; j++) {
				tauler[i][j] = 0;
			}
		}
		return TAMANY;
	}

	static void mostrar(int[][] tauler, int TAMANY) {
		for (int i = 0; i < TAMANY; i++) {
			for (int j = 0; j < TAMANY; j++) {
				System.out.print(tauler[i][j] + " ");
			}
			System.out.println();
		}

	}

	static boolean posarcreu(int[][] tauler) {
		for (int i = 0; i < tauler.length; i++) {
			System.out.println();
			for (int j = 0; j < tauler.length; j++) {
				System.out.print(tauler[i][j] + " ");
			}
		}
		System.out.println();
		int x = 0;
		int y = 0;
		System.out.println("Introdueix la posicio: ");
		x = sc.nextInt();
		y = sc.nextInt();
		if (x == 0 || x == tauler.length - 1 || y == 0 || y == tauler.length - 1) {
			System.out.println("No pots posar una creu aqui!!!");
			return false;
		} else if (tauler[x][y] == 0) {
			if (x > 0 && tauler[x - 1][y] == 0) {
				tauler[x - 1][y] = 1;
			}
			if (x < tauler.length - 1 && tauler[x + 1][y] == 0) {
				tauler[x + 1][y] = 1;
			}
			if (y > 0 && tauler[x][y - 1] == 0) {
				tauler[x][y - 1] = 1;
			}
			if (y < tauler.length - 1 && tauler[x][y + 1] == 0) {
				tauler[x][y + 1] = 1;
			}
			tauler[x][y] = 1;
			return true;
		} else {
			System.out.println("Ja hi ha una creu posada");
			return false;
		}
	}

	static boolean posarncreus(int[][] tauler) {
		System.out.println("Digues el nombre de creus: ");
		int n = sc.nextInt();
		if (n > 0 && n < (tauler.length * tauler.length / 5)) {
			for (int i = 0; i < n; i++) {
				int x, y;
				do {
					x = 1 + rd.nextInt(tauler.length - 2);
					y = 1 + rd.nextInt(tauler.length - 2);
				} while (tauler[x][y] != 0 || !posiblecreu(tauler, x, y));
				posar(tauler, x, y);
			}
			return true;
		} else {
			System.out.println("El numero de creus es incorrecte");
			return false;
		}
	}

	static boolean posiblecreu(int[][] tauler, int x, int y) {
		return tauler[x - 1][y] == 0 && tauler[x + 1][y] == 0 && tauler[x][y - 1] == 0 && tauler[x][y + 1] == 0;
	}

	static void posar(int[][] tauler, int x, int y) {
		tauler[x - 1][y] = 1;
		tauler[x + 1][y] = 1;
		tauler[x][y - 1] = 1;
		tauler[x][y + 1] = 1;
		tauler[x][y] = 1;
	}

	static boolean creu(int[][] tablero) {
		int x = 0;
		int y = 0;
		System.out.println("Indica les coordenades de la creu: ");
		x = sc.nextInt();
		y = sc.nextInt();
		if ((x == 0 || x == tablero.length - 1 || y == 0 || y == tablero.length - 1)
				|| (x > 0 && tablero[x][y] == 1 && tablero[x - 1][y] == 1 && tablero[x + 1][y] == 1
						&& tablero[x][y - 1] == 1 && tablero[x][y + 1] == 1)) {
			System.out.println("Creu!!!");
			return true;
		} else {
			System.out.println("No hi ha una creu");
			return false;
		}
	}

	static int comptarrcreus(int[][] tauler) {
		int cont = 0;
		for (int i = 1; i < tauler.length - 1; i++) {
			for (int j = 1; j < tauler[i].length - 1; j++) {
				if (tauler[i][j] == 1 && tauler[i - 1][j] == 1 && tauler[i + 1][j] == 1 && tauler[i][j - 1] == 1
						&& tauler[i][j + 1] == 1) {
					cont++;
				}
			}
		}
		return cont;
	}

	static void copiar(int[][] tauler, int[][] copia) {
		
		for (int i = 0; i < tauler.length; i++) {
			for (int j = 0; j < tauler.length; j++) {
				copia[i][j] = tauler[i][j];
			}
		}

		for (int i = 0; i < tauler.length; i++) {
			for (int j = 0; j < tauler.length; j++) {
				System.out.print(copia[i][j] + " ");
			}
			System.out.println();
		}

	}

	static int supercreu(int[][] tauler) {
		int cont = 0;
		for (int i = 0; i < tauler.length; i++) {
			for (int j = 0; j < tauler[i].length; j++) {
				if (tauler[i][j] == 1) {
					boolean superc = true;
					if (i - 2 >= 0 && tauler[i - 2][j] == 1)
						superc = false;
					if (i + 2 < tauler.length && tauler[i + 2][j] == 1)
						superc = false;
					if (j - 2 >= 0 && tauler[i][j - 2] == 1)
						superc = false;
					if (j + 2 < tauler[i].length && tauler[i][j + 2] == 1)
						superc = false;
					if (superc)
						cont++;
				}
			}
		}
		return cont;
	}

	static int superficie(int[][] tauler, int[][] copia, int posx, int posy) {
		if (copia[posx][posy] == 0) {
			return 0;
		} else {
			int cont = 0;
			
			return cont;
		}
		
		

	}

}
