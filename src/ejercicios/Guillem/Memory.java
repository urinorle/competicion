package ejercicios.Guillem;

import java.util.Random;
import java.util.Scanner;

public class Memory {

	public static Scanner sc = new Scanner(System.in);
	public static Random rd = new Random();
	public static final int TAULER = 4;

	public static void main(String[] args) {
		char tauler[][] = new char[TAULER][TAULER];
		char secret[][] = new char[TAULER][TAULER];
		int opcio;

		do {
			opcio = menu();
			switch (opcio) {
			default:
			case 0:
				break;
			case 1:
				Inicialitzar(tauler);
				break;
			case 2:
				Mostrar(tauler);
				break;
			case 3:
				Posar(secret);
				break;
			case 4:
				Remenar(secret);
				Mostrar(secret);
				break;
			}

		} while (opcio != 0);

	}

	private static int menu() {
		int opcio;
		System.out.println("0. Sortir");
		System.out.println("1. Inicialitzar Tauler");
		System.out.println("2. Mostrar Tauler");
		System.out.println("3. Posar Peces");
		System.out.println("4. Remenar Peces");
		
		do {
			System.out.println("Escull una opcio: ");
			opcio = sc.nextInt();
			if (opcio > 4 || opcio < 0)
				System.out.println("Opcio invalida");
		} while (opcio > 4 || opcio < 0);
		return opcio;
	}

	private static void Inicialitzar(char[][] tauler) {
		for (int i = 0; i < TAULER; i++) {
			for (int j = 0; j < TAULER; j++) {
				tauler[i][j] = '?';
			}
		}

	}

	private static void Mostrar(char[][] tauler) {
		for (int i = 0; i < TAULER; i++) {
			for (int j = 0; j < TAULER; j++) {
				if (j == 0)
					System.out.print(i + " " + tauler[i][j] + " ");
				else
					System.out.print(tauler[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("  0 1 2 3");
	}

	private static void Posar(char[][] secret) {
		char lletra = 'A';
		int num = 0;
		for (int i = 0; i < TAULER; i++) {
			for (int j = 0; j < TAULER; j++) {
				if (num != 0 && (num % 2) == 0) {
					lletra++;
				}
				secret[i][j] = lletra;
				num++;
			}
		}

	}

	private static void Remenar(char[][] secret) {

		for (int i = 0; i < 100; i++) {

			int filaV1;
			int colV1;
			int filaV2;
			int colV2;
			boolean repetir = false;

			do {

				filaV1 = rd.nextInt(TAULER);
				colV1 = rd.nextInt(TAULER);
				filaV2 = rd.nextInt(TAULER);
				colV2 = rd.nextInt(TAULER);

				if (filaV1 == filaV2 && colV1 == colV2) {
					repetir = true;
				} else {
					repetir = false;
				}

			} while (repetir);

			char V1 = secret[filaV1][colV1];
			char V2 = secret[filaV2][colV2];
			secret[filaV2][colV2] = V1;
			secret[filaV1][colV1] = V2;
		}
	}
}
