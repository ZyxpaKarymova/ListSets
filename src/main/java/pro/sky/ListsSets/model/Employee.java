package pro.sky.ListsSets.model;

import java.util.Objects;

public class Employee {
    private String firstName;

    private String lastName;
    private int salary;

    private int department;

    public Employee(String firstName, String lastName, int salary, int department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int hashCode() {
        return Objects.hash(firstName,lastName);
    }
@Override
    public boolean equals(Object object) {
        if (this==object) return true;
        if ((object==null) ||getClass()!=object.getClass()) return false;
        Employee employee=(Employee) object;
        return Objects.equals(firstName, employee.firstName)&&Objects.equals(lastName, employee.lastName);
            }

    public String toString() {
        return "Имя: " + this.firstName + ", Фамилия: " + this.lastName;
    }

}
