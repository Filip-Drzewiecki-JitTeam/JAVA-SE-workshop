package jit.team.workshop.collections;

import java.util.Arrays;

public class ArrayService {

    public void practiceArrays() {
        int[] array = createArray();
        System.out.println(Arrays.toString(array));
    }

    private int[] createArray() {
        int[] array = new int[3];
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        return array;
    }

    private String[] createStringArray() {
        String[] stringArray = new String[20];
        stringArray[2] = "myString";
        return stringArray;
    }
}
