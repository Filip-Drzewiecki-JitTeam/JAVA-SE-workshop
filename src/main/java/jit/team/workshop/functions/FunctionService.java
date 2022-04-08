package jit.team.workshop.functions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionService {

    public void practiceFunctions() {
        //practiceLambda();
        //practicePredicate();
    }

    public void practiceLambda() {
        Function<String, List> func = new SplitString();
        List<String> split = func.apply("Jit,Team");
        System.out.println("Function split:" + split);

        Function<String, List> lambdaFunc = val -> Arrays.asList(val.split(","));
        List<String> lambdaSplit = func.apply("Jit,Team");
        System.out.println("Lambda split:" + split);
    }

    public void practicePredicate() {
        String[] vals = new String[10];
        vals[2] = "Gdańsk";
        vals[5] = "";
        vals[8] = "Sopot";
        System.out.println("Array:" + Arrays.toString(vals));

        Predicate<String> predicate = new IsBlank();

        List<String> filtered = Arrays.stream(vals)
                .filter(value -> !predicate.test(value))
                .collect(Collectors.toList());

        System.out.println("Filtered:" + filtered);
    }

    private Predicate<String> isGdansk() {
        return val -> "Gdańsk".equals(val);
    }
}
