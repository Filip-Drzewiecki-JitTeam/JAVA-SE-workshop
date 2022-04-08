package solutions.service;

import jit.team.workshop.exercises.objects.Shop;
import jit.team.workshop.exercises.service.ProductService;

import java.util.List;
import java.util.Map;

public class ShopService {

    public double calculateGainForShopsOfCity(Map<String, List<Shop>> shops, String city) {
        List<Shop> shopsFromCity = shops.get(city);

        double totalIncome =  shopsFromCity.stream()
                .map(shop -> calculateAndSendIncome(shop))
                .map(shop -> shop.getIncome())
                .reduce(0d, (sub, el) -> sub + el);

        System.out.println("Total income for " + shopsFromCity.size() + " shops is " + totalIncome);
        return totalIncome;
    }

    public Shop calculateAndSendIncome(Shop shop) {
        ProductService service = new ProductService();
        double income = shop.getProducts().stream()
                .map(product -> service.calculateGain(product))
                .reduce(0d, (sub, el) -> sub + el);
        shop.setIncome(income);
        return shop;
    }
}
