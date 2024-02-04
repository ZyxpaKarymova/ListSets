package pro.sky.ListsSets.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import pro.sky.ListsSets.exceptions.EmployeeAlreadyAddedException;
import pro.sky.ListsSets.exceptions.EmployeeNotFoundException;
import pro.sky.ListsSets.exceptions.EmployeeStorageFullException;
import pro.sky.ListsSets.model.Employee;

import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeeService {
    private static final int AMOUNT = 5;
    private final List<Employee> employees = new ArrayList();



    public Employee addEmployee(@RequestParam() String firstName, @RequestParam() String lastName) {
        if (employees.size() >= AMOUNT) {
            throw new EmployeeStorageFullException();
        }
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee target = new Employee(firstName, lastName);
        if (!employees.remove(target)) {
            throw new EmployeeNotFoundException();
        }

        return target;
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee target = new Employee(firstName, lastName);
        int targetIndex = employees.indexOf(target);
        if (targetIndex < 0) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(targetIndex);
    }




}
