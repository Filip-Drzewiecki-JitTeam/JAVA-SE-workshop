package jit.team.workshop.generics.objects;

import jit.team.workshop.exercises.objects.Shop;

import java.util.List;

public class Company extends TaxEntity {

    private List<Shop> shopsOwned;

    public List<Shop> getShopsOwned() {
        return shopsOwned;
    }

    public void setShopsOwned(List<Shop> shopsOwned) {
        this.shopsOwned = shopsOwned;
    }

    @Override
    public double calculateAnnualIncome() {
        return shopsOwned.stream()
                .map(shop -> shop.getIncome())
                .reduce(0d, (total, el) -> total + el);
    }

    @Override
    public double calculateDueTax() {
        return this.getAnnualIncome() * 0.19;
    }
}
