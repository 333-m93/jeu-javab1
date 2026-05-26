public class Indice {

    private final String description;

    public Indice(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "- " + description;
    }
}
