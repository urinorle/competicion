package ejercicios.Guillem.Recursivitat;

import java.util.Scanner;

public class RPGGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Bienvenido al mundo de TextoLand!");
        System.out.println("Eres un valiente héroe destinado a salvar el reino del malvado villano.");

        System.out.print("Ingresa el nombre de tu héroe: ");
        String heroName = scanner.nextLine();

        System.out.println("Hola, " + heroName + "! Prepárate para tu aventura épica.");

        // Inicia la historia
        System.out.println("Capítulo 1: El Comienzo");
        System.out.println("Te encuentras en un pequeño pueblo. Un anciano te revela la profecía:");
        System.out.println("Para derrotar al villano, debes encontrar la Espada Legendaria perdida.");

        // Elección del jugador
        System.out.print("¿Deseas aventurarte al Bosque Oscuro (1) o explorar las Montañas Misteriosas (2)? ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            forestAdventure();
        } else if (choice == 2) {
            mountainAdventure();
        } else {
            System.out.println("Elección no válida. Tu indecisión te hace regresar al pueblo.");
        }

        scanner.close();
    }

    private static void forestAdventure() {
        System.out.println("Capítulo 2: En el Bosque Oscuro");
        System.out.println("Te adentras en el Bosque Oscuro, donde encuentras un puente custodiado por un troll.");

        // Desafío del troll
        System.out.println("El troll exige una respuesta a su acertijo para cruzar el puente.");
        System.out.println("Acertijo: Cuanto más lo quitan, más grande se vuelve. ¿Qué es?");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("Agujero")) {
            System.out.println("¡Correcto! El troll te permite pasar.");
            System.out.println("Más adelante, encuentras la Espada Legendaria y te sientes más fuerte.");
        } else {
            System.out.println("Respuesta incorrecta. El troll te arroja al río. Regresas al pueblo.");
            return;
        }

        // Continuación de la historia
        System.out.println("Capítulo 3: El Encuentro Final");
        System.out.println("Con la Espada Legendaria en tu posesión, te diriges al castillo del villano.");
        System.out.println("Una vez dentro, te enfrentas al villano en un épico duelo.");

        // Desafío final
        System.out.println("El villano te lanza un desafío: resolver un rompecabezas para sellar su destino.");
        System.out.println("Rompecabezas: Cuánto es 10 + 5 * 2?");
        int puzzleAnswer = scanner.nextInt();

        if (puzzleAnswer == 20) {
            System.out.println("¡Has resuelto el rompecabezas! Golpeas al villano con la Espada Legendaria.");
            System.out.println("Felicidades, " + getPlayerName() + ", has salvado el reino y completado tu aventura.");
        } else {
            System.out.println("Respuesta incorrecta. El villano te derrota y sume al reino en la oscuridad.");
        }
    }

    private static void mountainAdventure() {
        System.out.println("Capítulo 2: En las Montañas Misteriosas");
        System.out.println("Exploras las Montañas Misteriosas y encuentras una antigua cueva.");

        // Desafío de la cueva
        System.out.println("Dentro de la cueva, te enfrentas a un enigma mágico.");
        System.out.println("Enigma: Si lo nombras, lo rompes. ¿Qué es?");
        Scanner scanner = new Scanner(System.in);
        String riddleAnswer = scanner.nextLine();

        if (riddleAnswer.equalsIgnoreCase("Silencio")) {
            System.out.println("¡Correcto! La entrada a la Cámara del Conocimiento se abre.");
            System.out.println("Dentro, aprendes habilidades místicas que te fortalecen.");
        } else {
            System.out.println("Respuesta incorrecta. Un hechizo oscuro te envuelve y te hace retroceder al pueblo.");
            return;
        }

        // Continuación de la historia
        System.out.println("Capítulo 3: La Revelación Final");
        System.out.println("Con tu nuevo conocimiento, descubres la verdadera debilidad del villano.");
        System.out.println("Te diriges al castillo con determinación.");

        // Desafío final
        System.out.println("El villano te espera con una ilusión engañosa.");
        System.out.println("Identifica la verdadera forma del villano: Humo (1), Espejismo (2), o Sombra (3).");
        int trueForm = scanner.nextInt();

        if (trueForm == 3) {
            System.out.println("¡Correcto! Despides la ilusión y derrotas al villano.");
            System.out.println("Felicidades, " + getPlayerName() + ", has salvado el reino y completado tu aventura.");
        } else {
            System.out.println("Respuesta incorrecta. La ilusión se intensifica y te atrapa en un bucle.");
        }
    }

    private static String getPlayerName() {
        // Este método puede modificarse para obtener el nombre del jugador almacenado al inicio del juego.
        return "jugador";
    }
}


