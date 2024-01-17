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
		tablero[Ax][Ay] = '1';
		tablero[Bx][By] = 'A';

		int cont = 0;

		while (verificarExistenciaDeB(tablero)) {
			cont++;
			hacerTransformación1(tablero, cont, Ax, Ay);
		}
		System.out.println(cont);
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

	public static void hacerTransformación1(char[][] tablero, int cont, int ax, int ay) {

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((Math.abs(ax - i) == 1 && Math.abs(ay - j) == 2)
						|| (Math.abs(ax - i) == 2 && Math.abs(ay - j) == 1)) {
					tablero[i][j] = (char) cont;
				}
			}
		}

		

	}

}