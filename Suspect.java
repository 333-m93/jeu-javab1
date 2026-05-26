import java.util.Random;

public class Suspect {

    String nom;
    String couleur;
    String alibi;
    boolean imposteur;

    public Suspect(String nom, String couleur, String alibi) {
        this.nom = nom;
        this.couleur = couleur;
        this.alibi = alibi;
        this.imposteur = false;
    }

    public void afficherSuspect() {
        System.out.println("Nom : " + nom);
        System.out.println("Couleur : " + couleur);
    }

    public void parler() {
        System.out.println(nom + " dit : " + alibi);
    }

    public static Suspect[] creerSuspects() {
        Suspect[] suspects = new Suspect[Constantes.NB_SUSPECTS];

        suspects[0] = new Suspect("Nini", "Rouge", "J'etais dans la salle des machines.");
        suspects[1] = new Suspect("Mohammed", "Bleu", "Je reparais les cameras.");
        suspects[2] = new Suspect("Esteban", "Vert", "Je dormais dans ma cabine.");
        suspects[3] = new Suspect("Julien", "Jaune", "Je mangeais a la cafeteria.");
        suspects[4] = new Suspect("Melvin", "Rose", "Je faisais une ronde de securite.");

        return suspects;
    }

    public static int choisirImposteur(Suspect[] suspects) {
        Random random = new Random();
        int index = random.nextInt(suspects.length);
        suspects[index].imposteur = true;
        return index;
    }
}
