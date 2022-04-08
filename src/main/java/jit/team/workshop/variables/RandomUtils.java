package jit.team.workshop.variables;

import java.util.Random;

public class RandomUtils {

    public static int generateRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max) + min;
    }

    public static double generateRandomDouble(double min, double max) {
        Random random = new Random();
        return min + (max - min) * random.nextDouble();
    }
}
