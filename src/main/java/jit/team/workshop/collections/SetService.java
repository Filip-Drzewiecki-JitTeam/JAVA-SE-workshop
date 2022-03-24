package jit.team.workshop.collections;

import jit.team.workshop.inheritance.objects.Horse;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SetService {

    public void practiceSets() {
//        createSet();
//        Set<Horse> horses = createSetOfObjects();
//        checkIfContains(horses);
//        iterateThroughSet(horses);
//        mapList();
    }

    private Set createSet() {
        Set<String> set = new HashSet<>();
        set.add("John");
        set.add("Annie");
        set.add("William");
        set.add("John");
        System.out.println("Set includes=" + set);
        return set;
    }

    private Set createSetOfObjects() {
        Set<Horse> horses = new HashSet<>();
        horses.add(new Horse("John", "black"));
        horses.add(new Horse("Annie", "brown"));
        horses.add(new Horse("William", "white"));
        horses.add(new Horse("John", "white"));
        System.out.println("Set of horses includes=" + horses.stream().map(Horse::getName).collect(Collectors.toList()));
        return horses;
    }

    private void checkIfContains(Set<Horse> horses) {
        boolean contains = horses.contains(new Horse("John", "white"));
        System.out.println("Set contains element with given parameters = " + contains);
    }

    private void iterateThroughSet(Set<Horse> horses) {
        Iterator<Horse> iterator = horses.iterator();
        while (iterator.hasNext()) {
            Horse horse = iterator.next();
            System.out.println("Next Horse is: " + horse);
        }
    }

    private void mapList() {
        List<Horse> listOfHorses = List.of(
                new Horse("John", "black"),
                new Horse("John", "white"),
                new Horse("Annie", "brown"));

        System.out.println(listOfHorses);

        Set<String> names = mapListToNameSet(listOfHorses);

        System.out.println(names);
    }

    private Set<String> mapListToNameSet(List<Horse> horses) {
        return horses
                .stream()
                .map(Horse::getName)
                .collect(Collectors.toSet());
    }
}
