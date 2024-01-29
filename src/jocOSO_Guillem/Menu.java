package jocOSO_Guillem;

import java.util.Scanner;

public class Menu {
	
	public static Scanner sc = new Scanner(System.in);

	static Jugadors j1 = null;
	static Jugadors j2 = null;
	
	public static void main(String[] args) {
		
		int opcio = 0;
		
		do {
			menu();
			opcio = sc.nextInt();
			switch (opcio) {
			case 1: 
				j1 = Jugadors.definirjugador();
				j2 = Jugadors.definirjugador();
				Partida.inicializar();
				Partida.torns(null, null, opcio, opcio);
				break;
			case 2:
				break;
			case 0:
				break;
			}
		} while (opcio != 0);

	}

	static void menu() {
		System.out.println("### JOC DEL OSO ###");
		System.out.println("1.- Definir Jugadors");
		System.out.println("2.- Jugar Partida");
		System.out.println("0.- Sortir");
	}

}
