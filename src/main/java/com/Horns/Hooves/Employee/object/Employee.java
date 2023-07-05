package com.Horns.Hooves.Employee.object;
import java.util.Objects;

public class Employee {
    private final String name;
    private final String surname;
    public int salary;
    public int departmentId;

    public Employee(String name,String surname){
        this.name = name;
        this.surname = surname;
    }
    public Employee(String name,String surname,int salary,int departmentId) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.departmentId=departmentId;


    }
    public String getName() {
        return name;
    }
    public String getSurname() {return surname;}
    public int getSalary() {
        return salary;
    }
    public int getDepartmentId(){return departmentId;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname) && Objects.equals(departmentId, employee.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, salary, departmentId);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", departmentIds=" + departmentId +
                '}';
    }
}


