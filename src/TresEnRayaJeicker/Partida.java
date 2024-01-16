package TresEnRayaJeicker;

import java.util.Scanner;


public class Partida {
	static Scanner sc = new Scanner(System.in);
	public static void inicialitzar(Jugadors j1, char[][] Tablero) {
		if (j1 != null) {
			
			for (int i = 0;i < Menu.Medida;i++) {
				for (int j = 0;j < Menu.Medida;j++) {
					Tablero[i][j] = '-';
				}
			}

		}
		else {
			System.out.println("No hay jugadores definidos.");
		}
	}
	
	public static void mostrar(char[][] Tablero){
		for (int i = 0;i < Menu.Medida;i++) {
			for (int j11 = 0;j11 < Menu.Medida;j11++) {
				System.out.print(Tablero[i][j11]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public static void jugada(char[][] Tablero, Jugadors j1, Jugadors j2) {
		boolean j1win = false;
		boolean j2win = false;
		int X, Y;
		boolean empate = true;
		boolean desocupado = false;
		do {
			System.out.println();
			System.out.println("Comienza " + j1.Name);
			do {
				System.out.println("Escoge una fila: ");
				do {
	
					X = sc.nextInt();
					if (X > 2 || X < 0) {
						System.out.println("Error, debes escoger un numero entre 0 y 2");
					}
				}while(X < 0 || X > 2);
				System.out.println("Escoge una Columna: ");
				do {
	
					Y = sc.nextInt();
					if (Y > 2 || Y < 0) {
						System.out.println("Error, debes escoger un numero entre 0 y 2");
					}
				}while(Y < 0 || Y > 2);
				
				if (Tablero[X][Y] == '-') {
					Tablero[X][Y] = 'X';
					desocupado = true;
				}
				else {
					System.out.println("Error, esa posición ya está ocupada. Por favor, elige otra posición.");
				}
			}while(!desocupado);
			
			verificarj1(j1win, Tablero);
			mostrar(Tablero);
			
			desocupado = false;
			System.out.println();
			System.out.println("Le toca a " + j2.Name);
			do {
				System.out.println("Escoge una fila: ");
				do {
	
					X = sc.nextInt();
					if (X > 2 || X < 0) {
						System.out.println("Error, debes escoger un numero entre 0 y 2");
					}
				}while(X < 0 || X > 2);
				System.out.println("Escoge una Columna: ");
				do {
	
					Y = sc.nextInt();
					if (Y > 2 || Y < 0) {
						System.out.println("Error, debes escoger un numero entre 0 y 2");
					}
				}while(Y < 0 || Y > 2);
				
				if (Tablero[X][Y] == '-') {
					Tablero[X][Y] = 'X';
					desocupado = true;
				}
				else {
					System.out.println("Error, esa posición ya está ocupada. Por favor, elige otra posición.");
				}
			}while(!desocupado);
			
			verificarj1(j2win, Tablero);
			mostrar(Tablero);
			
			for (int i = 0;i < Menu.Medida;i++) {
				for (int j11 = 0;j11 < Menu.Medida;j11++) {
					if(Tablero[i][j11] == '-') {
						empate = false;
					}
				}
			}
		}while(j1win == false || j2win == false);

		
	}
	
	public static boolean verificarj1(boolean j1win, char[][] Tablero) {
		
		if (Tablero[0][0] == 'X' && Tablero[0][1] == 'X' && Tablero[0][2] == 'X') j1win = true;		
		if (Tablero[1][0] == 'X' && Tablero[1][1] == 'X' && Tablero[1][2] == 'X') j1win = true;
		if (Tablero[2][0] == 'X' && Tablero[2][1] == 'X' && Tablero[2][2] == 'X') j1win = true;
		if (Tablero[0][0] == 'X' && Tablero[1][0] == 'X' && Tablero[2][0] == 'X') j1win = true;
		if (Tablero[0][1] == 'X' && Tablero[1][1] == 'X' && Tablero[2][1] == 'X') j1win = true;
		if (Tablero[0][2] == 'X' && Tablero[1][2] == 'X' && Tablero[2][2] == 'X') j1win = true;
		if (Tablero[0][0] == 'X' && Tablero[1][1] == 'X' && Tablero[2][2] == 'X') j1win = true;
		if (Tablero[2][0] == 'X' && Tablero[1][1] == 'X' && Tablero[0][2] == 'X') j1win = true;
		return false;
	}
	
	public static boolean verificarj2(boolean j2win, char[][] Tablero) {
		if (Tablero[0][0] == 'O' && Tablero[0][1] == 'O' && Tablero[0][2] == 'O') j2win = true;
		if (Tablero[1][0] == 'O' && Tablero[1][1] == 'O' && Tablero[1][2] == 'O') j2win = true;
		if (Tablero[2][0] == 'O' && Tablero[2][1] == 'O' && Tablero[2][2] == 'O') j2win = true;
		if (Tablero[0][0] == 'O' && Tablero[1][0] == 'O' && Tablero[2][0] == 'O') j2win = true;
		if (Tablero[0][1] == 'O' && Tablero[1][1] == 'O' && Tablero[2][1] == 'O') j2win = true;
		if (Tablero[0][2] == 'O' && Tablero[1][2] == 'O' && Tablero[2][2] == 'O') j2win = true;
		if (Tablero[0][0] == 'O' && Tablero[1][1] == 'O' && Tablero[2][2] == 'O') j2win = true;
		if (Tablero[2][0] == 'O' && Tablero[1][1] == 'O' && Tablero[0][2] == 'O') j2win = true;
		return false;
	}
}
