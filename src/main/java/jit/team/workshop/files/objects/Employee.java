package jit.team.workshop.files.objects;

import java.math.BigDecimal;

import java.util.Map;

public class Employee implements Mappable<Employee> {

    private String name;
    private Integer age;
    private BigDecimal income;

    public Employee() {
    }

    public Employee(String name, Integer age, BigDecimal income) {
        this.name = name;
        this.age = age;
        this.income = income;
    }

    @Override
    public Employee ofMap(Map<String, Object> fields) {
        Employee em = new Employee();
        em.name = (String) fields.get("name");
        em.age = Integer.parseInt((String) fields.get("age"));
        em.income = new BigDecimal((String) fields.get("income"));
        return em;
    }

    @Override
    public String toCsvRow() {
        return this.name + "," +
                this.age + "," +
                this.income.toString() + "\r\n";
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public BigDecimal getIncome() {
        return income;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", income=" + income +
                '}';
    }
}
