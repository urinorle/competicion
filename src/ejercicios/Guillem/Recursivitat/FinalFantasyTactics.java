package ejercicios.Guillem.Recursivitat;

import java.util.Scanner;

public class FinalFantasyTactics {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int nCasos = sc.nextInt();

		for (int i = 0; i < nCasos; i++) {
			int filas = sc.nextInt();
			int columnas = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			int mov = sc.nextInt();

			int[][] mapa = new int[filas][columnas];

			for (int j = 0; j < filas; j++) {
				for (int k = 0; k < columnas; k++) {
					mapa[j][k] = 0;
				}
			}
			mapa[x][y] = 1;
			
			int res = contarmoviments(x, y, mov, mapa);
			System.out.println(res);

		}
	}

	public static int contarmoviments(int x, int y, int mov, int[][] mapa) {
		
		return 0;
		
		
	}

}
