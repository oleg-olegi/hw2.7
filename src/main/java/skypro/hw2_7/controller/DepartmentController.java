package skypro.hw2_7.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import skypro.hw2_7.sevice.DepartmentService;
import skypro.hw2_7.sevice.Employee;

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
}
