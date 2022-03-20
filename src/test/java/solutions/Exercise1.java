package solutions;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise1 {

    @Test
    public void testTaxRates() {
        double finalTax = calculateTax(85528);
        assertEquals(finalTax, 14539.76);
    }


    private double calculateTax(double income) {
        double firstRate = 85528;
        double finalTax = 0;
        if (income <= firstRate) {
            finalTax = income * 0.17;
        }
        if (income > firstRate) {
            double firstRateTax = firstRate * 0.17;
            double difference = income - firstRate;
            double secondRateTax = difference * 0.32;
            finalTax = firstRateTax + secondRateTax;
        }
        System.out.println("For income=" + income + " due tax equals=" + finalTax);
        DecimalFormat df = new DecimalFormat("########.##", DecimalFormatSymbols.getInstance(Locale.ENGLISH));

        return Double.parseDouble(df.format(finalTax));
    }
}
