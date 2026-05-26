public class Accueil {

    public void afficherMenu() {
        int choix = 0;

        while (choix != 3) {
            System.out.println(Constantes.MSG_SEPARATOR);
            System.out.println(" QUI EST L'IMPOSTEUR ");
            System.out.println(Constantes.MSG_SEPARATOR);
            System.out.println("1. Jouer");
            System.out.println("2. Regles");
            System.out.println("3. Quitter");
            System.out.print("> ");

            choix = Entrees.lireEntier();

            if (choix == -1) {
                System.out.println("Fin de l'entree detectee. Fermeture du jeu.");
                return;
            }

            switch (choix) {
                case 1:
                    Jeu jeu = new Jeu();
                    jeu.demarrer();
                    break;
                case 2:
                    afficherRegles();
                    break;
                case 3:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        }
    }

    public void afficherRegles() {
        System.out.println(Constantes.MSG_SEPARATOR);
        System.out.println("REGLES DU JEU");
        System.out.println(Constantes.MSG_SEPARATOR);
        System.out.println("Tu dois trouver l'imposteur parmi "
                + Constantes.NB_SUSPECTS + " suspects.");
        System.out.println("Utilise les indices et les interrogatoires.");
        System.out.println("Tu as " + Constantes.MAX_ACCUSATION + " chances d'accuser.");
        System.out.println(Constantes.MSG_SEPARATOR);
    }
}
