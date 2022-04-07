package jit.team.workshop.files.objects;

import java.util.Map;

public interface Mappable<T> {
    T ofMap(Map<String, Object> fields);

    String toCsvRow();
}
