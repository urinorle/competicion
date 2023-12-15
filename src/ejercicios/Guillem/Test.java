package ejercicios.Guillem;

import java.util.*;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int bloq;
		
		do {
			bloq = sc.nextInt();
			int pisos = 1;
			
			for (int i = 1; i < bloq; i = i + 2) {
				if (bloq == i * i) {
					pisos++;
				}
			}
			
			System.out.println(pisos);
		} while (bloq != 0);
	}

}
