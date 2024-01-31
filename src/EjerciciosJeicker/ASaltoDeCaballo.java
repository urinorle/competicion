package EjerciciosJeicker;

import java.util.*;

public class ASaltoDeCaballo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int resultado = 0;
		char[][] tablero = new char[8][8];
		System.out.println("Ingrese la posición inicial del caballo: ");
		int x = sc.nextInt();
		int y = sc.nextInt();
		if (x < 0 || x > 7 || y < 0 || y > 7) {
			System.out.println("Posición inválida, vuelva a intentarlo: ");
			x = sc.nextInt();
			y = sc.nextInt();
		}
		System.out.println("Ingrese la posición final del caballo: ");
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		if (x2 < 0 || x2 > 7 || y2 < 0 || y2 > 7) {
			System.out.println("Posición inválida, vuelva a intentarlo: s");
			x2 = sc.nextInt();
			y2 = sc.nextInt();
		}
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++)
				tablero[i][j] = '◻';
		}
		tablero[x][y] = '♘';
		tablero[x2][y2] = '♞';


		resultado = numMovimientos(x, y, x2, y2, tablero);

		System.out.println("El número de movimientos es: " + resultado);
	}


	private static int numMovimientos(int x, int y, int x2, int y2, char[][] tablero) {
		if (x == x2 && y == y2) {
			return 0; 
		}

		if (x < 0 || x >= tablero.length || y < 0 || y >= tablero.length || tablero[x][y] != '◻') {
			return -1; 
		}

		tablero[x][y] = '◼'; 

		int[] movimientosX = {2, 1, -1, -2, -2, -1, 1, 2};
		int[] movimientosY = {1, 2, 2, 1, -1, -2, -2, -1};

		int minMovimientos = Integer.MAX_VALUE;

		for (int i = 0; i < movimientosX.length; i++) {
			int nuevoX = x + movimientosX[i];
			int nuevoY = y + movimientosY[i];

			int numMovimientos = numMovimientos(nuevoX, nuevoY, x2, y2, tablero);
			if (numMovimientos >= 0 && numMovimientos < minMovimientos) {
				minMovimientos = numMovimientos + 1;
			}
		}

		tablero[x][y] = '◻';

		return minMovimientos == Integer.MAX_VALUE ? -1 : minMovimientos;
	}
}
