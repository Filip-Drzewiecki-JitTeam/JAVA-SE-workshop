package solutions.service;

import solutions.objects.Adult;
import solutions.objects.Child;
import solutions.objects.Human;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class TaxService {

    public double calculateTax(double income) {
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

    public double calculateTax(Human human) {
        if (human instanceof Child) {
            return 0;
        }
        if (human.getAge() < 18 || human.getAge() > 65) {
            return 0;
        }
        Adult adult = (Adult) human;
        if (adult.getIncome() == 0) {
            return 0;
        }
        return calculateTax(adult.getIncome());
    }

    public void calculateAndSetTax(Adult adult) {
        double calculatedTax = calculateTax(adult);
        adult.setDueTax(calculatedTax);
    }

    public void calculateTaxForPoles(Map<String, List<Human>> humans) {
        List<Human> poles = humans.get("Poland");
        poles.stream()
                .filter(h -> h instanceof Adult)
                .map(h -> (Adult) h)
                .forEach(this::calculateAndSetTax);
    }
}
