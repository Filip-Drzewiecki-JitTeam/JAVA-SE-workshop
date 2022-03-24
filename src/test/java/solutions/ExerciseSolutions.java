package solutions;

import org.junit.jupiter.api.Test;
import solutions.objects.Adult;
import solutions.objects.Child;
import solutions.objects.Human;
import solutions.service.HumanService;
import solutions.service.TaxService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExerciseSolutions {

    private final TaxService taxService = new TaxService();
    private final HumanService humanService = new HumanService();

    /**
     * Exercise 1
     * Create method that will count tax to pay.
     * 1. Method should accept 1 parameter - annual income.
     * 2. Method should return String with precise information - what is income, what is due tax.
     * Data to use:
     * first rate is up to 85 528 PLN. Rate is 17%.
     * second rate is above 85 528 PLN. Rate is 32%.
     * */
    @Test
    public void exercise1() {
        double finalTax = taxService.calculateTax(85528);
        assertEquals(14539.76, finalTax);
    }

    /**
     * Exercise 2
     * Create class Human and two classes that will inherit from it - Adult and Child.
     * Human should have at least name and age.
     * Adult should have information about income.
     * Child should have information whether it's happy or not.
     * */
    @Test
    public void exercise2() {
        Human human1 = new Adult("David", 19, 90000.00);
        Human human2 = new Adult("Marry", 67, 45000.00);
        Human human3 = new Child("Bobby", 4, true);

        assertTrue(human1 instanceof Adult);
        assertFalse(human1 instanceof Child);
        assertNotNull(((Adult) human2).getIncome());
        assertTrue(((Child) human3).isHappy());
    }


    /**
     * Exercise 3
     * create service that calculates taxes (with logic from exercise 1), but enhance it with objects and inheritance.
     * Method should accept parameter of class Human.
     * Method should calculate taxes only for Adults that have income and who's age is above 18 and below 65.
     * */
    @Test
    public void exercise3() {
        Human human1 = new Adult("David", 19, 85528.00);
        Human human2 = new Adult("Marry", 67, 45000.00);
        Human human3 = new Child("Bobby", 4, true);
        Human human4 = new Adult("Kirk", 45, 0.00);

        double tax1 = taxService.calculateTax(human1);
        double tax2 = taxService.calculateTax(human2);
        double tax3 = taxService.calculateTax(human3);
        double tax4 = taxService.calculateTax(human4);

        assertEquals(14539.76, tax1);
        assertEquals(0, tax2);
        assertEquals(0, tax3);
        assertEquals(0, tax4);
    }

    /**
     * Exercise 4
     * Create service that takes parameter of map that contains:
     * 1) keys - country of origin
     * 2) values - Lists of Humans
     *
     * Service should calculate taxes only for poles.
     * */
    @Test
    public void exercise4() {
        List<Human> humans = humanService.generateListOfHumans();

        Map<String, List<Human>> humanMap = humans
                .stream()
                .collect(Collectors.groupingBy(Human::getCountry, toList()));

        taxService.calculateTaxForPoles(humanMap);

        List<Adult> humansWithTaxCalculated = humans.stream()
                .filter(h -> h instanceof Adult)
                .map(h -> (Adult) h)
                .filter(adult -> adult.getDueTax() != null && adult.getDueTax() != 0.00)
                .collect(toList());

        assertEquals(1, humansWithTaxCalculated.size());
        assertEquals(14539.76, humansWithTaxCalculated.get(0).getDueTax());
    }
}
