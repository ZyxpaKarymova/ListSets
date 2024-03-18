package pro.sky.ListsSets.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import pro.sky.ListsSets.exceptions.EmployeeAlreadyAddedException;
import pro.sky.ListsSets.exceptions.EmployeeNotFoundException;
import pro.sky.ListsSets.exceptions.EmployeeStorageFullException;
import pro.sky.ListsSets.model.Employee;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@Service
public class EmployeeService {
    public static final int AMOUNT = 10;
    private final Map<String, Employee> employees = new HashMap<>();

    public Employee addEmployee(@RequestParam() String firstName,
                                @RequestParam() String lastName,
                                @RequestParam() int salary,
                                @RequestParam() int department) {
        if (employees.size() >= AMOUNT) {
            throw new EmployeeStorageFullException();
        }
        String key = getKey(firstName, lastName);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        Employee employee = new Employee(firstName, lastName, salary, department);
        employees.put(key, employee);
        return employee;
    }

    public Employee removeEmployee(String firstName, String lastName) {

        Employee employee = employees.remove(getKey(firstName, lastName));
        if (employee == null) {
            throw new EmployeeNotFoundException();
        }

        return employee;
    }

    public Employee findEmployee(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        Employee employee = employees.get(key);
        if (employee == null) {
            throw new EmployeeNotFoundException();
        }

        return employee;
    }


    public Collection<Employee>getEmployees(){
        return employees.values();
    }
    private String getKey(String firstName, String lastName) {
        return firstName + lastName;
    }

    public Collection<Employee> findAll(){
        return Collections.unmodifiableCollection(employees.values());
    }


}
