package solutions.objects;

public class Child extends Human {

    private boolean isHappy;

    public Child(String id, int age, boolean isHappy) {
        super(id, age);
        this.isHappy = isHappy;
    }

    public boolean isHappy() {
        return isHappy;
    }
}
