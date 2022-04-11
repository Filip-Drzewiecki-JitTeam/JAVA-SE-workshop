package jit.team.workshop.generics.service;

import jit.team.workshop.generics.objects.TaxEntity;

public class GenericTaxService {

    public<T extends TaxEntity> void calculateAnnualIncome(T entity) {
        double annualIncome = entity.calculateAnnualIncome();
        entity.setAnnualIncome(annualIncome);
        System.out.println("[GENERICS_TAX_SERVICE] income calculated for " + entity.getClass().getSimpleName() + " equals=" + annualIncome);
    }

    public<T extends TaxEntity> void calculateDueTax(T entity) {
        double dueTax = entity.calculateDueTax();
        entity.setDueTax(dueTax);
        System.out.println("[GENERICS_TAX_SERVICE] dueTax calculated for " + entity.getClass().getSimpleName() + " equals=" + dueTax);
    }
}
