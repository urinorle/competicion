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
		System.out.println("Torn de " + j1);
		Scanner sc = new Scanner(System.in);
		boolean j1win = false;
		boolean j2win = false;
		boolean empate = false; // es la condicion por si el tablero esta lleno y no hay ganadores EMPATE
		int fila;
		int columna;
		do {
			System.out.println("Posa la X: ");
			System.out.println();
			System.out.println("Escull una fila: ");
			 fila = sc.nextInt();
			 System.out.println("Escull una columna: ");
			 columna = sc.nextInt();
			 tauler[fila][columna] = 'X';
			 
			 verificar(j1win, j2win, tauler);
			 
			 
		} while (j1win == false || j2win == false);
	}

	private static boolean verificar(boolean j1win, boolean j2win, char[][] tauler) {
		
		if (tauler[0][0] == 'X' && tauler[0][1] == 'X' && tauler[0][2] == 'X') j1win = true;
		if (tauler[0][0] == 'O' && tauler[0][1] == 'O' && tauler[0][2] == 'O') j2win = true;
		
		if (tauler[1][0] == 'X' && tauler[1][1] == 'X' && tauler[1][2] == 'X') j1win = true;
		if (tauler[1][0] == 'O' && tauler[1][1] == 'O' && tauler[1][2] == 'O') j2win = true;
		
		if (tauler[2][0] == 'X' && tauler[2][1] == 'X' && tauler[2][2] == 'X') j1win = true;
		if (tauler[2][0] == 'O' && tauler[2][1] == 'O' && tauler[2][2] == 'O') j2win = true;
		
		if (tauler[0][0] == 'X' && tauler[1][0] == 'X' && tauler[2][0] == 'X') j1win = true;
		if (tauler[0][0] == 'O' && tauler[1][0] == 'O' && tauler[2][0] == 'O') j2win = true;
		
		if (tauler[0][1] == 'X' && tauler[1][1] == 'X' && tauler[2][1] == 'X') j1win = true;
		if (tauler[0][1] == 'O' && tauler[1][1] == 'O' && tauler[2][1] == 'O') j2win = true;
		
		if (tauler[0][2] == 'X' && tauler[1][2] == 'X' && tauler[2][2] == 'X') j1win = true;
		if (tauler[0][2] == 'O' && tauler[1][2] == 'O' && tauler[2][2] == 'O') j2win = true;
		
		if (tauler[0][0] == 'X' && tauler[1][1] == 'X' && tauler[2][2] == 'X') j1win = true;
		if (tauler[0][0] == 'O' && tauler[1][1] == 'O' && tauler[2][2] == 'O') j2win = true;
		
		if (tauler[2][0] == 'X' && tauler[1][1] == 'X' && tauler[0][2] == 'X') j1win = true;
		if (tauler[2][0] == 'O' && tauler[1][1] == 'O' && tauler[0][2] == 'O') j2win = true;
		
		return j1win;
	}
	
}
