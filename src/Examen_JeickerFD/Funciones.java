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
		System.out.println("Tablero ");
		for (int i = 0; i < tablero.length; i++) {
			System.out.println();
			for (int j = 0; j < tablero.length; j++) {
				System.out.print(tablero[i][j] + " ");
			}
		}
		System.out.println();
	}

	public static void verTableroCopia(char[][] tablero) {
		System.out.println("Tablero copiado");
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
		int i = 0;
		boolean flag = false;
		do {
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
					flag = true;
				}
			 }
			 else {
				System.out.println("El numero de cruces no es valido");
				flag = false;
			}
			i++;
		}while (i < n);
		
		return flag;
	}

	public static boolean cruzQ(char[][] tablero) {
		int x = 0;
		int y = 0;
		System.out.println("Introduce la posicion de la cruz: ");
		x = sc.nextInt();
		y = sc.nextInt();
		if ((x == 0 || x == tablero.length - 1 || y == 0 || y == tablero.length - 1) ||
			(x > 0 && tablero[x][y] == '1' && tablero[x-1][y] == '1' && tablero[x+1][y] == '1' && tablero[x][y-1] == '1' && tablero[x][y+1] == '1')) {
			System.out.println("Hay una Cruz");
			return true;
		} else {
			System.out.println("No hay una Cruz");
			return false;
		}
	}

	public static int contarCruces(char[][] tablero) {
		int cont = 0;
		for (int i = 1; i < tablero.length - 1; i++) {
			for (int j = 1; j < tablero[i].length - 1; j++) {
				if (tablero[i][j] == '1' && tablero[i-1][j] == '1' && tablero[i+1][j] == '1' && tablero[i][j-1] == '1' && tablero[i][j+1] == '1') {
					cont++;
				}
			}
		}
		return cont;
	}

	public static char[][] copiarTablero(char[][] tablero) {
		char[][] tablero2 = new char[tablero.length][tablero.length];
		for (int i = 0; i < tablero2.length; i++) {
			for (int j = 0; j < tablero2.length; j++) {
				tablero2[i][j] = tablero[i][j];
			}
		}
		return tablero2;
	}

	public static int superCruces(char[][] tablero) {
		int cont = 0;
		for (int i = 2; i < tablero.length - 2; i++) {
			for (int j = 2; j < tablero[i].length - 2; j++) {
				if (tablero[i][j] == '1' && tablero[i-1][j] == '1' && tablero[i+1][j] == '1' &&  tablero[i][j-1] == '1' && tablero[i][j+1] == '1' && tablero[i-2][j] != '1' && tablero[i+2][j] != '1' && tablero[i][j-2] != '1' && tablero[i][j+2] != '1') {
					cont++;
				}
			}
		}
		return cont;
	}

	public static int superficie(char[][] tablero, int a, int b) {
		int cont = 0;
		if (a >= 0 && a < tablero.length && b >= 0 && b < tablero[a].length) {
			if (tablero[a][b] == '1') {
			} else {
				if (tablero[a][b] == '0') {
					tablero[a][b] = '2';
					cont++;
					cont += superficie(tablero, a - 1, b);
					cont += superficie(tablero, a + 1, b);
					cont += superficie(tablero, a, b - 1);
					cont += superficie(tablero, a, b + 1);
				}
			}
		}
		return cont;
	}

}
