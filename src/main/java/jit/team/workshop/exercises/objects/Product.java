package jit.team.workshop.exercises.objects;

public class Product {

    private final String name;
    private final double wholeSalePrice;
    private final double retailPrice;

    public Product(String name, double wholeSalePrice, double retailPrice) {
        this.name = name;
        this.wholeSalePrice = wholeSalePrice;
        this.retailPrice = retailPrice;
    }

    public String getName() {
        return name;
    }

    public double getWholeSalePrice() {
        return wholeSalePrice;
    }

    public double getRetailPrice() {
        return retailPrice;
    }
}
