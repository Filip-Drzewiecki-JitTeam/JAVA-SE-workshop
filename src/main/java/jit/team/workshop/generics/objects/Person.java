package jit.team.workshop.generics.objects;

public class Person extends TaxEntity {

    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public double calculateAnnualIncome() {
        return this.salary * 12;
    }

    @Override
    public double calculateDueTax() {
        return getAnnualIncome() * 0.32;
    }
}
