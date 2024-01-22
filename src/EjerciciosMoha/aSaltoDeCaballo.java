package EjerciciosMoha;

import java.util.Scanner;

public class aSaltoDeCaballo {

	public static void main(String[] args) {
		int[][] tablero = new int[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				tablero[i][j] = 20;
			}
		}
		Scanner sc = new Scanner(System.in);

		int AxFake = sc.nextInt();
		int AyFake = sc.nextInt();
		int BxFake = sc.nextInt();
		int ByFake = sc.nextInt();
		int Ax = AxFake - 1;
		int Ay = AyFake - 1;
		int Bx = BxFake - 1;
		int By = ByFake - 1;
		tablero[Ax][Ay] = 0;
		tablero[Bx][By] = 8;

		int cont1 = 0;
		int cont2 = 1;

		modificarTablero(cont1, cont2, tablero);
	}

	public static void modificarTablero(int cont1, int cont2, int[][] tablero) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {

				if (tablero[i][j] == cont1) {

					for (int k = 0; k < 8; k++) {
						for (int l = 0; l < 8; l++) {

							if ((Math.abs(k - i) == 2 && Math.abs(l - j) == 1)
									|| (Math.abs(k - i) == 1 && Math.abs(l - j) == 2)) {
								tablero[k][l] = cont2;
							}

						}
					}

				}
			}
		}
		if (existeB(tablero)) {
			modificarTablero(cont1 + 1, cont2 + 1, tablero);
		}
		System.out.println(cont2);
		System.exit(0);
	}

	public static boolean existeB(int[][] tablero) {
		int elemento = 8;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (tablero[i][j] == elemento) {
					return true;
				}
			}
		}
		return false;
	}

}