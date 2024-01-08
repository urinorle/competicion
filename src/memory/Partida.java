package memory;

import java.util.Random;
import java.util.Scanner;

public class Partida {

	static Scanner sc = new Scanner(System.in);
	static Random rd = new Random();
	static final char Tapat = '?';
	static final char Files = 4;
	static final char Columnes = 4;

	static void inicilitzar(char[][] tauler) {
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				tauler[i][j] = Tapat;

	}

	static void visualitzar(char[][] tauler) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++)
				System.out.print(tauler[i][j] + " ");
			System.out.println();

		}

	}

	private static void posar(char[][] tauler) {
		char lletra = 'A';
		int comp = 0;
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {

				if (comp != 0 && (comp % 2) == 0)
					lletra++;

				tauler[i][j] = lletra;
				comp++;
			}
	}

	private static void remena(char[][] taulerSecret) {

		Random rand = new Random();

		for (int i = 0; i < Files; i++) {
			for (int j = 0; j < Columnes; j++) {

				int filaAleatoria = rand.nextInt(Files);
				int columnaAleatoria = rand.nextInt(Columnes);

				char temp = taulerSecret[i][j];
				taulerSecret[i][j] = taulerSecret[filaAleatoria][columnaAleatoria];
				taulerSecret[filaAleatoria][columnaAleatoria] = temp;
			}
		}
	}

	static void iniSecret(char[][] taulerSecret) {
		posar(taulerSecret);
		remena(taulerSecret);
	}
}
