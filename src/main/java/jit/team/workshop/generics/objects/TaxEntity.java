package jit.team.workshop.generics.objects;

import jit.team.workshop.generics.interfaces.Taxable;

public abstract class TaxEntity implements Taxable {

    private double annualIncome;
    private double dueTax;

    public double getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(double annualIncome) {
        this.annualIncome = annualIncome;
    }

    public double getDueTax() {
        return dueTax;
    }

    public void setDueTax(double dueTax) {
        this.dueTax = dueTax;
    }
}
