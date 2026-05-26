import java.util.Scanner;

public final class Entrees {

    public static final Scanner SCANNER = new Scanner(System.in);

    private Entrees() {
    }

    public static int lireEntier() {
        while (SCANNER.hasNext()) {
            String token = SCANNER.next();

            try {
                return Integer.parseInt(token);
            } catch (NumberFormatException exception) {
                System.out.print("Entre un nombre valide : ");
            }
        }

        return -1;
    }
}
