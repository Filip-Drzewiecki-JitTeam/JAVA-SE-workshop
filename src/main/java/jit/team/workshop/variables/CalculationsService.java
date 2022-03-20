package jit.team.workshop.variables;

public class CalculationsService {

    public void practiceCalculations() {

        byte byte1 = 127;
        short short1 = 32767;
        int integer = 2147483647;
        long long1 = 9223372036854775807L;

        float float1 = 2.1234567F;
        double double1 = 2.123456789123457;

        boolean bool = true;
        char chr = 'A';

        int additionEquation = add(byte1, short1);
        int reminderEquation = reminder(1, 3);
        System.out.println(reminderEquation);
    }

    private int add(int val1, int val2) {
        return val1 + val2;
    }

    private int reminder(int val1, int val2) {
        return val1 % val2;
    }
}
