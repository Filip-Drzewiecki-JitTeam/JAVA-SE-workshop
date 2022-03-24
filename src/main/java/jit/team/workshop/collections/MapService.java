package jit.team.workshop.collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MapService {

    public void practiceMaps() {
        createMap();
        createMapOfParentsAndKids();
    }

    private Map<String, String> createMap() {
        Map<String, String> capitals = new HashMap<>();
        capitals.put("Poland", "Warsaw");
        capitals.put("Spain", "Madrid");
        capitals.put("Norway", "Oslo");
        capitals.put("Catalonia", "Barcelona");
        capitals.put("Ukraine", "Kiev");

        String key = capitals.get("Ukraine");
        System.out.println(key);

        return capitals;
    }

    private Map<String, List<String>> createMapOfParentsAndKids() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("Anne", List.of("John", "William"));
        map.put("Robert", List.of());
        map.put("Gregory", List.of("Sarah", "Susan", "Sally"));

        Set<String> keys = map.keySet();

        List<String> values = map.values()
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println("keys=" + keys);
        System.out.println("values=" + values);

        return map;
    }

    /**
     * Exercise 4
     * Create service that takes parameter of map that contains:
     * 1) keys - country of origin
     * 2) values - Lists of Humans
     *
     * Service should calculate taxes only for poles.
     * */
}
