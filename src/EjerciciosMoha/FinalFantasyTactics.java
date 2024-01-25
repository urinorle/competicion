package EjerciciosMoha;

import java.util.Scanner;

public class FinalFantasyTactics {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int nCasos = sc.nextInt();

		for (int i = 0; i < nCasos; i++) {

			int filas = sc.nextInt();
			int columnas = sc.nextInt();
			int posX = sc.nextInt();
			int posY = sc.nextInt();
			int mov = sc.nextInt();

			int[][] tablero = new int[filas][columnas];
			int contador = 0;
			for (int j = 0; j < filas; j++) {
				for (int k = 0; k < columnas; k++) {

					if ((Math.abs(j - posX) + Math.abs(k - posY)) <= mov) {
						contador++;
					}

				}
			}
			System.out.println(contador);

		}

	}

}
