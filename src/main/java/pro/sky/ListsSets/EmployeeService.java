package pro.sky.ListsSets;

import pro.sky.ListsSets.EmployeeStorageFullException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import pro.sky.ListsSets.Employee;


@Service
public class EmployeeService {
    private static final int AMOUNT = 5;
    private final Employee[] employees = new Employee[AMOUNT];
    private int addedEmloyees = 0;


    public Employee addEmployee(@RequestParam() String firstName, @RequestParam() String lastName) {
        if (addedEmloyees >= AMOUNT) {throw new EmployeeStorageFullException();}
        Employee employee = new Employee(firstName, lastName);
        employees[addedEmloyees] = employee;
        addedEmloyees++;
        return employee;
    }


    public Employee removeEmployee(String firstName, String lastName) {
        Employee target = new Employee(firstName, lastName);
        int targetIndex = -1;
        for (int i = 0; i < addedEmloyees; i++) {
            if (employees[i] != null && (employees[i].equals(target))) {
                targetIndex = i;
                break;
            }

        }
        if (targetIndex < 0) {

        }
        employees[targetIndex] = null;
        if (targetIndex != employees.length - 1)
            System.arraycopy(employees, targetIndex + 1, employees, targetIndex, employees.length - targetIndex);
        addedEmloyees--;
        return target;
    }


    public Employee findEmployee(String firstName, String lastName) {
        Employee target = new Employee(firstName, lastName);
        int targetIndex = findEmployee(target);
        if (targetIndex < 0) {
        }
        return target;
    }

    private int findEmployee(Employee target) {
        int targetIndex = -1;
        for (int i = 0; i < addedEmloyees; i++) {
            if (employees[i] != null && employees[i].equals(target)) {
                targetIndex = i;
            }
        }
        return targetIndex;
    }
}
