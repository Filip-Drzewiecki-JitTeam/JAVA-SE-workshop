package jit.team.workshop.files;

import jit.team.workshop.files.objects.Mappable;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CsvMapper<T extends Mappable<T>> {

    private List<String> schema;
    private final Class<T> clazz;

    public CsvMapper(Class<T> clazz, List<String> schema) {
        this.schema = schema;
        this.clazz = clazz;
    }

    public CsvMapper(Class<T> clazz) {
        this.clazz = clazz;
    }

    public List<T> map(InputStream stream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

        List<String[]> lines = reader.lines()
                .map(row -> row.split(","))
                .collect(Collectors.toList());

        setSchemaIfNotProvided(lines);

        List<Map<String, Object>> fields = lines.stream()
                .map(this::mapRow)
                .collect(Collectors.toList());

        return mapObjects(fields);
    }

    public Map<String, Object> mapRow(String[] elements) {
        Map<String, Object> object = new HashMap<>();
        int maxIndex = schema.size();
        int index = 0;
        for (String element : elements) {
            if (index >= maxIndex) {
                break;
            }
            object.put(schema.get(index), element);
            index++;
        }
        return object;
    }

    public List<T> mapObjects(List<Map<String, Object>> list) {
        return list.stream().map(this::mapObject).collect(Collectors.toList());
    }

    private T mapObject(Map<String, Object> map) {
        try {
            Constructor<T> constructor = clazz.getConstructor();
            return constructor.newInstance().ofMap(map);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void setSchemaIfNotProvided(List<String[]> lines) {
        if (schema != null || lines.size() == 0) {
            return;
        }
        String[] firstRow = lines.get(0);
        schema = Arrays.stream(firstRow).collect(Collectors.toList());
        lines.remove(0);
    }
}
