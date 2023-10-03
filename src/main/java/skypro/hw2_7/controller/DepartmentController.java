package skypro.hw2_7.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import skypro.hw2_7.sevice.DepartmentService;
import skypro.hw2_7.sevice.Employee;

import java.util.Collection;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/min-salary")
    public Employee minSalary(@RequestParam int departmentID) {
        return departmentService.findMinSalaryByDepartment(departmentID);
    }

    @GetMapping(path = "/max-salary")
    public Employee maxSalary(@RequestParam int departmentID) {
        return departmentService.findMaxSalaryByDepartment(departmentID);
    }

    @GetMapping(path = "/sum-salary")
    public int sumSalaryByDepartment(@RequestParam int departmentID) {
        return departmentService.getTotalSalaryCostByDepartment(departmentID);
    }

    @GetMapping(path = "/all")
    public Collection<Employee> getAllEmployeesByDepartment(@RequestParam int departmentID) {
        return departmentService.getAllEmployeesByDepartment(departmentID);
    }

   @GetMapping()
    public Collection<Employee> getAllEmployee() {
        return departmentService.getAllEmployees();
    }
}
