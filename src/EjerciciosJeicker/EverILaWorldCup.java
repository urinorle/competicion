package EjerciciosJeicker;

import java.util.Scanner;

public class EverILaWorldCup {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < testCases; i++) {
            String num = sc.nextLine();
            System.out.println(recu(num, 0));
        }
	}

	private static int recu(String cadena, int index) {
        if (index == cadena.length()) {
            return 0;
        } else {
            return Character.getNumericValue(cadena.charAt(index)) + recu(cadena, index + 1);
        }
    }
	
}
