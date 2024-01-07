package tresenratlla;

import java.util.Scanner;

public class Menu {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int a;
		do {

			menu();
			a = sc.nextInt();

			switch (a) {
			case 1:
				Ajuda.info();
				break;
			case 2:
				
				break;
			case 3:
			
				break;
			case 4:
				
				break;
			case 0:
				break;

			default:
				System.out.print("Opció incorrecte");
			}
		} while (a != 0);
		System.out.println("Adeu");
	}

	static void menu() {
		System.out.println("1.- Mostrar Ajuda");
		System.out.println("2.- Definir Jugadors");
		System.out.println("3.- Jugar Partida");
		System.out.println("4.- Veure Jugadors");
		System.out.println("0.- Sortir");
		return;

	}

}
