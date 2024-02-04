package pro.sky.ListsSets;

import java.util.Objects;

public class Employee {
    private String firstName;

    private String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public int hashCode() {
        return Objects.hash(firstName,lastName);
    }

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
