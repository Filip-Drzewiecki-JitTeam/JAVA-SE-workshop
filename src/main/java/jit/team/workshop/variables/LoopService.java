package jit.team.workshop.variables;

import java.util.Arrays;

public class LoopService {

    public void practiceLoops() {
        //basicForLoop();
        //whileLoop();
        //doWhileLoop();
        //forEachLoop();
    }

    private void basicForLoop() {
        for (int i = 0; i <= 10; i++) {
            System.out.println("value of variable i equals=" + i);
        }
    }

    private void whileLoop() {
        int i = 0;
        while (i < 10) {
            System.out.println("value is still lesser than 10. Value=" + i);
            i++;
        }
        System.out.println("value is greater than or equal 10 now");
    }

    private void doWhileLoop() {
        int i = 0;
        int increment = 1;
        do {
            System.out.println("value equals " + i + ". Incrementing by " + increment);
            i+=increment;
        } while (i <= 10);
    }

    private void forEachLoop() {
        int[] array = {1, 2, 3};

        for (int i : array) {
            System.out.println("Currently processing integer " + i);
            i = i + 10;
            System.out.println("Transformed it into " + i);
        }
    }
}
