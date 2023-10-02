package skypro.hw2_7.sevice;

import org.springframework.stereotype.Service;
import skypro.hw2_7.exceptions.EmployeeAlreadyAdded;
import skypro.hw2_7.exceptions.EmployeeNotFoundException;


import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employeeMap;
    private static final int MAX_EMPLOYEES = 3;

    public EmployeeServiceImpl() {
        this.employeeMap = new HashMap<>();
    }

    @Override
    public Collection getEmployeeMap() {
        return Collections.unmodifiableCollection(this.employeeMap.values());
    }

    @Override
    public Employee addEmployee(String name, String surname, int department) {
        Employee employee = new Employee(name, surname, department);
        if (!employeeMap.containsKey(employee.getName() + employee.getSurname())) {
            employeeMap.put(employee.getName() + employee.getSurname(), employee);
            return employee;
        }
        throw new EmployeeAlreadyAdded("Такой сотрудник уже существует");
    }


    @Override
    public Employee removeEmployee(String name, String surname) {
        if (employeeMap.containsKey(name + surname)) {
            employeeMap.remove(name + surname);
            return new Employee(name, surname);
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }


    @Override
    public Employee findEmployee(String name, String surname) {
        if (!employeeMap.containsKey(name + surname)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return new Employee(name, surname);
    }

    @Override
    public String printAllDepartmentsAndNames() {
        Iterator<Map.Entry<String, Employee>> iterator = employeeMap.entrySet().iterator();
        List<String> listOfDepartmentsAndNames = new ArrayList<>();
        String string = "";
        while (iterator.hasNext()) {
            Map.Entry<String, Employee> iteratorEntry = iterator.next();
            string = "Отдел - " + iteratorEntry.getValue().getDepartment() + " " +
                    iteratorEntry.getValue().getName() + " " +
                    iteratorEntry.getValue().getSurname();
            listOfDepartmentsAndNames.add(string);
        }
        return listOfDepartmentsAndNames.toString();
    }

}
