package jit.team.workshop.variables;

import java.util.Random;

public class ConditionsService {

    public void practiceConditions() {
        //simpleIf();
        //elseIf();
        //nestedIf();
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
        int randomNumber = getRandomNumberUsingNextInt(1, 50);
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

    public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max) + min;
    }

    /**
     * Exercise 1
     * Create method that will count tax to pay.
     * 1. Method should accept 1 parameter - annual income.
     * 2. Method should return String with precise information - what is income, what is due tax.
     * Data to use:
     * first rate is up to 85 528 PLN. Rate is 17%.
     * second rate is above 85 528 PLN. Rate is 32%.
     * */
}
