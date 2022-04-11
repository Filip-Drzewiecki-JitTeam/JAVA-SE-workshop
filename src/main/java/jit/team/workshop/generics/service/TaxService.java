package jit.team.workshop.generics.service;

import jit.team.workshop.generics.objects.Company;
import jit.team.workshop.generics.objects.Person;

public class TaxService {

    public void calculateAnnualIncomeForCompany(Company company) {
        double annualIncome = company.getShopsOwned().stream()
                .map(shop -> shop.getIncome())
                .reduce(0d, (total, el) -> total + el);
        company.setAnnualIncome(annualIncome);
        System.out.println("[TAX_SERVICE] income calculated for company equals=" + annualIncome);
    }

    public void calculateAnnualIncomeForPerson(Person person) {
        double annualIncome = person.getSalary() * 12;
        person.setAnnualIncome(annualIncome);
        System.out.println("[TAX_SERVICE] income calculated for person equals=" + annualIncome);
    }

    public void calculateDueTaxForCompany(Company company) {
        double dueTax = company.getAnnualIncome() * 0.19;
        company.setDueTax(dueTax);
        System.out.println("[TAX_SERVICE] dueTax calculated for company equals=" + dueTax);
    }

    public void calculateDueTaxForPerson(Person person) {
        double dueTax = person.getAnnualIncome() * 0.32;
        person.setDueTax(dueTax);
        System.out.println("[TAX_SERVICE] dueTax calculated for person equals=" + dueTax);
    }
}
