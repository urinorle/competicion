package buscaminasMohamedZekhniniAbjij;

import java.util.Random;

public class PROGRAMA {
	public static Random rd = new Random();

	public static void main(String[] args) {

	}

	public static void inicializarSecreto(int x, int y, int mines) {
		char[][] secret = new char[x][y];
		char Bomba = 'B';
		int contador = 0;

		while (contador != mines) {
			int Bx = rd.nextInt();
			int By = rd.nextInt();
			if (secret[Bx][By] != Bomba) {
				secret[Bx][By] = Bomba;
				contador++;
			}
		}
	}

}
