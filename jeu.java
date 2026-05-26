import java.util.Scanner;

public class jeu {

    Scanner scanner = new Scanner(System.in);
    boolean enCours = true;

    public void demarrer() {

        System.out.println("=== QUI EST L'IMPOSTEUR ? ===");

        while (enCours) {
            menuPrincipal();
        }
    }

        public void menuPrincipal() {
        System.out.println("\n====================");
        System.out.println("1. Interroger un suspect");
        System.out.println("2. Chercher des indices");
        System.out.println("3. Carnet d'indices");
        System.out.println("4. Accuser");
        System.out.println("5. Quitter");
        System.out.print("> ");

        int choix = scanner.nextInt();

        switch (choix) {
            case 1:
                interroger();
                break;
            case 2:
                indices();
                break;
            case 3:
                carnet();
                break;
            case 4:
                accuser();
                break;
            case 5:
                quitter();
                break;
            default:
                System.out.println("Choix invalide.");
        }
    }

        public void interroger() {
        System.out.println(">> Interrogatoire (pas encore fait)");
    }

    public void indices() {
        System.out.println(">> Recherche d'indices (pas encore fait)");
    }

    public void carnet() {
        System.out.println(">> Carnet d'indices (pas encore fait)");
    }

    public void accuser() {
        System.out.println(">> Accusation (pas encore fait)");
    }

    public void quitter() {
        System.out.println("Fermeture du jeu...");
        enCours = false;
    }

    public void regles() {
    System.out.println("Trouve l'imposteur parmi les suspects !");
    }
}   
