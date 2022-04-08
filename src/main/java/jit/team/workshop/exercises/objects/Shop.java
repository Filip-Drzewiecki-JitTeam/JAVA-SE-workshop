package jit.team.workshop.exercises.objects;

import java.util.List;

public class Shop {

    private final String name;
    private String city;
    private boolean online;
    private List<Product> products;
    private double income;

    public Shop(String name) {
        this.name = name;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getIncome() {
        return income;
    }
}
