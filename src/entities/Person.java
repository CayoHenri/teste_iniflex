package entities;

import java.time.LocalDate;
import java.time.Period;

public class Person {
    String name;
    LocalDate birth_date;

    public Person(String name, LocalDate birth_date) {
        this.name = name;
        this.birth_date = birth_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public int getAge() {
        return Period.between(birth_date, LocalDate.now()).getYears();
    }
}
