package examenJavaGuillemFuncions;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TAMANY = 8;
		int[][]tauler = new int[TAMANY][TAMANY];
		int[][] copia = new int[tauler.length][tauler.length];
		
		
			int opcio = 0;
			
			do {
				menu();
				opcio = sc.nextInt();
				switch (opcio) {
				case 1: 
					Partida.inicialitzar(tauler, TAMANY);
					break;
				case 2:
					Partida.mostrar(tauler, TAMANY);
					break;
				case 3:
					Partida.posarcreu(tauler);
					break;
				case 4:
					Partida.posarncreus(tauler);
					break;
				case 5:
					Partida.creu(tauler);
					break;
				case 6:
					int cont = Partida.comptarrcreus(tauler);
					System.out.println(cont);
					break;
				case 7:
					System.out.println("Aquesta es la copia");
					Partida.copiar(tauler, copia);
					System.out.println("Aquesta es l'original");
					Partida.mostrar(tauler, TAMANY);
					break;
				case 8:
					int numSuperCreus = Partida.supercreu(tauler);
					System.out.println(numSuperCreus);
					break;
				case 9:
					int posx = sc.nextInt();
					int posy = sc.nextInt();
					int num = Partida.superficie(tauler, copia, posx, posy);
					break;
				case 0:
					break;
				}
			} while (opcio != 0);

		}

		static void menu() {
			System.out.println("### LEGO ###");
			System.out.println("1.- Definir Tauler");
			System.out.println("2.- Veure Tauler");
			System.out.println("3.- Posar Creu");
			System.out.println("4.- Posar n-Creus");
			System.out.println("5.- Creu?");
			System.out.println("6.- Comptar Creus");
			System.out.println("7.- Copiar i Veure");
			System.out.println("8.- SuperCreus");
			System.out.println("9.- Superfície");
			System.out.println("0.- Sortir");
		}

	}


