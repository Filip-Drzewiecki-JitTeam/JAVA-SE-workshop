package jit.team.workshop.exercises.service;

import jit.team.workshop.exercises.objects.Product;

public class ProductService {

    public double calculateGain(Product product) {
        double nett = product.getRetailPrice() / 1.23;
        return nett - product.getWholeSalePrice();
    }
}
