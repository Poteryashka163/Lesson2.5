package com.Horns.Hooves.Employee;

import java.util.Objects;

public class Employee {
    private String name;
    private String surname;
    private int id;
    private int salary;
    private String department;

    public Employee(String name, int id, int salary, String department,String surname) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.department = department;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {return surname;}

    public int getId() {
        return id;
    }

    public int getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Employee)) {
            return false;
        }
        Employee emp = (Employee) obj;
        return emp.id == id && emp.name.equals(name);
    }


    @Override
    public int hashCode() {
        return 31 * name.hashCode() + id;
    }




    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}

