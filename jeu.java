public class Jeu {
    private boolean enCours = true;
    private int accusationsRestantes = Constantes.MAX_ACCUSATION;

    private Suspect[] suspects;
    private int imposteurIndex;
    private GestionIndices gestion;
    private Score scoreJoueur;

    public void demarrer() {
        suspects = Suspect.creerSuspects();
        imposteurIndex = Suspect.choisirImposteur(suspects);
        gestion = new GestionIndices();
        scoreJoueur = new Score();
        scoreJoueur.demarrerChrono();

        System.out.println(Constantes.MSG_SEPARATOR);
        System.out.println("HISTOIRE");
        System.out.println(Constantes.MSG_SEPARATOR);
        System.out.println("Un meurtre a eu lieu dans une station spatiale.");
        System.out.println("Un membre de l'equipage est un imposteur.");
        System.out.println("Tu dois le trouver grace aux indices et interrogatoires.");
        System.out.println(Constantes.MSG_SEPARATOR);

        while (enCours) {
            menuPrincipal();
        }
    }

    public void menuPrincipal() {
        System.out.println("\n====================");
        System.out.println("1. Interroger un suspect");
        System.out.println("2. Chercher des indices");
        System.out.println("3. Carnet d'indices");
        System.out.println("4. Accuser (" + accusationsRestantes + " restantes)");
        System.out.println("5. Score");
        System.out.println("6. Quitter");
        System.out.print("> ");

        int choix = lireEntier();
        if (choix == -1) {
            quitter();
            return;
        }

        switch (choix) {
            case 1:
                interroger();
                break;
            case 2:
                chercherIndices();
                break;
            case 3:
                carnetIndices();
                break;
            case 4:
                accuser();
                break;
            case 5:
                afficherScore();
                break;
            case 6:
                quitter();
                break;
            default:
                System.out.println("Choix invalide.");
        }
    }

    public void interroger() {
        scoreJoueur.ajouterAction();
        System.out.println("\nChoisis un suspect :");

        for (int i = 0; i < suspects.length; i++) {
            System.out.println((i + 1) + ". " + suspects[i].nom);
        }

        int choix = lireEntier() - 1;
        if (choix == -2) {
            quitter();
            return;
        }

        if (choix >= 0 && choix < suspects.length) {
            suspects[choix].parler();
        } else {
            System.out.println("Choix invalide.");
        }
    }

    public void chercherIndices() {
        scoreJoueur.ajouterAction();
        System.out.println("\nRecherche d'un indice...");
        gestion.chercherIndice();
    }

    public void carnetIndices() {
        gestion.afficherCarnet();
    }

    public void accuser() {
        if (accusationsRestantes <= 0) {
            System.out.println("Tu n'as plus d'accusations disponibles.");
            return;
        }

        System.out.println("\nQui accusez-vous ?");
        for (int i = 0; i < suspects.length; i++) {
            System.out.println((i + 1) + ". " + suspects[i].nom);
        }

        int choix = lireEntier() - 1;
        if (choix == -2) {
            quitter();
            return;
        }

        if (choix < 0 || choix >= suspects.length) {
            System.out.println("Choix invalide.");
            return;
        }

        accusationsRestantes--;
        System.out.println(Constantes.MSG_SEPARATOR);

        if (choix == imposteurIndex) {
            System.out.println(Constantes.MSG_VICTOIRE);
            System.out.println("L'imposteur etait : " + suspects[imposteurIndex].nom);
            scoreJoueur.calculerScoreVictoire();
            scoreJoueur.afficherScore();
            System.out.println(Constantes.MSG_SEPARATOR);
            enCours = false;
            return;
        }

        System.out.println("Ce n'est pas le bon suspect.");
        scoreJoueur.ajouterFausseAccusation();

        if (accusationsRestantes > 0) {
            System.out.println("Il te reste " + accusationsRestantes + " accusation(s).");
            return;
        }

        System.out.println(Constantes.MSG_DEFAITE);
        System.out.println("L'imposteur etait : " + suspects[imposteurIndex].nom);
        scoreJoueur.calculerScoreDefaite();
        scoreJoueur.afficherScore();
        System.out.println(Constantes.MSG_SEPARATOR);
        enCours = false;
    }

    public void afficherScore() {
        scoreJoueur.afficherScore();
    }

    public void quitter() {
        System.out.println("Fin du jeu...");
        scoreJoueur.calculerScoreDefaite();
        scoreJoueur.afficherScore();
        enCours = false;
    }

    private int lireEntier() {
        return Entrees.lireEntier();
    }
}
