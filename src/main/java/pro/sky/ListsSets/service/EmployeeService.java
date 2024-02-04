package pro.sky.ListsSets.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import pro.sky.ListsSets.exceptions.EmployeeAlreadyAddedException;
import pro.sky.ListsSets.exceptions.EmployeeNotFoundException;
import pro.sky.ListsSets.exceptions.EmployeeStorageFullException;
import pro.sky.ListsSets.model.Employee;


@Service
public class EmployeeService {
    private static final int AMOUNT = 5;
    private final Employee[] employees = new Employee[AMOUNT];
    private int addedEmloyees = 0;


    public Employee addEmployee(@RequestParam() String firstName, @RequestParam() String lastName) {
        if (addedEmloyees >= AMOUNT) {throw new EmployeeStorageFullException();}
        Employee employee = new Employee(firstName, lastName);
        if (findEmployee(employee) >= 0) {
            throw new EmployeeAlreadyAddedException();
        }
        employees[addedEmloyees] = employee;
        addedEmloyees++;
        return employee;
    }


    public Employee removeEmployee(String firstName, String lastName) {
        Employee target = new Employee(firstName, lastName);
        int targetIndex = findEmployee(target);
        if (targetIndex < 0) {
            throw new EmployeeNotFoundException();
        }
        /*for (int i = 0; i < addedEmloyees; i++) {
            if (employees[i] != null && (employees[i].equals(target))) {
                targetIndex = i;
                break;
            }
        }*/
        if (targetIndex < 0) {
            throw new EmployeeNotFoundException();
        }
        employees[targetIndex] = null;
        if (targetIndex != employees.length - 1)
            System.arraycopy(employees, targetIndex + 1, employees, targetIndex, employees.length - targetIndex - 1);
        addedEmloyees--;
        return target;
    }


    public Employee findEmployee(String firstName, String lastName) {
        Employee target = new Employee(firstName, lastName);
        int targetIndex = findEmployee(target);
        if (targetIndex < 0) {
            throw new EmployeeNotFoundException();
        }
        return target;
    }

    private int findEmployee(Employee target) {
        int targetIndex = -1;
        int lastElementIndex = Math.min(addedEmloyees, employees.length - 1);
        for (int i = 0; i < lastElementIndex; i++) {
            if (employees[i] != null && employees[i].equals(target)) {
                targetIndex = i;
            }
        }
        return targetIndex;
    }


}
