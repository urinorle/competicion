package ejercicios.Guillem.Recursivitat;

import java.util.Scanner;

public class EverilaWorldCup {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int nCasos = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < nCasos; i++) {
			String num = sc.nextLine();
			int lon = num.length();
			int acum = 0;
			int pos = 0;
			int res = recu(num, lon, acum, pos);
			System.out.println(res);
		}

	}

	public static int recu(String num, int lon, int acum, int pos) {
		int res = num.charAt(pos) - '0';
		acum = res + acum;
		if (pos == lon-1) {
			return acum;
		} else {
			return recu(num, lon, acum, pos+1);
		}
		
	}

}
