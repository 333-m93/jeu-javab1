import java.util.ArrayList;
import java.util.Random;

public class GestionIndices {

    private final ArrayList<Indice> tousIndices = new ArrayList<>();
    private final ArrayList<Indice> carnetIndices = new ArrayList<>();
    private final Random random = new Random();

    public GestionIndices() {
        tousIndices.add(new Indice("Le coupable portait du jaune."));
        tousIndices.add(new Indice("Une personne a menti sur son alibi."));
        tousIndices.add(new Indice("Le coupable a ete vu pres du reacteur."));
        tousIndices.add(new Indice("Une trace de boue mene a la salle moteur."));
        tousIndices.add(new Indice("Le coupable semblait nerveux."));
    }

    public void chercherIndice() {
        if (tousIndices.isEmpty()) {
            System.out.println("Plus d'indices disponibles.");
            return;
        }

        int choix = random.nextInt(tousIndices.size());
        Indice indiceTrouve = tousIndices.remove(choix);
        carnetIndices.add(indiceTrouve);

        System.out.println("Indice trouve : " + indiceTrouve.getDescription());
    }

    public void afficherCarnet() {
        System.out.println("=== CARNET D'INDICES ===");

        if (carnetIndices.isEmpty()) {
            System.out.println("Aucun indice trouve.");
            return;
        }

        for (Indice indice : carnetIndices) {
            System.out.println(indice);
        }
    }
}
