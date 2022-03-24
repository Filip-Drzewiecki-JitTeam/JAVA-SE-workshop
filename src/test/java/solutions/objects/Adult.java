package solutions.objects;

public class Adult extends Human {
    private Double income;
    private Double dueTax;

    public Adult(String id, int age, Double income) {
        super(id, age);
        this.income = income;
    }

    public Double getIncome() {
        return income;
    }

    public Double getDueTax() {
        return dueTax;
    }

    public void setDueTax(Double dueTax) {
        this.dueTax = dueTax;
    }
}
