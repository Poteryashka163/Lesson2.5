package service;

public interface EmployeeServiceInterf {

    // Добавление сотрудника
    String addEmployee(String name, String surname, int salary, int departmentId);

    // Удаление сотрудника
   String delEmployee(String name, String surname);

    // Поиск сотрудника
    String findEmployee(String name, String surname);
}
