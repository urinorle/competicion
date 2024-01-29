package jocOSO_Guillem;

import java.util.Random;
import java.util.Scanner;

public class Partida {

	static Scanner sc = new Scanner(System.in);
	static Random rd = new Random();
	
	static void inicializar() {
		System.out.println("Digues el numero de files: ");
		final int FILES = sc.nextInt();
		System.out.println("Digues el numero de columnes: ");
		final int COLUMNES = sc.nextInt();
		
		int[][] memoria = new int[FILES][COLUMNES];
		char[][] tauler = new char[FILES][COLUMNES];
		
		for (int i = 0; i < FILES; i++) {
			for (int j = 0; j < COLUMNES; j++) {
				memoria[i][j] = 0;
				tauler[i][j] = '·';
			}
		}
		torns(memoria, tauler, FILES, COLUMNES);
	}
	
	static void torns(int[][] memoria, char[][] tauler, int FILES, int COLUMNES) {
		int casellesLliures = 0;
		do {
			casellesLliures = contarCaselles(tauler);
			System.out.println("Escull la fila: ");
			int filaSel = 0;
			do {
				filaSel = sc.nextInt();
			} while (filaSel < 0 && filaSel > FILES);
			
			System.out.println("Escull la columna: ");
			int columnaSel = 0;
			do {
				columnaSel = sc.nextInt();
			} while (columnaSel < 0 && columnaSel > COLUMNES);
			
			System.out.println("Quina lletra vols posar O / S ?");
			char seleccio = '?';
			do {
				seleccio = sc.next().charAt(0);
			} while (seleccio != 'O' && seleccio != 'S');
			
			tauler[filaSel][columnaSel] = seleccio;
			
			verificarO(tauler, memoria, filaSel, columnaSel);
			verificarS(tauler, memoria, filaSel, columnaSel);
			
			
			
			
			
		} while (casellesLliures != 0);
	}

	static int contarCaselles(char[][] tauler) {
		int cont = 0;
		for (int i = 0; i < tauler.length; i++) {
			for (int j = 0; j < tauler[0].length; j++) {
				if (tauler[i][j] == '·') {
					cont++;
				}
			}
		}
		return cont;
	}
	
	static int verificarS(char[][] tauler, int[][] memoria, int filaSel, int columnaSel) {
		int punts = 0;
		if (filaSel-1 >= 0 && columnaSel >= 0) {
			if (tauler[filaSel-1][columnaSel-1] == 'O') {
				if (filaSel+1 < tauler.length && columnaSel+1 < tauler[0].length) {
					if (tauler[filaSel+1][columnaSel+1] == 'O') {
						
					}
				}
			}
		}
		
		return 0;
	}

	static int verificarO(char[][] tauler, int[][] memoria, int filaSel, int columnaSel) {
		
		return 0;
	}
	
}
