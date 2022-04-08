package jit.team.workshop.collections;

import jit.team.workshop.exercises.Exercise4;
import jit.team.workshop.inheritance.objects.SportCar;
import jit.team.workshop.inheritance.objects.Truck;
import jit.team.workshop.inheritance.interfaces.Car;
import jit.team.workshop.variables.ConditionsService;
import jit.team.workshop.variables.RandomUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListService {

    public void practiceLists() {
        //produceCars();
        //flattenList();

        new Exercise4().doExercise();
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
        int carsNum = RandomUtils.generateRandomInt(0, amount);
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

    private void flattenList() {
        List<List<String>> listsOfLists = createListsOfLists();

        System.out.println("list contains " + listsOfLists.size() + "elements");

        List<String> flattenedList = listsOfLists
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        System.out.println("flattened list contains " + flattenedList.size() + "elements");
    }

    private List<List<String>> createListsOfLists() {
        List<List<String>> listsOfLists = new ArrayList<>();
        List<String> list1 = List.of("Warsaw", "Gdansk", "Cracow");
        List<String> list2 = List.of("Bilbao", "Barcelona", "Valencia");
        List<String> list3 = List.of("Oslo");

        listsOfLists.add(list1);
        listsOfLists.add(list2);
        listsOfLists.add(list3);

        return listsOfLists;
    }
}
