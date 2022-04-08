package solutions.service;

import jit.team.workshop.exercises.objects.Product;
import jit.team.workshop.variables.RandomUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProductGenerator {

    public static List<Product> generateProducts() {
        int amount = RandomUtils.generateRandomInt(1, 100);
        return IntStream.range(0, amount)
                .mapToObj(num -> generateProduct())
                .collect(Collectors.toList());
    }

    public static Product generateProduct() {
        double wholeSale = RandomUtils.generateRandomDouble(0, 10);
        double gainPercentage = RandomUtils.generateRandomDouble(1, 2);
        double retail = wholeSale * gainPercentage;
        return new Product(getRandomProduct(), wholeSale, retail);
    }

    private static String getRandomProduct() {
        List<String> products = List.of("ToyCar", "Carrot", "Coke", "Cheeseburger", "Potatoes");
        int random = RandomUtils.generateRandomInt(0, 4);
        return products.get(random);
    }
}
