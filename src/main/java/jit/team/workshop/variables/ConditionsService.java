package jit.team.workshop.variables;

import jit.team.workshop.exercises.Exercise1;

import java.util.Random;

public class ConditionsService {

    public void practiceConditions() {
        //simpleIf();
        //elseIf();
        //nestedIf();

        new Exercise1().doExercise();
    }

    private void simpleIf() {
        if (true) {
            System.out.println("This statement is printed, when boolean is True");
        } else {
            System.out.println("This statement is printed, when boolean is False");
        }
    }

    private void elseIf() {
        double equationResult = 2.89 * 2.37;

        boolean isGreater = equationResult > 6.85;
        boolean isEven = equationResult == 6.85;

        if (isGreater) {
            System.out.println("isGreater");
        } else if (isEven) {
            System.out.println("isEven");
        }
    }

    private void nestedIf() {
        int randomNumber = RandomUtils.generateRandomInt(1, 50);
        if (randomNumber > 10) {
            System.out.println("Bigger than 10");
            if (randomNumber > 30) {
                System.out.println("Bigger than 30");
                if (randomNumber == 50) {
                    System.out.println("Equal to 50");
                }
            }
        } else {
            System.out.println("Smaller than 10");
        }
        System.out.println("number=" + randomNumber);
    }
}
