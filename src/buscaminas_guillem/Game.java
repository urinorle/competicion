package buscaminas_guillem;

import java.util.Random;

public class Game {
public static void inicializar(int x, int y, int mines) {
	Random rd = new Random();
	char[][] tauler = new char[x][y];
	char[][] secret = new char[x][y];
	
	for (int i = 0; i < x; i++) {
		for (int j = 0; j < y; j++) {
			tauler[i][j] = '⬛';
		}
	}
	for (int i = 0; i < x; i++) {
		for (int j = 0; j < y; j++) {
			tauler[i][j] = '⬜';
		}
	}
	int cont = 0;
	for (int i = cont; i < mines;) {
		int rdx = rd.nextInt(x);
		int rdy = rd.nextInt(y);
		
		if (secret[rdx][rdy] == '⬜') {
			secret[rdx][rdy] = 'B';
			cont++;
		}
	}
	mostrar(tauler, secret, x, y);
}

public static void mostrar(char[][] tauler, char[][] secret, int x, int y) {
	for (int i = 0; i < x; i++) {
		for (int j = 0; j < y; j++) {
			System.out.print(tauler[i][j] + " ");
		}
		System.out.println();
	}
	for (int i = 0; i < x; i++) {
		for (int j = 0; j < y; j++) {
			System.out.print(secret[i][j] + " ");
		}
		System.out.println();
	}

}
}