package skypro.hw2_7.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import skypro.hw2_7.sevice.Employee;
import skypro.hw2_7.sevice.EmployeeService;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/employee")
public class Controller {
    private final EmployeeService employeeService;

    public Controller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String name, @RequestParam String surname, @RequestParam int salary,
                                @RequestParam int department) {
        return employeeService.addEmployee(name, surname, salary, department);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String name, @RequestParam String surname) {
        return employeeService.removeEmployee(name, surname);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String name, @RequestParam String surname) {
        return employeeService.findEmployee(name, surname);
    }

   /* @GetMapping("/departments")
    public String printDepartmentsAndNames() {
        return employeeService.printAllDepartmentsAndNames();
    }*/

    @GetMapping()
    public Collection showEmployee() {
        return employeeService.getEmployeeMap();
    }
}