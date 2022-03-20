package jit.team.workshop.variables;

public class StringService {

    public void helloWorld() {
        String myString1 = "Hello";
        String myString2 = "World";

        System.out.println(myString1 + myString2);
    }

    public void method() {
        String string = "Java";
        String str = new String("Java");
        boolean equal = string.equals(str);
        boolean same = string == str;
        System.out.println("== " + same);
        System.out.println("equals " + equal);
    }
}
