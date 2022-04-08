package solutions;

import jit.team.workshop.exercises.*;
import jit.team.workshop.exercises.objects.Product;
import jit.team.workshop.exercises.objects.Shop;
import jit.team.workshop.exercises.service.ProductService;
import org.junit.jupiter.api.Test;
import solutions.annotations.Exercise;
import solutions.objects.Adult;
import solutions.objects.Animal;
import solutions.objects.Child;
import solutions.objects.Human;
import solutions.service.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExerciseSolutions {

    private final TaxService taxService = new TaxService();
    private final HumanService humanService = new HumanService();
    private final AnimalService animalService = new AnimalService();

    @Test
    @Exercise(Exercise1.class)
    public void exercise1() {
        double finalTax = taxService.calculateTax(85528);
        assertEquals(14539.76, finalTax);
    }

    @Test
    @Exercise(Exercise2.class)
    public void exercise2() {
        Human human1 = new Adult("David", 19, 90000.00);
        Human human2 = new Adult("Marry", 67, 45000.00);
        Human human3 = new Child("Bobby", 4, true);

        assertTrue(human1 instanceof Adult);
        assertFalse(human1 instanceof Child);
        assertNotNull(((Adult) human2).getIncome());
        assertTrue(((Child) human3).isHappy());
    }

    @Test
    @Exercise(Exercise3.class)
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

    @Test
    @Exercise(Exercise4.class)
    public void exercise4() {
        ProductService service = new ProductService();

        List<Product> products = ProductGenerator.generateProducts();

        double totalGain = products.stream()
                .map(product -> service.calculateGain(product))
                .reduce(0d, (subtotal, element) -> subtotal + element);

        double totalWholeSale = products.stream()
                .map(product -> product.getWholeSalePrice())
                .reduce(0d, (subtotal, element) -> subtotal + element);

        double totalRetail = products.stream()
                .map(product -> product.getRetailPrice())
                .reduce(0d, (subtotal, element) -> subtotal + element);

        double reverted = (totalWholeSale + totalGain) * 1.23;
        double diff = totalRetail - reverted;

        System.out.println("Total products:" + products.size());
        System.out.println("Total wholeSale: " + totalWholeSale);
        System.out.println("Total retail: " + totalRetail);
        System.out.println("Total gain: " + totalGain);
        System.out.println("Total reverted: " + reverted);

        assertTrue(diff < 1);
    }

    @Test
    @Exercise(Exercise5.class)
    public void exercise5() {
        ShopService shopService = new ShopService();

        List<Shop> shops = ShopGenerator.generateShops();

        Map<String, List<Shop>> shopMap = shops
                .stream()
                .collect(Collectors.groupingBy(Shop::getCity, toList()));

        double totalIncome = shopService.calculateGainForShopsOfCity(shopMap, "Gdańsk");

        assertTrue(totalIncome > 0);
    }

    @Test
    @Exercise(Exercise6.class)
    public void exercise6() {
        Animal bear = new Animal("Bear", 600.00);
        Animal deer = new Animal("Deer");

        assertNotNull(animalService.returnIfNullSafe(bear));
        assertNull(animalService.returnIfNullSafe(deer));
    }
}
