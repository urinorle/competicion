package BuscaMinaJeicker;

import java.util.*;

public class Menu {
	
	static Scanner sc = new Scanner(System.in);
	static final int medida = (Integer) null;
	
	public static void main(String[] args) {
		int a = 1;
		Jugadores j1 = null;
		Jugadores j2 = null;
		
		do {
			int opcio = menu(a);
			
			switch(opcio) {
			case 1:
				break;
			case 2:
				boolean b = false;
				Opciones.menu();
				do {
					int l = sc.nextInt();
					
					if (l < 0 || l > 4) {
						System.out.println("Error, la opción seleccionada no existe");
					}
					else {
						switch(l) {
						case 1:
							Jugadores.crearJugador();
							break;
						case 2:
							Jugadores.crearJugador();
							break;
						case 3:
							Jugadores.crearJugador();
							break;
						case 4:
							Jugadores.crearJugador();
							break;
						case 0:
							break;
						}
					}
				}while(!b);
				break;
			case 3:
				break;
			case 4:
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
		System.out.println("2. Opciones");
		System.out.println("3. Jugar Partida");
		System.out.println("4. Ver Ranking");
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
