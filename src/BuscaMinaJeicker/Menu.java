package BuscaMinaJeicker;

import java.util.*;

public class Menu {
	
	static Scanner sc = new Scanner(System.in);
	static Jugadores j = null;
	static Jugadores j1 = null;
	static Jugadores j2 = null;
	static Jugadores j3 = null;
	static Jugadores j4 = null;
	public static void main(String[] args) throws InterruptedException {
		int a = 1;
		int x = 0;
		int y = 0;
		char[][] tablero = null;
		char[][] secret = null;
		boolean lvl1 = false;
		boolean lvl2 = false;
		boolean lvl3 = false;
		boolean lvl4 = false;

		do {
			int opcio = menu(a);
			
			switch(opcio) {
			case 1:
				Ayuda.Ayuda();
				break;
			case 2:
				boolean b = false;
				do {
					Opciones.menu();
					int l = sc.nextInt();
					
					if (l < 0 || l > 4) {
						System.out.println("Error, la opción seleccionada no existe");
					}
					else {
						switch(l) {
						case 1:
							x = 8;
							y = 8;
							int minas = 10;
							tablero = Partida.inicioTablero(x, y, minas);
							secret = Partida.inicioSecret(x, y, minas);
							j1 = Jugadores.crearJugador();
							Partida.jugar(tablero, secret, x, y, minas, x);
							break;
						case 2:
							x = 16;
							y = 16;
							minas = 40;
							tablero = Partida.inicioTablero(x, y, minas);
							secret = Partida.inicioSecret(x, y, minas);
							j1 = Jugadores.crearJugador();
							Partida.jugar(tablero, secret, x, y, minas, x);
							break;
						case 3:
							x = 16;
							y = 30;
							minas = 99;
							tablero = Partida.inicioTablero(x, y, minas);
							secret = Partida.inicioSecret(x, y, minas);
							j1 = Jugadores.crearJugador();
							Partida.jugar(tablero, secret, x, y, minas, x);
							break;
						case 4:
							System.out.println("Dime el tamaño del tablero");
							x = sc.nextInt();
							y = sc.nextInt();
							System.out.println("Dime el numero de minas");
							minas = sc.nextInt();
							tablero = Partida.inicioTablero(x, y, minas);
							secret = Partida.inicioSecret(x, y, minas);
							j1 = Jugadores.crearJugador();
							Partida.jugar(tablero, secret, x, y, minas, x);
							break;
						case 0:
							b = true;	
							break;
						}
					}
				}while(!b);
				break;
			case 3:
			Jugadores.veureJugador(j, j1, j2, j3, j4);
				break;
			case 0:
				break;
			}
		}while(a != 0);
		
		

	}

	private static int menu(int opcio) {
		boolean a = false;
		System.out.println("Bienvenido a Buscaminas");
		System.out.println();
		System.out.println("Escoge una opción para jugar");
		System.out.println("1. Ayuda");
		System.out.println("2. Jugar");
		System.out.println("3. Ver Ranking");
		System.out.println("0. Salir");
		do {
			opcio = sc.nextInt();
			
			if (opcio < 0 || opcio > 4) {
				System.out.println("Error, la opción seleccionada no existe");
			}
			else {
				a = true;
			}
		}while(!a);
		
		return opcio;
	}

}
