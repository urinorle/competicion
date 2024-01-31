package Examen_JeickerFD;

import java.util.*;

public class Funciones {
	static Random rd = new Random();
	static Scanner sc = new Scanner(System.in);

	public static char[][] definirTablero(int x, int y) {
		System.out.println("Introduce el tamaño del tablero: ");
		x = sc.nextInt();
		y = x;	
		char[][] tablero = new char[x][y];
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				tablero[i][j] = '0';
			}
		}
		return tablero;
	}

	public static void limpiarTablero(char[][] tablero) {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				tablero[i][j] = '0';
			}
		}
    }

	public static void verTablero(char[][] tablero) {
		for (int i = 0; i < tablero.length; i++) {
			System.out.println();
			for (int j = 0; j < tablero.length; j++) {
				System.out.print(tablero[i][j] + " ");
			}
		}
		System.out.println();
	}

	public static boolean ponerCruz(char[][] tablero) {
		for (int i = 0; i < tablero.length; i++) {
			System.out.println();
			for (int j = 0; j < tablero.length; j++) {
				System.out.print(tablero[i][j] + " ");
			}
		}
		System.out.println();
		int x = 0;
		int y = 0;
		System.out.println("Introduce la posicion de la cruz: ");
		x = sc.nextInt();
		y = sc.nextInt();
		if (tablero[x][y] == '0') {
			if (x > 0 && tablero[x-1][y] == '0') {
				tablero[x-1][y] = '1';
			}
			if (x < tablero.length-1 && tablero[x+1][y] == '0') {
				tablero[x+1][y] = '1';
			}
			if (y > 0 && tablero[x][y-1] == '0') {
				tablero[x][y-1] = '1';
			}
			if (y < tablero.length-1 && tablero[x][y+1] == '0') {
				tablero[x][y+1] = '1';
			}
			tablero[x][y] = '1';
			return true;
		} else {
			System.out.println("Ya hay una cruz en esa posicion");
			return false;
		}
	}

    public static boolean ponerNCruz(char[][] tablero) {
		System.out.println("Introduce el numero de cruces: ");
		int n = sc.nextInt();
		if (n > 0 && n < (tablero.length*tablero.length/5)) {
			int x = rd.nextInt(tablero.length);
			int y = rd.nextInt(tablero.length);
			if (tablero[x][y] == '0') {
				if (x > 0 && tablero[x-1][y] == '0') {
					tablero[x-1][y] = '1';
				}
				if (x < tablero.length-1 && tablero[x+1][y] == '0') {
					tablero[x+1][y] = '1';
				}
				if (y > 0 && tablero[x][y-1] == '0') {
					tablero[x][y-1] = '1';
				}
				if (y < tablero.length-1 && tablero[x][y+1] == '0') {
					tablero[x][y+1] = '1';
				}
				tablero[x][y] = '1';
				return true;
			}
 		}
		 else {
			System.out.println("El numero de cruces no es valido");
			return false;
		}
		return false;
	}
}
