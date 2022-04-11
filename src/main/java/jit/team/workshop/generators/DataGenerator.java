package jit.team.workshop.generators;

import jit.team.workshop.exercises.objects.Shop;
import jit.team.workshop.generics.objects.Company;
import jit.team.workshop.generics.objects.Person;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DataGenerator {

    public static Person person() {
        Person person = new Person();
        person.setSalary(2000);
        return person;
    }

    public static Company company(int shopsAmount) {
        Company company = new Company();
        company.setShopsOwned(shopsWithIncome(shopsAmount));
        return company;
    }

    public static Shop shopWithIncome() {
        Shop shop = new Shop("Reversed");
        shop.setIncome(1000);
        return shop;
    }

    public static List<Shop> shopsWithIncome(int amount) {
        return IntStream.range(0, amount)
                .mapToObj(num -> shopWithIncome())
                .collect(Collectors.toList());
    }
}
