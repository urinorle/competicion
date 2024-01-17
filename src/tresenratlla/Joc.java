package tresenratlla;

import java.util.Scanner;

public class Joc {

	public static void inicialitzar(Jugadors j1, char[][] tauler) {
		if (j1 != null) {
			for (int i = 0; i < Menu.mesura; i++) {
				for (int j = 0; j < Menu.mesura; j++) {
					tauler[i][j] = '-';
				}
			}
		} else {
			System.out.println("Escull primer els jugadors!!");
		}

	}

	public static void mostrar(char[][] tauler) {
		for (int i = 0; i < Menu.mesura; i++) {
			for (int j = 0; j < Menu.mesura; j++) {
				System.out.print(tauler[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	public static void jugada(char[][] tauler, Jugadors j1, Jugadors j2) {
		Scanner sc = new Scanner(System.in);
		boolean j1win = false;
		boolean j2win = false;
		boolean empate = true; // es la condicion por si el tablero esta lleno i no hay ganadores EMPATE
		int fila;
		int columna;
		boolean ocupat = false;
		do {
			System.out.println("Torn de " + j1.nom);
			System.out.println("Posa la X: ");
			System.out.println();
			do {
				ocupat = false;
				System.out.println("Escull una fila: ");
				do {
					fila = sc.nextInt();
					if (fila < 0 || fila > 2) {
						System.out.println("Escull un altre posicio, ha de ser entre 0 i 2: ");
					}
				} while (fila < 0 || fila > 2);

				System.out.println("Escull una columna: ");
				do {
					columna = sc.nextInt();
					if (columna < 0 || columna > 2) {
						System.out.println("Escull un altre posicio, ha de ser entre 0 i 2: ");
					}

				} while (columna < 0 || columna > 2);

				if (tauler[fila][columna] == 'X' || tauler[fila][columna] == 'O') {
					ocupat = true;
					System.out.println("La casella no esta buida, esull una altra posicio: ");
				}

			} while (ocupat == true);

			tauler[fila][columna] = 'X';

			j1win = verificarj1(j1win, tauler);
			mostrar(tauler);
			if (j1win == true) {
				System.out.println();
				System.out.println("El " + j1.nom + " ha guanyat!!");
				System.out.println();
				j1.partidesWin = j1.partidesWin+1;
				j2.partidesLose = j2.partidesLose+1;
				break;
			}
			empat(empate, tauler);

			System.out.println("Torn de " + j2.nom);
			System.out.println("Posa la O: ");
			System.out.println();
			do {
				ocupat = false;
				System.out.println("Escull una fila: ");
				do {
					fila = sc.nextInt();
					if (fila < 0 || fila > 2) {
						System.out.println("Escull un altre posicio, ha de ser entre 0 i 2: ");
					}
				} while (fila < 0 || fila > 2);

				System.out.println("Escull una columna: ");
				do {
					columna = sc.nextInt();
					if (columna < 0 || columna > 2) {
						System.out.println("Escull un altre posicio, ha de ser entre 0 i 2: ");
					}
				} while (columna < 0 || columna > 2);
				
				if (tauler[fila][columna] == 'X' || tauler[fila][columna] == 'O') {
					ocupat = true;
					System.out.println("La casella no esta buida, esull una altra posicio: ");
				}

			} while (ocupat == true);

			tauler[fila][columna] = 'O';

			j2win = verificarj2(j2win, tauler);
			mostrar(tauler);
			if (j2win == true) {
				System.out.println();
				System.out.println("El " + j2.nom + " ha guanyat!!");
				System.out.println();
				j2.partidesWin = j2.partidesWin+1;
				j1.partidesLose = j1.partidesLose+1;
				break;
			}
			
			empat(empate, tauler);

		} while (j1win == false || j2win == false || empate == false);
	}

	private static boolean empat(boolean empate, char[][] tauler) {
		for (int i = 0; i < Menu.mesura; i++) {
			for (int j = 0; j < Menu.mesura; j++) {
				if (tauler[i][j] == '-') {
					empate = false;
				}
			}
		}
		return empate;
	}

	private static boolean verificarj2(boolean j2win, char[][] tauler) {
		if (tauler[0][0] == 'O' && tauler[0][1] == 'O' && tauler[0][2] == 'O')
			j2win = true;

		if (tauler[1][0] == 'O' && tauler[1][1] == 'O' && tauler[1][2] == 'O')
			j2win = true;

		if (tauler[2][0] == 'O' && tauler[2][1] == 'O' && tauler[2][2] == 'O')
			j2win = true;

		if (tauler[0][0] == 'O' && tauler[1][0] == 'O' && tauler[2][0] == 'O')
			j2win = true;

		if (tauler[0][1] == 'O' && tauler[1][1] == 'O' && tauler[2][1] == 'O')
			j2win = true;

		if (tauler[0][2] == 'O' && tauler[1][2] == 'O' && tauler[2][2] == 'O')
			j2win = true;

		if (tauler[0][0] == 'O' && tauler[1][1] == 'O' && tauler[2][2] == 'O')
			j2win = true;

		if (tauler[2][0] == 'O' && tauler[1][1] == 'O' && tauler[0][2] == 'O')
			j2win = true;

		return j2win;
	}

	private static boolean verificarj1(boolean j1win, char[][] tauler) {

		if (tauler[0][0] == 'X' && tauler[0][1] == 'X' && tauler[0][2] == 'X')
			j1win = true;

		if (tauler[1][0] == 'X' && tauler[1][1] == 'X' && tauler[1][2] == 'X')
			j1win = true;

		if (tauler[2][0] == 'X' && tauler[2][1] == 'X' && tauler[2][2] == 'X')
			j1win = true;

		if (tauler[0][0] == 'X' && tauler[1][0] == 'X' && tauler[2][0] == 'X')
			j1win = true;

		if (tauler[0][1] == 'X' && tauler[1][1] == 'X' && tauler[2][1] == 'X')
			j1win = true;

		if (tauler[0][2] == 'X' && tauler[1][2] == 'X' && tauler[2][2] == 'X')
			j1win = true;

		if (tauler[0][0] == 'X' && tauler[1][1] == 'X' && tauler[2][2] == 'X')
			j1win = true;

		if (tauler[2][0] == 'X' && tauler[1][1] == 'X' && tauler[0][2] == 'X')
			j1win = true;

		return j1win;
	}

}
