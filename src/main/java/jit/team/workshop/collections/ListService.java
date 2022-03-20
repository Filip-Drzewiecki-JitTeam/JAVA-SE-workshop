package jit.team.workshop.collections;

import jit.team.workshop.inheritance.objects.SportCar;
import jit.team.workshop.inheritance.objects.Truck;
import jit.team.workshop.inheritance.interfaces.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListService {

    public void practiceLists() {
        produceCars();
    }

    public List<String> createList(String... strings) {
        List<String> list = new ArrayList<>();
        for (String str : strings) {
            list.add(str);
        }
        return list;
    }

    private void produceCars() {
        List<Car> cars = generateCars(20);
        System.out.println("Produced cars=" + cars.size());
        List<SportCar> sportsCars = new ArrayList<>();
        List<Truck> trucks = new ArrayList<>();
        for (Car car : cars) {
            if (car instanceof SportCar) {
                sportsCars.add((SportCar) car);
            } else if (car instanceof Truck) {
                trucks.add((Truck) car);
            }
        }
        System.out.println("Number of sports cars=" + sportsCars.size());
        System.out.println("Number of trucks=" + trucks.size());
    }

    private List<Car> generateCars(int amount) {
        int carsNum = 25;
        int trucksNum = amount - carsNum;

        List<Car> cars = new ArrayList<>();

        List<Car> sportCars = IntStream.range(0, carsNum)
                .mapToObj(num -> new SportCar(250))
                .collect(Collectors.toList());

        List<Car> trucks = IntStream.range(0, trucksNum)
                .mapToObj(num -> new Truck(120))
                .collect(Collectors.toList());

        cars.addAll(sportCars);
        cars.addAll(trucks);
        return cars;
    }
}
