package mohamed3enraya;

public class AYUDA {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Bienvenido al juego del 3 en RAYA.");
	    Thread.sleep(1000);
	    System.out.println("Es muy fácil. El juego consiste de un tablero 3x3 como este:");
	    System.out.println();
	    Thread.sleep(2500);
	    System.out.println("_________________");
	    System.out.println("|    |     |    |");
	    System.out.println("|____|_____|____|");
	    System.out.println("|    |     |    |");
	    System.out.println("|____|_____|____|");
	    System.out.println("|    |     |    |");
	    System.out.println("|____|_____|____|");
	    System.out.println();
	    Thread.sleep(1000);
	    System.out.println("En este juego intervienen 2 jugadores:\n Jugador 1 = <x> y Jugador 2 = <o>");
	    System.out.println();
	    Thread.sleep(3000);
	    System.out.println("Esto consta de ir colocando fichas de manera alternativa hasta que uno de los\n2 jugadores formen una linea recta de 3 fichas.");
	    System.out.println();
	    Thread.sleep(3500);
	    System.out.println("Ejemplo de partida ganada:");
	    System.out.println("_________________");
	    System.out.println("|  X |     | O  |");
	    System.out.println("|____|_____|____|");
	    System.out.println("|    |  X  | O  |");
	    System.out.println("|____|_____|____|");
	    System.out.println("|    |     | X  |");
	    System.out.println("|____|_____|____|");
	    System.out.println();
	    Thread.sleep(1000);
	    System.out.println("¿Estás preparado para jugar?");
	    System.out.println();
	    Thread.sleep(2500);
	    System.out.println(" .-._                                                   _,-,\r\n"
	    		+ "  `._`-._                                           _,-'_,'\r\n"
	    		+ "     `._ `-._                                   _,-' _,'\r\n"
	    		+ "        `._  `-._        __.-----.__        _,-'  _,'\r\n"
	    		+ "           `._   `#===\"\"\"           \"\"\"===#'   _,'\r\n"
	    		+ "              `._/)  ._               _.  (\\_,'\r\n"
	    		+ "               )*'     **.__     __.**     '*( \r\n"
	    		+ "               #  .==..__  \"\"   \"\"  __..==,  # \r\n"
	    		+ "              #   `\"._(_).       .(_)_.\"'   #");	    
		Thread.sleep(3000);
		System.out.println();
		System.out.println("Menú aparece en:");	
		for (int i = 3; i >= 1; i--) {		
	    System.out.print(i + " ");
		Thread.sleep(1000);			
		}
		System.out.println();
		System.out.println();
		MENU.main(args);
		
	}

}
