package jit.team.workshop.generics.service;

import jit.team.workshop.generators.DataGenerator;
import jit.team.workshop.generics.objects.ChessPlayer;
import jit.team.workshop.generics.objects.Company;
import jit.team.workshop.generics.objects.Horse;
import jit.team.workshop.generics.objects.Person;
import jit.team.workshop.generics.objects.Plant;
import jit.team.workshop.generics.objects.Team;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GenericsService {

    public void practiceGenerics() {
        //useGenerics();
        //compareGenerics();
        //useGenericObjects();
        whyUseGenerics();
        //new Exercise6().doExercise();
    }

    public void useGenerics() {
        Horse rafael = new Horse("Rafael");
        Horse guillermo = new Horse("Guillermo");

        List<Horse> list = combineObjectsIntoList(rafael, guillermo);
        System.out.println(list);

    }

    public <T> List<T> combineObjectsIntoList(T element1, T element2) {
        return List.of(element1, element2);
    }

    private void compareGenerics() {
        Horse rafael = new Horse("Rafael", true);
        Horse guillermo = new Horse("Guillermo", false);
        System.out.println("Faster horse is=" + compare(rafael, guillermo));

        Plant rose = new Plant("Rose", 10);
        Plant oak = new Plant("Oak", 1000);
        System.out.println("Bigger plant is=" + compare(rose, oak));
    }

    private <T extends Comparable<T>> T compare(T element1, T element2) {
        if (element1.compareTo(element2) > 0) {
            return element1;
        }
        if (element1.compareTo(element2) < 0) {
            return element2;
        }
        return null;
    }

    private void useGenericObjects() {
        Team<ChessPlayer> team = new Team<>();
        team.add(new ChessPlayer("Jan Krzysztof Duda"));
        team.add(new ChessPlayer("Magnus Carlsen"));
        System.out.println("First team member is=" + team.get(0));
        System.out.println("All team members=" + team);
    }

    private void whyUseGenerics() {
        useOneMethodInsteadOfMany();
        genericMethodVsTypelessMethod();
        useGenericsWithInterfaces();
    }

    /**
     * Method 'sumAnyNumber()' accepts any type that extends Number and therefore allows us to sum infinite amount
     * of elements of any type as long as it's any sort of number.
     * Using generics here allows us to have one methods that sums anything instead of many separate methods that sum
     * one type of number at a time.
     */
    private void useOneMethodInsteadOfMany() {
        System.out.println("sum doubles:" + sumDoublesOnly(1d, 2d, 3d, 4d, 1d));
        System.out.println("sum integers:" + sumIntegersOnly(1, 2, 3, 4, 1));

        System.out.println("sum anything:" + sumAnyNumber(1f, 2.0, 3L, 4, BigDecimal.ONE));

    }

    private <T extends Number> Double sumAnyNumber(T... elements) {
        double num = 0.0;
        for (T el : elements) {
            num += el.doubleValue();
        }
        return num;
    }

    private Integer sumIntegersOnly(Integer... elements) {
        Integer num = 0;
        for (Integer el : elements) {
            num += el;
        }
        return num;
    }

    private Double sumDoublesOnly(Double... elements) {
        double num = 0.0;
        for (Double el : elements) {
            num += el;
        }
        return num;
    }

    /**
     * Both methods 'createGenericList()' and 'createList' accept any amount of parameters of any type
     * and remove nulls and blanks from it.
     * 'createGenericsList' however checks types and ensures that it stores only one selected type at a time
     * and return type List<TYPE> is always true.
     * 'createList' despite declaration that returns List<Double> in fact stores no doubles, but strings and objects.
     */
    public void genericMethodVsTypelessMethod() {
        List<Double> doubles = createGenericList(12d, null, 13d);
        List<String> strings = createGenericList("StringOne", null, "");
        List<Double> lies = createList("dsa", null, "", 5, new Horse("Rafael"));

        System.out.println("doubles:" + doubles);
        System.out.println("strings:" + strings);
        System.out.println("lies:" + lies);
    }

    private <T> List<T> createGenericList(T... elements) {
        return Arrays.stream(elements)
                .filter(val -> !isBlank(val))
                .collect(Collectors.toList());
    }

    private List createList(Object... elements) {
        return Arrays.stream(elements)
                .filter(val -> !isBlank(val))
                .collect(Collectors.toList());
    }

    private boolean isBlank(Object o) {
        if (o == null) {
            return true;
        }
        if (o instanceof String) {
            return ((String) o).isBlank();
        }
        return false;
    }

    /**
     * Both 'GenericTaxService' and 'TaxService' do exactly the same thing - calculate annual income and due tax.
     * Both income and taxes are counted different way for different entities.
     * Person only multiplies its salary by number of months, while Company needs to count all profits from all owned shops.
     *
     * Even when business requirements change and service will need to implement incomes and taxes for new entities - such as
     * Global corporations, NGOs or special types of person - such as Foreign person or person that doesn't have work but has income -
     * GenericTaxService doesn't need to change single line of code, while TaxService will need to be modified or even rewritten.
     *
     * More entities we will want to include will cause regular service to be difficult to maintain, a lot of new lines, while
     * generic service will stay the same all the time.
     */
    public void useGenericsWithInterfaces() {
        GenericTaxService genericTaxService = new GenericTaxService();
        TaxService taxService = new TaxService();

        Company company = DataGenerator.company(10);
        Person person = DataGenerator.person();

        genericTaxService.calculateAnnualIncome(company);
        genericTaxService.calculateAnnualIncome(person);

        genericTaxService.calculateDueTax(company);
        genericTaxService.calculateDueTax(person);

        taxService.calculateAnnualIncomeForCompany(company);
        taxService.calculateAnnualIncomeForPerson(person);

        taxService.calculateDueTaxForCompany(company);
        taxService.calculateDueTaxForPerson(person);
    }
}
