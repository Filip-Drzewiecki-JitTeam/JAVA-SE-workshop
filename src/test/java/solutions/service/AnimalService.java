package solutions.service;

import solutions.objects.NullSafe;

public class AnimalService {

    public <T extends NullSafe> T returnIfNullSafe(T object) {
        if (object.isSafe()) {
            return object;
        }
        return null;
    }
}
