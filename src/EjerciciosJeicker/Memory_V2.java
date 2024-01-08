package EjerciciosJeicker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Memory_V2 {
	static Scanner sc = new Scanner(System.in);
	static Random rd = new Random();
	static final int val = 4;
	
	public static void main(String[] args) {
		char[][] tauler = new char[val][val];
		char[][] secret = new char[val][val];
		int opcio;
		int cont = 0;
		do {
			opcio = menu();
			switch (opcio) {
			default:
			case 0:
				break;
			case 1:
				Inicialitzar(tauler);
				break;
			case 2:
				Mostrar(tauler);
				break;
			case 3:
				InicialitzaSecret(secret);
				break;
			case 4:
				TriaCasella(tauler, secret);
				break;
			case 5:
				cont = 0;
				for (int i=0;i<val;i++) {
					for(int j=0;j<val;j++) {
						if(tauler[i][j] == '?') {
							cont++;
						}
					}
				}
				System.out.println("El numero de casillas que quedan sin Destapar es:" + cont);
				break;
			case 6:
				ferJugada(tauler, secret);
				break;
			}
		}while(opcio != 0);
		
	}
	
	private static int menu() {
		int opcio;
		System.out.println("0.- Sortir");
		System.out.println("1.- Inicialitzar Tauler");
		System.out.println("2.- Mostrar Tauler");
		System.out.println("3.- Remanar Peces");
		System.out.println("4.- Tria Casella");
		System.out.println("5.- Caselles Pendents");
		System.out.println("6.- Fer Jugada");
		do {
			System.out.println("Tria una opció");
			opcio = sc.nextInt();
			if (opcio > 6 || opcio < 0) {
				System.out.println("Opció Invalida");
			}
		} while(opcio > 6 || opcio < 0);
		System.out.println();
		return opcio;
	}
	private static void Inicialitzar(char[][] matriu) {
		for (int i=0;i<val;i++) {
			for (int k=0;k<val;k++) {
				matriu[i][k] = '?'; 
			}
		}
	}
	private static void Mostrar(char[][] matriu) {
		for (int i=0;i<val;i++) {
			for (int k=0;k<val;k++) {
				if (k != 0) {
					System.out.print(matriu[i][k] + " ");
				}
				else {
					System.out.print(i + " " + matriu[i][k] + " ");
				}

			}
			System.out.println();
		} 
		System.out.println("  0 1 2 3");
	}
	private static void Posar(char[][] secret) {
		char letra = 'A';
		int num = 0;
		for (int i = 0;i<val;i++) {
			for (int j=0;j<val;j++) {
				if (num != 0 && (num%2)== 0) {
					letra++;
				}
				secret[i][j] = letra;
				num++;
			}
		}
	}
	private static void Remenar(char[][] matrius) {
	    char[][] secret = new char[val][val];
	    char letra = 'A';
	    int num = 0;
	    int[] count = new int[26];

	    for (int i = 0; i < val; i++) {
	        for (int j = 0; j < val; j++) {
	            if (num != 0 && (num % 2) == 0) {
	                letra++;
	            }
	            secret[i][j] = letra;
	            num++;
	        }
	    }

	    for (int i = 0; i < val; i++) {
	        for (int k = 0; k < val; k++) {
	            matrius[i][k] = '?';
	        }
	    }

	    List<int[]> positions = new ArrayList<>();
	    for (int i = 0; i < val; i++) {
	        for (int j = 0; j < val; j++) {
	            positions.add(new int[]{i, j});
	        }
	    }

	    Collections.shuffle(positions);

	    int index = 0;
	    for (int i = 0; i < val; i++) {
	        for (int j = 0; j < val; j++) {
	            int[] pos = positions.get(index);
	            matrius[pos[0]][pos[1]] = secret[i][j];
	            index++;
	        }
	    }
	}
	
	private static void InicialitzaSecret(char[][] secret) {
	    Posar(secret);
	    Remenar(secret);
	}
	
	private static int obtenirFila() {
	    System.out.println("Introduce un número de fila:");
	    int fila = sc.nextInt();
	    while (fila < 0 || fila >= val) {
	        System.out.println("Número de fila incorrecto. Introduce un número de fila:");
	        fila = sc.nextInt();
	    }
	    return fila;
	}
	
	private static int obtenirColumna() {
	    System.out.println("Introduce un número de columna:");
	    int columna = sc.nextInt();
	    while (columna < 0 || columna >= val) {
	        System.out.println("Número de columna incorrecto. Introduce un número de columna:");
	        columna = sc.nextInt();
	    }
	    return columna;
	}
	
	private static boolean validaCasella(char[][] tauler, int fila, int columna) {
	    return tauler[fila][columna] == '?';
	}
	
	private static char obtenirCasella(char[][] secret, int fila, int columna) {
	    return secret[fila][columna];
	}
	
	private static void destapaCasella(char[][] tauler, int fila, int columna, char valor) {
	    tauler[fila][columna] = valor;
	}
	
	private static void tapaCasella(char[][] tauler, int fila, int columna) {
	    tauler[fila][columna] = '?';
	}
	
	private static void TriaCasella(char[][] tauler, char[][] secret) {
	    int fila = obtenirFila();
	    int columna = obtenirColumna();
	    if (validaCasella(tauler, fila, columna)) {
	        char valor = obtenirCasella(secret, fila, columna);
	        destapaCasella(tauler, fila, columna, valor);
	    } else {
	        System.out.println("La casilla ya está destapada. Por favor, elige otra.");
	        TriaCasella(tauler, secret);
	    }
	    Mostrar(tauler);
	}
	
	private static void ferJugada(char[][] tauler, char[][] secret) {
	    Mostrar(tauler);
	    System.out.println("Primera casella:");
	    int fila1 = obtenirFila();
	    int columna1 = obtenirColumna();
	    while (!validaCasella(tauler, fila1, columna1)) {
	        System.out.println("La casella ya está destapada. Por favor, elige otra.");
	        fila1 = obtenirFila();
	        columna1 = obtenirColumna();
	    }
	    char valor1 = obtenirCasella(secret, fila1, columna1);
	    destapaCasella(tauler, fila1, columna1, valor1);
	    Mostrar(tauler);

	    System.out.println("Segunda casella:");
	    int fila2 = obtenirFila();
	    int columna2 = obtenirColumna();
	    while (!validaCasella(tauler, fila2, columna2)) {
	        System.out.println("La casella ya está destapada. Por favor, elige otra.");
	        fila2 = obtenirFila();
	        columna2 = obtenirColumna();
	    }
	    char valor2 = obtenirCasella(secret, fila2, columna2);
	    destapaCasella(tauler, fila2, columna2, valor2);
	    Mostrar(tauler);

	    if (valor1 == valor2) {
	        System.out.println("¡Has encontrado una pareja!");
	    } else {
	        System.out.println("Las casellas no coinciden. Se taparán de nuevo.");
	        tapaCasella(tauler, fila1, columna1);
	        tapaCasella(tauler, fila2, columna2);
	    }
	}
}
