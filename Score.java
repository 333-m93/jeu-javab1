public class Score {

    private int points;
    private int nbActions;
    private int nbFaussesAccusations;
    private long tempsDebutMs;
    private long tempsFinMs;
    private boolean chronoActif;

    public Score() {
        this.points = 0;
        this.nbActions = 0;
        this.nbFaussesAccusations = 0;
        this.chronoActif = false;
    }

    public void demarrerChrono() {
        this.tempsDebutMs = System.currentTimeMillis();
        this.chronoActif = true;
        System.out.println("  Chronometre demarre !");
    }

    public void arreterChrono() {
        if (chronoActif) {
            this.tempsFinMs = System.currentTimeMillis();
            this.chronoActif = false;
        }
    }

    public long getTempsEcouleSecondes() {
        if (chronoActif) {
            return (System.currentTimeMillis() - tempsDebutMs) / 1000;
        }
        return (tempsFinMs - tempsDebutMs) / 1000;
    }

    public String getTempsFormate() {
        long secondes = getTempsEcouleSecondes();
        long min = secondes / 60;
        long sec = secondes % 60;
        return String.format("%02d:%02d", min, sec);
    }

    public void ajouterAction() {
        this.nbActions++;
    }

    public void ajouterFausseAccusation() {
        this.nbFaussesAccusations++;
        this.points -= Constantes.POINT_MALUS_FAUSSE_ACCUSATION;
        System.out.println("  Mauvaise accusation ! "
                + Constantes.POINT_MALUS_FAUSSE_ACCUSATION + " points");
    }

    public void calculerScoreVictoire() {
        arreterChrono();

        points += Constantes.POINT_VICTOIRE;

        if (nbActions < 5) {
            points += Constantes.POINT_BONUS;
            System.out.println("  Bonus rapidite (< 5 actions) : +"
                    + Constantes.POINT_BONUS);
        }

        if (nbFaussesAccusations == 0) {
            points += Constantes.POINT_BONUS_PREMIER_COUP;
            System.out.println("  Bonus precision (0 faute) : +"
                    + Constantes.POINT_BONUS_PREMIER_COUP);
        }

        long temps = getTempsEcouleSecondes();
        if (temps < Constantes.TEMPS_RAPIDE) {
            int bonusTemps = 40;
            points += bonusTemps;
            System.out.println("  Bonus temps (< 60s) : +" + bonusTemps);
        }
    }

    public void calculerScoreDefaite() {
        arreterChrono();
        if (points < 0) {
            points = 0;
        }
    }

    public int getPoints() {
        return points;
    }

    public int getNbActions() {
        return nbActions;
    }

    public int getNbFaussesAccusations() {
        return nbFaussesAccusations;
    }

    public boolean isChronoActif() {
        return chronoActif;
    }

    public void afficherScore() {
        System.out.println("==============================");
        System.out.println("  SCORE FINAL : " + points + " pts");
        System.out.println("  Temps       : " + getTempsFormate());
        System.out.println("  Actions     : " + nbActions);
        System.out.println("  Fausses acc : " + nbFaussesAccusations);
        System.out.println("==============================");
    }
}
