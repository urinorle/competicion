package Examen_JeickerFD;
import java.util.*;
public class LegoCreus {

	static Scanner sc = new Scanner(System.in);
	static Random r = new Random();
	public static void main(String[] args) {
		char[][] tablero = null;
		int x = 0;
		int y = 0;
		int opcio;
		do {
			menu();
			opcio = sc.nextInt();

			switch (opcio) {
				case 1:
					tablero = Funciones.definirTablero(x, y);
					break;
				case 2:
					if (tablero == null) {
						System.out.println("No has definido el tablero");
					}else{
						Funciones.verTablero(tablero);
					}
					
					break;
				case 3:
					if (tablero == null) {
						System.out.println("No has definido el tablero");
					}else{
						Funciones.ponerCruz(tablero);
					}
					break;
				case 4:
					if (tablero == null) {
						System.out.println("No has definido el tablero");
					}else{
						Funciones.limpiarTablero(tablero);
						Funciones.ponerNCruz(tablero);
					}
					break;
				case 5: 
					if (tablero == null) {
						System.out.println("No has definido el tablero");
					}else{
						Funciones.cruzQ(tablero);
					}
					break;
				case 6:
					if (tablero == null) {
						System.out.println("No has definido el tablero");
					}else{
						Funciones.contarCruces(tablero);
					}
					break;
				case 7:
					break;
				case 8:
					break;
				case 9:
					break;
				case 0:
					break;
			}
		}while(opcio != 0);

	}

	public static void menu() {
		System.out.println("1.- Definir Tablero");
		System.out.println("2.- Ver Tablero");
		System.out.println("3.- Poner Cruz");
		System.out.println("4.- Poner n-Cruz");
		System.out.println("5.- Cruz?");
		System.out.println("6.- Contar Cruces");
		System.out.println("7.- Copiar y Ver");
		System.out.println("8.- SuperCruces");
		System.out.println("9.- Superficie");
		System.out.println("0.- Salir");
		System.out.println("Escoge una opcion: ");
	}

}
