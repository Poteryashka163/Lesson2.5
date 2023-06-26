package com.Horns.Hooves.Employee;

import java.util.Objects;

public class Employee {
    public String department;
    public int salary;
    private String name;
    private String surname;
    public int id;


    public Employee(String name,String surname,String department,int salary,int id) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
        this.id=id;


    }
    public String getName() {
        return name;
    }
    public String getSurname() {return surname;}
    public String getDepartment() {
        return department;
    }
    public int getSalary() {
        return salary;
    }
    public int getId(){return id;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && id == employee.id && Objects.equals(department, employee.department) && Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(department, salary, name, surname, id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "department='" + department + '\'' +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                '}';
    }
}


