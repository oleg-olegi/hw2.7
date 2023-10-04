package skypro.hw2_7.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeServiceImpl employeeServiceImpl;

    @Autowired
    public DepartmentServiceImpl(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @Override
    public Employee findMinSalaryByDepartment(int numberOfDepartment) {
        return employeeServiceImpl.getEmployeeMap().stream()
                .filter(a -> a.getDepartment() == numberOfDepartment)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new NoSuchElementException("Employee not found"));
    }

    @Override
    public Employee findMaxSalaryByDepartment(int numberOfDepartment) {
        return employeeServiceImpl.getEmployeeMap().stream()
                .filter(a -> a.getDepartment() == numberOfDepartment)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new NoSuchElementException("Employee not found"));
    }

    @Override
    public int getTotalSalaryCostByDepartment(int department) {
        return employeeServiceImpl.getEmployeeMap().stream()
                .filter(a -> a.getDepartment() == department)
                .mapToInt(Employee::getSalary)
                .sum();
    }

    @Override
    public Collection<Employee> getAllEmployeesByDepartment(int department) {
        return employeeServiceImpl.getEmployeeMap().stream()
                .filter(a -> a.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        //тут объект Map<Integer,List<Employee>>
        Map<Integer, List<Employee>> sortedEmployeesByDepartments =
                employeeServiceImpl.getEmployeeMap().stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment));
        List<Employee> allEmployees = new ArrayList<>();
        sortedEmployeesByDepartments.entrySet().forEach(e -> allEmployees.addAll(e.getValue()));
        return allEmployees;
    }
}