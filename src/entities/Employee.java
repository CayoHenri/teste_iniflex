package entities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Employee extends Person {
    BigDecimal remuneration;
    String function;

    public Employee(String name, LocalDate birth_date, BigDecimal remuneration, String function) {
        super(name, birth_date);
        this.remuneration = remuneration;
        this.function = function;
    }

    public BigDecimal getRemuneration() {
        return remuneration;
    }

    public void setRemuneration(BigDecimal remuneration) {
        this.remuneration = remuneration;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public void applyIncreaseSalary(BigDecimal percentage) {
        BigDecimal increaseSalary = remuneration.multiply(percentage);
        this.remuneration = remuneration.add(increaseSalary);
    }

    public BigDecimal calculateMinimumRemuneration(BigDecimal minimumRemuneration) {
        return remuneration.divide(minimumRemuneration, 2, RoundingMode.HALF_UP);
    }
}
