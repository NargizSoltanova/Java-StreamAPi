package entities;

import java.util.UUID;

public class Employee {
    private final String id;
    private final String fullName;
    private final Double salary;

    public Employee(String fullName, Double salary) {
        this.id = UUID.randomUUID().toString();
        this.fullName = fullName;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public Double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", salary=" + salary +
                '}';
    }

}
