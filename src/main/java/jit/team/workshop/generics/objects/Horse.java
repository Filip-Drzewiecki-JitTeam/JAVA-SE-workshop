package jit.team.workshop.generics.objects;

public class Horse implements Comparable<Horse> {

    private String name;
    private boolean isFast;

    public Horse(String name) {
        this.name = name;
    }

    public Horse(String name, boolean isFast) {
        this.name = name;
        this.isFast = isFast;
    }

    @Override
    public String toString() {
        return "Horse{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Horse o) {
        if (this.isFast && !o.isFast) {
            return 1;
        }
        if (!this.isFast && o.isFast) {
            return -1;
        }
        return 0;
    }
}
