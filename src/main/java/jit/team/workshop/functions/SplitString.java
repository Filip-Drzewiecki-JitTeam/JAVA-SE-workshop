package jit.team.workshop.functions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class SplitString implements Function<String, List> {

    @Override
    public List<String> apply(String val) {
        return Arrays.asList(val.split(","));
    }
}
