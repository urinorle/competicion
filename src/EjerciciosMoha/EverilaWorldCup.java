package EjerciciosMoha;

import java.util.Scanner;

public class EverilaWorldCup {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int nCasos = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < nCasos; i++) {

			String cadena = sc.nextLine(); 
			int longitud = cadena.length(); 
			int acumulador = 0; 
			int pos = 0; 
			int resultado = calcularRecu(pos, acumulador, cadena, longitud); 
			System.out.println(resultado);
		}

	}

	public static int calcularRecu(int pos, int acumulador, String cadena, int longitud) {
		int numero = cadena.charAt(pos) - '0';
		acumulador += numero;
		if (pos == (longitud - 1)) {
			return acumulador;
		} else {
			return calcularRecu(pos + 1, acumulador, cadena, longitud);
		}

	}

}
