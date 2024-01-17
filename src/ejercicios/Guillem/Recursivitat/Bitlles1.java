package ejercicios.Guillem.Recursivitat;

import java.util.Scanner;

public class Bitlles1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int nCasos = sc.nextInt();

		for (int i = 0; i < nCasos; i++) {
			int num = sc.nextInt();
			num = total(num);
			System.out.println(num);
		}
	}

	public static int total(int num) {
		if (num == 0) {
			return 0;
		} 
		if (num <= 1) {
			return 1;
		}  
		return (num+total(num-1));
		
	}

	}

