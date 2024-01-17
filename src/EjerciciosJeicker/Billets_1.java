package EjerciciosJeicker;

import java.util.*;

public class Billets_1 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int nCasos = sc.nextInt();
		//asasasas
		for (int i = 0; i<nCasos;i++) {
			int files = sc.nextInt();
			int num = billets(files, 1);
			System.out.println(num);
		}
	}
	//asasasas
	private static int billets(int files, int billet) {
		if (files < billet) {
			return 0;
		} else {
			return 1 + billets(files - billet, billet + 1);
		}
	}

}
