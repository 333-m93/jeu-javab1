import java.util.Scanner;

public class accueil {

    Scanner scanner = new Scanner(System.in);

    public void afficherMenu() {

        int choix = 0;

        while (choix != 3) {

            System.out.println("\n======================");
            System.out.println(" QUI EST L'IMPOSTEUR ");
            System.out.println("======================");
            System.out.println("1. Jouer");
            System.out.println("2. Règles");
            System.out.println("3. Quitter");
            System.out.print("> ");

            choix = scanner.nextInt();

            switch (choix) {

                case 1:
                    jeu jeu = new jeu();
                    jeu.demarrer();
                    break;

                case 2:
                    regles();
                    break;

                case 3:
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide.");
            }
        }
    }

    public void regles() {
        System.out.println("\n--- REGLES ---");
        System.out.println("Trouve l'imposteur parmi les suspects.");
        System.out.println("Utilise les indices et les interrogatoires.");
    }
}