package services;

import entities.Employee;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeService {
    private static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final NumberFormat NF = NumberFormat.getNumberInstance();

    static {
        NF.setMinimumFractionDigits(2);
    }

    public static void removeByName(List<Employee> employees, String name) {
        employees.removeIf(employee -> employee.getName().equals(name));
    }

    public static void printEmployees(List<Employee> employees) {
        employees.forEach(employee -> {
            System.out.println(
                    employee.getName() + " | "
                            + employee.getBirth_date().format(DF) + " | R$ "
                            + NF.format(employee.getRemuneration()) + " | "
                            + employee.getFunction()
            );
        });
    }

    public static void applyAllSalariesIncrease(List<Employee> employees, BigDecimal percentage) {
        employees.forEach(employee -> employee.applyIncreaseSalary(percentage));
    }

    public static Map<String, List<Employee>> groupByFunction(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getFunction));
    }

    public static void printEmployeesByFunction(Map<String, List<Employee>> groupByFunction) {
        groupByFunction.forEach((function, employees) -> {
            System.out.println("\nFunção: " + function);
            employees.forEach(employee -> System.out.println(employee.getName()));
        });
    }

    public static void printBirthdayVelebrants(List<Employee> employees, int... months) {
        employees.stream().filter(employee -> {
            int month = employee.getBirth_date().getMonthValue();
            return Arrays.stream(months).anyMatch(monthInt -> month == monthInt);
        }).forEach(employee -> System.out.println(employee.getName()));
    }

    public static void printOlder(List<Employee> employees) {
        employees.stream().min(Comparator.comparing(Employee::getBirth_date))
                .ifPresent(employee ->
                        System.out.println(employee.getName() + " | " + employee.getAge() + " anos")
                );
    }

    public static void sortByName(List<Employee> employees) {
        employees.sort(Comparator.comparing(Employee::getName));
    }

    public static void printTotalSalaries(List<Employee> employees) {
        BigDecimal total = employees.stream().map(Employee::getRemuneration).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("\nTotal salários: R$ " + NF.format(total));
    }

    public static void printMinimumSalaries(List<Employee> employees, BigDecimal minimumSalary) {
        employees.forEach(employee -> {
            System.out.println(employee.getName() + " -> " + NF.format(
                    employee.calculateMinimumRemuneration(minimumSalary)
            ));
        });
    }
}
