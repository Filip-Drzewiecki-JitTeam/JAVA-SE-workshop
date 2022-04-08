package jit.team.workshop.functions;

import java.util.function.Predicate;

public class IsBlank implements Predicate<String> {
    @Override
    public boolean test(String s) {
        if (s == null) {
            return true;
        }
        return s.isBlank();
    }
}
