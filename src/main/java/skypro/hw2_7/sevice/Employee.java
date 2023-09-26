package skypro.hw2_7.sevice;

import java.util.Objects;

public class Employee {
    private String name;
    private String surname;
    private int department;


    public Employee(String name, String surname, int department) {
        this.name = name;
        this.surname = surname;
        this.department = department;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public int getDepartment() {
        return this.department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, department);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", department=" + department +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Employee employee = (Employee) obj; // Приводим obj к типу моего класса
        // Теперь сравниваем поля объектов
        return this.name.equals(employee.name) && this.surname.equals(employee.surname) &&
                this.department == employee.department;
    }
}

