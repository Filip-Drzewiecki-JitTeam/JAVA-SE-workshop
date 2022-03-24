package jit.team.workshop.generics.objects;

public class Plant implements Comparable<Plant> {

    private String name;
    private int length;

    public Plant(String name) {
        this.name = name;
    }

    public Plant(String name, int length) {
        this.name = name;
        this.length = length;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Plant o) {
        if (this.length > o.length) {
            return 1;
        }
        if (this.length < o.length) {
            return -1;
        }
        return 0;
    }
}
