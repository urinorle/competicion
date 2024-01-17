package EjerciciosMoha;

import java.util.Scanner;

public class aSaltoDeCaballo {

	public static void main(String[] args) {
		char[][] tablero = new char[8][8];
		Scanner sc = new Scanner(System.in);

		int AxFake = sc.nextInt();
		int AyFake = sc.nextInt();
		int BxFake = sc.nextInt();
		int ByFake = sc.nextInt();
		int Ax = AxFake - 1;
		int Ay = AyFake - 1;
		int Bx = BxFake - 1;
		int By = ByFake - 1;
		tablero[Ax][Ay] = 'A';
		tablero[Bx][By] = 'B';

		int cont = 0;

		if (!verificarExistenciaDeB(tablero)) {
			System.out.println(cont);
		} else {
			cont++;
			hacerTransformación(tablero, Ax, Ay);
		}
	}

	public static void hacerTransformación(char[][] tablero, int ax, int ay) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				int ireal = i - 1;
				int jreal = j - 1;
				if ((Math.abs(ax - ireal) == 2 && Math.abs(ay - jreal) == 1)
						|| (Math.abs(ax - ireal) == 1 && Math.abs(ay - jreal) == 2)) {
					tablero[ireal][jreal] = 'A';
				}
			}
		}

	}

	public static boolean verificarExistenciaDeB(char[][] tablero) {
		boolean flag = false;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (tablero[i][j] == 'B') {
					flag = true;
				}
			}
		}
		return flag;
	}
}