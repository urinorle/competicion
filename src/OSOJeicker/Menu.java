package OSOJeicker;

import java.util.Scanner;

public class Menu {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		char[][] tablero = null;
		char[][] memoria = null;
		Jugadores j1 = null;
		Jugadores j2 = null;
		int x = 0;
		int y = 0;
		int posX = 0;
		int posY = 0;
		
		int opcio = 0;

		do{
			menu();
			opcio = sc.nextInt();
			switch(opcio){
				case 1:
					System.out.println("Definir Jugadores");
					j1 = Jugadores.crearJugador();
					j2 = Jugadores.crearJugador();
					break;
				case 2:
					if (j1 == null || j2 == null) {
						System.out.println("No hay jugadores definidos");
					}
					else{
						System.out.println();
						System.out.println("Dime el tamaño del tablero");
						x = sc.nextInt();
						y = sc.nextInt();
						tablero = Partida.inicioTablero(x, y);
						memoria = Partida.inicioMemoria(x, y);
						Partida.jugar(tablero, memoria, x, y, j1, j2, posX, posY);
					}
					break;
				case 0:
					System.out.println("Adios");
					break;
			}

		}while(opcio != 0);

	}

	public static void menu(){
		System.out.println("Bienvenido al juego del OSO");
		System.out.println();
		System.out.println("-- MENU --");
		System.out.println();
		System.out.println("1.- Definir Jugadores ");
		System.out.println("2.- Jugar Partida ");
		System.out.println("0.- Salir");
	}

}
