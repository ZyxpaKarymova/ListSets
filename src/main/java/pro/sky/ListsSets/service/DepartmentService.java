package pro.sky.ListsSets.service;

import org.springframework.stereotype.Service;
import pro.sky.ListsSets.exceptions.EmployeeNotFoundException;
import pro.sky.ListsSets.model.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee findEmployeeWithMaxSalary(int department) {
        return employeeService.findAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max((employee1, employee2) -> employee1.getSalary() - employee2.getSalary())
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee findEmployeeWithMinSalary(int department) {
        return employeeService.findAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min((employee1, employee2) -> employee1.getSalary() - employee2.getSalary())
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Collection<Employee> findEmployeeFromDepartment(int department) {
        return employeeService.findAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());
    }

    public Map<Integer, Collection<Employee>> findEmployees() {
        return employeeService.findAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.toCollection(ArrayList::new)));
    }


 /*   public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void indexSalariesForDepartment(int index, int department) {
        employeeService.findAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .forEach(employee -> employee.setSalary((int) employee.getSalary() + employee.getSalary() * index / 100));
    }


    public double averageSalaryForDepartment(int department) {
        return employeeService.findAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .mapToInt(employee -> employee.getSalary())
                .average()
                .orElse(0D);
    }

    public Employee findMinSalaryEmployeeFromDepartment(int department) {
        return employeeService.findAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min((employee1, employee2) -> employee1.getSalary() - employee2.getSalary())
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee findMaxSalaryEmployeeFromDepartment(int department) {
        return employeeService.findAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max((employee1, employee2) -> employee1.getSalary() - employee2.getSalary())
                .orElseThrow(EmployeeNotFoundException::new);
    }


    public int calculateAllSalariesForDepartment(int department) {
        return employeeService.findAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .mapToInt(Employee::getSalary)
                .sum();
    }

    public void printAllEmployeesFromDepartment(int department) {
        employeeService.findAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .forEach(employee -> System.out.printf(
                        "Имя, Фамилия:%s %s, ЗП: %d%n",
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getSalary()
                ));
    }*/

}



