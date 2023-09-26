package skypro.hw2_7.sevice;

import org.springframework.stereotype.Service;
import skypro.hw2_7.excetions.EmployeeAlreadyAdded;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private Map<String, Employee> employeeMap;
    private static final int MAX_EMPLOYEES = 3;

    public EmployeeServiceImpl() {
        this.employeeMap = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String name, String surname, int department) {
        Employee employee = new Employee(name, surname, department);
        if (!employeeMap.containsKey(employee.getName() + employee.getSurname())) {
            employeeMap.put(employee.getName() + employee.getSurname(), employee);
        } else {
            throw new EmployeeAlreadyAdded("Такой сотрудник уже существует");
        }
        return employee;
    }

    @Override
    public Employee removeEmployee(String name, String surname) {
        return null;
    }

    @Override
    public Employee findEmployee(String name, String surname) {
        return null;
    }

    @Override
    public void printAllDepartmentsAndNames() {

    }
}