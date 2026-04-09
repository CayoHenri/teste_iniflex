import entities.Employee;
import mocks.EmployeeMock;
import services.EmployeeService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // 3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela
        List<Employee> employees = EmployeeMock.addEmployees();
        System.out.println("\n=== FUNCIONÁRIOS ===");
        EmployeeService.printEmployees(employees);

        // 3.2 – Remover o funcionário “João” da lista.
        EmployeeService.removeByName(employees, "João");

        // 3.3 – Imprimir todos os funcionários com todas suas informações
        System.out.println("\n=== Depois de remover o João ===");
        EmployeeService.printEmployees(employees);

        // 3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
        System.out.println("\n=== Depois do aumento de 10% ===");
        EmployeeService.applyAllSalariesIncrease(employees, new BigDecimal("0.10"));
        EmployeeService.printEmployees(employees);

        // 3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
        Map<String, List<Employee>> groupByFunction = EmployeeService.groupByFunction(employees);

        // 3.6 – Imprimir os funcionários, agrupados por função.
        System.out.println("\n=== Funcionários agrupados por função ===");
        EmployeeService.printEmployeesByFunction(groupByFunction);

        // 3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
        System.out.println("\n=== Aniversáriantes no mês 10 e 12 ===");
        EmployeeService.printBirthdayVelebrants(employees, 10, 12);

        // 3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
        System.out.println("\n=== Funcionário mais velho ===");
        EmployeeService.printOlder(employees);

        // 3.10 – Imprimir a lista de funcionários por ordem alfabética.
        EmployeeService.sortByName(employees);
        System.out.println("\n=== Lista ordenada por ordem  alfabética ===");
        EmployeeService.printEmployees(employees);

        // 3.11 – Imprimir o total dos salários dos funcionários.
        EmployeeService.printTotalSalaries(employees);

        // 3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.
        System.out.println("\n=== Quantidade de salários mínimos ===");
        EmployeeService.printMinimumSalaries(employees, new BigDecimal("1212.00"));
    }

}