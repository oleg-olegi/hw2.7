package skypro.hw2_7.sevice;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import skypro.hw2_7.exceptions.EmployeeAlreadyAddedException;
import skypro.hw2_7.exceptions.EmployeeNotFoundException;
import skypro.hw2_7.exceptions.MaximumEmployeesException;
import skypro.hw2_7.exceptions.NotValidCharacterException;


import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employeeMap;
    private static final int MAX_EMPLOYEES = 10;

    public EmployeeServiceImpl() {
        this.employeeMap = new HashMap<>();
    }

    @Override
    public Collection<Employee> getEmployeeMap() {
        return this.employeeMap.values();
    }

    @Override
    public Employee addEmployee(String name, String surname, int salary, int department) {
        isCorrectInput(name, surname);
        Employee employee = new Employee(name, surname, salary, department);
        if (!employeeMap.containsKey(employee.getName() + employee.getSurname())) {
            employeeMap.put(employee.getName() + employee.getSurname(), employee);
            return employee;
        } else if (employeeMap.size() > MAX_EMPLOYEES) {
            throw new MaximumEmployeesException("Максимальное количество сотрудников");
        }
        throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует");
    }

    @Override
    public Employee removeEmployee(String name, String surname) {
        isCorrectInput(name, surname);
        if (employeeMap.containsKey(name + surname)) {
            employeeMap.remove(name + surname);
            return new Employee(name, surname);
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public Employee findEmployee(String name, String surname) {
        isCorrectInput(name, surname);
        if (!employeeMap.containsKey(name + surname)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return new Employee(name, surname);
    }

    private void isCorrectInput(String name, String surname) { //почему когда случается ошибка со статусом 400 в
                                                                // консоли среды разработки нет моего сообщения,
                                                                // которое я указал в параметрах исключения
        if (!StringUtils.isAlpha(name + surname)) {
            throw new NotValidCharacterException("Недопустимые символы в имени или фамилии");
        }
    }
}
