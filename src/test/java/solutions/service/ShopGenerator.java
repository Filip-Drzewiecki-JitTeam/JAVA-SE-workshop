package solutions.service;

import jit.team.workshop.exercises.objects.Shop;

import java.util.ArrayList;
import java.util.List;

public class ShopGenerator {

    public static List<Shop> generateShops() {
        List<Shop> shops = new ArrayList<>();
        shops.add(generateShop("Gdańsk"));
        shops.add(generateShop("Gdańsk"));
        shops.add(generateShop("Bydgoszcz"));
        shops.add(generateShop("Warszawa"));
        shops.add(generateShop("Kraków"));
        shops.add(generateShop("Gdańsk"));
        shops.add(generateShop("Bydgoszcz"));
        shops.add(generateShop("Warszawa"));
        return shops;
    }

    public static Shop generateShop(String city) {
        Shop shop = new Shop("Reversed");
        shop.setCity(city);
        shop.setProducts(ProductGenerator.generateProducts());
        return shop;
    }
}
