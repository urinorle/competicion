package conectaCuatroMohamedZekhnini;

import java.util.Random;
import java.util.Scanner;

public class JUGAR {

	static final int ANCHO = 6;
	static final int ALTO = 7;
	static Scanner sc = new Scanner(System.in);
	static Random rd = new Random();
	static char[][] TABLERO = new char[ANCHO][ALTO];
	static final char J1 = 'X';
	static final char J2 = 'O';
	static final char VACIO = '-';

	public static void main(String[] args) {
		boolean J1GANA = false;
		boolean J2GANA = false;
		boolean EMPATE = false;
		String jugador1 = definirJugador1();
		String jugador2 = definirJugador2();
		int col = 0;
		inicializarTablero();

		do {
			// turno de J1
			mostrarTablero();
			System.out.println("TURNO DE: " + jugador1);
			boolean verificarSiSePuedeTirarJ1 = false;
			do {
				System.out.println("ESCOGE A QUÉ COLUMNA QUIERES LANZAR FICHA");
				col = sc.nextInt();
				verificarSiSePuedeTirarJ1 = verificarSiSePuedeTirar(col);
			} while (verificarSiSePuedeTirarJ1 == false);
			depositarX(col);
			J1GANA = verificarVictoria();
			if (J1GANA) {
				break;
			}
			/*----------------------*/
			// turno de J2
			mostrarTablero();
			System.out.println("TURNO DE: " + jugador2);
			boolean verificarSiSePuedeTirarJ2 = false;
			do {
				System.out.println("ESCOGE A QUÉ COLUMNA QUIERES LANZAR FICHA");
				col = sc.nextInt();
				verificarSiSePuedeTirarJ2 = verificarSiSePuedeTirar(col);
			} while (verificarSiSePuedeTirarJ2 == false);
			depositarY(col);
			J2GANA = verificarVictoria();
			if (J2GANA) {
				break;
			}
			EMPATE = verificarSiSePuedeTirar();
			if (EMPATE) {
				break;
			}
		} while (J1GANA == false && J2GANA == false && EMPATE == false);
		resultado(J1GANA, J2GANA, EMPATE, jugador1, jugador2);
	}

	public static boolean verificarVictoria() {
		/*SOLO ME FALTA LA VERIFICACIÓN*/
		return false;
	}

	public static void depositarY(int col) {
		for (int i = 5; i >= 0; i--) {
			if (TABLERO[i][col] == VACIO) {
				TABLERO[i][col] = J2;
				break;
			}
		}

	}

	public static void depositarX(int col) {
		for (int i = 5; i >= 0; i--) {
			if (TABLERO[i][col] == VACIO) {
				TABLERO[i][col] = J1;
				break;
			}
		}

	}

	private static boolean verificarSiSePuedeTirar() {

		int cont = 0;
		for (int i = 0; i < ANCHO; i++) {
			for (int j = 0; j < ALTO; j++) {
				if (TABLERO[i][j] == J1 || TABLERO[i][j] == J2) {
					cont++;
				}
			}
		}
		if (cont == (ALTO * ANCHO)) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean verificarSiSePuedeTirar(int col) {
		if (col < 0 || col >= ANCHO) {
			System.out.println("Debes escoger una columna válida.");
			return false;
		}

		for (int i = ANCHO - 1; i >= 0; i--) {
			if (TABLERO[i][col] == VACIO) {
				return true;
			}
		}
		System.out.println("La columna está llena. Escoge otra columna.");
		return false;
	}

	public static void mostrarTablero() {
		for (int i = 0; i < ANCHO; i++) {
			for (int j = 0; j < ALTO; j++) {
				System.out.print(TABLERO[i][j]);
			}
			System.out.println();
		}
		System.out.print(" 0 1 2 3 4 5 6");

	}

	private static void resultado(boolean j1gana, boolean j2gana, boolean EMPATE, String jugador1, String jugador2) {
		if (j1gana) {
			System.out.println("HA GANADO: " + jugador1);
		}
		if (j2gana) {
			System.out.println("HA GANADO: " + jugador2);
		}
		if (EMPATE) {
			System.out.println("EMPATE, BUENA PARTIDA!");
		}

	}

	private static void inicializarTablero() {
		for (int i = 0; i < ANCHO; i++) {
			for (int j = 0; j < ALTO; j++) {
				TABLERO[i][j] = VACIO;
			}
		}

	}

	private static String definirJugador1() {
		System.out.println("Nombre del jugador que jugará primero:");
		return sc.nextLine();
	}

	private static String definirJugador2() {
		System.out.println("Nombre del jugador que jugará segundo:");
		return sc.nextLine();
	}

}
