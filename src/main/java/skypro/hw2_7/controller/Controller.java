package skypro.hw2_7.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import skypro.hw2_7.sevice.Employee;
import skypro.hw2_7.sevice.EmployeeService;

@RestController
@RequestMapping("/employee")
public class Controller {
    private final EmployeeService employeeService;

    public Controller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String name, @RequestParam String surname,
                                @RequestParam int department) {
        return employeeService.addEmployee(name, surname, department);
    }
}
