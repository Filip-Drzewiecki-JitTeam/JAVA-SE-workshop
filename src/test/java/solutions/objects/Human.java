package solutions.objects;

public class Human {
    private String country;
    private int age;

    public Human(String country, int age) {
        this.country = country;
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public int getAge() {
        return age;
    }
}
