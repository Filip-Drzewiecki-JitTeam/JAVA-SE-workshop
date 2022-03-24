package solutions.objects;

public class Animal implements NullSafe {

    private String name;
    private Double weight;

    public Animal(String name, Double weight) {
        this.name = name;
        this.weight = weight;
    }

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public boolean isSafe() {
        return name != null && weight != null;
    }
}
